package G05_CENG211_HW1;

public class TransactionManagement {
    private Transaction[][] transactions; 

    public TransactionManagement(int numberOfShopAssistants, int maxTransactionsPerAssistant) {
        transactions = new Transaction[numberOfShopAssistants][maxTransactionsPerAssistant];
    }


    public boolean addTransaction(int shopAssistantId, Transaction transaction) {
        if (shopAssistantId < 0 || shopAssistantId >= transactions.length) {
            return false; 
        }

        for (int i = 0; i < transactions[shopAssistantId].length; i++) {
            if (transactions[shopAssistantId][i] == null) {
                transactions[shopAssistantId][i] = transaction;
                return true;
            }
        }
        return false; 
    }


    public void displayTransactions(int shopAssistantId) {
        if (shopAssistantId < 0 || shopAssistantId >= transactions.length) {
            System.out.println("Invalid shop assistant ID");
            return;
        }

        for (Transaction transaction : transactions[shopAssistantId]) {
            if (transaction != null) {
                System.out.println(transaction.toString());
            }
        }
    }
}
