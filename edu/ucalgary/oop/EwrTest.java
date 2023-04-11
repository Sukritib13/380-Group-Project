/**
 * EwrTest.java, this class provides test cases for the EWR application to ensure that it is working as expected.
 * For every test case, there are two tests, one for valid data and one for invalid data.
 * @author Sukriti Badhwar, Rita Boury, Rimal Rizvi, Huiying Zhen Zhen
 * @version 1.4
 * @since 1.0
 */
package edu.ucalgary.oop;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import java.util.*;

public class EwrTest {
    String expectedTaskId = "1";
    String expectedDescription = "Kit feeding";
    int expectedDuration = 30;
    int expectedMaxWindow = 2;
    String expectedStartHour = "22";
    String expectedAnimalId = "1";
    String expectedTreatmentId = "2";
    String expectedId = "1";

    /** The following section is for testing the methods in the Task class. */

    //test the constructor and getters with valid data
    @Test
    public void testTaskConstructorAndGetters(){
        Task task1 = new Task(expectedTaskId, expectedDescription, expectedDuration, expectedMaxWindow);

        String actualId = task1.getId();
        String actualDescription = task1.getDescription();
        int actualDuration = task1.getDuration();
        int actualMaxWindow = task1.getMaxWindow();

        assertTrue(expectedId.equals(actualId));
        assertTrue(expectedDescription.equals(actualDescription));
        assertTrue(expectedDuration == actualDuration);
        assertTrue(expectedMaxWindow == actualMaxWindow);
    }
    
    //test the constructor with invalid data
    @Test
    public void testTaskConstructorInvalid(){
        boolean testResult = false;
        String invalidTaskId = "abc";
        
        //try/catch block to check if the exception is thrown
        try{
            var testTask = new Task(invalidTaskId, expectedDescription, expectedDuration, expectedMaxWindow);
        }
        catch (IllegalArgumentException e){
            testResult = true;
        }
        catch(Exception e){ }
        assertTrue("Invalid ID should throw an IllegalArgumentException", testResult);
    }

    /** The following section is for testing methods in the Treatment class. */

    //test the constructor and getters with valid data
    @Test
    public void testTreatmentConstructorAndGetters(){
        Treatment treatment1 = new Treatment(expectedTreatmentId, expectedAnimalId, expectedTaskId, expectedStartHour);

        String actualTreatmentId = treatment1.getId();
        String actualAnimalId = treatment1.getAnimalId();
        String actualTaskId = treatment1.getTaskId();
        String actualStartHour = treatment1.getStartHour();

        assertTrue(expectedTreatmentId.equals(actualTreatmentId));
        assertTrue(expectedAnimalId.equals(actualAnimalId));
        assertTrue(expectedTaskId.equals(actualTaskId));
        assertTrue(expectedStartHour.equals(actualStartHour));
    }

    //test the constructor with invalid data
    @Test
    public void testTreatmentConstructorInvalid(){
        boolean testResult = false;
        String invalidStartHour = "30";

        //try/catch block to check if the exception is thrown
        try{
            var testTreatment = new Treatment(expectedTreatmentId, expectedAnimalId, expectedTaskId, invalidStartHour);
        }
        catch (IllegalArgumentException e){
            testResult = true;
        }
        catch(Exception e){ }
        assertTrue("Invalid start hour should throw an IllegalArgumentException", testResult);
    }

    /** The following section is for testing constructors and getters for each animal subclass. */

    //test constructor and getters for Beaver subclass with valid data
    @Test 
       @Test 
    public void testBeaverValid(){
        String expectedAnimalId = "2";
        String expectedNickname = "Beaver1";
        String expectedSpecies = "beaver";
        int[] expectedFeedingHours = {8, 9, 10};
        int expectedPrepTime = 0;
        int expectedDurationPerAnimal = 5;
        int expectedCleaningDuration = 5;

        Beaver beaver1 = new Beaver(expectedAnimalId, expectedNickname);

        String actualId = beaver1.getId();
        String actualNickname = beaver1.getNickname();
        String actualSpecies = beaver1.getSpecies();
        int[] actualFeedingHours = beaver1.getFeedingHours();
        int actualPrepTime = beaver1.getPrepTime();
        int actualDurationPerAnimal = beaver1.getFeedingDuration();
        int actualCleaningDuration = beaver1.getCleaningDuration();

        assertTrue(expectedAnimalId.equals(actualId));
        assertTrue(expectedNickname.equals(actualNickname));
        assertTrue(expectedSpecies.equals(actualSpecies));
        assertTrue(Arrays.equals(expectedFeedingHours, actualFeedingHours));
        assertTrue(expectedPrepTime == actualPrepTime);
        assertTrue(expectedDurationPerAnimal == actualDurationPerAnimal);
        assertTrue(expectedCleaningDuration == actualCleaningDuration);
    }

