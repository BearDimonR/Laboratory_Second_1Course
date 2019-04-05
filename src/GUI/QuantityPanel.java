package GUI;

import BackGround.Stock;
import BackGround.Utilities;
import GUI.General.TablePanel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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
    private JTextField tfAddToStock = new JTextField();
    private JTextField tfRemoveFromStock = new JTextField();
    private JTextField tfInStock = new JTextField();

    //Header elements
    private JTextField tfProductNameSearch = new JTextField();
    private JTextField tfManufacturerSearch = new JTextField();
    private JTextField tfLowestPriceearch = new JTextField();
    private JTextField tfHighestPriceSearch = new JTextField();
    private JComboBox cbProductGroupSearch = new JComboBox();
//
//    String group = cbProductGroupSearch.getToolTipText();
//    String product = tfProductNameSearch.getText();
//    String manufacturer = tfManufacturerSearch.getText();
    //double priceFrom = Double.valueOf(tfLowestPriceearch.getText());
   // double priceTo = Double.valueOf(tfHighestPriceSearch.getText());

   // private TablePanel tablePanel = new TablePanel(1);

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
cheakBox();
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
        background.add(tfLowestPriceearch);
        background.add(tfHighestPriceSearch);
        background.add(cbProductGroupSearch);
        background.add(tablePanel);

        tfProductNameSearch.setBounds(224, 42, 234, 18);
        tfManufacturerSearch.setBounds(224, 82, 234, 18);
        tfLowestPriceearch.setBounds(645, 82, 65, 18);
        tfHighestPriceSearch.setBounds(752, 82, 65, 18);
        cbProductGroupSearch.setBounds(645, 42, 234, 18);
        tablePanel.setBounds(23, 148, 659, 494);


        background.setBounds(0, 0, 914, 666);
        btnFind.setBounds(15, 16, 54, 110);
        btnAddMinus.setBounds(709, 326, 26, 26);
        btnRemoveMinus.setBounds(709, 453, 26, 26);
        btnAddPlus.setBounds(871, 326, 26, 26);
        btnRemovePlus.setBounds(871, 453, 26, 26);
        btnChange.setBounds(749, 580, 108, 26);
        tfAddToStock.setBounds(748, 330, 110, 22);
        tfRemoveFromStock.setBounds(748, 453, 110, 22);
        tfInStock.setBounds(748, 228, 110, 22);
        tfAddToStock.setText(String.valueOf(addAmount));
        tfAddToStock.setHorizontalAlignment(0);
        tfAddToStock.setEditable(false);
        tfRemoveFromStock.setText(String.valueOf(removeAmount));
        tfRemoveFromStock.setHorizontalAlignment(0);
        tfRemoveFromStock.setEditable(false);
        btnAddPlus.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(tablePanel.getSelectedProduct() == null) return;
                addAmount++;
                tfAddToStock.setText(String.valueOf(addAmount));
            }
        });
        btnAddMinus.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(tablePanel.getSelectedProduct() == null) return;
                if(addAmount == 0) return;
                addAmount--;
                tfAddToStock.setText(String.valueOf(addAmount));
            }
        });
        btnRemovePlus.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(tablePanel.getSelectedProduct() == null) return;
                if(removeAmount == Integer.parseInt(tfInStock.getText())) return;
                removeAmount++;
                tfRemoveFromStock.setText(String.valueOf(removeAmount));
            }
        });
        btnRemoveMinus.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(tablePanel.getSelectedProduct() == null) return;
                if(removeAmount == 0) return;
                removeAmount--;
                tfRemoveFromStock.setText(String.valueOf(removeAmount));
            }
        });
        btnChange.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(tablePanel.getSelectedProduct() == null) return;
                tablePanel.getSelectedProduct().setQuantityInStock(Integer.parseInt(tfInStock.getText()) + addAmount - removeAmount);
                Stock.saveData();
                checkStock();
                addAmount = 0;
                removeAmount = 0;
                tfAddToStock.setText(String.valueOf(addAmount));
                tfRemoveFromStock.setText(String.valueOf(removeAmount));
            }
        });

        btnFind.addMouseListener(new MouseAdapter(){
            @Override

            public void mouseClicked(MouseEvent e){

                if(tfProductNameSearch.getText().matches("[ ]*")==false||
                        tfManufacturerSearch.getText().matches("[ ]*")==false||
                        tfLowestPriceearch.getText().matches("[ ]*")==false||
                        tfHighestPriceSearch.getText().matches("[ ]*")==false
                      //  cbProductGroupSearch.getText().matches("[ ]*")==false
                ){

                    updateTable();

                }
            }
        });



    }


    public  void updateTable() {
        String group = cbProductGroupSearch.getToolTipText();
        String product = tfProductNameSearch.getText();
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
    private void checkStock() {
        if(tablePanel.getSelectedProduct() == null) return;
        if(tablePanel.getSelectedProduct().getQuantityInStock() == Integer.parseInt(tfInStock.getText())) return;
        tfInStock.setText(String.valueOf(tablePanel.getSelectedProduct().getQuantityInStock()));
    }
    public void cheakBox(){
        cbProductGroupSearch.removeAllItems();
        for(int i = 0; i< Stock.getGroups().size();i++){
            cbProductGroupSearch.addItem((Stock.getGroups().get(i).getName()));
        }
    }
}
