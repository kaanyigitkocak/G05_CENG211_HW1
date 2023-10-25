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

	public double calculateTotalWeeklySalaries() {
		// boş metod Query classındaki calculateTotalProfit metodu için ekledim
		//totalsalary ve commission ları burda çağırırız query e direkt bu metodu ekleriz
		return 0;
	}


}
