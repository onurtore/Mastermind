package Mastermind;

public class mainClass {

	static boolean result = false;
	static boolean firstTry = true;
	static RandomNumberGenerator myRNG	= new RandomNumberGenerator();
	static PossiblyArrays myPA			= new PossiblyArrays();
	static int[] correctAnswer 			= myRNG.getCorrectAnswer();
	
	
	
	public static void main(String[] args) {

		//Testing();
		
		
		
		while(!result){
			if(firstTry){
				
				//Under construction please don't touch
				//Generate Guess
				//Generate Result 
				//Eliminate Possibly Choices
				
				generateGuess();
			}
			
		}
		
		
	}
	
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
	
	public static void GenerateGues

}
/*
Apply minimax technique to find a next guess as follows: 
For each possible guess, that is, any unused code of the 1296 
not just those in S, calculate how many possibilities in S would
be eliminated for each possible colored/white peg score.
The score of a guess is the minimum number of possibilities 
it might eliminate from S. A single pass through S for each 
unused code of the 1296 will provide a hit count for each 
colored/white peg score found; the colored/white peg score 
with the highest hit count will eliminate the fewest 
possibilities; calculate the score of a guess by using 
"minimum eliminated" = "count of elements in S" - (minus) 
"highest hit count". From the set of guesses with the maximum 
score, select one as the next guess, choosing a member of S 
whenever possible. (Knuth follows the convention of choosing 
the guess with the least numeric value e.g. 2345 is lower than
3456. Knuth also gives an example showing that in some cases
no member of S will be among the highest scoring guesses and
thus the guess cannot win on the next turn, yet will be
necessary to assure a win in five.)
7)Repeat from step 3.
*/