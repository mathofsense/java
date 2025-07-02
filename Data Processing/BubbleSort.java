public class BubbleSort {
  final static int SIZE = 20;

  public static void main(String[] args) {
    double[] nums = new double[SIZE];
    
    // Generate and print initial array
    System.out.println("Original Array:");
    for (int i = 0; i < SIZE; ++i) {
      nums[i] = Math.random() * 100 * Math.pow(-1, (int) (Math.random() * 10));
      System.out.printf("%8.2f", nums[i]);
      if ((i + 1) % 5 == 0) System.out.println();  // New line every 5 numbers
    }
    
    // Bubble Sort implementation
    System.out.println("\nSorting Steps:");
    for (int i = 0; i < SIZE - 1; ++i) {
      boolean swapped = false;
      
      // Single pass through the array
      for (int j = 0; j < SIZE - i - 1; ++j) {
        if (nums[j] > nums[j + 1]) {
          // Swap elements
          double temp = nums[j];
          nums[j] = nums[j + 1];
          nums[j + 1] = temp;
          swapped = true;
        }
      }
      
      // Early termination if no swaps
      if (!swapped) break;
    }
    
    // Print final sorted array
    System.out.println("\n\nSorted Array:");
    for (int i = 0; i < SIZE; ++i) {
      System.out.printf("%.2f\n", nums[i]);
    }
  }
}
