package G05_CENG211_HW1;

public class Transaction {
    private int id;
    private Product[] products;
    private int itemCount;
    private int capacity;
    private double totalPrice;
    private double transactionFee;

    public Transaction(int id, int capacity, Product[] products) {
        this.id = id;
        this.capacity = capacity;
        this.products = new Product[capacity];
        addProductsByList(products);
        totalPrice = calculateTotalPrice();
        calculateTransactionFee();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Product getProductById(int id){

        return products[id];
    }
    
    public boolean isFull() {
        return itemCount == capacity;
    }
    
    public boolean isEmpty() {
        return itemCount == 0;
    }
    
    public boolean addProduct(Product newItem) {
        if (newItem == null || isFull()) {
            return false;
        }
        products[itemCount] = newItem;
        itemCount++;

        return true;
    }
    
    public boolean addProductsByList(Product[] products) {
        for (int i = 0; i < capacity; i++) {
        	
        	if (products[i]== null) {
        		return false;
        	}
        	
        	this.products[i] = products[i];
        }
        
        return true;
    }

    public void displayItems() {
        for (Product product : products) {
            System.out.println(product.toString()); 
        }
    }


    public double getTotalPrice() {
        return totalPrice;
    }

    public double getTransactionFee() {
        return transactionFee;
    }

    private double calculateTotalPrice() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    private void calculateTransactionFee() {
        if (totalPrice <= 499) {
            transactionFee = 0.01 * totalPrice; 
        } else if (totalPrice >= 500 && totalPrice <= 799) {
            transactionFee = 0.03 * totalPrice; 
        } else if (totalPrice >= 800 && totalPrice <= 999) {
            transactionFee = 0.05 * totalPrice; 
        } else {
            transactionFee = 0.09 * totalPrice; 
        }
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
}