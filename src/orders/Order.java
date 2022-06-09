package orders;

import exceptions.OrderIdNotFoundException;
import exceptions.OrderNameNotFoundException;

import java.time.LocalDate;
import java.util.List;

public class Order {
    int id;
    private String orderName;
    private String creator;
    private int orderItems;
    private LocalDate creationDate;

    /**
     * Empty Constructor
     */
    public Order() {
    }
    public int getId() {
        return id;
    }
    public String getOrderName() {
        return orderName;
    }
    public int getOrderItems() {
        return orderItems;
    }

    /**
     * Parameterized Constructor
     *
     * @param id
     * @param orderName
     * @param creator
     * @param itemsCount
     */
    public Order(int id, String orderName, String creator, int itemsCount) {
        this.id = id;
        this.orderName = orderName;
        this.creator = creator;
        this.orderItems = itemsCount;
        this.creationDate = LocalDate.now();
    }

    /**
     * Step: On some methods in class Order (method X) mark that they will
     * throw that custom exception (in the method signature)
     * Search Order by Name
     *
     * @param orderName      String
     * @param orderGenerator OrderGenerator
     * @throws OrderNameNotFoundException when the name of the order can NOT be found
     */

    public Order findOrderByName(String orderName, OrderGenerator orderGenerator) throws OrderNameNotFoundException {
        List<Order> orders = orderGenerator.getOrders();
        boolean isExist = false;
        Order testOrder = null;

        for (Order order : orders) {
            if (order.getOrderName().equals(orderName)) {
                isExist = true;
                testOrder = order;
                break;
            }
        }
        if (isExist) {
            return testOrder;
        } else {
            // Explicitly throw an exception
            throw new OrderNameNotFoundException("Could not find order with name: " + orderName);
        }
    }

    /**
     * Search Order by Id
     *
     * @param id             int
     * @param orderGenerator OrderGenerator
     * @throws OrderIdNotFoundException when the Id of the order can NOT be found
     */
    public Order findOrderById(int id, OrderGenerator orderGenerator) throws OrderIdNotFoundException {
        List<Order> orders = orderGenerator.getOrders();
        boolean isExist = false;
        Order testOrder = null;

        for (Order order : orders) {
            if (order.getId() == id) {
                isExist = true;
                testOrder = order;
                break;
            }
        }
        if (isExist) {
            return testOrder;
        } else {
            // Explicitly throw an exception
            throw new OrderIdNotFoundException("Could not find order with ID: " + id);
        }
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderName='" + orderName + '\'' +
                ", creator='" + creator + '\'' +
                ", orderItems=" + orderItems +
                ", creationDate=" + creationDate +
                '}';
    }
}
