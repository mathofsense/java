import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
 
public class MoveLight {
  static JButton button;
  static JPanel panel1;
  static LightPanel panel2;  
  static Timer timer = null;
      
  public static void main(String[] args) {
    button = new JButton("Move");
    button.addActionListener(new ButtonListener()); 

    panel1 = new JPanel ();
    panel1.setLayout(new FlowLayout());
    panel1.setBackground(Color.GREEN);
    panel1.add(button);

    panel2 = new LightPanel ();
    panel2.setLayout(new FlowLayout());
    panel2.setBackground(Color.WHITE);   

    JFrame frame = new JFrame("L");
    frame.setSize(400, 150);
    frame.setLocation(50, 50);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    frame.setLayout(new GridLayout(2,1));
    frame.add(panel1);
    frame.add(panel2);

    frame.setVisible(true);
  }
  
  private static class ButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      if (timer == null) {
        timer = new Timer (200, new TimerListener ());
      }
      if (! timer.isRunning ()) {
        timer.start ();
      }
      else {
        timer.stop ();
      }
    }
  }
  
  private static class TimerListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      panel2.move_light ();
    }
  }  
}
