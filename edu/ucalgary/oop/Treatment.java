/**
The Treatment class represents a medical treatment that is given to an animal.
It has four private fields: id, animalId, taskId, and startHour.
@author Sukriti Badhwar, Rita Boury, Rimal Rizvi, Huiying Zhen Zhen
@version 1.3
@since 1.0
*/

package edu.ucalgary.oop;

public class Treatment {
    private String id;
    private String animalId;
    private String taskId;
    private String startHour;
    
    /**
     * Constructor for Treatment class
     * @param id unique identifier for the treatment
     * @param animalId unique identifier for the animal receiving the treatment
     * @param taskId unique identifier for the task associated with the treatment
     * @param startHour the hour at which the treatment starts
     */
    public Treatment(String id, String animalId, String taskId, String startHour) {
        if(Integer.parseInt(startHour) < 0 || Integer.parseInt(startHour) > 23){
            throw new IllegalArgumentException("Invalid start hour.");
        }
        
        this.id = id;
        this.animalId = animalId;
        this.taskId = taskId;
        this.startHour = startHour;
    }
    
    /**
    * Getter method for the id field
    * @return the unique identifier for the treatment
    */
    public String getId() {
        return id;
    }
    
    
    
    /**
     * Setter method for the id field
     * @param id the unique identifier for the treatment
     */
    public void setId(String id) {
        this.id = id;
    }

    
     /**
     * Getter method for the animalId field
     * @return the unique identifier for the animal receiving the treatment
     */
    public String getAnimalId() {
        return animalId;
    }

    
    
    /**
     * Setter method for the animalId field
     * @param animalId the unique identifier for the animal receiving the treatment
     */
    public void setAnimalId(String animalId) {
        this.animalId = animalId;
    }

    
     /**
     * Getter method for the taskId field
     * @return the unique identifier for the task associated with the treatment
     */
    public String getTaskId() {
        return taskId;
    }
    
    
    
    /**
     * Setter method for the taskId field
     * @param taskId the unique identifier for the task associated with the treatment
     */
    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }
    
    
    /**
     * Getter method for the startHour field
     * @return the hour at which the treatment starts
     */
    public String getStartHour() {
        return startHour;
    }
    

     /**
     * Setter method for the startHour field
     * @param startHour the hour at which the treatment starts
     */
    public void setStartHour(String startHour) {
        this.startHour = startHour;
    }

}