    //test constructor and getters for Coyote subclass with valid data
    @Test
    public void testCoyoteValid(){
        String expectedAnimalId = "1";
        String expectedNickname = "Loner";
        String expectedSpecies = "coyote";
        int[] expectedFeedingHours ={19, 20, 21};
        int expectedPrepTime = 0;
        int expectedDurationPerAnimal = 5;
        int expectedCleaningDuration = 5;

        Coyote coyote1 = new Coyote(expectedAnimalId, expectedNickname);

        String actualId = coyote1.getId();
        String actualNickname = coyote1.getNickname();
        String actualSpecies = coyote1.getSpecies();
        int[] actualFeedingHours = coyote1.getFeedingHours();
        int actualPrepTime = coyote1.getPrepTime();
        int actualDurationPerAnimal = coyote1.getFeedingDuration();
        int actualCleaningDuration = coyote1.getCleaningDuration();

        assertTrue(expectedAnimalId.equals(actualId));
        assertTrue(expectedNickname.equals(actualNickname));
        assertTrue(expectedSpecies.equals(actualSpecies));
        assertTrue(Arrays.equals(expectedFeedingHours, actualFeedingHours));
        assertTrue(expectedPrepTime == actualPrepTime);
        assertTrue(expectedDurationPerAnimal == actualDurationPerAnimal);
        assertTrue(expectedCleaningDuration == actualCleaningDuration);
    }

    //test constructor and getters for Fox subclass with valid data
    @Test
    public void testFoxValid(){
        String expectedAnimalId = "7";
        String expectedNickname = "Slinky";
        String expectedSpecies = "fox";
        int[] expectedFeedingHours = {0, 1, 2};
        int expectedPrepTime = 5;
        int expectedDurationPerAnimal = 5;
        int expectedCleaningDuration = 5;

        Fox fox1 = new Fox(expectedAnimalId, expectedNickname);

        String actualId = fox1.getId();
        String actualNickname = fox1.getNickname();
        String actualSpecies = fox1.getSpecies();
        int[] actualFeedingHours = fox1.getFeedingHours();
        int actualPrepTime = fox1.getPrepTime();
        int actualDurationPerAnimal = fox1.getFeedingDuration();
        int actualCleaningDuration = fox1.getCleaningDuration();

        assertTrue(expectedAnimalId.equals(actualId));
        assertTrue(expectedNickname.equals(actualNickname));
        assertTrue(expectedSpecies.equals(actualSpecies));
        assertTrue(Arrays.equals(expectedFeedingHours, actualFeedingHours));
        assertTrue(expectedPrepTime == actualPrepTime);
        assertTrue(expectedDurationPerAnimal == actualDurationPerAnimal);
        assertTrue(expectedCleaningDuration == actualCleaningDuration);
    }

    //test constructor and getters for Porcupine subclass with valid data
    @Test
    public void testPorcupineValid(){
        String expectedAnimalId = "8";
        String expectedNickname = "Spike";
        String expectedSpecies = "porcupine";
        int[] expectedFeedingHours = {19, 20, 21};
        int expectedPrepTime = 0;
        int expectedDurationPerAnimal = 5;
        int expectedCleaningDuration = 10;

        Porcupine porcupine1 = new Porcupine(expectedAnimalId, expectedNickname);

        String actualId = porcupine1.getId();
        String actualNickname = porcupine1.getNickname();
        String actualSpecies = porcupine1.getSpecies();
        int[] actualFeedingHours = porcupine1.getFeedingHours();
        int actualPrepTime = porcupine1.getPrepTime();
        int actualDurationPerAnimal = porcupine1.getFeedingDuration();
        int actualCleaningDuration = porcupine1.getCleaningDuration();

        assertTrue(expectedAnimalId.equals(actualId));
        assertTrue(expectedNickname.equals(actualNickname));
        assertTrue(expectedSpecies.equals(actualSpecies));
        assertTrue(Arrays.equals(expectedFeedingHours, actualFeedingHours));
        assertTrue(expectedPrepTime == actualPrepTime);
        assertTrue(expectedDurationPerAnimal == actualDurationPerAnimal);
        assertTrue(expectedCleaningDuration == actualCleaningDuration);
    }

