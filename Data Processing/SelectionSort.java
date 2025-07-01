public class SelectionSort {
  final static int size = 20;

  public static void main(String[] args) {
    double[] nums = new double[size];
    
    // Fill array with random numbers (positive and negative)
    for (int i = 0; i < size; i++) {
      nums[i] = Math.random() * 100 * Math.pow(-1, (int) (Math.random() * 10));
      System.out.printf("%.2f\n", nums[i]);
    }

    // Selection sort: find max in each step
    for (int i = size - 1; i > 0; i--) {
      int maxIndex = 0;  // Track position of max value
      
      // Find max in unsorted portion [0, i]
      for (int j = 1; j <= i; j++) {
        if (nums[j] > nums[maxIndex]) {
          maxIndex = j;
        }
      }
      
      // Swap max with last unsorted element
      double temp = nums[maxIndex];
      nums[maxIndex] = nums[i];
      nums[i] = temp;
    }

    // Print sorted array
    System.out.println("\nSorted array:");
    for (int i = 0; i < size; i++) {
      System.out.printf("%.2f\n", nums[i]);
    }
  }
}
