package game;

import java.awt.Image;
import java.awt.image.BufferedImage;
import game.tools.ImageLoader;

public class Background {
	
	private static final int LEFT_ROAD_BOUND = 260;
	private static final int RIGHT_ROAD_BOUND = 482;
	private static final int TOP_ROAD_BOUND = 0;
	private static final int DOWN_ROAD_BOUND = 590;
	
	private	BufferedImage road, backRoad, backroad2;
	private int roadX, roadY, backRoadX, backRoadY; 
	private int dy;

	
	public Background(){
		roadX=200;
	    roadY=1640;
		 backRoadX = 100;
		 backRoadY= -1000;
	    
	    road = ImageLoader.loadImage("/res/(long)portraitRoadBG.png");
	    backRoad = ImageLoader.loadImage("/res/(long)background.png");
		backroad2 = ImageLoader.loadImage("/res/(long)backgroundw.png");
	}

	 
	 public int getRoadX(){
		 return roadX;
	 }
	 
	 public int getRoadY(){
		 return roadY;
	 }
	 public int geBackRoadX(){
		return backRoadX;
	}
	
	public int getBackRoadY(){
		return backRoadY;
	}
	 
	 public Image getRoad() {	
		return road;
	}
	 
	 public Image getBackRoad(){
		return backRoad;
	 }

	 public Image getBackRoad2(){
		return backroad2;
	 }
	 
	 
	 public void update(){
	     roadY+=dy;
	     if(roadY>0){
	    	 roadY=-3340;
			 backRoadY+=dy;
			 backRoadY+=dy;

			
	}

	 }
	 
	 public void setSpeed(int dy){
		 this.dy = dy;
		 update();
	 }


	 public static int getLeftRoadBound() {
		 return LEFT_ROAD_BOUND;
	 }

	 public static int getRightRoadBound() {
		 return RIGHT_ROAD_BOUND;
	 }

	 public static int getTopRoadBound() {
		return TOP_ROAD_BOUND;
	}


	public static int getDownRoadBound() {
		return DOWN_ROAD_BOUND;
	}

}