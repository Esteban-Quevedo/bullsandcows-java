import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BullsCows extends JFrame{
    private JPanel globalPanel;
    private JLabel titleLabel;
    private JButton submitBtn;
    private JPanel submitPanel;
    private JTextField nameTxtField;
    private JLabel nameLabel;
    private JPanel namePanel;
    private JPanel gameModePanel;
    private JRadioButton campaignModeBtn;
    private JRadioButton freeModeBtn;
    private JComboBox selectLevelCombo;
    private JPanel selectLevelPanel;
    private JButton gameModeBtn;
    private JPanel gameModeBtnPanel;
    private JRadioButton normalDifficultyBtn;
    private JRadioButton amateurDifficultyBtn;
    private JRadioButton expertDifficultyBtn;
    private JPanel gameDifficultyPanel;
    private JButton gameDifficultyBtn;
    private JPanel gameDifficultyBtnPanel;


    private String playerName = "";
    private int gameMode = 1;
    private int gameDifficulty = 1;
    private String selectedLevel = "1";
    private int levelInteger = 1;

    private int[] gameCode;

    private boolean levelPassed = false;

    private boolean isGameOver = false;

    public BullsCows() {

        this.gameDifficultyPanel.setVisible(false);
        this.gameDifficultyBtnPanel.setVisible(false);
        this.gameModePanel.setVisible(false);
        this.gameModeBtnPanel.setVisible(false);
        this.selectLevelPanel.setVisible(false);

        Player playerObj = new Player(playerName);
        Level levelObj = new Level();

        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerName = nameTxtField.getText();
                playerObj.setName(playerName);
                System.out.println("Entered name: " + playerName);

                namePanel.setVisible(false);
                submitPanel.setVisible(false);
                gameModePanel.setVisible(true);
                gameModeBtnPanel.setVisible(true);

                titleLabel.setText("Select a Game Mode");
            }
        });

        gameModeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameModePanel.setVisible(false);
                gameModeBtnPanel.setVisible(false);

                // Check which radio button is selected
                if (freeModeBtn.isSelected()) {
                    // Game game = new Game(1, );
                    gameMode = 1;

                    selectLevelPanel.setVisible(true);

                    titleLabel.setText("Select a Level");
                } else if (campaignModeBtn.isSelected()) {
                    gameMode = 2;

                    gameDifficultyPanel.setVisible(true);
                    gameDifficultyBtnPanel.setVisible(true);

                    titleLabel.setText("Select Game Difficulty");
                }
            }
        });

        selectLevelCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedLevel = (String) selectLevelCombo.getSelectedItem();

                levelInteger = Integer.parseInt(selectedLevel);
                levelObj.setLevel(levelInteger);
                levelObj.setTargetCombination(levelObj.generateRandomCombination());

                playerObj.setLevel(levelInteger);

                System.out.println("Selected Level: " + selectedLevel);

                selectLevelPanel.setVisible(false);

                titleLabel.setText("Select Game Difficulty");

                gameDifficultyPanel.setVisible(true);
                gameDifficultyBtnPanel.setVisible(true);
            }
        });
        gameDifficultyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameDifficultyPanel.setVisible(false);
                gameDifficultyBtnPanel.setVisible(false);

                // Check which radio button is selected
                if (amateurDifficultyBtn.isSelected()) {
                    gameDifficulty = 1;
                } else if (normalDifficultyBtn.isSelected()) {
                    gameDifficulty = 2;

                } else if (expertDifficultyBtn.isSelected()) {
                    gameDifficulty = 3;

                }
                Game gameObj = new Game(gameMode, gameDifficulty, levelObj);
                gameCode = levelObj.getTargetCombination();
                System.out.println("Game difficulty: " + gameDifficulty);

                titleLabel.setText("Bulls & Cows | Level " + selectedLevel);
            }
        });

        // Filling player data
        //Player playerObj = new Player(playerName);
        //layerObj.setLevel(levelInteger);

        // Create a level
        //Level levelObj = new Level();
        //levelInteger = Integer.parseInt(selectedLevel);
        //levelObj.setLevel(levelInteger);

        // Create a Game
        //Game gameObj = new Game(gameMode, gameDifficulty, levelObj);

        // Get the code number
        //int[] gameCode = levelObj.getTargetCombination();
    }

    public static void main(String[] args){
        BullsCows ui = new BullsCows();
        ui.setContentPane(ui.globalPanel);
        ui.setTitle("Bulls and Cows");
        ui.setSize(480, 800);
        ui.setVisible(true);
        ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
