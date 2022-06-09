package exceptions;
// Unchecked exception
public class InvalidOrderException extends RuntimeException{
    public InvalidOrderException(String message, Throwable err) {
        super(message, err);
    }
}
