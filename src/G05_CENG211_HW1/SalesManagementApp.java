package G05_CENG211_HW1;


public class SalesManagementApp {

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
		queries.printQueries();
	
	}
}


