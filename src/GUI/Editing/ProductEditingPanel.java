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
        headerBackground.setLayout(AppStyles.gridBagLayout);
        editFieldsBodyBackground.setLayout(AppStyles.gridBagLayout);
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
        editFieldsBodyBackground.add(tfOldProductName, new GridBagConstraints(0, 0, 1, 1, 1, 0.18,
                GridBagConstraints.NORTHWEST, GridBagConstraints.CENTER,
                new Insets(30, 111, 0, 0), 300, 0));
        editFieldsBodyBackground.add(spOldDescription, new GridBagConstraints(0, 1, 1, 1, 1, 0.18,
                GridBagConstraints.NORTHWEST, GridBagConstraints.CENTER,
                new Insets(0, 111, 0, 0), 300, 100));
        editFieldsBodyBackground.add(tfNewProductName, new GridBagConstraints(1, 0, 1, 1, 1, 0.18,
                GridBagConstraints.NORTHWEST, GridBagConstraints.NORTH,
                new Insets(30, 50, 0, 0), 300, 0));
        editFieldsBodyBackground.add(spNewDescription, new GridBagConstraints(1, 1, 1, 1, 1, 0.18,
                GridBagConstraints.NORTHWEST, GridBagConstraints.NORTH,
                new Insets(0, 50, 0, 0), 300, 100));
        editFieldsBodyBackground.add(cbOldGroup, new GridBagConstraints(0, 2, 1, 1, 1, 0.18,
                GridBagConstraints.NORTHWEST, GridBagConstraints.CENTER,
                new Insets(0, 111, 0, 0), 280, 0));
        editFieldsBodyBackground.add(cbNewGroup, new GridBagConstraints(1, 2, 1, 1, 1, 0.18,
                GridBagConstraints.NORTHWEST, GridBagConstraints.NORTH,
                new Insets(0, 50, 0, 0), 280, 0));
        editFieldsBodyBackground.add(tfOldManufacturer, new GridBagConstraints(0, 3, 1, 1, 1, 0.18,
                GridBagConstraints.NORTHWEST, GridBagConstraints.CENTER,
                new Insets(0, 111, 0, 0), 300, 0));
        editFieldsBodyBackground.add(tfNewManufacturer, new GridBagConstraints(1, 3, 1, 1, 1, 0.18,
                GridBagConstraints.NORTHWEST, GridBagConstraints.NORTH,
                new Insets(0, 50, 0, 0), 300, 0));
        editFieldsBodyBackground.add(tfOldPrice, new GridBagConstraints(0, 4, 1, 1, 1, 0.18,
                GridBagConstraints.NORTHWEST, GridBagConstraints.CENTER,
                new Insets(0, 111, 0, 0), 300, 0));
        editFieldsBodyBackground.add(tfNewPrice, new GridBagConstraints(1, 4, 1, 1, 1, 0.18,
                GridBagConstraints.NORTHWEST, GridBagConstraints.NORTH,
                new Insets(0, 50, 0, 0), 300, 0));
        editFieldsBodyBackground.add(btnEdit, new GridBagConstraints(0, 5, 2, 1, 1, 0.18,
                GridBagConstraints.CENTER, GridBagConstraints.CENTER,
                new Insets(0, 50, 0, 0), 0, 0));
    }

    private void addElementsToBackgroundHeader() {
        headerBackground.add(btnFind, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                GridBagConstraints.WEST, GridBagConstraints.CENTER,
                new Insets(30, 14, 0, 0), 0, 0));
        headerBackground.add(tfproductNameSearch, new GridBagConstraints(0, 0, 1, 1, 1, 0.18,
                GridBagConstraints.CENTER, GridBagConstraints.CENTER,
                new Insets(-10, -240, 0, 0), 230, 0));
        headerBackground.add(cbProductGroupSearch, new GridBagConstraints(0, 0, 1, 1, 1, 0.18,
                GridBagConstraints.CENTER, GridBagConstraints.CENTER,
                new Insets(-10, 610, 0, 0), 200, 0));
        headerBackground.add(tfManufacturerSearch, new GridBagConstraints(0, 0, 1, 1, 1, 0.18,
                GridBagConstraints.CENTER, GridBagConstraints.CENTER,
                new Insets(75, -240, 0, 0), 230, 0));
        headerBackground.add(tfLowestPriceearch, new GridBagConstraints(0, 0, 1, 1, 1, 0.18,
                GridBagConstraints.CENTER, GridBagConstraints.CENTER,
                new Insets(75, 450, 0, 0), 50, 0));
        headerBackground.add(tfHighestPriceSearch, new GridBagConstraints(0, 0, 1, 1, 1, 0.18,
                GridBagConstraints.CENTER, GridBagConstraints.CENTER,
                new Insets(75, 650, 0, 0), 50, 0));
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
