package Phase_3.Project.src.project;
import java.util.Date;

public class Order {
    private int orderId;
    private int customerId;
    private Date orderDate;
    private int totalAmount;

    public Order(int orderId, int customerId, Date orderDate, int totalAmount) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
    }

    public void placeOrder() {
        System.out.println("The order was placed successfully.");
    }

    public void cancelOrder() {
        System.out.println("The order has been canceled.");
    }

}
