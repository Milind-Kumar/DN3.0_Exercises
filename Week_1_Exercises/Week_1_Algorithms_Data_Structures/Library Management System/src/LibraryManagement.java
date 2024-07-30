import java.util.*;

public class LibraryManagement {
    private static List<Book> books = new ArrayList<>();

    public static Book linearSearch(String title) {
        for (Book book : books) {
            if (book.title.equals(title)) {
                return book;
            }
        }
        return null;
    }

    public static Book binarySearch(String title) {
        int left = 0, right = books.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = books.get(mid).title.compareTo(title);
            if (cmp == 0) return books.get(mid);
            if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of books:");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        for (int i = 0; i < n; i++) {
            System.out.println("Enter book ID:");
            String bookId = scanner.nextLine();
            System.out.println("Enter title:");
            String title = scanner.nextLine();
            System.out.println("Enter author:");
            String author = scanner.nextLine();
            books.add(new Book(bookId, title, author));
        }
        Collections.sort(books, Comparator.comparing(b -> b.title));
        System.out.println("Enter title to search:");
        String searchTitle = scanner.nextLine();
        System.out.println("Choose search method: 1. Linear Search 2. Binary Search");
        int choice = scanner.nextInt();
        Book book = null;
        if (choice == 1) {
            book = linearSearch(searchTitle);
        } else if (choice == 2) {
            book = binarySearch(searchTitle);
        }
        if (book != null) {
            System.out.println("Book found: " + book);
        } else {
            System.out.println("Book not found.");
        }
        scanner.close();
    }
}