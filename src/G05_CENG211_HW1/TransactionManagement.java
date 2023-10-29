package G05_CENG211_HW1;

import java.util.Random;

public class TransactionManagement {
    private static final int TRANSACTION_CAPACITY = 15;
    
	private Transaction[][] transactions;
    private int shopAssistantCount;
    private int transactionCapacity;

    public TransactionManagement(int shopAssistantCapacity) {

        this.shopAssistantCount = shopAssistantCapacity;
        this.transactionCapacity = TRANSACTION_CAPACITY;
        this.transactions = new Transaction[shopAssistantCount][transactionCapacity];
    }
    
    public void createTransactionsList(Product[] products, ShopAssistant[] shopAssistants) {
		int transaction_count = 0;
		for (int i = 0; i < shopAssistants.length; i++) {
			for(int j = 0; j < TRANSACTION_CAPACITY; j++) {
				Product[] randomProducts = new Product[3];
				Random random = new Random();
				
				randomProducts[0] = products[random.nextInt(90)];
				randomProducts[1] = products[random.nextInt(90)];
				randomProducts[2] = products[random.nextInt(90)];
				
				Transaction transaction = new Transaction(transaction_count++, 3, randomProducts);
				addTransaction(i, transaction);
			}
		}
	}
    
    public void addTransaction(int shopAssistantIndex, Transaction transaction) {
        if (shopAssistantIndex < 0 || shopAssistantIndex > shopAssistantCount) {
            System.out.println("Invalid shop assistant index.");
            return;
        }

        int assistantTransactionCount = getAssistantTransactionCount(shopAssistantIndex);
        if (assistantTransactionCount >= transactionCapacity) {
            System.out.println("Shop assistant's transaction capacity exceeded.");
            return;
        }

        transactions[shopAssistantIndex][assistantTransactionCount] = transaction;
    }

    public int getAssistantTransactionCount(int shopAssistantIndex) {
        if (shopAssistantIndex < 0 || shopAssistantIndex >= shopAssistantCount) {
            return 0;
        }

        int count = 0;
        for (Transaction transaction : transactions[shopAssistantIndex]) {
            if (transaction != null) {
                count++;
            }
            else {
            	break;
            }
        }
        
        return count;
    }


    public Transaction getTransaction(int shopAssistantIndex, int transactionIndex) {
        if (shopAssistantIndex < 0 || shopAssistantIndex >= shopAssistantCount
            || transactionIndex < 0 || transactionIndex >= getAssistantTransactionCount(shopAssistantIndex)) {
            return null;
        }

        return transactions[shopAssistantIndex][transactionIndex];
    }
    
    public double calculateCommission(int shopAssistantIndex) {

        double totalRevenue = 0.0;
        for (Transaction transaction : transactions[shopAssistantIndex]) {
            if (transaction != null) {
                totalRevenue += transaction.getTotalPrice();
            }
        }
        double commission;
        if (totalRevenue > 7500) {
            commission = totalRevenue * 0.03; 

        } else {
            commission = totalRevenue * 0.01;
        } 

        return commission;
    }
    
    public Transaction[][] getTransactions() {
        return transactions;
    }

    public int getShopAssistantCount() {
        return shopAssistantCount;
    }

    public int getTransactionCapacity() {
        return transactionCapacity;
    }

    public void setShopAssistantCount(int shopAssistantCount) {
        this.shopAssistantCount = shopAssistantCount;
    }

    public void setTransactionCapacity(int transactionCapacity) {
        this.transactionCapacity = transactionCapacity;
    }

}

