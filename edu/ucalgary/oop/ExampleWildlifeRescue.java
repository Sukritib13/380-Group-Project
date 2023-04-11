/**
 * This class represents a wildlife rescue organization and manages a list of animals, tasks, and treatments.
 * It also provides methods for adding treatments to the schedule, calculating backup needs, and adding feeding tasks.
 * @author Sukriti Badhwar, Rita Boury, Rimal Rizvi, Huiying Zhen Zhen
 * @version 1.34
 * @since 1.0
 */

 package edu.ucalgary.oop;

 import java.io.FileWriter;
 import java.io.IOException;
 import java.time.LocalDate;
 import java.util.*;
 import java.util.Date;
 import java.util.stream.Collectors;
 
 public class ExampleWildlifeRescue {
     // Private instance variables
     private ArrayList<Animal> animals; // list of animals
     private ArrayList<Task> tasks; // list of tasks
     private ArrayList<Treatment> treatments; // list of treatments
     private ArrayList<Integer> backupsNeededAtHours = new ArrayList<>(); // list of hours that need backups
     private HashMap<Integer, ArrayList<String>> scheduleByTheHour= new HashMap<>();  // schedule for each hour 
     private HashMap<Integer, ArrayList<Task>> tasksByTheHour= new HashMap<>();  // tasks for each hour
     private ArrayList<Integer> durationPerHour = new ArrayList<>(); // duration for each hour
     private HashMap<String, Integer> speciesCount = new HashMap<>();  // count of each species
     private HashMap<String, ArrayList<String>> speciesNames = new HashMap<>();  // list of names for each species
     private ArrayList<Integer> impossibleHours = new ArrayList<>();
 
     /**
      * Constructor for ExampleWildlifeRescue class
      * Initializes all instance variables and calculates species count
      * @param animals list of animals
      * @param tasks list of tasks
      * @param treatments list of treatments
      */
     public ExampleWildlifeRescue(ArrayList<Animal> animals, ArrayList<Task> tasks, ArrayList<Treatment> treatments) {
         this.animals = animals;
         this.tasks = tasks;
         this.treatments = treatments;
         
         // Initialize scheduleByTheHour, tasksByTheHour, and durationPerHour for each hour of the day
         for (int i = 0; i < 24; i++) {
             scheduleByTheHour.put(i, new ArrayList<String>());
             tasksByTheHour.put(i, new ArrayList<Task>());
             durationPerHour.add(i, 0);
         }
 
         // Initialize speciesNames for each species
         String[] speciesArr = {"beaver", "coyote", "fox", "porcupine", "raccoon"};
         for (String species : speciesArr) {
             speciesNames.put(species, new ArrayList<String>());
         }
 
         // Calculate species count and species names
         int beaverCount = 0;
         int raccoonCount = 0;
         int foxCount = 0;
         int coyoteCount = 0;
         int porcupineCount = 0;
 
         for (Animal animal : animals) {
             String species = animal.getSpecies();
             String name = animal.getNickname();
             if (species == "beaver") {
                 beaverCount++;
             } 
             if (species == "coyote") {
                 coyoteCount++;
             }
             if (species == "fox") {
                 foxCount++;
             }
             if (species == "porcupine") {
                 porcupineCount++;
             }
             if (species == "raccoon") {
                 raccoonCount++;
             }
             speciesNames.get(species).add(name);
         }
         speciesCount.put("beaver", beaverCount);
         speciesCount.put("coyote", coyoteCount);
         speciesCount.put("fox", foxCount);
         speciesCount.put("porcupine", porcupineCount);
         speciesCount.put("raccoon", raccoonCount);
     }
 
     /**
      * Method used to add treatments to the schedule. First, it loops through the treatments array list
      * that contains all treatments. For each treatment, it finds the corresponding task and animal, by getting
      * their IDs respectively. Then, it checks whether the task is null. If not, it adds the task description and  
      * animal nickname to the schedule for the hour that the treatment starts.
      */
     public void addTreatments() {
         // Loop through all treatments.
         for (Treatment treatment : treatments) {
             Task correspondingTask = findTaskById(treatment.getTaskId());
             Animal correspondingAnimal = findAnimalById(treatment.getAnimalId());
             if (correspondingTask != null) {
                 String schedLine = "* " + correspondingTask.getDescription() + " (" + correspondingAnimal.getNickname() + ").";
                 if (scheduleByTheHour.containsKey(Integer.parseInt(treatment.getStartHour()))) {
                     if (!scheduleByTheHour.get(Integer.parseInt(treatment.getStartHour())).contains(schedLine)) {
                         scheduleByTheHour.get(Integer.parseInt(treatment.getStartHour())).add(schedLine);
                         tasksByTheHour.get(Integer.parseInt(treatment.getStartHour())).add(correspondingTask);
                     }
                 }
             } 
         }
     }
 
     /**
      * This method is used to calculate whether there's a need for backup at a certain hour of the day. It is 
      * based on the duration of tasks scheduled for that hour. If the total duration of tasks for an hour is
      * between 60 and 120 minutes, then there's a need for backup at that hour.
      */
     public void backupCalculation() {
         for (int i = 0; i < 24; i++) {
             scheduleByTheHour.put(i, new ArrayList<String>());
             tasksByTheHour.put(i, new ArrayList<Task>());
             durationPerHour.add(i, 0);
         }
 
         // add treatments, feeding, and cleaning tasks to the rescue
         addTreatments();
         addFeeding();
         addCleaning();
 
         // Iterate over each hour in the day
         backupsNeededAtHours.clear();
         impossibleHours.clear();
         for (Integer hour : tasksByTheHour.keySet()) {
             int hourDuration = 0;
             // Iterate over each task scheduled for the current hour
             for (Task task : tasksByTheHour.get(hour)) {
                 hourDuration += task.getDuration(); // Add up the duration of each task
             }
             // Check if the total duration of tasks for this hour is between 60 and 120 minutes
             if (hourDuration > 60 && hourDuration <= 120) {
                 if (!backupsNeededAtHours.contains(hour)) {
                     backupsNeededAtHours.add(hour);   // If so, add this hour to the list of hours requiring backup
                 }
             } else if (hourDuration > 120){
                impossibleHours.add(hour);
             }
             durationPerHour.add(hourDuration); // Add the total duration for this hour to the list of durations per hour
     }
 }
 
     /**
      * This method is used to add feeding to the schedule. 
      */
      public void addFeeding() {
        int duration = 0; //initialize duration variable to zero
        Animal exampleSpecies, animalSpecies; //initialize Animal objects


        String[] speciesArr = {"beaver", "coyote", "fox", "porcupine", "raccoon"}; //array of species names
        for (String species : speciesArr) { //loop through species array
            if (speciesCount.get(species) != 0) { //check if there are any animals of that species present
                int count = speciesCount.get(species); //get the number of animals of that species present
                String nickNames = "";  //initialize a string for the nicknames of the animals
                exampleSpecies = animals.stream().collect(Collectors.groupingBy(Animal::getSpecies)).get(species).get(0);  //get an example animal of the species to determine preparation time and feeding duration
                
                ArrayList<Animal> animalBySpecies = new ArrayList<>();
                
                for (int i =0; i < count; i++) { //loop through each animal of the species and add them to the ArrayList
                    animalSpecies = animals.stream().collect(Collectors.groupingBy(Animal::getSpecies)).get(species).get(i);
                    animalBySpecies.add(animalSpecies);
                }
                
                for (Iterator<Animal> iterator = animalBySpecies.iterator(); iterator.hasNext();) {
                   Animal animal = iterator.next();
                   Treatment treatment = treatmentByTaskId();
                   if (animal.getId().equals(treatment.getAnimalId())) {
                       iterator.remove(); // safely remove the animal from the ArrayList
                       count--; // reduce the count of animals for the species accordingly
                   }
               }

                
                duration = exampleSpecies.getPrepTime() + (exampleSpecies.getFeedingDuration() * count); //calculate the total duration of the feeding task
            
                StringBuilder namesStringBuilder = new StringBuilder();
                for (Animal animal : animalBySpecies) {
                   if (namesStringBuilder.length() > 0) {
                       namesStringBuilder.append(", ");
                   } //create a string of the nicknames of the animals for the feeding task
                   namesStringBuilder.append(animal.getNickname());
               }
               String nicknames = namesStringBuilder.toString();
               
               int feedingStartHour = exampleSpecies.getFeedingHours()[0]; //get the start hour of the feeding task
               int hourDuration = 0; //initialize the duration of the hour
               int totalHourDuration = 0; //initialize the total duration of the hour
           
               
               List<Task> tasks = tasksByTheHour.get(feedingStartHour); //get a list of tasks scheduled for the start hour
               if (tasks != null) { //if there are tasks scheduled for the start hour
                   for (Task task : tasks) { //loop through each task and add its duration to the duration of the hour
                       hourDuration += task.getDuration();
                   }
               }
               totalHourDuration = hourDuration + duration; //add the duration of the feeding task to the duration of the hour
               
               //check if the total duration of the hour exceeds the maximum duration for an hour
               //if so, update the start hour accordingly
               if ((totalHourDuration > 60) && (totalHourDuration < 120) ) {
                   feedingStartHour += 1;
               }
               if ((totalHourDuration) > 120 && (totalHourDuration) < 180 ) {
                   feedingStartHour += 2;
               }
               if ((totalHourDuration) > 180) {
                   feedingStartHour = -1;   //if the duration exceeds the maximum, set the start hour to -1 to indicate that the task cannot be scheduled
               }

               if (feedingStartHour != -1) { //checks if the feeding task can be scheduled within the working hours (7am - 7pm)
                   if (!nicknames.equals(null)) {
                       String schedLine = "* Feeding - " + species + " (" + count + ": " + nicknames + ")";
                       scheduleByTheHour.get(feedingStartHour).add(schedLine);
                       durationPerHour.add(feedingStartHour, totalHourDuration);
                   }
               }

            }
       }
       
   }
     
     /** 
      * This method is used to add cleaning to the schedule.
      */
     public void addCleaning() {
         int duration = 0;
         int cleaningStartHour = 0;  // initialize start hour to 0
         Animal exampleSpecies;
         
         String[] speciesArr = {"beaver", "coyote", "fox", "porcupine", "raccoon"};
         for (String species : speciesArr) {
                int count = 0;
             // check if there are any animals of this species to clean
              if (speciesCount.get(species) != 0) {
              // loop through each animal of this species
                  while (count < speciesCount.get(species)) {
                      exampleSpecies = animals.stream().collect(Collectors.groupingBy(Animal::getSpecies)).get(species).get(count);
                      duration = exampleSpecies.getCleaningDuration();
                      // loop through each hour of the day to find a time slot to schedule the cleaning
                      while(cleaningStartHour < 24) {
                          int hourDuration = durationPerHour.get(cleaningStartHour);
                          int totalHourDuration = hourDuration + duration;
                          
                          if (totalHourDuration <= 60) { // if the total duration is less than or equal to 60 minutes
                              String schedLine = "* Cage Cleaning - " + exampleSpecies.getNickname();
                              scheduleByTheHour.get(cleaningStartHour).add(schedLine); // add cleaning task to schedule
                              durationPerHour.set(cleaningStartHour, totalHourDuration); // update total duration for this hour
                              break; // break out of the loop since a suitable time slot has been found
                          } else {
                              cleaningStartHour += 1; // increment hour to check next time slot
                          }
                      }
                      count++; // move on to the next animal of this species
                  }
              }
         }
     }
    
  /**
  * Generates a schedule for the current day by calling methods to add treatments,
  * feeding, and cleaning tasks. Then writes the schedule to a file named "schedule.txt".
  * @throws IOException if there is an error writing to the file
  */
     public void generateSchedule() throws IOException {
         for (int i = 0; i < 24; i++) {
             scheduleByTheHour.put(i, new ArrayList<String>());
             tasksByTheHour.put(i, new ArrayList<Task>());
             durationPerHour.add(i, 0);
         }
 
         // add treatments, feeding, and cleaning tasks to the rescue
         addTreatments();
         addFeeding();
         addCleaning();
 
         // create a FileWriter object to write to the file "schedule.txt"
         FileWriter myWriter = new FileWriter("schedule.txt");
         myWriter.write("");
 
         // write the header for the schedule file
         myWriter.write("Schedule for " + LocalDate.now() + "\n\n");
 
         // loop through the scheduleByTheHour map to write each hour's tasks to the file
         for (int hour : scheduleByTheHour.keySet()) {
             // check if a backup volunteer is needed at this hour and write to the file if so
             if (backupsNeededAtHours.contains(hour)) {
                 myWriter.write(hour + ":00" + "[+ backup volunteer]\n");
                 for (String line : scheduleByTheHour.get(hour)) {
                     myWriter.write(line + "\n");
                 }
                 myWriter.write("\n");
             }
             
             // check if there are tasks at this hour and write them to the file if so
             else if (scheduleByTheHour.get(hour).size() != 0) {
                 myWriter.write(hour + ":00\n");
                 for (String line : scheduleByTheHour.get(hour)) {
                     myWriter.write(line + "\n");
                 }
                 myWriter.write("\n");
             }
         }
         // close the FileWriter object
         myWriter.close();
     }
 
     /**
      * This method finds and returns the animal object in the animals list with the specified ID
      * @param animalId
      * @return animal with the specified ID
      */
     public Animal findAnimalById(String animalId) {
         for (Animal animal : animals) {
             if (animal.getId().equals(animalId)) {
                 return animal;
             }
         }
         return null;
     }
     
     /**
      * This method finds and returns the task object in the tasks list with the specified ID
      * @param taskId
      * @return task with the specified ID
      */
     public Task findTaskById(String taskId) {
         for (Task task : tasks) {
             if (task.getId().equals(taskId)) {
                 return task;
             }
         }
         return null;
     }
 
     /**
      * This method finds and returns the treatment object in the treatments list with the task ID 1
      */
     public Treatment treatmentByTaskId () {
         for (Treatment treatment : treatments) {
             if (treatment.getTaskId().equals("1")) {
                 return treatment;
             }
         }
         return null;
     }
     
     //getters and setters for class data members
     public ArrayList<Integer> getImpossibleHours() {
        return this.impossibleHours;
    }

     public ArrayList<Integer> getBackupsNeededAtHours() {
         return this.backupsNeededAtHours;
     }
 
     public void setBackupsNeededAtHours(ArrayList<Integer> backupsNeededAtHours) {
         this.backupsNeededAtHours = backupsNeededAtHours;
     }
 
     public ArrayList<Animal> getAnimals() {
         return this.animals;
     }
 
     public void setAnimals(ArrayList<Animal> animals) {
         this.animals = animals;
     }
 
     public ArrayList<Task> getTasks() {
         return this.tasks;
     }
 
     public void setTasks(ArrayList<Task> tasks) {
         this.tasks = tasks;
     }
 
     public ArrayList<Treatment> getTreatments() {
         return this.treatments;
     }
 
     public void setTreatments(ArrayList<Treatment> treatments) {
         this.treatments = treatments;
     }
 
     public HashMap<String, Integer> getSpeciesCount() {
         return this.speciesCount;
     }
 
     public void setSpeciesCount(HashMap<String, Integer> speciesCount) {
         this.speciesCount = speciesCount;
     }
 
     public HashMap<Integer, ArrayList<String>> getScheduleByTheHour() {
         return this.scheduleByTheHour;
     }
 
     public void setScheduleByTheHour(HashMap<Integer, ArrayList<String>> scheduleByTheHour) {
         this.scheduleByTheHour = scheduleByTheHour;
     }
 
     public HashMap<Integer, ArrayList<Task>> getTasksByTheHour() {
         return this.tasksByTheHour;
     }
 
     public void setTasksByTheHour(HashMap<Integer, ArrayList<Task>> tasksByTheHour) {
         this.tasksByTheHour = tasksByTheHour;
     }
 
     public ArrayList<Integer> getDurationPerHour() {
         return this.durationPerHour;
     }
 
     public void setDurationPerHour(ArrayList<Integer> durationPerHour) {
         this.durationPerHour = durationPerHour;
     }
 
     public HashMap<String, ArrayList<String>> getSpeciesNames(){
         return this.speciesNames;
     }
 
     public void setSpeciesNames(HashMap<String, ArrayList<String>> speciesNames){
         this.speciesNames = speciesNames;
     
     }
 }
