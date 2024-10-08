import java.util.Scanner;

public class SingletonPatternTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Logger logger = Logger.getInstance();

        System.out.println("Enter a message to log:");
        String message = scanner.nextLine();

        logger.log(message);

        // Verify Singleton instance
        Logger anotherLogger = Logger.getInstance();
        System.out.println("Are both logger instances the same? " + (logger == anotherLogger));

        scanner.close();
    }
}
