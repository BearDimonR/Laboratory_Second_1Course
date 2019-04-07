package GUI.Editing;

import BackGround.Stock;
import GUI.General.AppStyles;

import javax.swing.*;

public class EditingPanel extends JPanel {
    private static ProductEditingPanel productEditPanel = new ProductEditingPanel();
    private static GroupEditingPanel groupEditPanel = new GroupEditingPanel();

    public EditingPanel() {
        setLayout(null);
        setDefaultVisibility();
        addSubPanels();
    }

    /**
     * Method sets visible product editing panel and
     * mode seletion togle btn set in off position
     */
    public static void setDefaultVisibility() {
        productEditPanel.setVisible(true);
        groupEditPanel.setVisible(false);
    }

    /**
     * Method adds creation sub panels
     * - groupCEditingPanel
     * - productEditPanel
     * and mode togle btn to main creation panel
     */
    private void addSubPanels() {
        add(productEditPanel);
        add(groupEditPanel);
        productEditPanel.setBounds(0, 0, 914, 666);
        groupEditPanel.setBounds(0, 0, 914, 666);
        productEditPanel.setVisible(true);
        groupEditPanel.setVisible(false);
    }

    /**
     * Method shows group edit tab and hide product edit tab
     */
    public static void showGroupEditTab() {
        productEditPanel.setVisible(false);
        groupEditPanel.setVisible(true);
        groupEditPanel.getTablePanel().addDataToGroupOFGoodsTable(Stock.getGroups(), 2);
    }

    /**
     * Method shows product edit tab and hide group edit tab
     */
    public static void showProductDeleteTab() {
        productEditPanel.setVisible(true);
        groupEditPanel.setVisible(false);
        productEditPanel.getTablePanel().addDataToGoodsTable(Stock.getAllProducts(), 1);
    }

    /**
     * Method updates table
     */
    public void updateTable() {
        if (groupEditPanel.isVisible())
            showGroupEditTab();
        else
            showProductDeleteTab();
    }

}
