public class Spaceship extends Sprite
{
  boolean hit = false;
  int numberHit = 0;
  public Spaceship()
  {
    super(825, 650, 50, 50, "Spaceshippy.png");
    numberHit = 0;
  }
  
  public void gotHit()
  {
    hit = true;
  }
  
  public boolean isOrAlreadyHit()
  {
    if (hit)
    {
      numberHit++;
      return true;
    }
    else
      return false;
  }
  
  public int numberTimesHit()
  {
    return numberHit;
  }
  
  public void resetHit()
  {
    hit = false;
  }
  
}