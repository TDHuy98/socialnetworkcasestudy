package com.socialnetworkcasestudy.exception;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExeptionHandler {
    @ExceptionHandler({ WrongLogginInformationException.class,  })  // Có thể bắt nhiều loại exception
    public ResponseEntity<String> handleWrongLogginInformationException(Exception e) {
        return ResponseEntity.status(409).body(e.getMessage());
    }

    @ExceptionHandler({ResourceAlreadyExistException.class,})  // Có thể bắt nhiều loại exception
    public ResponseEntity<String> handleResourceAlreadyExistException(Exception e) {
        return ResponseEntity.status(409).body(e.getMessage());
    }

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<String> handleResourceNotFoundException(Exception e){
        return ResponseEntity.status(404).body(e.getMessage());
    }
}
