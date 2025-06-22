public class IntegerBot extends IntegerBotBase {
  public IntegerBot () {
    integer = 0;
  }
  
  public IntegerBot (int n) {
    integer = n;
  }
    
  @Override  // Preferred. The compiler will help check.
  public boolean can_divide (int n) {
    while (n >= integer) {
      n -= integer;
    }
    
    return n == 0;
  }
}

