/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ku.pii2020.swingworkshops.model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import ku.pii2020.swingworkshops.view.TextAreaPanel;

/**
 *
 * @author tugso
 */
public class MyHandler implements ActionListener {
    //Class Methods
    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (ae.getActionCommand()) {
            case "Load File":
                JFileChooser fileChooser = new JFileChooser();
                FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("CSV Files", "csv");
                fileChooser.setFileFilter(fileFilter);
                int returnValue = fileChooser.showOpenDialog(Challenge.getDataViewer());
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    try {
                        Object[] options = {"Append", "Replace"};
                        int optionPane = JOptionPane.showOptionDialog(Challenge.getDataViewer(), "Append New Tasks to Existing Tasks or Replace Existing Tasks?", "Append or Replace Tasks", JOptionPane.YES_OPTION, JOptionPane.NO_OPTION, null, options, options[0]);
                        if (optionPane == JOptionPane.YES_OPTION) {
                            System.out.println("Append Button Clicked");
                            Challenge.displayTasks(fileChooser.getSelectedFile().getName());
                        }
                        else if (optionPane == JOptionPane.NO_OPTION) {
                            Challenge.getTasks().clear();
                            System.out.println("Replace Button Clicked");
                            Challenge.displayTasks(fileChooser.getSelectedFile().getName());
                        }
                    }
                    catch (Exception e) {
                        TextAreaPanel.getTextDisplay().setText("Error - File Not Found/Unreadable. Please Retry.");
                    }
                }
                break;
            case "Edit Task":
                if (TextAreaPanel.getTextDisplay().getSelectedText() != null) {
                    String selectedText = TextAreaPanel.getTextDisplay().getSelectedText().trim();
                    int selectedNumber = -1;
                    try {
                        selectedNumber = Integer.parseInt(selectedText);
                    }
                    catch (NumberFormatException numExcept) {
                        
                    }
                    int taskToEdit = selectedNumber - 1;
                            if (taskToEdit >= 0) {
                                Object[] addPaneOptions = {"Title", "Priority", "Date", "Cancel"};
                                int addTaskOptionPane = JOptionPane.showOptionDialog(Challenge.getDataViewer(), "Choose task attribute to edit", "Edit Task", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, addPaneOptions, addPaneOptions[0]);
                                switch (addTaskOptionPane) {
                                    case 0:
                                        String updatedTitle = JOptionPane.showInputDialog("New Task Title:");
                                        if (!updatedTitle.equals("")) {
                                            try {
                                                Challenge.getTasks().get(taskToEdit).setTitle(updatedTitle);
                                                System.out.println("Title Updated");
                                                Challenge.updateTasks();
                                            }
                                            catch (Exception e) {
                                                System.out.println("Closed");
                                            }
                                        }
                                        else {
                                            System.out.println("No Change");
                                        }
                                        break;
                                    case 1:
                                        String updatedPriority = JOptionPane.showInputDialog("New Task Priority:");
                                        if (!updatedPriority.equals("")) {
                                            try {
                                                Challenge.getTasks().get(taskToEdit).setPriority(Integer.parseInt(updatedPriority));
                                                System.out.println("Priority Updated");
                                                Challenge.updateTasks();
                                            }
                                            catch (Exception e) {
                                                System.out.println("Closed");
                                            }
                                        }
                                        else {
                                            System.out.println("No Change");
                                        } 
                                        break;
                                    case 2:
                                        String updatedDate = JOptionPane.showInputDialog("New Task Due Date:");
                                            if (!updatedDate.equals("")) {
                                                try {
                                                    Challenge.getTasks().get(taskToEdit).setTargetDate(updatedDate);
                                                    System.out.println("Date Updated");
                                                    Challenge.updateTasks();
                                                }
                                                catch (Exception e) {
                                                    
                                            }
                                        }
                                        else {
                                            System.out.println("No Change");
                                        }
                                        break;
                                    case 3:
                                        System.out.println("Cancel Option");
                                        break;
                                    default:
                                        break;
                                }
                                break;
                            }
                            else if (taskToEdit < 0) {
                                System.out.println("No Task Found");
                        }
                }
                else {
                    System.out.println("No Task Found");
                }
                break;
            case "Add Task":
                JTextField taskTitleInputField = new JTextField();
                JTextField taskPriorityInputField = new JTextField();
                JTextField taskDateInputField = new JTextField();
                Object[] inputFields = {"Task Title:", taskTitleInputField, "Task Priority:", taskPriorityInputField, "Task Date:", taskDateInputField};
                int addTaskOptionPane = JOptionPane.showConfirmDialog(Challenge.getDataViewer(), inputFields, "Add Task", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
                if (addTaskOptionPane == JOptionPane.OK_OPTION) {
                    String userTitleInput = taskTitleInputField.getText().trim();
                    String userPriorityInput = taskPriorityInputField.getText().trim();
                    int userPriorityInputInt;
                    String userDateInput = taskDateInputField.getText().trim();
                    if (userTitleInput.equals("")) {
                        userTitleInput = "Unnamed Task";
                    }
                    if (!userPriorityInput.equals("")) {
                        try {
                            userPriorityInputInt = Integer.parseInt(userPriorityInput);
                        }
                        catch (Exception e) {
                         userPriorityInputInt = 1;
                        }
                    }
                    else {
                        userPriorityInputInt = 1;
                    }
                    if (userDateInput.equals("")) {
                        userDateInput = "1970-01-01";
                    }
                    Challenge.getTasks().add(new Task(userTitleInput, userPriorityInputInt, userDateInput));
                    Challenge.updateTasks();
                }
                break;
            case "Delete Task":
                if (TextAreaPanel.getTextDisplay().getSelectedText() != null) {
                    String selectedText = TextAreaPanel.getTextDisplay().getSelectedText().trim();
                    int selectedNumber = -1;
                    try {
                        selectedNumber = Integer.parseInt(selectedText);
                    }
                    catch (NumberFormatException numExcept) {
                        
                    }
                    int taskToDelete = selectedNumber - 1;
                            if (taskToDelete >= 0) {
                                int optionPane = JOptionPane.showConfirmDialog(Challenge.getDataViewer(), "Are you sure you want to delete the selected task?", "Confirm Task Deletion", JOptionPane.YES_NO_CANCEL_OPTION);
                                switch (optionPane) {
                                    case JOptionPane.YES_OPTION:
                                        Challenge.getTasks().remove(taskToDelete);
                                        System.out.println("Task Deleted: " + taskToDelete);
                                        System.out.println("Tasks Remaining: " + Challenge.getTasks().size());
                                        Challenge.updateTasks();
                                        break;
                                    case JOptionPane.NO_OPTION:
                                        System.out.println("User No Option ");
                                        break;
                                    case JOptionPane.CANCEL_OPTION:
                                        System.out.println("User Cancel Option");
                                        break;
                                    default:
                                        break;
                                }
                                break;
                            }
                            else if (taskToDelete < 0) {
                                System.out.println("No Task Deleted");
                                System.out.println("Tasks Remaining: " + Challenge.getTasks().size());
                        }
                }
                else {
                    System.out.println("No Task Deleted");
                    System.out.println("Tasks Remaining: " + Challenge.getTasks().size());
                }
                break;
            case "Open Table":
                DefaultTableModel tableModel = new DefaultTableModel();
                JTable taskTable = new JTable(tableModel);
                tableModel.addColumn("Task");
                tableModel.addColumn("Priority");
                tableModel.addColumn("Date");
                for (int i = 0; i< Challenge.getTasks().size(); i++) {
                    String taskTitle = Challenge.getTasks().get(i).getTitle();
                    String taskPriority = String.valueOf(Challenge.getTasks().get(i).getPriority());
                    String formattedDate = Challenge.getTasks().get(i).getTargetDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    String taskDate = formattedDate;
                    Object[] data = {taskTitle, taskPriority, taskDate};
                    tableModel.insertRow(taskTable.getRowCount(),data);
                }
                System.out.println("After For Loop");
                JScrollPane taskTableScrollPane = new JScrollPane(taskTable);
                JDialog tableViewer = new JDialog(Challenge.getDataViewer(), "Table View");
                tableViewer.setBounds(400,0,500,500);
                tableViewer.add(taskTableScrollPane);
                tableViewer.setVisible(true);
                break;
            case "Quit":
                System.exit(0);
            default:
                break;
        }
    }
}
