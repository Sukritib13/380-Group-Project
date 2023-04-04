/**
 * Class description
 * @author Sukriti Badhwar, Rita Boury, Rimal Rizvi, Huiying Zhen Zhen
 * @version 1.1
 * @since 1.0
 */

package edu.ucalgary.oop;

import java.sql.*;
import java.util.ArrayList;

public class Database {
    private Connection dbConnection;
    private final String URL = "jdbc:mysql://localhost:3306/treatments";
    private final String USERNAME = "oop";
    private final String PASSWORD = "password";
    private ArrayList<Animal> animals = new ArrayList<>();
    private ArrayList<Task> tasks = new ArrayList<>();
    private ArrayList<Treatment> treatments = new ArrayList<>();

    public Database(){
        this.dbConnection = connectToDatabase();
    }

    public Connection connectToDatabase(){
        try{
            dbConnection = DriverManager.getConnection(getURL(), getUsername(), getPassword());     
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return dbConnection;
    }


    public void readAnimalsFromDatabase() {
        try{
            Statement stmt = dbConnection.createStatement();
            String query = "SELECT AnimalID, AnimalNickName, AnimalSpecies FROM animals";
            ResultSet results = stmt.executeQuery(query);
           
            while (results.next()) {
                String id = results.getString("AnimalID");
                String nickname = results.getString("AnimalNickName");
                String species = results.getString("AnimalSpecies");
                
                animals.add(new Animal(id, nickname, species));
            }
            stmt.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void readTasksFromDatabase(){
        try{
            Statement stmt = dbConnection.createStatement();
            String query = "SELECT TaskID, Description, Duration, MaxWindow FROM tasks";
            ResultSet results = stmt.executeQuery(query);

            while (results.next()) {
                String id = results.getString("TaskID");
                String description = results.getString("Description");
                int duration = results.getInt("Duration");
                int maxWindow = results.getInt("MaxWindow");

                tasks.add(new Task(id, description, duration, maxWindow));
            }
            stmt.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void readTreatmentsFromDatabase(){
        try{
            Statement stmt = dbConnection.createStatement();
            String query = "SELECT TreatmentID, AnimalID, TaskID, StartHour FROM treatments";
            ResultSet results = stmt.executeQuery(query);

            while (results.next()) {
                String id = results.getString("TreatmentID");
                String animalID = results.getString("AnimalID");
                String taskID = results.getString("TaskID");
                String startHour = results.getString("StartHour");
                treatments.add(new Treatment(id, animalID, taskID, startHour));
            }
            stmt.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }


    public String getURL(){
        return this.URL;
    }

    public String getUsername(){
        return this.USERNAME;
    }

    public String getPassword(){
        return this.PASSWORD;
    }

    public ArrayList<Animal> getAnimalsArrayL(){
        readAnimalsFromDatabase();
        return this.animals;
    }

    public ArrayList<Task> getTasksArrayL(){
        readTasksFromDatabase();
        return this.tasks;
    }

    public ArrayList<Treatment> getTreatmentsArrayL(){
        readTreatmentsFromDatabase();
        return this.treatments;
    }

}
