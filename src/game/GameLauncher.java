package game;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.net.URL;
import javax.imageio.ImageIO;


public class GameLauncher extends JFrame {
	private  BufferedImage img1;
	public GameLauncher()
	{
		try{
			//logo app
			URL icon=this.getClass().getResource("/res/menu.png");
			img1=ImageIO.read(icon);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}

		JFrame f=new JFrame("Vehicle RUSH");
		f.setSize(720, 690);
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		f.add(new GamePanel());
        f.setIconImage(img1);
        f.setVisible(true);
        
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.addWindowListener(new WindowAdapter()
				{
			@Override
			public void windowClosing(WindowEvent e)
			{
				int choose = JOptionPane.showConfirmDialog(null, "Do you really want to exit the game?", "Confirm Exit", JOptionPane.YES_NO_OPTION);
				if(choose == JOptionPane.YES_OPTION)
				{
					e.getWindow().dispose();
					System.out.println("Exit");
				}
				else
					f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			}
				});


	}
	
	public static void main(String args[])
	{
		new GameLauncher();
	}
}
