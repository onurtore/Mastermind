package Mastermind;

import java.util.Random;

public class GuessEliminator extends Thread {

	int partion;
	static  boolean isFinish = false;
	int myGuess[] = new int[4];
	int[][] array1;
	
	public GuessEliminator(int partion,PossiblyArrays myPA){
		
		array1 = myPA.array1;

		this.partion = partion;
		
	}
	
	//Yanlýþ þeyi kontrol cevap bu olsaydý ne olurdu onu kontrol etmeli 
	public int[] getResult(int[] array ){
		
	}
	
	public void run(){
		if(partion == 1){
			for(int i = 0; i < 9999; i++){
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(isFinish){
					return;
				}
				if(array1[i][0] != -1 ){
					int[] eliminationGuess = getResult(array1[i]);
					int[] eliminationGuess = mainClass.getResult(mainClass.myPA.array1[i]);
					if(eliminationGuess[0] != mainClass.guessC || eliminationGuess[1] != mainClass.guessW   ){
						array1[i][0] = -1;
					}
					else{
		
						isFinish = true;	
						System.arraycopy(array1[i],0,mainClass.myGuess,0,mainClass.myGuess.length);
						array1[i][0] = -1;
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
		if(partion == 2){
			for(int i = 0; i < 2000; i++){	
				if(isFinish){
					return;
				}
				if(mainClass.myPA.array2[i][0] != -1 ){
					int[] eliminationGuess = mainClass.getResult(mainClass.myPA.array2[i]);
					if(eliminationGuess[0] != mainClass.guessC || eliminationGuess[1] != mainClass.guessW   ){
						mainClass.myPA.array2[i][0] = -1;
					}
					else{
						isFinish = true;	
						System.arraycopy(mainClass.myPA.array2[i],0,mainClass.myGuess,0,mainClass.myGuess.length);
						mainClass.myPA.array2[i][0] = -1;
					}
				}
				if(isFinish){
					return;
				}
				if(i == 1999 & !isFinish){
					return;
				}
			}
		}
		if(partion == 3){
			for(int i = 0; i < 2000; i++){
				if(mainClass.myPA.array3[i][0] != -1 ){
					int[] eliminationGuess = mainClass.getResult(mainClass.myPA.array3[i]);
					if(eliminationGuess[0] != mainClass.guessC || eliminationGuess[1] != mainClass.guessW   ){
						mainClass.myPA.array3[i][0] = -1;
					}
					else{
						isFinish = true;	
						System.arraycopy(mainClass.myPA.array3[i],0,mainClass.myGuess,0,mainClass.myGuess.length);
						mainClass.myPA.array3[i][0] = -1;					
					}
				}
				if(i == 1999 & !isFinish){
					return;
				}
				if(isFinish){
					return;
				}
			}
		}
		if(partion == 4){
			for(int i = 0; i < 2000; i++){
				if(mainClass.myPA.array4[i][0] != -1 ){
					int[] eliminationGuess = mainClass.getResult(mainClass.myPA.array4[i]);
					if(eliminationGuess[0] != mainClass.guessC || eliminationGuess[1] != mainClass.guessW   ){
						mainClass.myPA.array4[i][0] = -1;
					}
					else{
						
						isFinish = true;	
						System.arraycopy(mainClass.myPA.array4[i],0,mainClass.myGuess,0,mainClass.myGuess.length);
						mainClass.myPA.array4[i][0] = -1;
					}
					
				}
				if(isFinish){
					return;
				}
				
				if(i == 1999 & !isFinish){
					return;
				}
			}
		}
	
	}
	
}
