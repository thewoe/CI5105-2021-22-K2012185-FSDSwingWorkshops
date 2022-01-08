/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ku.pii2020.swingworkshops.model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
                Challenge.getTasks().clear();
                Challenge.displayTasks("Tasks.csv");
                break;
            case "Delete Task":
                if (TextAreaPanel.getTextDisplay().getSelectedText() != null) {
                    String selectedText = TextAreaPanel.getTextDisplay().getSelectedText();
                    int i = -1;
                    boolean found = false;
                        for (Task task : Challenge.getTasks()) {
                            i++;
                            if (task.getTitle().equals(selectedText)) {
                                Challenge.getTasks().remove(i);
                                System.out.println("Task Deleted: " + i);
                                System.out.println("Tasks Remaining: " + Challenge.getTasks().size());
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
