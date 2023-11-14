import java.util.Scanner;
import java.util.Random;

public class number_guessing_game {
    public static void main(String args[]) {
        generateRandom();
    }

    public static void generateRandom() {
        Random rand = new Random();

        // generating a random number between 0-10
        int randomNum = rand.nextInt(11);

        // calling guess method
        guess(randomNum);
    }

    public static void guess(int randomNum) {
        // creating an object of scanner class
        Scanner in = new Scanner(System.in);

        // Welcome message
        System.out.println("");
        System.out.println("Number Guessing Game");
        System.out.println("Guess a number between 0-10");
        int guess = in.nextInt();
        System.out.println("");

        // input validation
        while (guess < 0 || guess > 10) {
            System.out.println("Guess a number between 0-10: ");
            guess = in.nextInt();
            System.out.println("");
        }

        // try again until you guess the correct number
        int tries = 0;
        while (guess != randomNum) {
            tries++;
            System.out.println("Wrong Guess!");
            System.out.println("Guess Again: ");
            guess = in.nextInt();
            System.out.println("");

            // input validation
            while (guess < 0 || guess > 10) {
                System.out.println("Guess a number between 0-10: ");
                guess = in.nextInt();
                System.out.println("");
            }
        }
        // Game Won
        System.out.println("Correct Answer, You Won!");
        System.out.println("Wrong Tries: " + tries);
        System.out.println("");

        // play again or exit
        System.out.println("Press 1 to Play Again");
        System.out.println("Press 0 to Exit");
        int choice = in.nextInt();

        if (choice == 1) {
            generateRandom();
        } else {
            return;
        }
    }
}
