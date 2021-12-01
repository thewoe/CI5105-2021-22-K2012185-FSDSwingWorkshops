/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ku.pii2020.swingworkshops.view;

import javax.swing.*;
/**
 *
 * @author tugso
 */
public class DataViewer extends JFrame {
    // Attribute Declarations
    private JTextArea fileDisplay = new JTextArea();
    
    // Attribute Getter and Setter Methods
    public JTextArea getFileDisplay() {
        return fileDisplay;
    }

    public void setFileDisplay(JTextArea fileDisplay) {
        this.fileDisplay = fileDisplay;
    }
    
    // Constructor Methods
    public DataViewer() throws UnsupportedOperationException {
        this.setTitle("Data Viewer");
        this.setBounds(400,0,400,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        add(fileDisplay);
    }
    
    // Class Methods
    public void addText (String text) {
        this.getFileDisplay().append(text);
    }
}
