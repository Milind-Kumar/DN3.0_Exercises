import java.util.Scanner;

public class AdapterPatternTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        OldPaymentGateway oldPaymentGateway = new OldPaymentGateway();
        PaymentProcessor paymentProcessor = new PaymentGatewayAdapter(oldPaymentGateway);
        
        System.out.println("Enter payment amount:");
        double amount = scanner.nextDouble();
        
        paymentProcessor.processPayment(amount);

        scanner.close();
    }
}