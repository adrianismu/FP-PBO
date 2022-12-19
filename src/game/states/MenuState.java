package game.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import javax.swing.JOptionPane;
import game.GamePanel;
import game.tools.ImageLoader;

public class MenuState extends GameState {
	
	private	BufferedImage frontScreen;
	
	private int currentChoice = 0;

	
	
	private String info = "PRESS ENTER TO PLAY";
	private Font fontInfo;
	
	public MenuState(GameStateManager gsm) {
		this.gsm = gsm;
		init();
	}

	@Override
	public void init() {
		frontScreen = ImageLoader.loadImage("/res/menu.png");
	}

	@Override
	public void update() {
	}

	@Override
	public void draw(Graphics g) {
		
		g.drawImage(frontScreen, 0, 0, null);  
		g.setColor(Color.white);
		g.setFont(fontInfo);
		fontInfo = new Font(null, Font.PLAIN, 50);
		g.drawString(info, GamePanel.WIDTH / 2 -300, GamePanel.HEIGHT/2 + 150 );

	}
	
	private void select() {
		if(currentChoice == 0) {
			gsm.setState(GameStateManager.LEVEL1STATE, score);
		}
	}
	
	public void executeExit() {
		
		int choose = JOptionPane.showConfirmDialog(null, "Do you really want to exit the game?", "Confirm Exit", JOptionPane.YES_NO_OPTION);
		if(choose == JOptionPane.YES_OPTION) {
			System.exit(0);
			System.out.println("Exit");
		}
	}

	@Override
	public void keyPressed(int k) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyReleased(int k) {
		if(k == KeyEvent.VK_ENTER){
			select();
		}
	}

}
