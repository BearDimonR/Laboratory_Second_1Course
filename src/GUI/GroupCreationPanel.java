package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GroupCreationPanel extends JPanel {
    JLabel createBTN = new JLabel(new ImageIcon("images/CreateBTN.jpg"));
    JLabel background = new JLabel(new ImageIcon("images/groupCreationPanelBackground.jpg"));
    JTextField groupNameTF = new JTextField();
    JTextArea descriptionTA = new JTextArea();
    JScrollPane descriptionScrollPane = new JScrollPane(descriptionTA);

    public GroupCreationPanel() {
        setLayout(AppStyles.gridBagLayout);
        background.setLayout(AppStyles.gridBagLayout);
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
                descriptionScrollPane.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
            }
        }

        //add elements
        {
            add(background, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            background.add(groupNameTF, new GridBagConstraints(0, 0, 1, 1, 1, 0.0001,
                    GridBagConstraints.NORTH, GridBagConstraints.NORTH,
                    new Insets(177, 30, 0, 0), 435, 0));
            background.add(descriptionScrollPane, new GridBagConstraints(0, 0, 1, 1, 1, 0.0001,
                    GridBagConstraints.NORTH, GridBagConstraints.NORTH,
                    new Insets(250, 30, 0, 0), 435, 100));
            background.add(createBTN, new GridBagConstraints(0, 0, 1, 1, 1, 0.25,
                    GridBagConstraints.NORTH, GridBagConstraints.NORTH,
                    new Insets(578, 1, 0, 0), 0, 0));
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
