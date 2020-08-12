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
	
	public void paint(Graphics g) {  //�Զ����ã��൱��һ֧����
		g.drawImage(bg, 0, 0, null);
		plane.drawSelf(g);//���ɻ�
		for(int i=0;i<shells.length;i++) {
			shells[i].draw(g);
		}
		shell.draw(g);
	}
	
	
	//�ظ�������
	class PrintThread extends Thread
	{
		public void run() {
			while(true) {
			repaint();
			try {
				Thread.sleep(40);
			} catch (InterruptedException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		                  }
		                      }
	}

  private Image offScreenImage = null;//˫���弼��
  public void update(Graphics g) {
	  if(offScreenImage == null)
		  offScreenImage = this.createImage(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
	  
	  Graphics gOff=offScreenImage.getGraphics();
	  paint(gOff);//���ɻ�
	  g.drawImage(offScreenImage, 0, 0, null);
  }
  //������̼������ڲ���
 class KeyMonitor extends KeyAdapter{

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO �Զ����ɵķ������
		plane.addDirection(e);

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO �Զ����ɵķ������
	plane.minusDirection(e);
	}
	 
 }
  
  //��ʼ������
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
      new  PrintThread().start();//�����ػ����߳�
      addKeyListener(new KeyMonitor());//���������Ӽ��̵ļ���
      
      
      //��ʼ��50���ڵ�
      for(int i=0;i<=shells.length;i++) {
    	  shells[i]=new shell();
      }
	}	
	public static void main(String[] args) {
		MyGameFrame f=new MyGameFrame();
		f.launchFrame();
	}

}