    import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Objeto Fresas, que proporcionará puntos.
 * 
 * @author Josué Samuel Argueta Hernández   211024
 * @version 25/05/2021
 */
public class Fresas extends Actor
{
    private int speed;
    
    public Fresas(int v){
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