package Mastermind;


public class mainClass {

	static boolean result = false;	
	static boolean firstTry = true;
	static RandomNumberGenerator myRNG	= new RandomNumberGenerator();
	static int[] correctAnswer = myRNG.getCorrectAnswer();
	static PossiblyArrays myPA	= new PossiblyArrays();
	static int[] myGuess = new int[4];
	static int[] valueArray = new int[10];
	static int[] positionArray = new int[10];
	 
	public static void main(String[] args) {

		//Testing();
		/*
		correctAnswer[0] = 7;
		correctAnswer[1] = 0;
		correctAnswer[2] = 8;
		correctAnswer[3] = 5;
		*/
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
			myGuess[0] = 1;
			myGuess[1] = 1;
			myGuess[2] = 2;
			myGuess[3] = 2;
		}
		
		
		
		
		
	}
	
	public static void  getResult(){
		
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
		
		System.out.println("C is: " + RightPlaceAndValue + "W is: " + RightValue);
	}
	

}