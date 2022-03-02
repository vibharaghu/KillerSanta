import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Restart here.
 * restart.class is used to move between world classes when clicked on by the player with the mouse.

 * @author (your name) 
 * @version (a version number or a date)
 */
public class Restart extends Actor
{
    private GreenfootImage restart; // sets image
    private int switchTo; //changes world
    /**
     * Act - do whatever the Next wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Restart (int n)
    {
        restart = new GreenfootImage("Reset.png");
        switchTo = n;
    }
    public void act() 
    {
        
        if (switchTo == 1) //changes to factory world
         switchToFactory();
        else //changes to Forest world
         switchToForest();
    }    
    public boolean switchToFactory()//switches to Factory world and returns true
    {
        if(Greenfoot.mousePressed(this))
        {
            Greenfoot.setWorld(new Factory());
            
        }
        boolean result = false;
        if(Greenfoot.mousePressed(this))
        {
            result = true;
            
        }
        
        return result;
    }
    public boolean switchToForest() //switches to Forest world and returns true
    {
        if(Greenfoot.mousePressed(this))
        {
            Greenfoot.setWorld(new Forest());
            
        }
        boolean result = false;
        if(Greenfoot.mousePressed(this))
        {
            result = true;
            
        }
        
        return result;
    }
}
