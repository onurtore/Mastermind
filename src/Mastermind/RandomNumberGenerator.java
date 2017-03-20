package Mastermind;

import java.util.Random;

public class RandomNumberGenerator {

	private int[] correctAnswer = new int[4];

	RandomNumberGenerator(){
		
		Random rand = new Random();
		
		correctAnswer[0] = rand.nextInt(9) + 0;
		correctAnswer[1] = rand.nextInt(9) + 0;
		correctAnswer[2] = rand.nextInt(9) + 0;
		correctAnswer[3] = rand.nextInt(9) + 0;
		
	
	}

	public int[] getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(int[] correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

}

