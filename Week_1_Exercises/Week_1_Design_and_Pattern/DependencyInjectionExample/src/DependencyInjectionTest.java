import java.util.Scanner;

public class DependencyInjectionTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter game to play (football/cricket):");
        String gameType = scanner.nextLine();
        
        Game game;
        if (gameType.equalsIgnoreCase("football")) {
            game = new Football();
        } else if (gameType.equalsIgnoreCase("cricket")) {
            game = new Cricket();
        } else {
            System.out.println("Invalid game type.");
            scanner.close();
            return;
        }
        
        game.play();

        scanner.close();
    }
}
