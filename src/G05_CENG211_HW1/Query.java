package G05_CENG211_HW1;

public class Query {

	private TransactionManagement transactionManagement;
	private SalaryManagement salaryManagement;
	
	public Query(TransactionManagement transactionManagement, SalaryManagement salaryManagement) {
		this.transactionManagement = transactionManagement;
		this.salaryManagement = salaryManagement;
	}
    public Transaction findHighestTotalPriceTransaction() {
        Transaction[][] transactions = transactionManagement.getTransactions();
        Transaction highestTotalPriceTransaction = transactions[0][0];

        for (int i = 0; i < transactionManagement.getShopAssistantCount(); i++) {
            for (int j = 0; j < transactionManagement.getAssistantTransactionCount(i); j++) {
                Transaction transaction = transactions[i][j];
                if (transaction != null && transaction.getTotalPrice() > highestTotalPriceTransaction.getTotalPrice()) {
                    highestTotalPriceTransaction = transaction;
                }
            }
        }

        return highestTotalPriceTransaction;
    }

    public Product findMostExpensiveProductInLowestPriceTransaction() {
        Transaction[][] transactions = transactionManagement.getTransactions();
        Transaction lowestPriceTransaction = transactions[0][0];

        for (int i = 0; i < transactionManagement.getShopAssistantCount(); i++) {
            for (int j = 0; j < transactionManagement.getAssistantTransactionCount(i); j++) {
                Transaction transaction = transactions[i][j];
                if (transaction != null && transaction.getTotalPrice() < lowestPriceTransaction.getTotalPrice()) {
                    lowestPriceTransaction = transaction;
                }
            }
        }

        Product mostExpensiveProduct = null;
        double maxPrice = 0;

        for (Product product : lowestPriceTransaction.getProducts()) {
            if (product.getPrice() > maxPrice) {
                mostExpensiveProduct = product;
                maxPrice = product.getPrice();
            }
        }

        return mostExpensiveProduct;
    }

    public Transaction findLowestTransactionFee() {
        Transaction[][] transactions = transactionManagement.getTransactions();
        Transaction lowestTransactionFeeTransaction = transactions[0][0];

        for (int i = 0; i < transactionManagement.getShopAssistantCount(); i++) {
            for (int j = 0; j < transactionManagement.getAssistantTransactionCount(i); j++) {
                Transaction transaction = transactions[i][j];
                if (transaction != null && transaction.getTransactionFee() < lowestTransactionFeeTransaction.getTransactionFee()) {
                    lowestTransactionFeeTransaction = transaction;
                }
            }
        }

        return lowestTransactionFeeTransaction;
    }

    public ShopAssistant findHighestSalaryShopAssistant() {
    	ShopAssistant[] shopAssistants = salaryManagement.getShopAssistants();
        ShopAssistant highestSalaryAssistant = shopAssistants[0];

        for (ShopAssistant assistant : shopAssistants) {
            if (assistant != null && assistant.getTotalSalary() > highestSalaryAssistant.getTotalSalary()) {
                highestSalaryAssistant = assistant;
            }
        }

        return highestSalaryAssistant;
    }

    public double calculateTotalRevenue() {
        double totalRevenue = 0.0;
        Transaction[][] transactions = transactionManagement.getTransactions();

        for (int i = 0; i < transactionManagement.getShopAssistantCount(); i++) {
            for (int j = 0; j < transactionManagement.getAssistantTransactionCount(i); j++) {
                Transaction transaction = transactions[i][j];
                if (transaction != null) {
                    totalRevenue += transaction.getTotalPrice() + transaction.getTransactionFee();
                }
            }
        }

        return totalRevenue;
    }

    public double calculateTotalProfit(SalaryManagement salaryManagement) {
        double totalRevenue = calculateTotalRevenue();
        double totalShopAssistantSalaries = salaryManagement.calculateTotalWeeklySalaries();

        return totalRevenue - totalShopAssistantSalaries;
    }
}
