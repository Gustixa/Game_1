import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *  Objeto Uvas,que provee puntos e indica si avanza o no de nivel.
 * 
 * @author Josúe Samuel Argueta Hernández   211024
 * @version 31/07/2021
 */
public class Uvas extends Actor
{
    private int speed;
    
    public Uvas(int v){
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
