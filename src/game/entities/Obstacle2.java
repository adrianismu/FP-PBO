package game.entities;

public class Obstacle2 extends Obstacle {
    

private static String pathImage = "/res/obstacle2.png";
	
	public Obstacle2() {
		super(pathImage);
		
	}
	
	public void move()
	{
		y+=dy;
		if(y >= 1100){
			generateRandomPosition2();
		}
	}
	
}