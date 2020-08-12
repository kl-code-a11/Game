package game7;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

public class Plane extends GameObject{
	
	
	 public void drawSelf(Graphics g) {
		  g.drawImage(img,(int)x,(int)y,null);
		  x++;
	  }
	 
	 public Plane(Image img,double x,double y) {
		 this.img=img;
		 this.x=x;
		 this.y=y;
	 }

	public void addDirection(KeyEvent e) {
		// TODO 自动生成的方法存根
		
	}

}
