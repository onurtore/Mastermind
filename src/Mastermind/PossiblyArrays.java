package Mastermind;


public class PossiblyArrays {
//deneme
	//Fast access to these vector so they are become public 
	
	//Different vector for every thread
	
	public int[][] array1 = new int[5000][4];
	public int[][] array2 = new int[5000][4];
	
	PossiblyArrays(){
		fillArrays();
	}
	
	public void fillArrays(){
		
		int counter = 0;

		for(int i = 0; i < 5000 ; i++){
			array1[i] = intToDigits(counter);
			++counter;
		}
		

		for(int i = 0; i < 5000 ; i++){
			array2[i] = intToDigits(counter);
			++counter;
		}
		return;
		
		
	}
	
	public int[] intToDigits(int number ){
		
		int[] digitArray = new int[4];
		
		//I know java did this automatically but i am a C++ programmer, so double check
		for(int i = 0 ; i < 4; i++){
			digitArray[i] = 0; 
		}
		
		int digit = 0; 
		int digitCount = 3;
		
		while (number> 0) {
			
		    digit = number % 10;

		    digitArray[digitCount] = digit;
		   
		    number = number / 10;
		    
		    --digitCount;
		}
		
		return digitArray;		
	}
	

}
