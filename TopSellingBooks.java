import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TopSellingBooks {
    private List<Book> topSellingBooks;

    public TopSellingBooks() {
        topSellingBooks = new ArrayList<>();
    }

    public void updateTopSellingBooks(List<Book> salesData) {
        // Update list of top-selling books based on sales data
        topSellingBooks.clear(); // Clear previous list of top-selling books

        // Sort the sales data by quantity sold in descending order
        salesData.sort(Comparator.comparingInt(Book::getQuantity).reversed());

        // Add the top-selling books to the list
        for (int i = 0; i < Math.min(salesData.size(), 5); i++) { // Consider top 5 selling books
            topSellingBooks.add(salesData.get(i));
        }
    }

    public void viewTopSellingBooks() {
        // View list of top-selling books
        if (topSellingBooks.isEmpty()) {
            System.out.println("No top-selling books found.");
        } else {
            System.out.println("Top Selling Books:");
            for (Book book : topSellingBooks) {
                System.out.println(book.toString());
            }
        }
    }
 
    public void clearTopSellingBooks() {
        topSellingBooks.clear();
        System.out.println("Top-selling books list cleared.");
    }

    public static void main(String[] args) {
        // Create some sample sales data (for demonstration purposes)
        List<Book> salesData = new ArrayList<>();
        salesData.add(new Book("9780061120084", "To Kill a Mockingbird", "Harper Lee", "Classic", 10.99, 50));
        salesData.add(new Book("9780140283334", "1984", "George Orwell", "Dystopian", 9.99, 30));
        salesData.add(new Book("9780060850524", "The Great Gatsby", "F. Scott Fitzgerald", "Classic", 12.50, 40));
        salesData.add(new Book("4567890123", "The Catcher in the Rye", "J.D. Salinger", "Coming-of-age", 16.99, 12));
        salesData.add(new Book("5678901234", "Pride and Prejudice", "Jane Austen", "Romance", 8.99, 25));

        // Create a TopSellingBooks object
        TopSellingBooks topSellingBooks = new TopSellingBooks();

        // Update and view top selling books
        topSellingBooks.updateTopSellingBooks(salesData);
        topSellingBooks.viewTopSellingBooks();
    }
}
