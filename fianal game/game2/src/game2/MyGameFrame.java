package game2;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class MyGameFrame extends JFrame {
	public void paint(Graphics g) {
		super.paint(g);
		Color c=g.getColor();
		Font f=g.getFont();
		g.setColor(Color.BLUE);
	
		g.drawLine(100, 100,300,300);
		g.drawRect(100, 100, 300, 300);
		g.drawOval(100,100,300,300);
		g.fillRect(100, 100, 40, 40);
		g.setColor(Color.red);
		g.setFont(new Font("ËÎÌå",Font.BOLD,50));
		g.drawString("ÎÒË¯¾õÅ¶£¡", 200, 200);
            g.setColor(c);
	}

	
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
