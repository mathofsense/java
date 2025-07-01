public class FindMax {
  final static int size = 20;

  public static void main (String[] args) {
    double[] nums = new double[size];
    int i;
    
    for (i = 0; i < size; ++ i) {
      nums[i] = Math.random () * 100 * Math.pow (-1, (int) (Math.random () * 10));
      System.out.printf ("%.2f\n", nums[i]);
    }
    
    double max = -100;
    for (i = 0; i < size; ++ i) {
      if (max < nums[i]) {
        max = nums[i];
      }
    }    
    
    System.out.printf ("\nThe max is %.2f\n", max);
  }
}
