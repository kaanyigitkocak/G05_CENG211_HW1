package G05_CENG211_HW1;

public class SalaryManagement {
    private ShopAssistant[] shopAssistants;

    public SalaryManagement(ShopAssistant[] shopAssistants) {
        this.shopAssistants = shopAssistants;
    }



    public ShopAssistant[] getShopAssistants() {
        return shopAssistants;
    }

    public void setShopAssistants(ShopAssistant[] shopAssistants) {
        this.shopAssistants = shopAssistants;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SalaryManagement{");
        sb.append("shopAssistants=[");
        for (int i = 0; i < shopAssistants.length; i++) {
            sb.append(shopAssistants[i]);
            if (i < shopAssistants.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        sb.append("}");
        return sb.toString();
    }


}
