import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Start: controls world changes and music
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Start extends Actor
{
   private GreenfootImage start; //actor image
   private int switching;//controls changes to different worlds
   
    /**
     * Act - do whatever the Start wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Start(int n)
    {
        switching = n;
        start = new GreenfootImage("Start.png");
        
    }
    public void act() 
    {
        start.scale(240, 120);//sets image
        setImage(start);
        
       if(switching == 1)
         switchToStory();
       else if (switching == 2)
        switchToFactory();
       else 
        switchToForest();
       
       //changes to different worlds
        
    }

    public boolean switchToStory() //switches to Story world
    {
        if(Greenfoot.mousePressed(this))
        {
            Greenfoot.setWorld(new Story());
            
        }
        boolean result = false;
        if(Greenfoot.mousePressed(this))
        {
            result = true;
        }
        return result;
    }
    public boolean switchToFactory() //changes to Factory world
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
    public boolean switchToForest() //changes to Forest world
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
