package Mastermind;


public class GuessEliminator extends Thread {

	int[][] myArray;
	static  boolean isFinish = false;

		
	GuessEliminator(int[][] PaArray){
		
		this.myArray = PaArray;
		
	}
	
	
	//Yanlýþ þeyi kontrol cevap bu olsaydý ne olurdu onu kontrol etmeli 
	public boolean getResult(int[] correctAnswer){

		for(int i = 0 ; i < mainClass.guessVector.size(); i++){

			int[] valueArray = new int[10];
			
			//reconstruct the correct answer 
			for(int j = 0; j < 4; j++){
				valueArray[mainClass.guessVector.elementAt(i)[j]]++;
			}
			
			int RightValue = 0; 
			int RightPlaceAndValue = 0;
			
			for(int j = 0 ; j < 4 ; j++){
				
				if(valueArray[correctAnswer[j]]  > 0){
					if(mainClass.guessVector.elementAt(i)[j] == correctAnswer[j]){
						RightPlaceAndValue++;
					}
					else{
						RightValue++;
					}
					
					valueArray[correctAnswer[j]]--;
				}
			}
			if(mainClass.guessResult.elementAt(i)[0] != RightPlaceAndValue || mainClass.guessResult.elementAt(i)[1] != RightValue){
				return false;
			}
		}
		return true;
		
	}
	
	public void run(){
			
		
			for(int i = 0; i < 5000; i++){
				if(isFinish){

					return;

				}	
				/*Neden çalýþmýyor bak
				 * if(Thread.currentThread().isInterrupted()){
					return;
				}*/
				if(myArray[i][0] != -1 ){
						mainClass.tryCounter++;
						if(!getResult(myArray[i])  ){
							myArray[i][0] = -1;
						}
						else{
							isFinish = true;	
							//Deep Copy
							System.arraycopy(myArray[i],0,mainClass.myGuess,0,mainClass.myGuess.length);
							myArray[i][0] = -1;
							
						}
				}	
				if(i == 4999){
					return;
				}
			}
			
		}
}	

