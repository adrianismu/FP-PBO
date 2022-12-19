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

	public int deltaFuel;
	public int currentFuel;
	public int finalFuel;
	private int highestFuel;
	
	URL pathHighestScore, pathHighestFuel;
	File highestScoreFile, highestFuelFile;
	
	public Score() {
		
		pathHighestScore = getClass().getResource("/res/highestScore.txt");
		pathHighestFuel = getClass().getResource("/res/highestFuel.txt");
		
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

		try {
			highestFuelFile = new File(pathHighestFuel.getPath());
			Scanner myReader = new Scanner(highestFuelFile);
			while (myReader.hasNextInt()) {
				highestFuel = myReader.nextInt();
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
		
	
		try {
		      FileWriter myWriter = new FileWriter("src/res/highestScore.txt");
		      myWriter.write(highestScore + "");
		      myWriter.close();
		} catch (IOException e) {
	      e.printStackTrace();
	    }
		
	}

	public void setHighestFuel(int fuelCount) {
		
		highestFuel = Math.max(highestFuel, fuelCount);
		
		// read file highest coin count and compare
		try {
		      Scanner myReader = new Scanner(highestFuelFile);
		      
		      int highestFuelTemp = 0;
		      while (myReader.hasNextInt()) {
				highestFuelTemp  = myReader.nextInt();
		      }
		      
		      highestFuel = Math.max(highestFuel, highestFuelTemp );
		      
		      myReader.close();
		} catch (FileNotFoundException e) {
		      e.printStackTrace();
		}
		
		// write highest score to file
		try {
		      FileWriter myWriter = new FileWriter("src/res/.txt");
		      myWriter.write(highestFuel + "/res/highestFuel.txt");
		      myWriter.close();
		} catch (IOException e) {
	      e.printStackTrace();
	    }
		
	}
	
	
	public int getHighestScore() {
		return highestScore;
	}

	public int getHighestFuel() {
		return highestFuel;
	}
	

}
