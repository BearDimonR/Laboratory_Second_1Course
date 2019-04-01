package GUI.Creating;

import BackGround.GroupOfProduct;
import BackGround.Stock;
import GUI.General.AppStyles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GroupCreationPanel extends JPanel {
    JLabel createBTN = new JLabel(new ImageIcon("images/CreateBTN.jpg"));
    JLabel background = new JLabel(new ImageIcon("images/groupCreationPanelBackground.jpg"));
    JTextField groupNameTF = new JTextField();
    JTextArea descriptionTA = new JTextArea();
    JScrollPane descriptionScrollPane = new JScrollPane(descriptionTA);

    public GroupCreationPanel() {
        createBTN.setEnabled(false);
        setLayout(AppStyles.gridBagLayout);
        background.setLayout(AppStyles.gridBagLayout);

        setStylesOfGroupNameTF();
        setStylesOfDescriptionTA();
        addElementsToGroupCreationPAnel();
        addListenerToCreateBTN();
    }

    /**
     * set border font and foreground of name text field
     */
    private void setStylesOfGroupNameTF() {
        groupNameTF.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        groupNameTF.setFont(AppStyles.fieldFont);
        groupNameTF.setForeground(AppStyles.MainColor);
    }

    /**
     * set border font and foreground of description text area
     */
    private void setStylesOfDescriptionTA() {
        descriptionTA.setFont(AppStyles.fieldFont);
        descriptionTA.setForeground(AppStyles.MainColor);
        descriptionScrollPane.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
    }

    /**
     * Method adds listenr to creation btn img
     */
    private void addListenerToCreateBTN() {
        groupNameTF.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
               checkFields();
            }
        });
        descriptionTA.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                checkFields();
            }
        });

        createBTN.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Stock.getGroups().add(new GroupOfProduct(groupNameTF.getText(),descriptionTA.getText()));
            }
        });
    }

    private void checkFields() {
        Matcher matcher = Pattern.compile("([\"]?[a-zA-ZА-Яa-я]+\\d*[\"]?(\\s?|([-]?))[\"]?[a-zA-ZА-Яa-яєї]+\\d*[\"]?)+").matcher(groupNameTF.getText());
        if(!matcher.matches() || groupNameTF.getText().length()>20) createBTN.setEnabled(false);
        else if(descriptionTA.getText() == null || descriptionTA.getText().equals("")) createBTN.setEnabled(false);
        else createBTN.setEnabled(true);
    }

    /**
     * Method adds elements on group creation panel
     */
    private void addElementsToGroupCreationPAnel() {
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
}
