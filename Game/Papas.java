import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Objeto papas, que quita puntos.
 * 
 * @author Josúe Samuel Argueta Hernández   211024
 * @version 31/07/2021
 */
public class Papas extends Actor
{
    private int speed;
    
    public Papas(int v){
        //tener control de la velocidad.
        speed = v;
    }

    public void act()
    {
        //Eliminar objeto cuanto tenga contacto con el personaje.
        setLocation(getX(), getY() + speed);
        if(getY() >= getWorld().getHeight() - 1){
            MyWorld juego = (MyWorld) getWorld();
            juego.removeObject(this);
            juego.disminuir_num_rivales();
        }
    }
}