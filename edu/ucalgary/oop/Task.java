/**
 * Class description
 * @author Sukriti Badhwar, Rita Boury, Rimal Rizvi, Huiying Zhen Zhen
 * @version 1.0
 * @since 1.0
 */

package edu.ucalgary.oop;

abstract class Task {
    protected final int TASKID;
    protected String description;
    protected int duration;
    protected int maxWindow;
    protected Animal animal;

    /** Constructor */

    /**
     * 
     * @param taskId
     * @param description
     * @param duration
     * @param maxWindow
     * @param animal
     * @throws IllegalArgumentException
     */
    public Task(int taskId, String description, int duration, int maxWindow, Animal animal) throws IllegalArgumentException{
        this.TASKID = taskId;
        this.description = description;
        this.duration = duration;
        this.maxWindow = maxWindow;
        this.animal = animal;
    }

    /** Getters */

    /**
     * 
     * @return
     */
    public int getTaskId(){
        return this.TASKID;
    }

    /**
     * 
     * @return
     */
    public String getDescription(){
        return this.description;
    }

    /**
     * 
     * @return
     */
    public int getDuration(){
        return this.duration;
    }

    /**
     * 
     * @return
     */
    public int getMaxWindow(){
        return this.maxWindow; 
    }

    /** Setters */
    /**
     * 
     * @param description
     */
    public void setDescription(String description){
        
    }

    /**
     * 
     * @param duration
     */
    public void setDuration(int duration){

    }

    /**
     * 
     * @param maxWindow
     */
    public void setMaxWindow(int maxWindow){

    }
}
