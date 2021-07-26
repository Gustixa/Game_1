import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Objeto Hamburguesa, que quitará puntos.
 * 
 * @author Josué Samuel Argueta Hernández   211024
 * @version 25/05/2021
 */
public class Hamburguesa extends Actor
{
    private int speed;
    
    public Hamburguesa(int v){
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
            juego.aumentar_num_adelantamientos();
        }
    }
}