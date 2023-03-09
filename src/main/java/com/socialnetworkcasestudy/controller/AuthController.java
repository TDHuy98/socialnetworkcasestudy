package com.socialnetworkcasestudy.controller;

import com.socialnetworkcasestudy.dto.LoginRequest;
import com.socialnetworkcasestudy.dto.SignUpDto;
import com.socialnetworkcasestudy.exception.UserAlreadyExistException;
import com.socialnetworkcasestudy.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {
    @Autowired
    private AuthService authService;
//    @Autowired
//    private AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<SignUpDto> signUp(@RequestBody SignUpDto signUpDto) throws UserAlreadyExistException {
        try {
            if (
                    authService.getAll().stream()
                            .filter(user -> Objects.equals(user.getEmail(), signUpDto.getEmail()))
                            .filter(user -> Objects.equals(user.getUsername(), signUpDto.getUsername()))
                            .noneMatch(user -> Objects.equals(user.getMobile(), signUpDto.getMobile()))
            ) {
                return new ResponseEntity<>(authService.signUp(signUpDto), HttpStatus.CREATED);
            }
        } catch (RuntimeException UserAlreadyExistException) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return null;
    }

//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
//        return new ResponseEntity<>(authService.login(loginRequest), HttpStatus.OK);
//    }


//    @PostMapping("/register")
//    public ResponseEntity<AuthenticationResponse> register(
//            @RequestBody RegisterRequest request
//    ) {
//        return ResponseEntity.ok(authenticationService.register(request));
//    }

//    @PostMapping("/authenticate")
//    public ResponseEntity<AuthenticationResponse> register(
//            @RequestBody AuthenticationRequest request
//    ) {
//
//    }
}
