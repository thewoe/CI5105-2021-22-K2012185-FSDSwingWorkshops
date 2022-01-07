/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ku.pii2020.swingworkshops.model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ku.pii2020.swingworkshops.view.ButtonAreaPanel;
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
                Challenge.displayTasks("Tasks.csv");
                break;
            case "Selected Text":
                if (TextAreaPanel.getTextDisplay().getSelectedText() != null) {
                    System.out.println(TextAreaPanel.getTextDisplay().getSelectedText());
                }
                else {
                    System.out.println("Please Select Some Text");
                }
                break;
            case "Quit":
                System.exit(0);
            default:
                break;
        }
    }
}
