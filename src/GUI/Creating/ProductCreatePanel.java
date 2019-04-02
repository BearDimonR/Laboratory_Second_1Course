package GUI.Creating;

import BackGround.Product;
import BackGround.Stock;
import GUI.General.AppStyles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductCreatePanel extends JPanel {
    private JLabel btnCreate = new JLabel(new ImageIcon("images/createBTN.jpg"));
    private JLabel background = new JLabel(new ImageIcon("images/createComponents/productCreateBackground.jpg"));
    private JTextField tfProductName = new JTextField();
    private JTextField tfManufacturer = new JTextField();
    private JTextField tfPrice = new JTextField();
    private JComboBox cbProductGroup = new JComboBox();
    private JTextArea taDescription = new JTextArea();
    private JScrollPane spDescription = new JScrollPane(taDescription);

    public ProductCreatePanel() {
        //to change enabled
        btnCreate.setEnabled(false);
        setLayout(AppStyles.gridBagLayout);
        background.setLayout(null);
        setStylesOfUserInputFields();
        addElementsOnProductPanel();
        addListenerToCreateBTN();
        addListenerToUserInputFields();
        checkBox();

    }

    /**
     * Method sets styles of all text areas and text field
     * which are situated on product creation panel
     */
    private void setStylesOfUserInputFields() {
        //tfProductName
        tfProductName.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        tfProductName.setFont(AppStyles.fieldFont);
        tfProductName.setForeground(AppStyles.MainColor);

        //taDescription
        taDescription.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        taDescription.setFont(AppStyles.fieldFont);
        taDescription.setForeground(AppStyles.MainColor);
        spDescription.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        //tfManufacturer
        tfManufacturer.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        tfManufacturer.setFont(AppStyles.fieldFont);
        tfManufacturer.setForeground(AppStyles.MainColor);
        //tfPrice
        tfPrice.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        tfPrice.setFont(AppStyles.fieldFont);
        tfPrice.setForeground(AppStyles.MainColor);
        //cbProductGroup
        cbProductGroup.setBackground(Color.WHITE);
        cbProductGroup.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        cbProductGroup.setFont(AppStyles.fieldFont);
        cbProductGroup.setForeground(AppStyles.MainColor);
    }

    /**
     * Method adds elementa on product creation panel
     */
    private void addElementsOnProductPanel() {
        add(background, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        background.add(tfProductName);
        background.add(spDescription);
        background.add(cbProductGroup);
        background.add(tfManufacturer);
        background.add(tfPrice);
        background.add(btnCreate);
        tfProductName.setBounds(250, 101, 445, 30);
        spDescription.setBounds(253, 174, 438, 135);
        cbProductGroup.setBounds(250, 351, 445, 30);
        tfManufacturer.setBounds(250, 421, 445, 30);
        tfPrice.setBounds(250, 491, 445, 30);
        btnCreate.setBounds(375, 578, 165, 40);
    }

    /**
     * Method adds listenr to creation btn img
     */
    private void addListenerToCreateBTN() {

        btnCreate.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Stock.getGroups().get(cbProductGroup.getSelectedIndex()).addProduct(new Product(Stock.getGroups().get(cbProductGroup.getSelectedIndex()),
                        tfProductName.getText(), tfManufacturer.getText(), Double.valueOf(tfPrice.getText())));
                tfProductName.setText("");
                taDescription.setText("");
                tfManufacturer.setText("");
                tfPrice.setText("");
                //to change enabled
                btnCreate.setEnabled(false);
            }
        });

    }

    private void addListenerToUserInputFields() {
        tfProductName.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                checkFields();
            }
        });
        cbProductGroup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkFields();
            }
        });
        taDescription.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                checkFields();
            }
        });
        tfManufacturer.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                checkFields();
            }
        });
        tfPrice.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!Character.isDigit(e.getKeyChar()))
                    e.consume();
                checkFields();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                checkFields();
            }
        });
    }

    private void checkFields() {
        //to change enable
        Matcher matcher = Pattern.compile("([\"]?[a-zA-ZА-Яa-я]+\\d*[\"]?(\\s?|([-]?))[\"]?[a-zA-ZА-Яa-яєї]+\\d*[\"]?)+").matcher(tfProductName.getText());
        if (!matcher.matches() || tfProductName.getText().length() > 20) {
            btnCreate.setEnabled(false);
            return;
        }
        if(Stock.findProductByName(tfProductName.getText()) != null){
            btnCreate.setEnabled(false);
            return;
        }
        if (taDescription.getText() == null || taDescription.getText().equals("")) {
            btnCreate.setEnabled(false);
            return;
        }
        matcher.reset(tfManufacturer.getText());
        if (!matcher.matches() || tfManufacturer.getText().length() > 20) {
            btnCreate.setEnabled(false);
            return;
        }
        if (tfPrice.getText() != null && tfPrice.getText().length() == 0) {
            btnCreate.setEnabled(false);
            return;
        }
        btnCreate.setEnabled(true);
    }

    public void checkBox() {
        cbProductGroup.removeAllItems();
        for (int i = 0; i < Stock.getGroups().size(); i++) {
            cbProductGroup.addItem(Stock.getGroups().get(i).getName());
        }
    }
}
