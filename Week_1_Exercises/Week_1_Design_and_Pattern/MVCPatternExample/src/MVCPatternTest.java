import java.util.Scanner;

public class MVCPatternTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Student model = new Student("", "", "");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);

        System.out.println("Enter student name:");
        controller.setStudentName(scanner.nextLine());

        System.out.println("Enter student ID:");
        controller.setStudentId(scanner.nextLine());

        System.out.println("Enter student grade:");
        controller.setStudentGrade(scanner.nextLine());

        controller.updateView();

        scanner.close();
    }
}
