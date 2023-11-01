# bullsandcows-java
This repo contains a Java application that brings the classic Bulls and Cows game. It features interactive menus and various play modes to provide an engaging gaming experience.


## Project Description:

This project is a Java-based game that implements the classic Bulls and Cows guessing game. The game is played through the terminal, providing an interactive experience for the user.
The game begins by prompting the user to create a profile. Once a user is created, they are given the option to choose between two kinds of games:

1.	Campaign Mode: In this mode, the user starts at Level 1 and progresses through the levels, increasing in difficulty. The user has three lives to complete each level.

2.	Free Mode: In this mode, the user can directly choose the desired level to play.

Each level presents a different challenge, with Level 1 having only 2 numbers to guess, and Level 5 requiring the player to guess a combination of 6 numbers.
Additionally, the player must select a game mode which determines the number of tries allowed for each level:

### Amateur Mode:
•	Level 1: 6 tries per life.
•	Level 2: 8 tries per life.
•	Level 3: 10 tries per life.
•	Level 4: 12 tries per life.
•	Level 5: 14 tries per life.

### Normal Mode:
•	Level 1: 4 tries per life.
•	Level 2: 6 tries per life.
•	Level 3: 8 tries per life.
•	Level 4: 10 tries per life.
•	Level 5: 12 tries per life.

### Expert Mode:
•	Level 1: 2 tries per life.
•	Level 2: 4 tries per life.
•	Level 3: 6 tries per life.
•	Level 4: 8 tries per life.
•	Level 5: 10 tries per life.



## Game Details:

1. Each number in the combination is represented by a box, allowing the player to input their guesses.

2.After each guess, the program provides feedback in the form of "Bulls" and "Cows":

2.1.	Bulls refer to the correct code in the correct position.
2.2.	Cows refer to the correct code in the wrong position.

3. A visual dashboard is displayed throughout the game, showing the following information:

3.1.	Remaining lives (a heart Icon per live will be displayed).

3.2.	Current score (determined by starting points for each level: Level 1 - 1000 points, Level 2 - 2000 points, Level 3 - 3000 points, Level 4 - 4000 points, Level 5 - 5000 points). The score decreases as the number of tries increases.

3.3.	The player's current progress, including the level, number of attempts, and previous guesses.


## Game Structure

The program is structured using three main classes, each equipped with their own getters, setters, and methods, along with the required conditionals, loops, and logic to guarantee the game's structure and operation:

1.	Player Class: This class defines the attributes and behaviors of a player, allowing for the creation and management of user profiles.

2.	Level Class: This class encapsulates the various difficulty levels, handles points calculation, generates random combinations for the player to guess, and manages the game progress.

3.	Game Class: This final class orchestrates the game experience. It creates a new player, assigns a level, and tracks the number of attempts, the player's previous guesses, and the number of bulls and cows achieved. In the event that the player does not reach the specified number of attempts, it handles end-game scenarios.
