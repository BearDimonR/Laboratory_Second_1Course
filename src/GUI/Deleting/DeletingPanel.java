package GUI.Deleting;

import GUI.General.AppStyles;

import javax.swing.*;
import java.awt.*;

public class DeletingPanel extends JLabel {
    private static ProductDeletingPanel productDeletingPanel = new ProductDeletingPanel();
    private static GroupDeletingPanel groupDeletingPanel = new GroupDeletingPanel();


    public DeletingPanel() {
        setLayout(null);
        add(productDeletingPanel);
        add(groupDeletingPanel);
        groupDeletingPanel.setBounds(0, 0, 914, 666);
        productDeletingPanel.setBounds(0, 0, 914, 666);
        productDeletingPanel.setVisible(true);
        groupDeletingPanel.setVisible(false);


    }
    public static void showGroupDeleteTab(){
        productDeletingPanel.setVisible(false);
       groupDeletingPanel.setVisible(true);
    }
    public static void showProductDeleteTab(){
        productDeletingPanel.setVisible(true);
        groupDeletingPanel.setVisible(false);
    }
}
