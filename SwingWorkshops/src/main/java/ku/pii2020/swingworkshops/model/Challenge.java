/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ku.pii2020.swingworkshops.model;

import java.io.FileReader;	  		 	  	 	        	     	
import java.io.BufferedReader;

/**
 *
 * @author dave
 */
public class Challenge {
      public static String readFile()	  		 	  	 	        	     	
  {	  		 	  	 	        	     	
    String fileToRead="Tasks.csv";
    String output="";
    try {	  		 	  	 	        	     	
      FileReader readTheFile = new FileReader(fileToRead);	  		 	  	 	        	     	
      BufferedReader betterReadTheFile = new BufferedReader(readTheFile);	  		 	  	 	        	     	
      while (betterReadTheFile.ready()) {	  		 	  	 	        	     	
        String line = betterReadTheFile.readLine();
        output = output + line + System.lineSeparator();
      }	  		 	  	 	        	     	
    }	  		 	  	 	        	     	
      catch (Exception e) {	  		 	  	 	        	     	
  		 	  	 	        	     	
      }	  		 	  	 	        	     	
	  		 	  	 	        	     	
        //ioexception //filenotfoundexception	  
        return output;
  }
}
