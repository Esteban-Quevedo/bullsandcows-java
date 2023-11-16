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


    public BullsCows() {

        this.gameModePanel.setVisible(false);
        this.selectLevelPanel.setVisible(false);
        this.gameModeBtnPanel.setVisible(false);

        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enteredName = nameTxtField.getText();
                System.out.println("Entered name: " +enteredName);
                Player playerObj = new Player(enteredName);

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
                // Check which radio button is selected
                if (freeModeBtn.isSelected()) {
                    gameModePanel.setVisible(false);
                    selectLevelPanel.setVisible(true);
                    gameModeBtnPanel.setVisible(false);

                    titleLabel.setText("Select a Level");

                } else if (campaignModeBtn.isSelected()) {
                    gameModePanel.setVisible(false);
                    selectLevelPanel.setVisible(false);
                    gameModeBtnPanel.setVisible(false);

                    titleLabel.setText("Bulls & Cows | Level 1");
                }
            }
        });

        selectLevelCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedLevel = (String) selectLevelCombo.getSelectedItem();
                System.out.println("Selected: " + selectedLevel);

                selectLevelPanel.setVisible(false);

                titleLabel.setText("Bulls & Cows | Level " + selectedLevel);
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
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
