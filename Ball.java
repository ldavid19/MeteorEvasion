public class Ball extends MobileSprite
{
  private boolean hit = false;
  public Ball(double position, double velocitySpeed)
  {
    super(position, 
          0, 90, 90, "meteor.png", 
          Math.cos(Math.random() * 2 * Math.PI) + velocitySpeed, Math.sin(Math.random() * 2 * Math.PI) + velocitySpeed);
    
    
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
    
    Spaceship someSpaceship = world.getSpaceship();
    
    if (this.overlaps(someSpaceship))
    {
      someSpaceship.setLeft(250);
      someSpaceship.setTop(650);
      someSpaceship.gotHit();
    }
  }
  
  
  //if (coolShip.isOrAlreadyHit())
        //g.drawString("# Times Died =" + coolShip.numberTimesHit(), 0, 0);
}