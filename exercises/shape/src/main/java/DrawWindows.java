import java.awt.Graphics;
	import javax.swing.JPanel;
	import javax.swing.JFrame;

	public class DrawWindows extends JPanel
	{
	    private Drawable drawable;
	    /**
	     * @pre  drawable != null
	     * @post create and show a windows containing the drawable
	     */
	    public DrawWindows(Drawable drawable) {
			this.drawable = drawable;
			JFrame app = new JFrame();
			app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			app.setSize(550,550);
			app.add(this);
			app.setVisible(true);
	    }
	
	    /**
	     * @pre  g has been initialized
	     * @post draw in g
	     */
	    public void paintComponent(Graphics g){
	        super.paintComponent(g);
	        drawable.draw(g);
	    }
	}