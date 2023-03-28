package com.io.gift.controller.config;

import com.io.gift.exception.NoContentToShowException;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> entityNotFoundHandler(EntityNotFoundException exception) {
        log.error(exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> entityNotFoundHandler(MethodArgumentNotValidException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @ExceptionHandler(EntityExistsException.class)
    public ResponseEntity<String> entityExistsHandler(EntityExistsException exception) {
        log.error(exception.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());
    }

    @ExceptionHandler(NoContentToShowException.class)
    public ResponseEntity<String> noContentToShowHandler(NoContentToShowException exception) {
        log.error(exception.getMessage());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(exception.getMessage());
    }

}
