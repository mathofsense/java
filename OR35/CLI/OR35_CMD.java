public class OR35_CMD {
  public static void main (String[] args) {
    if (args.length == 0) {
      System.out.println ("Usage: " + OR35_CMD.class.getSimpleName() + " <one or more numbers>");
      System.exit (0);
    }
  
    for (int i = 0; i < args.length; i++) {
      if (or35 (args[i])) {
        System.out.println (args[i] + " contains 3 or 5.");
      }
      else {
        System.out.println (args[i] + " does not contains 3 or 5.");
      }
    }
  }

  public static boolean or35 (String s) {
    boolean has_3 = false, has_5 = false;
    try {
      has_char (s, '3');
      has_3 = true;
    }
    catch (StringIndexOutOfBoundsException e) {
      System.out.println (e.getMessage());
    }
    
    try {
      has_char (s, '5');
      has_5 = true;
    }
    catch (StringIndexOutOfBoundsException e) {
      System.out.println (e.getMessage());
    }
   
    if (has_3 || has_5) {
      return true;
    }
    return false;
  }
  
  public static void has_char (String s, char c) {
    if (s.length () == 0) {
      throw new StringIndexOutOfBoundsException ("Character " + c + " not found!");
    }
    
    if (s.charAt (0) == c) {
      return;
    }
    
    has_char (s.substring (1), c); 
  }
}