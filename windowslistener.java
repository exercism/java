import java.awt.*;
import java.awt.event.*;
class MyFrame17 extends Frame implements WindowListener
{
	MyFrame17()
	{
		addWindowListener(this);
		setSize(300,300);
		setVisible(true);
	}
	public static void main(String args[])
	{	new MyFrame17();
	}
	public void windowClosing(WindowEvent we)
	{
		Frame f=(Frame)we.getWindow();
		f.dispose();
	}
	public void windowOpened(WindowEvent we){}
	public void windowClosed(WindowEvent we){}
	public void windowIconified(WindowEvent we){}
	public void windowDeiconified(WindowEvent we){}
	public void windowActivated(WindowEvent we)
	{
		setTitle("I\'m active");
	}
	public void windowDeactivated(WindowEvent we)
	{
		setTitle("I\'m not active");
	}
}
