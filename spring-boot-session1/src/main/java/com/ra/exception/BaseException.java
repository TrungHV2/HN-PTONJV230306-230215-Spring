package com.ra.exception;

import org.springframework.beans.factory.annotation.Autowired;

public class BaseException extends RuntimeException {
    private ErrorMessage errorMessage;
    @Autowired
    private ErrorMessagesLoader messagesLoader;

    public BaseException(String errorCode) {
        super(errorCode);
        errorMessage = new ErrorMessage();
        errorMessage.setCode(errorCode);
        errorMessage.setMessage(messagesLoader.getMessages(errorCode));
    }

    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }
}
