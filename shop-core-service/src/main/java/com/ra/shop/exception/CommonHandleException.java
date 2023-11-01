package com.ra.shop.exception;

import org.springframework.core.PriorityOrdered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@Order(value = PriorityOrdered.HIGHEST_PRECEDENCE)
public class CommonHandleException {
    @ExceptionHandler(Throwable.class)
    public ResponseEntity handlerException(Throwable ex, HttpServletRequest request) {
        ErrorMessage errorMessage = new ErrorMessage();
        if (ex instanceof RaException) {
            RaException raException = (RaException) ex;
            errorMessage = raException.getErrorMessage();
            return new ResponseEntity(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            errorMessage.setCode(ErrorCode.INTERNAL_SERVER);
            Messages mes = new Messages();
            mes.setEn("Internal server error!");
            mes.setVn("Lỗi hệ thống!");
            errorMessage.setMessages(mes);
            return new ResponseEntity(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
