import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class End here.
 * End.class is the world shown when the game is completed
 * @author (your name) 
 * @version (a version number or a date)
 */
public class End extends World
{
    private GreenfootImage end; //world image
    private GreenfootSound SN; //silent night sound 
    private GreenfootSound child; //child laughing sound
    private EvilPatrick p; //evilpatrick
    private Home h; //homebutton
    private int count; //controls how often child is played
    /**
     * Constructor for objects of class End.
     * 
     */
    public End()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1);
        
        end = new GreenfootImage("End.png");
        SN = new GreenfootSound("SilentNight.wav");
        child = new GreenfootSound("ChildLaugh.wav");
        p = new EvilPatrick();
        h = new Home();
        count = 0;
        
        end.scale(getWidth(), getHeight());
        setBackground(end);
        addObject(p, 730, 500);
        addObject(h, getWidth()/3, 500);
    }
    public void act()
    {
        count++;
        SN.playLoop();
        if(h.switchTitle()) //stops sound if world switch
        {
         SN.stop();
         child.stop();
        }
        
        if(count%5000 == 0) //plays child laugh
         child.play();
         
    }
    
}
