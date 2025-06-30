import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
 
public class OR35_GUI {
  // These variables have to be defined here so that they are accessible in the listener classes
  final static String[] wait_text = { "Waiting for a number", "Waiting for a string"};
  final static String[] yes_text = {" is divisible by 3 or 5", " has the character '3' or '5'"};
  final static String[] no_text = {" is not divisible by 3 or 5"," has neither character '3' nor '5'"};
  static JTextField box;
  static JSlider slider;
  static JButton button, random_button;
  static JLabel label;
  static JRadioButton option_factor, option_char;
  static ButtonGroup option_group;
  static JPanel panel1, panel2;
  static LightPanel panel3;  
  static byte check_type;
      
  public static void main(String[] args) {
    check_type = 0;  // 0 for checking factor, 1 for checking character
    
    box = new JTextField("0.0", 10);
    box.setHorizontalAlignment(SwingConstants.RIGHT);
    box.addFocusListener (new TextListener ());  
    
    // Create a horizontal slider with min=0, max=1000, initial=0 
    slider = new JSlider(JSlider.HORIZONTAL, 0, 1000, 0);
    slider.setMinorTickSpacing(100);
    slider.setMajorTickSpacing(500);
    slider.setPaintTicks(true);
    slider.setPaintLabels(false);
    slider.addChangeListener (new SliderListener ());

    button = new JButton("OR35");
    button.addActionListener(new ButtonListener());
 
    random_button = new JButton("Random");
    random_button.addActionListener(new RandomButtonListener());
       
    label = new JLabel(wait_text[check_type]);
    label.setFont(new Font("Serif", Font.BOLD, 20));
    label.setForeground(Color.red);
    label.setHorizontalAlignment(SwingConstants.CENTER);   
    
    option_factor = new JRadioButton("Factor");
    option_factor.setSelected(true);
    option_factor.addItemListener (new FactorRadioButtonListener ());
    option_char = new JRadioButton("Char");
    option_char.addItemListener (new CharRadioButtonListener ()); 
    
    option_group = new ButtonGroup();
    option_group.add(option_factor);
    option_group.add(option_char);
    
    panel1 = new JPanel ();
    panel1.setLayout(new FlowLayout());
    panel1.setBackground(Color.GREEN);
    panel1.add(box); 
    panel1.add(button);
    panel1.add(slider);
    panel1.add(random_button);
    panel1.add(option_factor);
    panel1.add(option_char);
    
    panel2 = new JPanel ();
    panel2.setLayout(new FlowLayout());
    panel2.setBackground(new Color (51, 204, 255));   
    panel2.add(label);
    
    panel3 = new LightPanel ();
    panel3.setLayout(new FlowLayout());
    panel3.setBackground(Color.WHITE);   

    JFrame frame = new JFrame("L");
    frame.setSize(400, 150);
    frame.setLocation(50, 50);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    frame.setLayout(new GridLayout(3,1));
    frame.add(panel1);
    frame.add(panel2);
    frame.add(panel3);

    frame.setVisible(true);
  }
  
  private static class ButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      String s = box.getText();
      boolean result;
      
      if (check_type == 0) {
        try {
          double value = Double.parseDouble (s);
          result = or35 (value);
        }
        catch (NumberFormatException e1) {
          label.setText (s + " is not a number.");
          panel3.SetLight (LightPanel.Light.BLACK);
          panel3.repaint ();
          return;
        }
      }
      else {
        result = or35 (s);
      }
      
      panel3.SetLight (result ? LightPanel.Light.GREEN :  LightPanel.Light.RED);
      panel3.repaint ();
      
      String msg = s + (result ? yes_text[check_type] : no_text[check_type]);
      label.setText (msg);
    }
  }
  
  private static class RandomButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      double r = Math.random() * 100;  // How to get a random value between x and y?  
      String formatted = String.format("%.1f", r);
      box.setText(formatted);
    }
  }  

  private static class TextListener implements FocusListener {
    @Override
    public void focusGained(FocusEvent e) {
      label.setText (wait_text[check_type]);
      panel3.SetLight (LightPanel.Light.BLACK);
      panel3.repaint ();      
    }

    @Override
    public void focusLost(FocusEvent e) {
    }
  }
  
  private static class SliderListener implements ChangeListener {
    @Override
    public void stateChanged(ChangeEvent e) {
      label.setText (wait_text[check_type]);
      panel3.SetLight (LightPanel.Light.BLACK);
      panel3.repaint ();         
      box.setText("" + (slider.getValue() / 10.0f));
    }
  }
  
  private static class FactorRadioButtonListener implements ItemListener {
    @Override
    public void itemStateChanged(ItemEvent e) {
      check_type = 0;
      label.setText (wait_text[check_type]);
      panel3.SetLight (LightPanel.Light.BLACK);
      panel3.repaint ();  
    }
  }  

  private static class CharRadioButtonListener implements ItemListener {
    @Override
    public void itemStateChanged(ItemEvent e) {
      check_type = 1;
      label.setText (wait_text[check_type]);
      panel3.SetLight (LightPanel.Light.BLACK);
      panel3.repaint ();  
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
  
  public static boolean or35 (String s) {
    boolean has_3 = has_char (s, '3');
    boolean has_5 = has_char (s, '5');
   
    if (has_3 || has_5) {
      return true;
    }
    return false;
  }
  
  public static boolean has_char (String s, char c) {
    int i = 0;
    int len = s.length ();
    
    while (i < len) {
      if (s.charAt (i) == c) {
        break;
      }
      
      ++ i;
    }
    
    return (i < len);
  }      
}
