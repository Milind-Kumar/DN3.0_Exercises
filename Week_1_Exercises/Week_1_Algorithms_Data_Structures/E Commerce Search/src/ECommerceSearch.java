import java.util.*;

public class ECommerceSearch {
    private Product[] products;

    public ECommerceSearch(Product[] products) {
        this.products = products;
    }

    public int linearSearch(String productName) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].getProductName().equalsIgnoreCase(productName)) {
                return i;
            }
        }
        return -1;
    }

    public int binarySearch(String productName) {
        Arrays.sort(products, Comparator.comparing(Product::getProductName));
        int left = 0, right = products.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int compare = products[mid].getProductName().compareToIgnoreCase(productName);
            if (compare == 0) {
                return mid;
            } else if (compare < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Product[] products = new Product[3];

        for (int i = 0; i < products.length; i++) {
            System.out.println("Enter details for product " + (i + 1) + ":");
            System.out.print("Product ID: ");
            String productId = scanner.nextLine();
            System.out.print("Product Name: ");
            String productName = scanner.nextLine();
            System.out.print("Category: ");
            String category = scanner.nextLine();
            products[i] = new Product(productId, productName, category);
        }

        ECommerceSearch es = new ECommerceSearch(products);
        System.out.println("Enter product name to search: ");
        String searchName = scanner.nextLine();

        System.out.println("Linear Search:");
        int index = es.linearSearch(searchName);
        System.out.println(index != -1 ? products[index] : "Product not found");

        System.out.println("Binary Search:");
        index = es.binarySearch(searchName);
        System.out.println(index != -1 ? products[index] : "Product not found");

        scanner.close();
    }
}