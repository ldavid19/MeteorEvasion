public class MobileSprite extends Sprite
{
  public double vx;
  public double vy;
  
  public MobileSprite(double left, double top, int width, int height, String image,
                      double velocityX, double velocityY)
  {
    super(left, top, width, height, image);

    vx = velocityX;
    vy = velocityY;
  }
  
  public double getVY()
  {
    return vy;
  }
  
  public void setVY(double velocityY)
  {
    vy = velocityY;
  }
  
  public void step(World world)
  {
    if (getLeft() < 375)
      vx = Math.abs(vx);
    if (getLeft() + getWidth() > world.getWidth())
      vx = -Math.abs(vx);
    if (getTop() + getHeight() > world.getHeight())
      vy = -Math.abs(vy);
    if (getTop() < 0)
      vy = Math.abs(vy);
    
    setLeft(getLeft() + vx);
    setTop(getTop() + vy);
    
  }
}