package com.fscsp.csp.advice;

import com.fscsp.csp.exceptions.CompaniesExceptions;

import com.fscsp.csp.exceptions.CouponsExceptions;
import com.fscsp.csp.exceptions.CustomException;
import com.fscsp.csp.exceptions.CustomersExceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ControllerAdvice
@RestController

public class ControllerAdviceAll {
    @ExceptionHandler(value = {CompaniesExceptions.class, CouponsExceptions.class, CustomersExceptions.class, CustomException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDetails exceptionHandler(Exception e){
        return new ErrorDetails("BAD_REQUEST!!!",e.getMessage());
    }

}
