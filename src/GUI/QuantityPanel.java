package GUI;

import BackGround.Stock;
import BackGround.Utilities;
import GUI.General.AppStyles;
import GUI.General.DonePanel;
import GUI.General.ProblemPanel;
import GUI.General.TablePanel;
import GUI.MainComponents.TitleBarPanel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class QuantityPanel extends JPanel {
    private static int addAmount;
    private static int removeAmount;
    private JLabel background = new JLabel(new ImageIcon("images/quantityBackground.jpg"));
    private JLabel btnFind = new JLabel(new ImageIcon("images/findVerticalBTN.jpg"));
    private TablePanel tablePanel = new TablePanel(1);

    //Sub tool bar elements
    private JLabel btnAddPlus = new JLabel(new ImageIcon("images/plusBTN.png"));
    private JLabel btnAddMinus = new JLabel(new ImageIcon("images/minusBTN.png"));
    private JLabel btnRemoveMinus = new JLabel(new ImageIcon("images/minusBTN.png"));
    private JLabel btnRemovePlus = new JLabel(new ImageIcon("images/plusBTN.png"));
    private JLabel btnChange = new JLabel(new ImageIcon("images/changeBTN.jpg"));
    private JLabel tfAddToStock = new JLabel();
    private JLabel tfRemoveFromStock = new JLabel();
    private JLabel tfInStock = new JLabel();

    //Header elements
    private JTextField tfProductNameSearch = new JTextField();
    private JTextField tfManufacturerSearch = new JTextField();
    private JTextField tfLowestPriceSearch = new JTextField();
    private JTextField tfHighestPriceSearch = new JTextField();
    private JComboBox cbProductGroupSearch = new JComboBox();

    public QuantityPanel() {
        setLayout(null);
        background.setLayout(null);
        add(background);
        background.add(btnFind);
        background.add(btnAddMinus);
        background.add(btnAddPlus);
        background.add(btnRemoveMinus);
        background.add(btnRemovePlus);
        background.add(btnChange);
        background.add(tfAddToStock);
        background.add(tfRemoveFromStock);
        background.add(tfInStock);
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
        //  updateTable();
        tablePanel.addDataToGoodsTable(Stock.getAllProducts(), 1);
        tablePanel.getTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                tfInStock.setText("0");
                checkStock();
//                if (tablePanel.getTable().getSelectedRow() == -1) return;
//                tableBodyBackground.setVisible(false);
//                editFieldsBodyBackground.setVisible(true);
//                tfNewProductName.setText(tablePanel.getSelectedProduct().getProductName());
//                tfOldProductName.setText(tablePanel.getSelectedProduct().getProductName());
//                taNewDescription.setText(tablePanel.getSelectedProduct().getDescription());
//                taOldDescription.setText(tablePanel.getSelectedProduct().getDescription());
//                tfOldManufacturer.setText(tablePanel.getSelectedProduct().getManufacturer());
//                tfNewManufacturer.setText(tablePanel.getSelectedProduct().getManufacturer());
//                tfOldPrice.setText(String.valueOf(tablePanel.getSelectedProduct().getPrice()));
//                tfNewPrice.setText(String.valueOf(tablePanel.getSelectedProduct().getPrice()));
//                cbOldGroup.addItem(String.valueOf(tablePanel.getSelectedProduct().getGroupProducts()));
//                cbOldGroup.setSelectedIndex(0);
//                ComboBoxModel model = new DefaultComboBoxModel<>();
//                ((DefaultComboBoxModel) model).addAll(Stock.getGroups());
//                cbNewGroup.setModel(model);
//                cbNewGroup.setSelectedItem(tablePanel.getSelectedProduct().getGroupProducts());
            }
        });


        background.add(tfProductNameSearch);
        background.add(tfManufacturerSearch);
        background.add(tfLowestPriceSearch);
        background.add(tfHighestPriceSearch);
        background.add(cbProductGroupSearch);
        background.add(tablePanel);

        tfProductNameSearch.setBounds(229, 42, 227, 18);
        tfManufacturerSearch.setBounds(229, 82, 227, 18);
        cbProductGroupSearch.setBounds(648, 43, 227, 17);
        tfLowestPriceSearch.setBounds(649, 82, 60, 18);
        tfHighestPriceSearch.setBounds(756, 82, 60, 18);
        tablePanel.setBounds(23, 148, 659, 494);

        background.setBounds(0, 0, 914, 666);
        btnFind.setBounds(15, 16, 54, 110);
        btnAddMinus.setBounds(709, 326, 26, 26);
        btnRemoveMinus.setBounds(709, 453, 26, 26);
        btnAddPlus.setBounds(871, 326, 26, 26);
        btnRemovePlus.setBounds(871, 453, 26, 26);
        btnChange.setBounds(749, 580, 108, 26);
        tfAddToStock.setBounds(750, 329, 105, 19);
        tfRemoveFromStock.setBounds(749, 456, 105, 19);
        tfInStock.setBounds(750, 230, 105, 20);
        tfAddToStock.setText(String.valueOf(addAmount));
        tfAddToStock.setHorizontalAlignment(0);
        tfRemoveFromStock.setText(String.valueOf(removeAmount));
        tfRemoveFromStock.setHorizontalAlignment(0);
        tfInStock.setHorizontalAlignment(0);
