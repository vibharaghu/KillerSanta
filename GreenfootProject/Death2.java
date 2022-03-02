import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Death2 here.
 * Death2.class is the death screen that pops up when you die in the forest.
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Death2 extends World
{
    private GreenfootImage caught; // world image
    private GreenfootSound laugh; //sound
    private int settingSound; //sets sound replay
    private Home h; //home button
    private Restart r; //restart button
    /**
     * Constructor for objects of class Death2.
     * 
     */
    public Death2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        
        caught = new GreenfootImage("Death.png");
        laugh = new GreenfootSound("SantaLaugh.wav");
        r = new Restart(2);
        h = new Home();
        
        settingSound = 0;
        caught.scale(getWidth(), getHeight());
        setBackground(caught);
        addObject(h, getWidth()/7, getHeight()/2);
        addObject(r, getWidth()*6/7, getHeight()/2);
    }
    public void act()
    {
        if(settingSound == 0) //plays sound and stops if world switched
        {
          laugh.play();
          settingSound = 1;
        }
        if(h.switchTitle() || r.switchToForest())
        {
            laugh.stop();
        }
    }
    
}
