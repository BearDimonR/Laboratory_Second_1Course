package GUI.Deleting;

import BackGround.Stock;
import GUI.General.TablePanel;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ProductDeletingPanel extends JPanel {
    JLabel backgroundHeader = new JLabel(new ImageIcon("images/deleteComponents/productDeleteHeader.jpg"));
    JLabel tableBackground = new JLabel(new ImageIcon("images/tableBodyBackground.jpg"));
    private static JLabel modeSwitchOff = new JLabel(new ImageIcon("images/groupCreateModeOffBTN.png"));
    private TablePanel tablePanel = new TablePanel(2);
    JLabel btnDelete = new JLabel(new ImageIcon("images/createBTN.jpg"));
    JLabel btnFind = new JLabel(new ImageIcon("images/findVerticalBTN.jpg"));
    //Header elements
    private JTextField tfproductNameSearch = new JTextField();
    private JTextField tfManufacturerSearch = new JTextField();
    private JTextField tfLowestPriceearch = new JTextField();
    private JTextField tfHighestPriceSearch = new JTextField();
    private JComboBox cbProductGroupSearch = new JComboBox();

    public ProductDeletingPanel() {
        setLayout(null);
        backgroundHeader.setLayout(null);
        add(backgroundHeader);
        add(tableBackground);
        backgroundHeader.add(modeSwitchOff);
        backgroundHeader.add(btnFind);
        btnFind.setBounds(13, 47, 54, 110);
        backgroundHeader.setBounds(0, 0, 914, 175);
        modeSwitchOff.setBounds(536, 5, 26, 26);
        tableBackground.setBounds(0, 175, 914, 491);
        addElementsToProductDeltePanel();
        addListners();

        tablePanel.addDataToGoodsTable(Stock.getAllProducts(),1);
    }

    private void addElementsToProductDeltePanel() {
        backgroundHeader.setBounds(0, 0, 914, 175);
        tableBackground.setBounds(0, 175, 914, 491);
        addElementsToHeaderBackground();
        addElementsToTableBackground();
    }

    private void addElementsToTableBackground() {
        tableBackground.add(btnDelete);
        tableBackground.add(tablePanel);
        tablePanel.setBounds(35, 15, 850, 400);
        btnDelete.setBounds(375, 420, 165, 40);
    }

    private void addElementsToHeaderBackground() {

        backgroundHeader.add(modeSwitchOff);
        backgroundHeader.add(btnFind);
        backgroundHeader.add(tfproductNameSearch);
        backgroundHeader.add(cbProductGroupSearch);
        backgroundHeader.add(tfManufacturerSearch);
        backgroundHeader.add(tfLowestPriceearch);
        backgroundHeader.add(tfHighestPriceSearch);
        tfproductNameSearch.setBounds(229, 74, 227, 18);
        tfManufacturerSearch.setBounds(229, 114, 227, 18);
        cbProductGroupSearch.setBounds(648, 74, 227, 17);
        tfLowestPriceearch.setBounds(649, 114, 60, 18);
        tfHighestPriceSearch.setBounds(756, 114, 60, 18);

        backgroundHeader.add(btnDelete);
        btnFind.setBounds(13, 47, 54, 110);

        modeSwitchOff.setBounds(536, 5, 26, 26);

    }

    public TablePanel getTablePanel() {
        return tablePanel;
    }

    private void addListners() {
        btnFind.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });
        modeSwitchOff.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DeletingPanel.showGroupDeleteTab();
            }
        });
        btnDelete.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(tablePanel.getSelectedProduct() == null) return;
                tablePanel.getSelectedProduct().getGroupProducts().removeProduct(tablePanel.getSelectedProduct());
                tablePanel.addDataToGoodsTable(Stock.getAllProducts(),1);
            }
        });
    }

}
