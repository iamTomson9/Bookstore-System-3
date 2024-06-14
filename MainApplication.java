import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class MainApplication extends JFrame implements ActionListener {
    private Inventory inventory;
    private CustomerManager customerManager;
    private SalesReport salesReport;
    private TopSellingBooks topSellingBooks;

    private JTextArea outputArea;
    private JTextField searchField;
    private JComboBox<String> searchOptions;

    public MainApplication() {
        super("Bookworm Haven Bookstore Management System");
        inventory = new Inventory();
        customerManager = new CustomerManager();
        salesReport = new SalesReport();
        topSellingBooks = new TopSellingBooks();

        outputArea = new JTextArea(20, 50);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        JLabel searchLabel = new JLabel("Search:");
        searchField = new JTextField(20);
        String[] searchOptionsList = {"Title", "Author", "Genre"};
        searchOptions = new JComboBox<>(searchOptionsList);
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(this);

        JButton addBookButton = new JButton("Add Book");
        addBookButton.addActionListener(this);

        JButton processSaleButton = new JButton("Process Sale");
        processSaleButton.addActionListener(this);

        JButton viewInventoryButton = new JButton("View Inventory");
        viewInventoryButton.addActionListener(this);

        JButton generateSalesReportButton = new JButton("Generate Sales Report");
        generateSalesReportButton.addActionListener(this);

        JPanel searchPanel = new JPanel();
        searchPanel.add(searchLabel);
        searchPanel.add(searchField);
        searchPanel.add(searchOptions);
        searchPanel.add(searchButton);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addBookButton);
        buttonPanel.add(processSaleButton);
        buttonPanel.add(viewInventoryButton);
        buttonPanel.add(generateSalesReportButton);

        JPanel mainPanel = new JPanel();
        mainPanel.add(searchPanel);
        mainPanel.add(buttonPanel);
        mainPanel.add(scrollPane);

        add(mainPanel);
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "Search":
                searchBooks();
                break;
            case "Add Book":
                addBook();
                break;
            case "Process Sale":
                processSale();
                break;
            case "View Inventory":
                viewInventory();
                break;
            case "Generate Sales Report":
                generateSalesReport();
                break;
            default:
                break;
        }
    }

    private void searchBooks() {
        String keyword = searchField.getText();
        String option = (String) searchOptions.getSelectedItem();
        List<Book> searchResults;

        switch (option) {
            case "Title":
                searchResults = inventory.searchBooksByTitle(keyword);
                break;
            case "Author":
                searchResults = inventory.searchBooksByAuthor(keyword);
                break;
            case "Genre":
                searchResults = inventory.searchBooksByGenre(keyword);
                break;
            default:
                searchResults = inventory.searchBooksByTitle(keyword);
        }

        displaySearchResults(searchResults);
    }

    private void displaySearchResults(List<Book> searchResults) {
        outputArea.setText("");
        if (searchResults.isEmpty()) {
            outputArea.append("No books found.");
        } else {
            for (Book book : searchResults) {
                outputArea.append(book.toString() + "\n");
            }
        }
    }

    private void addBook() {
        String isbn = "9780061120084";
        String title = "To Kill a Mockingbird";
        String author = "Harper Lee";
        String genre = "Classic";
        double price = 10.99;
        int quantity = 50;

        Book newBook = new Book(isbn, title, author, genre, price, quantity);
        inventory.addBook(newBook);
        outputArea.setText("Book added successfully.");
    }

    private void processSale() {
        // Placeholder values for demonstration
        String isbn = "9780061120084";
        int quantitySold = 1;

        Book book = inventory.getBookByISBN(isbn);
        if (book != null && book.getQuantity() >= quantitySold) {
            inventory.processSale(book, quantitySold);
            salesReport.generateSalesReport(); // Update sales report
            outputArea.setText("Sale processed successfully.");
        } else {
            outputArea.setText("Error: Book not found or insufficient quantity.");
        }
    }

    private void viewInventory() {
        List<Book> inventoryList = inventory.getAllBooks();
        outputArea.setText("");
        if (inventoryList.isEmpty()) {
            outputArea.setText("Inventory is empty.");
        } else {
            for (Book book : inventoryList) {
                outputArea.append(book.toString() + "\n");
            }
        }
    }

    private void generateSalesReport() {
        salesReport.generateSalesReport();
        double totalRevenue = salesReport.getTotalRevenue();
        outputArea.setText("Sales Report:\n");
        outputArea.append("Total Revenue: $" + totalRevenue);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainApplication::new);
    }
}
