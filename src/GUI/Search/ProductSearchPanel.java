package GUI.Search;

import GUI.General.AppStyles;
import GUI.General.TablePanel;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ProductSearchPanel extends JPanel {
    JLabel backgroundHeader = new JLabel(new ImageIcon("images/Search/SearchHeader.jpg"));
    JLabel tableBackground = new JLabel(new ImageIcon("images/tableBodyBackground.jpg"));
    private JLabel btnFind = new JLabel(new ImageIcon("images/findVerticalBTN.jpg"));
    private JTextField tfproductNameSearch = new JTextField();
    private JTextField tfManufacturerSearch = new JTextField();
    private JTextField tfLowestPriceSearch = new JTextField();
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
        setStyleOfHeaderElements();
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
        tableBackground.add(tablePanel);
        tablePanel.setBounds(35, 20, 850, 441);
    }
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
}
