/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ku.pii2020.swingworkshops.model;

import java.io.FileReader;	  		 	  	 	        	     	
import java.io.BufferedReader;
import ku.pii2020.swingworkshops.view.DataViewer;
import javax.swing.*;

/**
 *
 * @author dave
 */
public class Challenge {
    public static DataViewer dataViewer = new DataViewer();
    public static String readFile(String fileInput) {	  		 	  	 	        	     	
        String textOutput="";
        try(BufferedReader bReader = new BufferedReader(new FileReader(fileInput))) {	  		 	  	 	        	     		  		 	  	 	        	     	
            while (bReader.ready()) {	  		 	  	 	        	     	
                String line = bReader.readLine();
                textOutput = textOutput + line + System.lineSeparator();
            }	  		 	  	 	        	     	
        }	  		 	  	 	        	     	
        catch (Exception e) {	  		 	  	 	        	     	
            return "Error - Task Aborted";	 	  	 	        	     	
        }	  		 	  	 	        	     		  
        return textOutput;
  }
    public static void displayFile(String fileInput) {
        dataViewer.addText(Challenge.readFile(fileInput));
    }
}
