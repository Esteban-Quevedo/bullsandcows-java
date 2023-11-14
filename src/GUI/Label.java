import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class Label extends JLabel {
  Label(String text, Color color, Font font) {
    this.setText(text);
    this.setHorizontalAlignment(JLabel.CENTER);
    this.setVerticalAlignment(JLabel.TOP);
    this.setForeground(color);
    this.setFont(font);
  }

  void setVerticalPosition(String position) {
    if (position.equals("top")) {
      this.setVerticalAlignment(JLabel.TOP);
    } else if (position.equals("bottom")) {
      this.setVerticalAlignment(JLabel.BOTTOM);
    } else {
      this.setVerticalAlignment(JLabel.CENTER);
    }
  }

  void setHorizontalPosition(String position) {
    if (position.toLowerCase().equals("left")) {
      this.setHorizontalAlignment(JLabel.LEFT);
    } else if (position.toLowerCase().equals("right")) {
      this.setHorizontalAlignment(JLabel.RIGHT);
    } else {
      this.setHorizontalAlignment(JLabel.CENTER);
    }
  }
}
