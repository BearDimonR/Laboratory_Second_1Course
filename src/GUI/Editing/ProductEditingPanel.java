package GUI.Editing;

import BackGround.GroupOfProduct;
import BackGround.Product;
import BackGround.Stock;
import GUI.General.AppStyles;
import GUI.General.TablePanel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    private JComboBox<String> cbOldGroup = new JComboBox<>();
    private JComboBox<String> cbNewGroup = new JComboBox<String>();
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
        editFieldsBodyBackground.setVisible(false);
        tableBodyBackground.setVisible(true);

        addElementsToProductEditingPanel();
        addMouseListenersToBTNS();

        tablePanel.addDataToGoodsTable(Stock.getAllProducts(), 1);
        tablePanel.getTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(tablePanel.getTable().getSelectedRow() == -1) return;
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
        taNewDescription.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                checkFields();
            }
        });
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
                if (!btnEdit.isVisible()) return;
                Product product = tablePanel.getSelectedProduct();
                tablePanel.getTable().clearSelection();
                product.setDescription(taNewDescription.getText());
                product.setPrice(Double.parseDouble(tfNewPrice.getText()));
                product.setManufacturer(tfNewManufacturer.getText());
                product.setGroupProducts(Stock.findGroup((String) cbNewGroup.getSelectedItem()));
                product.setProductName(tfNewProductName.getText());
                taNewDescription.setText("");
                taOldDescription.setText("");
                tfNewProductName.setText("");
                tfOldProductName.setText("");
                tablePanel.addDataToGoodsTable(Stock.getAllProducts(),1);
                editFieldsBodyBackground.setVisible(false);
                tableBodyBackground.setVisible(true);
            }
        });
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
}
