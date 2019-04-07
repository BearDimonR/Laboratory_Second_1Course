package GUI.Editing;

import BackGround.GroupOfProduct;
import BackGround.Product;
import BackGround.Stock;
import BackGround.Utilities;
import GUI.General.AppStyles;
import GUI.General.DonePanel;
import GUI.General.TablePanel;
import GUI.MainComponents.TitleBarPanel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductEditingPanel extends JPanel {
    private JLabel btnEdit = new JLabel(new ImageIcon("images/editBTN.jpg"));
    private JLabel btnDesEdit = new JLabel(new ImageIcon("images/deselectedEditBTN.jpg"));
    private JLabel backgroundHeader = new JLabel(new ImageIcon("images/editComponents/productEditHeader.jpg"));
    private JLabel btnFind = new JLabel(new ImageIcon("images/findVerticalBTN.jpg"));
    private JLabel tableBodyBackground = new JLabel(new ImageIcon("images/tableBodyBackground.jpg"));
    private JLabel editFieldsBodyBackground = new JLabel(new ImageIcon("images/editComponents/productEditBody.jpg"));
    //Text fields body elements
    private JTextField tfNewProductName = new JTextField();
    private JTextArea taNewDescription = new JTextArea();
    private JTextField tfOldProductName = new JTextField();
    private JTextArea taOldDescription = new JTextArea();
    private JScrollPane spNewDescription = new JScrollPane(taNewDescription);
    private JScrollPane spOldDescription = new JScrollPane(taOldDescription);
    private JTextField tfOldManufacturer = new JTextField();
    private JTextField tfNewManufacturer = new JTextField();
    private JTextField tfOldPrice = new JTextField();
    private JTextField tfNewPrice = new JTextField();
    private JLabel lbOldGroup = new JLabel();
    private JComboBox<String> cbNewGroup = new JComboBox<String>();
    private static JLabel arrowBack = new JLabel(new ImageIcon("images/editComponents/back.png"));
    //Header elements
    private JTextField tfproductNameSearch = new JTextField();
    private JTextField tfManufacturerSearch = new JTextField();
    private JTextField tfLowestPriceSearch = new JTextField();
    private JTextField tfHighestPriceSearch = new JTextField();
    private JComboBox cbProductGroupSearch = new JComboBox();
    private static JLabel btnModeSwitchOff = new JLabel(new ImageIcon("images/groupCreateModeOffBTN.png"));
    //Table body elements
    private TablePanel tablePanel = new TablePanel(1);

    public ProductEditingPanel() {
        setLayout(AppStyles.gridBagLayout);
        backgroundHeader.setLayout(null);
        editFieldsBodyBackground.setLayout(null);
        tableBodyBackground.setLayout(null);
        editFieldsBodyBackground.setVisible(false);
        tableBodyBackground.setVisible(true);

        tfLowestPriceSearch.addKeyListener(new KeyAdapter(){
            @Override
            public void keyTyped(KeyEvent e){
                if(!Character.isDigit(e.getKeyChar())&&e.getKeyChar()!='.'){
                    e.consume(); }}});
        tfHighestPriceSearch.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(!Character.isDigit(e.getKeyChar())&&e.getKeyChar()!='.'){
                    e.consume();
                }
            }
        });

        setEditDisabled();

        addElementsToProductEditingPanel();
        addMouseListenersToBTNS();

        tablePanel.addDataToGoodsTable(Stock.getAllProducts(), 1);
        tablePanel.getTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (tablePanel.getTable().getSelectedRow() == -1) return;
                tableBodyBackground.setVisible(false);
                editFieldsBodyBackground.setVisible(true);
                tfNewProductName.setText(tablePanel.getSelectedProduct().getProductName());
                tfOldProductName.setText(tablePanel.getSelectedProduct().getProductName());
                taNewDescription.setText(tablePanel.getSelectedProduct().getDescription());
                taOldDescription.setText(tablePanel.getSelectedProduct().getDescription());
                tfOldManufacturer.setText(tablePanel.getSelectedProduct().getManufacturer());
                tfNewManufacturer.setText(tablePanel.getSelectedProduct().getManufacturer());
                tfOldPrice.setText(String.valueOf(tablePanel.getSelectedProduct().getPrice()));
                tfNewPrice.setText(String.valueOf(tablePanel.getSelectedProduct().getPrice()));
                lbOldGroup.setText(String.valueOf(tablePanel.getSelectedProduct().getGroupProducts()));
                ComboBoxModel model = new DefaultComboBoxModel<>();
                ((DefaultComboBoxModel) model).addAll(Stock.getGroups());
                cbNewGroup.setModel(model);
                cbNewGroup.setSelectedItem(tablePanel.getSelectedProduct().getGroupProducts());
            }
        });

        cheakBox();


        setStyleOfHeaderElements();
        setStyleOfUserInputElements();

    }

    private void addElementsToProductEditingPanel() {
        add(backgroundHeader, new GridBagConstraints(0, 0, 1, 1, 1, 0.6,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        add(tableBodyBackground, new GridBagConstraints(0, 1, 1, 1, 1, 0.6,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        add(editFieldsBodyBackground, new GridBagConstraints(0, 1, 1, 1, 1, 0.6,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        addElementsToBackgroundHeader();
        addElementsToBackgroundBody();
        addElementsToTableBackgroundBody();
    }

    private void addElementsToBackgroundBody() {
        editFieldsBodyBackground.add(tfOldProductName);
        editFieldsBodyBackground.add(spOldDescription);
        editFieldsBodyBackground.add(tfNewProductName);
        editFieldsBodyBackground.add(spNewDescription);
        editFieldsBodyBackground.add(lbOldGroup);
        editFieldsBodyBackground.add(cbNewGroup);
        editFieldsBodyBackground.add(tfOldManufacturer);
        editFieldsBodyBackground.add(tfNewManufacturer);
        editFieldsBodyBackground.add(tfOldPrice);
        editFieldsBodyBackground.add(tfNewPrice);
        editFieldsBodyBackground.add(btnEdit);
        editFieldsBodyBackground.add(btnDesEdit);
        editFieldsBodyBackground.add(arrowBack);

        tfOldProductName.setBounds(112, 30, 303, 20);
        spOldDescription.setBounds(112, 86, 303, 122);
        lbOldGroup.setBounds(112, 247, 303, 20);
        tfOldManufacturer.setBounds(112, 310, 303, 20);
        tfOldPrice.setBounds(112, 370, 303, 20);
        arrowBack.setBounds(0, 0, 26, 26);
        tfNewProductName.setBounds(537, 30, 303, 20);
        spNewDescription.setBounds(537, 86, 303, 122);
        cbNewGroup.setBounds(537, 247, 303, 20);
        tfNewManufacturer.setBounds(537, 310, 303, 20);
        tfNewPrice.setBounds(537, 370, 303, 20);
        btnEdit.setBounds(375, 420, 165, 40);

//        tfOldProductName.setBounds(112,30,303,20);
//        spOldDescription.setBounds(112,86,303,122);
//        lbOldGroup.setBounds(112,247,303,20);
//        tfOldManufacturer.setBounds(112,310,303,20);
//        tfOldPrice.setBounds(112,370,303,20);
//        arrowBack. setBounds(20,0,26,26);
//        tfNewProductName.setBounds(537,30,303,20);
//        spNewDescription.setBounds(537,86,303,122);
//        cbNewGroup.setBounds(537,247,303,20);
//        tfNewManufacturer.setBounds(537,310,303,20);
//        tfNewPrice.setBounds(537,370,303,20);
//        btnEdit.setBounds(375,420,165,40);
//        btnDesEdit.setBounds(375,420,165,40);

    }

    private void addElementsToBackgroundHeader() {
        btnFind.setBounds(13, 47, 54, 110);
        backgroundHeader.add(btnFind);
        backgroundHeader.add(tfproductNameSearch);
        backgroundHeader.add(cbProductGroupSearch);
        backgroundHeader.add(tfManufacturerSearch);
        backgroundHeader.add(tfLowestPriceSearch);
        backgroundHeader.add(tfHighestPriceSearch);
        backgroundHeader.add(btnModeSwitchOff);
        btnModeSwitchOff.setBounds(544, 5, 26, 26);

        tfproductNameSearch.setBounds(229, 74, 227, 18);
        tfManufacturerSearch.setBounds(229, 114, 227, 18);
        cbProductGroupSearch.setBounds(648, 74, 227, 17);
        tfLowestPriceSearch.setBounds(649, 114, 60, 18);
        tfHighestPriceSearch.setBounds(756, 114, 60, 18);

    }

    private void addElementsToTableBackgroundBody() {
        tableBodyBackground.add(tablePanel);
        tablePanel.setBounds(35, 20, 850, 441);
    }

    private void addMouseListenersToBTNS() {
        taNewDescription.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                checkFields();
            }
        });
//        btnFind.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                 //метод додавання інформації до таблиці перший параметр - масив груп, другий елемент - тип таблиці (1 - goods, 2-group)
//               // tablePanel.addDataToGroupOFGoodsTable(,1);
//            }
//        });
        btnFind.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String group = (String) String.valueOf(cbProductGroupSearch.getSelectedItem());
                if (tfproductNameSearch.getText().matches("[ ]*") == false ||
                        tfManufacturerSearch.getText().matches("[ ]*") == false ||
                        tfLowestPriceSearch.getText().matches("[ ]*") == false ||
                        tfHighestPriceSearch.getText().matches("[ ]*") == false||
                group.matches("[ ]*") == false

                ){

                    System.out.println("кнопка FIND натиснута  Edit");
                    updateTable();
                }
            }
        });

        arrowBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tableBodyBackground.setVisible(true);
                editFieldsBodyBackground.setVisible(false);
                tablePanel.getTable().clearSelection();
            }
        });
        btnEdit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               // if (!btnEdit.isVisible()) return;
                Product product = tablePanel.getSelectedProduct();
                tablePanel.getTable().clearSelection();
                product.setDescription(taNewDescription.getText());
                product.setPrice(Double.parseDouble(tfNewPrice.getText()));
                product.setManufacturer(tfNewManufacturer.getText());
                product.setGroupProducts((GroupOfProduct) cbNewGroup.getSelectedItem());
                product.setProductName(tfNewProductName.getText());
                Stock.saveData();
                TitleBarPanel.setStats();
                taNewDescription.setText("");
                taOldDescription.setText("");
                tfNewProductName.setText("");
                tfOldProductName.setText("");
                tablePanel.addDataToGoodsTable(Stock.getAllProducts(), 1);
                editFieldsBodyBackground.setVisible(false);
                tableBodyBackground.setVisible(true);
                DonePanel d = new DonePanel();


            }
        });
        btnModeSwitchOff.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                EditingPanel.showGroupEditTab();
            }
        });
        tfNewPrice.addKeyListener(keyListener());
        tfNewManufacturer.addKeyListener(keyListener());
        tfNewProductName.addKeyListener(keyListener());
        taNewDescription.addKeyListener(keyListener());
        cbNewGroup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkFields();
            }
        });
    }

    private KeyListener keyListener() {
        return new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                checkFields();
            }
        };
    }

    /**
     * Method set style of elements which are on header
     */
    private void setStyleOfHeaderElements() {
        tfHighestPriceSearch.setFont(AppStyles.appH2Font);
        tfHighestPriceSearch.setForeground(AppStyles.MainColor);
        tfHighestPriceSearch.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        tfLowestPriceSearch.setFont(AppStyles.appH2Font);
        tfLowestPriceSearch.setForeground(AppStyles.MainColor);
        tfLowestPriceSearch.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        tfManufacturerSearch.setFont(AppStyles.appH2Font);
        tfManufacturerSearch.setForeground(AppStyles.MainColor);
        tfManufacturerSearch.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        tfproductNameSearch.setFont(AppStyles.appH2Font);
        tfproductNameSearch.setForeground(AppStyles.MainColor);
        tfproductNameSearch.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        cbProductGroupSearch.setBackground(Color.WHITE);
        cbProductGroupSearch.setFont(AppStyles.appH2Font);
        cbProductGroupSearch.setForeground(AppStyles.MainColor);
        cbProductGroupSearch.setUI(new BasicComboBoxUI());
    }

    /**
     * Method set style of elements which are on header
     */
    private void setStyleOfUserInputElements() {
        tfOldProductName.setFont(AppStyles.appH2Font);
        tfOldProductName.setForeground(AppStyles.MainColor);
        tfOldProductName.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        lbOldGroup.setFont(AppStyles.appH2Font);
        lbOldGroup.setForeground(AppStyles.MainColor);
        lbOldGroup.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        tfOldPrice.setFont(AppStyles.appH2Font);
        tfOldPrice.setForeground(AppStyles.MainColor);
        tfOldPrice.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        tfOldManufacturer.setFont(AppStyles.appH2Font);
        tfOldManufacturer.setForeground(AppStyles.MainColor);
        tfOldManufacturer.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        taOldDescription.setFont(AppStyles.appH2Font);
        taOldDescription.setForeground(AppStyles.MainColor);
        spOldDescription.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        tfNewProductName.setFont(AppStyles.appH2Font);
        tfNewProductName.setForeground(AppStyles.MainColor);
        tfNewProductName.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        tfNewManufacturer.setFont(AppStyles.appH2Font);
        tfNewManufacturer.setForeground(AppStyles.MainColor);
        tfNewManufacturer.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        taNewDescription.setFont(AppStyles.appH2Font);
        taNewDescription.setForeground(AppStyles.MainColor);
        spNewDescription.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        tfNewManufacturer.setFont(AppStyles.appH2Font);
        tfNewManufacturer.setForeground(AppStyles.MainColor);
        tfNewManufacturer.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        tfNewPrice.setFont(AppStyles.appH2Font);
        tfNewPrice.setForeground(AppStyles.MainColor);
        tfNewPrice.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        cbNewGroup.setBackground(Color.WHITE);
        cbNewGroup.setFont(AppStyles.appH2Font);
        cbNewGroup.setForeground(AppStyles.MainColor);
        cbNewGroup.setUI(new BasicComboBoxUI());
    }
    /**
     * Method set edit button in disabled mode
     */
    private void setEditEnable() {
        btnEdit.setVisible(true);
        btnDesEdit.setVisible(false);
    }

    /**
     * Method set edit button in disabled mode
     */
    private void setEditDisabled() {
        btnEdit.setVisible(false);
        btnDesEdit.setVisible(true);
    }
    TablePanel getTablePanel() {
        return tablePanel;
    }

    private void checkFields() {
        Matcher matcher = Pattern.compile("([\"]?[a-zA-ZА-Яa-я]+\\d*[\"]?(\\s?|([-]?))[\"]?[a-zA-ZА-Яa-яєї]+\\d*[\"]?)+").matcher(tfNewProductName.getText());
        if (!matcher.matches() || tfNewProductName.getText().length() > 20) {
            setEditDisabled();
            return;
        }
        if (Stock.findProductByName(tfNewProductName.getText()) != null){
            if(Stock.findProductByName(tfNewProductName.getText()) != tablePanel.getSelectedProduct()) {
                setEditDisabled();
                return;
            }
        }
        if (taNewDescription.getText() == null || taNewDescription.getText().equals("")) {
            setEditDisabled();
            return;
        }
        matcher.reset(tfNewManufacturer.getText());
        if (!matcher.matches() || tfNewManufacturer.getText().length() > 20) {
            setEditDisabled();
            return;
        }
        if (tfNewPrice.getText() != null && tfNewPrice.getText().length() == 0) {
            setEditDisabled();
            return;
        }
        setEditEnable();
    }

    public void cheakBox() {
        cbProductGroupSearch.removeAllItems();
        for (int i = 0; i < Stock.getGroups().size(); i++) {
            cbProductGroupSearch.addItem((Stock.getGroups().get(i).getName()));
        }
    }

    private void updateTable() {
        String group = (String) cbProductGroupSearch.getSelectedItem();
        String product = tfproductNameSearch.getText();
        String manufacturer = tfManufacturerSearch.getText();
        String priceFrom = tfLowestPriceSearch.getText();
        String priceTo = tfHighestPriceSearch.getText();

        double prFrom = 0;
        if (tfLowestPriceSearch.getText().matches("[ ]*") == true) {
            prFrom = 0;
        } else if (tfLowestPriceSearch.getText().matches("[\\d]+[.]?[\\d]*") == true) {
            prFrom = Double.valueOf(priceFrom);
        }

        double prTo = 150;
        if (tfHighestPriceSearch.getText().equals(""))
            prTo = 0;
        else prTo = Double.parseDouble(tfHighestPriceSearch.getText());
        tablePanel.addDataToGoodsTable(Utilities.mainSearch(group, product, manufacturer, prFrom, prTo), 1);
        //tablePanel.addDataToGoodsTable(Stock.getAllProducts(),1);
        System.out.println("price From= " + prFrom);
        System.out.println("price to='" + prTo + "'");
    }


}
