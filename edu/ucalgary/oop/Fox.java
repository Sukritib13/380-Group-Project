/**
 * The Fox class is a subclass of the Animal class, representing a raccoon at the Wildlife Rescue.
 * It contains methods to retrieve information about feeding and cleaning for the fox subclass.
 * @author Sukriti Badhwar, Rita Boury, Rimal Rizvi, Huiying Zhen Zhen
 * @version 1.0
 * @since 1.0
 */

 package edu.ucalgary.oop;
 
 public class Fox extends Animal {
    private final int[] FEEDINGHOURS = {0, 1, 2};
    private final int PREPTIME = 5;
    private final int DURATIONPERANIMAL = 5;
    private final int CLEANINGDURATION = 5;

    /**
     * Constructor for the Fox class. Takes in an id and nickname for the fox and sets the species to "fox".
     * @param id The unique identifier for the fox
     * @param nickname The nickname of the fox
     */
    public Fox(String id, String nickname) {
        super(id, nickname, "fox");
    }
    
    /** 
     * Overrides the default implementation in the Animal class.
     * @return the preparation time required for feeding the fox.
     */
    @Override
    public int getPrepTime() {
        return PREPTIME;
    }
    
    /** 
     * Overrides the default implementation in the Animal class.
     * @return the duration required for feeding each fox.
     */
    @Override
    public int getFeedingDuration() {
        return DURATIONPERANIMAL;
    }
    
    /** 
     * Overrides the default implementation in the Animal class.
     * @return the duration required for cleaning the fox.
     */
    @Override
    public int getCleaningDuration() {
        return CLEANINGDURATION;
    }
 
    /** 
     * Overrides the default implementation in the Animal class.
     * @return the feeding hours for the fox.
     */
    @Override
    public  int[] getFeedingHours() {
        return FEEDINGHOURS;
    }
 }