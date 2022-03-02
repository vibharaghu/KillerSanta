import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Blaster here.
 * Blaster.class shoots a candycane when game is complete
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Blaster extends Actor
{
    private GreenfootImage cane; //cane image
    private int count; //counter for animation to be spaced
    private int rotate; //rotates image
    public Blaster ()
    {
        cane = new GreenfootImage ("CandyCane.png");
        count = 0;
        rotate = 0;
    }
    public void act() 
    {
        animation();
        setLocation(getX()-2, getY());
        count++;
    }    
    public void animation() //spinning and size animation
    {
        setImage(cane);
        setRotation(rotate);
        rotate += 10;
       
        if (count >= 0) 
        {
         cane.scale(25,25);
         setImage(cane);
        
        }
       if (count > 40) 
       {
           cane.scale(50, 50);
           setImage(cane);
           
        }
        if (count > 70) 
        {
           cane.scale(100, 100);
           setImage(cane);
           
        }
        if (count > 100) 
        {
           cane.scale(175, 175);
           setImage(cane);
           
        }
        if (count > 130) {
           cane.scale(275, 275);
           setImage(cane);
           
        }
        if (count > 160) 
        {
           cane.scale(400, 400);
           setImage(cane);
           
        }
        if (count > 190) 
        {
           cane.scale(550, 550);
           setImage(cane);
           
        }
        
    }
}
