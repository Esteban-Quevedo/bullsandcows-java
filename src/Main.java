/**
 * Application purpose: This app is a Java-based game that implements the classic Bulls and Cows guessing game.
 * The game is played through the terminal, providing an interactive experience for the user.
 * This main class:
 * - Create player
 * - Initialize game instance
 * - Run Game
 * Author: Camilo, Esteban, Vishal
 * Date: November 8th of 2023
 */

// Importing the required libraries
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Creating a new Scanner
        Scanner scan = new Scanner(System.in);

        // Ask the user if the user want to create a new record
        System.out.println("Welcome to Bulls and Cows 3.0 Game.");
        System.out.println("Lets Create your player user.");

        // Reading player data
        System.out.println("Please introduce your Nick Name.");
        String user_name = scan.nextLine().toUpperCase();

        // Create a player
        Player playerObj = new Player(user_name);

        // Reading Game Mode
        System.out.printf("\nwelcome %s, please select the Game Mode.\n", user_name);
        System.out.println("1. Free Mode (You can directly choose the desired level to play).");
        System.out.println("2. Campaign Mode (Starts at Level 1 and progresses through the levels).");
        int gameMode = scan.nextInt();

        // Create a level control initialized by Zero
        int levelNum = 0;

        // Check if the game Mode is Campaign
        if(gameMode == 2){
            levelNum=1; // Assign the level 1 to start the game
        } else { // If not is campaign it means that it is the free mode
            while(levelNum==0) { // Controls that if the user does not give a valid input it will continue asking until get a valid one.
                // Getting the user level input
                System.out.println("Which level do you want to play (1-5) ?.");
                int levelTemp = scan.nextInt();
                // If the input is valid assign the level number and break the loop
                if (levelTemp > 0 && levelTemp < 6) {
                    levelNum = levelTemp; // Assign the input level to start the game
                } else {
                    // Pint an error message when a wrong input is received and executes the loop again
                    System.out.println("Error, please enter a valid input (from 1 to 5).");
                }
            }
        }

        // Create a level
        Level levelObj = new Level(levelNum);

        // Create a Game
        Game gameObj = new Game(gameMode, playerObj, levelObj);

        // Get the code number
        int[] gameCode = gameObj.getCode(levelNum);

        // Get the number of lives to this game level
        int livesNum = levelObj.getLivesNum();

        // Create a tries counter
        int triesCounter = 0;
        // Create a flag to check if the level is done
        Boolean levelPassed = false;

        // Game loop while the user has lives and the level is not done
        while(livesNum>0 && !levelPassed){
            // Create a new array to save the user guess
            int[] userGuessCode = new int[levelNum+1];
            int userGuessCodeLength = userGuessCode.length;
            // Fill the userGuessCode array to compare with the gameCode
            for (int i=0; i<userGuessCodeLength; i++){
                System.out.printf("\nWhich number do you want to put in the %s position\n",i+1);
                userGuessCode[i] = scan.nextInt();
            }

            // Increasing tries number
            triesCounter++;

            // Check the user input
            gameObj.checkGuess(userGuessCode, livesNum, triesCounter);

            // Get the user game data (Lives, Bulls, and Cows)
            livesNum = levelObj.getLivesNum();
            bullsNum = levelObj.getLivesNum();
            cowsNum = levelObj.getLivesNum();

            // Printing the input
            System.out.println("your Result is:");
            for (int i=0; i<userGuessCodeLength; i++){
                System.out.printf(" %s \t",i+1);
                userGuessCode[i] = scan.nextInt();
            }
            // Printing the result
            System.out.printf("\nBulls:%s an Cows:%s\n", bullsNum, cowsNum);
            System.out.printf("\nLives:%s \n", livesNum);

            // Check if the user have the correct code
            if (bullsNum == userGuessCodeLength){
                // Print that the level was passed
                System.out.println("Well done, the level is complete !!!");
            }
        }
    }
}