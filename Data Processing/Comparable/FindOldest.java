import java.util.Random;

public class FindOldest {
  private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
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
    Person[] people = new Person[size];
    int i;
    
    for (i = 0; i < size; ++ i) {
      String name = get_random_string (4); // Generate a random string of length 12
      int age = RANDOM.nextInt (100);      
      
      people[i] = new Person (name, age);
      
      System.out.println(name + ", " + age);
    }  
    

    Person oldest = people[0];
    for (i = 1; i < size; ++ i) {
      if (oldest.compareTo (people[i]) < 0) {
        oldest = people[i];
      }
    }      
    
    System.out.printf ("\nThe oldest is %s at %d\n", oldest.name, oldest.age);         
  }
}
