package id.putra.peoplelibrarysystem.exception;

public class UsernameException extends Exception {
    public UsernameException(String message, Throwable cause) {
        super(message, cause);
    }

    public UsernameException(String message) {
        super(message);
    }
}
