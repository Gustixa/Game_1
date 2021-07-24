import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fresas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fresas extends Actor
{
    private int speed;
    
    public Fresas(int v){
        speed = v;
    }
    /**
     * Act - do whatever the Bomba wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        setLocation(getX(), getY() + speed);
        if(getY() >= getWorld().getHeight() - 1){
            MyWorld juego = (MyWorld) getWorld();
            juego.removeObject(this);
            //por cada objeto que desaparezca, aumente el pt.
            juego.disminuir_num_rivales();
            juego.aumentar_num_adelantamientos();
        }
    }
}