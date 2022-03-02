
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FlyingRo here.
 * FlyingRo.class is an enemy for kid.class meant to be an obstacle to make it difficult for the kid to escape from santa.class. 
 * FlyingRo.class is spawned in randomly at a rate that does not make it hard for the kid to avoid them, but not easy either.
 * Also, this class moves to the left of the world to make it look as if the kid.class is moving through the factory. 
 * This class also drops to the minimum height when above a certain y value at a random time.


 * @author (your name) 
 * @version (a version number or a date)
 */
public class FlyingRo extends Actor
{
   
    private GreenfootImage FR1; //animation frames
    private GreenfootImage FR2;
    private GreenfootImage redFR1;//red animation frames
    private GreenfootImage redFR2;
    private int count;//controls time between frame switch
    private int size;//size of image
    private int Width; //image width
    private int Height;//image height
    private int vspeed;//speed of desend
    private int acceleration;//acceleration of fall
    private int setting; //continues falling even if below required height
    private int num; //random falling point
    private int speed;//speed of movement
    private int set; //creates a random falling point once
    private int setting2;//locks turning red position
    public FlyingRo(int n)
    {
        speed = n;
        FR1 = new GreenfootImage("1.png");
        FR2 = new GreenfootImage("2.png");
        redFR1 = new GreenfootImage("red1.png");
        redFR2 = new GreenfootImage("red2.png");
        count = 1;
        size = 130;
        Width = getImage().getWidth();
        Height = getImage().getHeight();
        vspeed = 0;
        acceleration = 1;
        setting = 0;
        set = 0;
        setting2 = 0;
    }
    public void act() 
    {
       colorChange();
        fall();
        count++;
        if(getY() > 650) //remove if out of world
           getWorld().removeObject(this);
    } 
    public void colorChange()//changes color of image when about to drop 
    {
        if(getX() >= num + 75)
        moving();
       else if(getY()<=getWorld().getHeight()*5/12 || setting2 == 1)
       {
        movingRed();
        setting2 = 1;
       }
       else
        moving();
    }
    public void moving() //normal animation sequence
    {
        if (count == 1){
            FR1.scale(size,size);
            setImage(FR1);
        }
        else if( count % 20 == 0){
            FR2.scale(size,size);
            setImage(FR2);
            
        }
        else if( count % 10 == 0){
            FR1.scale(size,size);
            setImage(FR1);
        }
        if (count > 30)
       
            count=0;
         
       setLocation(getX()-speed, getY());
       
    }
    public void movingRed() //red animation sequence to alert the player
    {
        if (count == 1){
            redFR1.scale(size,size);
            setImage(redFR1);
        }
        else if( count % 20 == 0){
            redFR2.scale(size,size);
            setImage(redFR2);
            
        }
        else if( count % 10 == 0){
            redFR1.scale(size,size);
            setImage(redFR1);
        }
        if (count > 30)
       
            count=0;
         
       setLocation(getX()-speed, getY());
       
    }
   
    public void fall() //falls at a random point
    {
        if(!checkFall() && set == 0) //checks if not falling and assigns a random point
        {
          random();
          set = 1;
        }
         if(getY() <= getWorld().getHeight()*5/12 || setting == 1 ) //falls if below certain height
         {

           if(getX() <= num) //starts falling
           {
                vspeed = vspeed + acceleration;
                
                setLocation (getX(), getY() + vspeed); 
                
                setting = 1;
               
           }
        }
        else 
        {
            setting = 0;
        }
    }
    public void random()//random number to fall
    {
        num = Greenfoot.getRandomNumber(900) + 50;
    }
    public boolean checkFall() //checks if already falling
    {
        boolean result = false;
        if (getX() < num)
       {
        result = true;
       }
       return result;
    }
}


