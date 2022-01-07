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
    public void actionPerformed(ActionEvent ae) {
        Challenge.displayTasks("Tasks.csv");
    }
}
