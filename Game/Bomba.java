import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Objeto BOMBA, que tendra protagonismo en el juego
 * para terminar el juego inmediatamente tenga contacto
 * el personaje con este objeto.
 *
 * @author Josué Samuel Argueta Hernández   211024
 * @version 25/07/2021
 */
public class Bomba extends Actor
{
    private int speed;
    
    public Bomba(int v){
        //tener control de la velocidad de bajada.
        speed = v;
    }
    /**
     * Act - do whatever the Bomba wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Controlar el putno de bajada y contacto con el personaje.
        setLocation(getX(), getY() + speed);
        if(getY() >= getWorld().getHeight() - 1){
            MyWorld juego = (MyWorld) getWorld();
            juego.removeObject(this);
            juego.disminuir_num_rivales();
            juego.aumentar_num_adelantamientos();
            
            //Modificar
            //GameOver t = new GameOver();
            //getWorld().addObject(t,((getWorld().getWidth()/2)+30),((getWorld().getHeight()/2)+150));
        }
    }
}
