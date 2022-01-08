/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ku.pii2020.swingworkshops.view;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import ku.pii2020.swingworkshops.model.MyHandler;

/**
 *
 * @author tugso
 */
public class DataViewer extends JFrame {
    // Attribute Declarations
    private static TextAreaPanel textPanel = new TextAreaPanel();
    private static ButtonPanel buttonPanel = new ButtonPanel();
    private static JMenuBar menuBar = new JMenuBar();
    private static JMenu fileMenu = new JMenu("File");
    private static JMenu editMenu = new JMenu("Edit");
    private static JMenuItem loadFile = new JMenuItem("Load File");
    private static JMenuItem quitViewer = new JMenuItem("Quit");
    private static JMenuItem deleteTask = new JMenuItem("Delete Task");
    
    // Attribute Getter and Setter Methods    
    public static TextAreaPanel getTextPanel() {
        return DataViewer.textPanel;
    }
    
    public static void setTextPanel(TextAreaPanel textPanel) {
        DataViewer.textPanel = textPanel;
    }
    
    public static ButtonPanel getButtonPanel() {
        return DataViewer.buttonPanel;
    }
    
    public static void setButtonPanel(ButtonPanel buttonPanel) {
        DataViewer.buttonPanel = buttonPanel;
    }

    public static void setMenuBar(JMenuBar menuBar) {
        DataViewer.menuBar = menuBar;
    }

    public static JMenu getFileMenu() {
        return fileMenu;
    }

    public static void setFileMenu(JMenu fileMenu) {
        DataViewer.fileMenu = fileMenu;
    }

    public static JMenu getEditMenu() {
        return editMenu;
    }

    public static void setEditMenu(JMenu editMenu) {
        DataViewer.editMenu = editMenu;
    }

    public static JMenuItem getLoadFile() {
        return loadFile;
    }

    public static void setLoadFile(JMenuItem loadFile) {
        DataViewer.loadFile = loadFile;
    }

    public static JMenuItem getQuitViewer() {
        return quitViewer;
    }

    public static void setQuitViewer(JMenuItem quitViewer) {
        DataViewer.quitViewer = quitViewer;
    }

    public static JMenuItem getDeleteTask() {
        return deleteTask;
    }

    public static void setDeleteTask(JMenuItem deleteTask) {
        DataViewer.deleteTask = deleteTask;
    }
    
    // Constructor Methods
    public DataViewer() throws HeadlessException {
        this.setTitle("My Task List");
        this.setBounds(400,0,400,425);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLayout(new BorderLayout());
        this.add(DataViewer.getTextPanel(), BorderLayout.CENTER);
        this.add(DataViewer.getButtonPanel(), BorderLayout.SOUTH);
        DataViewer.loadFile.setActionCommand("Load File");
        DataViewer.loadFile.addActionListener(new MyHandler());
        DataViewer.quitViewer.setActionCommand("Quit");
        DataViewer.quitViewer.addActionListener(new MyHandler());
        DataViewer.deleteTask.setActionCommand("Delete Task");
        DataViewer.deleteTask.addActionListener(new MyHandler());
        DataViewer.fileMenu.add(loadFile);
        DataViewer.fileMenu.add(quitViewer);
        DataViewer.editMenu.add(deleteTask);
        DataViewer.menuBar.add(fileMenu);
        DataViewer.menuBar.add(editMenu);
        this.add(menuBar, BorderLayout.NORTH);
    }
}
