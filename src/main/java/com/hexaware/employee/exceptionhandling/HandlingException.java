package com.hexaware.employee.exceptionhandling;

import com.hexaware.employee.dto.ErrorMessage;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandlingException {
    @ExceptionHandler(IndexOutOfBoundsException.class)
    public ResponseEntity<ErrorMessage> handleIndexOutOfBoundsException(IndexOutOfBoundsException e) {
        return new ResponseEntity<>(new ErrorMessage("Index out of bounds"), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleEntityNotFoundException(EntityNotFoundException e) {
        return new ResponseEntity<>(new ErrorMessage(e.getMessage()), HttpStatus.NOT_FOUND);
    }
}