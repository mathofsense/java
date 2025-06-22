import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 
public class OR35_GUI {
  // These variables have to be defined here so that they are accessible in the listener classes
  final static String wait_text = "Waiting for a number";
  final static String yes_text = " is divisible by 3 or 5";
  final static String no_text = " is no divisible by 3 or 5";
  static JTextField box;
  static JButton button;
  static JLabel label;    
    
  public static void main(String[] args) {
    JPanel panel1, panel2;
    
    box = new JTextField("0.0", 10);
    box.setHorizontalAlignment(SwingConstants.RIGHT);
    box.addFocusListener (new TextListener ());  

    button = new JButton("OR35");
    button.addActionListener(new ButtonListener());
    
    label = new JLabel(wait_text);
    label.setFont(new Font("Serif", Font.BOLD, 20));
    label.setForeground(Color.red);
    label.setHorizontalAlignment(SwingConstants.CENTER);   
    
    panel1 = new JPanel ();
    panel1.setLayout(new FlowLayout());
    panel1.setBackground(Color.GREEN);
    panel1.add(box);
    panel1.add(button);
    
    panel2 = new JPanel ();
    panel2.setLayout(new FlowLayout());
    panel2.setBackground(Color.WHITE);    
    panel2.add(label);

    JFrame frame = new JFrame("L");
    frame.setSize(400, 100);
    frame.setLocation(50, 50);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    frame.setLayout(new BorderLayout());
    frame.add(panel1, BorderLayout.CENTER);
    frame.add(panel2, BorderLayout.SOUTH);
    frame.setVisible(true);
  }
  
  private static class ButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      String s = box.getText();
      double value = Double.parseDouble (s);
      
      if (or35 (value)) {
        label.setText (value + yes_text);
      }
      else {
        label.setText (value + no_text);
      }
    }
  }
  
  private static class TextListener implements FocusListener {
    @Override
    public void focusGained(FocusEvent e) {
      label.setText (wait_text);
    }

    @Override
    public void focusLost(FocusEvent e) {
    }
  }
  
  public static boolean or35 (double n) {
     boolean is_mul_of_3 = is_multiple_of (n, 3);
     boolean is_mul_of_5 = is_multiple_of (n, 5);
   
     if (is_mul_of_3 || is_mul_of_5) {
       return true;
     }
     return false;
  }
  
  public static boolean is_multiple_of (double dividend, double divisor) {
    while (dividend >= divisor) {
      dividend -= divisor;
    }
    
    return dividend == 0;
  }    
}
