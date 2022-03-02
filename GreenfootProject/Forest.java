import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Forest here.
 * Forest.class is to show the escape route for the kid.class to get to his home base with patrick.class.
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Forest extends World
{
    private ScoreCurrent scoreObject; //current score during game
    private int score; //parameters for scoreObject
    private Timer timeObject; // the timer
    private int time; //the max time
    private GameBoardText text; //text on gameboard
    private int color; // controls game board image
    private Kid kid; // kid actor
    private Santa santa; // the big bad boy (santa claus)
    private GreenfootImage forest; // world image
    private GreenfootSound chase; // game sound during chase
    private GreenfootSound yay ; // game sound after beating level
    private int settingSound; // controls times "yay" is played
    private int setting; //controls santa movement
    private int counter; //controls how often enemies spawn
    private Patrick patrick; //the star guardian/captain of the STWF (save the world force)
    private GameBoard board; //gameboard image
    private Next next; //next button
    private int score2; //score parameter for text
    private int candy; //controls number of times blaster is spawned
    private int count;//controls the space between throwing presents
    private int frames; //controls time between actions in the end animation sequence
    private int set; //separates between ending animation and end score board
    public Forest()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels. Boundless world
        super(1000, 600, 1, false); 
        forest = new GreenfootImage("SnowForest.png"); //Creates world image and scales
        forest.scale(getWidth(),getHeight());
        setBackground(forest);
        
        setPaintOrder(ThrowPresent.class,FlyingRo.class,Kid.class, Patrick.class, 
        Snow.class, Elf.class, Barrel.class, Blaster.class,
        Santa.class, GameBoardText.class, GameBoard.class, Timer.class, ScoreCurrent.class); //set placement order of objects
        
        chase = new GreenfootSound("Chase.wav");
        yay = new GreenfootSound("Yay.wav");
        set = 0;
        frames = 0;
        count = 0;
        candy = 0;
        score2= 0;
        next = new Next(2);
        color = 2;
        patrick = new Patrick();
        board = new GameBoard(color);
        counter = 1;
        setting = 1;
        settingSound= 0;
        score = 0;
        time = 0;
       
        kid = new Kid(3);
        addObject(kid, getWidth()/2, 500);
        santa = new Santa();
        
        
        scoreObject = new ScoreCurrent(); //ingame score
        scoreObject.setScore(score);
        addObject(scoreObject, 90, 40);
        
        time= 3500; //timer in game
        timeObject = new Timer();
        timeObject.setTime(time);
        addObject(timeObject, 910, 40); //sets location
        
        text = new GameBoardText();//end game text

        Snow snow = new Snow(); //inital enemies 
        Barrel b = new Barrel(3);
        FlyingRo f = new FlyingRo(6);
        addObject(snow, 1100, 500);
        addObject(b, 1400, 500);
        addObject(f, 1300, 100);

    }
    public void act()
    {
        count++;
        chase.playLoop();
        text.getGame(score2, 3500 - time);
        
        if(kid.checkEnemies()) //stops song if death
        {
            chase.stop();
            chase.stop();
            Greenfoot.setWorld(new Death2());
        }
        
        duringGame();
        if(time> 3) //stops santa 3 before end
         santaAttack();
        if(time == 1) //adds santa back in 1 before end
         addObject(santa,-120,370);
        
        endGame();
        
        if(kid.colPresents()){
            scoreObject.setScore(score++);
            text.getGame(score2++,time);
           
            kid.removePresents();
        }
        
    } 
    public void duringGame() //actions preformed during game
    {
         if(time>0)
        {
          time--;
          weapon();
          spawn();
          santa.animation();
          scoreObject.setScore(score);
         timeObject.setTime(time);
        }
        
    }
    public void endGame() //actions preformed when end of level is reached
    {
        if(time==0)
        {
         
         addObject(patrick, 810, 470);
         if (candy == 0){
          addObject(new Blaster(), patrick.getX(), patrick.getY());
          candy = 1;
         }
         end();
         if(set == 1) //adds board and next and plays yay once
         {
             addObject(board, getWidth()/2, getHeight()/3+50);
             addObject(text, getWidth()/2, 250+50);
             addObject(next, 850, 300);
             chase.stop();
              if(settingSound == 0){
               yay.play();
              settingSound = 1;
            }
         }
         
        
         
          removeObjects(getObjects(Snow.class)); 
          removeObjects(getObjects(Barrel.class)); 
          removeObjects(getObjects(FlyingRo.class)); 
          removeObjects(getObjects(Presents.class)); 
          removeObjects(getObjects(ScoreCurrent.class)); 
          removeObjects(getObjects(Timer.class)); 
   
        }
    }
     public void spawn() //how often things spawn
    {
        counter++;
        if (counter % 1111 == 0 || counter% 537 == 0)
        {
          addObject(new Barrel(3), Greenfoot.getRandomNumber(100)+1000, 500);
        }
        if(counter % 1309 == 0 || counter % 279 == 0)
        {
            addObject(new Snow(), Greenfoot.getRandomNumber(100)+ 1000, 500);
        }
        if (counter % 1936 == 0 || counter% 367 == 0)
        {
          addObject(new FlyingRo(6), Greenfoot.getRandomNumber(100)+1000, Greenfoot.getRandomNumber(350));
        }
        if( counter % 282 == 0 || counter % 3333 == 0)
        {
           addObject(new Presents(6), Greenfoot.getRandomNumber(100)+1000, Greenfoot.getRandomNumber(150) + 75);
        }
    }
    
    public void santaAttack () //Santa movement when player is in range
    {
        if (kid.getX() < 500)
         setting = 1; 
         
        if (setting == 1) //adds santa if kid is in range
         addObject(santa,-120,370);
        
        if (kid.getX() > 500 && setting !=2) //moves back if kid is out of range
         {
             santa.moveBack(3);
             setting = 0;
             if(santa.getX() == -120) //removes santa if out of screen
             {
                 removeObject(santa);
                 setting = 2;
             }
            }
    }
 
     public void weapon() //adds throwing presents when space bar is hit with a 10 act cooldown
      {
        if(kid.checkWeapon() && score > 0 && (count % 10 == 0))
        {
           addObject(new ThrowPresent(), kid.getX(), kid.getY());
           subScore();
           
        }
        
      }
      public void subScore() //subtracts score when called
      {
        score--;
        scoreObject.setScore(score);
      }
      
      public void end() //ending animation when you complete the level
      {
          frames++;
         
          if(frames < 150) 
          {
           santa.animation();
        }
           
          else if (set == 0) //adds blaster and calls death animation
          {
              removeObjects(getObjects(Blaster.class));
              santa.setLocation(santa.getX()-2, santa.getY());
              santa.deathAnim();
              if(frames > 210) //removes santa
              {
               removeObjects(getObjects(Santa.class));
               set = 1;
            }
            }
        }
        
        
 }
    
     