    //test constructor and getters for Raccoon subclass with valid data
    @Test
    public void testRaccoonValid(){
        String expectedAnimalId = "9";
        String expectedNickname = "Ricky";
        String expectedSpecies = "raccoon";
        int[] expectedFeedingHours = {0, 1, 2};
        int expectedPrepTime = 0;
        int expectedDurationPerAnimal = 5;
        int expectedCleaningDuration = 5;

        Raccoon raccoon1 = new Raccoon(expectedAnimalId, expectedNickname);

        String actualId = raccoon1.getId();
        String actualNickname = raccoon1.getNickname();
        String actualSpecies = raccoon1.getSpecies();
        int[] actualFeedingHours = raccoon1.getFeedingHours();
        int actualPrepTime = raccoon1.getPrepTime();
        int actualDurationPerAnimal = raccoon1.getFeedingDuration();
        int actualCleaningDuration = raccoon1.getCleaningDuration();

        assertTrue(expectedAnimalId.equals(actualId));
        assertTrue(expectedNickname.equals(actualNickname));
        assertTrue(expectedSpecies.equals(actualSpecies));
        assertTrue(Arrays.equals(expectedFeedingHours, actualFeedingHours));
        assertTrue(expectedPrepTime == actualPrepTime);
        assertTrue(expectedDurationPerAnimal == actualDurationPerAnimal);
        assertTrue(expectedCleaningDuration == actualCleaningDuration);
    }

    /** The following section is for testing methods in the Example Wildlife Rescue class. */

    //test the constructor and getters with valid data
    @Test
    public void testExampleWildlifeRescueConstructorAndGetters(){
    	ArrayList<Animal> expectedAnimals = new ArrayList<Animal>();
    	ArrayList<Task> expectedTasks = new ArrayList<Task>();
    	ArrayList<Treatment> expectedTreatments = new ArrayList<Treatment>();
    	
    	//Add animals
    	expectedAnimals.add(new Fox("7", "Slinky"));
    	expectedAnimals.add(new Coyote("1", "Loner"));
    	expectedAnimals.add(new Porcupine("8", "Spike"));
    	
    	//Add tasks
    	expectedTasks.add(new Task("5", "Flush neck wound", 25, 1));
    	expectedTasks.add(new Task("6", "Give fluid injection", 10, 1));
    	
    	//Add treatments
    	expectedTreatments.add(new Treatment("1", "1", "5", "12"));
    	expectedTreatments.add(new Treatment("3", "8", "6", "2"));
    	
    	//create an instance of the ExampleWildlifeRescue class
    	ExampleWildlifeRescue exampleRescue = new ExampleWildlifeRescue(expectedAnimals, expectedTasks, expectedTreatments);
    	
		ArrayList<Animal> actualAnimals = exampleRescue.getAnimals();
        ArrayList<Task> actualTasks = exampleRescue.getTasks();
        ArrayList<Treatment> actualTreatments = exampleRescue.getTreatments();

        assertTrue(expectedAnimals.equals(actualAnimals));
        assertTrue(expectedTasks.equals(actualTasks));
        assertTrue(expectedTreatments.equals(actualTreatments));
    }

    //test backup calculation method
    @Test
    public void testBackupCalculation() {
        ArrayList<Animal> expectedAnimals = new ArrayList<Animal>();
        ArrayList<Task> expectedTasks = new ArrayList<Task>();
        ArrayList<Treatment> expectedTreatments = new ArrayList<Treatment>();
        
        //Add animals
        expectedAnimals.add(new Fox("6", "Slinky"));
        expectedAnimals.add(new Coyote("1", "Loner"));
        expectedAnimals.add(new Porcupine("8", "Spike"));
        
        //Add tasks
        expectedTasks.add(new Task("1", "Kit feeding", 30, 2));
        expectedTasks.add(new Task("5", "Flush neck wound", 65, 1));
        expectedTasks.add(new Task("6", "Give fluid injection", 10, 1));
        
        //Add treatments
        expectedTreatments.add(new Treatment("2", "6", "2", "12"));
        expectedTreatments.add(new Treatment("1", "1", "5", "12"));
        expectedTreatments.add(new Treatment("3", "8", "1", "2"));
        
        //create an instance of the ExampleWildlifeRescue class
        ExampleWildlifeRescue exampleRescue = new ExampleWildlifeRescue(expectedAnimals, expectedTasks, expectedTreatments);

        //Create tasks
        ArrayList<Task> tasks = new ArrayList<>();
        tasks.add(new Task("6", "Give fluid injection", 10, 1));
        tasks.add(new Task("5", "Flush neck wound", 25, 1));

        //Create tasks by hour map
        HashMap<Integer, ArrayList<Task>> tasksByTheHour = new HashMap<>();
        tasksByTheHour.put(8, new ArrayList<>(tasks));
        tasksByTheHour.put(9, new ArrayList<>(expectedTasks));

        exampleRescue.setTasksByTheHour(tasksByTheHour);

        exampleRescue.backupCalculation();

        ArrayList<Integer> backupsNeededAtHours = exampleRescue.getBackupsNeededAtHours();
        assertEquals(1, backupsNeededAtHours.size());
        assertEquals((Integer) 12, backupsNeededAtHours.get(0));

        ArrayList<Integer> durationPerHour = exampleRescue.getDurationPerHour();
        assertEquals(0, durationPerHour.get(8).intValue());
        assertEquals(0, durationPerHour.get(9).intValue());
    }

