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
import ku.pii2020.swingworkshops.view.TextAreaPanel;

/**
 *
 * @author dave
 */
public class Challenge {
    // Attribute Declarations
    private static DataViewer dataViewer = new DataViewer();
    private static List<Task> tasks = new ArrayList();
    
    // Attribute Getter and Setter Methods
    public static DataViewer getDataViewer() {
        return Challenge.dataViewer;
    }

    public static void setDataViewer(DataViewer dataViewer) {
        Challenge.dataViewer = dataViewer;
    }
    
    public static List<Task> getTasks() {
        return Challenge.tasks;
    }
    
    public static Task getTask(int taskNumber) {
        return Challenge.tasks.get(taskNumber);
    }
    
    public static void setTasks(List<Task> tasks) {
        Challenge.tasks = tasks;
    }
    
    // Class Methods
    public static void readFile(String fileInput) {	  		 	  	 	        	     	
        try(BufferedReader bReader = new BufferedReader(new FileReader(fileInput))) {
            while (bReader.ready()) {
                String line = bReader.readLine();
                String taskList[] = line.trim().split(",");
                tasks.add(new Task(taskList[0], Integer.parseInt(taskList[1]),taskList[2]));
            }
            setTasks(tasks);
        }	  		 	  	 	        	     	
        catch (Exception e) {
            TextAreaPanel.getTextDisplay().setText("Error - File Not Found/Unreadable. Please Retry.");	 	  	 	        	     	
        }	  		 	  	 	        	     		  
  }
    
    public static void displayTasks(String fileInput) {
        Challenge.readFile(fileInput);
        String taskListString= "";
        for (int i = 0; i < Challenge.getTasks().size(); i++) {
            taskListString = taskListString + String.valueOf(i+1) + Challenge.getTask(i).toString().replaceAll(",","");
        }
        String tasksToDisplay = taskListString.substring(0, taskListString.length() -1);
        Challenge.getDataViewer().getTextPanel().addText(tasksToDisplay);
    }
        public static void updateTasks() {
            String taskListString= "";
        for (int i = 0; i < Challenge.getTasks().size(); i++) {
            taskListString = taskListString + String.valueOf(i+1) + Challenge.getTask(i).toString().replaceAll(",","");
        }
        String tasksToDisplay = taskListString.substring(0, taskListString.length() -1);
        Challenge.getDataViewer().getTextPanel().addText(tasksToDisplay);
    }
}
