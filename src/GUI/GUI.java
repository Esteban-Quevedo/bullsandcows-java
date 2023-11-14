import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {

  public static void main(String[] args) {
    Frame frame = new Frame("Cows and Bulls");

    Label titleLabel = new Label("Welcome to Cows and Bulls", new Color(0x344e41), new Font("MV Boli", Font.PLAIN, 30));
    titleLabel.setBounds(0, 0, 480, 100);
    frame.add(titleLabel);

    Label nameLabel = new Label("Enter your name:", new Color(0x344e41), new Font("MV Boli", Font.PLAIN, 15));
    nameLabel.setBounds(50, 100, 150, 20);
    frame.add(nameLabel);

    TextField nameInput = new TextField();
    nameInput.setBounds(50, 130, 200, 20);
    frame.add(nameInput);

    Button submitButton = new Button("Submit");
    submitButton.setBounds(50, 160, 80, 30);
    submitButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String enteredName = nameInput.getText();
        System.out.println(enteredName);
        // Perform any action you want with the entered name
      }
    });
    frame.add(submitButton);

    frame.setLayout(null);
  }
}