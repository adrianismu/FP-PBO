package game.entities;

public class Obstacle1 extends Obstacle {
    

private static String pathImage = "/res/obstacle1.png";
	
	public Obstacle1() {
		super(pathImage);
		
	}
	
	public void move()
	{
		y+=dy;
		if(y >= 1800)
			generateRandomPosition();
		
			
	}
	
}