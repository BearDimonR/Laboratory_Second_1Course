package GUI.Creating;

import GUI.General.AppStyles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CreationPanel extends JPanel {
    private static ProductCreatePanel productCreatePanel = new ProductCreatePanel();
    private static GroupCreatePanel groupCreatePanel = new GroupCreatePanel();
    private static JLabel btnModeSwitchOn = new JLabel(new ImageIcon("images/groupCreateModeOnBTN.png"));
    private static JLabel btnModeSwitchBTNOff = new JLabel(new ImageIcon("images/groupCreateModeOffBTN.png"));

    public CreationPanel() {
        setLayout(AppStyles.gridBagLayout);
        setDefaultVisibility();
        addSubPanels();
        addListenersToModeToggleBTN();
    }

    /**
     * Method sets visible product creation panel and
     * mode selection toggle btn set in off position
     */
    public static void setDefaultVisibility() {
        productCreatePanel.setVisible(true);
        groupCreatePanel.setVisible(false);
        btnModeSwitchOn.setVisible(false);
        btnModeSwitchBTNOff.setVisible(true);
    }

    /**
     * Method adds creation sub panels
     * - groupCreatePanel
     * - productCreatePanel
     * and mode toggle btn to main creation panel
     */
    private void addSubPanels() {
        add(btnModeSwitchOn, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.NORTH,
                new Insets(5, 200, 0, 0), 0, 0));
        add(btnModeSwitchBTNOff, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.NORTH,
                new Insets(5, 200, 0, 0), 0, 0));
        add(productCreatePanel, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.NORTH,
                new Insets(0, 0, 0, 0), 0, 0));
        add(groupCreatePanel, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.NORTH,
                new Insets(0, 0, 0, 0), 0, 0));

    }

    /**
     * Method adds action listeners to toggle btn images
     */
    private void addListenersToModeToggleBTN() {
        btnModeSwitchOn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                btnModeSwitchBTNOff.setVisible(true);
                btnModeSwitchOn.setVisible(false);
                groupCreatePanel.setVisible(false);
                productCreatePanel.setVisible(true);
                updateBox();
            }
        });
        btnModeSwitchBTNOff.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                btnModeSwitchBTNOff.setVisible(false);
                btnModeSwitchOn.setVisible(true);
                groupCreatePanel.setVisible(true);
                productCreatePanel.setVisible(false);
                updateBox();
            }
        });
    }

    public static void updateBox() {
        productCreatePanel.checkBox();
    }
}
