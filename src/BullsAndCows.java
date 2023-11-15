import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BullsAndCows extends JFrame{
    private JPanel mainPanel;
    private JTextField nameTxtField;
    private JButton submitButton;

    public BullsAndCows() {
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enteredName = nameTxtField.getText();
                System.out.println(enteredName);
                Player playerObj = new Player(enteredName);
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public static void main(String[] args){
        BullsAndCows ui = new BullsAndCows();
        ui.setContentPane(ui.mainPanel);
        ui.setTitle("Bulls and Cows");
        ui.setSize(480, 480);
        ui.setVisible(true);
        ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
