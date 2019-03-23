package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GroupCreationPanel extends JPanel {
    JLabel createBTN = new JLabel(new ImageIcon("images/CreateBTN.jpg"));
    JLabel background = new JLabel(new ImageIcon("images/GroupCreateBackground.jpg"));
   JTextField groupNameTF = new JTextField();
   JTextArea descriptionTA = new JTextArea();
   public GroupCreationPanel() {
       setLayout(AppStyles.gridBagLayout);
       background.setLayout(AppStyles.gridBagLayout);
background.setHo
       //set styles of textfield and text areas
       {
           //groupNameTF
           {
               // productNameTF.setOpaque(false);
               groupNameTF.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
               groupNameTF.setFont(AppStyles.fieldFont);
               groupNameTF.setForeground(AppStyles.MainColor);
           }
           //descriptionTA
           {
               //  descriptionTA.setOpaque(false);
               descriptionTA.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
               descriptionTA.setFont(AppStyles.fieldFont);
               descriptionTA.setForeground(AppStyles.MainColor);
           }
       }

       //add elements
       {
           add(background, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                   GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                   new Insets(0, 0, 0, 0), 0, 0));
           background.add(groupNameTF, new GridBagConstraints(0, 0, 1, 1, 1, 0.0001,
                   GridBagConstraints.NORTH, GridBagConstraints.NORTH,
                   new Insets(100, 353, 0, 0), 350, 0));
           background.add(descriptionTA, new GridBagConstraints(0, 0, 1, 1, 1, 0.0001,
                   GridBagConstraints.NORTH, GridBagConstraints.NORTH,
                   new Insets(175, 353, 0, 0), 350, 0));
           descriptionTA.setBackground(Color.RED);
           background.add(createBTN, new GridBagConstraints(0, 0, 1, 1, 1, 0.25,
                   GridBagConstraints.NORTH, GridBagConstraints.NORTH,
                   new Insets(550, 0, 0, 0), 0, 0));
       }

       //add mouse listeners
       {
           createBTN.addMouseListener(new MouseAdapter() {
               @Override
               public void mouseClicked(MouseEvent e) {
                   //       Aaaalaarm
                   //здесь бил бекенд
               }
           });
       }
   }
}
