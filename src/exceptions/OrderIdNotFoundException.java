package exceptions;

public class OrderIdNotFoundException extends Throwable {
    public OrderIdNotFoundException(String message) {
        super(message);
    }
}
