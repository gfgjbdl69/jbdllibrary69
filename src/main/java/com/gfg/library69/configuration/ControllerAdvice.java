package com.gfg.library69.configuration;

import com.gfg.library69.exception.UserAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<?> handleNullPointerException(NullPointerException e){

        return new ResponseEntity<>("something went wrong, please try again", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){

        Map<String,String> errorsMap=new HashMap<>();
        for(FieldError error:e.getBindingResult().getFieldErrors()){
            errorsMap.put(error.getField(),error.getDefaultMessage());

        }
        return new ResponseEntity<>(errorsMap, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<?> handleUserAlreadyExistsException(UserAlreadyExistsException e){
        Map<String,String> errorsMap=new HashMap<>();
        errorsMap.put("message",e.getMessage());
        return new ResponseEntity<>(errorsMap,HttpStatus.BAD_REQUEST);
    }

}
