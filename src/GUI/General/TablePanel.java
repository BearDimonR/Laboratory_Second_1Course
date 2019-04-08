package GUI.General;


import BackGround.Alphabet;
import BackGround.Product;
import BackGround.GroupOfProduct;
import BackGround.Stock;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class TablePanel extends JPanel implements MouseListener {
    /**
     * name of columns
     */
    private  String[] GoodsTitles = {"№", "Product", "Group", "Manufacturer", "Price"};
    private  String[] GroupTitles = {"№", "Group of products"};
    private String[] GroupStats = {"№","Group of products","Total price","Total amount","Description"};
    private String[] GoodsStats = {"№","Product","Manufacturer","Price","Amount","Description"};
    /**
     * JTable and JScrollPane
     */
    private  JTable table = new JTable();
    private JScrollPane scrollPane = new JScrollPane(table);
    /**
     * Layout
     */
    GridBagLayout gbl = new GridBagLayout();

    /**
     * init table
     * @param titleType type of columns
     */
    public TablePanel(int titleType) {
        setModel(null,titleType);
        setLayout(gbl);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        setModel(null ,1);
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
            table.setShowGrid(true);
            table.setSelectionBackground(Color.LIGHT_GRAY);
            table.setIntercellSpacing(new Dimension(5,5));
            table.getTableHeader().setFont(new java.awt.Font("Verdana", 0, 16));
            table.setRowHeight(50);
        }
/**
 * **********************************************************************************************************************************
 */

      //  AddActionListener();
/**
 * **********************************************************************************************************************************
 */

    }

    /**
     * add data to table
     * @param products arraylist of products
     * @param titleNum type of title
     */
    public  void addDataToGoodsTable(ArrayList<Product> products, int titleNum) {
        Object[][] objects = new Object[products.size()][];
        for (int i = 0; i < products.size(); i++) {
            String[] productLine = new String[6];
            productLine[0] = (i + 1) + "";
            productLine[1] = products.get(i).getProductName();
            productLine[2] = products.get(i).getGroupProducts().getName();
            productLine[3] = products.get(i).getManufacturer();
            productLine[4] = String.valueOf(products.get(i).getPrice());
            objects[i] = productLine;
        }
        setModel(objects,titleNum);

    }

    /**
     * add data to table
     * @param groupOfProduct arraylist of groups
     * @param titleNum type of title
     */
    public  void addDataToGroupOFGoodsTable(ArrayList<GroupOfProduct> groupOfProduct, int titleNum) {
        Object[][] objects = new Object[groupOfProduct.size()][];
        for (int i = 0; i < groupOfProduct.size(); i++) {
            String[] groupLine = new String[2];
            groupLine[0] = (i + 1) + "";
            groupLine[1] = groupOfProduct.get(i).getName();
            objects[i] = groupLine;
        }
        setModel(objects,titleNum);
    }

    /**
     * selector of title
     * @param titleNum type of title
     * @return string[] titles
     */
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

    /**
     * getTable
     * @return JTable
     */
    public  JTable getTable() {
        return table;
    }

    /**
     *
     * @return selected product
     */
    public  Product getSelectedProduct(){
        if(table.getSelectedRow() == -1) return null;
        return Stock.findProductByName((String) table.getValueAt(table.getSelectedRow(),1));
    }

    /**
     *
     * @return selected group
     */
    public  GroupOfProduct getSelectedGroup(){
        if(table.getSelectedRow() == -1) return null;
        return Stock.findGroup((String) table.getValueAt(table.getSelectedRow(),1));
    }

    /**
     * set new model to JTable
     * @param data new data
     * @param titleNum type of title
     */
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


    /**
     *  add data to table
     * @param groups arraylist of groups
     * @param titleNum type of title
     */
    public void addStatsToGroupOFGoodsTable(ArrayList<GroupOfProduct> groups, int titleNum) {
        Object[][] objects = new Object[groups.size()][];
        for (int i = 0; i < groups.size(); i++) {
            String[] groupLine = new String[5];
            groupLine[0] = (i + 1) + "";
            groupLine[1] = groups.get(i).getName();
            groupLine[2] = String.valueOf(groups.get(i).getGroupPrice());
            groupLine[3] = String.valueOf(groups.get(i).getGroupAmount());
            groupLine[4] = groups.get(i).getDescription();
            objects[i] = groupLine;
        }
        setModel(objects,titleNum);
    }

    /**
     * add data to table
     * @param products arraylist of products
     * @param titleNum type of title
     */
    public void addStatsToGoodsTable(ArrayList<Product> products, int titleNum) {
        Object[][] objects = new Object[products.size()][];
        for (int i = 0; i < products.size(); i++) {
            String[] productLine = new String[6];
            productLine[0] = (i + 1) + "";
            productLine[1] = products.get(i).getProductName();
            productLine[2] = products.get(i).getManufacturer();
            productLine[3] = String.valueOf(products.get(i).getPrice());
            productLine[4] = String.valueOf(products.get(i).getQuantityInStock());
            productLine[5] = products.get(i).getDescription();
            objects[i] = productLine;
        }
        setModel(objects,titleNum);
    }

    public  void AddActionListener() {
        table.getTableHeader().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JTableHeader header = table.getTableHeader();
                header.addMouseListener(new TablePanel(table));
                Point point = e.getPoint();
                if(table.getColumnCount()==5) {
                    int column = table.columnAtPoint(point);
                    System.out.println("i1=" + column);
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
                }
                //якщо ми знаходимося в таблиці де лише групи
                else if(table.getColumnCount()==2){
                    int column = table.columnAtPoint(point);
                    if (column == 1) {
                        System.out.println("лише групи товарів");
                        addDataToGroupOFGoodsTable(Alphabet.alphabetOnlyGroup(), 2  );
                    }
                }
            }
        });
    }

    /**
     * get JTable
     * @param table JTable
     */
    TablePanel(JTable table){
        this.table = table; }

    @Override
    public void mouseClicked(MouseEvent e) { }
    @Override
    public void mousePressed(MouseEvent e) { }
    @Override
    public void mouseReleased(MouseEvent e) { }
    @Override
    public void mouseEntered(MouseEvent e) { }
    @Override
    public void mouseExited(MouseEvent e) { }
}