package GUI.General;


import BackGround.Alphabet;
import BackGround.Product;
import BackGround.GroupOfProduct;
import BackGround.Stock;

import javax.swing.*;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.ArrayList;
import java.util.Arrays;



//public class TablePanel extends JPanel implements MouseListener {
//    private String[] GoodsTitles = {"id", "Product", "Group", "Manufacturer", "Price"};
//    private String[] GroupTitles = {"id", "Group of products"};
//    public JTable table = new JTable();
//    private JScrollPane scrollPane = new JScrollPane(table);
//    private DefaultTableModel model = (DefaultTableModel) table.getModel();
//    private JList studentList = new JList();

public class TablePanel extends JPanel {
    private  String[] GoodsTitles = {"id", "Product", "Group", "Manufacturer", "Price"};
    private  String[] GroupTitles = {"id", "Group of products"};
    private String[] GroupStats = {"id","Group of products","Total price","Total amount","Description"};
    private String[] GoodsStats = {"id","Product","Manufacturer","Price","Amount","Description"};
    private  JTable table = new JTable();
    private JScrollPane scrollPane = new JScrollPane(table);


    GridBagLayout gbl = new GridBagLayout();

    public TablePanel(int titleType) {
        //table.setAutoCreateRowSorter(true);
        AddActionListener();
        init(titleType);
        setLayout(gbl);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        setBackground(Color.WHITE);
        init(1);

    //    setModel(null ,1);

        add(scrollPane, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(1, 0, 0, 0), 0, 430));

        {
            setBackground(Color.WHITE);
            scrollPane.setBackground(Color.WHITE);
            scrollPane.setForeground(Color.WHITE);
            scrollPane.setOpaque(false);
            scrollPane.getViewport().setOpaque(false);
            scrollPane.setBorder(new EmptyBorder(0,0,0,0));
            table.setFont(new java.awt.Font("Verdana", 0, 16));
            table.setBackground(Color.WHITE);
            table.setBorder(new EmptyBorder(0,0,0,0));
            table.setOpaque(false);
            ((DefaultTableCellRenderer)table.getDefaultRenderer(Object.class)).setOpaque(false);
            ((DefaultTableCellRenderer)table.getDefaultRenderer(Object.class)).setHorizontalAlignment(JLabel.CENTER);
            table.getTableHeader().setOpaque(false);
            table.getTableHeader().setBackground(AppStyles.MainColor);
            table.getTableHeader().setForeground(Color.white);
            table.setShowGrid(false);
            table.setSelectionBackground(Color.LIGHT_GRAY);
        }
        AddActionListener();

    }

    /**
     * тут в таюлицю ввожиться вся інформація
     *
     * @param products
     * @param titleNum
     */
    public void addDataToGoodsTable(ArrayList<Product> products, int titleNum) {
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


//        model.setDataVector(studs, titles);
//        table.setModel(model);

        setModel(objects,titleNum);


    }

    public void addDataToGroupOFGoodsTable(ArrayList<GroupOfProduct> groupOfProduct, int titleNum) {
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

    public void init(int titleNum) {
        table.setModel(new DefaultTableModel(null, titlesChoser(titleNum)));
    }

    private String[] titlesChoser(int titleNum) {
        String[] titles;
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

    public JTable getTable() {
        return table;
    }

    public Product getSelectedProduct() {
        if (table.getSelectedRow() == -1) return null;
        return Stock.findProductByName((String) table.getValueAt(table.getSelectedRow(), 1));
    }

    public GroupOfProduct getSelectedGroup() {
        if (table.getSelectedRow() == -1) return null;
        return Stock.findGroup((String) table.getValueAt(table.getSelectedRow(), 1));
    }


//    public void crearAll() {
//        model = new DefaultTableModel();

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

        TableColumn column;
        for (int i = 0; i < titlesChoser(titleNum).length; i++) {
            column = table.getColumnModel().getColumn(i);
            if (i == 0) {
                column.setPreferredWidth(40);
            }else if(i == 4){
                column.setPreferredWidth(150);
            } else {
                column.setPreferredWidth(300);
            }
        }

    }

    public void AddActionListener() {

        table.getTableHeader().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JTableHeader header = table.getTableHeader();
                header.addMouseListener(new TablePanel(table));
                Point point = e.getPoint();
                int column = table.columnAtPoint(point);
                System.out.println("i=" + column);
                if (column == 1) {
                    addDataToGoodsTable(Alphabet.alphabetProduct(), 1);
                }
                if (column == 2) {
                    addDataToGoodsTable(Alphabet.alphabetGroup(), 1);
                }
                if (column == 3) {
                    addDataToGoodsTable(Alphabet.alphabetManufacturer(), 1);
                } else if (column == 4) {
                    addDataToGoodsTable(Alphabet.alphabetPrice(), 1);
                }
                // System.out.println("shlop po pope");


            }
        });
    }

    public void AddActionL() {
        JTableHeader header = table.getTableHeader();
        header.addMouseListener(new TableHeaderMouseListener(table));
    }


//    public TablePanel(JTable table) {
//        this.table = table;
//    }
//    public void mouseClicked(MouseEvent e) {
////        Point point = e.getPoint();
////        int column = table.columnAtPoint(point);
////        System.out.println("i=" + column);
////        if (column == 1) {
////            addDataToGoodsTable(Alphabet.alphabetProduct(), 1);
////        }
////        if (column == 2) {
////            addDataToGoodsTable(Alphabet.alphabetGroup(), 1);
////        }
////        if (column == 3) {
////            addDataToGoodsTable(Alphabet.alphabetManufacturer(), 1);
////        } else if (column == 4) {
////            addDataToGoodsTable(Alphabet.alphabetPrice(), 1);
////        }
//    }
//
//    @Override
//    public void mousePressed(MouseEvent e) {
//
//    }
//
//    @Override
//    public void mouseReleased(MouseEvent e) {
//
//    }
//
//    @Override
//    public void mouseEntered(MouseEvent e) {
//
//    }
//
//    @Override
//    public void mouseExited(MouseEvent e) {


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