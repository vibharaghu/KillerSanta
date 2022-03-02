import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Elf here.
 * Elf.class is an enemy for kid.class meant to be an obstacle to make it difficult for the kid to escape from santa.class. 
 * Elf.class is spawned in randomly at a rate that does not make it hard for the kid to avoid them, but not easy either.
 * Also, this class moves to the left of the world to make it look as if the kid.class is moving through the factory.
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Elf extends Actor
{
    
    private GreenfootImage elf1; //walking images
    private GreenfootImage elf2;
    private GreenfootImage elf3;
    private GreenfootImage elf4;
    private GreenfootImage elf5;
    private GreenfootImage elf6;
    private GreenfootImage elf7;
    private GreenfootImage elf8;
    private GreenfootImage elf9;
    private GreenfootImage elf10;
    private int count = 0; //spacing between frames
    private int Width; //image width
    private int Height; //image height
    public Elf()
    {
        elf1 = new GreenfootImage("Elf1.png");
        elf2 = new GreenfootImage("Elf2.png");
        elf3 = new GreenfootImage("Elf3.png");
        elf4 = new GreenfootImage("Elf4.png");
        elf5 = new GreenfootImage("Elf5.png");
        elf6 = new GreenfootImage("Elf6.png");
        elf7 = new GreenfootImage("Elf7.png");
        elf8 = new GreenfootImage("Elf8.png");
        elf9 = new GreenfootImage("Elf9.png");
        elf10 = new GreenfootImage("Elf10.png");
        count = 0;
        Width = getImage().getWidth();
        Height = getImage().getHeight();
    }
    public void act() 
    {
         moving();
         count++;  
        if(getX() < -50) //removes object after out of screen
         getWorld().removeObject(this);
          
    }
    public void moving() //animation sequence and movement
    {
        if (count == 1)
            setImage(elf1);
        else if (count % 100 == 0)
            setImage(elf10);
        else if( count % 90 == 0)
            setImage(elf9);
        else if( count % 80 == 0)
            setImage(elf8);
        else if( count % 70 == 0)
            setImage(elf7);
        else if( count % 60 == 0)
            setImage(elf6);
        else if( count % 50 == 0)
            setImage(elf5);
        else if( count % 40 == 0)
            setImage(elf4);
        else if( count % 30 == 0)
            setImage(elf3);
        else if( count % 20 == 0)
            setImage(elf2);
        else if( count % 10 == 0)
            setImage(elf1); 
        if (count > 100)
       
            count=0;
         
        setLocation(getX()-2, getY());
    }
    
    
}
