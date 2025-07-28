import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int totalPoints = 0;
        int roundNumber = 1;
        boolean continuePlaying;

        System.out.println("=== Welcome to Guess the Number! ===");

        do {
            int target = random.nextInt(100) + 1;
            int triesLeft = 7;
            boolean isGuessed = false;

            System.out.println("\n[ Round " + roundNumber + " ] Try to guess the number between 1 and 100.");

            while (triesLeft > 0) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                triesLeft--;

                if (userGuess == target) {
                    System.out.println("🎉 Great job! You nailed it.");
                    int roundScore = triesLeft + 1;
                    totalPoints += roundScore;
                    System.out.println("You scored: " + roundScore + " points.");
                    isGuessed = true;
                    break;
                } else if (userGuess < target) {
                    System.out.println("Too small! Try something bigger.");
                } else {
                    System.out.println("Too large! Try a smaller one.");
                }

                if (triesLeft > 0) {
                    System.out.println("Remaining tries: " + triesLeft);
                }
            }

            if (!isGuessed) {
                System.out.println("No more tries! The correct number was: " + target);
            }

            System.out.println("Current total score: " + totalPoints);
            System.out.print("Want to play another round? (yes/no): ");
            String choice = scanner.next().toLowerCase();
            continuePlaying = choice.equals("yes");
            roundNumber++;

        } while (continuePlaying);

        System.out.println("=== Game Over! Your final score: " + totalPoints + " ===");
        scanner.close();
    }
}
