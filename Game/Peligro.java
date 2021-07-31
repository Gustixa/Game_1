import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Objeto PELIGRO, que tiene la misma acción como
 * el objeto peligro.
 * 
 * @author Josué Samuel Argueta Hernández   211024
 * @version 25/07/2021
 */
public class Peligro extends Actor
{
    private int speed;
    
    public Peligro(int v){
        //Obtener control de la velocidad del objeto.
        speed = v;
    }
    /**
     * Act - do whatever the Bomba wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        //Eliminar objeto cuando tenga contacto con el Personaje.
        setLocation(getX(), getY() + speed);
        if(getY() >= getWorld().getHeight() - 1){
            MyWorld juego = (MyWorld) getWorld();
            juego.removeObject(this);
            //juego.disminuir_num_rivales();
            
            //Modificar
            //GameOver t = new GameOver();
            //
        }
    }
}
