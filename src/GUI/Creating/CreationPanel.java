package GUI.Creating;

import GUI.General.AppStyles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CreationPanel extends JPanel {
    private static ProductCreationPanel productCreationPanel = new ProductCreationPanel();
    private static GroupCreationPanel groupCreationPanel = new GroupCreationPanel();
    private static JLabel modeSwitchOn = new JLabel(new ImageIcon("images/GroupCreateModeOn.png"));
    private static JLabel modeSwitchOff = new JLabel(new ImageIcon("images/GroupCreateModeOff.png"));

    public CreationPanel() {
        setLayout(AppStyles.gridBagLayout);
        setDefaultVisibility();
        addSubPanels();
        addListenersToModeTogleBTN();
    }

    /**
     * Method sets visible product creation panel and
     * mode seletion togle btn set in off position
     */
    public static void setDefaultVisibility() {
        productCreationPanel.setVisible(true);
        groupCreationPanel.setVisible(false);
        modeSwitchOn.setVisible(false);
        modeSwitchOff.setVisible(true);
    }

    /**
     * Method adds creation sub panels
     * - groupCreationPanel
     * - productCreationPanel
     * and mode togle btn to main creation panel
     */
    private void addSubPanels() {
        add(modeSwitchOn, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.NORTH,
                new Insets(5, 200, 0, 0), 0, 0));
        add(modeSwitchOff, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.NORTH,
                new Insets(5, 200, 0, 0), 0, 0));
        add(productCreationPanel, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.NORTH,
                new Insets(0, 0, 0, 0), 0, 0));
        add(groupCreationPanel, new GridBagConstraints(0, 0, 1, 1, 1, 1,
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
                groupCreationPanel.setVisible(false);
                productCreationPanel.setVisible(true);
            }
        });
        modeSwitchOff.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                modeSwitchOff.setVisible(false);
                modeSwitchOn.setVisible(true);
                groupCreationPanel.setVisible(true);
                productCreationPanel.setVisible(false);
            }
        });
    }
}
