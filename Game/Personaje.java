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
            if(getX()< 500){
                setLocation(getX() + speed, getY());    
            }
        }
        if (Greenfoot.isKeyDown("left")||Greenfoot.isKeyDown("a")){
            if(getX()> 100){
                setLocation(getX() - speed, getY());    
            }
        }
        CheckCollision();
    }
    
    public void CheckCollision(){
        /* Controlar los objetos que tienen contacto con el
           personaje.*/
        Actor collided = getOneIntersectingObject(Bomba.class);
        Actor collided2 = getOneIntersectingObject(Peligro.class);
        if(collided != null){
            getWorld().removeObject(collided);
            Greenfoot.stop();
            GameOver t = new GameOver("Juego Terminado");
            getWorld().addObject(t,((getWorld().getWidth()/2)+30), ((getWorld().getHeight()/2)+150));
        }else if(collided2 != null){
            getWorld().removeObject(collided2);
            Greenfoot.stop();
        }
        
        Actor collided3 = getOneIntersectingObject(Fresas.class);
        Actor collided4 = getOneIntersectingObject(Naranjas.class);
        Actor collided5 = getOneIntersectingObject(Uvas.class);
        Actor collided6 = getOneIntersectingObject(Manzanas.class);
        //por cada objeto que se recolecte, aumente el pt.
        if(collided3 != null) {
            MyWorld juego = (MyWorld) getWorld();
            getWorld().removeObject(collided3);
            juego.aumentar_puntuacion(10);
        }else if(collided4 != null){
            MyWorld juego = (MyWorld) getWorld();
            juego.aumentar_puntuacion(10);
            getWorld().removeObject(collided4);
        }else if(collided5 != null){
            MyWorld juego = (MyWorld) getWorld();
            juego.aumentar_puntuacion(10);
            getWorld().removeObject(collided5);
            juego.aumentar_num_adelantamientos();
        }else if(collided6 != null){
            MyWorld juego = (MyWorld) getWorld();
            juego.aumentar_puntuacion(5);
            getWorld().removeObject(collided6);
        }
        
        Actor collided7 = getOneIntersectingObject(Hamburguesa.class);
        Actor collided8 = getOneIntersectingObject(Papas.class);
        //por cada objeto que se recolecte, disminuye el pt.
        if(collided7 != null){
            MyWorld juego = (MyWorld) getWorld();
            juego.aumentar_puntuacion(-10);
            getWorld().removeObject(collided7);
        }else if(collided8 != null){
            MyWorld juego = (MyWorld) getWorld();
            juego.aumentar_puntuacion(-10);
            getWorld().removeObject(collided8);
        }
    }
    public void aumento_velocidad(){
        speed++;
    }
}
