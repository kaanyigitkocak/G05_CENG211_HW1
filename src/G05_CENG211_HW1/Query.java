package G05_CENG211_HW1;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

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

        DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.getDefault());
        otherSymbols.setDecimalSeparator('.');
        DecimalFormat df = new DecimalFormat("#.00", otherSymbols);

        return Double.parseDouble(df.format(totalRevenue));
    }

    public double calculateTotalProfit() {
    	
        double totalRevenue = calculateTotalRevenue();
        double totalShopAssistantSalaries = salaryManagement.calculateTotalShopAssistantSalaries(transactionManagement);

        double totalProfit = totalRevenue - totalShopAssistantSalaries;

        DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.getDefault());
        otherSymbols.setDecimalSeparator('.');
        DecimalFormat df = new DecimalFormat("#.00", otherSymbols);

        return Double.parseDouble(df.format(totalProfit).replace(",", ""));

    }
    
    public void printQueries() {
    	
    	System.out.println("Highest Total Price Transaction: " +"\n"+ findHighestTotalPriceTransaction()+"\n-------------------------------------\n" );
        System.out.println("Most Expensive Product In Lowest Price Transaction: " +"\n"+ findMostExpensiveProductInLowestPriceTransaction()+"\n-------------------------------------\n" );
        System.out.println("Lowest Transaction Fee: " +"\n"+ findLowestTransactionFee()+"\n-------------------------------------\n" );
        System.out.println("Highest Salary Shop Assistant: " +"\n"+ findHighestSalaryShopAssistant()+"\n-------------------------------------\n" );
        System.out.println("Total Revenue is: " + calculateTotalRevenue()+"\n-------------------------------------\n\n" );
        System.out.println("Total Profit is: " + calculateTotalProfit());
    }
}
