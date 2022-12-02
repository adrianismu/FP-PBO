package game.entities;

public abstract class Obstacle extends Car {
    
	protected int area = 15;
	protected boolean visible = true;
	
	public Obstacle(String pathImage) {
		
		super(pathImage);
		
		generateRandomPosition();
	}
	
	protected void generateRandomPosition() {
		int x1 = (int)(Math.random()*16);
		x = 250+x1*area;
		int y1 = (int)(Math.random()*1);
		y = y1*area-600;
	}

    protected void generateRandomPosition1() {
		int x1 = (int)(Math.random()*16);
		x = 200+x1*area;
		int y1 = (int)(Math.random()*1);
		y = y1*area-600;
	}

    protected void generateRandomPosition2() {
		int x1 = (int)(Math.random()*16);
		x = 300+x1*area;
		int y1 = (int)(Math.random()*1);
		y = y1*area-600;
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
