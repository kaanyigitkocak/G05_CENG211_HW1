package G05_CENG211_HW1;

import java.util.Random;

public class ShopAssistant {
    private int id;
    private String name;
    private String surname;
    private String phoneNumber;
    private int seniority;
    private int weeklySalaryBasis;
    
    //asagidaki iki deger sonradan query icerisinde atanacak
    //commission icin transactionManagement a bak orada bir method var
    private double totalSalary; 
    private int commission;

    public ShopAssistant(int id, String name, String surname, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        setSeniorityRandom();
        setWeeklySalaryBasis(seniority);
        
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }


    @Override
    public String toString() {
        return "ShopAssistant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
	public int getSeniority() {
		return seniority;
	}
	private void setSeniorityRandom() {
	    Random rand = new Random();
	    int randomSeniority = rand.nextInt(15) + 1;
	    this.seniority = randomSeniority;
	}
	public int getWeeklySalaryBasis() {
		return weeklySalaryBasis;
	}
	
	private void setWeeklySalaryBasis(int seniority) {
		if (seniority < 1) {
            this.weeklySalaryBasis = 1500; 
        } else if (seniority >= 1 && seniority < 3) {
        	this.weeklySalaryBasis = 2000; 
        } else if (seniority >= 3 && seniority <= 5) {
        	this.weeklySalaryBasis = 2500; 
        } else {
        	this.weeklySalaryBasis = 3000; 
        }
	}
	public int getCommission() {
		return commission;
	}
	public void setCommission(int commission) {
		this.commission = commission;
	}
	public double getTotalSalary() {
		return totalSalary;
	}
	public void setTotalSalary(double totalSalary) {
		this.totalSalary = totalSalary;
	}


}
