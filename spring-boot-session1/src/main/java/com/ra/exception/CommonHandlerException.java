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

@ControllerAdvice
@Order(value = PriorityOrdered.HIGHEST_PRECEDENCE)
public class CommonHandlerException {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommonHandlerException.class);

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<Object> handlerException(Throwable ex, HttpServletRequest request) {
        HttpHeaders headers = new HttpHeaders();
        if (ex instanceof BaseException) {
            BaseException exception = (BaseException) ex;
            return new ResponseEntity<>(exception.getErrorMessage(), headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        LOGGER.error("===Process with error: {}", ex.getMessage());
        return new ResponseEntity<>(ErrorMessage.builder()
                .code(ErrorCode.INTERNAL_SERVER_ERROR)
                .message(Messages.builder()
                        .en(ex.getMessage())
                        .build())
                .build(), headers, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
