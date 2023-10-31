package G05_CENG211_HW1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileIO {
	
	static String productFilePath = "files/products.csv";
	static String assistantFilePath = "files/shopAssistants.csv";
	
	public static Product[] readProducts() {
		int PRODUCTS_COUNT = calculateLineCountInFile(productFilePath);
		Product[] productsArray = new Product[PRODUCTS_COUNT];
		try (BufferedReader reader = new BufferedReader(new FileReader(productFilePath))) {
            String line;
            int i = 0;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                if (data.length == 3) {
                    int id = Integer.parseInt(data[0]);
                    String name = data[1];
                    double price = Double.parseDouble(data[2].replace(",", "."));
                    Product product = new Product(id, name, price);
                    productsArray[i++] = product;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } 
		return productsArray;
	}
	
	public static ShopAssistant[] readShopAssistants() {
		
		int ASSISTANTS_COUNT = calculateLineCountInFile(assistantFilePath);
		ShopAssistant[] assistants = new ShopAssistant[ASSISTANTS_COUNT];

        try (BufferedReader reader = new BufferedReader(new FileReader(assistantFilePath))) {
            String line;
            int i = 0;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                if (data.length == 4) {
                    int id = Integer.parseInt(data[0]);
                    String name = data[1];
                    String surname = data[2];
                    String phoneNumber = data[3];
                    ShopAssistant assistant = new ShopAssistant(id, name, surname, phoneNumber);
                    assistants[i++] = assistant; 
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return assistants;
    }
	
	private static int calculateLineCountInFile(String filePath) {
		
		int lineCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while (br.readLine() != null) {
                lineCount++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lineCount;
	}
}
