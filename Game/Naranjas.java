import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Objeto Naranja, que proporcionará puntos.
 * 
 * @author Josué Samuel Argueta Hernández   211024
 * @version 25/05/2021
 */
public class Naranjas extends Actor
{
    private int speed;
    
    public Naranjas(int v){
        //Obtener control de la velocidad del objeto Naranja.
        speed = v;
    }

    public void act()
    {
        //Eliminar objeto cuando tenga control con el personaje.
        setLocation(getX(), getY() + speed);
        if(getY() >= getWorld().getHeight() - 1){
            MyWorld juego = (MyWorld) getWorld();
            juego.removeObject(this);
            juego.disminuir_num_rivales();
        }
    }
}
