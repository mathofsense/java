import javax.swing.*;
import java.awt.*;

public class LightPanel extends JPanel {
  public enum Light {RED, BLACK, GREEN};
  Light light;
  
  public LightPanel () {
    super ();
    light = Light.BLACK;
  }  

  public void SetLight (Light lit) {
    light = lit;
  }  

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.YELLOW);
    // drawOval(x, y, width, height): draws an oval bounded by the rectangle
    g.drawOval(150, 10, 100, 100); // x, y, width, height    
    switch (light) {
      case Light.RED:
        g.setColor(Color.RED);
        break;
      case Light.GREEN:  
        g.setColor(Color.GREEN);
        break;
      default:
        g.setColor(Color.BLACK);
    }          
    g.fillOval(150, 10, 100, 100); // x, y, width, height
  }
}
