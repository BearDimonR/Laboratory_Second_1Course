package GUI.Deleting;

import BackGround.Stock;
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
       groupDeletingPanel.getTablePanel().addDataToGroupOFGoodsTable(Stock.getGroups(),2);
    }
    public static void showProductDeleteTab(){
        productDeletingPanel.setVisible(true);
        groupDeletingPanel.setVisible(false);
        productDeletingPanel.getTablePanel().addDataToGoodsTable(Stock.getAllProducts(),1);
    }

    public static void updateTable(){
        if(productDeletingPanel.isVisible()) showProductDeleteTab();
        else showGroupDeleteTab();
    }
}
