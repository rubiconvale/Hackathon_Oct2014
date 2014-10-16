package exception;
/**
 * Copyright (c) 2014. PICS Auditing LLC. All Rights Reserved.  This file is privileged, confidential and exempt from disclosure
 * under applicable law.  If you have received this file in error, please notify PICS Auditing LLC immediately, and destroy
 * the original file and all copies thereof (including electronic media).
 */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

/**
 * @Author RNatarajan on 6/18/2014.
 * Modification Log :
 */

@ControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {
    protected final Logger log = LoggerFactory.getLogger(this.getClass());
  //  @Autowired
   // private FormatMessages formatMessages;

    @Autowired
    ApplicationContext context;


    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(HttpMediaTypeNotAcceptableException ex, HttpHeaders headers, HttpStatus status,
                                                                      WebRequest request) {
        log.debug(" type not acceptable");

        Object domain=new Object();

        return new ResponseEntity<Object>(domain, headers, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatus status,
                                                                     WebRequest request) {
        log.debug(" type not supported");

        Object domain=new Object();

        return new ResponseEntity<Object>(domain, headers,  HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers,
                                                                         HttpStatus status, WebRequest request) {
        log.debug(" type not acceptable");

        Object domain=new Object();

        return new ResponseEntity<Object>(domain, headers,  HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status,
                                                                  WebRequest request) {
        log.debug(" type not acceptable");
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        List<ObjectError> globalErrors = ex.getBindingResult().getGlobalErrors();
        List<String> errors = new ArrayList<String>(fieldErrors.size() + globalErrors.size());
        String error;
        for (FieldError fieldError : fieldErrors) {
            error = fieldError.getField() + ", " + fieldError.getDefaultMessage();
            errors.add(error);
        }
        for (ObjectError objectError : globalErrors) {
            error = objectError.getObjectName() + ", " + objectError.getDefaultMessage();
            errors.add(error);
        }

        Object domain=new Object();


        return new ResponseEntity<Object>(domain, headers,  HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }

    @Override
    protected ResponseEntity<Object> handleNoSuchRequestHandlingMethod(NoSuchRequestHandlingMethodException ex, HttpHeaders headers,
                                                                       HttpStatus status, WebRequest request) {
        log.debug(" type not acceptable");


        Object domain=new Object();


        return new ResponseEntity<Object>(domain, headers,HttpStatus.METHOD_NOT_ALLOWED);
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.debug(" type not acceptable");

        Object domain=new Object();

        return new ResponseEntity<Object>(domain, null,HttpStatus.BAD_REQUEST);
    }

    /*
     * Catch App server runtime exceptions
     */
    @ExceptionHandler({ Exception.class })
    public ResponseEntity<Object> handleCustomServiceException(Exception ex) {
        log.debug("Custom service error");

        Object domain=new Object();

        return new ResponseEntity<Object>(HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }



}
