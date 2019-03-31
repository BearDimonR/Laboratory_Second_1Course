package GUI.Deleting;

import GUI.General.AppStyles;

import javax.swing.*;
import java.awt.*;

public class DeletingPanel extends JLabel {
    JLabel headerBackground = new JLabel(new ImageIcon("images/UC.jpg"));
    JLabel uc1 = new JLabel(new ImageIcon("images/selectedCreateBTN.jpg"));

    public DeletingPanel() {
        setLayout(null);
        add(uc1);
        add(headerBackground);
        uc1.setBounds(50,15,914,666);
       // uc.setBounds(50,5,400,400);



    }
}
