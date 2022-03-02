import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Factory here.
 * Factory.class is to show the secret layer that santa.class has for his evil plan.
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Factory extends World
{
   
    private int setting; //controls loops in santa attack
    private int counter; //used to spawn objects periodically
    private int settingSound; //plays sound once
    private int score; //parameter for ScoreCurrent object
    private int score2; //parameter for Text object
    private int color; //gameboard image
    private int time; //parameter for Timer object
    private ScoreCurrent scoreObject; //ingame score
    private Timer timeObject; //ingame time
    private GameBoardText text; //post game time and score
    private GameBoard board; //Gameboard image
    private Kid kid; //user player
    private Santa santa; //santa enemy
    private GreenfootSound chase; //music
    private GreenfootSound yay; //winning sound
    private Next next; //next button
    private Elf elf; //enemy
    private Barrel b; //platform
    private FlyingRo f; //enemy
    /** 
     * Constructor for objects of class Factory.
     * 
     */
    public Factory()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1, false); //boundless world

            setting = 1;
            counter = 1; 
            settingSound= 0;
            score = 0;
            score2 = 0;
            color = 1;
            santa = new Santa();
            chase = new GreenfootSound("Chase.wav");
            yay = new GreenfootSound("Yay.wav");
            next = new Next(1);
        

        GreenfootImage factory = new GreenfootImage("Factory.png");  //world image settings
        factory.scale(getWidth(),getHeight());
        setBackground(factory);
        
        //order of objects
        setPaintOrder(Patrick.class, FlyingRo.class,Kid.class, Elf.class, Barrel.class,
        Santa.class, Presents.class, GameBoardText.class, GameBoard.class, Timer.class, ScoreCurrent.class);
        
        //adds Score and Timer
        scoreObject = new ScoreCurrent();
        addObject(scoreObject, 90, 40);
        
        
        time=1500;
        timeObject = new Timer();
        timeObject.setTime(time);
        addObject(timeObject, 910, 40); //sets location
        
        board = new GameBoard(color);
        text = new GameBoardText();
        
        //adds initial enemies
        kid = new Kid(2);
        elf = new Elf();
        b = new Barrel(2);
        f = new FlyingRo(4);
        addObject(elf, 1100, 500);
        addObject(b, 1400, 500);
        addObject(f, 1300, 100);
        addObject(kid, getWidth()/2, 500);
        
    }
   
    public int presents() //returns number of presents collected
    {
        return score;
    }
    
    public void act()
    {
        
        music();
        
        text.getGame(score2,1500-time);
        if(time> 3)
         santaAttack();
        duringGame();
        endGame();
         
        if(kid.colPresents()) //collects presents
        {
            scoreObject.setScore(score++);
            text.getGame(score2++,time);
           
            kid.removePresents();
        }
        

    }
    public void duringGame() //actions preformed during level
    {
        if(time>0)
        {
          time--;
         
          spawn();   
          santa.animation();
          scoreObject.setScore(score);
          timeObject.setTime(time);
        
        }
    }
    public void endGame() //actions preformed after completing the level
    {
        if(time==0)
        {
         
         //adds GameBoard text and next buttons
         addObject(board, getWidth()/2, getHeight()/3+50);  
         addObject(text, getWidth()/2, 250+50); 
         addObject(next, 850, 300);
       
         chase.stop();
         
         if(settingSound == 0){
          yay.play();
          settingSound = 1;
        }
         //removes most entites
         removeObjects(getObjects(Santa.class)); 
         removeObjects(getObjects(Elf.class)); 
         removeObjects(getObjects(Barrel.class)); 
         removeObjects(getObjects(FlyingRo.class)); 
         removeObjects(getObjects(Presents.class)); 
         removeObjects(getObjects(ScoreCurrent.class)); 
         removeObjects(getObjects(Timer.class)); 
      
        }
    }
    public void music() //controls music and adds death screen
    {
        chase.playLoop();
        if(kid.checkEnemies())
        {
            chase.stop();
            chase.stop();
            Greenfoot.setWorld(new Death(1));
        }
    }
        
    public void spawn() //spawns entities
     {
        counter++;
       if( counter % 295 == 0 || counter % 3333 == 0)
       {
           addObject(new Presents(2), Greenfoot.getRandomNumber(100)+1000, Greenfoot.getRandomNumber(150) + 50);
        }
       if (counter % 1111 == 0 || counter% 437 == 0)
        {
          addObject(new Barrel(2), Greenfoot.getRandomNumber(100)+1000, 500);
        }
       if(counter % 739 == 0 || counter % 977== 0)
        {
            addObject(new Elf(), Greenfoot.getRandomNumber(100)+ 1000, 500);
        }
       if (counter % 1936 == 0 || counter% 387 == 0)
        {
          addObject(new FlyingRo(4), Greenfoot.getRandomNumber(100)+1000, Greenfoot.getRandomNumber(350));
        }
       
    }
    
    public void santaAttack () //santa's movement 
    {
        if (kid.getX() < 500)
         setting = 1; 
         
        if (setting == 1)
         addObject(santa,-120,370);
        
        if (kid.getX() > 500 && setting !=2)
         {
             santa.moveBack(3);
             setting = 0;
             if(santa.getX() == -120)
             {
                 removeObject(santa);
                 setting = 2;
             }
            }
    }
    
    
    public void subScore() ///subtracts score
    {
        score--;
        scoreObject.setScore(score);
    }
    
    
    
    
  } 
    

