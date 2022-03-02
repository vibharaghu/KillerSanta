import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ThrowPresent here.
 * ThrowPresents.class allows the kid to throw presents with the sapce button
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ThrowPresent extends Actor
{
    private GreenfootImage present2; //actor image when thrown
    private GreenfootImage impact; //actor image when in contact with Enemy
    private int rotate;//rotates image
    private int count;//controls space between frames
    public ThrowPresent()
    {
        present2 = new GreenfootImage("Present.png");
        impact = new GreenfootImage("Impact.png");
        rotate = 0;
        count = 0;
    }
    public void act() 
    {
        throwing();
    }
        
       
    public boolean hit() //returns true if ThrowPresent hits a Snow or FlyingRo
    {
        boolean result = false;
        if(isTouching(Snow.class) || isTouching(FlyingRo.class))
        {
            result = true;
        }
        return result;
    }
    
    public void throwing() //throwing animation until in contact with enemy and then impact is created and enemies removed
    {
        if (hit())
        {
            impact.scale(50,50);
            setImage(impact);
            count++;
            setLocation(getX()+1, getY());
            if(count>2){
             impact.scale(100,100);
             setLocation(getX()+1, getY());
            }
            if(count>6){
             impact.scale(200,200);
             setLocation(getX()+1, getY());
            }
            if(count>12)
             impact.scale(300,300);
            if (count > 15)
            {
              removeTouching(Snow.class);
              removeTouching(FlyingRo.class);
              count=0;
              getWorld().removeObject(this);
            }
        }
        else 
        {
            setLocation(getX()+8, getY());
            setRotation(rotate+=20);
            present2.scale(40,40);
            setImage(present2);
        }
    }
    
    
        
    
    
}
