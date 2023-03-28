package edu.ucalgary.oop;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class EwrTest {
	int expectedAnimalId = 3;
	String expectedAnimalNickname = "Bitter";
	String expectedAnimalSpecies = "coyote";
	int expectedTreatmentHour = 13;
	int expectedTaskId = 7;
	String expectedDescription = "Give vitamin injection";
	int expectedDuration = 5;
	int expectedMaxWindow = 5;

	public Animal testAnimal = new Animal(expectedAnimalId, expectedAnimalNickname, expectedAnimalSpecies );

	@Test
	public void testAnimalConstructor {
		int expectedAnimalId = 5;
		String expectedAnimalNickname = "Eraser";
		String expectedAnimalSpecies = "coyote";

		Animal testObject = new Animal(expectedAnimalId, expectedAnimalNickname, expectedAnimalSpecies);

		int actualAnimalId = testObject.getAnimalId();
		String actualAnimalNickname = testObject.getAnimalNickname();
		String actualAnimalSpecies = testObject.getAnimalSpecies();

		assertEquals("Constructor or getter gave wrong value for AnimalId", expectedAnimalId, actualAnimalId);
		assertEquals("Constructor or getter gave wrong value for AnimalNickname", expectedAnimalNickname, actualAnimalNickname);
		assertEquals("Constructor or getter gave wrong value for AnimalSpecies", expectedAnimalSpecies, actualAnimalSpecies);
	}


	@Test
	public void testGetAnimalId {
		String actualAnimalId = testAnimal.getAnimalId();
		assertEquals("IncorrectInformation returned for AnimalId", expectedAnimalId, actualAnimalId);
	}

	@Test
	public void testGetAnimalNickname {
		String actualAnimalNickname = testAnimal.getAnimalNickname();
		assertEquals("IncorrectInformation returned for AnimalNickname", expectedAnimalNickname, actualAnimalNickname);
	}

	@Test
	public void testGetAnimalSpecies {
		String actualAnimalSpecies = testAnimal.getAnimalSpecies();
		assertEquals("IncorrectInformation returned for AnimalSpecies", expectedAnimalSpecies, actualAnimalSpecies);
	}

	@Test
	public void setAnimalNicknameTest {
		var testAnimal2 = new Animal(expectedAnimalId, expectedAnimalNickname, expectedAnimalSpecies);
		String newExpectedNickname = "Lola";
		testAnimal2.setAnimalNickname(newExpectedNickName);
		String actualNickName = testAnimal2.getAnimalNickname();
		assertEquals("Error with setting Animal Nickname", newExpectedNickname, actualNickname);
	}

	@Test
	public void setAnimalSpecies {
		var testAnimal2 = new Animal(expectedAnimalId, expectedAnimalNickname, expectedAnimalSpecies);
		String newExpectedSpecies = "Beaver";
		testAnimal2.setAnimalNickname(newExpectedSpecies);
		String actualSpecies = testAnimal2.getAnimalSpecies();
		assertEquals("Error with setting Animal Species", newExpectedSpecies, actualSpecies);
	}

	@Test
	public void testAnimalIdException() {
		 boolean testResult = false;
		int invalidAnimalId = 153;
		try {
		    var testAnimal3 = new Animal(expectedAnimalId, expectedAnimalNickname, expectedAnimalSpecies);     
		}
		catch (IllegalArgumentException e) {
		    testResult = true;
		}
		catch (Exception e) { }
		assertTrue("Invalid Animal Id did not throw an IllegalArgumentException", testResult);
	}

	@Test
	public void testTreatmentInheritedGetters(){
		int actualAnimalId = testAnimal.getAnimalId();
		int actualTaskId = testAnimal.getTaskId();
		int actualDescription = testAnimal.getDescription();
		int actualDuration = testAnimal.getDuration();
		int actualMaxWindow = testAnimal.getMaxWindow();

		assertEquals("Getter returned wrong value for AnimalId", expectedAnimalId, actualAnimalId);
		assertEquals("Getter returned wrong value for TaskId", expectedTaskId, actualTaskId);
		assertEquals("Getter returned wrong value for Description", expectedDescription, actualDescription);
		assertEquals("Getter returned wrong value for Duration", expectedDuration, actualDuration);
		assertEquals("Getter returned wrong value for MaxWindow", expectedMaxWindow, actualMaxWindow);
	}

	@Test
	public void testTreatmentHourGetter(){
		int actualTreatmentHour = testAnimal.getStartHour();
		assertEquals("Getter returned wrong value for StartHour", expectedTreatmentHour, actualTreatmentHour);
	}

	@Test
	public void testInvalidStartHour(){
		boolean testResult = false;
		int invalidStartHour = 26;

		try {
		    var testTreatment = new Treatment(expectedAnimalId, expectedTaskId, expectedDescription, expectedDuration, expectedMaxWindow, invalidStartHour);     
		}
		catch (IllegalArgumentException e) {
		    testResult = true;
		}
		catch (Exception e) { }
		assertTrue("Invalid start hour did not throw an IllegalArgumentException", testResult);
	}
	
	
	// ExampleWildlifeRescue Class Tests

	ArrayList<Animal> testAnimals = new ArrayList <Animal>();
	ArrayList<Tasks> testTasks = new ArrayList <Tasks>();

	public ExampleWildlifeRescue ewr = new ExampleWildlifeRescue(testAnimals, testTasks);

	@Test
	public void testAddAnimal() {
		Animal animal1 = new Animal(expectedAnimalId, expectedAnimalNickname, expectedAnimalSpecies);
		ewr.addAnimal(animal);
		assertEquals("Animal not added to ArrayList properly", 1, ewr.getAnimals().size());
	}

	@Test
	public void testAddingDuplicateAnimals() {
		Animal animal1 = new Animal(expectedAnimalId, expectedAnimalNickname, expectedAnimalSpecies);
		ewr.addAnimal(animal1);
		Animal animal2 = new Animal(expectedAnimalId, expectedAnimalNickname, expectedAnimalSpecies);
		ewr.addAnimal(animal2);
		assertEquals("Cannot add animals with the same ID.", 1, ewr.getAnimals().size());
	}

	@Test
	public void testRemoveAnimal() {
		Animal animal1 = new Animal(expectedAnimalId, expectedAnimalNickname, expectedAnimalSpecies);
		Animal animal2 = new Animal(5, "Eraser", "coyote");
		ewr.addAnimal(animal1);
		ewr.addAnimal(animal2);
		ewr.removeAnimal(animal1);
		assertFalse("removeAnimal did not remove the animal properly", ewr.getAnimals().contains(animal1));
	}

	@Test
	public void testAddTask() {
		Task testTask = new Task(1, 'Kit feeding', 30, 2);
		ewr.addTask(testTask);
		assertEquals(1, ewr.getTasks().size());
	}

	@Test
	public void testRemoveTask() {
		Task testTask = new Task(1, 'Kit feeding', 30, 2);
		ewr.addTask(testTask);
		ewr.removeTask(testTask);
		assertFalse(ewr.getTasks().contains(testTask));
	}

	@Test
	public void testExampleWildlifeRescueConstructorAndGetters() {
		ArrayList<Animal> expectedAnimals = testAnimals;
		ArrayList<Tasks> expectedTasks = testTasks;

		public ExampleWildlifeRescue ewr1 = new ExampleWildlifeRescue(testAnimals, testTasks);

		ArrayList<Animal> actualAnimals = ewr1.getAnimals();
		ArrayList<Tasks> actualTasks = ewr1.getTasks();

		assertEquals("Constructor or getter gave wrong value for animals", expectedAnimals, actualAnimals);
		assertEquals("Constructor or getter gave wrong value for tasks", expectedTasks, actualTasks);
	}

	@Test
	public void testExampleWildlifeRescueIllegalArgumentException() {
		boolean testResult = false;
		try {
		    public ExampleWildlifeRescue ewr = new ExampleWildlifeRescue(testTasks, testAnimals); // switched argument order
		}
		catch (IllegalArgumentException e) {
		    testResult = true;
		}
		catch (Exception e) { }
		assertTrue("ExampleWildlifeRescue constructor did not throw an IllegalArgumentException with invalid argument order.", 
		    testResult);
	}

	@Test
	public void testFormatSchedule() {
		Animal animal1 = new Animal(6, 'Annie, Oliver and Mowgli', 'fox');
		Animal animal2 = new Animal(8, 'Spike', 'porcupine');
		Task task1 = new Task(1, 'Kit feeding', 30, 2, animal1);
		Task task2 = new Task(2, 'Rebandage leg wound', 20, 1, animal2);
		ewr.addAnimal(animal1);
		ewr.addAnimal(animal2);
		ewr.addTask(task1);
		ewr.addTask(task2);

		String expectedSchedule = "Schedule for 2023-02-27\n\n19:00\n* Rebandage leg wound (Slinky)\n* Kit feeding (Annie, Oliver and Mowgli)\n\n21:00\n* Kit feeding (Annie, Oliver and Mowgli)"

		String actualSchedule = ewr.formatSchedule("2023-02-27");

		assertEquals("formatSchedule did not format correctly.", expectedSchedule, actualSchedule); 
	}
	
	@Test
    	public void testFeedingInheritedGetters(){
        int actualAnimalId = testAnimal.getAnimalId();
        int actualTaskId = testAnimal.getTaskId();
        int actualDescription = testAnimal.getDescription();
        int actualDuration = testAnimal.getDuration();
        int actualMaxWindow = testAnimal.getMaxWindow();

        assertEquals("Getter returned wrong value for AnimalId", expectedAnimalId, actualAnimalId);
        assertEquals("Getter returned wrong value for TaskId", expectedTaskId, actualTaskId);
        assertEquals("Getter returned wrong value for Description", expectedDescription, actualDescription);
        assertEquals("Getter returned wrong value for Duration", expectedDuration, actualDuration);
        assertEquals("Getter returned wrong value for MaxWindow", expectedMaxWindow, actualMaxWindow);
    }

    @Test
    public void testFeedingHourGetter(){
        int actualFeedingHour = testAnimal.getFeedingHour();
        assertEquals("Getter returned wrong value for FeedingHour", expectedFeedingHour, actualFeedingHour);
    }

    @Test
    public void testInvalidFeedingHour(){
        boolean testResult = false;
        int invalidFeedingHour = 26;

        try {
            var testFeeding = new Feeding(expectedAnimalId, expectedTaskId, expectedDescription, expectedDuration, expectedMaxWindow, invalidFeedingHour);
        }
        catch (IllegalArgumentException e) {
            testResult = true;
        }
}