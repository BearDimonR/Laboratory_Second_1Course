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
        btnCreate.setEnabled(false);
        setLayout(AppStyles.gridBagLayout);
        background.setLayout(AppStyles.gridBagLayout);
        setStylesOfTFandTA();
        addElementsOnProductPanel();
        addListenerToCreateBTN();
        checkBox();

    }

    /**
     * Method sets styles of all text areas and text field
     * which are situated on product creation panel
     */
    private void setStylesOfTFandTA() {
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
        background.add(tfProductName, new GridBagConstraints(0, 0, 1, 1, 1, 0.0001,
                GridBagConstraints.NORTH, GridBagConstraints.NORTH,
                new Insets(101, 30, 0, 0), 430, 0));
        background.add(spDescription, new GridBagConstraints(0, 0, 1, 1, 1, 0.0001,
                GridBagConstraints.NORTH, GridBagConstraints.NORTH,
                new Insets(175, 30, 0, 0), 435, 100));
        background.add(cbProductGroup, new GridBagConstraints(0, 0, 1, 1, 1, 0.0001,
                GridBagConstraints.NORTH, GridBagConstraints.NORTH,
                new Insets(350, 30, 0, 0), 413, 0));
        background.add(tfManufacturer, new GridBagConstraints(0, 0, 1, 1, 1, 0.25,
                GridBagConstraints.CENTER, GridBagConstraints.NORTH,
                new Insets(209, 30, 0, 0), 435, 0));
        background.add(tfPrice, new GridBagConstraints(0, 0, 1, 1, 1, 0.25,
                GridBagConstraints.CENTER, GridBagConstraints.NORTH,
                new Insets(349, 30, 0, 0), 435, 0));
        background.add(btnCreate, new GridBagConstraints(0, 0, 1, 1, 1, 0.25,
                GridBagConstraints.NORTH, GridBagConstraints.NORTH,
                new Insets(578, 1, 0, 0), 0, 0));
    }

    /**
     * Method adds listenr to creation btn img
     */
    private void addListenerToCreateBTN() {
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
        btnCreate.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Stock.getGroups().get(cbProductGroup.getSelectedIndex()).addProduct(new Product(Stock.getGroups().get(cbProductGroup.getSelectedIndex()),
                        tfProductName.getText(), tfManufacturer.getText(), Double.valueOf(tfPrice.getText())));
                btnCreate.setEnabled(false);
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
        Matcher matcher = Pattern.compile("([\"]?[a-zA-ZА-Яa-я]+\\d*[\"]?(\\s?|([-]?))[\"]?[a-zA-ZА-Яa-яєї]+\\d*[\"]?)+").matcher(tfProductName.getText());
        if (!matcher.matches() || tfProductName.getText().length() > 20) {
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
