// File must be named after the class !!
import javax.swing.JFrame; // use others' code
public class __ChangeThis__ {
  public void main(String[] args){
    JFrame frame = new JFrame("L");
    frame.setSize (400, 300);
    frame.setLocation (50, 50);
    frame.setDefaultCloseOperation (
    JFrame.EXIT_ON_CLOSE);
    frame.setContentPane (new MyFirstPanel());
    frame.setVisible (true);
  }
}

import javax.swing.*;
import java.awt.*;
public class MyFirstPanel extends Jpanel {
  public void paintComponent(Graphics g) {
    g.setColor(Color.YELLOW);
    g.fillRect(75, 50, 300, 125);
    g.setFont(new Font("Serif", Font.BOLD, 50));
    g.setColor(new Color(255, 0, 150));
    g.drawString("It works!", 100, 150);
  }
}
