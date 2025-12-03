package Phase_3.Project.src.project;

public class Product {
    private int productId;
    private String name;
    private String category;
    private int price;
    private int stockQuantity;

    public Product(int productId, String name, String category, int price, int stockQuantity) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public void addStock(int quantity) {
        this.stockQuantity += quantity;
    }

    public void removeStock(int quantity) {
        if (this.stockQuantity >= quantity) {
            this.stockQuantity -= quantity;
        } else {
            System.out.println("insufficient stock!");
        }
    }

    public void updateDetails(String name, String category, int price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

}
