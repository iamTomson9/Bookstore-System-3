import java.util.HashMap;
import java.util.Map;

public class CustomerManager {
    private Map<String, Customer> customers;

    public CustomerManager() {
        customers = new HashMap<>();
        // Add sample customers
        Customer[] sampleCustomers = Customer.sampleCustomers();
        for (Customer customer : sampleCustomers) {
            customers.put(customer.getEmail(), customer);
        }
    }

    public void addCustomer(Customer customer) {
        customers.put(customer.getEmail(), customer);
    }

    public Customer getCustomerByEmail(String email) {
        return customers.get(email);
    }

    public void viewPurchaseHistory(Customer customer) {
        Map<Book, Integer> purchaseHistory = customer.getPurchaseHistory();
        System.out.println("Purchase History for " + customer.getName() + ":");
        if (purchaseHistory.isEmpty()) {
            System.out.println("No purchase history found.");
        } else {
            for (Map.Entry<Book, Integer> entry : purchaseHistory.entrySet()) {
                System.out.println(entry.getKey().getTitle() + " - Quantity: " + entry.getValue());
            }
        }
    }

    public static void main(String[] args) {
        CustomerManager customerManager = new CustomerManager();
        Customer customer1 = customerManager.getCustomerByEmail("alice@gmail.com.com");
        Customer customer2 = customerManager.getCustomerByEmail("bob@yahoo.com");

        if (customer1 != null && customer2 != null) {
            customer1.addToPurchaseHistory(new Book("9780061120084", "To Kill a Mockingbird", "Harper Lee", "Classic", 10.99, 2), 1);
            customer1.addToPurchaseHistory(new Book("9780140283334", "1984", "George Orwell", "Dystopian", 9.99, 3), 1);
            customer2.addToPurchaseHistory(new Book("9780060850524", "The Great Gatsby", "F. Scott Fitzgerald", "Classic", 12.50, 1), 2);
            customer2.addToPurchaseHistory(new Book("4567890123", "The Catcher in the Rye", "J.D. Salinger", "Coming-of-age", 16.99, 4), 3);
            customer2.addToPurchaseHistory(new Book("5678901234", "Pride and Prejudice", "Jane Austen", "Romance", 8.99, 4), 3);

            customerManager.viewPurchaseHistory(customer1);
            System.out.println();
            customerManager.viewPurchaseHistory(customer2);
        }
        
    }
}
