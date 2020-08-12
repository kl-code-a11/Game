package game;
import java.awt.Graphics;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class MyGameFrame extends JFrame {
	/*public void paint(Graphics g) {
		g.drawLine(100, 100,300,300);
		g.drawRect(100, 100, 300, 300);
	}*/

	
	public void launchFrame() {
		this.setTitle("kele");
		this.setVisible(true);
		this.setSize(500,500);
		this.setLocation(300,300);
		
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
			System.exit(0);
			}
		});
	}
	public static void main(String[] args) {
		MyGameFrame f=new MyGameFrame();
		f.launchFrame();
	}

}
