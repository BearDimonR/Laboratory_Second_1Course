package GUI.General;


import BackGround.Product;
import BackGround.GroupOfProduct;
import BackGround.Stock;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class TablePanel extends JPanel {
    static String[] GoodsTitles = {"id", "Product", "Group", "Manufacturer", "Price"};
    static String[] GroupTitles = {"id", "Group of products"};
    static JTable table = new JTable();
    JScrollPane scrollPane = new JScrollPane(table);
    static DefaultTableModel model = (DefaultTableModel) table.getModel();
    static JList studentList = new JList();

    GridBagLayout gbl = new GridBagLayout();

    public TablePanel(int titleType) {
        init(titleType);
        setLayout(gbl);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        studentList.setVisible(true);

        setBackground(Color.WHITE);
        init(1);
        add(scrollPane, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(1, 0, 0, 0), 0, 430));
    }

    public  void addDataToGoodsTable(ArrayList<Product> products, int titleNum) {
        String[] titles = titlesChoser(titleNum);
        Object[][] studs = new Object[products.size()][];
        for (int i = 0; i < products.size(); i++) {
            String[] productLine = new String[6];
            productLine[0] = (i + 1) + ".";
            productLine[1] = products.get(i).getProductName();
            productLine[2] = products.get(i).getGroupProducts().getName();
            productLine[3] = products.get(i).getManufacturer();
            productLine[4] = String.valueOf(products.get(i).getPrice());
            studs[i] = productLine;
        }
        model.setDataVector(studs, titles);
        table.setModel(model);
    }

    public  void addDataToGroupOFGoodsTable(ArrayList<GroupOfProduct> groupOfProduct, int titleNum) {
        String[] titles = titlesChoser(titleNum);
        Object[][] groups = new Object[groupOfProduct.size()][];
        for (int i = 0; i < groupOfProduct.size(); i++) {
            String[] groupLine = new String[2];
            groupLine[0] = (i + 1) + ".";
            groupLine[1] = groupOfProduct.get(i).getName();
            groups[i] = groupLine;
        }
        model.setDataVector(groups, titles);
        table.setModel(model);
    }

    public  void init(int titleNum) {
        table.setModel(new DefaultTableModel(null, titlesChoser(titleNum)));
    }

    private  String[] titlesChoser(int titleNum) {
        String[] titles;
        switch (titleNum) {
            case 1:
                return GoodsTitles;
            case 2:
                return GroupTitles;
            default:
                return GoodsTitles;
        }
    }

    public  JTable getTable() {
        return table;
    }

    public  Product getSelectedProduct(){
        if(table.getSelectedRow() == -1) return null;
        return Stock.findProductByName((String) table.getValueAt(table.getSelectedRow(),1));
    }

    public  GroupOfProduct getSelectedGroup(){
        if(table.getSelectedRow() == -1) return null;
        return Stock.findGroup((String) table.getValueAt(table.getSelectedRow(),1));
    }

}