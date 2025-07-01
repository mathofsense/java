import java.util.Random;

public class FindMaxString {
  private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
  private static final Random RANDOM = new Random();
  final static int size = 20;

  public static String get_random_string (int length) {
    StringBuilder sb = new StringBuilder(length);
    for (int i = 0; i < length; i++) {
      int index = RANDOM.nextInt(CHARACTERS.length());
      sb.append(CHARACTERS.charAt(index));
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    String[] strs = new String[size];
    int i;
    
    for (i = 0; i < size; ++ i) {
      strs[i] = get_random_string (12); // Generate a random string of length 12
      System.out.println(strs[i]);
    }  
    

    String max = "";
    for (i = 0; i < size; ++ i) {
      if (max.compareTo (strs[i]) < 0) {
        max = strs[i];
      }
    }      
    
    System.out.printf ("\nThe max is %s\n", max);         
  }
}
