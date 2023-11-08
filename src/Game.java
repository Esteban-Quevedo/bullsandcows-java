/**
 * Application purpose:
 * Author: Camilo, Esteban, Vishal
 * Date: November 8th of 2023
 */

// Importing the required libraries
import java.util.Random;

public class Game {
    private int gameMode; // Game Mode  1.Free Mode 2.Campaign Mode
    private String gameModeName; // String that contain the game Mode Name
    private int gameLevel; // Integer that save the game Level
    private Player playerObj; // Save the Player object
    private Level levelObj; // Save the level object

    // Method that returns the Game Mode Name according to the gameMode var
    String getGameModeName(int game_mode){
        if (game_mode == 2){
            gameModeName = "Campaign Mode"; // When Option is 2 then the name will be Campaign Mode
        }
        else {
            gameModeName = "Free Mode"; // When Option is different of 2 then the name will be Free Mode
        }
        return gameModeName;
    }

    // Method that check if a number already exists in the code array
    private static boolean checkNumExist(int[] array, int num) {
        for (int element : array) {
            if (element == num) {
                return true;
            }
        }
        return false;
    }

    // Method that create the code using the Random Object.
    int[] getCode(int levelNum){
        // Create a nre Random objet
        Random random = new Random();
        // Create a new array
        int[] gameCode = new int[levelNum+1];

        // Fill the gameCode array with random numbers (with the constraint that it cannot have a repeated number)
        for (int i=0; i<gameCode.length; i++){
            int tempNum = random.nextInt(9);
            // Loop that get a number until it is not repeated
            while (!checkNumExist(gameCode, tempNum)){ // If the number already exist get a new random number
                tempNum = random.nextInt(9);
            }
            gameCode[i] = tempNum; // Assign the random number to the array into the i position
        }
        return gameCode;
    }

    // Constructor class that receives (int game Mode, Player playerObj, and Level levelObj)
    Game(int gameMode, Player playerObj, Level levelObj){
        this.gameMode = gameMode;
        this.levelObj = levelObj;
        this.playerObj = playerObj;
        this.gameModeName = getGameModeName(gameMode);
    }
}
