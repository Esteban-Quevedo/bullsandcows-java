/**
 * Application purpose: Game Class with its respective Constructors, Setters, Getters, and Methods.
 * Date: November 8th of 2023
 */

public class Game {
    // Method that returns the Game Mode Name according to the gameMode var
    private String calcGameModeName() {
        if (gameMode == 2) {
            return "Campaign"; // When Option is 2 then the name will be Campaign Mode
        } else {
            return "Free"; // When Option is different of 2 then the name will be Free Mode
        }
    }

    // Method that returns the Game Mode Name according to the gameMode var
    private String calcGameDifficultyName() {
        return switch (gameDifficulty) {
            case 3 -> "Expert"; // When Option is 3 then the name will be Expert Difficulty
            case 2 -> "Normal"; // When Option is 2 then the name will be Normal Difficulty
            default -> "Amateur"; // When Option is different of 3 and 2 then the name will be Amateur Difficulty
        };
    }

    // Method that returns the Game Mode Name according to the gameMode var
    private int calcTotalScore() {
        return levelObj.getLevel() * 1000;
    }

    // Method that returns the Game Mode Name according to the gameMode var
    private int calcMaxTries() {
        int concatModeDifficulty = (gameDifficulty * 10) + levelObj.getLevel();
        return switch (concatModeDifficulty) {
            case 11, 22, 33 -> 6;
            case 12, 23, 34 -> 8;
            case 13, 24, 35 -> 10;
            case 14, 25 -> 12;
            case 15 -> 14;
            case 21, 32 -> 4;
            case 31 -> 2;
            default -> 9;
        };
    }

    // Variables Definition
    private final int gameMode; // Game Mode  1.Free Mode, and 2.Campaign Mode
    private final String gameModeName; // String that contain the game Mode Name
    private final int gameDifficulty; // Game Mode 1.Amateur, 2.Normal, and 3.Expert
    private final String gameDifficultyName; // String that contain the game Difficulty Name
    private final Level levelObj; // Save the level object
    private int livesNum; // Save the number of lives
    private final int maxTriesNum; // Save the Max number of tries
    private int totalAttempts; // Save the total number of attempts
    private int totalScore; // Save the total Score of the game

    // Default Constructor
    Game() {
        this.gameMode = 0;
        this.gameModeName = "";
        this.gameDifficulty = 0;
        this.gameDifficultyName = "";
        this.levelObj = null;
        this.livesNum = 0;
        this.maxTriesNum = 0;
        this.totalAttempts = 0;
        this.totalScore = 0;
    }

    // Constructor which receives (int game Mode, int gameDifficulty, Player playerObj, and Level levelObj)
    Game(int gameMode, int gameDifficulty, Level levelObj) {
        this.gameMode = gameMode;
        this.gameModeName = calcGameModeName();
        this.gameDifficulty = gameDifficulty;
        this.gameDifficultyName = calcGameDifficultyName();
        this.levelObj = levelObj;
        this.livesNum = 3;
        this.maxTriesNum = calcMaxTries();
        this.totalAttempts = 0;
        this.totalScore = calcTotalScore();
    }

    // Getters Definition.
    public int getGameMode() {
        return gameMode;
    }

    public String getGameModeName() {
        return gameModeName;
    }

    public int getGameDifficulty() {
        return gameDifficulty;
    }

    public String getGameDifficultyName() {
        return gameDifficultyName;
    }

    public Level getLevelObj() {
        return levelObj;
    }

    public int getLivesNum() {
        return livesNum;
    }

    public int getMaxTriesNum() {
        return maxTriesNum;
    }

    public int getTotalAttempts() {
        return totalAttempts;
    }

    public int getTotalScore() {
        return totalScore;
    }

    // Setters Definition
    public void setLivesNum(int livesNum) {
        this.livesNum = livesNum;
    }

    public void setTotalAttempts(int totalAttempts) {
        this.totalAttempts = totalAttempts;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }


    // Check Guess method definition
    public int[] checkGuess(int[] originalCode, int[] enteredCode) {
        int[] bullsAnCows = new int[2]; // Creating an array to save the Bulls and Cows values (respectively)
        for (int i = 0; i < enteredCode.length; i++) {
            if (enteredCode[i] == originalCode[i]) {
                bullsAnCows[0]++;
            } else {
                for (int num : originalCode) {
                    if (num == enteredCode[i]) {
                        bullsAnCows[1]++;
                    }
                }
            }
        }
        return bullsAnCows;
    }

    // Re-calculate Score
    public void reCalcScore() throws ArithmeticException {
        int numToDecrease = (levelObj.getLevel() * 1000) / (maxTriesNum * 3);
        totalScore -= numToDecrease;
    }

    public boolean checkStillAlive() {
        // Increase 1 attempt to total attempts
        totalAttempts++;
        // Check if total attempts have been exceeded
        if (totalAttempts >= maxTriesNum) {
            this.totalAttempts = 0; // Reset total Attempts
            this.livesNum--; // Subtract 1 live
        }
        // Check if there are available lives
        return livesNum > 0;
    }
}
