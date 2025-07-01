import java.awt.image.*;
import java.awt.*;

public class Circle extends MyBaseImage {
  int radius;
  Color color;

  public Circle (int width, int height, int r, Color c) {
    super (width, height);
    radius = r;
    color = c;
  }
  
  public void draw () {
    Graphics2D g = (Graphics2D) getGraphics();
    int width = getWidth ();
    int height = getHeight ();
    
    g.setColor(Color.WHITE);
    g.fillRect(0, 0, width, height);
    g.setColor (color); 
    g.setStroke (new BasicStroke (5.0f));
    g.drawOval ((width - radius) / 2, (width - radius) / 2, radius, radius);
  }
} 