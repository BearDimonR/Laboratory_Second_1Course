package GUI.Creating;

import BackGround.Product;
import BackGround.Stock;
import GUI.General.AppStyles;
import GUI.General.DonePanel;
import GUI.MainComponents.TitleBarPanel;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductCreatePanel extends JPanel {
    private JLabel btnCreate = new JLabel(new ImageIcon("images/createBTN.jpg"));
    private JLabel btnDesCreate = new JLabel(new ImageIcon("images/deselectedCreateBTN.jpg"));
    private JLabel background = new JLabel(new ImageIcon("images/createComponents/productCreateBackground.jpg"));
    private JTextField tfProductName = new JTextField("");
    private JTextField tfManufacturer = new JTextField("");
    private JTextField tfPrice = new JTextField("");
    private JTextArea taDescription = new JTextArea("");
    private JComboBox cbProductGroup = new JComboBox();
    private JScrollPane spDescription = new JScrollPane(taDescription);

    public ProductCreatePanel() {
        setCreateDisabled();
        setLayout(AppStyles.gridBagLayout);
        background.setLayout(null);
        setStylesOfUserInputFields();
        addElementsOnProductPanel();
        addListenerToCreateBTN();
        addListenerToUserInputFields();
        setDefaultTextToTF();
        checkBox();

    }

    /**
     * Method sets styles of all text areas and text field
     * which are situated on product creation panel
     */
    private void setStylesOfUserInputFields() {
        //tfProductName
        tfProductName.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        tfProductName.setFont(AppStyles.appH1Font);
        tfProductName.setForeground(AppStyles.DeselectedColor);

        //taDescription
        taDescription.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        taDescription.setFont(AppStyles.appH1Font);
        taDescription.setForeground(AppStyles.DeselectedColor);
        spDescription.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        //tfManufacturer
        tfManufacturer.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        tfManufacturer.setFont(AppStyles.appH1Font);
        tfManufacturer.setForeground(AppStyles.DeselectedColor);
        //tfPrice
        tfPrice.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        tfPrice.setFont(AppStyles.appH1Font);
        tfPrice.setForeground(AppStyles.DeselectedColor);
        //cbProductGroup
        cbProductGroup.setBackground(Color.WHITE);
        cbProductGroup.setUI(new BasicComboBoxUI());
        cbProductGroup.setFont(AppStyles.appH1Font);
        cbProductGroup.setForeground(AppStyles.MainColor);
    }

    /**
     * Method adds elements on product creation panel
     */
    private void addElementsOnProductPanel() {
        //Add background
        add(background);
        background.setVisible(true);
        background.setBounds(0, 0, 914, 666);
        //Add elements on background
        background.add(tfProductName);
        background.add(spDescription);
        background.add(cbProductGroup);
        background.add(tfManufacturer);
        background.add(tfPrice);
        background.add(btnCreate);
        background.add(btnDesCreate);
        tfProductName.setBounds(250, 101, 445, 30);
        spDescription.setBounds(253, 174, 438, 135);
        cbProductGroup.setBounds(250, 351, 445, 30);
        tfManufacturer.setBounds(250, 421, 445, 30);
        tfPrice.setBounds(250, 491, 445, 30);
        btnCreate.setBounds(375, 578, 165, 40);
        btnDesCreate.setBounds(375, 578, 165, 40);
    }

    /**
     * Method adds listener to creation btn img
     */
    private void addListenerToCreateBTN() {

        btnCreate.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Stock.getGroups().get(cbProductGroup.getSelectedIndex()).addProduct(new Product(Stock.getGroups().get(cbProductGroup.getSelectedIndex()),
                        tfProductName.getText(), tfManufacturer.getText(), Double.valueOf(tfPrice.getText())));
                Stock.saveData();
                TitleBarPanel.setStats();
                setDefaultTextToTF();
                setAllFieldsForegroundDeselected();
                setFocusOnNameTF();
                setCreateDisabled();
                DonePanel d =new DonePanel();
            }
        });

    }

    /**
     * Method adds listeners to user input fields
     */
    private void addListenerToUserInputFields() {
        //Listner-checker of product name text field
        tfProductName.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                checkFields();
            }
        });

        //Set tips to product name text field
        tfProductName.addFocusListener(new FocusListener() {

            public void focusGained(FocusEvent e) {
                tfProductName.setForeground(AppStyles.MainColor);
                if (tfProductName.getText().equals("Product name"))
                    tfProductName.setText("");
            }

            public void focusLost(FocusEvent e) {
                if (checkIfEmpty(tfProductName.getText())) {
                    tfProductName.setText("Product name");
                    tfProductName.setForeground(AppStyles.DeselectedColor);
                } else {
                    tfProductName.setForeground(AppStyles.MainColor);
                }


            }
        });

        //Listener-checker of product group combo box
        cbProductGroup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkFields();
            }
        });

        //Listener-checker of product description text area
        taDescription.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                checkFields();
            }
        });

        //set tips to product description text area
        taDescription.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                taDescription.setForeground(AppStyles.MainColor);
                if (taDescription.getText().equals("Product description"))
                    taDescription.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (checkIfEmpty(taDescription.getText())) {
                    taDescription.setText("Product description");
                    taDescription.setForeground(AppStyles.DeselectedColor);
                } else {
                    taDescription.setForeground(AppStyles.MainColor);
                }
            }
        });

        //Listener-checker of manufacturer text field
        tfManufacturer.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                checkFields();
            }
        });

        //set tips to product manufacturer text area
        tfManufacturer.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                tfManufacturer.setForeground(AppStyles.MainColor);
                if (tfManufacturer.getText().equals("Product manufacturer"))
                    tfManufacturer.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (checkIfEmpty(tfManufacturer.getText())) {
                    tfManufacturer.setText("Product manufacturer");
                    tfManufacturer.setForeground(AppStyles.DeselectedColor);
                } else {
                    tfManufacturer.setForeground(AppStyles.MainColor);
                }
            }
        });

        //Listener-checker of price tf
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

        //set tips to product price text area
        tfPrice.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                tfPrice.setForeground(AppStyles.MainColor);
                if (tfPrice.getText().equals("Product price"))
                    tfPrice.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (checkIfEmpty(tfPrice.getText())) {
                    tfPrice.setText("Product price");
                    tfPrice.setForeground(AppStyles.DeselectedColor);
                } else {
                    tfPrice.setForeground(AppStyles.MainColor);
                }
            }
        });
    }

    /**
     * Method which check if fields are filled properly
     */
    private void checkFields() {
        Matcher matcher = Pattern.compile("([\"]?[a-zA-ZА-Яa-я]+\\d*[\"]?(\\s?|([-]?))[\"]?[a-zA-ZА-Яa-яєї]+\\d*[\"]?)+").matcher(tfProductName.getText());
        if (!matcher.matches() || tfProductName.getText().length() > 20) {
            setCreateDisabled();
            return;
        }
        if (Stock.findProductByName(tfProductName.getText()) != null) {
            setCreateDisabled();
            return;
        }
        if (taDescription.getText() == null || taDescription.getText().equals("")) {
            setCreateDisabled();
            return;
        }
        matcher.reset(tfManufacturer.getText());
        if (!matcher.matches() || tfManufacturer.getText().length() > 20) {
            setCreateDisabled();
            return;
        }
        if (tfPrice.getText() != null && tfPrice.getText().length() == 0) {
            setCreateDisabled();
            return;
        }
        if (tfProductName.getText().equals("Product name") || tfPrice.getText().equals("Product price") || taDescription.getText().equals("Product description") || tfManufacturer.getText().equals("Product manufacturer")) {
            setCreateDisabled();
            return;
        }
        setCreateEnable();

    }

    /**
     * Method which filles combo box with groups
     */
    public void checkBox() {
        cbProductGroup.removeAllItems();
        for (int i = 0; i < Stock.getGroups().size(); i++) {
            cbProductGroup.addItem(Stock.getGroups().get(i).getName());
        }
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
        taDescription.requestFocusInWindow();
        tfPrice.requestFocusInWindow();
        tfManufacturer.requestFocusInWindow();
        tfProductName.requestFocusInWindow();
    }

    /**
     * Method set all fields foreground deselected
     */
    private void setAllFieldsForegroundDeselected() {
        tfProductName.setForeground(AppStyles.DeselectedColor);
        taDescription.setForeground(AppStyles.DeselectedColor);
        tfManufacturer.setForeground(AppStyles.DeselectedColor);
        tfPrice.setForeground(AppStyles.DeselectedColor);
    }

    /**
     * Method set default text to text fields
     */
    private void setDefaultTextToTF() {
        tfProductName.setText("Product name");
        taDescription.setText("Product description");
        tfManufacturer.setText("Product manufacturer");
        tfPrice.setText("Product price");
    }

    /**

     */
    public void cheakBox(){
        cbProductGroup.removeAllItems();
        for(int i = 0; i< Stock.getGroups().size();i++){
            cbProductGroup.addItem((Stock.getGroups().get(i).getName()));
        }
    }
}
