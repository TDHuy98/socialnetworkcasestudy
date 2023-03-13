package com.socialnetworkcasestudy.service.impl.authentication;

import com.socialnetworkcasestudy.config.JwtService;
import com.socialnetworkcasestudy.dto.authentication.AuthenticationRequest;
import com.socialnetworkcasestudy.dto.authentication.AuthenticationResponse;
import com.socialnetworkcasestudy.dto.authentication.RegisterRequest;
import com.socialnetworkcasestudy.exception.ResourceAlreadyExistException;
import com.socialnetworkcasestudy.model.Role;
import com.socialnetworkcasestudy.model.User;
import com.socialnetworkcasestudy.repository.UserRepository;
import com.socialnetworkcasestudy.model.token.Token;
import com.socialnetworkcasestudy.repository.TokenRepository;
import com.socialnetworkcasestudy.model.token.TokenType;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
public class AuthenticationService {
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

    public AuthenticationResponse register(RegisterRequest request) {
        if (checkUsernameExisted(request) && checkEmailExisted(request) && checkMobileExisted(request)) {
            throw new ResourceAlreadyExistException("These mobile, email and username have already registed");
        } else if (checkEmailExisted(request)) {
            throw new ResourceAlreadyExistException("This email has already registed");
        } else if (checkMobileExisted(request)) {
            throw new ResourceAlreadyExistException("This mobile has already registed");
        } else if (checkUsernameExisted(request)) {
            throw new ResourceAlreadyExistException("This username has already registed");
        }
        var user = User.builder()
                .firstName(request.getFirstname())
                .middleName(request.getMiddlename())
                .lastName(request.getLastname())
                .username(request.getUsername())
                .email(request.getEmail())
                .mobile(request.getMobile())
                .password(passwordEncoder.encode(request.getPassword()))
                .dateOfBirth(request.getDateOfBirth())
                .role(Role.USER)
                .build();
        user.setCreatedAt(Instant.now());
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        var user = userRepository.findUserByUsername(request.getUsername())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        revokeAllUserTokens(user);
        saveUserToken(user, jwtToken);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    private void saveUserToken(User user, String jwtToken) {
        var token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);
    }

    private void revokeAllUserTokens(User user) {
        var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
        if (validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
    }

    public Optional<UserDetails> getCurrentUser() {
        UserDetails principal = (UserDetails) SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();
        return Optional.of(principal);
    }
    private boolean checkEmailExisted(RegisterRequest request) {
        return userRepository.findUserByEmail(request.getEmail()).isPresent();
    }

    private boolean checkMobileExisted(RegisterRequest request) {
        return userRepository.findUserByMobile(request.getMobile()).isPresent();
    }

    private boolean checkUsernameExisted(RegisterRequest request) {
        return userRepository.findUserByUsername(request.getUsername()).isPresent();
    }


}
