package G05_CENG211_HW1;

public class SalaryManagement {
    private ShopAssistant[] shopAssistants;
    private int itemCount;
    private int capacity;

    public SalaryManagement(ShopAssistant[] shopAssistants) {
        this.shopAssistants = shopAssistants;
    }

	public int getCapacity() {
		return capacity;
	}
	
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

    public ShopAssistant getShopAssistantById(int id){

        return shopAssistants[id];
    }
    
    public ShopAssistant[] getShopAssistants() {
    	return shopAssistants;
    }
    
    public boolean isFull() {
        return itemCount == capacity;
    }
    
    public boolean isEmpty() {
        return itemCount == 0;
    }
    
    public boolean addShopAssistant(ShopAssistant newItem) {
        if (newItem == null || isFull()) {
            return false;
        }

        shopAssistants[itemCount] = newItem;
        itemCount++;

        return true;
    }

    public void displayShopAssistantItems() {
        for (ShopAssistant assistant : shopAssistants) {
            System.out.println(assistant.toString()); // Assuming ShopAssistant has a proper toString method
        }
    }
    
    public double calculateShopAssistantsTotalSalary(int shopAssistantIndex) {
    	double commission = shopAssistants[shopAssistantIndex].getCommission();
    	int weekly = shopAssistants[shopAssistantIndex].getWeeklySalaryBasis();
    	double total = commission + (weekly * 4);
    	return total;
    			
    }
    public void calculateAndSetShopAssistantTotalSalary(TransactionManagement tm) {
    	for (int i = 0; i < shopAssistants.length; i++) {
    		shopAssistants[i].setCommission(tm.calculateCommission(i));
    		double commission = shopAssistants[i].getCommission();
    		int monthly = shopAssistants[i].getWeeklySalaryBasis() * 4;
    		double total = monthly + commission;  		
    		shopAssistants[i].setTotalSalary(total);
    	}
    }

	public double calculateTotalShopAssistantSalaries(TransactionManagement tm) {
		double total = 0;
		for (int i = 0; i < shopAssistants.length; i++) {
    		total += shopAssistants[i].getTotalSalary();
    	}
		return total;
	}
}
