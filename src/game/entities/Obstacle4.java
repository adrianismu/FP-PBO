package game.entities;

public class Obstacle4 extends Obstacle {
    

private static String pathImage = "/res/obstacle4R.png";
	
	public Obstacle4() {
		super(pathImage);
		
	}
	
	public void move()
	{
		y+=dy;
		if(y >= 1450)
			generateRandomPosition4();
	}
	
}