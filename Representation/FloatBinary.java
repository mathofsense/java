import java.util.Scanner;
import java.nio.ByteBuffer;

public class FloatBinary {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter a floating-point number: ");
    double input = scanner.nextDouble();

    // Single precision (float, 32-bit)
    float fValue = (float) input;
    int floatBits = floatToRawIntBits(fValue);

    // Double precision (double, 64-bit)
    long doubleBits = doubleToRawLongBits(input);

    // Half precision (16-bit) - manual encoding from float bits
    short halfBits = floatToHalfBits(floatBits);

    System.out.println("\nHalf-precision (16 bits):");
    printIEEEFormulaHalf(halfBits);
    printBits(halfBits, 16);

    System.out.println("\nSingle-precision (32 bits):");
    printIEEEFormulaSingle(floatBits);
    printBits(floatBits, 32);

    System.out.println("\nDouble-precision (64 bits):");
    printIEEEFormulaDouble(doubleBits);
    printBits(doubleBits, 64);
  }

  // Print bits, grouped by 4
  static void printBits(long value, int bits) {
    for (int i = bits - 1; i >= 0; i--) {
      System.out.print((value >> i) & 1L);
      if (i % 4 == 0 && i != 0) System.out.print(" ");
    }
    System.out.println();
  }

  // Get float bits using only bit operations (no Float.floatToIntBits)
  static int floatToRawIntBits(float value) {
    byte[] bytes = new byte[4];
    ByteBuffer.wrap(bytes).putFloat(value);
    int bits = 0;
    for (int i = 0; i < 4; i++) {
      bits |= (bytes[i] & 0xFF) << (8 * (3 - i));
    }
    return bits;
  }

  // Get double bits using only bit operations (no Double.doubleToLongBits)
  static long doubleToRawLongBits(double value) {
    byte[] bytes = new byte[8];
    ByteBuffer.wrap(bytes).putDouble(value);
    long bits = 0L;
    for (int i = 0; i < 8; i++) {
      bits |= ((long) (bytes[i] & 0xFF)) << (8 * (7 - i));
    }
    return bits;
  }

  // Convert float bits to IEEE 754 half-precision (16-bit) representation
  static short floatToHalfBits(int fbits) {
    int sign = (fbits >>> 16) & 0x8000;
    int val = (fbits & 0x7fffffff);
    int exp = ((fbits >>> 23) & 0xFF) - 127 + 15;
    int mant = (fbits >> 13) & 0x3FF;

    if (exp <= 0) {
      // Subnormal or zero
      if (exp < -10) {
        return (short) sign;
      }
      mant = (mant | 0x400) >> (1 - exp);
      return (short) (sign | mant);
    } else if (exp == 0xFF - 127 + 15) {
      // Inf or NaN
      if (mant != 0) {
        return (short) (sign | 0x7C00 | (mant & 0x3FF));
      } else {
        return (short) (sign | 0x7C00);
      }
    } else if (exp > 30) {
      // Overflow to Inf
      return (short) (sign | 0x7C00);
    }
    return (short) (sign | (exp << 10) | mant);
  }

  // Print IEEE formula for half-precision
  static void printIEEEFormulaHalf(short bits) {
    int sign = (bits >>> 15) & 0x1;
    int exponent = (bits >>> 10) & 0x1F;
    int fraction = bits & 0x3FF;
    int bias = 15;

    if (exponent == 0) {
      if (fraction == 0) {
        System.out.println("Formula: 0 (zero)");
      } else {
        System.out.printf("Formula: (-1)^%d × 0.%s × 2^(%d)\n",
            sign, fractionToBinaryString(fraction, 10), 1 - bias);
      }
    } else if (exponent == 0x1F) {
      if (fraction == 0) {
        System.out.printf("Formula: %sInfinity\n", sign == 1 ? "-" : "+");
      } else {
        System.out.println("Formula: NaN (Not a Number)");
      }
    } else {
      System.out.printf("Formula: (-1)^%d × 1.%s × 2^(%d)\n",
          sign, fractionToBinaryString(fraction, 10), exponent - bias);
    }
  }

  // Print IEEE formula for single-precision
  static void printIEEEFormulaSingle(int bits) {
    int sign = (bits >>> 31) & 0x1;
    int exponent = (bits >>> 23) & 0xFF;
    int fraction = bits & 0x7FFFFF;
    int bias = 127;

    if (exponent == 0) {
      if (fraction == 0) {
        System.out.println("Formula: 0 (zero)");
      } else {
        System.out.printf("Formula: (-1)^%d × 0.%s × 2^(%d)\n",
            sign, fractionToBinaryString(fraction, 23), 1 - bias);
      }
    } else if (exponent == 0xFF) {
      if (fraction == 0) {
        System.out.printf("Formula: %sInfinity\n", sign == 1 ? "-" : "+");
      } else {
        System.out.println("Formula: NaN (Not a Number)");
      }
    } else {
      System.out.printf("Formula: (-1)^%d × 1.%s × 2^(%d)\n",
          sign, fractionToBinaryString(fraction, 23), exponent - bias);
    }
  }

  // Print IEEE formula for double-precision
  static void printIEEEFormulaDouble(long bits) {
    int sign = (int) ((bits >>> 63) & 0x1);
    int exponent = (int) ((bits >>> 52) & 0x7FF);
    long fraction = bits & 0xFFFFFFFFFFFFFL;
    int bias = 1023;

    if (exponent == 0) {
      if (fraction == 0) {
        System.out.println("Formula: 0 (zero)");
      } else {
        System.out.printf("Formula: (-1)^%d × 0.%s × 2^(%d)\n",
            sign, fractionToBinaryString(fraction, 52), 1 - bias);
      }
    } else if (exponent == 0x7FF) {
      if (fraction == 0) {
        System.out.printf("Formula: %sInfinity\n", sign == 1 ? "-" : "+");
      } else {
        System.out.println("Formula: NaN (Not a Number)");
      }
    } else {
      System.out.printf("Formula: (-1)^%d × 1.%s × 2^(%d)\n",
          sign, fractionToBinaryString(fraction, 52), exponent - bias);
    }
  }

  // Convert fraction to binary string with specified width
  static String fractionToBinaryString(long fraction, int width) {
    StringBuilder sb = new StringBuilder();
    for (int i = width - 1; i >= 0; i--) {
      sb.append((fraction >> i) & 1L);
    }
    return sb.toString();
  }
}
