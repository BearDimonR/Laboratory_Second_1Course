package GUI.MainComponents;

import GUI.General.AppStyles;
import GUI.Creating.CreationPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ToolBarPanel extends JPanel {
    private static JLabel toolBarBackground = new JLabel(new ImageIcon("images/mainFrame/toolBarBackground.jpg"));//Background of tool bar
    private static JLabel btnSelectedCreate = new JLabel(new ImageIcon("images/toolBarButtons/selectedCreate.jpg"));
    private static JLabel btnSelectedEdit = new JLabel(new ImageIcon("images/toolBarButtons/selectedEdit.jpg"));
    private static JLabel btnSelectedDelete = new JLabel(new ImageIcon("images/toolBarButtons/selectedDelete.jpg"));
    private static JLabel btnSelectedQuantity = new JLabel(new ImageIcon("images/toolBarButtons/selectedQuantity.jpg"));
    private static JLabel btnSelectedSettings = new JLabel(new ImageIcon("images/toolBarButtons/selectedSettings.jpg"));
    private static JLabel btnSeselectedCreate = new JLabel(new ImageIcon("images/toolBarButtons/deselectedCreate.jpg"));
    private static JLabel btnDeselectedEdit = new JLabel(new ImageIcon("images/toolBarButtons/deselectedEdit.jpg"));
    private static JLabel btnDeselectedDelete = new JLabel(new ImageIcon("images/toolBarButtons/deselectedDelete.jpg"));
    private static JLabel btnDeselectedQuantity = new JLabel(new ImageIcon("images/toolBarButtons/deselectedQuantity.jpg"));
    private static JLabel btnDeselectedSettings = new JLabel(new ImageIcon("images/toolBarButtons/deselectedSettings.jpg"));

    public ToolBarPanel() {
        setLayout(AppStyles.gridBagLayout);
        toolBarBackground.setLayout(AppStyles.gridBagLayout);

        //set default btn selection
        {
            btnSelectedEdit.setVisible(false);
            btnSelectedDelete.setVisible(false);
            btnSelectedQuantity.setVisible(false);
            btnSelectedSettings.setVisible(false);
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
            toolBarBackground.add(btnSelectedCreate, new GridBagConstraints(0, 0, 1, 1, 1, 0.25,
                    GridBagConstraints.NORTH, GridBagConstraints.NORTH,
                    new Insets(75, 0, 0, 0), 0, 0));
            toolBarBackground.add(btnSeselectedCreate, new GridBagConstraints(0, 0, 1, 1, 1, 0.25,
                    GridBagConstraints.NORTH, GridBagConstraints.NORTH,
                    new Insets(75, 0, 0, 0), 0, 0));
            toolBarBackground.add(btnSelectedEdit, new GridBagConstraints(0, 0, 1, 1, 1, 0.25,
                    GridBagConstraints.NORTH, GridBagConstraints.NORTH,
                    new Insets(160, 0, 0, 0), 0, 0));
            toolBarBackground.add(btnDeselectedEdit, new GridBagConstraints(0, 0, 1, 1, 1, 0.25,
                    GridBagConstraints.NORTH, GridBagConstraints.NORTH,
                    new Insets(160, 0, 0, 0), 0, 0));
            toolBarBackground.add(btnSelectedDelete, new GridBagConstraints(0, 0, 1, 1, 1, 0.25,
                    GridBagConstraints.NORTH, GridBagConstraints.NORTH,
                    new Insets(250, 0, 0, 0), 0, 0));
            toolBarBackground.add(btnDeselectedDelete, new GridBagConstraints(0, 0, 1, 1, 1, 0.25,
                    GridBagConstraints.NORTH, GridBagConstraints.NORTH,
                    new Insets(250, 0, 0, 0), 0, 0));
            toolBarBackground.add(btnSelectedQuantity, new GridBagConstraints(0, 0, 1, 1, 1, 0.25,
                    GridBagConstraints.NORTH, GridBagConstraints.NORTH,
                    new Insets(330, 0, 0, 0), 0, 0));
            toolBarBackground.add(btnDeselectedQuantity, new GridBagConstraints(0, 0, 1, 1, 1, 0.25,
                    GridBagConstraints.NORTH, GridBagConstraints.NORTH,
                    new Insets(330, 0, 0, 0), 0, 0));
            toolBarBackground.add(btnSelectedSettings, new GridBagConstraints(0, 0, 1, 1, 1, 0.25,
                    GridBagConstraints.NORTH, GridBagConstraints.NORTH,
                    new Insets(420, 0, 0, 0), 0, 0));
            toolBarBackground.add(btnDeselectedSettings, new GridBagConstraints(0, 0, 1, 1, 1, 0.25,
                    GridBagConstraints.NORTH, GridBagConstraints.NORTH,
                    new Insets(420, 0, 0, 0), 0, 0));
        }

        //add mouse listeners to buttons of tool bar
        {
            btnSeselectedCreate.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    //Button selection
                    {
                        btnSelectedCreate.setVisible(true);
                        btnSeselectedCreate.setVisible(false);
                        btnSelectedEdit.setVisible(false);
                        btnDeselectedEdit.setVisible(true);
                        btnSelectedDelete.setVisible(false);
                        btnDeselectedDelete.setVisible(true);
                        btnSelectedQuantity.setVisible(false);
                        btnDeselectedQuantity.setVisible(true);
                        btnSelectedSettings.setVisible(false);
                        btnDeselectedSettings.setVisible(true);
                    }

                    //Panel selection
                    {
                        CreationPanel.setDefaultVisibility();
                        ContentPanel.showPanel(1);
                    }

                }
            });
            btnDeselectedEdit.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    //Button selection
                    {
                        btnSelectedCreate.setVisible(false);
                        btnSeselectedCreate.setVisible(true);
                        btnSelectedEdit.setVisible(true);
                        btnDeselectedEdit.setVisible(false);
                        btnSelectedDelete.setVisible(false);
                        btnDeselectedDelete.setVisible(true);
                        btnSelectedQuantity.setVisible(false);
                        btnDeselectedQuantity.setVisible(true);
                        btnSelectedSettings.setVisible(false);
                        btnDeselectedSettings.setVisible(true);

                    }

                    //Panel selection
                    {
                        ContentPanel.showPanel(2);
                    }

                }
            });
            btnDeselectedDelete.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    //Button selection
                    {
                        btnSelectedCreate.setVisible(false);
                        btnSeselectedCreate.setVisible(true);
                        btnSelectedEdit.setVisible(false);
                        btnDeselectedEdit.setVisible(true);
                        btnSelectedDelete.setVisible(true);
                        btnDeselectedDelete.setVisible(false);
                        btnSelectedQuantity.setVisible(false);
                        btnDeselectedQuantity.setVisible(true);
                        btnSelectedSettings.setVisible(false);
                        btnDeselectedSettings.setVisible(true);
                    }
                    //Panel selection
                    {
                        ContentPanel.showPanel(3);
                    }

                }
            });
            btnDeselectedQuantity.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    //Button selection
                    {
                        btnSelectedCreate.setVisible(false);
                        btnSeselectedCreate.setVisible(true);
                        btnSelectedEdit.setVisible(false);
                        btnDeselectedEdit.setVisible(true);
                        btnSelectedDelete.setVisible(false);
                        btnDeselectedDelete.setVisible(true);
                        btnSelectedQuantity.setVisible(true);
                        btnDeselectedQuantity.setVisible(false);
                        btnSelectedSettings.setVisible(false);
                        btnDeselectedSettings.setVisible(true);
                    }

                    //Panel selection
                    {
                        ContentPanel.showPanel(4);
                    }

                }
            });
            btnDeselectedSettings.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    //Button selection
                    {
                        btnSelectedCreate.setVisible(false);
                        btnSeselectedCreate.setVisible(true);
                        btnSelectedEdit.setVisible(false);
                        btnDeselectedEdit.setVisible(true);
                        btnSelectedDelete.setVisible(false);
                        btnDeselectedDelete.setVisible(true);
                        btnSelectedQuantity.setVisible(false);
                        btnDeselectedQuantity.setVisible(true);
                        btnSelectedSettings.setVisible(true);
                        btnDeselectedSettings.setVisible(false);
                    }

                    //Panel selection
                    {
                        ContentPanel.showPanel(5);
                    }

                }
            });
        }

    }

    public static void deselectAllButtonsOnToolBar() {
        btnSelectedCreate.setVisible(false);
        btnSeselectedCreate.setVisible(true);
        btnSelectedEdit.setVisible(false);
        btnDeselectedEdit.setVisible(true);
        btnSelectedDelete.setVisible(false);
        btnDeselectedDelete.setVisible(true);
        btnSelectedQuantity.setVisible(false);
        btnDeselectedQuantity.setVisible(true);
        btnSelectedSettings.setVisible(false);
        btnDeselectedSettings.setVisible(true);
    }


}
