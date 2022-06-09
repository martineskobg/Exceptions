import exceptions.OrderException;
import exceptions.OrderIdNotFoundException;
import exceptions.OrderNameNotFoundException;
import orders.Order;
import orders.OrderGenerator;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.List;

public class Main {
    private static final Order order = new Order();
    private static final OrderGenerator orderGenerator = new OrderGenerator();

    public static void main(String[] args) {

        // Example 1:  Control flow of try-catch
        // From another method, call X and handle the exception
//        controlFlowOfTryCatch();

        // Example 2: Control flow of try-catch-finally clause
//        flowOfTryCatchFinally();

        // Example 3: Control flow of try-with-resources
        // Implements java.lang.AutoCloseable
//        tryWithResources();

        // Example 4: Re-throwing exception - "throw", "throws"
        // From another method call X and re-throw the exception
 //       reThrowTheException();

        // Example 5:
        // Catch multiple exceptions
//        catchMultipleExceptions();

        // Example 6:
        // Step: Catch the top level exception (Throwable)
        CatchTopLevelException();
    }

    /**
     * Example 1:
     * Throw custom exception
     *
     * @throws OrderNameNotFoundException when the name of the order can NOT be found
     */
    public static void controlFlowOfTryCatch() {
        try {
            System.out.println(order.findOrderByName("Order1", orderGenerator));
        } catch (OrderNameNotFoundException e) {
            System.err.print(e);
        }
    }

    /**
     * Example 2:
     * It is using finally clause
     *
     * @throws OrderNameNotFoundException when the name of the order can NOT be found
     */
    public static void flowOfTryCatchFinally() {
        try {
            System.out.println(order.findOrderByName("Order1", orderGenerator));
        } catch (Exception e) {
            System.err.print(e);
        } finally {
            System.out.println("\nJust test the finally block!");
        }
    }

    /**
     * Example 3:
     * Control flow of  try-with-resources
     * Save all Orders in a file
     * No need to close FileWriter since  in try-with-resources you have to use implementation of java.lang.AutoCloseable
     * The file will be closed automatically
     *
     * @throws Exception when the path is wrong
     */
    public static void tryWithResources() {
        try (FileWriter writer = new FileWriter("src/resources/orders.txt")) {
            List<Order> orders = orderGenerator.getOrders();
            for (Order o : orders) {
                writer.write(o + System.lineSeparator());
            }
            System.out.println("Data written successfully!");
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    //

    /**
     * Example 4:
     * From another method call X and re-throw the exception
     *
     * @throws OrderIdNotFoundException when the Order's Id can NOT be found
     */
    public static void reThrowTheException() {
        try {
            System.out.println(order.findOrderById(0, orderGenerator));
        } catch (OrderIdNotFoundException e) {
            System.err.println(e);
        }
    }

    /**
     * Example 5:
     * Catch multiple exceptions
     *
     * @throws OrderNameNotFoundException
     * @throws ArithmeticException
     * @throws OrderIdNotFoundException
     */
    public static void catchMultipleExceptions() {
        try {
            int orderId = order.findOrderById(1, orderGenerator).getId();
            String orderName = order.findOrderByName("Order11", orderGenerator).getOrderName();
            // TEST
            int a[] = new int[5];
            a[5] = 30 / 0;
            System.out.println("Order Id:" + orderId);
            System.out.println("Order Name:" + orderName);

        } catch (OrderNameNotFoundException e) {
            System.err.println(e);
        } catch (ArithmeticException e) {
            System.err.println("Arithmetic Exception occurs");
        } catch (OrderIdNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Example 6:
     * Step: Catch the top level exception (Throwable)
     *
     * @throws Throwable
     */
    public static void CatchTopLevelException() {
        try {
            int items = order.findOrderById(1, orderGenerator).getOrderItems();
            if (items <= 0) {
                throw new Exception("No items in the order");
            }
        } catch (Throwable throwable) {
            System.err.println(throwable);
        }
    }

}