import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Mostrar Juego Terminado, según haya sido la acción
 * del jugador.
 * 
 * @author Josué Samuel Argueta Hernández   211024
 * @version 25/07/2021
 */
public class GameOver extends Actor
{
    /**
     * Act - do whatever the GameOver wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage imagen;
    private String mensaje;
    private int stringLength;
    private String text;
    
    public GameOver(){
        this("");
    }
    public GameOver(String prefix){
        //Mostrar Game Over en la panalla.
        text = prefix;
        stringLength = (text.length() + 2) * 16;
        
        setImage(new GreenfootImage(stringLength, 24));
        GreenfootImage image = getImage();
        Font font = image.getFont();
        imagen = new GreenfootImage(400,300);
        imagen.setColor(Color.BLACK);
        imagen.setFont(font.deriveFont(44.0F));
        imagen.drawString(text,0,30);
        setImage(imagen);
        Greenfoot.stop();
    }
    public void act()
    {
        // Add your action code here.
    }
}
