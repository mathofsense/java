import java.util.Scanner;

public class OR35_Input_Loop_Ctrl {
  public static void main (String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.println ("Enter a string with one or more digits:");
      String s = scanner.nextLine();
      s = s.trim ();
      if (s == "" || s == "exit" || s == "quit") {
        scanner.close ();
        break;
      }
  
      if (or35 (s)) {
        System.out.println (s + " contains 3 or 5.");
        continue;
      }
      
      System.out.println (s + " does not contains 3 or 5.");
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