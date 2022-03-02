import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Death here.
 * Death.class the death screen that shows up when you die in the factory
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Death extends World
{
    private GreenfootImage caught; //world image
    private GreenfootSound laugh; //sound
    private int settingSound; //controls replay of sound
    private Home h; //home button
    private Restart r; //restart button
    /**
     * Constructor for objects of class Death.
     * 
     */
    public Death(int n)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        caught = new GreenfootImage("Death.png");
        laugh = new GreenfootSound("SantaLaugh.wav");
        h = new Home();
        r = new Restart(n);
        
        caught.scale(getWidth(), getHeight());
        setBackground(caught);
        addObject(h, getWidth()/7, getHeight()/2);
        addObject(r, getWidth()*6/7, getHeight()/2);
        settingSound = 0;
        
    }
    public void act()
    {
        if(settingSound == 0)//plays laugh once 
        {
          laugh.play();
          settingSound = 1;
        }
        if(h.switchTitle() || r.switchToFactory()) //stops laugh and switches to other worlds
        {
            laugh.stop();
        }
    }
    
}
