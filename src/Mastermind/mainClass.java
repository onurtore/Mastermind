package Mastermind;

import java.util.Vector;

public class mainClass {

	static boolean result = false;	
	static boolean firstTry = true;
	static RandomNumberGenerator myRNG	= new RandomNumberGenerator();
	static int[] correctAnswer = myRNG.getCorrectAnswer();
	static PossiblyArrays myPA	= new PossiblyArrays();
	static int[] myGuess = new int[4];
	static int[] valueArray = new int[10];
	static int[] positionArray = new int[10];
	
	
	static int guessW = 0;
	static int guessC = 0;
	
	public static void main(String[] args) {

		for(int i = 0; i < 4; i++){
			valueArray[correctAnswer[i]]++;
		}
		
		
		
		while(!result){

			if(firstTry){
				firstTry = false;
				myGuess[0] = 1;
				myGuess[1] = 1;
				myGuess[2] = 2;
				myGuess[3] = 2;
			}
			

			for(int i = 0;  i < 4 ; i++){
				System.out.print(myGuess[i]);
			}
			
			System.out.println();
			
			int [] guessArray  = getResult(myGuess);
		
			guessC = guessArray[0];
			guessW = guessArray[1];
			
			
			
			if(guessC == 4){
				return;
			}
				
			eliminator();
			
			
			
		
		}
			
	}
		
		
	
	/*
	 * Testing for our 4 different arrays
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
	
	
	public static void eliminator(){
		
		//Just like the terminator
		GuessEliminator eliminate1 = new GuessEliminator(1);
		GuessEliminator eliminate2 = new GuessEliminator(2);
		GuessEliminator eliminate3 = new GuessEliminator(3);
		GuessEliminator eliminate4 = new GuessEliminator(4);
	
		eliminate1.start();
		eliminate2.start();
		eliminate3.start();
		eliminate4.start();
		
		try{
			eliminate1.join();
		}
		catch(InterruptedException ie){
			ie.printStackTrace();
			
		}
		
	}
	
	public static int[]  getResult(int[] myGuess){
		
		int RightValue = 0;
		int RightPlaceAndValue = 0;
		
		//Not O(n^2), O(n)
		
		for(int i = 0 ; i < 4 ; i++){
			
			if(valueArray[myGuess[i]]  > 0){
				if(myGuess[i] == correctAnswer[i]){
					RightPlaceAndValue++;
				}
				else{
					RightValue++;
				}
				
				valueArray[myGuess[i]]--;
			}
		}

		
		
		int[] returnArray = new int[2];
		returnArray[0] = RightPlaceAndValue;
		returnArray[1] = RightValue;
		return returnArray;
	}
	

}