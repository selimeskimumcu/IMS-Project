package Phase_3.Project.src.project;

public class OrderDetails {
    private int orderDetailId;
    private int orderId;
    private int productId;
    private int quantity;
    private int subtotal;

    public OrderDetails(int orderDetailId, int orderId, int productId, int quantity, int subtotal) {
        this.orderDetailId = orderDetailId;
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.subtotal = subtotal;
    }

    public void addOrderDetails(int quantity, int productPrice) {
        this.quantity += quantity;
        this.subtotal = this.quantity * productPrice;
    }

    public void updateQuantity(int quantity) {
        this.quantity = quantity;
    }

}
