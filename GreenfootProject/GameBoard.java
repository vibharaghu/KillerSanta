

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameBoard here.
 * GameBoard.class image of the Game Board
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameBoard extends Actor
{
    public GameBoard(int num)
    {
        if (num == 1) //level one image
        {
            GreenfootImage newImage = new GreenfootImage("Board.png");
            newImage.scale(550, 550);
            setImage(newImage);
        }
        if (num == 2) //level two image
        {
            GreenfootImage newImage = new GreenfootImage("Board2.png");
            newImage.scale(550, 550);
            setImage(newImage);
        }
    }
    
}  
