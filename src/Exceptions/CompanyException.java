package Exceptions;

public class CompanyException extends Exception{

    public CompanyException() {
    }

    public CompanyException(String message) {
        super(message);
    }

    public CompanyException(String message, Throwable cause) {
        super(message, cause);
    }

    public CompanyException(Throwable cause) {
        super(cause);
    }

    public CompanyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
