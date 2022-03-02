import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ForestStory here.
 * ForestStory.class is the next part of the storyline after beating the first level
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ForestStory extends World
{
    private GreenfootSound Carol; //sound
    private GreenfootImage forestStory; //world image
    private Start s; //start button
    private Patrick patrick;
    /**
     * Constructor for objects of class ForestStory.
     * 
     */
    public ForestStory()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1);
        Carol = new GreenfootSound("CarolOfTheBells.wav");
        forestStory = new GreenfootImage("story2.png");
        s = new Start (3);
        patrick = new Patrick();
        forestStory.scale(getWidth(),getHeight());
        setBackground(forestStory);
        
        addObject(s, 250, 200);
        addObject(patrick, 342, 458);
        
    }
    public void act()
    {
        if(!Carol.isPlaying()) //plays carol
          Carol.playLoop();
       
        if (s.switchToForest()) //stops playing if world switch
       {
         Carol.stop();
         
       }
    }
    
    
}
