import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Timer here.
 * Timer.class shows current time
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Timer extends Actor
{
    private GreenfootImage newImage; //timer box
   public Timer ()
    {
        newImage = new GreenfootImage (160,50);
        setImage(newImage);
    }
   public void setTime(int time) //sets the timer during game
   {
        newImage.clear();
        Font f = new Font("Courier New", true, false, 22); 
        newImage.setFont(f);
        Color c = new Color(130, 50, 50);
        newImage.setColor(c);
        newImage.fill();
        newImage.setColor(Color.WHITE);
        newImage.drawString("Timer:" + time, 10, 33);
        setImage(newImage);
    }    
}
