package GUI.Editing;

import BackGround.Stock;
import GUI.General.AppStyles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class EditingPanel extends JPanel {
    private static ProductEditingPanel productEditPanel = new ProductEditingPanel();
    private static GroupEditingPanel groupEditPanel = new GroupEditingPanel();
    private static JLabel btnModeSwitchOn = new JLabel(new ImageIcon("images/groupCreateModeOnBTN.png"));
    private static JLabel btnModeSwitchOff = new JLabel(new ImageIcon("images/groupCreateModeOffBTN.png"));

    public EditingPanel() {
        setLayout(AppStyles.gridBagLayout);
        setDefaultVisibility();
        addSubPanels();
        addListenersToModeTogleBTN();
    }

    /**
     * Method sets visible product editing panel and
     * mode seletion togle btn set in off position
     */
    public static void setDefaultVisibility() {
        productEditPanel.setVisible(true);
        groupEditPanel.setVisible(false);
        btnModeSwitchOn.setVisible(false);
        btnModeSwitchOff.setVisible(true);
    }

    /**
     * Method adds creation sub panels
     * - groupCEditingPanel
     * - productEditPanel
     * and mode togle btn to main creation panel
     */
    private void addSubPanels() {
        add(btnModeSwitchOn, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.NORTH,
                new Insets(5, 200, 0, 0), 0, 0));
        add(btnModeSwitchOff, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.NORTH,
                new Insets(5, 200, 0, 0), 0, 0));
        add(productEditPanel, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.NORTH,
                new Insets(0, 0, 0, 0), 0, 0));
        add(groupEditPanel, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.NORTH,
                new Insets(0, 0, 0, 0), 0, 0));

    }

    /**
     * Method adds action listeners to togle btn images
     */
    private void addListenersToModeTogleBTN() {
        btnModeSwitchOn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                btnModeSwitchOff.setVisible(true);
                btnModeSwitchOn.setVisible(false);
                groupEditPanel.setVisible(false);
                productEditPanel.setVisible(true);
            }
        });
        btnModeSwitchOff.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                btnModeSwitchOff.setVisible(false);
                btnModeSwitchOn.setVisible(true);
                groupEditPanel.setVisible(true);
                productEditPanel.setVisible(false);
                groupEditPanel.getTablePanel().addDataToGroupOFGoodsTable(Stock.getGroups(),2);
            }
        });
    }

    public void updateTable(){
        if(groupEditPanel.isVisible()) groupEditPanel.getTablePanel().addDataToGroupOFGoodsTable(Stock.getGroups(),2);
        else ;//to write
    }
}
