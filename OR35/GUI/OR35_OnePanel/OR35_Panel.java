import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class OR35_Panel extends JPanel {
  private JTextField box;
  private JButton button;
  private JLabel label;
  private final String wait_text = "Waiting for a number";
  private final String yes_text = " is divisible by 3 or 5";
  private final String no_text = " is no divisible by 3 or 5";
  
  public OR35_Panel () {
    this (0);
  }
  
  public OR35_Panel (int layout) {
    box = new JTextField("0.0", 10);
    box.setHorizontalAlignment(SwingConstants.RIGHT);
    box.addFocusListener (new TextListener ());

    button = new JButton("OR35");
    button.addActionListener(new ButtonListener());

    label = new JLabel(wait_text);
    label.setFont(new Font("Serif", Font.BOLD, 20));
    label.setForeground(Color.red);
    label.setHorizontalAlignment(SwingConstants.CENTER);
    
    if (layout == 0) {
      setLayout(new FlowLayout());
      add(box);
      add(button);
      add(label);
    }
    else if (layout == 1) {
      setLayout(new BorderLayout());  
      add (box, BorderLayout.NORTH);  
      add (button, BorderLayout.CENTER); 
      add (label, BorderLayout.SOUTH); 
    }  
    else if (layout == 2) {
      setLayout(new GridLayout(2,2));  
      add(box);
      add(button);
      add(label);
    }    
    else if (layout == 3) {
      setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));  
      add(box);
      add(button);
      add(label);
    }     
    
  }
  private class ButtonListener implements ActionListener {
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
  private class TextListener implements FocusListener {
    @Override
    public void focusGained(FocusEvent e) {
      label.setText (wait_text);
    }

    @Override
    public void focusLost(FocusEvent e) {
    }
  }
    
  
  public boolean or35 (double n) { // does not need to be 'static' any more
     boolean is_mul_of_3 = is_multiple_of (n, 3);
     boolean is_mul_of_5 = is_multiple_of (n, 5);
   
     if (is_mul_of_3 || is_mul_of_5) {
       return true;
     }
     return false;
  }
  
  public boolean is_multiple_of (double dividend, double divisor) { // does not need to be 'static' any more
    while (dividend >= divisor) {
      dividend -= divisor;
    }
    
    return dividend == 0;
  }  
}
