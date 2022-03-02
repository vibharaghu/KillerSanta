import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Story here.
 * Story.class gives a breif description of what is happening 
 * in this fictional world.
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Story extends World
{
    private Start s; //start button
    private Patrick sergpat;   //patrick
    private GreenfootSound Carol; //sound
    private GreenfootImage story; //world image
    public Story()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        story = new GreenfootImage("story.png");
        Carol = new GreenfootSound("CarolOfTheBells.wav");
        s = new Start(2);
        sergpat = new Patrick();
        story.scale(getWidth(), getHeight());
        setBackground(story);
        
        addObject(s, 255, getHeight()/4 + 25);
        addObject(sergpat, getWidth()/4, 394);
       
    }
    public void act()
    {
        if(!Carol.isPlaying()) //plays carol
          Carol.playLoop();
       
        
        if (s.switchToFactory()) //stops carol if world is switched
       {
         Carol.stop();
         
       }
        
    }
}