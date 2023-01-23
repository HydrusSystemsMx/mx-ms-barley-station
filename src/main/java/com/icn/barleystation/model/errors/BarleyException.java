package com.icn.barleystation.model.errors;

public class BarleyException extends RuntimeException {
    public BarleyException(String error, String code) {
        super(error);
    }

}
