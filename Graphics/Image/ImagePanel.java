import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ImagePanel extends JPanel {
  enum Direction { EAST, WEST, SOUTH, NORTH };
  int click_x, click_y;
  Direction direction;
  ImageIcon img;
  
  public ImagePanel () {
    super ();
    setFocusable(true);   
    addMouseListener (new  MouseListener ());
    addKeyListener (new DirListener ());
    click_x = -1;
    click_y = -1;
    direction = Direction.EAST;
    img = new ImageIcon ("smile.png");
  }  
  
  public void move_image () {
    if (click_x < 0 || click_y < 0 || click_x >= getWidth () || click_y >= getHeight ()) {
      return;
    }
  
    switch (direction) {
      case EAST:
        click_x += 1;
        break;
      case WEST:
        click_x -= 1;
        break;
      case SOUTH:
        click_y += 1;
        break;
      case NORTH:
        click_y -= 1;
    }
    
    repaint ();
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);  
    Graphics2D g2  = (Graphics2D) g;
    if (click_x >= 0 && click_y >= 0 && click_x < getWidth () && click_y < getHeight ()) {
      g2.setColor(Color.RED);
      g2.setStroke (new BasicStroke (5.0f));
      g2.drawOval(click_x, click_y, 100, 100); 
      int img_width = img.getImage ().getWidth (null);
      int img_height = img.getImage ().getHeight (null);
      g.drawImage (img.getImage (), click_x + 50 - img_width / 2, 
                   click_y + 50 - img_height / 2, null);
    }
  }
  
  private class MouseListener extends MouseAdapter {
    @Override
    public void mouseClicked(MouseEvent e) {
      // Get cursor position relative to this panel
      click_x = e.getX();
      click_y = e.getY();
      // System.out.println("Mouse clicked at: (" + x + ", " + y + ")");
      repaint ();
      requestFocusInWindow();
    }
  }
  
  private class DirListener extends KeyAdapter {
    @Override
    public void keyPressed(KeyEvent e) {
      int key_code = e.getKeyCode();
      
      // System.out.println ("Key pressed");
      
      switch (key_code) {
        case KeyEvent.VK_UP:
        case KeyEvent.VK_N:
          direction = Direction.NORTH;
          break;
        case KeyEvent.VK_DOWN:
        case KeyEvent.VK_S:
          direction = Direction.SOUTH;
          break;
        case KeyEvent.VK_LEFT:
        case KeyEvent.VK_W:
          direction = Direction.WEST;
          break;
        case KeyEvent.VK_RIGHT:
        case KeyEvent.VK_E:
          direction = Direction.EAST;
          break;                              
      }
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }   
  }   
}
