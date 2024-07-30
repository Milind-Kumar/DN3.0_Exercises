import java.util.Scanner;

public class DecoratorPatternTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Notifier notifier = new EmailNotifier();
        
        System.out.println("Do you want to add SMS notifications? (yes/no)");
        String smsChoice = scanner.nextLine();
        if (smsChoice.equalsIgnoreCase("yes")) {
            notifier = new SMSNotifierDecorator(notifier);
        }
        
        System.out.println("Do you want to add Slack notifications? (yes/no)");
        String slackChoice = scanner.nextLine();
        if (slackChoice.equalsIgnoreCase("yes")) {
            notifier = new SlackNotifierDecorator(notifier);
        }
        
        System.out.println("Enter the message to send:");
        String message = scanner.nextLine();
        
        notifier.send(message);

        scanner.close();
    }
}
