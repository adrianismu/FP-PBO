package game.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import game.Background;
import game.entities.PlayerCar;
import game.entities.Score;
import game.entities.Obstacle1;
import game.entities.Obstacle2;
import game.entities.Obstacle3;
import game.entities.Obstacle4;

import game.tools.GameSound;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


import java.io.IOException;

public class Level1State extends GameState {
	
	int currentSpeed;
	Background background;
	PlayerCar player;
	Obstacle1 obstacleone;
	Obstacle2 obstacletwo;
	Obstacle3 obstaclethree;
	Obstacle4 obstaclefour;
	//Obstacle1 obstacleone;
	GameSound carSound1;
	GameSound carSound2;
	GameSound carSound3;
	GameSound carSound4;
	GameSound crash;

	
	public Level1State(GameStateManager gsm) {
		
		this.gsm = gsm;
		player = new PlayerCar();
		obstacleone = new Obstacle1();
		obstacletwo = new Obstacle2();
		obstaclethree = new Obstacle3();
		obstaclefour = new Obstacle4();
		
		background = new Background();
		score = new Score();	


		try {
			carSound1 = new GameSound("/res/carSound1.wav");
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			carSound2 = new GameSound("/res/carSound2.wav");
			carSound3 = new GameSound("/res/carSound3.wav");
			carSound4 = new GameSound("/res/carSound4.wav");
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}




		// carSound4.play();
		// carSound4.getCLip().loop(Clip.LOOP_CONTINUOUSLY);

		try {
			crash = new GameSound("/res/crash.wav");
		} catch (javax.sound.sampled.UnsupportedAudioFileException | IOException
				| javax.sound.sampled.LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	public void action() {
		obstacleone.move();
		obstacletwo.move();
		obstaclethree.move();
		obstaclefour.move();
		update();
		checkCollision();
		

		
	}
	
	@Override
	public void update() {
				
		player.setX(player.getX() + player.getDx());
		player.setY(player.getY() - player.getDy());
		
		if(player.getX() >= background.getRightRoadBound())
			player.setX( background.getRightRoadBound() );
		
		if(player.getX() <= background.getLeftRoadBound())
			player.setX( background.getLeftRoadBound() );;

		 if(player.getY() <= background.getTopRoadBound())
			player.setY( background.getTopRoadBound() );
		
		if(player.getY() >= background.getDownRoadBound())
		 	player.setY( background.getDownRoadBound() );;
		
			
		score.currentScore += score.deltaScore;
		score.checkScore = score.currentScore;
		if(score.checkScore>0){
			
			background.setSpeed(2);
			obstacleone.setSpeed(2);
			obstacletwo.setSpeed(2);
			obstaclethree.setSpeed(2);
			
		}


		if(score.checkScore>3500){
			background.setSpeed(3);
			obstacleone.setSpeed(3+2);
			obstacletwo.setSpeed(3+2);
			obstaclethree.setSpeed(3+2);
			

		}
		
		if(score.checkScore>6000){
			background.setSpeed(5);
			score.deltaScore=10;
			obstacleone.setSpeed(5 + 5);
			obstacletwo.setSpeed(5 + 5 );
			obstaclethree.setSpeed(5 + 5);
			obstaclefour.setSpeed(5 + 10);
	
		}
		
		if(score.checkScore>15000){
			background.setSpeed(6);
			obstacleone.setSpeed(6 + 10);
			obstacletwo.setSpeed(6 + 10);
			obstaclethree.setSpeed(6 + 10);
			obstaclefour.setSpeed(5 + 100);
			score.deltaScore=25;
		}
		
		
	}



	@Override
	public void draw(Graphics g) {
			//g.drawImage(background.getBackRoad(),0, background.getRoadY(),null);
			if(score.currentScore >0){
			g.drawImage(background.getBackRoad2(),0, background.getRoadY(),null);
			g.drawImage(background.getRoadA(), background.getRoadX(), background.getRoadY(), null);
			
		}
			if(score.currentScore >5000){
			g.drawImage(background.getBackRoad(),0, background.getRoadY(),null);
			g.drawImage(background.getRoad(), background.getRoadX(), background.getRoadY(), null);
			}
			if(score.currentScore >15000){
			g.drawImage(background.getBackRoad3(),0, background.getRoadY(),null);
			g.drawImage(background.getRoad(), background.getRoadX(), background.getRoadY(), null);
			}
		
		g.setColor(new Color(240, 208, 83));
		Font f=new Font("MONOSPACED",Font.BOLD,20);
		g.setFont(f);
		g.drawString("SCORE : " +score.currentScore, 30, 500);
		g.drawImage(obstacleone.getImage(), (int)obstacleone.getX(), (int)obstacleone.getY(), null);
		g.drawImage(obstacletwo.getImage(), (int)obstacletwo.getX(), (int)obstacletwo.getY(), null);
		g.drawImage(obstaclefour.getImage(), (int)obstaclefour.getX(), (int)obstaclefour.getY(), null);
		g.drawImage(obstaclethree.getImage(), (int)obstaclethree.getX(), (int)obstaclethree.getY(), null);
		g.drawImage(obstaclefour.getImage(), (int)obstaclefour.getX(), (int)obstaclefour.getY(), null);g.drawImage(player.getImage(), (int) player.getX(),(int) player.getY(), null);


		score.finalScore = score.currentScore;
	}
	

	public void checkCollision(){
		score.deltaScore = 4;
		currentSpeed = 0;
		
		Rectangle op1 = obstacleone.getRectangle();
		Rectangle op2 = obstacletwo.getRectangle();
		Rectangle op3 = obstaclethree.getRectangle();
		Rectangle op4 = obstaclefour.getRectangle();
		
		
		Rectangle p = player.getRectangle();
		if(op1.intersects(p) || op2.intersects(p)||op3.intersects(p)||op4.intersects(p)){
			try {
				carSound2.stop();
				carSound3.stop();
				carSound4.stop();
				
				
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
				e.printStackTrace();
			}
			crash.play();
			gsm.setState(GameStateManager.STOPSTATE, score);
			
		}
		if(score.checkScore>6000){
			carSound3.pause();
			carSound4.play();
			carSound4.getCLip().loop(Clip.LOOP_CONTINUOUSLY);
	
		}

		if(score.checkScore>3500){
			carSound2.pause();
			carSound3.play();
			carSound3.getCLip().loop(Clip.LOOP_CONTINUOUSLY);
	
		}

		if(score.checkScore>1800){
			carSound1.pause();
			carSound2.play();
			carSound2.getCLip().loop(Clip.LOOP_CONTINUOUSLY);
		}

		if(score.checkScore > 0){
			carSound1.play();
			carSound1.getCLip().loop(Clip.LOOP_CONTINUOUSLY);
	
		}
		
		
	}

	
	@Override
	public void keyPressed(int key) {
		if(key==KeyEvent.VK_RIGHT){
			player.setDx(player.getDx() + 3.5);
		}
		
		if(key==KeyEvent.VK_LEFT){
			player.setDx(player.getDx() - 3.5);
		}

		if(key==KeyEvent.VK_DOWN){
			player.setDy(player.getDy() - 1.5);
		}

		if(key==KeyEvent.VK_UP){
			player.setDy(player.getDy() + 1.5);
		}
		
	}

	@Override
	public void keyReleased(int key) {
		if(key==KeyEvent.VK_RIGHT){
			player.setDx(0);
			player.setDy(0);
		}
		
		if(key==KeyEvent.VK_LEFT){
			player.setDx(0);
			player.setDy(0);
		}

		if(key==KeyEvent.VK_UP){
			player.setDx(0);
			player.setDy(0);
		}
		
		if(key==KeyEvent.VK_DOWN){
			player.setDx(0);
			player.setDy(0);
		}

	}


}
