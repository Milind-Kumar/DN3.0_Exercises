import java.util.Scanner;

public class ObserverPatternTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        StockMarket stockMarket = new StockMarket();
        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();
        
        stockMarket.register(mobileApp);
        stockMarket.register(webApp);
        
        System.out.println("Enter the stock price:");
        double price = scanner.nextDouble();
        
        stockMarket.setPrice(price);

        scanner.close();
    }
}