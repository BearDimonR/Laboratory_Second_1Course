package GUI;

import GUI.General.TablePanel;

import javax.swing.*;
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
                addAmount++;
                tfAddToStock.setText(String.valueOf(addAmount));
            }
        });
        btnAddMinus.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                addAmount--;
                tfAddToStock.setText(String.valueOf(addAmount));
            }
        });
        btnRemovePlus.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                removeAmount++;
                tfRemoveFromStock.setText(String.valueOf(removeAmount));
            }
        });
        btnRemoveMinus.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                removeAmount--;
                tfRemoveFromStock.setText(String.valueOf(removeAmount));
            }
        });
    }
}
