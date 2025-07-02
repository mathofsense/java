import java.util.Scanner;

public class CharBinary {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter a character: ");
    String input = scanner.nextLine();

    if (input.length() == 0) {
      System.out.println("No character entered.");
      return;
    }

    char ch = input.charAt(0);
    int codePoint = ch;

    System.out.println("Character: " + ch);

    // Unicode
    System.out.println("Unicode code point: " + codePoint);
    System.out.print("Unicode (binary): ");
    printBits(codePoint, 16);
    System.out.print("Unicode (hex): 0x");
    printHex(codePoint, 4);
    System.out.println();

    // ASCII
    if (codePoint >= 0 && codePoint <= 127) {
      System.out.println("ASCII code: " + codePoint);
      System.out.print("ASCII (binary): ");
      printBits(codePoint, 7);
      System.out.print("ASCII (hex): 0x");
      printHex(codePoint, 2);
      System.out.println();
    } else {
      System.out.println("This character does not have an ASCII representation (ASCII is 0–127 only).");
    }
  }

  // Print bits (grouped by 4)
  static void printBits(int value, int bits) {
    for (int i = bits - 1; i >= 0; i--) {
      System.out.print((value >> i) & 1);
      if (i % 4 == 0 && i != 0) System.out.print(" ");
    }
    System.out.println();
  }

  // Print hex digits
  static void printHex(int value, int digits) {
    for (int i = (digits - 1) * 4; i >= 0; i -= 4) {
      int digit = (value >> i) & 0xF;
      if (digit < 10)
        System.out.print(digit);
      else
        System.out.print((char)('A' + digit - 10));
    }
  }
}
