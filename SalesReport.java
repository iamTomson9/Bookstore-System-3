import java.util.HashMap;
import java.util.Map;

public class SalesReport {
    private double totalRevenue;

    // Placeholder sales data (for demonstration purposes)
    private Map<Book, Integer> salesData;

    public SalesReport() {
        totalRevenue = 0.0;
        salesData = new HashMap<>();
    }

    // Method to generate sales report and calculate total revenue
    public void generateSalesReport() {
        // Reset total revenue before recalculating
        totalRevenue = 0.0;

        // Placeholder sales data (for demonstration purposes)
        salesData.put(new Book("9780061120084", "To Kill a Mockingbird", "Harper Lee", "Classic", 10.99, 2), 1);
        salesData.put(new Book("9780140283334", "1984", "George Orwell", "Dystopian", 9.99, 3), 1);
        salesData.put(new Book("9780060850524", "The Great Gatsby", "F. Scott Fitzgerald", "Classic", 12.50, 1), 2);
        salesData.put(new Book("4567890123", "The Catcher in the Rye", "J.D. Salinger", "Coming-of-age", 16.99, 4), 3);
        salesData.put(new Book("5678901234", "Pride and Prejudice", "Jane Austen", "Romance", 8.99, 4), 3);

        // Calculate total revenue based on sales data
        for (Map.Entry<Book, Integer> entry : salesData.entrySet()) {
            Book book = entry.getKey();
            int quantitySold = entry.getValue();
            totalRevenue += book.getPrice() * quantitySold;
        }
    }

    // Getter method for total revenue
    public double getTotalRevenue() {
        return totalRevenue;
    }

    // Other methods for generating reports (if needed)
}
