public class Book {
    private String isbn;
    private String title;
    private String author;
    private String genre;
    private double price;
    private int quantity;

    // Constructor
    public Book(String isbn, String title, String author, String genre, double price, int quantity) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and Setters
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // toString method
    @Override
    public String toString() {
        return "ISBN: " + isbn + ", Title: " + title + ", Author: " + author + ", Genre: " + genre +
                ", Price: $" + price + ", Quantity: " + quantity;
    }

    public static void main(String[] args) {
        // Create some Book objects with actual data
        Book book1 = new Book("9780061120084", "To Kill a Mockingbird", "Harper Lee", "Classic", 10.99, 50);
        Book book2 = new Book("9780140283334", "1984", "George Orwell", "Dystopian", 9.99, 30);
        Book book3 = new Book("9780060850524", "The Great Gatsby", "F. Scott Fitzgerald", "Classic", 12.50, 40);
        Book book4 = new Book("4567890123", "The Catcher in the Rye", "J.D. Salinger", "Coming-of-age", 16.99, 12);
        Book book5 = new Book("5678901234", "Pride and Prejudice", "Jane Austen", "Romance", 8.99, 25);


        // Display book information
        System.out.println("Book 1: " + book1);
        System.out.println("Book 2: " + book2);
        System.out.println("Book 3: " + book3);
        System.out.println("Book 4: " + book4);
        System.out.println("Book 5: " + book5);

    }
}
