/**
 * Application purpose: Game Level with its respective Constructors, Setters, Getters, and Methods.
 * Date: November 8th of 2023
 */

// Importing the required libraries
import java.util.Random;

// Level class definition.
public class Level {

    // Variables Definition
    private int levelNumber;
    private int[] targetCombination;

    // Default constructor
    Level() {
        this.levelNumber = 0;
        this.targetCombination = null;
    }

    // Default constructor
    Level(int levelNumber) throws Exception {
        this.levelNumber = levelNumber;
        this.targetCombination = generateRandomCombination();
    }

    // Constructor that takes 3 (four) arguments.
    Level(int levelNumber, int maxTries, int[] targetCombination) {
        this.levelNumber = levelNumber;
        this.targetCombination = targetCombination.clone();
    }

    // Getters Definition.
    public int getLevel() {
        return levelNumber;
    }

    public int[] getTargetCombination() {
        return targetCombination;
    }

    // Setters Definition.
    public void setLevel(int levelNumber) {
        this.levelNumber = levelNumber;
    }


    public void setTargetCombination(int[] targetCombination) {
        this.targetCombination = targetCombination;
    }


    // Method that check that the number is not duplicated
    private static boolean checkNumberInArray(int[] array, int target) {
        for (int num : array) {
            if (num == target) {
                return true; // Number found in the array
            }
        }
        return false; // Number not found in the array
    }

    // generateRandomCombination method definition
    private int[] generateRandomCombination() {
        // Check a valid Level Number
        if (levelNumber < 1 || levelNumber > 5) {
            throw new ArithmeticException("The level number is not valid (the number must be from 0 to 5).");
        }
        // Creates an empty array
        int[] combinationArray = new int[levelNumber + 1];
        // Creates a new random object
        Random random = new Random();
        // Fills out the combination Array
        for (int i = 0; i < combinationArray.length; i++) {
            int randomNumber;
            do {
                randomNumber = random.nextInt(10); // Generates a random number between 0 and 9
            } while (checkNumberInArray(combinationArray, randomNumber));
            combinationArray[i] = randomNumber;
        }
        return combinationArray;
    }
}
