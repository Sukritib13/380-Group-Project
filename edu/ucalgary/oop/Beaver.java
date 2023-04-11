/**
 * The Beaver class represents a beaver animal that extends the Animal class.
 * It provides methods for getting the feeding hours, cleaning duration, feeding duration, and preparation time for a beaver.
 * This class provides default values for these attributes that can be overridden
 * @author Sukriti Badhwar, Rita Boury, Rimal Rizvi, Huiying Zhen Zhen
 * @version 1.5
 * @since 1.0
 */

package edu.ucalgary.oop;

public class Beaver extends Animal {
    //The default feeding hours for a beaver 
    private final int[] FEEDINGHOURS = {8, 9, 10};
    //The default preparation time for feeding and cleaning a beaver
    private final int PREPTIME = 0;
    // The default feeding duration for a beaver
    private final int DURATIONPERANIMAL = 5;
    // The default cleaning duration for a beaver
    private final int CLEANINGDURATION = 5;
    
    

    /**
     * Constructs a new Beaver object with the given ID and nickname.
     * Sets the species to "beaver".
     * @param id the unique ID of the beaver
     * @param nickname the nickname of the beaver
     */
 
    public Beaver(String id, String nickname) {
        super(id, nickname, "beaver");
    }
    
     /**
     * Returns the preparation time for feeding and cleaning the beaver.
     * Overrides the default implementation in the Animal class.
     * @return the preparation time for feeding and cleaning the beaver
     */
    @Override
    public int getPrepTime() {
        return PREPTIME;
    }
    

     /**
     * Returns the duration of feeding for the beaver.
     * Overrides the default implementation in the Animal class.
     * @return the duration of feeding for the beaver
     */
  
    @Override
    public int getFeedingDuration() {
        return DURATIONPERANIMAL;
    }
    
    
    /**
    * Returns the duration of cleaning for the beaver.
    * Overrides the default implementation in the Animal class.
    * @return the duration of cleaning for the beaver
    */

    @Override
    public int getCleaningDuration() {
        return CLEANINGDURATION;
    }
    
     /**
     * Returns an array of feeding hours for the beaver.
     * Overrides the default implementation in the Animal class.
     * @return an array of feeding hours for the beaver
     */

    @Override
    public int[] getFeedingHours() {
         return FEEDINGHOURS;
    }
}
