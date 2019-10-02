import java.awt.*;

public class Rectangle implements Drawable {

    protected int x0,x1,x2,x3;
    protected int y0,y1,y2,y3;
    protected int height;

    /***
     * @pre  x0,x1,y0,y1 >= 0
     * @post create an instance of this class
     *  (0) (x0,y0)........(x1,y1) (1)
     *             .      .
     *             .      .
     *             .      .
     *  (2) (x2,y2)........(x3,y3) (3)
     */
    public Rectangle(int x0,int y0, int x1, int y1, int height){
        this.height= height;

        this.x0=x0;
        this.y0=y0;

        this.x1=x1;
        this.y1=y1;

        this.x2=x0;
        this.y2=y0+height;

        this.x3=x1;
        this.y3=y1+height;
    }

    /**
     * @pre  g has been initialized
     * @post draw in g
     */
    public void draw(Graphics g) {
         g.drawLine(x0,y0,x1,y1);
         g.drawLine(x0,y0,x2,y2);
         g.drawLine(x2,y2,x3,y3);
         g.drawLine(x3,y3,x1,y1);
    }
}