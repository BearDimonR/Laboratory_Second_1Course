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
    private  String[] GoodsTitles = {"id", "Product", "Group", "Manufacturer", "Price"};
    private  String[] GroupTitles = {"id", "Group of products"};
    private String[] GroupStats = {"id","Group of products","Total price","Total amount","Description"};
    private String[] GoodsStats = {"id","Product","Manufacturer","Price","Amount","Description"};
    private  JTable table = new JTable();
    private JScrollPane scrollPane = new JScrollPane(table);
    private JList studentList = new JList();

    GridBagLayout gbl = new GridBagLayout();

    public TablePanel(int titleType) {
        setModel(null,titleType);
        setLayout(gbl);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        studentList.setVisible(true);

        setBackground(Color.WHITE);
        setModel(null ,1);
        add(scrollPane, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(1, 0, 0, 0), 0, 430));
        AddActionListener();
    }

    public  void addDataToGoodsTable(ArrayList<Product> products, int titleNum) {
        Object[][] objects = new Object[products.size()][];
        for (int i = 0; i < products.size(); i++) {
            String[] productLine = new String[6];
            productLine[0] = (i + 1) + ".";
            productLine[1] = products.get(i).getProductName();
            productLine[2] = products.get(i).getGroupProducts().getName();
            productLine[3] = products.get(i).getManufacturer();
            productLine[4] = String.valueOf(products.get(i).getPrice());
            objects[i] = productLine;
        }
        setModel(objects,titleNum);

    }

    public  void addDataToGroupOFGoodsTable(ArrayList<GroupOfProduct> groupOfProduct, int titleNum) {
        Object[][] objects = new Object[groupOfProduct.size()][];
        for (int i = 0; i < groupOfProduct.size(); i++) {
            String[] groupLine = new String[2];
            groupLine[0] = (i + 1) + ".";
            groupLine[1] = groupOfProduct.get(i).getName();
            objects[i] = groupLine;
        }
        setModel(objects,titleNum);
    }

    private  String[] titlesChoser(int titleNum) {
        switch (titleNum) {
            case 1:
                return GoodsTitles;
            case 2:
                return GroupTitles;
            case 3:
                return GroupStats;
            case 4:
                return GoodsStats;
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

    private void setModel(Object[][] data, int titleNum){
        table.setModel(new javax.swing.table.DefaultTableModel(
                data
                ,
                titlesChoser(titleNum)
        ){

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        });
    }

    public void AddActionListener(){
        table.getTableHeader().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("shlop po pope");
//                if(table.){
//                    System.out.println("group");
//                }
//                else{
//                    System.out.println("kek");
//                }
            }
        });
    }


    public void addStatsToGroupOFGoodsTable(ArrayList<GroupOfProduct> groups, int titleNum) {
        Object[][] objects = new Object[groups.size()][];
        for (int i = 0; i < groups.size(); i++) {
            String[] groupLine = new String[5];
            groupLine[0] = (i + 1) + ".";
            groupLine[1] = groups.get(i).getName();
            groupLine[2] = String.valueOf(groups.get(i).getGroupPrice());
            groupLine[3] = String.valueOf(groups.get(i).getGroupAmount());
            groupLine[4] = groups.get(i).getDescription();
            objects[i] = groupLine;
        }
        setModel(objects,titleNum);
    }

    public void addStatsToGoodsTable(ArrayList<Product> products, int titleNum) {
        Object[][] objects = new Object[products.size()][];
        for (int i = 0; i < products.size(); i++) {
            String[] productLine = new String[6];
            productLine[0] = (i + 1) + ".";
            productLine[1] = products.get(i).getProductName();
            productLine[2] = products.get(i).getManufacturer();
            productLine[3] = String.valueOf(products.get(i).getPrice());
            productLine[4] = String.valueOf(products.get(i).getQuantityInStock());
            productLine[5] = products.get(i).getDescription();
            objects[i] = productLine;
        }
        setModel(objects,titleNum);
    }

}