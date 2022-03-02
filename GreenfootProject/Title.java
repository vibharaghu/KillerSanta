import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Title screen: Starts game and shows game name.
 * 
 * Vibha Raghu, Joey Hudson 
 * @version (a version number or a date)
 */
public class Title extends World
{
    private GreenfootSound Carol;//music
    private GreenfootImage Outfactory; //image
    private Start s; // Start button. Sends to Story
    private Instruction i;// Instructions button. Sends to Controls
    /**
     * Constructor for objects of class Title.
     * 
     */
    public Title()
    {    
        // Create a new world with 1000x600 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        
        Outfactory = new GreenfootImage("Title.png"); //Sets image as title
        Outfactory.scale(getWidth(),getHeight()); //Scales to screen
        setBackground(Outfactory);
        Greenfoot.start(); //Start world automatically
        
        Carol = new GreenfootSound("CarolOfTheBells.wav"); //instantiates new sound and buttons
        s = new Start(1);
        i = new Instruction();
        
        addObject(s, getWidth()/2, getHeight()/2 + 25); //adds objects to world.
        addObject(i, getWidth()/2, getHeight()/2 + 175); 
        addObject(new Patrick(), 743, 378); 
        addObject(new Patrick(), 223, 378);
        
       
    }
    public void act()
    {
       if(!Carol.isPlaying())
          Carol.playLoop();
       //starts sound
       
        if (i.switchToInstruct() ||  s.switchToStory())
       {
         Carol.stop();
         //stops sound if either buttons are pressed. 
       }
    }
      
    /* Citations
     * Elf - https://www.deviantart.com/bhldrr/art/A-little-elf-walking-684781620
     * Santa - http://www.twobitart.com
     * Kid - https://amandawangzy.com/portfolio/pixel-art/
     * Barrel - http://pixelartmaker.com/art/1e60bc9507863a1
     * FlyingRo - https://gifer.com/en/I3p5
     * Presents - http://pixelartmaker.com/art/3cbb9a5db779562
     * Snow - http://photobucket.com/gifs/snowman%20pixels
     * Patrick - http://spongebob.wikia.com/wiki/File:Pixel-art-christmas-spongebob-patrick-1760195.gif
     * Title screen - https://openclipart.org/detail/310204/pixel-scene
     * Factory - https://www.deviantart.com/sonicmechaomega999/art/Robot-Factory-Sprite-Background-580390989
     * Forest - https://ansimuz.itch.io/parallax-forest
     * End - https://weheartit.com/entry/263743534
     * Rest of Worlds and Objects made at https://www.pixilart.com
     * Carol - https://www.youtube.com/watch?v=yKdjSUEHaJ0
     * Chase -https://www.youtube.com/watch?v=BVeqk_tPtnE
     * Yay - https://www.youtube.com/watch?v=waRq6ZR7BNE
     * Evil laugh - https://www.youtube.com/watch?v=1P526n6wfP4
     * SilentNight - https://www.youtube.com/watch?v=REk9Ia6eYXk
     * 
     */
    
    
    
    
}
