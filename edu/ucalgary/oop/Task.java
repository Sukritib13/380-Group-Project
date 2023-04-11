/**

* This class represents a task that needs to be performed. It contains information about the task's id, description,
* duration and maximum window within which the task can be completed.
* @author Sukriti Badhwar, Rita Boury, Rimal Rizvi, Huiying Zhen Zhen
* @version 1.2
* @since 1.0
*/


package edu.ucalgary.oop;
import java.util.regex.*;

public class Task {
    //Unique ID for task
    private String id;
    
    //Description of tasK
    private String description;
    
    //Duration of task
    private int duration;
    
    //Maximum window within which the task can be completed
    private int maxWindow;




 /**
 * Constructor for Task class
 * @param id Unique ID for task
 * @param description Description of task
 * @param duration Duration of task
 * @param maxWindow Maximum window within which the task can be completed
 */
    public Task(String id, String description, int duration, int maxWindow) throws IllegalArgumentException{
    	String pattern = "\\d+";
    	
    	if (id.matches(pattern)) {
	    	this.id = id;
    	} 
    	else {
    		throw new IllegalArgumentException("Invalid ID.");
    	}
    	
    	this.description = description;
    	this.duration = duration;
    	this.maxWindow = maxWindow;
    }
    
    
/**
* Returns the unique ID for the task
* @return Unique ID for task
*/
    public String getId() {
        return id;
    }


/**
 * Sets the unique ID for the task
 * @param id Unique ID for task
 */
    public void setId(String id) {
        this.id = id;
    }
    
    
    
 /**
 * Returns the description of the task
 * @return Description of task
 */
    public String getDescription() {
        return this.description;
    }



/**
 * Sets the description of the task
 * @param description Description of task
 */
    public void setDescription(String description) {
        this.description = description;
    }


/**
 * Returns the duration of the task
 * @return Duration of task
 */
    public int getDuration() {
        return this.duration;
    }


/**
 * Sets the duration of the task
 * @param duration Duration of task
 */
    public void setDuration(int duration) {
        this.duration = duration;
    }
    
    
 /**
 * Returns the maximum window within which the task can be completed
 * @return Maximum window within which the task can be completed
 */
    public int getMaxWindow() {
        return this.maxWindow;
    }


/**
 * Sets the maximum window within which the task can be completed
 * @param maxWindow Maximum window within which the task can be completed
 */
    public void setMaxWindow(int maxWindow) {
        this.maxWindow = maxWindow;
    }
}