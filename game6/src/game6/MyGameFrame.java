package game6;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class MyGameFrame extends Frame {
	Image planeImage=GameUtil.getImage("images/planefinal1.jpg");
	Image bg=GameUtil.getImage("images/black.jpg");
	
	Plane plane=new Plane(planeImage,250,250);
	
	
	public void paint(Graphics g) {  //自动调用，相当于一支画笔
		g.drawImage(bg, 0, 0, null);
		plane.drawSelf(g);//画飞机
	}
	
	
	//重复画窗口
	class PrintThread extends Thread
	{
		public void run() {
			while(true) {
				System.out.println("窗口重画一次");
			repaint();
			try {
				Thread.sleep(40);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		                  }
		                      }
	}

  private Image offScreenImage = null;
  public void update(Graphics g) {
	  if(offScreenImage == null)
		  offScreenImage = this.createImage(600,600);
	  
	  Graphics gOff=offScreenImage.getGraphics();
	  paint(gOff);
	  g.drawImage(offScreenImage, 0, 0, null);
  }
  
 
  
  //初始化窗口
	public void launchFrame() {
		this.setTitle("kele");
		this.setVisible(true);
		this.setSize(600,600);
		this.setLocation(300,300);
		
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
			System.exit(0);
			}
		});
      new  PrintThread().start();
	}	
	public static void main(String[] args) {
		MyGameFrame f=new MyGameFrame();
		f.launchFrame();
	}

}