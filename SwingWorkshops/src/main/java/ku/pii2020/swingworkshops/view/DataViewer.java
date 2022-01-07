/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ku.pii2020.swingworkshops.view;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import javax.swing.JFrame;
/**
 *
 * @author tugso
 */
public class DataViewer extends JFrame {
    // Attribute Declarations
    private static TextAreaPanel textPanel = new TextAreaPanel();
    
    // Attribute Getter and Setter Methods    
    public static TextAreaPanel getTextPanel() {
        return DataViewer.textPanel;
    }
    
    public static void setTextPanel(TextAreaPanel textPanel) {
        DataViewer.textPanel = textPanel;
    }
    
    // Constructor Methods
    public DataViewer() throws HeadlessException {
        this.setTitle("My Task List");
        this.setBounds(400,0,400,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLayout(new BorderLayout());
        this.add(DataViewer.getTextPanel(), BorderLayout.CENTER);
    }
}
