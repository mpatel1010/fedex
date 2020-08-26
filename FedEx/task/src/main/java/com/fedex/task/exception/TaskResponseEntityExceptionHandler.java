package com.fedex.task.exception;

import java.util.Date;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class TaskResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGenericException(Exception e, WebRequest request) {
        TaskExceptionResponse taskExceptionResponse =
                new TaskExceptionResponse(new Date(), e.getMessage(), request.getDescription(false));
        ResponseEntity<Object> responseEntity =
                new ResponseEntity<Object>(taskExceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        return responseEntity;
    }

    @ExceptionHandler(TaskItemNotFoundException.class)
    public ResponseEntity<Object> handleTaskItemNotFoundException(Exception e, WebRequest request) {
        TaskExceptionResponse TaskExceptionResponse =
                new TaskExceptionResponse(new Date(), e.getMessage(), request.getDescription(false));
        ResponseEntity<Object> responseEntity =
                new ResponseEntity<Object>(TaskExceptionResponse, HttpStatus.NOT_FOUND);
        return responseEntity;
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        TaskExceptionResponse TaskExceptionResponse =
                new TaskExceptionResponse(
                        new Date(),
                        StringUtils.collectionToCommaDelimitedString(ex.getBindingResult().getAllErrors()),
                        ex.getMessage());
        ResponseEntity<Object> responseEntity =
                new ResponseEntity<>(TaskExceptionResponse, HttpStatus.BAD_REQUEST);
        return responseEntity;
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(
            TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        TaskExceptionResponse TaskExceptionResponse =
                new TaskExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
        ResponseEntity<Object> responseEntity =
                new ResponseEntity<>(TaskExceptionResponse, HttpStatus.BAD_REQUEST);
        return responseEntity;
    }
}