//        System.out.println("group = " + cbProductGroupSearch.getSelectedItem());
//        System.out.println("group = " + (String) String.valueOf(cbProductGroupSearch.getSelectedItem()));
//        System.out.println("group = " + (String) cbProductGroupSearch.getSelectedItem());
        btnAddPlus.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (tablePanel.getSelectedProduct() == null) return;
                addAmount++;
                tfAddToStock.setText(String.valueOf(addAmount));
            }
        });
        btnAddMinus.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (tablePanel.getSelectedProduct() == null) return;
                if (addAmount == 0) return;
                addAmount--;
                tfAddToStock.setText(String.valueOf(addAmount));
            }
        });
        btnRemovePlus.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (tablePanel.getSelectedProduct() == null) return;
                if (removeAmount == Integer.parseInt(tfInStock.getText())) return;
                removeAmount++;
                tfRemoveFromStock.setText(String.valueOf(removeAmount));
            }
        });
        btnRemoveMinus.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (tablePanel.getSelectedProduct() == null) return;
                if (removeAmount == 0) return;
                removeAmount--;
                tfRemoveFromStock.setText(String.valueOf(removeAmount));
            }
        });
        btnChange.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(tablePanel.getSelectedProduct() == null){
                    ProblemPanel p = new ProblemPanel();
                    return;
                }
                tablePanel.getSelectedProduct().setQuantityInStock(Integer.parseInt(tfInStock.getText()) + addAmount - removeAmount);
                Stock.saveData();
                TitleBarPanel.setStats();
                checkStock();
                addAmount = 0;
                removeAmount = 0;
                tfAddToStock.setText(String.valueOf(addAmount));
                tfRemoveFromStock.setText(String.valueOf(removeAmount));
                DonePanel d = new DonePanel();

            }
        });

        btnFind.addMouseListener(new MouseAdapter() {
            @Override

            public void mouseClicked(MouseEvent e) {
                System.out.println("group = " + cbProductGroupSearch.getSelectedItem());
                System.out.println("group = " + (String) String.valueOf(cbProductGroupSearch.getSelectedItem()));
                System.out.println("group = " + (String) cbProductGroupSearch.getSelectedItem());
                String group = (String) String.valueOf(cbProductGroupSearch.getSelectedItem());
                if (tfProductNameSearch.getText().matches("[ ]*") == false ||
                        tfManufacturerSearch.getText().matches("[ ]*") == false ||
                        tfLowestPriceSearch.getText().matches("[ ]*") == false ||
                        tfHighestPriceSearch.getText().matches("[ ]*") == false||
                        group.matches("[ ]*")==false
                ) {

                    updateTable();

                }
            }
        });


        cheakBox();

        setStyleOfHeader();
    }
    public void cheakBox() {
        cbProductGroupSearch.removeAllItems();
        for (int i = 0; i < Stock.getGroups().size(); i++) {
            cbProductGroupSearch.addItem((Stock.getGroups().get(i).getName()));
        }
    }

    private void updateTable() {
        String group = (String) cbProductGroupSearch.getSelectedItem();
        String product = tfProductNameSearch.getText();
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

    private void checkStock() {
        if (tablePanel.getSelectedProduct() == null) return;
        if (tablePanel.getSelectedProduct().getQuantityInStock() == Integer.parseInt(tfInStock.getText())) return;
        tfInStock.setText(String.valueOf(tablePanel.getSelectedProduct().getQuantityInStock()));
    }



    private void setStyleOfHeader() {
        tfHighestPriceSearch.setFont(AppStyles.appH2Font);
        tfHighestPriceSearch.setForeground(AppStyles.MainColor);
        tfHighestPriceSearch.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        tfLowestPriceSearch.setFont(AppStyles.appH2Font);
        tfLowestPriceSearch.setForeground(AppStyles.MainColor);
        tfLowestPriceSearch.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        tfManufacturerSearch.setFont(AppStyles.appH2Font);
        tfManufacturerSearch.setForeground(AppStyles.MainColor);
        tfManufacturerSearch.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        tfProductNameSearch.setFont(AppStyles.appH2Font);
        tfProductNameSearch.setForeground(AppStyles.MainColor);
        tfProductNameSearch.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        cbProductGroupSearch.setBackground(Color.WHITE);
        cbProductGroupSearch.setFont(AppStyles.appH2Font);
        cbProductGroupSearch.setForeground(AppStyles.MainColor);
        cbProductGroupSearch.setUI(new BasicComboBoxUI());
    }

    private void setStyleOfBOdy() {
        tfInStock.setFont(AppStyles.appH2Font);
        tfInStock.setForeground(AppStyles.MainColor);
        tfInStock.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        tfAddToStock.setFont(AppStyles.appH2Font);
        tfAddToStock.setForeground(AppStyles.MainColor);
        tfAddToStock.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        tfRemoveFromStock.setFont(AppStyles.appH2Font);
        tfRemoveFromStock.setForeground(AppStyles.MainColor);
        tfRemoveFromStock.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

    }


}
