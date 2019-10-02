import java.awt.*;

public class Line implements Drawable {

   private int x0,y0;
   private int x1,y1;

   /**
     * @pre x0,y0,x1,y1 >=0 et <512
     * @post Create an instance of Line
     */
    public Line(int x0, int y0, int x1, int y1){
        this.x0=x0;
        this.y0=y0;
        this.x1=x1;
        this.y1=y1;
    }

    /**
     * @pre  g est initialise
     * @post
     */
    public void draw(Graphics g){
        g.drawLine(x0,y0,x1,y1);
    }
}