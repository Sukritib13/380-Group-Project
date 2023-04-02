/**
 * Class description
 * @author Sukriti Badhwar, Rita Boury, Rimal Rizvi, Huiying Zhen Zhen
 * @version 1.0
 * @since 1.0
 */

package edu.ucalgary.oop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
import java.text.*;
import java.io.*;
import java.util.Date;

public class GUI extends JFrame implements ActionListener {
    private ExampleWildlifeRescue rescue;
    private JButton generateButton;
    private JLabel welcome;
    private JLabel instructions;

    public GUI(ExampleWildlifeRescue rescue) {
        this.rescue = rescue;
        setTitle("Example Wildlife Rescue Scheduler");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container pane = getContentPane();
        pane.setLayout(new FlowLayout());
        welcome = new JLabel("Welcome to the Example Wildlife Rescue Scheduler!");
        instructions = new JLabel("Please click the button below to generate your schedule for the day.");
        pane.add(welcome);
        pane.add(instructions);
        generateButton = new JButton("Generate Schedule");
        generateButton.addActionListener(this);
        pane.add(generateButton);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        try {

            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.YEAR, 2023);
            cal.set(Calendar.MONTH, 3);
            cal.set(Calendar.DAY_OF_MONTH, 1);
            cal.set(Calendar.HOUR_OF_DAY, 8);
            cal.set(Calendar.MINUTE, 0);
            Date date = cal.getTime();

            rescue.generateSchedule(date);
            JOptionPane.showMessageDialog(this, "Schedule generated successfully!");
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Invalid date format. Please use YYYY-MM-DD.");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error writing to file. Please check file permissions.");
        }
    }

    public static void main(String[] args) {
        try {
            Database db = new Database();
            ArrayList<Animal> animals = db.readAnimalsFromDatabase();
            ArrayList<Task> tasks = db.readTasksFromDatabase();
            ArrayList<Treatment> treatments = db.readTreatmentsFromDatabase();
            ExampleWildlifeRescue rescue = new ExampleWildlifeRescue(animals, tasks, treatments);
            GUI gui = new GUI(rescue);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
