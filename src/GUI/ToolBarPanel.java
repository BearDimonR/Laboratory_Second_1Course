package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ToolBarPanel extends JPanel {
    JLabel toolBarBackground = new JLabel(new ImageIcon("images/toolBarBackground.jpg"));//Background of tool bar
    JLabel selectedCreateBTN = new JLabel(new ImageIcon("images/selectedCreateBTN.jpg"));
    JLabel selectedEditBTN = new JLabel(new ImageIcon("images/selectedEditBTN.jpg"));
    JLabel selectedDeleteBTN = new JLabel(new ImageIcon("images/selectedDeleteBTN.jpg"));
    JLabel selectedQuantityBTN = new JLabel(new ImageIcon("images/selectedQuantityBTN.jpg"));
    JLabel selectedSettingsBTN = new JLabel(new ImageIcon("images/selectedSettingsBTN.jpg"));
    JLabel deselectedCreateBTN = new JLabel(new ImageIcon("images/deselectedCreateBTN.jpg"));
    JLabel deselectedEditBTN = new JLabel(new ImageIcon("images/deselectedEditBTN.jpg"));
    JLabel deselectedDeleteBTN = new JLabel(new ImageIcon("images/deselectedDeleteBTN.jpg"));
    JLabel deselectedQuantityBTN = new JLabel(new ImageIcon("images/deselectedQuantityBTN.jpg"));
    JLabel deselectedSettingsBTN = new JLabel(new ImageIcon("images/deselectedSettingsBTN.jpg"));

    public ToolBarPanel() {
        setLayout(AppStyles.gridBagLayout);
        toolBarBackground.setLayout(AppStyles.gridBagLayout);

        //set default btn selection
        {
            selectedEditBTN.setVisible(false);
            selectedDeleteBTN.setVisible(false);
            selectedQuantityBTN.setVisible(false);
            selectedSettingsBTN.setVisible(false);
        }

        //set size of toll bar panel
        {
            setSize(new Dimension(95, 665));
            setPreferredSize(new Dimension(95, 665));
            setMaximumSize(new Dimension(95, 665));
            setMinimumSize(new Dimension(95, 665));
        }

        //add elements on tool bar
        {
            add(toolBarBackground);
            toolBarBackground.add(selectedCreateBTN, new GridBagConstraints(0, 0, 1, 1, 1, 0.25,
                    GridBagConstraints.NORTH, GridBagConstraints.NORTH,
                    new Insets(75, 0, 0, 0), 0, 0));
            toolBarBackground.add(deselectedCreateBTN, new GridBagConstraints(0, 0, 1, 1, 1, 0.25,
                    GridBagConstraints.NORTH, GridBagConstraints.NORTH,
                    new Insets(75, 0, 0, 0), 0, 0));
            toolBarBackground.add(selectedEditBTN, new GridBagConstraints(0, 0, 1, 1, 1, 0.25,
                    GridBagConstraints.NORTH, GridBagConstraints.NORTH,
                    new Insets(160, 0, 0, 0), 0, 0));
            toolBarBackground.add(deselectedEditBTN, new GridBagConstraints(0, 0, 1, 1, 1, 0.25,
                    GridBagConstraints.NORTH, GridBagConstraints.NORTH,
                    new Insets(160, 0, 0, 0), 0, 0));
            toolBarBackground.add(selectedDeleteBTN, new GridBagConstraints(0, 0, 1, 1, 1, 0.25,
                    GridBagConstraints.NORTH, GridBagConstraints.NORTH,
                    new Insets(250, 0, 0, 0), 0, 0));
            toolBarBackground.add(deselectedDeleteBTN, new GridBagConstraints(0, 0, 1, 1, 1, 0.25,
                    GridBagConstraints.NORTH, GridBagConstraints.NORTH,
                    new Insets(250, 0, 0, 0), 0, 0));
            toolBarBackground.add(selectedQuantityBTN, new GridBagConstraints(0, 0, 1, 1, 1, 0.25,
                    GridBagConstraints.NORTH, GridBagConstraints.NORTH,
                    new Insets(330, 0, 0, 0), 0, 0));
            toolBarBackground.add(deselectedQuantityBTN, new GridBagConstraints(0, 0, 1, 1, 1, 0.25,
                    GridBagConstraints.NORTH, GridBagConstraints.NORTH,
                    new Insets(330, 0, 0, 0), 0, 0));
            toolBarBackground.add(selectedSettingsBTN, new GridBagConstraints(0, 0, 1, 1, 1, 0.25,
                    GridBagConstraints.NORTH, GridBagConstraints.NORTH,
                    new Insets(420, 0, 0, 0), 0, 0));
            toolBarBackground.add(deselectedSettingsBTN, new GridBagConstraints(0, 0, 1, 1, 1, 0.25,
                    GridBagConstraints.NORTH, GridBagConstraints.NORTH,
                    new Insets(420, 0, 0, 0), 0, 0));
        }

        //add mouse listeners to buttons of tool bar
        {
            deselectedCreateBTN.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    //Button selection
                    {
                        selectedCreateBTN.setVisible(true);
                        deselectedCreateBTN.setVisible(false);
                        selectedEditBTN.setVisible(false);
                        deselectedEditBTN.setVisible(true);
                        selectedDeleteBTN.setVisible(false);
                        deselectedDeleteBTN.setVisible(true);
                        selectedQuantityBTN.setVisible(false);
                        deselectedQuantityBTN.setVisible(true);
                        selectedSettingsBTN.setVisible(false);
                        deselectedSettingsBTN.setVisible(true);
                    }

                    //Panel selection
                    {
                        CreationPanel.showProductCraetionPanel();
                        ContentPanel.showPanel(1);
                    }

                }
            });
            deselectedEditBTN.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    //Button selection
                    {
                        selectedCreateBTN.setVisible(false);
                        deselectedCreateBTN.setVisible(true);
                        selectedEditBTN.setVisible(true);
                        deselectedEditBTN.setVisible(false);
                        selectedDeleteBTN.setVisible(false);
                        deselectedDeleteBTN.setVisible(true);
                        selectedQuantityBTN.setVisible(false);
                        deselectedQuantityBTN.setVisible(true);
                        selectedSettingsBTN.setVisible(false);
                        deselectedSettingsBTN.setVisible(true);
                    }

                    //Panel selection
                    {
                        ContentPanel.showPanel(2);
                    }

                }
            });
            deselectedDeleteBTN.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    //Button selection
                    {
                        selectedCreateBTN.setVisible(false);
                        deselectedCreateBTN.setVisible(true);
                        selectedEditBTN.setVisible(false);
                        deselectedEditBTN.setVisible(true);
                        selectedDeleteBTN.setVisible(true);
                        deselectedDeleteBTN.setVisible(false);
                        selectedQuantityBTN.setVisible(false);
                        deselectedQuantityBTN.setVisible(true);
                        selectedSettingsBTN.setVisible(false);
                        deselectedSettingsBTN.setVisible(true);
                    }
                    //Panel selection
                    {
                        ContentPanel.showPanel(3);
                    }

                }
            });
            deselectedQuantityBTN.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    //Button selection
                    {
                        selectedCreateBTN.setVisible(false);
                        deselectedCreateBTN.setVisible(true);
                        selectedEditBTN.setVisible(false);
                        deselectedEditBTN.setVisible(true);
                        selectedDeleteBTN.setVisible(false);
                        deselectedDeleteBTN.setVisible(true);
                        selectedQuantityBTN.setVisible(true);
                        deselectedQuantityBTN.setVisible(false);
                        selectedSettingsBTN.setVisible(false);
                        deselectedSettingsBTN.setVisible(true);
                    }

                    //Panel selection
                    {
                        ContentPanel.showPanel(4);
                    }

                }
            });
            deselectedSettingsBTN.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    //Button selection
                    {
                        selectedCreateBTN.setVisible(false);
                        deselectedCreateBTN.setVisible(true);
                        selectedEditBTN.setVisible(false);
                        deselectedEditBTN.setVisible(true);
                        selectedDeleteBTN.setVisible(false);
                        deselectedDeleteBTN.setVisible(true);
                        selectedQuantityBTN.setVisible(false);
                        deselectedQuantityBTN.setVisible(true);
                        selectedSettingsBTN.setVisible(true);
                        deselectedSettingsBTN.setVisible(false);
                    }

                    //Panel selection
                    {
                        ContentPanel.showPanel(5);
                    }

                }
            });
        }

    }


}
