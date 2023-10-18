package G05_CENG211_HW1;

public class ShopAssistant {
    private int id;
    private String name;
    private String surname;
    private String phoneNumber;

    public ShopAssistant(int id, String name, String surname, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
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


}
