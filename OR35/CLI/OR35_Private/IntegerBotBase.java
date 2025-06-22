abstract class IntegerBotBase {
  private int integer;

  public int get () { // accessor, getter
    return integer;
  }  
  
  public void set (int n) { // mutators, modifier, setter
    integer = n;
  }
  
  public abstract boolean can_divide (int n);
}

