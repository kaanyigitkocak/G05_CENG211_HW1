package G05_CENG211_HW1;

public class Product {
    private int id;
    private String productName;
    private double price;

    public Product(int id, String productName, double price) {
        this.id = id;
        this.productName = productName;
        this.price = price;
    }
    
    public int getId() {
        return id;
    }


    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                '}';
    }

}
