package edu.alumno.joan.api_rest_bd_futbol.exception;

public class CiudadNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final String errorCode;

    public CiudadNotFoundException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
