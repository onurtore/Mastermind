package Mastermind;

import java.util.Random;

public class GuessEliminator extends Thread {

	int partion;
	static  boolean isFinish = false;

		
	//Yanlýþ þeyi kontrol cevap bu olsaydý ne olurdu onu kontrol etmeli 
	public boolean getResult(int[] correctAnswer){

		for(int i = 0 ; i < mainClass.guessVector.size(); i++){

			int[] valueArray = new int[10];
			
			//reconstruct the correct answer 
			for(int j = 0; j < 4; j++){
				valueArray[correctAnswer[j]]++;
			}
			
			int RightValue = 0; 
			int RightPlaceAndValue = 0;
			
			for(int j = 0 ; j < 4 ; j++){
				
				if(valueArray[mainClass.guessVector.elementAt(i)[j] ]  > 0){
					if(mainClass.guessVector.elementAt(i)[j] == correctAnswer[j]){
						RightPlaceAndValue++;
					}
					else{
						RightValue++;
					}
					
					valueArray[mainClass.guessVector.elementAt(i)[j]]--;
				}
			}
			if(mainClass.guessResult.elementAt(i)[0] != RightPlaceAndValue || mainClass.guessResult.elementAt(i)[1] != RightValue){
				return false;
			}
		}
		return true;
		
	}
	
	public void run(){

			for(int i = 0; i < 9999; i++){
				//try {
				//	Thread.sleep(5);
				//} catch (InterruptedException e) {
					 //TODO Auto-generated catch block
					// e.printStackTrace();
				//}
				if(mainClass.myPA.array1[i][0] != -1 ){
					if(!getResult(mainClass.myPA.array1[i])  ){
						mainClass.myPA.array1[i][0] = -1;
					}
					else{
						isFinish = true;	
						System.arraycopy(mainClass.myPA.array1[i],0,mainClass.myGuess,0,mainClass.myGuess.length);
						mainClass.myPA.array1[i][0] = -1;
					}
				}
				if(isFinish){
					return;
				}
				if(i == 9999){
									
					return;
				}
			}
		}
}	

