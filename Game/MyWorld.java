import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
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
        
        setPaintOrder(GameOver.class,Personaje.class);
        //objLife = new vida();
    }
    
    public void act(){
        aumetar_dificultad();
        aniadir_objetos();
    }
    
    public int getRandomNumber(int start, int end){
        //Obtención de valores aleatorio para mostrar los items.
        int normal = Greenfoot.getRandomNumber(end-start+1);
        return normal + 1;
    }
    
    public void aumentar_puntuacion(int valor){
        //Aumento del punteo y nivel, según sea el caso del item obtenido.
        score.add(valor);
    }
    
    public void aumentar_num_adelantamientos(){
        num_adelantamientos++;
    }
    
    public void disminuir_num_rivales(){
        num_rivales++;
    }
    
    public void aumetar_dificultad(){
        if(num_adelantamientos == num_adelantamientos_nivel){
            num_adelantamientos = 0;
            num_adelantamientos_nivel += 2;
            velocidad_objetos++;
            level.add(1);
            linux.aumento_velocidad();
        }
    }
    
    public void aniadir_objetos(){
        //Agregar objetos al mapa.
        if(num_rivales == 0){
            
            int carril = getRandomNumber(0,5);
            
            if (carril == 0){
                addObject(new Bomba(velocidad_objetos), 150, 80);
            }else if (carril == 1){
                addObject(new Hamburguesa(velocidad_objetos), 210, 80);
            }else if(carril == 2){
                addObject(new Naranjas(velocidad_objetos), 290, 80);
            }else if(carril == 3){    
                addObject(new Fresas(velocidad_objetos), 350, 80);
            }else{
                addObject(new Peligro(velocidad_objetos), 410, 80);
            }
                   
            carril++;
            carril %= 5;
        
            if (carril == 0){
                addObject(new Fresas(velocidad_objetos), 150, 80);
            }else if (carril == 1){
                addObject(new Bomba(velocidad_objetos), 210, 80);
            }else if(carril == 2){
                addObject(new Hamburguesa(velocidad_objetos), 290, 80);
            }else if(carril == 3){
                addObject(new Peligro(velocidad_objetos), 350, 80);
            }else{
                addObject(new Naranjas(velocidad_objetos), 410, 80);
            num_rivales = 2;
            }
        }        
    }
}