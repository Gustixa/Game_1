import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Funcionalidad general del juego.
 * 
 * Autor: Josué Samuel Argueta Hernández    211024
 * @version 5 (23/07/2021)
 */
public class MyWorld extends World
{
    private Counter score;
    private Counter level;
    
    private int velocidad_objetos;
    private int num_adelantamientos;
    private int num_adelantamientos_nivel;
    private Personaje linux;
    private int num_rivales;
    
    private int contar= 0;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    //public vida objLife;
    public MyWorld()
    {    
        //Vista inicial del juego
        super(600, 700, 1);
        
        num_adelantamientos = 0;
        num_adelantamientos_nivel = 4;
        velocidad_objetos = 2;
        
        score = new Counter("Score: ");
        level = new Counter("Level: ");
        level.add(1);
        linux = new Personaje(velocidad_objetos);
        
        addObject(linux, 300, 650);
        addObject(level, 100, 60);
        addObject(score, 100, 30);
        
        //setPaintOrder(GameOver.class,Personaje.class);
    }
    
    public void act(){
        aumetar_dificultad();
        contar++;
        if(contar>59){
            enemigos();
            contar = 0;
        }
        alimentos();
    }
    public void enemigos(){
        //Agregar los objetos que terminan automaticamente el juego.
        addObject(new Bomba(velocidad_objetos), getRandomNumber(100,501), 70);    
        addObject(new Hamburguesa(velocidad_objetos), getRandomNumber(100,501), 70);
        addObject(new Papas(velocidad_objetos), getRandomNumber(100,501), 70);
        /* Agregar si se desea, pero dificulta el juego de tal manera que es
           casi imposible poder avanzar.*/
        //addObject(new Peligro(velocidad_objetos), getRandomNumber(100,501), 70);
    }

    public void alimentos(){
        //Agregar los objetos que proveen puntos.
        if(Greenfoot.getRandomNumber(60) < 1){
            addObject(new Fresas(velocidad_objetos), getRandomNumber(100,501), 70);
            addObject(new Naranjas(velocidad_objetos), getRandomNumber(100,501), 70);
            addObject(new Uvas(velocidad_objetos), getRandomNumber(100,501),70);
            addObject(new Manzanas(velocidad_objetos), getRandomNumber(100,501),70);
            //Objeto que no da puntos, más bien, quta puntos.
            
        }
    }
    
    public int getRandomNumber(int start, int end){
        //Obtención de valores aleatorio para mostrar los items.
        int normal = Greenfoot.getRandomNumber(end-start+1);
        return normal + start;
    }
    
    public void aumentar_puntuacion(int valor){
        //Aumento del punteo y nivel, según sea el caso del item obtenido.
        score.add(valor);
    }
    
    public void aumentar_num_adelantamientos(){
        //Aumentar el numero de objetos recolectados
        num_adelantamientos++;
    }
    
    public void disminuir_num_rivales(){
        num_rivales++;
    }
    
    public void aumetar_dificultad(){
        //Aumentar la velocidad de "caída" de los objetos.        
        if(num_adelantamientos == num_adelantamientos_nivel ){
            num_adelantamientos = 0;
            num_adelantamientos_nivel += 2;
            velocidad_objetos++;
            level.add(1);
            linux.aumento_velocidad();
        }
    }
}