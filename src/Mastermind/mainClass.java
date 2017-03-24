package Mastermind;

import java.util.Vector;

public class mainClass {

	static boolean result = false;
	
	static boolean firstTry = true;
	
	static RandomNumberGenerator myRNG	= new RandomNumberGenerator();
	
	static int[] correctAnswer 			= myRNG.getCorrectAnswer();
	
	static PossiblyArrays myPA			= new PossiblyArrays();
	
	
	static int[] myGuess = new int[4];
	

	static int[] valueArray = new int[10];
	
	 
	public static void main(String[] args) {

		//Testing();
		
		correctAnswer[0] = 0;
		correctAnswer[1] = 0;
		correctAnswer[2] = 0;
		correctAnswer[3] = 0;
		
		for(int i = 0; i < 4; i++){
			valueArray[correctAnswer[i]]++;
		}

		
		
		//while(!result){
				//Generate Guess
				//Generate Result 
				//Eliminate Possibly Choices
				
				generateGuess();
				
				getResult();
				
				//eliminator();
		
		//}
			
	}
		
		
	
	/*
	 * Testing for our 4 different arrays
	 * 
	 */
	public static void Testing(){
		for(int i = 0 ; i < 4 ; i++){
			System.out.print(correctAnswer[i] + " ");
		}
		
		for(int i = 0; i < 2000; i++){
			for(int j = 0; j < 4; j++){
				System.out.print(myPA.array5[i][j]);
			}
			System.out.println();
		}
		
	}
	
	public static void generateGuess(){
			
		if(firstTry){
			firstTry = false;
			myGuess[0] = 0;
			myGuess[1] = 0;
			myGuess[2] = 0;
			myGuess[3] = 0;
		}
		
		
		
		
		
	}
	
	public static void  getResult(){
		
		int RightValue = 0;
		
		//Not O(n^2), O(n)
		
		for(int i = 0 ; i < 4 ; i++){
			
			if(valueArray[myGuess[i]]  > 0){
				RightValue++;
				valueArray[myGuess[i]]--;
				
			}
		}
		
		System.out.println(RightValue);
		
	}
	

}