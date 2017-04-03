package Mastermind;

import java.util.Vector;

public class mainClass {

	static boolean result = false;	
	static boolean firstTry = true;
	static RandomNumberGenerator myRNG	= new RandomNumberGenerator();
	static int[] correctAnswer = new int[4];
	final static PossiblyArrays myPA	= new PossiblyArrays();
	static int[] myGuess = new int[4];
	static int[] valueArray = new int[10];
	static int[] positionArray = new int[10];
	String outputString;
	static int[] oldGuess;
	static int guessW = 0;
	static int guessC = 0;
	
	static int guessCounter = 0;
	static int tryCounter = 0;
	static boolean eliminationDone = false;
	
	static  Vector<int[]> guessVector = new Vector<int[]>();
	static 	Vector<int[]> guessResult = new Vector<int[]>();
	static long startTime = System.currentTimeMillis();
	
	mainClass(int[] userInput){
		
		correctAnswer[0] = userInput[0];
		correctAnswer[1] = userInput[1];
		correctAnswer[2] = userInput[2];
		correctAnswer[3] = userInput[3];
		
	}
	
	
	
	public   void  startGame() {
		
		
		
		//System.out.print("Right Answer is: ");
		
		//For GUI
		outputString = "<html>Right Answer is: ";
		
		for(int i = 0;  i < 4 ; i++){
			//System.out.print(correctAnswer[i]);
			//For GUI
			outputString += correctAnswer[i];
		}
		
		while(true){

			
			if(firstTry){
				firstTry = false;
				myGuess[0] = 1;
				myGuess[1] = 1;
				myGuess[2] = 2;
				myGuess[3] = 2;
				myPA.array1[1122][0] = -1;
			}
			int [] numbersClone = (int[])myGuess.clone();
			guessVector.addElement(numbersClone);//Add old guesses to this vector 
			
			
			//System.out.println();
			
			//For GUI
			outputString += "<br> My Guess is ";
			
			//System.out.print("My Guess is: ");
			for(int i = 0;  i < 4 ; i++){
			//	System.out.print(myGuess[i]);
				//For GUI
				outputString += myGuess[i];
			}
			
			//System.out.println();
			
			int [] guessArray  = getResult(myGuess);
		
			guessC = guessArray[0];
			guessW = guessArray[1];
			
			
			int [] numbersClone2 = (int[])guessArray.clone();
			guessResult.addElement(numbersClone2);
			
			
			guessCounter++;
			
			if(guessC == 4){
				//For GUI
				outputString += "<br>Found in " + guessCounter +" guess in " + tryCounter +" tries.</html>";
				//System.out.println("\nFound in " + guessCounter +" guess in " + tryCounter +" tries.");
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
				System.out.print(myPA.array1[i][j]);
			}
			System.out.println();
		}
		
	}
	
	
	public static void eliminator(){
		
		GuessEliminator eliminate1 = new GuessEliminator(myPA.array1);
		GuessEliminator eliminate2 = new GuessEliminator(myPA.array2);

		GuessEliminator.isFinish = false;
		eliminationDone = false;
		eliminate1.start();
		eliminate2.start();
	
		/*
		while(true){
			if(eliminationDone){
				if(eliminate1.isAlive()){
					eliminate1.interrupt();
				}
				if(eliminate2.isAlive()){
					eliminate2.interrupt();
				}
				break;
			}
		System.out.println(eliminationDone);
		}*/
		

		try {

			eliminate1.join();

		} catch (InterruptedException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

		try {

			eliminate2.join();

		} catch (InterruptedException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

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