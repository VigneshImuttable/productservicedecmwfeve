package com.project.productservicedecmwfeve.controllerAdvices;

import com.project.productservicedecmwfeve.dtos.ExceptionDto;
import com.project.productservicedecmwfeve.exceptions.ProductNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers extends Exception {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<Void> handleArithmeticException(){
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(ProductNotExistException.class)
    public ResponseEntity<ExceptionDto> handleProductDoesNotExistException(ProductNotExistException exception){
        ExceptionDto dto = new ExceptionDto();
        dto.setMessage(exception.getMessage());
        dto.setDetail("The product does not exist");
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }


}
