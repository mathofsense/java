public class OR35_String {
  public static void main (String[] args) {
    if (or35 ("25990")) {
      System.out.println ("25990" + " contains 3 or 5.");
    }
    else {
      System.out.println ("25990" + " does not contains 3 or 5.");
    }
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