import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Next here.
 * Next.class is used to move between world classes when clicked on by the player with the mouse.
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Next extends Actor
{
    private GreenfootImage next; //actor image
    private int switching;//switches world based on current world
    /**
     * Act - do whatever the Next wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Next(int n)
    {
        next = new GreenfootImage("Next.png");
        switching = n;
    }
    public void act() 
    {
        next.scale(440, 440);//image size
        setImage(next); 
        
        if(switching == 1) 
        switchForestStory();
        else
        switchToEnd();
    }    
    public boolean switchForestStory() //switches to ForestStory world and returns true
    {
        if(Greenfoot.mousePressed(this))
        {
            Greenfoot.setWorld(new ForestStory());
            
        }
        boolean result = false;
        if(Greenfoot.mousePressed(this))
        {
            result = true;
            
        }
        
        return result;
    }
    public boolean switchToEnd() //switches to End and returns true
    {
        if(Greenfoot.mousePressed(this))
        {
            Greenfoot.setWorld(new End());
            
        }
        boolean result = false;
        if(Greenfoot.mousePressed(this))
        {
            result = true;
            
        }
        return result;
    }
}
