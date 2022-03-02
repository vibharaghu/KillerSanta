import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Instruction: takes to controls 
 * Instuction.class is used to move between world classes when clicked on by the player with the mouse.
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Instruction extends Actor
{
    private GreenfootImage inst;//actor image
    public Instruction()
    {
        inst = new GreenfootImage("Instructions.png");
    }
    public void act() 
    {
        inst.scale(350, 160); //sets image
        setImage(inst);
        switchToInstruct(); //changes to Control world if pressed
    }    
    public boolean switchToInstruct()//changes to Control world
    {
        if(Greenfoot.mousePressed(this))
        {
            Greenfoot.setWorld(new Controls());
            
        }
        boolean result = false;
        if(Greenfoot.mousePressed(this))
        {
            result = true;
        }
        
        return result;
    }
}
