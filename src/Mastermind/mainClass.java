package Mastermind;

import java.util.Vector;

public class mainClass {

	static boolean result = false;	
	static boolean firstTry = true;
	static RandomNumberGenerator myRNG	= new RandomNumberGenerator();
	static int[] correctAnswer = myRNG.getCorrectAnswer();
	final static PossiblyArrays myPA	= new PossiblyArrays();
	static int[] myGuess = new int[4];
	static int[] valueArray = new int[10];
	static int[] positionArray = new int[10];
	
	static int[] oldGuess;
	static int guessW = 0;
	static int guessC = 0;
	
	static  Vector<int[]> guessVector = new Vector<int[]>();
	static 	Vector<int[]> guessResult = new Vector<int[]>();
	
	public static void main(String[] args) {
			

		while(true){

			
			if(firstTry){
				firstTry = false;
				myGuess[0] = 1;
				myGuess[1] = 1;
				myGuess[2] = 2;
				myGuess[3] = 2;
				myPA.array1[1122][0] = -1;
			}
	/*			System.out.println("\n\n");
				for(int i = 0; i < guessVector.size(); i++){
					for(int j = 0; j < 4 ; j++){
						System.out.print(guessVector.elementAt(i)[j]);
					}
					System.out.println();
				
				}
				System.out.println("\n\n");
				for(int i = 0; i < guessResult.size(); i++){
					for(int j = 0; j <2 ; j++){
						System.out.print(guessResult.elementAt(i)[j]);
					}
					System.out.println();
				
				}
	*/	
			
			int [] numbersClone = (int[])myGuess.clone();
			guessVector.addElement(numbersClone);//Add old guesses to this vector 
			
			
			System.out.print("Right Answer is: ");
			
			for(int i = 0;  i < 4 ; i++){
				System.out.print(correctAnswer[i]);
			}
			
			System.out.println();
			System.out.print("My Guess is: ");
			for(int i = 0;  i < 4 ; i++){
				System.out.print(myGuess[i]);
			}
			
			System.out.println();
			
			int [] guessArray  = getResult(myGuess);
		
			guessC = guessArray[0];
			guessW = guessArray[1];
			
			
			int [] numbersClone2 = (int[])guessArray.clone();
			guessResult.addElement(numbersClone2);
			
			System.out.println("GuessC is: " + guessC + " GuessW is:" + guessW);
			
			if(guessC == 4){
				return;
			}
			
				
			
			eliminator();
	
			}
			
	}
		
		
	
	/*
	 * Testing for our 4 different arrays
	 */
	public  void Testing(){
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
		
		GuessEliminator eliminate1 = new GuessEliminator();
		GuessEliminator.isFinish = false;
		
		eliminate1.start();
		//eliminate2.start();
		//eliminate3.start();
		//eliminate4.start();
	
		try{
			
			eliminate1.join();
		}
		catch(InterruptedException ie){
			ie.printStackTrace();
			
		}
		
	}
	
	public static int[]  getResult(int[] myGuess){
		
		valueArray = new int[10];
		
		for(int i = 0; i < 4; i++){
			valueArray[myGuess[i]]++;
		}
		
		
		int RightValue = 0;
		int RightPlaceAndValue = 0;
		
		//Not O(n^2), O(n)
		
		for(int i = 0 ; i < 4 ; i++){
			
			if(valueArray[correctAnswer[i]]  > 0){
				if(myGuess[i] == correctAnswer[i]){
					RightPlaceAndValue++;
				}
				else{
					RightValue++;
				}
				
				valueArray[correctAnswer[i]]--;
			}
		}

		
		
		int[] returnArray = new int[2];
		returnArray[0] = RightPlaceAndValue;
		returnArray[1] = RightValue;
		return returnArray;
	}
	

}