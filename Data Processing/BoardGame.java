import java.util.Scanner;

public class BoardGame {
  public static void main(String[] args) {
    char[][] board = new char[8][8];
    Scanner scanner = new Scanner(System.in);

    // Initialize the board with dashes
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        board[i][j] = '-';
      }
    }

    while (true) {
      printBoard(board);
      System.out.println("Enter coordinates (row and column) between 0 and 7, separated by space:");
      int row = scanner.nextInt();
      int col = scanner.nextInt();

      // Check if coordinates are valid
      if (row < 0 || row >= 8 || col < 0 || col >= 8) {
        System.out.println("Invalid coordinates. Please enter values between 0 and 7.");
        continue;
      }

      // Check if the position is already occupied
      if (board[row][col] == 'O') {
        System.out.println("This position is already taken. Try again.");
        continue;
      }

      // Check for conflicts in row, column, or diagonal
      boolean conflict = false;
      for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++) {
          if (board[i][j] == 'O') {
            if (i == row || j == col || Math.abs(i - row) == Math.abs(j - col)) {
              conflict = true;
              break;
            }
          }
        }
        if (conflict) break;
      }

      if (conflict) {
        System.out.println("Error: Coordinates conflict with previously entered coordinates in the same row, column, or diagonal.");
        continue;
      }

      // Place 'O' at the entered coordinates
      board[row][col] = 'O';
    }
  }

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
