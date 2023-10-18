package G05_CENG211_HW1;

public class Transaction {
    private int id;
    private Product[] products;
    private double totalPrice;
    private double transactionFee;

    public Transaction(int id, Product[] products, double transactionFee) {
        this.id = id;
        if (products.length == 3) {
            this.products = products;
        } else {
            throw new IllegalArgumentException("A transaction must include an array of 3 products.");
        }
        this.totalPrice = calculateTotalPrice();
        this.transactionFee = transactionFee;
    }

    // Getter and Setter methods for the attributes

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        if (products.length == 3) {
            this.products = products;
        } else {
            throw new IllegalArgumentException("A transaction must include an array of 3 products.");
        }
        this.totalPrice = calculateTotalPrice();
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double getTransactionFee() {
        return transactionFee;
    }

    public void setTransactionFee(double transactionFee) {
        this.transactionFee = transactionFee;
    }

    private double calculateTotalPrice() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Transaction{");
        sb.append("id=").append(id).append(", ");
        sb.append("products=[");
        for (int i = 0; i < products.length; i++) {
            sb.append(products[i]);
            if (i < products.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("], ");
        sb.append("totalPrice=").append(totalPrice).append(", ");
        sb.append("transactionFee=").append(transactionFee);
        sb.append("}");
        return sb.toString();
    }
    // You can add other methods and functionality as needed.
}
