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
import java.io.IOException;

public class Level1State extends GameState {
	
	int currentSpeed;
	Background background;
	PlayerCar player;
	Obstacle1 obstacleone;
	Obstacle2 obstacletwo;
	Obstacle3 obstaclethree;
	//Obstacle1 obstacleone;

	
	public Level1State(GameStateManager gsm) {
		
		this.gsm = gsm;
		player = new PlayerCar();
		obstacleone = new Obstacle1();
		obstacletwo = new Obstacle2();
		obstaclethree = new Obstacle3();
		
		background = new Background();
		score = new Score();	
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	public void action() {
		update();
		obstacleone.move();
		obstacletwo.move();
		obstaclethree.move();
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
		
			
		score.currentScore += score.deltaScore;
		score.checkScore = score.currentScore;
		obstacleone.setSpeed(2);
		obstacletwo.setSpeed(2);
		obstaclethree.setSpeed(2);

		if(score.checkScore>3500){
			background.setSpeed(7);
			obstacleone.setSpeed(7);
			obstacletwo.setSpeed(7);
			obstaclethree.setSpeed(7);
			
		}
		
		if(score.checkScore>5000){
			background.setSpeed(8);
			score.deltaScore=10;
			obstacleone.setSpeed(8);
			obstacletwo.setSpeed(7);
			obstaclethree.setSpeed(7);
		}
		
		if(score.checkScore>7000){
			background.setSpeed(9);
			score.deltaScore=25;
		}
		else {
			background.setSpeed(currentSpeed);
		}
		
	}

	@Override
	public void draw(Graphics g) {
			//g.drawImage(background.getBackRoad(),0, background.getRoadY(),null);
			if(score.currentScore >0){
			g.drawImage(background.getBackRoad2(),0, background.getRoadY(),null);
			}
			if(score.currentScore >5000){
			g.drawImage(background.getBackRoad(),0, background.getRoadY(),null);
			}
			if(score.currentScore >34000){
			g.drawImage(background.getBackRoad2(),0, background.getRoadY(),null);
			}

		g.setColor(new Color(240, 208, 83));
		Font f=new Font("MONOSPACED",Font.BOLD,20);
		g.setFont(f);
		g.drawString("SCORE : " +score.currentScore, 30, 500);
		
		g.drawImage(background.getRoad(), background.getRoadX(), background.getRoadY(), null);

		g.drawImage(obstacleone.getImage(), (int)obstacleone.getX(), (int)obstacleone.getY(), null);
		g.drawImage(obstacletwo.getImage(), (int)obstacletwo.getX(), (int)obstacletwo.getY(), null);
		g.drawImage(obstaclethree.getImage(), (int)obstaclethree.getX(), (int)obstaclethree.getY(), null);

		g.drawImage(player.getImage(), (int) player.getX(),(int) player.getY(), null);
		
		
		score.finalScore = score.currentScore;

	}

	public void checkCollision(){
		score.deltaScore = 4;
		currentSpeed = 2;
		
		Rectangle op1 = obstacleone.getRectangle();
		Rectangle op2 = obstacletwo.getRectangle();
		Rectangle op3 = obstaclethree.getRectangle();
		
		
		Rectangle p = player.getRectangle();
		if(op1.intersects(p)|op2.intersects(p)|op3.intersects(p)){
			gsm.setState(GameStateManager.STOPSTATE, score);
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
