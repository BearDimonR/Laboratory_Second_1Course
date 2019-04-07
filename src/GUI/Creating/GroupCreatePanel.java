package GUI.Creating;

import BackGround.GroupOfProduct;
import BackGround.Stock;
import GUI.General.AppStyles;
import GUI.General.DonePanel;
import GUI.MainComponents.ContentPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GroupCreatePanel extends JPanel {
    private JLabel btnCreate = new JLabel(new ImageIcon("images/createBTN.jpg"));
    private JLabel background = new JLabel(new ImageIcon("images/createComponents/groupCreateBackground.jpg"));
    private JLabel btnDesCreate = new JLabel(new ImageIcon("images/deselectedCreateBTN.jpg"));
    private JTextField tfGroupName = new JTextField();
    private JTextArea taDescription = new JTextArea();
    private JScrollPane spDescription = new JScrollPane(taDescription);

    public GroupCreatePanel() {
        //to change enabled
        setCreateDisabled();
        setLayout(AppStyles.gridBagLayout);
        background.setLayout(null);
        setDefaultTextToTF();
        setStylesOfGroupNameTF();
        setStylesOfDescriptionTA();
        addElementsToGroupCreationPanel();
        addListenerToUserInputFields();
        setAllFieldsForegroundDeselected();
        addListenerToCreateBTN();
    }

    /**
     * set border font and foreground of name text field
     */
    private void setStylesOfGroupNameTF() {
        tfGroupName.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        tfGroupName.setFont(AppStyles.appH1Font);
        tfGroupName.setForeground(AppStyles.MainColor);
    }

    /**
     * set border font and foreground of description text area
     */
    private void setStylesOfDescriptionTA() {
        taDescription.setFont(AppStyles.appH1Font);
        taDescription.setForeground(AppStyles.MainColor);
        spDescription.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
    }

    /**
     * Method adds listener to creation btn img
     */
    private void addListenerToCreateBTN() {
        btnCreate.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Stock.getGroups().add(new GroupOfProduct(tfGroupName.getText(), taDescription.getText()));
                Stock.saveData();
                CreationPanel.updateBox();
                setFocusOnNameTF();
                setCreateDisabled();
                setDefaultTextToTF();
                setAllFieldsForegroundDeselected();
                DonePanel d =new DonePanel();
            }
        });
    }

    /**
     * Method which check if fields are filled properly
     */
    private void checkFields() {
        Matcher matcher = Pattern.compile("([\"]?[a-zA-ZА-Яa-яіїє]+\\d*[\"]?(\\s?|([-]?))[\"]?[a-zA-ZА-Яa-яієї]+\\d*[\"]?)+").matcher(tfGroupName.getText());
        if (!matcher.matches() || tfGroupName.getText().length() > 20) setCreateDisabled();
        else if (taDescription.getText() == null || taDescription.getText().equals("")) setCreateDisabled();
        else if (Stock.findGroup(tfGroupName.getText()) != null) setCreateDisabled();
        else if (tfGroupName.getText().equals("Group name") || taDescription.getText().equals("Group description"))
            setCreateDisabled();
        else setCreateEnable();
    }

    /**
     * Method adds elements on group creation panel
     */
    private void addElementsToGroupCreationPanel() {
        background.add(tfGroupName);
        background.add(spDescription);
        background.add(btnCreate);
        background.add(btnDesCreate);
        tfGroupName.setBounds(250, 178, 445, 30);
        spDescription.setBounds(253, 250, 438, 135);
        btnCreate.setBounds(375, 578, 165, 40);
        btnDesCreate.setBounds(375, 578, 165, 40);
        add(background, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

    }

    /**
     * Method adds listeners to user input fields
     */
    private void addListenerToUserInputFields() {
        //Listener-checker of group name text field
        tfGroupName.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                checkFields();
            }
        });
        //Set tips to product name text field
        tfGroupName.addFocusListener(new FocusListener() {

            public void focusGained(FocusEvent e) {
                tfGroupName.setForeground(AppStyles.MainColor);
                if (tfGroupName.getText().equals("Group name"))
                    tfGroupName.setText("");
            }

            public void focusLost(FocusEvent e) {
                if (checkIfEmpty(tfGroupName.getText())) {
                    tfGroupName.setText("Group name");
                    tfGroupName.setForeground(AppStyles.DeselectedColor);
                } else {
                    tfGroupName.setForeground(AppStyles.MainColor);
                }


            }
        });
        //Listener-checker of group description text area
        taDescription.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                checkFields();
            }
        });
        //Set tips to group description text area
        taDescription.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                taDescription.setForeground(AppStyles.MainColor);
                if (taDescription.getText().equals("Group description"))
                    taDescription.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (checkIfEmpty(taDescription.getText())) {
                    taDescription.setText("Group description");
                    taDescription.setForeground(AppStyles.DeselectedColor);
                } else {
                    taDescription.setForeground(AppStyles.MainColor);
                }
            }
        });
    }

    /**
     * Empty string checker
     */
    private boolean checkIfEmpty(String str) {
        Pattern empty = Pattern.compile("[ ]*");
        Matcher matcher = empty.matcher(str);
        return matcher.matches();
    }

    /**
     * Method set create button in enable mode
     */
    private void setCreateEnable() {
        btnCreate.setVisible(true);
        btnDesCreate.setVisible(false);
    }

    /**
     * Method set create button in disabled mode
     */
    private void setCreateDisabled() {
        btnCreate.setVisible(false);
        btnDesCreate.setVisible(true);
    }

    /**
     * Method set cursor to name text field
     */
    private void setFocusOnNameTF() {
        tfGroupName.requestFocusInWindow();
        taDescription.requestFocusInWindow();
        tfGroupName.requestFocusInWindow();
    }

    /**
     * Method set all fields foreground deselected
     */
    private void setAllFieldsForegroundDeselected() {
        tfGroupName.setForeground(AppStyles.DeselectedColor);
        taDescription.setForeground(AppStyles.DeselectedColor);
    }

    /**
     * Method set default text to text fields
     */
    private void setDefaultTextToTF() {
        tfGroupName.setText("Group name");
        taDescription.setText("Group description");
    }
}
