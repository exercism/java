import java.awt.*;

public class Oval implements Drawable {

    private int originX, originY, diameter1, diameter2;

    /**
     * 	@pre originX >=0 ,originY >=0 ,diametre1 >=0,  diameter2 >=0
     * 	@post originX, diameter2 are the origin of the Oval
     * 	      when (diameter1 == diameter2) we obtain  a circle
     */
    public Oval(int originX, int originY, int diameter1, int diameter2){
        this.originX = originX;
        this.originY = originY;
        this.diameter1 = diameter1;
        this.diameter2 = diameter2;
    }

    /**
     * @pre  g has been initialized
     * @post draw in g
     */
    public void draw(Graphics g) {
        g.drawOval(originX, originY, diameter1, diameter2);
    }
}