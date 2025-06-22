public class IntegerBot {
  private int integer;

  public IntegerBot () {
    integer = 0;
  }
  
  public IntegerBot (int n) {
    integer = n;
  }
  
  public int get () { // accessor, getter
    return integer;
  }  
  
  public void set (int n) { // mutators, modifier, setter
    integer = n;
  }
  
  public boolean can_divide (int n) {
    while (n >= integer) {
      n -= integer;
    }
    
    return n == 0;
  }
}

