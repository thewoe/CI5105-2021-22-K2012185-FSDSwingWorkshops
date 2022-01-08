/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ku.pii2020.swingworkshops.model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
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
            case "Delete Task":
                if (TextAreaPanel.getTextDisplay().getSelectedText() != null) {
                    String selectedText = TextAreaPanel.getTextDisplay().getSelectedText();
                    int i = -1;
                    boolean found = false;
                        for (Task task : Challenge.getTasks()) {
                            i++;
                            if (task.getTitle().equals(selectedText)) {
                                int optionPane = JOptionPane.showConfirmDialog(Challenge.getDataViewer(), "Are you sure you want to delete the selected task?", "Confirm Task Deletion", JOptionPane.YES_NO_CANCEL_OPTION);
                                switch (optionPane) {
                                    case JOptionPane.YES_OPTION:
                                        Challenge.getTasks().remove(i);
                                        System.out.println("Task Deleted: " + i);
                                        System.out.println("Tasks Remaining: " + Challenge.getTasks().size());
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
                                found = true;
                                break;
                            }
                        }
                        if (found == false) {
                            System.out.println("No Task Deleted");
                            System.out.println("Tasks Remaining: " + Challenge.getTasks().size());
                        }
                }
                else {
                    System.out.println("No Task Deleted");
                    System.out.println("Tasks Remaining: " + Challenge.getTasks().size());
                }
                break;
            case "Quit":
                System.exit(0);
            default:
                break;
        }
    }
}
