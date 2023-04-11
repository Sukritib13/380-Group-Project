/**
 * The Raccoon class is a subclass of the Animal class, representing a raccoon at the Wildlife Rescue.
 * It contains methods to retrieve information about feeding and cleaning for the raccoon subclass.
 * @author Sukriti Badhwar, Rita Boury, Rimal Rizvi, Huiying Zhen Zhen
 * @version 1.0
 * @since 1.0
 */

package edu.ucalgary.oop;

public class Raccoon extends Animal{
    private final int[] FEEDINGHOURS = {0, 1, 2};
    private final int PREPTIME = 0;
    private final int DURATIONPERANIMAL = 5;
    private final int CLEANINGDURATION = 5;

    /**
     * Constructor for the Raccoon class. Takes in an id and nickname for the raccoon and sets the species to "raccoon".
     * @param id The unique identifier for the raccoon
     * @param nickname The nickname of the raccoon
     */
    public Raccoon(String id, String nickname) {
        super(id, nickname, "raccoon");
    }
    
    /** 
     * Overrides the default implementation in the Animal class.
     * @return the preparation time required for feeding the raccoon.
     */
    @Override
    public int getPrepTime() {
        return PREPTIME;
    }

    /** 
     * Overrides the default implementation in the Animal class.
     * @return the duration required for feeding each raccoon.
     */
    @Override
    public int getFeedingDuration() {
        return DURATIONPERANIMAL;
    }

    /** 
     * Overrides the default implementation in the Animal class.
     * @return the duration required for cleaning the raccoon.
     */
    @Override
    public int getCleaningDuration() {
        return CLEANINGDURATION;
    }

    /** 
     * Overrides the default implementation in the Animal class.
     * @return the feeding hours for the raccoon.
     */
    @Override
    public int[] getFeedingHours() {
         return FEEDINGHOURS;
     }
}