    //test backup calculation method with no tasks
    @Test
    public void testBackupCalculationNoTasks() {
    	ArrayList<Animal> expectedAnimals = new ArrayList<Animal>();
    	ArrayList<Task> expectedTasks = new ArrayList<Task>();
    	ArrayList<Treatment> expectedTreatments = new ArrayList<Treatment>();
    	
    	//Add animals
    	expectedAnimals.add(new Fox("7", "Slinky"));
    	expectedAnimals.add(new Coyote("1", "Loner"));
    	expectedAnimals.add(new Porcupine("8", "Spike"));
    	
    	//Add tasks
        expectedTasks.add(new Task("1", "Kit feeding", 30, 2));
    	expectedTasks.add(new Task("5", "Flush neck wound", 25, 1));
    	expectedTasks.add(new Task("6", "Give fluid injection", 10, 1));
    	
    	//Add treatments
    	expectedTreatments.add(new Treatment("1", "1", "5", "12"));
    	expectedTreatments.add(new Treatment("3", "8", "6", "2"));
        expectedTreatments.add(new Treatment("3", "8", "1", "2"));
    	
    	//create an instance of the ExampleWildlifeRescue class
    	ExampleWildlifeRescue exampleRescue = new ExampleWildlifeRescue(expectedAnimals, expectedTasks, expectedTreatments);
        exampleRescue.backupCalculation();

        ArrayList<Integer> backupsNeededAtHours = exampleRescue.getBackupsNeededAtHours();
        assertEquals(0, backupsNeededAtHours.size());

        ArrayList<Integer> durationPerHour = exampleRescue.getDurationPerHour();
        assertEquals(0, durationPerHour.get(8).intValue());
        assertEquals(0, durationPerHour.get(9).intValue());
    }

    //test addTreatments method
    @Test
    public void testAddTreatments(){
        ArrayList<Animal> expectedAnimals = new ArrayList<Animal>();
        ArrayList<Task> expectedTasks = new ArrayList<Task>();
        ArrayList<Treatment> expectedTreatments = new ArrayList<Treatment>();
        
        //Add animals
        expectedAnimals.add(new Fox("7", "Slinky"));
        expectedAnimals.add(new Coyote("1", "Loner"));
        expectedAnimals.add(new Porcupine("8", "Spike"));
        
        //Add tasks
        expectedTasks.add(new Task("5", "Flush neck wound", 25, 1));
        expectedTasks.add(new Task("6", "Give fluid injection", 10, 1));
        
        //Add treatments
        expectedTreatments.add(new Treatment("1", "1", "5", "12"));
        //expectedTreatments.add(new Treatment("3", "8", "6", "2"));
        
        //create an instance of the ExampleWildlifeRescue class
        ExampleWildlifeRescue exampleRescue = new ExampleWildlifeRescue(expectedAnimals, expectedTasks, expectedTreatments);
        exampleRescue.addTreatments();

        String expectedSchedLine = "* Flush neck wound (Loner).";
        assertEquals(exampleRescue.getScheduleByTheHour().get(12).get(0), expectedSchedLine);
        ArrayList<Treatment> actualTreatments = exampleRescue.getTreatments();
        assertEquals(expectedTreatments, actualTreatments);
    }

    //test addFeeding method
    @Test
    public void testAddFeeding(){
        ArrayList<Animal> expectedAnimals = new ArrayList<Animal>();
        ArrayList<Task> expectedTasks = new ArrayList<Task>();
        ArrayList<Treatment> expectedTreatments = new ArrayList<Treatment>();
        
        //Add animals
        expectedAnimals.add(new Fox("6", "Slinky"));
        expectedAnimals.add(new Coyote("1", "Loner"));
        expectedAnimals.add(new Porcupine("8", "Spike"));
        
        //Add tasks
        expectedTasks.add(new Task("1", "Kit feeding", 30, 2));
        expectedTasks.add(new Task("5", "Flush neck wound", 25, 1));
        expectedTasks.add(new Task("6", "Give fluid injection", 10, 1));
        
        //Add treatments
        expectedTreatments.add(new Treatment("2", "6", "2", "0"));
        expectedTreatments.add(new Treatment("1", "1", "5", "12"));
        expectedTreatments.add(new Treatment("3", "8", "1", "2"));
        
        //create an instance of the ExampleWildlifeRescue class
        ExampleWildlifeRescue exampleRescue = new ExampleWildlifeRescue(expectedAnimals, expectedTasks, expectedTreatments);
        exampleRescue.addFeeding();

        String expectedSchedLine = "* Feeding - fox (1: Slinky)";
        assertEquals(expectedSchedLine, exampleRescue.getScheduleByTheHour().get(0).get(0));
    }
}
