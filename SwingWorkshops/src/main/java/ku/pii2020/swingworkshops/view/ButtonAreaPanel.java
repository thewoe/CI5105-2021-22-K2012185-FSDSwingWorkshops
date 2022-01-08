/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ku.pii2020.swingworkshops.view;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import ku.pii2020.swingworkshops.model.MyHandler;

/**
 *
 * @author tugso
 */
public class ButtonAreaPanel extends JPanel {
    //Attribute Declarations
    private static JButton loadFile = new JButton("Load File");
    private static JButton userSelectedText = new JButton("Delete Task");
    private static JButton quitViewer = new JButton("Quit");
    
    // Attribute Getter and Setter Methods    
    public static JButton getLoadFile() {
        return ButtonAreaPanel.loadFile;
    }
    
    public static void setLoadFile(JButton loadFile) {
        ButtonAreaPanel.loadFile = loadFile;
    }
    
    public static JButton getQuitViewer() {
        return ButtonAreaPanel.quitViewer;
    }
    
    public static void setQuitViewer(JButton quitViewer) {
        ButtonAreaPanel.quitViewer = quitViewer;
    }
    
    public static JButton getUserSelectedText() {
        return ButtonAreaPanel.userSelectedText;
    }
    
    public static void setUserSelectedText(JButton userSelectedText) {
        ButtonAreaPanel.userSelectedText = userSelectedText;
    }
    
    // Constructor Methods
    public ButtonAreaPanel() {
        this.add(ButtonAreaPanel.getLoadFile(), BorderLayout.WEST);
        ButtonAreaPanel.loadFile.addActionListener(new MyHandler());
        this.add(ButtonAreaPanel.getUserSelectedText(), BorderLayout.CENTER);
        ButtonAreaPanel.userSelectedText.addActionListener(new MyHandler());
        this.add(ButtonAreaPanel.getQuitViewer(), BorderLayout.EAST);
        ButtonAreaPanel.quitViewer.addActionListener(new MyHandler());
    }
}
