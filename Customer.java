import java.util.HashMap;
import java.util.Map;

public class Customer {
    private String name;
    private String email;
    private Map<Book, Integer> purchaseHistory;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
        this.purchaseHistory = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Map<Book, Integer> getPurchaseHistory() {
        return purchaseHistory;
    }

    public void addToPurchaseHistory(Book book, int quantity) {
        purchaseHistory.put(book, quantity);
    }



    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    // Sample customers
    public static Customer[] sampleCustomers() {
        return new Customer[] {
            new Customer("Alice Doe", "alice@gmail.com"),
            new Customer("Bob Smith", "jane@yahoo.com"),
            new Customer("Michael Johnson", "michael@yahoo.com")
        };
    }

}
