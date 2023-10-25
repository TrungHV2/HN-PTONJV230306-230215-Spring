package com.ra.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.PriorityOrdered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@ControllerAdvice
@Order(value = PriorityOrdered.HIGHEST_PRECEDENCE)
public class CommonHandlerException {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommonHandlerException.class);

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<Object> handlerException(Throwable ex, HttpServletRequest request) {
        HttpHeaders headers = new HttpHeaders();
        LOGGER.error("===Process with error: {}", ex.getMessage());
        return new ResponseEntity<>(ErrorMessage.builder()
                .code("RA-01-500")
                .message(ex.getMessage())
                .build(), headers, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
