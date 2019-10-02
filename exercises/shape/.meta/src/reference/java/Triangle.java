import java.awt.*;


public class Triangle implements Drawable {

    protected int x0,y0;
    protected int x1,y1;
    protected int x2,y2;


    /**
     * @pre  x0,y0, x1,y1, x2,y2 >= 0
     * @post Create an instance of Triangle
     */
    public Triangle(int x0,int y0, int x1,int y1, int x2,int y2 ){
        this.x0= x0; this.x1=x1;
        this.y0= y0; this.y1=y1;
        this.x2=x2;  this.y2=y2;
    }

    /**
     * @pre  g has been initialized
     * @post draw in g
     */
    public void draw(Graphics g) {
        g.drawLine(x0,y0,x1,y1);
        g.drawLine(x1,y1,x2,y2);
        g.drawLine(x2,y2,x0,y0);
    }
}