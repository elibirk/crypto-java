import java.util.HashMap;

import javax.swing.JOptionPane;

public class Frequency {


	 public static void main(String[] args){
		 
		 //hash map to store the frequencies within the text
		 HashMap<Character, Integer> cipherFreq = new HashMap<Character, Integer>();
		 
		 //make placements for each letter of the alphabet
		 for(char alphabet = 'a'; alphabet <= 'z';alphabet++) {
			 cipherFreq.put(alphabet, 0);
		 }//end for loop
	 
		 String cipherText = JOptionPane.showInputDialog("Hello! Please enter text to decrypt (no punctuation):");
		 
		 
		 
		 int length = cipherText.length();  //get length of text
		 
		 //get rid of capitals
		 cipherText = cipherText.toLowerCase();
		 
		 int current;
	
		    for(int i = 0; i < length; i++){ //go through text
		    	if (cipherText.charAt(i) != ' '){
		    		Character c = (Character)(cipherText.charAt(i)); //grab char
			        current = cipherFreq.get(c);
			        cipherFreq.put(c, current + 1); //add 1 to the count of the current letter
		    	}//end if
		        
		    }//end for
		    
		    String finalresults = "";
			 
		for(int j = 0; j < 10; j++){ //try 10 times
				
		    char mostFrequent = 'e'; //default to e in case of error
		    int freq;
		    int highestFreq = 0;
		    for(char alphabet = 'a'; alphabet <= 'z';alphabet++) { //get item with highest frequency
				 freq=cipherFreq.get(alphabet);
				 
				 if(freq > highestFreq){
					 mostFrequent=alphabet;
					 highestFreq = freq;
				 }//end if
				 
			 }//for
		    
		
		    cipherFreq.put(mostFrequent, 0); //reset this so we can move to next most frequent
		    
		    //convert to int
		    int temp = (int)mostFrequent;
		    int temp_integer = 96; //lower case ascii beginning of alphabet
		    
		    
		    int key = 0;
		    int printKey = 0;//the number to print
		    
		    if(temp-temp_integer > 5){ //find key by moving things in relation to E
		    	key = 26 - (temp - temp_integer - 5); //negative because we need to go back
		    	printKey = temp - temp_integer - 5;
		    } else if (temp-temp_integer < 5){
		    	key = (temp-temp_integer) - 1; 
		    	System.out.print("   "+ (temp-temp_integer) + "  " + key + " ");
		    	printKey = key%26;
		    }//end else if
		    
		    //use key and text to make plaintext
		    String newtext = cipher(cipherText, key);
		    
		    if (key < 0){//make key positive so it makes more sense on output
		    	key = key * -1;
		    }//end if
		    
		    //add current output to list of possibilities
		    finalresults = finalresults + "\n" + printKey + "      " + newtext;
		    
		    
		 }//end for
			JOptionPane.showMessageDialog(null, "Your result is: \nKey     Text\n" + finalresults);
		    
		    
	 }//end main
	 
	 
	 
	//decrypting function
		public static String cipher(String message, int key){
		    String s = ""; //start with blank result
		    int length = message.length();  //get length of text
		    
		    for(int i = 0; i < length; i++){ //go through text
		    	if (!(message.charAt(i)==' ')){
		    		char c = (char)(message.charAt(i) + key); //shift char
			        if (c > 'z') //if it circles, take it back and then add it to our string
			            s += (char)(message.charAt(i) - (26 - key));
			        else
			            s += (char)(message.charAt(i) + key); //otherwise, add it to the result
			    }//end if	
		    	}//end for
		    return s;
		}
}
