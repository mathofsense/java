import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class OR35_File {
  public static void main (String[] args) {
    if (args.length == 0) {
      System.out.println ("Usage: " + OR35_CMD.class.getSimpleName() + " <file name>");
      System.exit (0);
    }  
    String fileName = args[0]; 
    
    
    File myFile;
    Scanner myReader = null;
  
    try {
      myFile = new File(fileName); 
      myReader = new Scanner(myFile);
    } catch (FileNotFoundException e) {
      System.out.println("The file " + fileName + " is not found.");
      System.exit (0);
    }

    while (myReader.hasNextLine()) {
      String s = myReader.nextLine();
      if (or35 (s)) {
        System.out.println (s + " contains 3 or 5.");
      }
      else {
        System.out.println (s + " does not contains 3 or 5.");
      }      
    }
    myReader.close();
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