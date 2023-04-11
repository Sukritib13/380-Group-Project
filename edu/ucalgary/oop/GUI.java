package edu.ucalgary.oop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
import java.text.*;
import java.io.*;
import java.util.stream.Collectors;
import java.util.List;
import java.util.ArrayList;

public class GUI extends JFrame implements ActionListener {

    private ExampleWildlifeRescue rescue;
    private Database db;
    private JButton generateButton;
    private JLabel welcome;
    private JLabel instructions;

    public GUI(ExampleWildlifeRescue rescue, Database db) {
        this.rescue = rescue;
        this.db = db;
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
        if (backupCalculationAndConfirmation()) {
            generateSchedule();
        } else if (rescue.getImpossibleHours().size() != 0) {
            handleImpossible();
        }
        else {
            handleScheduleGenerationError();
        }
    }
    
    private boolean backupCalculationAndConfirmation() {
        rescue.backupCalculation();
        if (rescue.getImpossibleHours().size() != 0){
            return false;
        } else if (rescue.getBackupsNeededAtHours().size() != 0) {
            StringBuilder hoursStringBuilder = new StringBuilder();
            for (int hour : rescue.getBackupsNeededAtHours()) {
                if (hoursStringBuilder.length() > 0) {
                    hoursStringBuilder.append(", ");
                }
                hoursStringBuilder.append(hour);
            }
            String hoursString = hoursStringBuilder.toString();
            int choice = JOptionPane.showConfirmDialog(this, "Backup volunteer needed at the following hours: " + hoursString + ".\nIs this okay?", "Confirmation", JOptionPane.YES_NO_OPTION);
            return choice == JOptionPane.YES_OPTION;
        } else {
            return true;
        }
    }
    
    private void generateSchedule() {
        try {
            rescue.generateSchedule();
            JOptionPane.showMessageDialog(this, "Schedule generated successfully!");
        } catch (IOException exp) {
            JOptionPane.showMessageDialog(this, "Error writing to file. Please check file permissions.");
        }
        
    }
    
    private void handleImpossible() {
        try {
            FileWriter myWriter = new FileWriter("schedule.txt");
            myWriter.write("Schedule could not be generated.");
            myWriter.close();
            StringBuilder hoursStringBuilder = new StringBuilder();
            for (int hour : rescue.getImpossibleHours()) {
                if (hoursStringBuilder.length() > 0) {
                    hoursStringBuilder.append(", ");
                }
                hoursStringBuilder.append(hour);
            }
            String hoursString = hoursStringBuilder.toString();
            JOptionPane.showMessageDialog(this, "Schedule could not be generated since too many events were scheduled at the times " + hoursString + " and more than one backup would be necessary to account for them.");
 
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error writing to file. Please check file permissions.");
        }
    }

    private void handleScheduleGenerationError() {
        try {
            FileWriter myWriter = new FileWriter("schedule.txt");
            myWriter.write("Schedule could not be generated.");
            myWriter.close();
            int nextChoice = JOptionPane.showConfirmDialog(this, "Schedule could not be generated. Would you like to alter treatment times?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (nextChoice == JOptionPane.YES_OPTION) {
                handleTreatmentAlteration();
            } else {
                JOptionPane.showMessageDialog(this, "Sorry, schedule generation unsuccessful.");
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error writing to file. Please check file permissions.");
        }
    }
    
    private void handleTreatmentAlteration() {
        String[] hoursArray = rescue.getBackupsNeededAtHours().stream().map(Object::toString).toArray(String[]::new);
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>(hoursArray);
        JComboBox<String> comboBox = new JComboBox<String>(comboBoxModel);
        comboBox.setSelectedIndex(0);
        JLabel messageLabel = new JLabel("Select the hour when backup is not available and click OK.");
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(messageLabel);
        panel.add(comboBox);
        int result = JOptionPane.showOptionDialog(null, panel, "Select the hour:", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, null, null);
    
        while (result == JOptionPane.OK_OPTION) { // check if the user clicked OK
            String selectedHour = (String) comboBox.getSelectedItem(); // get the selected hour
            List<Treatment> treatmentsAtHour = new ArrayList<>(rescue.getTreatments().stream().collect(Collectors.groupingBy(Treatment::getStartHour)).get(selectedHour));
            List<String> treatmentIdStrings = treatmentsAtHour.stream().map(Treatment::getId).collect(Collectors.toList());
            DefaultComboBoxModel<String> comboBoxModel2 = new DefaultComboBoxModel<>(treatmentIdStrings.toArray(new String[0]));
            JComboBox<String> comboBox2 = new JComboBox<String>(comboBoxModel2); // create a JComboBox with the ids array
            comboBox2.setSelectedIndex(0); // set the default selection to the first id in the list

            JLabel messageLabel2 = new JLabel("Select the treatment id of the treatment you would like to alter and click OK.");
            JPanel panel2 = new JPanel(new GridLayout(0, 1));
            panel2.add(messageLabel2);
            panel2.add(comboBox2);
            int result2 = JOptionPane.showOptionDialog(null, panel2, "Select the treatment id:", JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE, null, null, null);

            if (result2 == JOptionPane.OK_OPTION) {
                String treatmentIDString = (String) comboBox2.getSelectedItem();
                String newHour = JOptionPane.showInputDialog(this, "Enter the new start hour for this treatment:");
                while (Integer.parseInt(newHour) < 0 || Integer.parseInt(newHour) > 23) {
                    JOptionPane.showMessageDialog(this, "Invalid input. Start hour must be from 0 to 23. Please try again.");
                    newHour = JOptionPane.showInputDialog(this, "Enter the new start hour for this treatment:");
                }
                try {
                    db.updateTreatmentStartHour(Integer.parseInt(treatmentIDString), Integer.parseInt(newHour));
                    for (Treatment t : rescue.getTreatments()) {
                        if (t.getId().equals(treatmentIDString)) {
                            t.setStartHour(newHour);
                            break;
                        }
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                JOptionPane.showMessageDialog(this, "Start hour updated successfully!");
                rescue.backupCalculation();
                if (rescue.getBackupsNeededAtHours().contains(Integer.parseInt(selectedHour))) {
                    JOptionPane.showMessageDialog(this, "More alteration is needed for the hour: " + selectedHour);
                    continue;
                } else {
                    JOptionPane.showMessageDialog(this, "Hour " + selectedHour + " no longer needs backup!");
                    if (backupCalculationAndConfirmation()) {
                        generateSchedule();
                    } else if (rescue.getImpossibleHours().size() != 0) {
                        handleImpossible();
                    } else {
                        handleScheduleGenerationError();
                    }
                    break;
                }

            }
        }
    }
    public static void main(String[] args) {
        try {
            Database db = new Database();
            ArrayList<Animal> animals = db.getAnimalsArrayL();
            ArrayList<Treatment> treatments = db.getTreatmentsArrayL();
            ArrayList<Task> tasks = db.getTasksArrayL();
            ExampleWildlifeRescue rescue = new ExampleWildlifeRescue(animals, tasks, treatments);
            GUI gui = new GUI(rescue, db);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
