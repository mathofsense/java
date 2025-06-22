public class MegaIntegerBot extends IntegerBot { // derived class, subclass
  private int integer2;

  public MegaIntegerBot () {
    super ();
    integer2 = 0;
  }
  
  public MegaIntegerBot (int n1, int n2) {
    super (n1);
    integer2 = n2;
  }
  
  // "public int[] get ()" won't work
  public int[] get_all () { 
    int [] rv = new int[2];
    rv[0] = super.get ();
    rv[1] = integer2;
    return rv;
  }  
  
  public void set (int n1, int n2) { // does NOT override
    super.set (n1);
    integer2 = n2;
  }
  
  @Override
  public boolean can_divide (int n) {
    int integer = super.get ();
    while (n >= integer) {
      n -= integer;
    }
    
    return n == 0 ? true : super.can_divide (n);
    /* Equivalent to:
       if (n == 0) {
         return true;
       }
       else {
         return super.can_divide (n);
       }
     */
  }
}

