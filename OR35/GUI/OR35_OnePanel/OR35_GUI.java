import javax.swing.JFrame;
 
public class OR35_GUI {
  public static void main(String[] args) {
    OR35_Panel panel;
    panel = new OR35_Panel();
    
    JFrame frame = new JFrame("L");
    frame.setSize(400, 100);
    frame.setLocation(50, 50);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setContentPane(panel);
    frame.setVisible(true);
  }
}
