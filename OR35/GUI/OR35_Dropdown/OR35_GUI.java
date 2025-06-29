import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
 
public class OR35_GUI {
  // These variables have to be defined here so that they are accessible in the listener classes
  final static String[] wait_text = { "Waiting for a number", "Waiting for a string", "Waiting for input", "Must choose a type!"};
  final static String[] yes_text = {" is divisible by 3 or 5", " has the character '3' or '5'"};
  final static String[] no_text = {" is no divisible by 3 or 5"," has neither character '3' nor '5'"};
  static JTextField box;
  static JSlider slider;
  static JButton button, random_button;
  static JTextArea text_area;
  static JComboBox dropdown;
  static ButtonGroup option_group;
  static JScrollPane scroll_pane;
  static JPanel panel1, panel2;
  static byte check_type;
      
  public static void main(String[] args) {
    check_type = 0;  // 0 for checking factor, 1 for checking character, 2 for checking both
    
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
    
    String[] options = { "Factor", "Char", "Both"};
    dropdown = new JComboBox (options);
    dropdown.addItemListener (new DropdownListListener ());
    dropdown.setSelectedIndex(check_type);
    
    panel1 = new JPanel ();
    panel1.setLayout(new FlowLayout());
    panel1.setBackground(Color.GREEN);
    panel1.add(box); 
    panel1.add(button);
    panel1.add(slider);
    panel1.add(random_button);
    panel1.add (dropdown);
    
    text_area = new JTextArea(wait_text[check_type]); // There are other constructors
    text_area.setFont(new Font("Serif", Font.BOLD, 20));
    text_area.setForeground(Color.red);
    text_area.setRows (5);
    text_area.setColumns (20);
    text_area.setLineWrap(false); // Line wrapping, should be disabled to see horizontal scrollbar.
    text_area.setWrapStyleWord(true); // Wrap at word boundaries   
    text_area.setEditable(true); // Set to read only or not.
    
    scroll_pane = new JScrollPane (text_area);    
    
    panel2 = new JPanel ();
    panel1.setLayout(new FlowLayout());
    panel2.setBackground(Color.WHITE);    
    panel2.add(scroll_pane);

    JFrame frame = new JFrame("L");
    frame.setSize(400, 150);
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
      String msg = "";  // must be initialized
      boolean result;
      
      if (check_type % 2 == 0) { // 0 or 2
        try {
          double value = Double.parseDouble (s);
          msg = s + (or35 (value) ? yes_text[0] : no_text[0]);

        }
        catch (NumberFormatException e1) {
          msg = s + " is not a number.";
        }
      }
      
      if (check_type > 0) { 
        if (msg.length () > 0) {
          msg += "\n";
        }
        msg += s + (or35 (s) ? yes_text[1] : no_text[1]);
      }
      
      text_area.setText (msg);
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
      text_area.setText (wait_text[check_type]);
    }

    @Override
    public void focusLost(FocusEvent e) {
    }
  }
  
  private static class SliderListener implements ChangeListener {
    @Override
    public void stateChanged(ChangeEvent e) {
      text_area.setText (wait_text[check_type]);
      box.setText("" + (slider.getValue() / 10.0f));
    }
  }
  
  private static class DropdownListListener implements ItemListener {
    @Override
    public void itemStateChanged(ItemEvent e) {
      check_type = (byte) dropdown.getSelectedIndex ();
      if (check_type >= 0) {
        text_area.setText (wait_text[check_type]);
      }
      else {
        text_area.setText (wait_text[3]);
      }
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
