import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Caesar {

	 public static void main(String[] args){
		    
		 String encdec = JOptionPane.showInputDialog("Hello! Welcome to the Caesar cipher encrption. Please enter an option for encrypt (e) or decrypt (d):");
		 
		 String shiftKey = JOptionPane.showInputDialog("Now please enter the desired key length:");
		 String message = JOptionPane.showInputDialog("Finally, enter the text to encode or decode:");
		 
		 //get key, choose 0 if there's some issue
		 int shiftKeyInt = 0;
		 shiftKeyInt = Integer.parseInt(shiftKey);
		 
	        
		 if (encdec.startsWith("d")){//if we're decrypting...
			 shiftKeyInt = 26 - shiftKeyInt; //this will reverse the key
		 }
		 
		 String newtext = cipher (message, shiftKeyInt); //get our result
		 
	     JOptionPane.showMessageDialog(null, "Your result is: " + newtext);
		 
	    }
	
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
