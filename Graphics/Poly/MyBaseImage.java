import java.awt.image.BufferedImage;

public abstract class MyBaseImage extends BufferedImage {

  public MyBaseImage (int width, int height) {
    super (width, height, BufferedImage.TYPE_INT_RGB);
  }
  
  public abstract void draw ();
} 