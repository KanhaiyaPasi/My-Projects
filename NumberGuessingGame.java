import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        int range = 100;
        int numberToGuess = random.nextInt(range) + 1;
        int maxAttempts = 5;
        int attempts = 0;
        int score = 0;
        boolean playAgain = true;

        while (playAgain) {
            System.out.println("Guess a number between 1 and " + range + ":");
            while (attempts < maxAttempts) {
                int guess = input.nextInt();
                attempts++;
                if (guess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    score += maxAttempts - attempts + 1;
                    break;
                } else if (guess < numberToGuess) {
                    System.out.println("Too low. Guess again:");
                } else {
                    System.out.println("Too high. Guess again:");
                }
            }
            if (attempts == maxAttempts) {
                System.out.println("Sorry, you ran out of attempts. The number was " + numberToGuess + ".");
            }
            System.out.println("Your score is " + score + ".");
            System.out.println("Do you want to play again? (yes/no)");
            String playAgainAnswer = input.next();
            if (playAgainAnswer.equalsIgnoreCase("no")) {
                playAgain = false;
            } else {
                numberToGuess = random.nextInt(range) + 1;
                attempts = 0;
            }
        }
        System.out.println("Thanks for playing!");
    }
}