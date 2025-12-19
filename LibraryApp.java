import java.util.Scanner;

public class LibraryApp {

    public static void main(String[] args) {

        String libraryName = (args.length > 0) ? args[0] : "My Library";

        Library library = new Library();
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        // Default books
        library.addBook(new Book(101, "Java Programming", "James Gosling", 450));
        library.addBook(new Book(102, "Data Structures", "Mark Allen", 350));
        library.addBook(new Book(103, "Algorithms", "Thomas Cormen", 500));

        do {
            System.out.println("\n========== " + libraryName + " ==========");
            System.out.println("1. Add Book");
            System.out.println("2. Search Book by Title");
            System.out.println("3. Search Book by Author");
            System.out.println("4. Rent Book");
            System.out.println("5. Return Book");
            System.out.println("6. Show Available Books");
            System.out.println("7. Show Rented Books");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input. Try again.");
                continue;
            }

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Enter Book ID: ");
                        int id = Integer.parseInt(sc.nextLine());

                        System.out.print("Enter Title: ");
                        String title = sc.nextLine();

                        System.out.print("Enter Author: ");
                        String author = sc.nextLine();

                        System.out.print("Enter Price: ");
                        double price = Double.parseDouble(sc.nextLine());

                        Book book = new Book(id, title, author, price);
                        library.addBook(book);

                        System.out.println("✅ Book added successfully!");

                    } catch (Exception e) {
                        System.out.println("❌ Invalid input. Book not added.");
                    }
                    break;

                case 2:
                    System.out.print("Enter title to search: ");
                    String title = sc.nextLine();
                    Book found1 = library.searchBook(title);

                    if (found1 != null) {
                        System.out.println(found1);
                    } else {
                        System.out.println("❌ Book not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter author to search: ");
                    String author = sc.nextLine();
                    Book found2 = library.searchBookByAuthor(author);

                    if (found2 != null) {
                        System.out.println(found2);
                    } else {
                        System.out.println("❌ Book not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Book ID to rent: ");
                    int rentId = Integer.parseInt(sc.nextLine());
                    boolean rented = library.rentBook(rentId);

                    if (rented) {
                        System.out.println("✅ Book rented successfully!");
                    } else {
                        System.out.println("❌ Book is already rented or not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter Book ID to return: ");
                    int returnId = Integer.parseInt(sc.nextLine());
                    boolean returned = library.returnBook(returnId);

                    if (returned) {
                        System.out.println("✅ Book returned successfully!");
                    } else {
                        System.out.println("❌ Book not found or not rented.");
                    }
                    break;

                case 6:
                    library.displayAvailableBooks();
                    break;

                case 7:
                    library.displayRentedBooks();
                    break;

                case 8:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 8);

        sc.close();
    }
}