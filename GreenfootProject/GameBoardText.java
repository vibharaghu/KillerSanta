import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameBoardText here.
 * GameBoardText.class is the text on the game board
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameBoardText extends Actor
{
    private GreenfootImage newImage;//actor box image
    /**
     * Act - do whatever the GameBoardText wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public GameBoardText() //sets Text up
    {
        newImage = new GreenfootImage(300, 500);
        setImage(newImage);
    }    
    public void getGame (int score, int time) //changes score when called
    {
        newImage.clear();
        Font f = new Font("Courier New", true, false, 22); 
        newImage.setFont(f);
        newImage.setColor(Color.WHITE);
        newImage.drawString("Presents:" + score, 50, 200);
        newImage.drawString("Time:" + time, 50, 250);
        setImage(newImage);
    }   
}
