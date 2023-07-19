package com.example.propertymanagement.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class CentralizeExceptionHandler {
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<List<ErrorModel>> BusinessExceptionHandler(BusinessException bex)
    {
        System.out.println("Business Exception occurs");
        ResponseEntity<List<ErrorModel>> response=new ResponseEntity<List<ErrorModel>>(bex.getErrors(), HttpStatus.BAD_REQUEST);
        return response;
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public void handleFieldValidation(MethodArgumentNotValidException manv )
    {
        List<FieldError> fieldErrorList=manv.getBindingResult().getFieldErrors();
        List<ErrorModel> errors=new ArrayList<>();
        ErrorModel error=null;


    }

}
