/**
* The Coyote class is a subclass of the Animal class, representing a coyote at the Wildlife Rescue.
* It contains methods to retrieve information about feeding and cleaning the coyote.
* @author Sukriti Badhwar, Rita Boury, Rimal Rizvi, Huiying Zhen Zhen
* @version 1.2
* @since 1.0
*/

package edu.ucalgary.oop;

public class Coyote extends Animal {
    //The default feeding hours for a coyote
    private final int[] FEEDINGHOURS = {19, 20, 21};
    //The default preparation time for feeding and cleaning a coyote
    private final int PREPTIME = 0;
    // The default feeding duration for a coyote
    private final int DURATIONPERANIMAL = 5;
    // The default cleaning duration for a coyote
    private final int CLEANINGDURATION = 5;


     /**
     * Constructor for the Coyote class. Takes in an id and nickname for the coyote and sets the species to "coyote".
     * Sets the species to "coyote"
     * @param id The unique identifier for the coyote
     * @param nickname The nickname of the coyote
     */
    public Coyote(String id, String nickname) {
        super(id, nickname, "coyote");
    }

      /**
     * Returns the preparation time required for feeding the coyote enclosure. 
     * Overrides the default implementation in the Animal class.
     * @return The preparation time required (in minutes)
     */
    @Override
    public int getPrepTime() {
        return PREPTIME;
    }
    
     /**
     * Returns the duration required for feeding each coyote in the enclosure. 
     * Overrides the default implementation in the Animal class.
     * @return The duration required (in minutes)
     */
    @Override
    public int getFeedingDuration() {
        return DURATIONPERANIMAL;
    }

     /**
     * Returns the duration required for cleaning the coyote enclosure. 
     * Overrides the default implementation in the Animal class
     * @return The duration required (in minutes)
     */
    @Override
    public int getCleaningDuration() {
        return CLEANINGDURATION;
    }
    
     /**
     * Returns an array of feeding hours for the coyote enclosure.
     * Overrides the default implementation in the Animal class.
     * @return An array of feeding hours (in 24-hour format)
     */
    @Override
    public int[] getFeedingHours() {
         return FEEDINGHOURS;
    }
}
