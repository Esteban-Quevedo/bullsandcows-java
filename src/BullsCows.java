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
    private JPanel gameModeBtnPanel;
    private JRadioButton campaignModeBtn;
    private JRadioButton freeModeBtn;
    private JButton gameModeBtn;
    private JComboBox selectLevelCombo;
    private JPanel selectLevelPanel;
    private JRadioButton normalDifficultyBtn;
    private JRadioButton amateurDifficultyBtn;
    private JRadioButton expertDifficultyBtn;
    private JPanel gameDifficultyPanel;
    private JButton gameDifficultyBtn;
    private JPanel gameDifficultyBtnPanel;
    private JPanel livesPanel;
    private JLabel livesLabel;
    private JPanel bullsAndCowsPanel;
    private JLabel bullsLabel;
    private JLabel cowsLabel;
    private JPanel dataPanel;
    private JComboBox dataComboBox1;
    private JComboBox dataComboBox2;
    private JComboBox dataComboBox3;
    private JComboBox dataComboBox4;
    private JComboBox dataComboBox5;
    private JComboBox dataComboBox6;
    private JPanel submitDataPanel;
    private JButton submitDataBtn;


    private String playerName = "";
    private int gameMode = 1;
    private int gameDifficulty = 1;
    private String selectedLevel = "1";
    private int levelInteger = 1;
    private int[] gameCode;
    private int lives = 0;
    private int bullsNum = 0;
    private int cowsNum = 0;

    public BullsCows() {

        this.gameDifficultyPanel.setVisible(false);
        this.gameDifficultyBtnPanel.setVisible(false);
        this.gameModePanel.setVisible(false);
        this.gameModeBtnPanel.setVisible(false);
        this.selectLevelPanel.setVisible(false);
        this.livesPanel.setVisible(false);
        this.bullsAndCowsPanel.setVisible(false);
        this.dataPanel.setVisible(false);
        this.submitDataPanel.setVisible(false);

        Player playerObj = new Player(playerName);
        Level levelObj = new Level();
        Game gameObj = new Game();

        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logic
                playerName = nameTxtField.getText();
                playerObj.setName(playerName);

                System.out.println("Entered name: " + playerName);

                // UI
                namePanel.setVisible(false);
                submitPanel.setVisible(false);
                //gameModePanel.setVisible(true);
                //gameModeBtnPanel.setVisible(true);
                selectLevelPanel.setVisible(true);

                //titleLabel.setText("Select a Game Mode");
                titleLabel.setText("Select a Level");
            }
        });

        //gameModeBtn.addActionListener(new ActionListener() {
            //@Override
            //public void actionPerformed(ActionEvent e) {
                //gameModePanel.setVisible(false);
                //gameModeBtnPanel.setVisible(false);

                //selectLevelPanel.setVisible(true);

                //titleLabel.setText("Select a Level");

                // Check which radio button is selected
                //if (freeModeBtn.isSelected()) {
                //    // Game game = new Game(1, );
                //    gameMode = 1;

                //    selectLevelPanel.setVisible(true);

                //    titleLabel.setText("Select a Level");
                //} else if (campaignModeBtn.isSelected()) {
                //    gameMode = 2;

                //    gameDifficultyPanel.setVisible(true);
                //    gameDifficultyBtnPanel.setVisible(true);

                //    titleLabel.setText("Select Game Difficulty");
                //}
            //}
        //});

        selectLevelCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logic
                selectedLevel = (String) selectLevelCombo.getSelectedItem();

                levelInteger = Integer.parseInt(selectedLevel);
                levelObj.setLevel(levelInteger);
                levelObj.setTargetCombination(levelObj.generateRandomCombination());

                playerObj.setLevel(levelInteger);

                System.out.println("Selected Level: " + selectedLevel);

                // UI
                selectLevelPanel.setVisible(false);

                titleLabel.setText("Select Game Difficulty");

                gameDifficultyPanel.setVisible(true);
                gameDifficultyBtnPanel.setVisible(true);
            }
        });
        gameDifficultyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logic
                // Check which radio button is selected
                if (amateurDifficultyBtn.isSelected()) {
                    gameDifficulty = 1;
                } else if (normalDifficultyBtn.isSelected()) {
                    gameDifficulty = 2;

                } else if (expertDifficultyBtn.isSelected()) {
                    gameDifficulty = 3;
                }

                //Game gameObj = new Game(gameMode, gameDifficulty, levelObj);
                gameObj.setGameMode(gameMode);
                gameObj.setGameDifficulty(gameDifficulty);
                gameObj.setLevelObj(levelObj);
                gameObj.setMaxTriesNum();
                gameObj.setTotalScore();
                gameObj.setLivesNum(3);

                gameCode = levelObj.getTargetCombination();

                lives = gameObj.getLivesNum();

                System.out.println("Game difficulty: " + gameDifficulty);

                // UI
                gameDifficultyPanel.setVisible(false);
                gameDifficultyBtnPanel.setVisible(false);

                titleLabel.setText("Bulls & Cows | Level " + selectedLevel);

                livesPanel.setVisible(true);
                livesLabel.setText("Lives: " + lives);

                bullsAndCowsPanel.setVisible(true);
                bullsLabel.setText("Bulls: " + bullsNum);
                cowsLabel.setText("Cows: " + cowsNum);

                dataPanel.setVisible(true);

                switch (selectedLevel) {
                    case "2":
                        dataComboBox4.setVisible(false);
                        dataComboBox5.setVisible(false);
                        dataComboBox6.setVisible(false);
                        break;
                    case "3":
                        dataComboBox5.setVisible(false);
                        dataComboBox6.setVisible(false);
                        break;
                    case "4":
                        dataComboBox6.setVisible(false);
                        break;
                    case "5":
                        break;
                    default:
                        dataComboBox3.setVisible(false);
                        dataComboBox4.setVisible(false);
                        dataComboBox5.setVisible(false);
                        dataComboBox6.setVisible(false);
                        break;
                }

                submitDataPanel.setVisible(true);
            }
        });

        submitDataBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logic
                String dataCombo1;
                String dataCombo2;
                String dataCombo3;
                String dataCombo4;
                String dataCombo5;
                String dataCombo6;

                // Create a new array to save the user guess
                int[] userGuessCode = new int[levelObj.getLevel() + 1];
                int userGuessCodeLength = userGuessCode.length;

                switch (selectedLevel) {
                    case "2":
                        dataCombo1 = (String) dataComboBox1.getSelectedItem();
                        dataCombo2 = (String) dataComboBox2.getSelectedItem();
                        dataCombo3 = (String) dataComboBox3.getSelectedItem();

                        System.out.println("Selected data: " + dataCombo1 + dataCombo2 + dataCombo3);

                        userGuessCode[0] = Integer.parseInt(dataCombo1);
                        userGuessCode[1] = Integer.parseInt(dataCombo2);
                        userGuessCode[2] = Integer.parseInt(dataCombo3);

                        break;
                    case "3":
                        dataCombo1 = (String) dataComboBox1.getSelectedItem();
                        dataCombo2 = (String) dataComboBox2.getSelectedItem();
                        dataCombo3 = (String) dataComboBox3.getSelectedItem();
                        dataCombo4 = (String) dataComboBox4.getSelectedItem();

                        System.out.println("Selected data: " + dataCombo1 + dataCombo2 + dataCombo3 + dataCombo4);

                        userGuessCode[0] = Integer.parseInt(dataCombo1);
                        userGuessCode[1] = Integer.parseInt(dataCombo2);
                        userGuessCode[2] = Integer.parseInt(dataCombo3);
                        userGuessCode[3] = Integer.parseInt(dataCombo4);

                        break;
                    case "4":
                        dataCombo1 = (String) dataComboBox1.getSelectedItem();
                        dataCombo2 = (String) dataComboBox2.getSelectedItem();
                        dataCombo3 = (String) dataComboBox3.getSelectedItem();
                        dataCombo4 = (String) dataComboBox4.getSelectedItem();
                        dataCombo5 = (String) dataComboBox5.getSelectedItem();

                        System.out.println("Selected data: " + dataCombo1 + dataCombo2 + dataCombo3 + dataCombo4 + dataCombo5);

                        userGuessCode[0] = Integer.parseInt(dataCombo1);
                        userGuessCode[1] = Integer.parseInt(dataCombo2);
                        userGuessCode[2] = Integer.parseInt(dataCombo3);
                        userGuessCode[3] = Integer.parseInt(dataCombo4);
                        userGuessCode[4] = Integer.parseInt(dataCombo5);

                        break;
                    case "5":
                        dataCombo1 = (String) dataComboBox1.getSelectedItem();
                        dataCombo2 = (String) dataComboBox2.getSelectedItem();
                        dataCombo3 = (String) dataComboBox3.getSelectedItem();
                        dataCombo4 = (String) dataComboBox4.getSelectedItem();
                        dataCombo5 = (String) dataComboBox5.getSelectedItem();
                        dataCombo6 = (String) dataComboBox6.getSelectedItem();

                        System.out.println("Selected data: " + dataCombo1 + dataCombo2 + dataCombo3 + dataCombo4 + dataCombo5 + dataCombo6);

                        userGuessCode[0] = Integer.parseInt(dataCombo1);
                        userGuessCode[1] = Integer.parseInt(dataCombo2);
                        userGuessCode[2] = Integer.parseInt(dataCombo3);
                        userGuessCode[3] = Integer.parseInt(dataCombo4);
                        userGuessCode[4] = Integer.parseInt(dataCombo5);
                        userGuessCode[5] = Integer.parseInt(dataCombo6);

                        break;
                    default:
                        dataCombo1 = (String) dataComboBox1.getSelectedItem();
                        dataCombo2 = (String) dataComboBox2.getSelectedItem();

                        System.out.println("Selected data: " + dataCombo1 + dataCombo2);

                        userGuessCode[0] = Integer.parseInt(dataCombo1);
                        userGuessCode[1] = Integer.parseInt(dataCombo2);

                        break;
                }

                // Check the user input
                int[] tempBullsAndCows = gameObj.checkGuess(gameCode, userGuessCode);
                bullsNum = tempBullsAndCows[0];
                cowsNum = tempBullsAndCows[1];

                // UI
                // Check if the user have the correct code
                if (bullsNum == userGuessCodeLength) {
                    livesPanel.setVisible(false);
                    bullsAndCowsPanel.setVisible(false);
                    submitDataPanel.setVisible(false);

                    String winnerText = playerObj.getName().toUpperCase() + " WON! Score: ";
                    titleLabel.setText(winnerText + gameObj.getTotalScore());
                }
                else {
                    lives =  gameObj.getLivesNum();

                    livesLabel.setText("Lives: " + lives);
                    bullsLabel.setText("Bulls: " + bullsNum);
                    cowsLabel.setText("Cows: " + cowsNum);

                    gameObj.reCalcScore();
                    boolean isAlive = gameObj.checkStillAlive();

                    if (!isAlive) {
                        livesPanel.setVisible(false);
                        bullsAndCowsPanel.setVisible(false);
                        submitDataPanel.setVisible(false);

                        String looserText = playerObj.getName().toUpperCase() + " LOST! Good luck next time";
                        titleLabel.setText(looserText);
                    }
                }
            }
        });
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
