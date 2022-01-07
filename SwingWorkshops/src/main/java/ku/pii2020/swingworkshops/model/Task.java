/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ku.pii2020.swingworkshops.model;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 *
 * @author dave
 */
public class Task {
    private String title;	  		 	  	 	        	     	
    private int priority;	  		 	  	 	        	     	
    private LocalDate targetDate;	  		 	  	 	        	     	
	  		 	  	 	        	     	
	  		 	  	 	        	     	
/**	  		 	  	 	        	     	
* Default Constructor	  		 	  	 	        	     	
*/	  		 	  	 	        	     	
	  		 	  	 	        	     	
public Task(){	  		 	  	 	        	     	
	  		 	  	 	        	     	
}	  		 	  	 	        	     	
  public Task(String title, int priority, String targetDate) {	  		 	  	 	        	     	
    this.setTitle(title);	  		 	  	 	        	     	
    this.setPriority(priority);	  		 	  	 	        	     	
    this.setTargetDate(targetDate);	  		 	  	 	        	     	
  }	  		 	  	 	        	     	
	  		 	  	 	        	     	
    /**	  		 	  	 	        	     	
     * Get the value of targetDate	  		 	  	 	        	     	
     *	  		 	  	 	        	     	
     * @return the value of targetDate	  		 	  	 	        	     	
     */	  		 	  	 	        	     	
    public LocalDate getTargetDate() {	  		 	  	 	        	     	
        return targetDate;	  		 	  	 	        	     	
    }	  		 	  	 	        	     	
	  		 	  	 	        	     	
    /**	  		 	  	 	        	     	
     * Set the value of targetDate	  		 	  	 	        	     	
     *	  		 	  	 	        	     	
     * @param targetDate new value of targetDate	  		 	  	 	        	     	
     */	  		 	  	 	        	     	
    public void setTargetDate(LocalDate targetDate) {	  		 	  	 	        	     	
        this.targetDate = targetDate;	  		 	  	 	        	     	
    }	  		 	  	 	        	     	
	  		 	  	 	        	     	
    /**	  		 	  	 	        	     	
     * Set the value of targetDate using a String	  		 	  	 	        	     	
     *	  		 	  	 	        	     	
     * @param targetDate new value of targetDate	  		 	  	 	        	     	
     */	  		 	  	 	        	     	
    public void setTargetDate(String dateStr) throws DateTimeParseException {	  		 	  	 	        	     	
        this.targetDate = LocalDate.parse(dateStr);	  		 	  	 	        	     	
    }	  		 	  	 	        	     	
	  		 	  	 	        	     	
    /**	  		 	  	 	        	     	
     * Get the value of priority	  		 	  	 	        	     	
     *	  		 	  	 	        	     	
     * @return the value of priority	  		 	  	 	        	     	
     */	  		 	  	 	        	     	
    public int getPriority() {	  		 	  	 	        	     	
        return priority;	  		 	  	 	        	     	
    }	  		 	  	 	        	     	
	  		 	  	 	        	     	
    /**	  		 	  	 	        	     	
     * Set the value of priority	  		 	  	 	        	     	
     *	  		 	  	 	        	     	
     * @param priority new value of priority	  		 	  	 	        	     	
     */	  		 	  	 	        	     	
    public void setPriority(int priority) {	  		 	  	 	        	     	
        this.priority = priority;	  		 	  	 	        	     	
    }	  		 	  	 	        	     	
	  		 	  	 	        	     	
    /**	  		 	  	 	        	     	
     * Get the value of title	  		 	  	 	        	     	
     *	  		 	  	 	        	     	
     * @return the value of title	  		 	  	 	        	     	
     */	  		 	  	 	        	     	
    public String getTitle() {	  		 	  	 	        	     	
        return title;	  		 	  	 	        	     	
    }	  		 	  	 	        	     	
	  		 	  	 	        	     	
    /**	  		 	  	 	        	     	
     * Set the value of title	  		 	  	 	        	     	
     *	  		 	  	 	        	     	
     * @param title new value of title	  		 	  	 	        	     	
     */	  		 	  	 	        	     	
    public void setTitle(String title) {	  		 	  	 	        	     	
        this.title = title;	  		 	  	 	        	     	
    }	  		 	  	 	        	     	
	  		 	  	 	        	     	
 /**	  		 	  	 	        	     	
     * Get a String representation of a Task	  		 	  	 	        	     	
     *	  		 	  	 	        	     	
     *	  		 	  	 	        	     	
     */	  		 	  	 	        	     	
    @Override	  		 	  	 	        	     	
    public String toString() {	  		 	  	 	        	     	
        return '\u2022' + " " + title + ". Priority: "+ priority + ". Due Date: " + targetDate.toString() + ". " + System.lineSeparator();	  		 	  	 	        	     	
    }
}
