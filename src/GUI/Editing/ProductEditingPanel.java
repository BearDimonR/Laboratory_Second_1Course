package GUI.Editing;

import GUI.General.AppStyles;
import GUI.General.TablePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ProductEditingPanel extends JPanel {
    private JLabel btnEdit = new JLabel(new ImageIcon("images/EditBTN.jpg"));
    private JLabel backgroundHeader = new JLabel(new ImageIcon("images/TproductEditingHeader.jpg"));
    private JLabel btnFind = new JLabel(new ImageIcon("images/findVerticalButton.jpg"));
    private JLabel backgroundClearBody = new JLabel(new ImageIcon("images/productEditingClearBody.jpg"));
    private JLabel backgroundBody = new JLabel(new ImageIcon("images/productEditingBody.jpg"));
    //Body elements
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
    //ClearBody elements
    private TablePanel tablePanel = new TablePanel(1);

    public ProductEditingPanel() {
        setLayout(AppStyles.gridBagLayout);
        backgroundHeader.setLayout(AppStyles.gridBagLayout);
        backgroundBody.setLayout(AppStyles.gridBagLayout);
        backgroundClearBody.setLayout(AppStyles.gridBagLayout);
        backgroundBody.setVisible(true);
        backgroundClearBody.setVisible(false);

        addElementsToProductEditingPanel();
        addMouseListenersToBTNS();
    }

    private void addElementsToProductEditingPanel() {
        add(backgroundHeader, new GridBagConstraints(0, 0, 1, 1, 1, 0.6,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        add(backgroundClearBody, new GridBagConstraints(0, 1, 1, 1, 1, 0.6,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        add(backgroundBody, new GridBagConstraints(0, 1, 1, 1, 1, 0.6,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        addElementsToBackgroundHeader();
        addElementsToBackgroundBody();
        addElementsToClearBackgroundBody();
    }

    private void addElementsToBackgroundBody() {
        backgroundBody.add(tfOldProductName, new GridBagConstraints(0, 0, 1, 1, 1, 0.18,
                GridBagConstraints.NORTHWEST, GridBagConstraints.CENTER,
                new Insets(30, 111, 0, 0), 300, 0));
        backgroundBody.add(spOldDescription, new GridBagConstraints(0, 1, 1, 1, 1, 0.18,
                GridBagConstraints.NORTHWEST, GridBagConstraints.CENTER,
                new Insets(0, 111, 0, 0), 300, 100));
        backgroundBody.add(tfNewProductName, new GridBagConstraints(1, 0, 1, 1, 1, 0.18,
                GridBagConstraints.NORTHWEST, GridBagConstraints.NORTH,
                new Insets(30, 50, 0, 0), 300, 0));
        backgroundBody.add(spNewDescription, new GridBagConstraints(1, 1, 1, 1, 1, 0.18,
                GridBagConstraints.NORTHWEST, GridBagConstraints.NORTH,
                new Insets(0, 50, 0, 0), 300, 100));
        backgroundBody.add(cbOldGroup, new GridBagConstraints(0, 2, 1, 1, 1, 0.18,
                GridBagConstraints.NORTHWEST, GridBagConstraints.CENTER,
                new Insets(0, 111, 0, 0), 280, 0));
        backgroundBody.add(cbNewGroup, new GridBagConstraints(1, 2, 1, 1, 1, 0.18,
                GridBagConstraints.NORTHWEST, GridBagConstraints.NORTH,
                new Insets(0, 50, 0, 0), 280, 0));
        backgroundBody.add(tfOldManufacturer, new GridBagConstraints(0, 3, 1, 1, 1, 0.18,
                GridBagConstraints.NORTHWEST, GridBagConstraints.CENTER,
                new Insets(0, 111, 0, 0), 300, 0));
        backgroundBody.add(tfNewManufacturer, new GridBagConstraints(1, 3, 1, 1, 1, 0.18,
                GridBagConstraints.NORTHWEST, GridBagConstraints.NORTH,
                new Insets(0, 50, 0, 0), 300, 0));
        backgroundBody.add(tfOldPrice, new GridBagConstraints(0, 4, 1, 1, 1, 0.18,
                GridBagConstraints.NORTHWEST, GridBagConstraints.CENTER,
                new Insets(0, 111, 0, 0), 300, 0));
        backgroundBody.add(tfNewPrice, new GridBagConstraints(1, 4, 1, 1, 1, 0.18,
                GridBagConstraints.NORTHWEST, GridBagConstraints.NORTH,
                new Insets(0, 50, 0, 0), 300, 0));
        backgroundBody.add(btnEdit, new GridBagConstraints(0, 5, 2, 1, 1, 0.18,
                GridBagConstraints.CENTER, GridBagConstraints.CENTER,
                new Insets(0, 50, 0, 0), 0, 0));
    }

    private void addElementsToBackgroundHeader() {
        backgroundHeader.add(btnFind, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                GridBagConstraints.WEST, GridBagConstraints.CENTER,
                new Insets(30, 14, 0, 0), 0, 0));
        backgroundHeader.add(tfproductNameSearch, new GridBagConstraints(0, 0, 1, 1, 1, 0.18,
                GridBagConstraints.CENTER, GridBagConstraints.CENTER,
                new Insets(-10, -240, 0, 0), 230, 0));
        backgroundHeader.add(cbProductGroupSearch, new GridBagConstraints(0, 0, 1, 1, 1, 0.18,
                GridBagConstraints.CENTER, GridBagConstraints.CENTER,
                new Insets(-10, 610, 0, 0), 200, 0));
        backgroundHeader.add(tfManufacturerSearch, new GridBagConstraints(0, 0, 1, 1, 1, 0.18,
                GridBagConstraints.CENTER, GridBagConstraints.CENTER,
                new Insets(75, -240, 0, 0), 230, 0));
        backgroundHeader.add(tfLowestPriceearch, new GridBagConstraints(0, 0, 1, 1, 1, 0.18,
                GridBagConstraints.CENTER, GridBagConstraints.CENTER,
                new Insets(75, 450, 0, 0), 50, 0));
        backgroundHeader.add(tfHighestPriceSearch, new GridBagConstraints(0, 0, 1, 1, 1, 0.18,
                GridBagConstraints.CENTER, GridBagConstraints.CENTER,
                new Insets(75, 650, 0, 0), 50, 0));
    }

    private void addElementsToClearBackgroundBody() {
        backgroundClearBody.add(tablePanel, new GridBagConstraints(0, 0, 1, 1, 1, 1,
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
