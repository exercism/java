import java.awt.*;

public class Mandala implements Drawable {

/**
 * @pre  g has been initialized
 * @post Drow this shape in g
 */
public void draw(Graphics g) {
        for(int j=0; j<25; j++){
            for(int i=0; i<95; i=i+40){
                Triangle_Equilateral equi= new Triangle_Equilateral(100-i-j, 125+i+j, 150+i+j);
                g.setColor(Color.MAGENTA);
                equi.draw(g);
                }

            for(int i=0; i<100; i=i+40){
                Triangle_Equilateral equi= new Triangle_Equilateral(350-i-j, i+j, 140+i+j);
                g.setColor(Color.PINK);
                equi.draw(g);
                }

            for(int i=0; i<100; i=i+40){
                Triangle_Equilateral equi= new Triangle_Equilateral(350-i-j, 230+i+j, 140+i+j);
                g.setColor(Color.PINK);
                equi.draw(g);
                }

            for(int i=0; i<100; i=i+40){
                Triangle_Equilateral equi= new Triangle_Equilateral(350-i-j, 125+i+j, 400+i+j);
                g.setColor(Color.MAGENTA);
                equi.draw(g);
            }


            for(int i=0; i<100; i=i+40){
                Triangle_Equilateral equi= new Triangle_Equilateral(100-i-j, 345+i+j, 150+i+j);
                g.setColor(Color.MAGENTA);
                equi.draw(g);
            }

            for(int i=0; i<100; i=i+40){
                Triangle_Equilateral equi= new Triangle_Equilateral(350-i-j, 345+i+j, 400+i+j);
                g.setColor(Color.MAGENTA);
                equi.draw(g);
            }
        }
    }
}