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
}
