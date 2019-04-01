package GUI.Creating;

import BackGround.GroupOfProduct;
import BackGround.Stock;
import GUI.General.AppStyles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
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
        background.setLayout(null);

        setStylesOfGroupNameTF();
        setStylesOfDescriptionTA();
        addElementsToGroupCreationPAnel();
        addListenerToUserInputFields();
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
        btnCreate.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Stock.getGroups().add(new GroupOfProduct(tfGroupName.getText(), taDescription.getText()));
            }
        });
    }

    private void checkFields() {
        Matcher matcher = Pattern.compile("([\"]?[a-zA-ZА-Яa-я]+\\d*[\"]?(\\s?|([-]?))[\"]?[a-zA-ZА-Яa-яєї]+\\d*[\"]?)+").matcher(tfGroupName.getText());
        if (!matcher.matches() || tfGroupName.getText().length() > 20) btnCreate.setEnabled(false);
        else if (taDescription.getText() == null || taDescription.getText().equals("")) btnCreate.setEnabled(false);
        else btnCreate.setEnabled(true);
    }

    /**
     * Method adds elements on group creation panel
     */
    private void addElementsToGroupCreationPAnel() {

        background.add(tfGroupName);
        background.add(spDescription);
        background.add(btnCreate);
        tfGroupName.setBounds(250, 178, 445, 30);
        spDescription.setBounds(253, 250, 438, 135);
        btnCreate.setBounds(375,578,165,40);
        add(background, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

    }

    private void addListenerToUserInputFields() {
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
    }
}
