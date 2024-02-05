package com.ArthurSilva.investAPI.InvestAPI.ExeptionHandler;

import com.ArthurSilva.investAPI.InvestAPI.Entities.StandardError;
import com.ArthurSilva.investAPI.InvestAPI.ExeptionHandler.Exeptions.ResourceNotFoundExeption;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ExeptionHandler
{
    @ExceptionHandler(ResourceNotFoundExeption.class)
    public ResponseEntity<StandardError> ResourceNotFoundHandler(ResourceNotFoundExeption e)
    {
        StandardError error = new StandardError();
        error.setTimeStamp(Instant.now());
        error.setMessage(e.getMessage());
        error.setError("Resource not found");
        error.setStatus(HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(error.getStatus()).body(error);
    }
}
