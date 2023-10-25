package G05_CENG211_HW1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileIO {
	
	static String productFilePath = "../files/products.csv";
	static String assistantFilePath = "../files/shopAssistants.csv";


	public static void readProducts(Transaction transaction) {

        try (BufferedReader reader = new BufferedReader(new FileReader(productFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) {
                    int id = Integer.parseInt(data[0]);
                    String productName = data[1];
                    double price = Double.parseDouble(data[2]);
                    transaction.addProduct(new Product(id, productName, price));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

	public static void readShopAssistants(SalaryManagement salaryManagement) {


        try (BufferedReader reader = new BufferedReader(new FileReader(assistantFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    int id = Integer.parseInt(data[0]);
                    String name = data[1];
                    String surname = data[2];
                    String phoneNumber = data[3];
                    salaryManagement.addShopAssistant(new ShopAssistant(id, name, surname, phoneNumber));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
