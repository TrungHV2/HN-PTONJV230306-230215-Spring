package com.ra.shop.exception;

public class RaException extends RuntimeException{
    private ErrorMessage errorMessage;

    public RaException(String errorCode) {
        super(errorCode);
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setCode(errorCode);
        Messages mess = new Messages();
        mess.setEn("Lỗi hệ thống!");
        mess.setVn("Error internal server!");
        errorMessage.setMessages(mess);
        this.errorMessage = errorMessage;
    }

    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }
}
