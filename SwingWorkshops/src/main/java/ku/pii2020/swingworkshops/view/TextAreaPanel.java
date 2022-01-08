/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ku.pii2020.swingworkshops.view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author tugso
 */
public class TextAreaPanel extends JPanel {
    // Attribute Declarations
    private static JTextArea textDisplay = new JTextArea(20,41);
    private static JScrollPane scrollPane = new JScrollPane(textDisplay);
    
    // Attribute Getter and Setter Methods    
    public static JTextArea getTextDisplay() {
        return TextAreaPanel.textDisplay;
    }
    
    public static void setTextDisplay(JTextArea textDisplay) {
        TextAreaPanel.textDisplay = textDisplay;
    }
    
    public static JScrollPane getScrollPane() {
        return TextAreaPanel.scrollPane;
    }
    
    public static void setScrollPane(JScrollPane scrollPane) {
        TextAreaPanel.scrollPane = scrollPane;
    }
    
    // Constructor Methods    
    public TextAreaPanel() {
        this.add(TextAreaPanel.getScrollPane());
    }
    
    // Class Methods    
    public static void addText(String text) {
        TextAreaPanel.getTextDisplay().setText(" My Task List:" + System.lineSeparator() + " " + text);
    }
}
