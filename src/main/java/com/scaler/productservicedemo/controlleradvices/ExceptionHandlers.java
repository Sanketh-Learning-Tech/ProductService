package com.scaler.productservicedemo.controlleradvices;

import com.scaler.productservicedemo.dto.ExceptionDto;
import com.scaler.productservicedemo.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class  ExceptionHandlers {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionDto> handleException(ProductNotFoundException exception) {

        ExceptionDto exceptionDto = new ExceptionDto();

        exceptionDto.setMessage(exception.getMessage());
        exceptionDto.setDetails("Check the product id. It probably does not exist.");

        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
    }
}
