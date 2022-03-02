import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Kid here.
 * Kid.class is the character of the player. This class is controlled by the player by using key bindings. 
 * Kid.class can jump, move left, move right, and throw presents (in level 2). This character must avoid 
 * touching elf.class, santa.class , robot.class, and snow.class. 
 * The goal of the kid is to survive the level’s time limit while collecting presents by touching them.
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Kid extends Actor
{
    private GifImage kid; //actor gif image
    private GifImage kidLeft; //flipped actor gif image
    private int norm;//normal length of floor to ceiling
    private double vspeed;//speed of fall
    private double acceleration; //acceleration of fall
    private int barrelspeed; //speed of barrel so when touching barrel kid moves at the same speed
    private int Width;//width of image
    private int Height; //height of image
    public Kid (int n)
    {
        barrelspeed = n;
        kid = new GifImage ("RunningKidEdited.gif");
        kidLeft = new GifImage ("ezgif.com-rotate.gif");
        norm = 500;
        vspeed = 0;
        acceleration = 1.3;
        Width = getImage().getWidth();
        Height = getImage().getHeight();
    }
    public void act() 
    {
      controls();
      checkFall(); 
      checkEnemies();
      colPresents();
    }    
    
    
    public boolean checkEnemies() //checks if in contact with enemies and returns true
    {
       boolean sound = false;
       if (getOneObjectAtOffset(Width/-4 +1, Height/-2, Santa.class) != null ||
         getOneObjectAtOffset(Width/-4 +1, Height/2 +1, Santa.class) !=null ||
        getOneObjectAtOffset(Width/4 +3, Height/-2, Santa.class) != null||
         getOneObjectAtOffset(Width/4 +3, Height/2 -1, Santa.class) !=null)
         {
         sound = true;

        }
       if (getOneObjectAtOffset(Width/-5 +1, Height/-2, Elf.class) != null ||
        getOneObjectAtOffset(Width/5 +3, Height/-2, Elf.class) != null){ 

         sound = true;

        }
       if (getOneObjectAtOffset(Width/7 -3, Height/-2, Snow.class) != null) {

         sound = true;
        }
        if (getOneObjectAtOffset(Width/-7 -5, Height/-5-2, FlyingRo.class) != null ||
         getOneObjectAtOffset(Width/-7 -5, Height/5 -1, FlyingRo.class) !=null ||
        getOneObjectAtOffset(Width/7 -3, Height/-5 -2, FlyingRo.class) != null||
         getOneObjectAtOffset(Width/7 -3, Height/5 -1, FlyingRo.class) !=null)
         sound = true;
        return sound;
    }
    
     private void moveRight() //moves right
    {
        setImage(kid.getCurrentImage());
        move(5);
    }
    
    
     private void moveLeft() //moves left with flipped image
    {
        setImage(kidLeft.getCurrentImage());
        move(-5);
    }
    
    public void controls() //uses keys to move in different directions and speeds
    {
         if(Greenfoot.isKeyDown("right") && checkRight()) // moves right if right key is pressed
         {
           moveRight(); 
        
         }
         
         if(Greenfoot.isKeyDown("left") && checkLeft()) // moves left if left key is pressed
          {
         moveLeft(); 
          }
         if(this.isTouching(Barrel.class)) //moves back along with barrel if touching barrel
          {
           move(-barrelspeed);
          }
         if (Greenfoot.isKeyDown("up") && Ground()) //jumps if up is pressed or on Ground
           {
              jump();
           }
          
    }
    
    
    public void checkFall() //checks if falling and continues falling unless on ground or at the norm
    {
       if(getY() <= norm)
       {
           if(!Ground())
            fall();
           else
           {
            vspeed=0;
            while(Ground())
            {
                setLocation(getX(), getY()-1);
            }
           }
        }
       else 
       { 
            vspeed= 0;
        }
       
    }
    public boolean checkLeft() //checks if left of barrel
    {
        boolean left = true;
        if (getY() >= norm)
            left = true;
       
            
        if (getOneObjectAtOffset(Width/-2 -4, Height/-2, Barrel.class) != null ||
         getOneObjectAtOffset(Width/-2 -4, Height/2 -2, Barrel.class) !=null)
         left=false;
        
         return left;
    }
    public boolean checkRight() //checks if right of barrel or if at edge of world
    {
        boolean right = true;
        if (getY() >= norm)
            right = true;
        
            
        if (getOneObjectAtOffset(Width/2 +4, Height/-2, Barrel.class) != null ||
         getOneObjectAtOffset(Width/2 +4, Height/2 -2, Barrel.class) !=null)
         right=false;
         
        if(getX() > getWorld().getWidth() - 10)
        right = false; 
        
         return right;
    }
    
    public boolean Ground() //checks if on barrel
    {
        boolean OnGround = false;
        if (getY() >= norm)
            OnGround = true;
       
            
        if (getOneObjectAtOffset(Width/-2, Height/2, Barrel.class) != null ||
         getOneObjectAtOffset(Width/2, Height/2, Barrel.class) !=null)
         OnGround=true;
         
        
         return OnGround;
    }
    
     
    
    
    private void jump()//jumps to a certain height and falls
    { 
        vspeed = -25;
        setLocation (getX(), getY() + (int)vspeed);
        
        fall();
        
    }
    
    
    private void fall() //falls in a curve 
    {
        
        vspeed = vspeed + acceleration;
        setLocation (getX(), getY() + (int)vspeed);
    }
    
    public boolean colPresents() //returns true if touched present
    {
        boolean result = false;
        if (isTouching(Presents.class))
        {
            result = true;
        }
        
        return result;
        
    }
    public void removePresents() //removes present if touching
    {
        if(isTouching(Presents.class))
         removeTouching(Presents.class);
    }
      
    public boolean checkWeapon() //checks if space is pressed
    {
        boolean result = false;
        if(Greenfoot.isKeyDown("space"))
        result = true;
        
        return result;
    }
    
    
     
    
}
