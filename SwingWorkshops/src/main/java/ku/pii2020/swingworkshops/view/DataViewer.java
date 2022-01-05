/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ku.pii2020.swingworkshops.view;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import javax.swing.*;
/**
 *
 * @author tugso
 */
public class DataViewer extends JFrame {
    // Attribute Declarations
    private JTextArea fileDisplay = new JTextArea();
    private JScrollPane scrollPane = new JScrollPane(this.getFileDisplay());
    
    // Attribute Getter and Setter Methods
    public JTextArea getFileDisplay() {
        return fileDisplay;
    }

    public void setFileDisplay(JTextArea fileDisplay) {
        this.fileDisplay = fileDisplay;
    }
    
    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }
    
    // Constructor Methods
    public DataViewer() throws HeadlessException {
        this.setTitle("My Task List");
        this.setBounds(400,0,400,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLayout(new BorderLayout());
        add(this.getScrollPane(), BorderLayout.CENTER);
    }
    
    // Class Methods
    public void addText (String text) {
        this.getFileDisplay().append(" My Task List:" + System.lineSeparator() + " ");
        this.getFileDisplay().append(text);
    }
}
