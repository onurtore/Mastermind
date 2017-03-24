package Mastermind;

public class GuessEliminator extends Thread {

	int partion;
	static  boolean isFinish = false;
	static 	int myGuess[] = new int[4];
	public GuessEliminator(int partion){
		
		this.partion = partion;
		
	}
	
	public void run(){
		isFinish = false;
		if(partion == 1){
			for(int i = 0; i < 2000; i++){
				if(isFinish){
					return;
				}
				if(mainClass.myPA.array1[i][0] != -1 ){
					int[] eliminationGuess = mainClass.getResult(mainClass.myPA.array1[i]);
					if(eliminationGuess[0] != mainClass.guessC || eliminationGuess[1] != mainClass.guessW   ){
						mainClass.myPA.array1[i][0] = -1;
					}
					else{
						isFinish = true;
						mainClass.myGuess = mainClass.myPA.array1[i];
					}
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
						mainClass.myGuess = mainClass.myPA.array1[i];
					}
				}
			}
		}
		if(partion == 3){
			for(int i = 0; i < 2000; i++){
				if(isFinish){
					return;
				}
				if(mainClass.myPA.array3[i][0] != -1 ){
					int[] eliminationGuess = mainClass.getResult(mainClass.myPA.array3[i]);
					if(eliminationGuess[0] != mainClass.guessC || eliminationGuess[1] != mainClass.guessW   ){
						mainClass.myPA.array3[i][0] = -1;
					}
					else{
						isFinish = true;
						mainClass.myGuess = mainClass.myPA.array1[i];
					}
				}
			}
		}
		if(partion == 4){
			for(int i = 0; i < 2000; i++){
				if(isFinish){
					return;
				}
				if(mainClass.myPA.array4[i][0] != -1 ){
					int[] eliminationGuess = mainClass.getResult(mainClass.myPA.array4[i]);
					if(eliminationGuess[0] != mainClass.guessC || eliminationGuess[1] != mainClass.guessW   ){
						mainClass.myPA.array4[i][0] = -1;
					}
					else{
						isFinish = true;
						mainClass.myGuess = mainClass.myPA.array1[i];	
					}
				}
			}
		}
	
	}
	
}
