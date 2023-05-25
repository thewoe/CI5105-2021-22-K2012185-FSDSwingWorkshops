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
public class ButtonPanel extends JPanel {
    //Attribute Declarations
    private static JButton loadFile = new JButton("Load File");
    private static JButton addTask = new JButton("Add Task");
    private static JButton editTask = new JButton("Edit Task");
    private static JButton userSelectedText = new JButton("Delete Task");
    private static JButton quitViewer = new JButton("Quit");
    private static JButton openTable = new JButton("Open Table");
    
    // Attribute Getter and Setter Methods    
    public static JButton getLoadFile() {
        return ButtonPanel.loadFile;
    }
    
    public static void setLoadFile(JButton loadFile) {
        ButtonPanel.loadFile = loadFile;
    }
    
    public static JButton getQuitViewer() {
        return ButtonPanel.quitViewer;
    }
    
    public static void setQuitViewer(JButton quitViewer) {
        ButtonPanel.quitViewer = quitViewer;
    }
    
    public static JButton getUserSelectedText() {
        return ButtonPanel.userSelectedText;
    }
    
    public static void setUserSelectedText(JButton userSelectedText) {
        ButtonPanel.userSelectedText = userSelectedText;
    }
    
    public static JButton getEditTask() {
        return ButtonPanel.editTask;
    }
    
    public static void setEditTask(JButton editTask) {
        ButtonPanel.editTask = editTask;
    }
    
    public static JButton getAddTask() {
        return ButtonPanel.addTask;
    }
    
    public static void setAddTask(JButton addTask) {
        ButtonPanel.addTask = addTask;
    }
    
    public static JButton getOpenTable() {
        return ButtonPanel.openTable;
    }
    
    public static void setopenTable(JButton openTable) {
        ButtonPanel.openTable = openTable;
    }
    
    // Constructor Methods
    public ButtonPanel() {
        this.add(ButtonPanel.getLoadFile(), BorderLayout.WEST);
        ButtonPanel.loadFile.addActionListener(new MyHandler());
        this.add(ButtonPanel.getAddTask(), BorderLayout.CENTER);
        ButtonPanel.addTask.addActionListener(new MyHandler());
        this.add(ButtonPanel.getEditTask(), BorderLayout.CENTER);
        ButtonPanel.editTask.addActionListener(new MyHandler());
        this.add(ButtonPanel.getUserSelectedText(), BorderLayout.CENTER);
        ButtonPanel.userSelectedText.addActionListener(new MyHandler());
        this.add(ButtonPanel.getOpenTable(), BorderLayout.EAST);
        ButtonPanel.openTable.addActionListener(new MyHandler());
        this.add(ButtonPanel.getQuitViewer(), BorderLayout.EAST);
        ButtonPanel.quitViewer.addActionListener(new MyHandler());
    }
}
