import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        String playAgain;

        do {
            int numberToGuess = rand.nextInt(100) + 1;
            int guess;
            int attempts = 0;
            final int MAX_ATTEMPTS = 10;

            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("Guess a number between 1 and 100. You have 10 attempts:");

            while (attempts < MAX_ATTEMPTS) {
                System.out.print("Enter your guess: ");

                if (!scanner.hasNextInt()) {
                    System.out.println("Please enter a valid number between 1 and 100.");
                    scanner.next(); // clear invalid input
                    continue;
                }

                guess = scanner.nextInt();
                attempts++;

                if (guess < 1 || guess > 100) {
                    System.out.println("Number out of range! Try again.");
                } else if (guess == numberToGuess) {
                    System.out.println("🎉 Congratulations! You guessed the number in " + attempts + " attempts!");
                    break;
                } else if (guess < numberToGuess) {
                    System.out.println("Too low! Attempts left: " + (MAX_ATTEMPTS - attempts));
                } else {
                    System.out.println("Too high! Attempts left: " + (MAX_ATTEMPTS - attempts));
                }
            }

            if (attempts == MAX_ATTEMPTS) {
                System.out.println("❌ You've used all 10 attempts! The number was: " + numberToGuess);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.next();

        } while (playAgain.equalsIgnoreCase("yes"));

        System.out.println("Thanks for playing! Goodbye 👋");
        scanner.close();
    }
}
