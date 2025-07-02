import java.util.Scanner;

// Binary search
public class GuessTheNumber {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int low = 1, high = 100;
    System.out.println("Think of a number between 1 and 100 (inclusive).");

    while (low <= high) {
      int mid = low + (high - low) / 2;
      System.out.println("Is your number " + mid + "?");
      System.out.print("Enter 'h' if your number is higher, 'l' if lower, or 'c' if correct: ");
      String response = scanner.nextLine();

      if (response.equals("c")) {
        System.out.println("Hooray! I guessed your number.");
        break;
      } else if (response.equals("h")) {
        low = mid + 1;
      } else if (response.equals("l")) {
        high = mid - 1;
      } else {
        System.out.println("Invalid input. Please enter 'h', 'l', or 'c'.");
      }
    }
    scanner.close();
  }
}
