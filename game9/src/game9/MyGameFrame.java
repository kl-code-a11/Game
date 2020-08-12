package game9;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyGameFrame extends Frame {
	Image planeImage=GameUtil.getImage("images/planefinal.jpg");
	Image bg=GameUtil.getImage("images/black.jpg");
	
	Plane plane=new Plane(planeImage,250,250);
	shell shell=new shell();
	shell[] shells=new shell[50];
	
	public void paint(Graphics g) {  //自动调用，相当于一支画笔
		g.drawImage(bg, 0, 0, null);
		plane.drawSelf(g);//画飞机
		for(int i=0;i<shells.length;i++) {
			shells[i].draw(g);
		}
		shell.draw(g);
	}
	
	
	//重复画窗口
	class PrintThread extends Thread
	{
		public void run() {
			while(true) {
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

  private Image offScreenImage = null;//双缓冲技术
  public void update(Graphics g) {
	  if(offScreenImage == null)
		  offScreenImage = this.createImage(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
	  
	  Graphics gOff=offScreenImage.getGraphics();
	  paint(gOff);//画飞机
	  g.drawImage(offScreenImage, 0, 0, null);
  }
  //定义键盘监听的内部类
 class KeyMonitor extends KeyAdapter{

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO 自动生成的方法存根
		plane.addDirection(e);

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO 自动生成的方法存根
	plane.minusDirection(e);
	}
	 
 }
  
  //初始化窗口
	public void launchFrame() {
		this.setTitle("kele");
		this.setVisible(true);
		this.setSize(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
		this.setLocation(300,300);
		
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
			System.exit(0);
			}
		});
      new  PrintThread().start();//启动重画的线程
      addKeyListener(new KeyMonitor());//给窗口增加键盘的监听
      
      
      //初始化50个炮弹
      for(int i=0;i<=shells.length;i++) {
    	  shells[i]=new shell();
      }
	}	
	public static void main(String[] args) {
		MyGameFrame f=new MyGameFrame();
		f.launchFrame();
	}

}