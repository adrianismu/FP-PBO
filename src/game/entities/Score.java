package game.entities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Score {

	public int currentScore;
	public int checkScore;
	public int deltaScore;
	public int finalScore;

	private int highestScore;
	
	URL pathHighestScore;
	
	File highestScoreFile;
	
	public Score() {
		
		pathHighestScore = getClass().getResource("/res/highestScore.txt");		
		init();

	}
	
	public void init() {
			
		try {
		      highestScoreFile = new File(pathHighestScore.getPath());
		      Scanner myReader = new Scanner(highestScoreFile);
		      while (myReader.hasNextInt()) {
		        highestScore = myReader.nextInt();
		      }
		      myReader.close();
		} catch (FileNotFoundException e) {
		      e.printStackTrace();
		}
		
	}

	
	public void setHighestScore(int score) {
	
		highestScore = Math.max(highestScore, score);
		
		// read file highest score and compare
		try {
		      Scanner myReader = new Scanner(highestScoreFile);
		      
		      int highestScoreTemp = 0;
		      while (myReader.hasNextInt()) {
		        highestScoreTemp = myReader.nextInt();
		      }
		      
		      highestScore = Math.max(highestScore, highestScoreTemp);
		      
		      myReader.close();
		} catch (FileNotFoundException e) {
		      e.printStackTrace();
		}
		
		// write highest score to file
		try {
		      FileWriter myWriter = new FileWriter("src/res/highestScore.txt");
		      myWriter.write(highestScore + "");
		      myWriter.close();
		} catch (IOException e) {
	      e.printStackTrace();
	    }
		
	}
	
	
	public int getHighestScore() {
		return highestScore;
	}
	

}
