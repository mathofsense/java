public class IntegerBot extends IntegerBotBase implements IntegerBotOp {
  public IntegerBot () {
    // integer = 0; does not work any more
    set (0);
  }
  
  public IntegerBot (int n) {
    // integer = n; does not work any more
    set (n);
  }
    
  @Override  // Preferred. The compiler will help check.
  public boolean can_divide (int n) {
    int integer = get ();
    while (n >= integer) {
      n -= integer;
    }
    
    return n == 0;
  }
}

