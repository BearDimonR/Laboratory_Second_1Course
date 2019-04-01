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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GroupCreatePanel extends JPanel {
   private JLabel btnCreate = new JLabel(new ImageIcon("images/createBTN.jpg"));
   private JLabel background = new JLabel(new ImageIcon("images/createComponents/groupCreateBackground.jpg"));
   private JTextField tfGroupName = new JTextField();
   private JTextArea taDescription = new JTextArea();
   private JScrollPane spDescription = new JScrollPane(taDescription);

    public GroupCreatePanel() {
        btnCreate.setEnabled(false);
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
        tfGroupName.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        tfGroupName.setFont(AppStyles.fieldFont);
        tfGroupName.setForeground(AppStyles.MainColor);
    }

    /**
     * set border font and foreground of description text area
     */
    private void setStylesOfDescriptionTA() {
        taDescription.setFont(AppStyles.fieldFont);
        taDescription.setForeground(AppStyles.MainColor);
        spDescription.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
    }

    /**
     * Method adds listenr to creation btn img
     */
    private void addListenerToCreateBTN() {
        tfGroupName.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
               checkFields();
            }
        });
        taDescription.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                checkFields();
            }
        });
        btnCreate.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Stock.getGroups().add(new GroupOfProduct(tfGroupName.getText(), taDescription.getText()));
            }
        });
    }

    private void checkFields() {
        Matcher matcher = Pattern.compile("([\"]?[a-zA-ZА-Яa-я]+\\d*[\"]?(\\s?|([-]?))[\"]?[a-zA-ZА-Яa-яєї]+\\d*[\"]?)+").matcher(tfGroupName.getText());
        if(!matcher.matches() || tfGroupName.getText().length()>20) btnCreate.setEnabled(false);
        else if(taDescription.getText() == null || taDescription.getText().equals("")) btnCreate.setEnabled(false);
        else btnCreate.setEnabled(true);
    }

    /**
     * Method adds elements on group creation panel
     */
    private void addElementsToGroupCreationPAnel() {
        add(background, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        background.add(tfGroupName, new GridBagConstraints(0, 0, 1, 1, 1, 0.0001,
                GridBagConstraints.NORTH, GridBagConstraints.NORTH,
                new Insets(177, 30, 0, 0), 435, 0));
        background.add(spDescription, new GridBagConstraints(0, 0, 1, 1, 1, 0.0001,
                GridBagConstraints.NORTH, GridBagConstraints.NORTH,
                new Insets(250, 30, 0, 0), 435, 100));
        background.add(btnCreate, new GridBagConstraints(0, 0, 1, 1, 1, 0.25,
                GridBagConstraints.NORTH, GridBagConstraints.NORTH,
                new Insets(578, 1, 0, 0), 0, 0));
    }
}
