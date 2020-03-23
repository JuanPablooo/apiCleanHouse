package br.com.cleanhouse.handler;


import br.com.cleanhouse.error.ResourceNotFoundDetails;
import br.com.cleanhouse.error.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundDetails (ResourceNotFoundException rfnException){
        ResourceNotFoundDetails rfnDetails =  ResourceNotFoundDetails.Builder
                .newBuilder()
                .timestamp(new Date().getTime())
                .status(HttpStatus.NOT_FOUND.value())
                .title("Recurso nao encontrado")
                .causa(rfnException.getMessage())
                .developerMessage(rfnException.getClass().getName())
                .build();
        return new ResponseEntity<>(rfnDetails, HttpStatus.NOT_FOUND);
    }

}
