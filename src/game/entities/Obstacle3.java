package game.entities;

public class Obstacle3 extends Obstacle {
    

private static String pathImage = "/res/obstacle3.png";
	
	public Obstacle3() {
		super(pathImage);
		
	}
	
	public void move()
	{
		y+=dy;
		if(y >= 2200)
			generateRandomPosition2();
	}
	
}