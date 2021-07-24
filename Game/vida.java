import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class vida here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class vida extends Actor
{
    /**
     * Act - do whatever the vida wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int vidas = 3;
    public void Disminuir(){
        vidas--;
        if(vidas == 0){
            Greenfoot.stop();
        }
    }
}
