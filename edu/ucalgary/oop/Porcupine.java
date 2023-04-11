/**
* This class represents a Porcupine and extends the Animal class. It defines the feeding hours, preparation time,
* feeding duration and cleaning duration for a Porcupine.
* @author Sukriti Badhwar, Rita Boury, Rimal Rizvi, Huiying Zhen Zhen
* @version 1.35
* @since 1.0
*/

 package edu.ucalgary.oop;

 import java.util.*;
 
 public class Porcupine extends Animal {
    //Array of feeding hours for Porcupine
    private final int[] FEEDINGHOURS = {19, 20, 21};
    // Preparation time for Porcupine
    private final int PREPTIME = 0;
    //Feeding duration for Porcupine
    private final int DURATIONPERANIMAL = 5;
    //Cleaning duration for Porcupine
    private final int CLEANINGDURATION = 10;
 
  
  
  
    /**
    * Constructor for Porcupine class
    * @param id Unique ID for Porcupine
    * @param nickname Nickname for Porcupine
    */
    public Porcupine(String id, String nickname) {
        super(id, nickname, "porcupine");
    }
  
  
  
    /**
    * Returns the preparation time for Porcupine
    * @return Preparation time for Porcupine
    */
    @Override   
    public int getPrepTime() {
        return PREPTIME;
    }
  
  
   /**
   * Returns the feeding duration for Porcupine
   * @return Feeding duration for Porcupine
   */
    @Override
    public int getFeedingDuration() {
        return DURATIONPERANIMAL;
    }
  
  
  
    /**
    * Returns the cleaning duration for Porcupine
    * @return Cleaning duration for Porcupine
    */  
    @Override
    public int getCleaningDuration() {
        return CLEANINGDURATION;
    }

     
  
    /**
    * Returns the array of feeding hours for Porcupine
    * @return Array of feeding hours for Porcupine
    */
    @Override
    public int[] getFeedingHours() {
        return FEEDINGHOURS;
    }
 }
