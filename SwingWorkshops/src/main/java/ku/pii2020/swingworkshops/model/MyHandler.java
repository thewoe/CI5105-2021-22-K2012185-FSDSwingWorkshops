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
            case "Selected Text":
                if (TextAreaPanel.getTextDisplay().getSelectedText() != null) {
                    String selectedText = TextAreaPanel.getTextDisplay().getSelectedText();
                    int i = -1;
                    for (Task task : Challenge.getTasks()) {
                        i++;
                        if (task.getTitle().equals(selectedText)) {
                            System.out.println(i);
                        }
                    }
                }
                else {
                    System.out.println("No Task Found");
                }
                break;
            case "Quit":
                System.exit(0);
            default:
                break;
        }
    }
}
