package Mastermind;
import javax.swing.JOptionPane; // program uses JOptionPane


public class GUI 
{
    
     public static void main( String args[] )
     {

     
    	 
    	String firstNumber =  JOptionPane.showInputDialog( null,"Enter the Secret Number:","MasterMind Game",JOptionPane.PLAIN_MESSAGE );  
        
    	
        
        int[] userInputArray;
		
        try {
        	
        	int userInput = Integer.parseInt( firstNumber);
        	userInputArray = intToDigits( userInput);
	        mainClass myGame = new mainClass(userInputArray);
	        myGame.startGame();
	        JOptionPane.showMessageDialog(null,myGame.outputString,"MasterMind Game",JOptionPane.PLAIN_MESSAGE);   
        
        } catch (notGoodInputException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,"Enter Valid Number","MasterMind Game",JOptionPane.PLAIN_MESSAGE);
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"Enter Valid Number","MasterMind Game",JOptionPane.PLAIN_MESSAGE);
			
		}
        
    

     } 
     
     
     public static int[] intToDigits(int number ) throws notGoodInputException {
 		
 		int[] digitArray = new int[4];
 		
 		//I know java did this automatically but i am a C++ programmer, so double check
 		for(int i = 0 ; i < 4; i++){
 			digitArray[i] = 0; 
 		}
 		
 		int digit = 0; 
 		int digitCount = 3;
 		
 		while (number> 0) {
 			
 		    digit = number % 10;
 		    
 		    if(digitCount < 0 ){
 		    	throw new notGoodInputException();
 		    }
 		    
 		    digitArray[digitCount] = digit;
 		   
 		    number = number / 10;
 		    
 		    --digitCount;
 		}
 		
 		if(digitCount !=  -1){
 			throw new notGoodInputException();
 		}
 		
 		return digitArray;		
 	}
}
