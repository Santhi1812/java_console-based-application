public class Book {

    private int bookId;
    private String title;
    private String author;
    private double price;
    private boolean isAvailable;

    public static int totalBooks = 0;
    public static final double LATE_FEE = 2.5;

    public Book(int bookId, String title, String author, double price) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.price = price;
        this.isAvailable = true;
        totalBooks++;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public boolean rentBook() {
        if (isAvailable) {
            isAvailable = false;
            return true;
        }
        return false;
    }

    public boolean returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            return true;
        }
        return false;
    }

    public void displayDetails() {
        System.out.printf("%-6d %-25s %-20s %-8.2f %-10s\n",
                bookId, title, author, price, (isAvailable ? "Available" : "Rented"));
    }

    public String toString() {
        return "Book ID: " + bookId +
               ", Title: " + title +
               ", Author: " + author +
               ", Price: " + price +
               ", Status: " + (isAvailable ? "Available" : "Rented");
    }
}