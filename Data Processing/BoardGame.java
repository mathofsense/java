import java.util.Scanner;

public class BoardGame {
  public static void main(String[] args) {
    char[][] board = new char[8][8];
    // Initialize the board with dashes
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        board[i][j] = '-';
      }
    }

    // Arrays to store previously entered coordinates
    int[] prevRows = new int[64];
    int[] prevCols = new int[64];
    int count = 0;

    Scanner scanner = new Scanner(System.in);

    printBoard(board);

    while (true) {
      System.out.println("Enter row (0-7) and column (0-7) separated by space (or -1 to exit):");
      int row = scanner.nextInt();
      if (row == -1) break;
      int col = scanner.nextInt();

      if (row < 0 || row >= 8 || col < 0 || col >= 8) {
        System.out.println("Invalid coordinates. Please enter values between 0 and 7.");
        continue;
      }

      if (isInvalidMove(row, col, prevRows, prevCols, count)) {
        System.out.println("Error: Coordinates are in the same row, column, or diagonal as a previous move. Try again.");
        continue;
      }

      board[row][col] = 'O';
      prevRows[count] = row;
      prevCols[count] = col;
      count++;

      printBoard(board);
    }

    scanner.close();
  }

  // Check if the move is invalid
  public static boolean isInvalidMove(int row, int col, int[] prevRows, int[] prevCols, int count) {
    for (int i = 0; i < count; i++) {
      int prevRow = prevRows[i];
      int prevCol = prevCols[i];
      // Same row or column
      if (row == prevRow || col == prevCol) return true;
      // Same diagonal
      if (Math.abs(row - prevRow) == Math.abs(col - prevCol)) return true;
    }
    return false;
  }

  // Print the board
  public static void printBoard(char[][] board) {
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        System.out.print(board[i][j]);
        if (j < 7) System.out.print(" | ");
      }
      System.out.println();
      if (i < 7) System.out.println("-------------------------------");
    }
    System.out.println();
  }
}
