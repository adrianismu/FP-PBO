package game.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import game.Background;
import game.GamePanel;
import game.entities.Score;

public class StopState extends GameState {

	private Score score;

	private Background background;

	Font highestScoreFont, f, titleFont;

	public StopState(GameStateManager gsm, Score score) {

		this.gsm = gsm;

		this.score = score;

		background = new Background();

		init();
	}

	@Override
	public void init() {
		highestScoreFont = new Font("HelveticaNeue", Font.BOLD, 25);
		f = new Font("HelveticaNeue", Font.BOLD, 50);
		titleFont = new Font("HelveticaNeue", Font.BOLD, 60);

		score.setHighestScore(score.finalScore);
	}

	@Override
	public void update() {

	}

	@Override
	public void draw(Graphics g) {

		g.drawImage(background.getEnd(), 0, 0, null);

		g.setFont(highestScoreFont);
		g.setColor(Color.WHITE);
		g.drawString("Highest Score: " + score.getHighestScore(), 100, 400);

		g.setFont(titleFont);
		g.setColor(Color.WHITE);
		g.drawString("GAME OVER", 100, 200);

		g.setFont(f);
		g.setColor(Color.WHITE);
		g.drawString("SCORE: " + score.finalScore, 100, 300);

		g.setFont(new Font("HelveticaNeue", Font.PLAIN, 25));
		g.setColor(Color.WHITE);
		g.drawString("Press Space to Play Again", GamePanel.WIDTH / 3 - 15, 480);

	}

	@Override
	public void keyPressed(int k) {

		if (k == KeyEvent.VK_SPACE) {
			gsm.setState(GameStateManager.LEVEL1STATE, score);
		}
	}

	@Override
	public void keyReleased(int k) {
		// TODO Auto-generated method stub

	}

}
