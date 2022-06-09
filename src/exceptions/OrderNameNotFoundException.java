package exceptions;
 //Create custom checked exception class
public class OrderNameNotFoundException extends OrderException{
    public OrderNameNotFoundException(String message) {
        super(message);
    }
}
