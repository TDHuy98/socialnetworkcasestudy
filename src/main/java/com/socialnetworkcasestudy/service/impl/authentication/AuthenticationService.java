package com.socialnetworkcasestudy.service.impl.authentication;

import com.socialnetworkcasestudy.config.JwtService;
import com.socialnetworkcasestudy.dto.UserDto;
import com.socialnetworkcasestudy.dto.authentication.AuthenticationRequest;
import com.socialnetworkcasestudy.dto.authentication.AuthenticationResponse;
import com.socialnetworkcasestudy.dto.authentication.RegisterRequest;
import com.socialnetworkcasestudy.exception.ResourceAlreadyExistException;
import com.socialnetworkcasestudy.exception.WrongLogginInformationException;
import com.socialnetworkcasestudy.model.Role;
import com.socialnetworkcasestudy.model.User;
import com.socialnetworkcasestudy.model.token.Token;
import com.socialnetworkcasestudy.model.token.TokenType;
import com.socialnetworkcasestudy.repository.TokenRepository;
import com.socialnetworkcasestudy.repository.UserRepository;
import com.socialnetworkcasestudy.service.AuthService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.Instant;
import java.util.Optional;

@Service
public class AuthenticationService implements AuthService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenRepository tokenRepository;




    @Override
    public AuthenticationResponse register(RegisterRequest request) {
        if (checkUsernameExisted(request) && checkEmailExisted(request) && checkMobileExisted(request)) {
            throw new ResourceAlreadyExistException("These mobile, email and username have already registed");
        }
        if (checkEmailExisted(request)) {
            throw new ResourceAlreadyExistException("This email has already registed");
        }
        if (checkMobileExisted(request)) {
            throw new ResourceAlreadyExistException("This mobile has already registed");
        }
        if (checkUsernameExisted(request)) {
            throw new ResourceAlreadyExistException("This username has already registed");
        }
        var user = User.builder().firstName(request.getFirstname()).middleName(request.getMiddlename())
                .lastName(request.getLastname()).username(request.getUsername())
                .email(request.getEmail()).mobile(request.getMobile())
                .password(passwordEncoder.encode(request.getPassword())).dateOfBirth(request.getDateOfBirth()).role(Role.USER).build();
        user.setCreatedAt(Instant.now());
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        if (!isLoginInformationMathched(authenticationRequest)) {
            throw new WrongLogginInformationException("Username or password wrong, please try again");
        }
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        var user = userRepository.findUserByUsername(authenticationRequest.getUsername()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        revokeAllUserTokens(user);
        saveUserToken(user, jwtToken);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    @Override
    public Optional<UserDto> getCurrentUser() {
        User principal = (User) SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();
        UserDto userDto = new UserDto(principal.getId(), principal.getFirstName(), principal.getMiddleName(), principal.getLastName(), principal.getUsername()
                , principal.getEmail(), principal.getMobile(), principal.getProfile(), (Date) principal.getDateOfBirth());
        return Optional.of(userDto);
    }

    private UserDto userToUserDto(User user){
        return modelMapper.map(user, UserDto.class);
    }
    @Override
    public UserDto getUserById(Long id) {
        var userFound = userRepository.findUserById(id).get();
        return userToUserDto(userFound);
    }

    @Override
    public void saveUserToken(User user, String jwtToken) {
        var token = Token.builder().user(user).token(jwtToken).tokenType(TokenType.BEARER).expired(false).revoked(false).build();
        tokenRepository.save(token);
    }

    @Override
    public void revokeAllUserTokens(User user) {
        var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
        if (validUserTokens.isEmpty()) return;
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
    }

    @Override
    public boolean checkEmailExisted(RegisterRequest request) {
        return userRepository.findUserByEmail(request.getEmail()).isPresent();
    }

    @Override
    public boolean checkMobileExisted(RegisterRequest request) {
        return userRepository.findUserByMobile(request.getMobile()).isPresent();
    }

    @Override
    public boolean checkUsernameExisted(RegisterRequest request) {
        return userRepository.findUserByUsername(request.getUsername()).isPresent();
    }

    @Override
    public boolean isLoginInformationMathched(AuthenticationRequest authenticationRequest) {
        return userRepository.findUserByUsername(authenticationRequest.getUsername()).isPresent() && passwordEncoder.matches(authenticationRequest.getPassword(), userRepository.findUserByUsername(authenticationRequest.getUsername()).get().getPassword());
    }


}
