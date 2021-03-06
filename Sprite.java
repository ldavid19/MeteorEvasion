import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.imageio.*;

public class Sprite
{
  private double left;  //the x-coordinate of the left edge of the sprite
  private double top;   //the y-coordinate of the top edge of the sprite
  private int width;
  private int height;
  private String image;
  
  public Sprite(double theLeft, double theTop, int theWidth, int theHeight, String theImage)
  {
    left = theLeft;
    top = theTop;
    width = theWidth;
    height = theHeight;
    setImage(theImage);
  }
  
  public double getLeft()
  {
    return left;
  }
  
  public void setLeft(double l)
  {
    left = l;
  }
  
  public double getTop()
  {
    return top;
  }
  
  public void setTop(double t)
  {
    top = t;
  }
  
  public int getWidth()
  {
    return width;
  }
  
  public void setWidth(int w)
  {
    width = w;
  }
  
  public int getHeight()
  {
    return height;
  }
  
  public void setHeight(int h)
  {
    height = h;
  }
  
  public String getImage()
  {
    return image;
  }
  
  public void setImage(String i)
  {
    image = i;
  }
  
  public double getMiddleX()
  {
    return left + width / 2;
  }
  
  public double getMiddleY()
  {
    return top + height / 2;
  }
  
  public void step(World world)
  {
    
  }
  
  public boolean overlaps(Sprite other)
  {
    double x1 = getMiddleX();
    double y1 = getMiddleY();
    double x2 = other.getMiddleX();
    double y2 = other.getMiddleY();
    double distance = Math.sqrt((x1 - x2)*(x1 - x2) + (y1 - y2)*(y1 - y2));
   
    
    if (distance <= (getHeight() + 15) / 2.0)
    {
     System.out.println("RESTART");
     return true;
    }
    else
      return false;
    }
  }
