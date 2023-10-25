package G05_CENG211_HW1;

public class SalesManagement {
	

	public static void main(String[] args) {

		// Create Product objects
		Product product1 = new Product(1, "Product 1", 100.0);
		Product product2 = new Product(2, "Product 2", 200.0);
		Product product3 = new Product(3, "Product 3", 150.0);
		Product product4 = new Product(3, "Product 3", 150.0);
		// Create a Product array with the products
		Product[] products = {product1, product2, product3};

		// Create a new Transaction
		Transaction newTransaction = new Transaction(1, 3,products);

		


		// Display the new Transaction
		System.out.println("New Transaction:");
		System.out.println(newTransaction);

	}

}
