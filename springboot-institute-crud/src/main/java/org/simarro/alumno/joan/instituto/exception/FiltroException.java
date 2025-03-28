package org.simarro.alumno.joan.instituto.exception;

import lombok.Getter;

@Getter
public class FiltroException extends Exception {

    private static final long serialVersionUID = 1L;
    private final String errorCode;
    private final String message;
    private final String detailedMessage;

    public FiltroException(String errorCode, String message, String detailedMessage) {
        super(message);
        this.errorCode = errorCode;
        this.message = message;
        this.detailedMessage = detailedMessage;
    }
}
