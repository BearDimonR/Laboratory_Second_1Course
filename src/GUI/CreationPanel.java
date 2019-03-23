package GUI;

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

        //set default visibility
        {
            groupCreationPanel.setVisible(false);
            modeSwitchOn.setVisible(false);
        }

        //add subPanels
        {
            add(modeSwitchOn, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                    GridBagConstraints.NORTH, GridBagConstraints.NORTH,
                    new Insets(10, 150, 0, 0), 0, 0));
            add(modeSwitchOff, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                    GridBagConstraints.NORTH, GridBagConstraints.NORTH,
                    new Insets(10, 150, 0, 0), 0, 0));
            add(productCreationPanel, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                    GridBagConstraints.NORTH, GridBagConstraints.NORTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            add(groupCreationPanel, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                    GridBagConstraints.NORTH, GridBagConstraints.NORTH,
                    new Insets(0, 0, 0, 0), 0, 0));

        }

        //add action listeners
        {
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

    public static void showProductCraetionPanel() {
        productCreationPanel.setVisible(true);
        groupCreationPanel.setVisible(false);
        modeSwitchOn.setVisible(false);
        modeSwitchOff.setVisible(true);
    }
}
