package G05_CENG211_HW1;

import java.util.Random;

public class Product {
    private int id;
    private String productName;
    private double price;
    private int quantity;

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

	public int getQuantity() {
		return quantity;
	}

	private void setQuantityRandom() {
	    Random rand = new Random();
	    int randomQuantity = rand.nextInt(10) + 1;
	    this.quantity = randomQuantity;
	}
}
