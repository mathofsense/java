import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ClickablePanel extends JPanel{
   private JLabel label;      //reference in a field
   public ClickablePanel() {
      setLayout(new FlowLayout());
   
      label = new JLabel("Number will show up here.");
      label.setFont(new Font("Serif", Font.BOLD, 20));
      label.setForeground(Color.blue);
      add(label);
   
      JButton button = new JButton("Click me"); //local
      button.addActionListener(new Listener());
      add(button);
   }
   private class Listener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         double x = Math.random();   //local variable
         label.setText("" + x);
      }
   }
}
