package Phase_3.Project.src.project;

public class Supplier {
    private int supplierId;
    private String name;
    private String contactInfo;

    public Supplier(int supplierId, String name, String contactInfo) {
        this.supplierId = supplierId;
        this.name = name;
        this.contactInfo = contactInfo;
    }

    public void updateSupplier(String name, String contactInfo) {
        this.name = name;
        this.contactInfo = contactInfo;
    }

}
