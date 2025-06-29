import javax.swing.JFrame;
 
public class MyFirstGUI {
  public static void main(String[] args) {
    JFrame frame = new JFrame("L");
    frame.setSize(400, 300);
    frame.setLocation(50, 50);
    frame.setDefaultCloseOperation(
                       JFrame.EXIT_ON_CLOSE);
    frame.setContentPane(new ClickablePanel());
    frame.setVisible(true);
  }
}
