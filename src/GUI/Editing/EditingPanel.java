package GUI.Editing;

import GUI.General.AppStyles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EditingPanel extends JPanel {
    private static ProductEditingPanel productEditingPanel = new ProductEditingPanel();
    private static GroupEditingPanel groupEditingPanel = new GroupEditingPanel();
    private static JLabel modeSwitchOn = new JLabel(new ImageIcon("images/GroupCreateModeOn.png"));
    private static JLabel modeSwitchOff = new JLabel(new ImageIcon("images/GroupCreateModeOff.png"));

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
        productEditingPanel.setVisible(true);
        groupEditingPanel.setVisible(false);
        modeSwitchOn.setVisible(false);
        modeSwitchOff.setVisible(true);
    }

    /**
     * Method adds creation sub panels
     * - groupCEditingPanel
     * - productEditingPanel
     * and mode togle btn to main creation panel
     */
    private void addSubPanels() {
        add(modeSwitchOn, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.NORTH,
                new Insets(5, 200, 0, 0), 0, 0));
        add(modeSwitchOff, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.NORTH,
                new Insets(5, 200, 0, 0), 0, 0));
        add(productEditingPanel, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.NORTH,
                new Insets(0, 0, 0, 0), 0, 0));
        add(groupEditingPanel, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.NORTH,
                new Insets(0, 0, 0, 0), 0, 0));

    }

    /**
     * Method adds action listeners to togle btn images
     */
    private void addListenersToModeTogleBTN() {
        modeSwitchOn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                modeSwitchOff.setVisible(true);
                modeSwitchOn.setVisible(false);
                groupEditingPanel.setVisible(false);
                productEditingPanel.setVisible(true);
            }
        });
        modeSwitchOff.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                modeSwitchOff.setVisible(false);
                modeSwitchOn.setVisible(true);
                groupEditingPanel.setVisible(true);
                productEditingPanel.setVisible(false);
            }
        });
    }
}
