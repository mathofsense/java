import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class OR35_FileArrayWrite {
  public static void main (String[] args) {
    if (args.length != 2) {
      System.out.println ("Usage: " + OR35_CMD.class.getSimpleName() + " <file name to read>  <file name to write> ");
      System.exit (0);
    }  
    String inFileName = args[0]; 
    String outFileName = args[1]; 
    
    File myFile;
    Scanner myReader = null;
    FileWriter myWriter = null;
  
    try {
      myFile = new File(inFileName); 
      myReader = new Scanner(myFile);
      myWriter = new FileWriter(outFileName);

      boolean first_line_read = false;
      char[] chars = new char[1000];

      while (myReader.hasNextLine()) {
        String s = myReader.nextLine();
        if (! first_line_read) {
          int char_count = 0;
          for (int i = 0; i < s.length (); ++ i) {
            if (Character.isDigit (s.charAt (i))) {
              chars[char_count] = s.charAt(i);
              ++ char_count;
            } 
          }
          chars[char_count] = '\0';
          first_line_read = true;
          continue;
        }
        
        String output = null;
        if (or35 (s, chars)) {
          output = s + " contains one of the chracters.";
        }
        else {
          output = s + " does not contains any of the chracters.";
        }
        System.out.println (output);
        myWriter.write (output); 
      }

      myWriter.close ();
    } catch (FileNotFoundException e) {
      System.out.println("The file " + inFileName + " is not found.");
    } 
    catch (IOException e) {
      System.out.println("An error occurred writing to " + outFileName + ".");
    }

    myReader.close();
  }

  public static boolean or35 (String s, char[] char_list) {
    int i;
    boolean has = false;
    for (i = 0; i < char_list.length; ++ i) {  // try while
      if (char_list[i] == '\0') break;
      try {
        has_char (s, char_list[i]);
        has = true;
        break;
      }
      catch (StringIndexOutOfBoundsException e) {
        // System.out.println (e.getMessage());
      }
    }  

    return has;
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