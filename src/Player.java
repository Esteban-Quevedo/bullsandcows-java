/**
 * Application purpose: Player Class with its respective Constructors, Setters, Getters, and Methods.
 * Date: November 8th of 2023
 */

// Player class definition.
public class Player {

    // Variables Definition
    private String name;
    private int level;
    private int score;

    // Default constructor
    Player(){
        this.name = "";
        this.level = 0;
        this.score = 0;
    }

    // Constructor that takes 4 (four) arguments.
    Player( String name){
        this.name = name;
        this.level = 0;
        this.score = 0;
    }

    // Constructor that takes 4 (four) arguments.
    Player( String name, int level, int score){
        this.name = name;
        this.level = level;
        this.score = score;
    }

    // Getters Definition.
    public String getName() {return name;}
    public int getLevel() {return level;}
    public int getScore() {return score;}


    // Setters Definition.
    public void setName (String name) {this.name = name;}
    public void setLevel(int level) {this.level = level;}
    public void setScore(int score) {this.score = score;}

}
