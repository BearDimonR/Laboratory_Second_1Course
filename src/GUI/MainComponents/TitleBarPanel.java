package GUI.MainComponents;

import GUI.General.AppStyles;
import GUI.General.App;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TitleBarPanel extends JPanel {
    JLabel btnCancel = new JLabel(new ImageIcon("images/cancelBTN.jpg"));//icon of cancel btn
    JLabel btnMinimize = new JLabel(new ImageIcon("images/minimise.jpg"));//icon of minimize btn
    JLabel userNameLabel = new JLabel("User name");// label which contains user name info
    JLabel background = new JLabel(new ImageIcon("images/titleBarBackground.jpg"));//background picture of title bar
    JLabel userProfilePic = new JLabel(new ImageIcon("images/userProfilePic.png"));//icon of user profile picture
    JTextField searchTF = new JTextField();

    public TitleBarPanel() {
        setLayout(AppStyles.gridBagLayout);

        //set size of toll bar panel
        {
            setSize(new Dimension(915, 35));
            setPreferredSize(new Dimension(915, 35));
            setMaximumSize(new Dimension(915, 35));
            setMinimumSize(new Dimension(915, 35));
        }

        //set size of cancel button
        {
            btnCancel.setSize(new Dimension(28, 28));
            btnCancel.setPreferredSize(new Dimension(28, 28));
            btnCancel.setMaximumSize(new Dimension(28, 28));
            btnCancel.setMinimumSize(new Dimension(28, 28));
        }

        //set size of minimise button
        {
            btnMinimize.setSize(new Dimension(28, 28));
            btnMinimize.setPreferredSize(new Dimension(28, 28));
            btnMinimize.setMaximumSize(new Dimension(28, 28));
            btnMinimize.setMinimumSize(new Dimension(28, 28));
        }

        //set size of User profile picture button
        {
            userProfilePic.setSize(new Dimension(31, 31));
            userProfilePic.setPreferredSize(new Dimension(31, 31));
            userProfilePic.setMaximumSize(new Dimension(31, 31));
            userProfilePic.setMinimumSize(new Dimension(31, 31));
        }

        //set color and style of toll bar panel
        {
            background.setLayout(AppStyles.gridBagLayout);
            userNameLabel.setForeground(AppStyles.MainColor);
            userNameLabel.setFont(AppStyles.appH1Font);
        }

        //set style of search text field
        {
            searchTF.setOpaque(false);
            searchTF.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            searchTF.setFont(AppStyles.searchFont);
            searchTF.setForeground(AppStyles.MainColor);
        }

        //add elements to title bar
        {
            add(background, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            background.add(searchTF, new GridBagConstraints(0, 0, 1, 1, 0.1, 1,
                    GridBagConstraints.WEST, GridBagConstraints.CENTER,
                    new Insets(0, 65, 3, 0), 140, 0));
            background.add(userProfilePic, new GridBagConstraints(1, 0, 1, 1, 0.001, 1,
                    GridBagConstraints.EAST, GridBagConstraints.CENTER,
                    new Insets(0, 0, 0, 0), 0, 0));
            background.add(userNameLabel, new GridBagConstraints(2, 0, 1, 1, 0.01, 1,
                    GridBagConstraints.EAST, GridBagConstraints.CENTER,
                    new Insets(0, -45, 0, 20), 0, 0));
            background.add(btnMinimize, new GridBagConstraints(3, 0, 1, 1, 0.001, 1,
                    GridBagConstraints.EAST, GridBagConstraints.CENTER,
                    new Insets(0, 0, 0, 2), 0, 0));
            background.add(btnCancel, new GridBagConstraints(4, 0, 1, 1, 0.0012, 1,
                    GridBagConstraints.EAST, GridBagConstraints.CENTER,
                    new Insets(0, 0, 0, 3), 0, 0));
        }

        //add mouse listener to close and minimize btn
        {
            btnCancel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    System.exit(0);
                }
            });
            btnMinimize.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    App.mainFrame.setState(Frame.ICONIFIED);
                }
            });
            searchTF.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    ToolBarPanel.deselectAllButtonsOnToolBar();
                    ContentPanel.showPanel(6);

                }
            });
        }

    }


}
