import javax.swing.JOptionPane;

public class OR35_Class {
  public static void main (String[] args) {
    int n = Integer.parseInt ( JOptionPane.showInputDialog ("Enter an integer below. \nWe will check if it is divisible by 3 or 5."));
  
    if (or35 (n)) {
      JOptionPane.showMessageDialog (null, n + " is a multiple of 3 or 5.");
    }
    else {
      JOptionPane.showMessageDialog (null, n + " is not a multiple of 3 or 5.");
    }
  }

  public static boolean or35 (int n) {
    MegaIntegerBot three_five = new MegaIntegerBot (3, 5);
    /* OR:
       MegaIntegerBot three_five = new IntegerBot ();
       three_five.set (3, 5);
     */
    
    return three_five.can_divide (n);
  }
}
