package GUI.MainComponents;

import GUI.General.AppStyles;
import GUI.General.App;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TitleBarPanel extends JPanel {
    JLabel btnCancel = new JLabel(new ImageIcon("images/mainFrame/cancelBTN.jpg"));//icon of cancel btn
    JLabel btnMinimize = new JLabel(new ImageIcon("images/mainFrame/minimiseBTN.jpg"));//icon of minimize btn
    JLabel userNameLabel = new JLabel("User name");// label which contains user name info
    JLabel background = new JLabel(new ImageIcon("images/mainFrame/titleBarBackground.jpg"));//background picture of title bar
    JLabel userProfilePic = new JLabel(new ImageIcon("images/userProfilePic.png"));//icon of user profile picture
    JLabel totalPrice = new JLabel(new ImageIcon("images/userProfilePic.png"));//icon of user profile picture
    JLabel totalAmount = new JLabel(new ImageIcon("images/userProfilePic.png"));//icon of user profile picture
    JTextField tfSearch = new JTextField();

    public TitleBarPanel() {
        setLayout(null);
        background.setLayout(null);
        background.setVisible(true);
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
            userNameLabel.setFont(AppStyles.untitled);
        }

        //set style of search text field
        {
            tfSearch.setOpaque(false);
            tfSearch.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            tfSearch.setFont(AppStyles.searchFont);
            tfSearch.setForeground(AppStyles.MainColor);
        }

        //add elements to title bar
        {
            add(background);
background.add(tfSearch);
background.add(userProfilePic);
/*background.add(userNameLabel);
background.add(btnMinimize);
background.add(btnCancel);
background.add(totalAmount);
background.add(totalPrice);*/
background.setBounds(0,0,914,35);
userProfilePic.setBounds(716,3,26,26);
/*userNameLabel.setBounds(1058,10,142,14);
btnMinimize.setBounds(848,0,27,27);
btnCancel.setBounds(884,0,27,27);*/
            /*totalAmount.setBounds(0, 0, 914, 35);
            totalPrice.setBounds(0, 0, 914, 35);*/

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
            tfSearch.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    ToolBarPanel.deselectAllButtonsOnToolBar();
                    ContentPanel.showPanel(6);

                }
            });
        }

    }


}
