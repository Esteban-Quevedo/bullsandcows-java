package GUI;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

  Frame(String title) {
    // Set title
    this.setTitle(title);
    // Close program when window is closed
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Sets window properties
    this.setVisible(true);
    this.setSize(480, 480);
    this.getContentPane().setBackground(new Color(0xe9edc9));
  }
}
