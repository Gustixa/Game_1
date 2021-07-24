import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Personaje here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Personaje extends Actor
{
    private int speed;
    
    public Personaje(int v){
        speed = v;
    }
    
    /**
     * Act - do whatever the Personaje wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        //Desplazamientos del personaje
        if (Greenfoot.isKeyDown("right")||Greenfoot.isKeyDown("d")){
            if(getX()< 700){
                setLocation(getX() + speed, getY());    
            }
            
        }
        if (Greenfoot.isKeyDown("left")||Greenfoot.isKeyDown("a")){
            if(getX()> 200){
                setLocation(getX() - speed, getY());    
            }
            
        }
        CheckCollision();
    }
    
    public void CheckCollision(){
        Actor collided = getOneIntersectingObject(Bomba.class);
        if(collided != null){
            //MyWorld papel = (MyWorld) getWorld();
            getWorld().removeObject(collided);
            getWorld().removeObject(this);
            Greenfoot.stop();
            //Greenfoot.stop();
        }
    }
    public void aumento_velocidad(){
        speed++;
    }
}
