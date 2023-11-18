/**
 * Application purpose: This app is a Java-based game that implements the classic Bulls and Cows guessing game.
 * The game is played through the terminal, providing an interactive experience for the user.
 * This main class:
 * - Creates a player
 * - Creates a Level
 * - Initialize game instance
 * - Run Game
 * Date: November 8th of 2023
 */

// Importing the required libraries
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
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

        // declaring the game mode var
        int gameMode;
        // Reading Game Mode
        do {
            System.out.printf("\nwelcome %s, please select the Game Mode.\n", user_name);
            System.out.println("1. Free Mode (You can directly choose the desired level to play).");
            System.out.println("2. Campaign Mode (Starts at Level 1 and progresses through the levels).");
            gameMode = scan.nextInt();
        } while (gameMode < 1 || gameMode > 2);

        // declaring the level num var
        int levelNum;
        // Check if the game Mode is Campaign
        if (gameMode == 2) {
            levelNum = 1; // Assign the level 1 to start the game
        } else { // If not is campaign it means that it is the free mode
            // Getting a valid user level input
            do {
                System.out.println("Which level do you want to play (1-5) ?.");
                levelNum = scan.nextInt();
            } while (levelNum < 1 || levelNum > 5);
        }

        // declaring the difficulty num
        int gameDifficulty;
        // Reading Game Difficulty
        do {
            System.out.println("Now please select the Game Difficulty.");
            System.out.println("1. Amateur.");
            System.out.println("2. Normal.");
            System.out.println("3. Expert.");
            gameDifficulty = scan.nextInt();
        } while (gameDifficulty < 1 || gameDifficulty > 3);

        boolean gameOver = false;

        do {
            // Create a level
            Level levelObj = new Level(levelNum);

            // Filling player data
            playerObj.setLevel(levelNum);

            // Create a Game
            Game gameObj = new Game(gameMode, gameDifficulty, levelObj);

            // Get the code number
            int[] gameCode = levelObj.getTargetCombination();

            // Create a flag to check if the level is done
            Boolean levelPassed = false;

            System.out.print("\n\n\n***************************************************************");
            System.out.printf("\nSTARTING LEVEL: %S", levelObj.getLevel());
            System.out.println("\n***************************************************************");

            // Game loop while the user has lives and the level is not done
            do {
                // initialize both Bulls and Cows variables
                int bullsNum;
                int cowsNum;

                // Create a new array to save the user guess
                int[] userGuessCode = new int[levelObj.getLevel() + 1];
                int userGuessCodeLength = userGuessCode.length;
                // Fill the userGuessCode array to compare with the gameCode
                for (int i = 0; i < userGuessCodeLength; i++) {
                    int guessNum;
                    do {
                        System.out.printf("\nWhich number (From 0-9 [-1 to exit]) do you want to put in the position %s\n", i + 1);
                        guessNum = scan.nextInt();
                    } while (guessNum < -1 || guessNum > 9);
                    if (guessNum == -1){
                        // Terminate the program with a status of 0 (success)
                        System.exit(0);
                    }
                    userGuessCode[i] = guessNum;
                }

                // Check the user input
                int[] tempBullsAndCows = gameObj.checkGuess(gameCode, userGuessCode);
                bullsNum = tempBullsAndCows[0];
                cowsNum = tempBullsAndCows[1];

                // Check if the user have the correct code
                if (bullsNum == userGuessCodeLength) {
                    // Print that the level was passed
                    System.out.print("\n\n\n***************************************************************");
                    System.out.printf("\nWell done %s, the level is complete !!!", playerObj.getName());
                    System.out.printf("\nYour Score was: %s", gameObj.getTotalScore());
                    System.out.println("\n***************************************************************");
                    playerObj.setScore(playerObj.getScore()+gameObj.getTotalScore());
                    levelPassed = true;
                    break;
                }

                // Execute the Score, lives and attempts calculations
                gameObj.reCalcScore();
                boolean isAlive = gameObj.checkStillAlive();
                if (!isAlive) {
                    System.out.println("******Game over, better luck next time!!!******");
                    scan.close();
                    gameOver = true;
                    break;
                }

                // Printing the input
                System.out.printf("\n%s - Mode: %s - Difficulty: %s - Level: %s Lives: %s and Attempts: %s", playerObj.getName(),
                        gameObj.getGameModeName(), gameObj.getGameDifficultyName(), levelObj.getLevel(), gameObj.getLivesNum(), gameObj.getTotalAttempts());
                System.out.printf("\n%s, your Result is:", playerObj.getName());
                for (int j : userGuessCode) {
                    System.out.printf(" [%s] \t", j);
                }
                // Printing the result
                System.out.printf("\nBulls: %s and Cows: %s", bullsNum, cowsNum);

            } while (!levelPassed);

            if (levelPassed) {

                if (gameMode == 2 && levelNum <5){
                    levelNum++;
                }
                else {
                    System.out.print("\n\n\n***************************************************************");
                    System.out.print("\n************************ GAME COMPLETE *************************");
                    System.out.printf("\n**** Player Name: %s  ****", playerObj.getName());
                    System.out.printf("\n**** Mode: %s   Difficulty: %s  ****", gameObj.getGameModeName(), gameObj.getGameDifficultyName());
                    System.out.printf("\n**** Rem lives: %s  Final Score: %s  ****", gameObj.getLivesNum(), playerObj.getScore());
                    System.out.println("\n***************************************************************");
                    gameOver = true;
                }

            }
        } while (!gameOver);

        // Closing The scanner
        scan.close();

    }
}
