import java.util.Scanner;

public class CommandPatternTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Light light = new Light();
        RemoteControl remote = new RemoteControl();
        
        System.out.println("Enter command (on/off):");
        String command = scanner.nextLine();
        
        if (command.equalsIgnoreCase("on")) {
            remote.setCommand(new LightOnCommand(light));
        } else if (command.equalsIgnoreCase("off")) {
            remote.setCommand(new LightOffCommand(light));
        } else {
            System.out.println("Invalid command.");
            scanner.close();
            return;
        }
        
        remote.pressButton();

        scanner.close();
    }
}
