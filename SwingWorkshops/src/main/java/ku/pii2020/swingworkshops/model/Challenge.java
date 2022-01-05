/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ku.pii2020.swingworkshops.model;

import java.util.List;
import java.util.ArrayList;
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
    private static List<Task> tasks = new ArrayList();
    
    // Attribute Getter and Setter Methods
    public static DataViewer getDataViewer() {
        return dataViewer;
    }

    public static void setDataViewer(DataViewer dataViewer) {
        Challenge.dataViewer = dataViewer;
    }
    
    public static List<Task> getTasks() {
        return tasks;
    }
    
    public static void setTasks(List<Task> tasks) {
        Challenge.tasks = tasks;
    }
    
    // Class Methods
    public static String readFile(String fileInput) {	  		 	  	 	        	     	
        String textOutput="  Task List:" + System.lineSeparator();
        try(BufferedReader bReader = new BufferedReader(new FileReader(fileInput))) {	  		 	  	 	        	     		  		 	  	 	        	     	
            while (bReader.ready()) {	  		 	  	 	        	     	
                String line = bReader.readLine();
                String taskList[] = line.trim().split(",");
                Task addedTask = new Task(taskList[0], Integer.parseInt(taskList[1]),taskList[2]);
                tasks.add(addedTask);
            }
            setTasks(tasks);
        }	  		 	  	 	        	     	
        catch (Exception e) {	  		 	  	 	        	     	
            return "Error - Task Aborted";	 	  	 	        	     	
        }	  		 	  	 	        	     		  
        return textOutput;
  }
    
    public static void displayTasks(String fileInput) {
        Challenge.readFile(fileInput);
        String taskListString = Challenge.getTasks().toString();
        String taskListStringEdited = taskListString.replaceAll(",","");
        taskListStringEdited = taskListStringEdited.substring(1, taskListStringEdited.length() -1);
        Challenge.getDataViewer().addText(taskListStringEdited);
    }
}
