import java.util.Scanner;

public class ProxyPatternTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the image filename:");
        String filename = scanner.nextLine();
        
        Image image = new ProxyImage(filename);
        image.display();  // Loading from disk
        image.display();  // Loading from cache

        scanner.close();
    }
}