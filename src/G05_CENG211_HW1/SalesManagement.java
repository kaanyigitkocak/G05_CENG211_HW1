package G05_CENG211_HW1;

import java.util.Random;

public class SalesManagement {
	

	public static final int TRANSACTION_CAPACITY = 15;
	
	private static Product[] products;
	private static ShopAssistant[] shopAssistants;
	
	public static void main(String[] args) {

		products = FileIO.readProducts();
		shopAssistants = FileIO.readShopAssistants();
		
		TransactionManagement tm = new TransactionManagement(shopAssistants.length);
		SalaryManagement sm = new SalaryManagement(shopAssistants);

		tm.createTransactionsList(products, shopAssistants); //fills transaction management class' 2D array with transactions.
		sm.calculateAndSetShopAssistantTotalSalary(tm);
		
		Query queries = new Query(tm, sm);
		System.out.println("Highest Salary Shop Assistant is: " + queries.findHighestSalaryShopAssistant());
		System.out.println("Highest Total Price Transaction is: " + queries.findHighestTotalPriceTransaction());
		System.out.println("Lowest Transaction Fee is: " + queries.findLowestTransactionFee());
		System.out.println("Most Expensive Product In Lowest Price Transaction is: " + queries.findMostExpensiveProductInLowestPriceTransaction());
		System.out.println("Total Revenue is: " + queries.calculateTotalRevenue());
		System.out.println("Total profit is: " + queries.calculateTotalProfit());
	
	}
	

}
