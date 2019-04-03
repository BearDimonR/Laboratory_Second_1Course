package GUI.Search;

import GUI.General.TablePanel;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ProductSearchPanel extends JPanel {
    JLabel backgroundHeader = new JLabel(new ImageIcon("images/Search/SearchHeader.jpg"));
    JLabel tableBackground = new JLabel(new ImageIcon("images/tableBodyBackground.jpg"));
    private JLabel btnFind = new JLabel(new ImageIcon("images/findVerticalBTN.jpg"));
    private JTextField tfproductNameSearch = new JTextField();
    private JTextField tfManufacturerSearch = new JTextField();
    private JTextField tfLowestPriceearch = new JTextField();
    private JTextField tfHighestPriceSearch = new JTextField();
    private JComboBox cbProductGroupSearch = new JComboBox();
    private static JLabel btnModeSwitchOff = new JLabel(new ImageIcon("images/groupCreateModeOffBTN.png"));
    private TablePanel tablePanel = new TablePanel(1);

    public ProductSearchPanel() {
        setLayout(null);
        backgroundHeader.setLayout(null);
        add(backgroundHeader);
        add(tableBackground);
        backgroundHeader.setBounds(0, 0, 914, 175);
        tableBackground.setBounds(0, 175, 914, 491);
        addElementsToBackgroundHeader();
        addElementsToTableBackgroundBody();
        btnModeSwitchOff.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SearchPanel.showStatistickPanel();
            }
        });
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
        tableBackground.add(tablePanel);
        tablePanel.setBounds(35, 20, 850, 441);
    }
}
