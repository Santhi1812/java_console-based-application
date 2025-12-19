import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    // Add book
    public void addBook(Book book) {
        books.add(book);
    }

    // Search by Title
    public Book searchBook(String title) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                return b;
            }
        }
        return null;
    }

    // Search by Author
    public Book searchBookByAuthor(String author) {
        for (Book b : books) {
            if (b.getAuthor().equalsIgnoreCase(author)) {
                return b;
            }
        }
        return null;
    }

    // Recursion - Search by ID
    public Book recursiveSearch(int id, int index) {
        if (index >= books.size()) {
            return null;
        }

        if (books.get(index).getBookId() == id) {
            return books.get(index);
        }

        return recursiveSearch(id, index + 1);

    }

    // Rent a book
    public boolean rentBook(int id) {
        Book book = recursiveSearch(id, 0);
        if (book != null) {
            return book.rentBook();
        }
        return false;
    }

    // Return a book
    public boolean returnBook(int id) {
        Book book = recursiveSearch(id, 0);
        if (book != null) {
            return book.returnBook();
        }
        return false;
    }

    // Display available books
    public void displayAvailableBooks() {
        System.out.println("\n--- Available Books ---");
        for (Book b : books) {
            if (b.isAvailable()) {
                b.displayDetails();
            }
        }
    }

    // Display rented books
    public void displayRentedBooks() {
        System.out.println("\n--- Rented Books ---");
        for (Book b : books) {
            if (!b.isAvailable()) {
                b.displayDetails();
            }
        }
    }
}