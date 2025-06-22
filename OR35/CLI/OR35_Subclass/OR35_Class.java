public class OR35_Class {
  public static void main (String[] args) {
    if (or35 (12)) {
      System.out.println ("12 is a multiple of 3 or 5.");
    }
    else {
      System.out.println ("12 is not a multiple of 3 or 5.");
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
