public class OR35_StrInt {
  public static void main (String[] args) {
    if (or35 ("1 2")) {
      System.out.println ("12 is a multiple of 3 or 5.");
    }
    else {
      System.out.println ("12 is not a multiple of 3 or 5.");
    }
  }

  public static boolean or35 (String s) {
     boolean is_mul_of_3 = is_multiple_of (s, 3);
     boolean is_mul_of_5 = is_multiple_of (s, 5);
   
     if (is_mul_of_3 || is_mul_of_5) {
       return true;
     }
     return false;
  }
  
  public static boolean is_multiple_of (String dividend, int divisor) {
    int dividend_int = Integer.parseInt(dividend);
    if (dividend_int < divisor) {
      return dividend_int == 0;
    }
  
    dividend_int -= divisor;
    dividend = Integer.toString (dividend_int); // dividend = "" + dividend_int;
    return is_multiple_of (dividend, divisor);
  }
}