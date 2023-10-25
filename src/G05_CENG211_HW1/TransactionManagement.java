package G05_CENG211_HW1;

public class TransactionManagement {
    private Transaction[][] transactions;
    private int shopAssistantCount;
    private int shopAssistantCapacity;
    private int transactionCount;
    private int transactionCapacity;


    public TransactionManagement(int shopAssistantCapacity, int transactionCapacity) {

        this.shopAssistantCapacity = shopAssistantCapacity;
        this.transactionCapacity = transactionCapacity;
        this.transactions = new Transaction[shopAssistantCapacity][transactionCapacity];
    }
    
    
    
    //assistant idlerine gore atama yapilabilir
    public void addTransaction(int shopAssistantIndex, Transaction transaction) {
        if (shopAssistantIndex < 0 || shopAssistantIndex > shopAssistantCapacity) {
            System.out.println("Invalid shop assistant index.");
            System.out.println(shopAssistantCount);
            
            return;
        }

        if (transactionCount >= transactionCapacity) {
            System.out.println("Transaction capacity exceeded.");
            return;
        }

        //hatalı ve gereksiz duruyor birlikte bakalım tekrar transactions 2 boyutlu çünkü
        //if (transactions[shopAssistantIndex] == null) {
        //    transactions[shopAssistantIndex] = new Transaction[shopAssistantCapacity];
        //}

        int assistantTransactionCount = getAssistantTransactionCount(shopAssistantIndex);
        if (assistantTransactionCount >= shopAssistantCapacity) {
            System.out.println("Shop assistant's transaction capacity exceeded.");
            return;
        }

        transactions[shopAssistantIndex][assistantTransactionCount] = transaction;
        transactionCount++;

    }

    public int getAssistantTransactionCount(int shopAssistantIndex) {
        if (shopAssistantIndex < 0 || shopAssistantIndex >= shopAssistantCount) {
            return 0;
        }

        int count = 0;
        if (transactions[shopAssistantIndex] != null) {
            for (Transaction transaction : transactions[shopAssistantIndex]) {
                if (transaction != null) {
                    count++;
                }
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
    
    public int calculateCommission(int shopAssistantIndex) {

        double totalRevenue = 0.0;
        if (transactions[shopAssistantIndex] != null) {
            for (Transaction transaction : transactions[shopAssistantIndex]) {
                if (transaction != null) {
                    totalRevenue += transaction.getTotalPrice();
                }
            }
        }
        int commission;
        if (totalRevenue > 7500) {
            commission = 3; 
        } else {
            commission = 1;
        }

        return commission;
    }
    
    public Transaction[][] getTransactions() {
        return transactions;
    }

    public int getShopAssistantCount() {
        return shopAssistantCount;
    }

    public int getShopAssistantCapacity() {
        return shopAssistantCapacity;
    }

    public int getTransactionCount() {
        return transactionCount;
    }

    public int getTransactionCapacity() {
        return transactionCapacity;
    }

    public void setShopAssistantCount(int shopAssistantCount) {
        this.shopAssistantCount = shopAssistantCount;
    }

    public void setShopAssistantCapacity(int shopAssistantCapacity) {
        this.shopAssistantCapacity = shopAssistantCapacity;
    }

    public void setTransactionCount(int transactionCount) {
        this.transactionCount = transactionCount;
    }

    public void setTransactionCapacity(int transactionCapacity) {
        this.transactionCapacity = transactionCapacity;
    }

}

