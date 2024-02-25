import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        playGuessTheNumber();
    }

    public static void playGuessTheNumber() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Guess the Number game!");
        int lowerLimit = 1;
        int upperLimit = 100;
        int targetNumber = random.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;

        int attemptsLimit = 7; 
        int attempts = 0;
        int roundsWon = 0;

        boolean playAgain = true;
        while (playAgain) {
            System.out.printf("%nGuess the number between %d and %d:%n", lowerLimit, upperLimit);

            while (attempts < attemptsLimit) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == targetNumber) {
                    System.out.printf("Congratulations! You guessed the correct number %d in %d attempts!%n", targetNumber, attempts);
                    roundsWon++;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (attempts == attemptsLimit) {
                System.out.printf("Sorry, you've reached the maximum number of attempts. The correct number was %d.%n", targetNumber);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            if (!playAgainInput.equals("yes")) {
                playAgain = false;
            } else {
                targetNumber = random.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
                attempts = 0;
            }
        }

        System.out.printf("%nGame Over! You won %d round(s).%n", roundsWon);
    }
}
