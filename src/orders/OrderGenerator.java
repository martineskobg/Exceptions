package orders;

import java.util.Arrays;
import java.util.List;

public class OrderGenerator {
    private final List<Order> orders;

    public List<Order> getOrders() {
        return orders;
    }

    public OrderGenerator() {
        this.orders = Arrays.asList(
                new Order(1, "Order1", "bachev", 0),
                new Order(2, "Order2", "petrov", 1),
                new Order(3, "Order3", "ivanov", 3),
                new Order(4, "Order4", "dimitrov", 10)
        );
    }
}
