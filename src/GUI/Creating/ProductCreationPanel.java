package GUI.Creating;

import BackGround.GroupOfProduct;
import BackGround.Product;
import BackGround.Stock;
import GUI.General.AppStyles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductCreationPanel extends JPanel {
    JLabel createBTN = new JLabel(new ImageIcon("images/CreateBTN.jpg"));
    JLabel background = new JLabel(new ImageIcon("images/productCreationPanelBackground.jpg"));
    JTextField productNameTF = new JTextField();
    JTextField manufacturerTF = new JTextField();
    JTextField priceTF = new JTextField();
    JComboBox productGroupChooser = new JComboBox();
    JTextArea descriptionTA = new JTextArea();
    JScrollPane descriptionScrollPane = new JScrollPane(descriptionTA);

    public ProductCreationPanel() {
        createBTN.setEnabled(false);
        setLayout(AppStyles.gridBagLayout);
        background.setLayout(AppStyles.gridBagLayout);
        setStylesOfTFandTA();
        addElementsOnProductPanel();
        addListenerToCreateBTN();
        checkBox();

    }

    /**
     * Method sets styles of all text areas and text fialde
     * which are situated on product creation panel
     */
    private void setStylesOfTFandTA() {
        //productNameTF
        productNameTF.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        productNameTF.setFont(AppStyles.fieldFont);
        productNameTF.setForeground(AppStyles.MainColor);

        //descriptionTA
        descriptionTA.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        descriptionTA.setFont(AppStyles.fieldFont);
        descriptionTA.setForeground(AppStyles.MainColor);
        descriptionScrollPane.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        //manufacturerTF
        manufacturerTF.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        manufacturerTF.setFont(AppStyles.fieldFont);
        manufacturerTF.setForeground(AppStyles.MainColor);
        //priceTF
        priceTF.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        priceTF.setFont(AppStyles.fieldFont);
        priceTF.setForeground(AppStyles.MainColor);
        //productGroupChooser
        productGroupChooser.setBackground(Color.WHITE);
        productGroupChooser.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        productGroupChooser.setFont(AppStyles.fieldFont);
        productGroupChooser.setForeground(AppStyles.MainColor);
    }

    /**
     * Method adds elementa on product creation panel
     */
    private void addElementsOnProductPanel() {
        add(background, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        background.add(productNameTF, new GridBagConstraints(0, 0, 1, 1, 1, 0.0001,
                GridBagConstraints.NORTH, GridBagConstraints.NORTH,
                new Insets(101, 30, 0, 0), 430, 0));
        background.add(descriptionScrollPane, new GridBagConstraints(0, 0, 1, 1, 1, 0.0001,
                GridBagConstraints.NORTH, GridBagConstraints.NORTH,
                new Insets(175, 30, 0, 0), 435, 100));
        background.add(productGroupChooser, new GridBagConstraints(0, 0, 1, 1, 1, 0.0001,
                GridBagConstraints.NORTH, GridBagConstraints.NORTH,
                new Insets(350, 30, 0, 0), 413, 0));
        background.add(manufacturerTF, new GridBagConstraints(0, 0, 1, 1, 1, 0.25,
                GridBagConstraints.CENTER, GridBagConstraints.NORTH,
                new Insets(209, 30, 0, 0), 435, 0));
        background.add(priceTF, new GridBagConstraints(0, 0, 1, 1, 1, 0.25,
                GridBagConstraints.CENTER, GridBagConstraints.NORTH,
                new Insets(349, 30, 0, 0), 435, 0));
        background.add(createBTN, new GridBagConstraints(0, 0, 1, 1, 1, 0.25,
                GridBagConstraints.NORTH, GridBagConstraints.NORTH,
                new Insets(578, 1, 0, 0), 0, 0));
    }

    /**
     * Method adds listenr to creation btn img
     */
    private void addListenerToCreateBTN() {
        productNameTF.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                checkFields();
            }
        });
        productGroupChooser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
                Stock.getGroups().get(productGroupChooser.getSelectedIndex()).addProduct(new Product(Stock.getGroups().get(productGroupChooser.getSelectedIndex()),
                        productNameTF.getText(),manufacturerTF.getText(),Double.valueOf(priceTF.getText())));
                createBTN.setEnabled(false);
            }
        });
        manufacturerTF.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                checkFields();
            }
        });
        priceTF.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(!Character.isDigit(e.getKeyChar()))
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
        Matcher matcher = Pattern.compile("([\"]?[a-zA-ZА-Яa-я]+\\d*[\"]?(\\s?|([-]?))[\"]?[a-zA-ZА-Яa-яєї]+\\d*[\"]?)+").matcher(productNameTF.getText());
        if(!matcher.matches() || productNameTF.getText().length()>20){
            createBTN.setEnabled(false);
            return;
        }
        if(descriptionTA.getText() == null || descriptionTA.getText().equals("")){
            createBTN.setEnabled(false);
            return;
        }
        matcher.reset(manufacturerTF.getText());
        if(!matcher.matches() || manufacturerTF.getText().length()>20){
            createBTN.setEnabled(false);
            return;
        }
        if(priceTF.getText() != null && priceTF.getText().length()==0){
            createBTN.setEnabled(false);
            return;
        }
        createBTN.setEnabled(true);
    }

    public void checkBox() {
        productGroupChooser.removeAllItems();
        for(int i=0;i<Stock.getGroups().size();i++){
            productGroupChooser.addItem(Stock.getGroups().get(i).getName());
        }
    }
}
