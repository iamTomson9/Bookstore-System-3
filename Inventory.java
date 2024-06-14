import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Book> books;

    // Constructor to initialize the inventory
    public Inventory() {
        books = new ArrayList<>();
    }

    // Method to add a book to the inventory
    public void addBook(Book book) {
        books.add(book);
    }

    // Method to display the current inventory
    public void displayInventory() {
        if (books.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            System.out.println("Inventory:");
            for (Book book : books) {
                System.out.println(book.toString());
            }
        }
    }

    // Method to search for books by title
    public List<Book> searchBooksByTitle(String keyword) {
        List<Book> searchResults = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                searchResults.add(book);
            }
        }
        return searchResults;
    }

    // Method to search for books by author
    public List<Book> searchBooksByAuthor(String keyword) {
        List<Book> searchResults = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                searchResults.add(book);
            }
        }
        return searchResults;
    }

    // Method to search for books by genre
    public List<Book> searchBooksByGenre(String keyword) {
        List<Book> searchResults = new ArrayList<>();
        for (Book book : books) {
            if (book.getGenre().toLowerCase().contains(keyword.toLowerCase())) {
                searchResults.add(book);
            }
        }
        return searchResults;
    }

    // Method to process a sale and update book quantity
    public void processSale(Book book, int quantity) {
        if (books.contains(book)) {
            int index = books.indexOf(book);
            Book soldBook = books.get(index);
            if (soldBook.getQuantity() >= quantity) {
                soldBook.setQuantity(soldBook.getQuantity() - quantity);
                System.out.println("Sale processed successfully.");
            } else {
                System.out.println("Error: Insufficient quantity in stock.");
            }
        } else {
            System.out.println("Error: Book not found in inventory.");
        }
    }

    // Method to retrieve a book by ISBN
    public Book getBookByISBN(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    // Other methods for managing inventory

    public static void main(String[] args) {
        // Create an inventory object
        Inventory inventory = new Inventory();

        // Add some books to the inventory
        inventory.addBook(new Book("9780061120084", "To Kill a Mockingbird", "Harper Lee", "Classic", 10.99, 50));
        inventory.addBook(new Book("9780140283334", "1984", "George Orwell", "Dystopian", 9.99, 30));
        inventory.addBook(new Book("9780060850524", "The Great Gatsby", "F. Scott Fitzgerald", "Classic", 12.50, 40));
        inventory.addBook(new Book("4567890123", "The Catcher in the Rye", "J.D. Salinger", "Coming-of-age", 16.99, 12));
        inventory.addBook(new Book("5678901234", "Pride and Prejudice", "Jane Austen", "Romance", 8.99, 25));

        // Display the inventory
        inventory.displayInventory();
    }
    
     public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }
}
