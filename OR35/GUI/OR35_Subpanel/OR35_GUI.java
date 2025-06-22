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
    JPanel main_panel, sub_panel;
    
    box = new JTextField("0.0", 10);
    box.setHorizontalAlignment(SwingConstants.RIGHT);
    box.addFocusListener (new TextListener ());  

    button = new JButton("OR35");
    button.addActionListener(new ButtonListener());
    
    label = new JLabel(wait_text);
    label.setFont(new Font("Serif", Font.BOLD, 20));
    label.setForeground(Color.red);
    label.setHorizontalAlignment(SwingConstants.CENTER);   

    sub_panel = new JPanel ();
    sub_panel.setLayout(new FlowLayout());
    sub_panel.setBackground(Color.WHITE);    
    sub_panel.add(label);
        
    main_panel = new JPanel ();
    main_panel.setLayout(new FlowLayout());
    main_panel.setBackground(Color.GREEN);
    main_panel.add(box);
    main_panel.add(button);
    
    main_panel.add (sub_panel);

    JFrame frame = new JFrame("L");
    frame.setSize(400, 100);
    frame.setLocation(50, 50);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setContentPane(main_panel);
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
