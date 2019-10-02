import java.awt.*;


    public class Cubism_PP implements Drawable {

        /**
         * @pre  g has been initialized
         * @post Drow this shape in g
         */
        public void draw(Graphics g) {

            Triangle_Equilateral equi= new Triangle_Equilateral(60,270, 270);
            g.setColor(Color.RED);
            equi.draw(g);

            Rectangle rectfenetr= new Rectangle(140,300,190,300,70);
            g.setColor(Color.green);
            rectfenetr.draw(g);

            Rectangle rectporte= new Rectangle(200,350,250,350,90);
            g.setColor(Color.green);
            rectporte.draw(g);

            Rectangle rectarbre= new Rectangle(150,205,370,205,135);
            g.setColor(Color.gray);
            rectarbre.draw(g);

            Rectangle rectangle= new Rectangle(65,65,130,215,70);
            g.setColor(Color.red);
            rectangle.draw(g);

            Oval ovale= new Oval(300, 170, 225, 135);
            g.setColor(Color.pink);
            ovale.draw(g);

            Oval soleil= new Oval(82, 82, 70, 70);
            g.setColor(Color.YELLOW);
            soleil.draw(g);
        }
    }