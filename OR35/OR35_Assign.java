public class OR35_Assign {
  public static void main (String[] args) {
    if (or35 (12)) {
      System.out.println ("12 is a multiple of 3 or 5.");
    }
    else {
      System.out.println ("12 is not a multiple of 3 or 5.");
    }
  }


  public static boolean or35 (int n) {
    int i, j;
    
    i = n % 3;
    j = n % 5;
    if (i == 0 || j == 0) {
      return true;
    }
    return false;
  }

}