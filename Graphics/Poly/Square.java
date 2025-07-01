import java.awt.image.*;
import java.awt.*;

public class Square extends MyBaseImage {
  int side_length;
  Color color;

  public Square (int width, int height, int len, Color c) {
    super (width, height);
    side_length = len;
    color = c;
  }
  
  public void draw () {
    Graphics2D g = (Graphics2D) getGraphics();
    int width = getWidth ();
    int height = getHeight ();    
    
    g.setColor (color);
    g.setStroke (new BasicStroke (5.0f));
    g.drawRect ((width - side_length) / 2, (width - side_length) / 2, side_length, side_length);
  }
} 