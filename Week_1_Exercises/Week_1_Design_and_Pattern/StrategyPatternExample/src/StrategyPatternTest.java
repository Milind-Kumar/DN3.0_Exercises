import java.util.Scanner;

public class StrategyPatternTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        PaymentContext context = new PaymentContext();
        
        System.out.println("Select payment method (creditcard/paypal):");
        String method = scanner.nextLine();
        
        if (method.equalsIgnoreCase("creditcard")) {
            context.setPaymentStrategy(new CreditCardPayment());
        } else if (method.equalsIgnoreCase("paypal")) {
            context.setPaymentStrategy(new PayPalPayment());
        } else {
            System.out.println("Invalid payment method.");
            scanner.close();
            return;
        }
        
        System.out.println("Enter the amount to pay:");
        double amount = scanner.nextDouble();
        
        context.pay(amount);

        scanner.close();
    }
}
