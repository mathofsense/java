public class InsertionSortExample {
  final static int SIZE = 20;

  public static void main(String[] args) {
    double[] nums = new double[SIZE];

    // Generate and print the initial array
    System.out.println("Original Array:");
    for (int i = 0; i < SIZE; ++i) {
      nums[i] = Math.random() * 100 * Math.pow(-1, (int) (Math.random() * 10));
      System.out.printf("%8.2f", nums[i]);
      if ((i + 1) % 5 == 0) System.out.println();
    }

    // Insertion Sort implementation with step-by-step output
    System.out.println("\nInsertion Sort Steps:");
    for (int i = 1; i < SIZE; ++i) {
      double key = nums[i];
      int j = i - 1;

      // Move elements greater than key to one position ahead
      while (j >= 0 && nums[j] > key) {
        nums[j + 1] = nums[j];
        j--;
      }
      nums[j + 1] = key;
    }

    // Print the final sorted array
    System.out.println("\nSorted Array:");
    for (int i = 0; i < SIZE; ++i) {
      System.out.printf("%.2f\n", nums[i]);
    }
  }
}
