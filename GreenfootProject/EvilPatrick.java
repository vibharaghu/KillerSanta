import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EvilPatrick here.
 * EvilPatrick.class makes patricks eyes red.
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EvilPatrick extends Actor
{
    private GifImage patrick; //actor image 
    
    public EvilPatrick()
    {
        patrick = new GifImage ("EvilPatrick.gif");
    }
    public void act() 
    {
        setImage(patrick.getCurrentImage()); //gif cycle
    }    
}
