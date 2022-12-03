package game.entities;

public abstract class Obstacle extends Car {
    
	protected int area = 0;
	protected boolean visible = true;
	
	public Obstacle(String pathImage) {
		
		super(pathImage);
		
		generateRandomPosition();
	}
	
	protected void generateRandomPosition() {
		int x1 = (int)(Math.random()/2);
		x = 200+x1*area;
		int y1 = (int)(Math.random()/2);
		y = y1*area-500;
	}

	// protected void generateRandomPosition() {
	// 	int x1 = (int)(Math.random()*16);
	// 	x = 200+x1*area;
	// 	int y1 = (int)(Math.random()*1);
	// 	y = y1*area-500;
	// }

    protected void generateRandomPosition1() {
		int x1 = (int)(Math.random()/2);
		x = 200+x1*area;
		int y1 = (int)(Math.random()/2);
		y = y1*area-100;
	}

    protected void generateRandomPosition2() {
		int x1 = (int)(Math.random()/2);
		x = 300+x1*area;
		int y1 = (int)(Math.random()/2);
		y = y1*area-2000;
	}

	abstract public void move();
    
	public void setSpeed (int dy){
		this.dy = dy;
	}
	
	public void setVisible(boolean visible){
		this.visible = visible;
	}
	
	public boolean isVisible(){
		return visible;
	}
}
