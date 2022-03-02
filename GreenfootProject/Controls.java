import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * Controls.class shows the controls of the game and your goal of what to do.
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Controls extends World
{
    Start s; //start button
    Patrick sergpat; //patrick
    GreenfootSound Carol; //music
    GreenfootImage control; //world
    public Controls()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        s = new Start(1);
        sergpat = new Patrick();
        Carol = new GreenfootSound("CarolOfTheBells.wav");
        control = new GreenfootImage("instuctions.png");
        
        control.scale(getWidth(), getHeight());
        setBackground(control);
        
        addObject(s, getWidth()/4, 400);
        addObject(sergpat, 600, 400);
       
    }
    public void act()
    {
        if(!Carol.isPlaying()) //plays song
          Carol.playLoop();
       
        
        if (s.switchToStory()) //stops if switched to Story world
       {
         Carol.stop();
         
       }
        
    }
}
