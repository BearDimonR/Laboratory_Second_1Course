package GUI.Editing;

import BackGround.GroupOfProduct;
import BackGround.Product;
import BackGround.Stock;
import BackGround.Utilities;
import GUI.General.AppStyles;
import GUI.General.TablePanel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static GUI.Deleting.DeletingPanel.updateTable;

public class ProductEditingPanel extends JPanel {
    private JLabel btnEdit = new JLabel(new ImageIcon("images/editBTN.jpg"));
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
    private JComboBox<String> cbOldGroup = new JComboBox<>();
    private JComboBox<String> cbNewGroup = new JComboBox<String>();
    private static JLabel arrowBack = new JLabel(new ImageIcon("images/editComponents/back.png"));
    //Header elements
    private JTextField tfproductNameSearch = new JTextField();
    private JTextField tfManufacturerSearch = new JTextField();
    private JTextField tfLowestPriceearch = new JTextField();
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
        //to change enable
        btnEdit.setEnabled(false);

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
                cbOldGroup.addItem(String.valueOf(tablePanel.getSelectedProduct().getGroupProducts()));
                cbOldGroup.setSelectedIndex(0);
                ComboBoxModel model = new DefaultComboBoxModel<>();
                ((DefaultComboBoxModel) model).addAll(Stock.getGroups());
                cbNewGroup.setModel(model);
                cbNewGroup.setSelectedItem(tablePanel.getSelectedProduct().getGroupProducts());
            }
        });
        cheakBox();
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
        editFieldsBodyBackground.add(cbOldGroup);
        editFieldsBodyBackground.add(cbNewGroup);
        editFieldsBodyBackground.add(tfOldManufacturer);
        editFieldsBodyBackground.add(tfNewManufacturer);
        editFieldsBodyBackground.add(tfOldPrice);
        editFieldsBodyBackground.add(tfNewPrice);
        editFieldsBodyBackground.add(btnEdit);
        editFieldsBodyBackground.add(arrowBack);
        tfOldProductName.setBounds(112, 30, 303, 20);
        spOldDescription.setBounds(112, 86, 303, 122);
        cbOldGroup.setBounds(112, 247, 303, 20);
        tfOldManufacturer.setBounds(112, 310, 303, 20);
        tfOldPrice.setBounds(112, 370, 303, 20);
        arrowBack.setBounds(0, 0, 26, 26);
        tfNewProductName.setBounds(537, 30, 303, 20);
        spNewDescription.setBounds(537, 86, 303, 122);
        cbNewGroup.setBounds(537, 247, 303, 20);
        tfNewManufacturer.setBounds(537, 310, 303, 20);
        tfNewPrice.setBounds(537, 370, 303, 20);
        btnEdit.setBounds(375, 420, 165, 40);
    }

    private void addElementsToBackgroundHeader() {
        btnFind.setBounds(13, 47, 54, 110);
        backgroundHeader.add(btnFind);
        backgroundHeader.add(tfproductNameSearch);
        backgroundHeader.add(cbProductGroupSearch);
        backgroundHeader.add(tfManufacturerSearch);
        backgroundHeader.add(tfLowestPriceearch);
        backgroundHeader.add(tfHighestPriceSearch);
        backgroundHeader.add(btnModeSwitchOff);
        btnModeSwitchOff.setBounds(544, 5, 26, 26);
        tfproductNameSearch.setBounds(229, 74, 227, 18);
        tfManufacturerSearch.setBounds(229, 114, 227, 18);
        cbProductGroupSearch.setBounds(648, 74, 227, 17);
        tfLowestPriceearch.setBounds(649, 114, 60, 18);
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
//                 //РјРµС‚РѕРґ РґРѕРґР°РІР°РЅРЅСЏ С–РЅС„РѕСЂРјР°С†С–С— РґРѕ С‚Р°Р±Р»РёС†С– РїРµСЂС€РёР№ РїР°СЂР°РјРµС‚СЂ - РјР°СЃРёРІ РіСЂСѓРї, РґСЂСѓРіРёР№ РµР»РµРјРµРЅС‚ - С‚РёРї С‚Р°Р±Р»РёС†С– (1 - goods, 2-group)
//               // tablePanel.addDataToGroupOFGoodsTable(,1);
//            }
//        });
        btnFind.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String group = (String) String.valueOf(cbProductGroupSearch.getSelectedItem());
                if (tfproductNameSearch.getText().matches("[ ]*") == false ||
                        tfManufacturerSearch.getText().matches("[ ]*") == false ||
                        tfLowestPriceearch.getText().matches("[ ]*") == false ||
                        tfHighestPriceSearch.getText().matches("[ ]*") == false||
                        group.matches("[ ]*") == false
                ){

                    System.out.println("РєРЅРѕРїРєР° FIND РЅР°С‚РёСЃРЅСѓС‚Р°  Edit");
                    updateTable();
                }
            }
        });

        arrowBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tableBodyBackground.setVisible(true);
                editFieldsBodyBackground.setVisible(false);
            }
        });
        btnEdit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!btnEdit.isVisible()) return;
                Product product = tablePanel.getSelectedProduct();
                tablePanel.getTable().clearSelection();
                product.setDescription(taNewDescription.getText());
                product.setPrice(Double.parseDouble(tfNewPrice.getText()));
                product.setManufacturer(tfNewManufacturer.getText());
                product.setGroupProducts((GroupOfProduct) cbNewGroup.getSelectedItem());
                product.setProductName(tfNewProductName.getText());
                Stock.saveData();
                taNewDescription.setText("");
                taOldDescription.setText("");
                tfNewProductName.setText("");
                tfOldProductName.setText("");
                tablePanel.addDataToGoodsTable(Stock.getAllProducts(), 1);
                editFieldsBodyBackground.setVisible(false);
                tableBodyBackground.setVisible(true);
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
        cbNewGroup.addKeyListener(keyListener());
    }

    private KeyListener keyListener() {
        return new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                checkFields();
            }
        };
    }

    TablePanel getTablePanel() {
        return tablePanel;
    }

    private void checkFields() {
        //to change enable
        Matcher matcher = Pattern.compile("([\"]?[a-zA-ZА-Яa-я]+\\d*[\"]?(\\s?|([-]?))[\"]?[a-zA-ZА-Яa-яєї]+\\d*[\"]?)+").matcher(tfNewProductName.getText());
        if (!matcher.matches() || tfNewProductName.getText().length() > 20) {
            btnEdit.setEnabled(false);
            return;
        }
        if (Stock.findProductByName(tfNewProductName.getText()) != null) {
            btnEdit.setEnabled(false);
            return;
        }
        if (taNewDescription.getText() == null || taNewDescription.getText().equals("")) {
            btnEdit.setEnabled(false);
            return;
        }
        matcher.reset(tfNewManufacturer.getText());
        if (!matcher.matches() || tfNewManufacturer.getText().length() > 20) {
            btnEdit.setEnabled(false);
            return;
        }
        if (tfNewPrice.getText() != null && tfNewPrice.getText().length() == 0) {
            btnEdit.setEnabled(false);
            return;
        }
        btnEdit.setEnabled(true);
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
        String priceFrom = tfLowestPriceearch.getText();
        String priceTo = tfHighestPriceSearch.getText();

        double prFrom = 0;
        if (tfLowestPriceearch.getText().matches("[ ]*") == true) {
            prFrom = 0;
        } else if (tfLowestPriceearch.getText().matches("[\\d]+[.]?[\\d]*") == true) {
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
