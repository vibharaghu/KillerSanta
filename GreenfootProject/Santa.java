import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Santa here.
 * Santa.class is an enemy for kid.class meant to prevent the kid from going too far left in the world.
 * Santa.class does this by coming into the screen from the left when ever the kid is at a location that is less than half the x value of the world.

 * @author (your name) 
 * @version (a version number or a date)
 */
public class Santa extends Actor
{
    private GreenfootImage santa1; //image frames running
    private GreenfootImage santa2;
    private GreenfootImage santa3;
    private GreenfootImage santa4;
    private GreenfootImage santa11;//image frames dying
    private GreenfootImage santa12;
    private GreenfootImage santa13;
    private GreenfootImage santa14;
    private int count; //controls space between frames
    
    public Santa ()
    {
        santa1 = new GreenfootImage("Santa1.png");
        santa2 = new GreenfootImage("Santa2.png");
        santa3 = new GreenfootImage("Santa3.png");
        santa4 = new GreenfootImage("Santa4.png");
        santa11 = new GreenfootImage("Santa10.png");
        santa12 = new GreenfootImage("Santa11.png");
        santa13 = new GreenfootImage("Santa12.png");
        santa14 = new GreenfootImage("Santa13.png");
        count = 0;
        
    }
    public void act() 
    {

         count++;
         move();
        
    } 
    public void animation() //shows animation of image
    {
        if (count == 1)
           {
            santa1.scale(400,400);
            setImage(santa1);
        }
        
        else if( count % 40 == 0)
            {
            santa4.scale(400,400);
            setImage(santa4);
        }
        else if( count % 30 == 0)
            {
            santa3.scale(400,400);
            setImage(santa3);
        }
        else if( count % 20 == 0)
            {
            santa2.scale(400,400);
            setImage(santa2);
        }
        else if( count % 10 == 0)
            {
            santa1.scale(400,400);
            setImage(santa1);
        }
            
        if (count > 40)
       
            count=0;
    }
    public void move() //moves character along the screen
    {
        if (getX()< 150)
            setLocation(getX()+2, getY());
    }
    public void moveBack(int num) //moves character back
    {
        
         setLocation(getX()-num, getY());
        
    }
    
    public void deathAnim() //Animation called when Santa dies
    {
      if (count == 1)
           {
            santa11.scale(400,400);
            setImage(santa11);
        }
        
        else if( count % 80 == 0)
            {
            santa14.scale(400,400);
            setImage(santa14);
        }
        else if( count % 60 == 0)
            {
            santa13.scale(400,400);
            setImage(santa13);
        }
        else if( count % 40 == 0)
            {
            santa12.scale(400,400);
            setImage(santa12);
        }
        else if( count % 20 == 0)
            {
            santa11.scale(400,400);
            setImage(santa11);
        }
            
        if (count > 100)
       
            count=0;  
    }
    
    
}
