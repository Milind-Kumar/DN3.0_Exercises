
public class PaymentGatewayAdapter implements PaymentProcessor {
    private OldPaymentGateway oldPaymentGateway;

    public PaymentGatewayAdapter(OldPaymentGateway oldPaymentGateway) {
        this.oldPaymentGateway = oldPaymentGateway;
    }

    @Override
    public void processPayment(double amount) {
        oldPaymentGateway.makePayment(amount);
    }
}
