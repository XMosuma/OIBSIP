package OnlineExamination;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Sample user
        User user = new User("username", "password");

        // Sample questions
        Question[] questions = {
            new Question("What is the capital of France?", new String[]{"Paris", "Berlin", "Madrid"}, 1),
            new Question("What is 2 + 2?", new String[]{"3", "4", "5"}, 2),
            // Add more questions as needed
        };

        // Sample exam
        Exam exam = new Exam(questions, 30); // 30 minutes duration

        try (// Sample login
        Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter username: ");
            String enteredUsername = scanner.nextLine();
            System.out.print("Enter password: ");
            String enteredPassword = scanner.nextLine();

            if (user.login(enteredUsername, enteredPassword)) {
                System.out.println("Login successful.");

                // Sample update profile
                System.out.print("Enter new username: ");
                String newUsername = scanner.nextLine();
                System.out.print("Enter new password: ");
                String newPassword = scanner.nextLine();
                user.updateProfile(newUsername, newPassword);

                // Start exam
                exam.startExam();
            } else {
                System.out.println("Invalid username or password.");
            }
        }
    }
}
