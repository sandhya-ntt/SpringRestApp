package com.keepLearning.TouristApp.Advice;

import com.keepLearning.TouristApp.exception.TouristNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class TouristControllerAdvice {

    @ExceptionHandler(TouristNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleTouristNotFoundException (TouristNotFoundException e){
        ErrorDetails errorDetails = new ErrorDetails("Not Found Exception ", e.getMessage(), LocalDateTime.now());

        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleAllException(Exception e){
        ErrorDetails errorDetails = new ErrorDetails("Internal Server Error", e.getMessage(), LocalDateTime.now());

        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
