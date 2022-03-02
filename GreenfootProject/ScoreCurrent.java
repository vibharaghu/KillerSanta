import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ScoreCurrent here.
 * ScoreCurrent.class shows the current score in game
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreCurrent extends Actor
{
    private GreenfootImage newImage; //score box
    public ScoreCurrent ()
    {
        newImage = new GreenfootImage (170,50);
        setImage(newImage);
    }
    public void setScore(int score)//sets score during game
    {
        newImage.clear();
        Font f = new Font("Courier New", true, false, 22); 
        newImage.setFont(f);
        Color c = new Color(50, 130, 50);
        newImage.setColor(c);
        newImage.fill();
        newImage.setColor(Color.WHITE);
        newImage.drawString("Presents:" + score, 5, 33);
        setImage(newImage);
    }   
    
}
