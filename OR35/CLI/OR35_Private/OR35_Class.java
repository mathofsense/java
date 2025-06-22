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
    IntegerBot three = new IntegerBot (3);
    IntegerBot five = new IntegerBot ();
    five.set (5);
    
    if (three.can_divide (n)) {
      return true;
    }
    
    return five.can_divide (n);
    
    // return three.can_divide (n) || five.can_divide (n);
  }
}
