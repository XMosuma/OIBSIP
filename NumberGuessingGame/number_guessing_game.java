import java.util.Random;
import java.util.Scanner;

public class number_guessing_game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int generatedNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        int maxAttempts = 3;
        int attempts = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have generated a number between " + lowerBound + " and " + upperBound + ". Try to guess it!");

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();

            if (userGuess == generatedNumber) {
                System.out.println("Congratulations! You guessed the number!");
                break;
            } else if (userGuess < generatedNumber) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }

            attempts++;
        }

        if (attempts == maxAttempts) {
            System.out.println("Sorry, you've run out of attempts. The correct number was: " + generatedNumber);
        }

        scanner.close();
    }
}
