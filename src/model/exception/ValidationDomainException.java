package model.exception;

public class ValidationDomainException extends RuntimeException{

    public ValidationDomainException(String message) {
        super(message);
    }
}
