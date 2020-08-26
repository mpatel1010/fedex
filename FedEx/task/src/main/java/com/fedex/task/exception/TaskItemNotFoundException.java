package com.fedex.task.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TaskItemNotFoundException extends RuntimeException {

    public TaskItemNotFoundException(String message) {
        super(message);
    }
}
