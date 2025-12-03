package Phase_3.Project.src.project;

public class Customer {
    private int customerId;
    private String name;
    private String email;
    private int phoneNumber;

    public Customer(int customerId, String name, String email, int phoneNumber) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public void register(String name, String email, int phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public void updateDetails(String name, String email, int phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

}
