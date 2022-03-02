import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Home here.
 * Home.class is used to move between world classes when clicked on by the player with the mouse.
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Home extends Actor
{
    private GreenfootImage Home;
    /**
     * Act - do whatever the Next wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Home()
    {
        Home = new GreenfootImage("Home.png");
    }
    public void act() 
    {
        switchTitle();
    }    
    public boolean switchTitle() //returns true if object is pressed and changes to Title World
    {
        if(Greenfoot.mousePressed(this))
        {
            Greenfoot.setWorld(new Title());
            
        }
        boolean result = false;
        if(Greenfoot.mousePressed(this))
        {
            result = true;
            
        }
        return result;
    }
}
