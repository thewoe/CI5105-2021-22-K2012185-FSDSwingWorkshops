/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ku.pii2020.swingworkshops.model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author tugso
 */
public class MyHandler implements ActionListener {
    //Class Methods
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Load File")) {
            Challenge.displayTasks("Tasks.csv");
        }
        else if (ae.getActionCommand().equals("Quit")) {
            System.exit(0);
        }
    }
}
