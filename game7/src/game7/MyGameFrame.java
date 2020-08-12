package game7;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyGameFrame extends Frame {
	Image planeImage=GameUtil.getImage("images/planefinal1.jpg");
	Image bg=GameUtil.getImage("images/black.jpg");
	
	Plane plane=new Plane(planeImage,250,250);
	
	
	public void paint(Graphics g) {  //�Զ����ã��൱��һ֧����
		g.drawImage(bg, 0, 0, null);
		plane.drawSelf(g);//���ɻ�
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

  private Image offScreenImage = null;
  public void update(Graphics g) {
	  if(offScreenImage == null)
		  offScreenImage = this.createImage(600,600);
	  
	  Graphics gOff=offScreenImage.getGraphics();
	  paint(gOff);//���ɻ�
	  g.drawImage(offScreenImage, 0, 0, null);
  }
  //������̼������ڲ���
 class KeyMonitor extends KeyAdapter{

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO �Զ����ɵķ������
		super.keyPressed(e);
		System.out.println("���£�"+e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO �Զ����ɵķ������
		super.keyReleased(e);
		System.out.println("̧��"+e.getKeyCode());
	}
	 
 }
  
  //��ʼ������
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
      new  PrintThread().start();//�����ػ����߳�
      addKeyListener(new KeyMonitor());//���������Ӽ��̵ļ���
	}	
	public static void main(String[] args) {
		MyGameFrame f=new MyGameFrame();
		f.launchFrame();
	}

}