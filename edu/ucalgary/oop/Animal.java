/**
 * Class description
 * @author Sukriti Badhwar, Rita Boury, Rimal Rizvi, Huiying Zhen Zhen
 * @version 1.0
 * @since 1.0
 */

package edu.ucalgary.oop;

public class Animal {
    private final int ANIMALID;
    private String animalNickname;
    private String animalSpecies;

    /** Constructor */
    /**
     * @param
     * @throws
     */
    public Animal(int AnimalId, String animalNickname, String animalSpecies) throws IllegalArgumentException{
    	this.ANIMALID = AnimalId;
    	this.animalNickname = animalNickname;
    	this.animalSpecies = animalSpecies;
    }

    /** Getters */

    /**
     * getter method that returns the animal ID 
     * @return
     */
    public int getANIMALID(){
    	return ANIMALID;	
    }

    /**
     * getter method that returns the animal nickname
     * @return
     */
    public String getAnimalNickname(){
    	return animalNickname;
    }
    /**
     * getter method that returns the animal species
     * @return
     */
    public String getAnimalSpecies(){
    	return animalSpecies;
    }

    /** Setters */
    
    /**
     * 
     * @param nickname
     */
    public void setAnimalNickname(String nickname){
    	this.animalNickname = nickname;
    }
    /**
     * 
     * @param species
     */
    public void setAnimalSpecies(String species){
    	this.animalSpecies = species;
    }
}
