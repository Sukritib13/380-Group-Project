/**
* The Animal class is an abstract class that has the attributes of ID, nickname, and species. 
* It provides methods to get and set these attributes as well as methods for feeding and cleaning.
* @author Sukriti Badhwar, Rita Boury, Rimal Rizvi, Huiying Zhen Zhen
* @version 1.9
* @since 1.0
*/
package edu.ucalgary.oop;

abstract class Animal {
    protected String id;
    protected String nickname;
    protected String species;
    

    /**
     * Constructor for the Animal class. Takes in an id, nickname, and species for the animal.
     * @param id The unique identifier for the animal
     * @param nickname The nickname of the animal
     * @param species The species of the animal
     */
    public Animal(String id, String nickname, String species) {
        this.id = id;
        this.nickname = nickname;
        this.species = species;
    }
    
    /** 
     * Getter for the ID of the animal
     * @return the ID of the animal
     */
    public String getId() {
        return this.id;
    }

    /**
     * Setter for the ID of the animal
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter for the nickname of the animal
     * @return the nickname of the animal
     */
    public String getNickname() {
        return this.nickname;
    }
    
    /**
     * Setter for the nickname of the animal
     * @param nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    
    /**
     * Getter for the species of the animal
     * @return the species of the animal
     */
    public String getSpecies() {
        return this.species;
    }
    
    /**
     * Setter for the species of the animal
     * @param species
     */
    public void setSpecies(String species) {
        this.species = species;
    }

    /**
     * Getter for the feeding hours of the animal
     * @return the feeding hours of the animal
     */
    public int[] getFeedingHours() {
        return null;
    }
    
    /**
     * Getter for the duration of clianing the cage of the animal.
     * @return the duration of cleaning the cage of the animal
     */
    public int getCleaningDuration() {
        return 0;
    }
    
    /**
     * Getter for the duration of feeding the animal.
     * @return the duration of feeding the animal
     */
    public int getFeedingDuration() {
        return 0;
    }
    
    /**
     * Getter for the preparation time required for feeding the animal.
     * @return the preparation time required for feeding the animal
     */
    public int getPrepTime() {
        return 0;
    }

}
