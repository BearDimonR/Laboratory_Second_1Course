package GUI.Editing;

import GUI.General.AppStyles;
import GUI.General.TablePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ProductEditingPanel extends JPanel {
    private JLabel btnEdit = new JLabel(new ImageIcon("images/editBTN.jpg"));
    private JLabel headerBackground = new JLabel(new ImageIcon("images/editComponents/productEditHeader.jpg"));
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
    private JComboBox cbOldGroup = new JComboBox();
    private JComboBox cbNewGroup = new JComboBox();
    //Header elements
    private JTextField tfproductNameSearch = new JTextField();
    private JTextField tfManufacturerSearch = new JTextField();
    private JTextField tfLowestPriceearch = new JTextField();
    private JTextField tfHighestPriceSearch = new JTextField();
    private JComboBox cbProductGroupSearch = new JComboBox();
    //Table body elements
    private TablePanel tablePanel = new TablePanel(1);

    public ProductEditingPanel() {
        setLayout(AppStyles.gridBagLayout);
        headerBackground.setLayout(null);
        editFieldsBodyBackground.setLayout(null);
        tableBodyBackground.setLayout(AppStyles.gridBagLayout);
        editFieldsBodyBackground.setVisible(true);
        tableBodyBackground.setVisible(false);

        addElementsToProductEditingPanel();
        addMouseListenersToBTNS();
    }

    private void addElementsToProductEditingPanel() {
        add(headerBackground, new GridBagConstraints(0, 0, 1, 1, 1, 0.6,
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
        addElementsToClearBackgroundBody();
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
        tfOldProductName.setBounds(112,30,303,20);
        spOldDescription.setBounds(112,86,303,122);
        cbOldGroup.setBounds(112,247,303,20);
        tfOldManufacturer.setBounds(112,310,303,20);
        tfOldPrice.setBounds(112,370,303,20);

        tfNewProductName.setBounds(537,30,303,20);
        spNewDescription.setBounds(537,86,303,122);
        cbNewGroup.setBounds(537,247,303,20);
        tfNewManufacturer.setBounds(537,310,303,20);
        tfNewPrice.setBounds(537,370,303,20);
        btnEdit.setBounds(375,420,165,40);
    }

    private void addElementsToBackgroundHeader() {
        btnFind.setBounds(13,47,54,110);
        headerBackground.add(btnFind);
        headerBackground.add(tfproductNameSearch);
        headerBackground.add(cbProductGroupSearch);
        headerBackground.add(tfManufacturerSearch);
        headerBackground.add(tfLowestPriceearch);
        headerBackground.add(tfHighestPriceSearch);
        tfproductNameSearch.setBounds(229,74,227,18);
        tfManufacturerSearch.setBounds(229,114,227,18);
        cbProductGroupSearch.setBounds(648,74,227,17);
        tfLowestPriceearch.setBounds(649,114,60,18);
        tfHighestPriceSearch.setBounds(756,114,60,18);
    }

    private void addElementsToClearBackgroundBody() {
        tableBodyBackground.add(tablePanel, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                GridBagConstraints.CENTER, GridBagConstraints.CENTER,
                new Insets(0, 0, 0, 0), 800, 0));
    }

    private void addMouseListenersToBTNS() {
        btnFind.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                 //метод додавання інформації до таблиці перший параметр - масив груп, другий елемент - тип таблиці (1 - goods, 2-group)
                //tablePanel.addDataToGroupOFGoodsTable(,1);
            }
        });
        btnEdit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });
    }
}
