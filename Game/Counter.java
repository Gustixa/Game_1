import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Llevar el control de los puntos y el nivel en donde se
 * encuentra el jugador.
 * 
 * @author Josué Samuel Argueta Hernández   211024
 * @version 25/07/2021
 */
public class Counter extends Actor
{
    private int value = 0;
    private int target = 0;
    private String text;
    private int stringLength;

    public Counter(){
        this("");
    }
    public Counter(String prefix)
    {
        //Presentar el contador en pantalla.
        text = prefix;
        stringLength = (text.length() + 2) * 16;

        setImage(new GreenfootImage(stringLength, 24));
        GreenfootImage image = getImage();
        Font font = image.getFont();
        image.setFont(font.deriveFont(24.0F));
        image.setColor(Color.BLACK);
        
        updateImage();
    }
    public void act() {
        //Actualizar el contador
        if(value < target) {
            value++;
            updateImage();
        }
        else if(value > target) {
            value--;
            updateImage();
        }
    }
    public void add(int score){
        //Sumar puntos
        target += score;
    }
    public void subtract(int score){
        //Restar puntos
        target -= score;
    }
    public int getValue(){
        //Obtener el estado de los puntos y niveles.
        return value;
    }
    private void updateImage(){
        //Método para tener el control de los puntos y niveles.
        GreenfootImage image = getImage();
        image.clear();
        image.drawString(text + value, 1, 18);
    }
}
