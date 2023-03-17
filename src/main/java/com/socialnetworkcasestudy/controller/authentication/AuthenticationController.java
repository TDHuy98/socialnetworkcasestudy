package com.socialnetworkcasestudy.controller.authentication;

import com.socialnetworkcasestudy.dto.UserDto;
import com.socialnetworkcasestudy.dto.authentication.AuthenticationRequest;
import com.socialnetworkcasestudy.dto.authentication.AuthenticationResponse;
import com.socialnetworkcasestudy.dto.authentication.RegisterRequest;
import com.socialnetworkcasestudy.model.User;
import com.socialnetworkcasestudy.repository.UserRepository;
import com.socialnetworkcasestudy.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin(allowedHeaders = "*")
public class AuthenticationController {
    @Autowired
    private AuthService service;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
        return new ResponseEntity<>(service.register(request), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(service.authenticate(request));
    }

    @GetMapping("/getCurrentUser")
    public ResponseEntity<UserDto> getCurrentUserLoggedIn() {
        UserDto loggedInUser = service.getCurrentUser().orElseThrow(() -> new IllegalArgumentException("User Not Found"));
        return ResponseEntity.ok(loggedInUser);
    }
    @GetMapping("/getUser/{id}")
    public UserDto getUser(@PathVariable Long id) {
        UserDto currentUser=service.getUserById(id);
        return currentUser;
    }
}
