import java.util.Scanner;

public class SignedInteger {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // Get signed integer as input
    System.out.print("Enter a signed integer (up to 64 bits): ");
    long value = scanner.nextLong();

    // Calculate least number of bits needed for two's complement
    int minBits = getMinBitsTwoComplement(value);

    // Round up to nearest multiple of 8
    int N = ((minBits + 7) / 8) * 8;
    if (N > 64) N = 64; // Limit to 64 bits

    System.out.println("Least number of bits needed (two's complement): " + minBits);
    System.out.println("Using N = " + N + " bits (smallest multiple of 8 ≥ needed bits)");

    // Display binary
    System.out.print("Binary   : ");
    for (int i = N - 1; i >= 0; i--) {
      System.out.print(((value >> i) & 1L));
      if (i % 4 == 0 && i != 0) System.out.print(" ");
    }
    System.out.println();

    // Display octal
    System.out.print("Octal  : ");
    for (int i = N - 3; i >= 0; i -= 3) {
      int digit = 0;
      for (int j = 0; j < 3; j++) {
        digit = (digit << 1) | (int)((value >> (i + 2 - j)) & 1L);
      }
      System.out.print(digit);
      if (i % 12 == 0 && i != 0) System.out.print(" ");
    }
    System.out.println();

    // Display hexadecimal
    System.out.print("Hex    : ");
    for (int i = N - 4; i >= 0; i -= 4) {
      int digit = 0;
      for (int j = 0; j < 4; j++) {
        digit = (digit << 1) | (int)((value >> (i + 3 - j)) & 1L);
      }
      if (digit < 10) System.out.print(digit);
      else System.out.print((char)('A' + digit - 10));
      if (i % 16 == 0 && i != 0) System.out.print(" ");
    }
    System.out.println();
  }

  // Calculates the minimum number of bits needed for two's complement representation
  private static int getMinBitsTwoComplement(long value) {
    if (value == 0 || value == -1) return 1;
    int bits = 1;
    if (value > 0) {
      long temp = value;
      while (temp != 0) {
        bits++;
        temp >>= 1;
      }
    } else {
      long temp = value;
      while (temp != -1) {
        bits++;
        temp >>= 1;
      }
    }
    return bits;
  }
}
