import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Manzanas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Manzanas extends Actor
{
    private int speed;
    
    public Manzanas(int v){
        //Tener control de la velocidad
        speed = v;
    }
    public void act()
    {
        //Elminar objeto cuando tenga contacto con el personaje.
        setLocation(getX(), getY() + speed);
        if(getY() >= getWorld().getHeight() - 1){
            MyWorld juego = (MyWorld) getWorld();
            juego.removeObject(this);
            juego.disminuir_num_rivales();
        }
    }
}