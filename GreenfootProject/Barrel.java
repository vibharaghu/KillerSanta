import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Barrel here.
 * Barrel.class it used as a platform for the kid to jump onto.
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Barrel extends Actor
{
    private int width; //image width
    private int height; //image height
    private int speed; //speed of movement
    /**
     * Act - do whatever the Barrel wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Barrel(int n)
    {
        speed = n;
        width = getImage().getWidth();
        height = getImage().getHeight();
    }
    public void act() 
    {
       setLocation(getX()-speed, getY());
    }    
}
