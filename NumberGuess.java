import java.util.Random;
import java.util.Scanner;

public class NumberGuess {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random random = new Random();
        int minVal = 1;
        int maxVal = 100;
        int maxAttempts = 5;
        boolean play = true;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (play) {
            int generatedNumber = random.nextInt(maxVal - minVal + 1) + minVal;
            int attempts = 0;
            boolean correctGuess = false;

            System.out.println("A number has been generated between " + minVal + " and " + maxVal + ".");
            System.out.println("You have " + maxAttempts + " attempts to guess the number.");

            while (attempts < maxAttempts && !correctGuess) {
                System.out.print("Enter your guess: ");
                int userGuess = in.nextInt();
                attempts++;

                if (userGuess == generatedNumber) {
                    System.out.println("Congratulations! You guessed the number correctly.");
                    correctGuess = true;
                    score += (maxAttempts - attempts + 1); // Higher score for fewer attempts
                } else if (userGuess < generatedNumber) {
                    System.out.println("Your guess is too low.");
                } else {
                    System.out.println("Your guess is too high.");
                }

                if (!correctGuess && attempts == maxAttempts) {
                    System.out.println("You've used all your attempts. The correct number was " + generatedNumber + ".");
                }
            }

            System.out.println("Your score: " + score);
            System.out.print("Do you want to play another round? (yes/no): ");
            play = in.next().equalsIgnoreCase("yes");
        }

        System.out.println("Thank you for playing! Your final score is: " + score);
        in.close();
    }
}
