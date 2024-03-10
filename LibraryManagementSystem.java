import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private int id;
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public int getId() {
        return id;
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

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}

class Library {
    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public Book findBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    public void displayAvailableBooks() {
        System.out.println("Available Books:");
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println(book.getTitle() + " by " + book.getAuthor());
            }
        }
    }

    public void checkOutBook(int id) {
        Book book = findBookById(id);
        if (book != null && book.isAvailable()) {
            book.setAvailable(false);
            System.out.println("Book checked out successfully.");
        } else {
            System.out.println("Book not found or already checked out.");
        }
    }

    public void returnBook(int id) {
        Book book = findBookById(id);
        if (book != null && !book.isAvailable()) {
            book.setAvailable(true);
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Book not found or already available.");
        }
    }

    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        library.addBook(new Book(1187, "The Catcher in the Rye", "J.D. Salinger"));
        library.addBook(new Book(2256, "To Kill a Mockingbird", "Harper Lee"));
        library.addBook(new Book(3489, "1984", "George Orwell"));

        while (true) {
            System.out.println("\n1. Display available books");
            System.out.println("2. Check out book");
            System.out.println("3. Return book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    library.displayAvailableBooks();
                    break;
                case 2:
                    System.out.print("Enter book id: ");
                    int bookId = scanner.nextInt();
                    library.checkOutBook(bookId);
                    break;
                case 3:
                    System.out.print("Enter book id: ");
                    bookId = scanner.nextInt();
                    library.returnBook(bookId);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}