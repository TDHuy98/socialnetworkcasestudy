package com.socialnetworkcasestudy.controller;

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
@CrossOrigin(origins = "*")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<SignUpDto> signUp(@RequestBody SignUpDto signUpDto) throws UserAlreadyExistException {
        try {
            if (
//            authService.getAll().stream().noneMatch(user -> Objects.equals(user.getUsername(), signUpDto.getUsername())
//                    || Objects.equals(user.getEmail(), signUpDto.getEmail())
//                    || Objects.equals(user.getMobile(), signUpDto.getMobile()))
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
}
