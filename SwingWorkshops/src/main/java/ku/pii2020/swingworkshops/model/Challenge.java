/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ku.pii2020.swingworkshops.model;

import java.io.FileReader;	  		 	  	 	        	     	
import java.io.BufferedReader;
import ku.pii2020.swingworkshops.view.DataViewer;

/**
 *
 * @author dave
 */
public class Challenge {
    // Attribute declarations
    private static DataViewer dataViewer = new DataViewer();
    
    // Attribute Getter and Setter Methods
    public static DataViewer getDataViewer() {
        return dataViewer;
    }

    public static void setDataViewer(DataViewer dataViewer) {
        Challenge.dataViewer = dataViewer;
    }
    
    // Class Methods
    public static String readFile(String fileInput) {	  		 	  	 	        	     	
        String textOutput="  Task List:" + System.lineSeparator();
        try(BufferedReader bReader = new BufferedReader(new FileReader(fileInput))) {	  		 	  	 	        	     		  		 	  	 	        	     	
            while (bReader.ready()) {	  		 	  	 	        	     	
                String line = bReader.readLine();
                String taskList[] = line.trim().split(",");
                textOutput = textOutput + '\u2022' + " " + taskList[0] + ". Priority: " + taskList[1] + ". Due Date: " + taskList[2] + "." + System.lineSeparator();
            }	  		 	  	 	        	     	
        }	  		 	  	 	        	     	
        catch (Exception e) {	  		 	  	 	        	     	
            return "Error - Task Aborted";	 	  	 	        	     	
        }	  		 	  	 	        	     		  
        return textOutput;
  }
    public static void displayFile(String fileInput) {
        Challenge.getDataViewer().addText(Challenge.readFile(fileInput));
    }
}
