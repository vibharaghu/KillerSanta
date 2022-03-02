import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Presents here.
 * Presents.class is used as a score count for the kid when ever the kid touches one
 * and it is ammuntion for thowing presents.
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Presents extends Actor
{
    private GreenfootImage present1; //actor image
    private int num;//controls speed of movement
    /**
     * Act - do whatever the Presents wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Presents(int n)
    {
       num = n; 
       present1 = new GreenfootImage("Present.png");
    }
    
    public void act() 
    {
       setLocation(getX()-num, getY()); //speed of object
    } 
    
    
}
