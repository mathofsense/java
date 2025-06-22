/****************************************************
 * An IntegerBot contains an integer, and can check if
 * a given number is divisible by this integer.
 * @author Leo Math, email: mathofsense@gmail.com
 * @version 06.22.2025
*****************************************************/
public class IntegerBot {
  /**
   * The integer that will be checked if a given is divisible by.
   */
  private int integer;

  /**
   * Initialize an IntegetBox by settig the integer to 0.
   */
  public IntegerBot () {
    integer = 0;
  }
  
  /**
   * Initialize an IntegetBox by setting the integer to the given paremeter.
   * @param n The value that the integer will be set to.
   */  
  public IntegerBot (int n) {
    integer = n;
  }
  
  /**
   * Provide the integer value.
   * @return The integer stored in the IntegerBot.
   */
  public int get () { // accessor, getter
    return integer;
  }  
  
  /**
   * Set the integer to the given paremeter.
   * @param n The value that the integer will be set to.
   */    
  public void set (int n) { // mutators, modifier, setter
    integer = n;
  }
  
  /** 
   * Check if the parameter n is divisible by the integer stored in the IntegerBox.
   * @param n The number to be checked for divisibility.
   * @return True if divisible, false otherwise.
   */
  public boolean can_divide (int n) {
    while (n >= integer) {
      n -= integer;
    }
    
    return n == 0;
  }
}

