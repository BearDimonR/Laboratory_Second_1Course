package GUI.General;


import BackGround.Product;
import BackGround.GroupOfProduct;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class TablePanel extends JPanel {
    static String[] GoodsTitles = {"id", "Product", "Group", "Manufacturer", "Price"};
    static String[] GroupTitles = {"id", "Group of products"};
    static JTable t = new JTable();
    JScrollPane scrollPane = new JScrollPane(t);
    static DefaultTableModel model = (DefaultTableModel) t.getModel();
    static JList studentList = new JList();

    GridBagLayout gbl = new GridBagLayout();

    public TablePanel(int titleType) {
        init(titleType);
        setLayout(gbl);
        studentList.setVisible(true);

        setBackground(Color.WHITE);
        init(1);
        add(scrollPane, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(1, 0, 0, 0), 0, 430));
    }

    public static void addDataToGoodsTable(Product[] products, int titleNum) {
        String[] titles = titlesChoser(titleNum);
        Object[][] studs = new Object[products.length][];
        for (int i = 0; i < products.length; i++) {
            String[] productLine = new String[6];
            productLine[0] = (i + 1) + ".";
            productLine[1] = products[i].getProductName();
            productLine[2] = products[i].getGroupProducts();
            productLine[3] = products[i].getManufacturer();
            productLine[4] = String.valueOf(products[i].getPrice());
            studs[i] = productLine;
        }
        model.setDataVector(studs, titles);
        t.setModel(model);
    }

    public static void addDataToGroupOFGoodsTable(GroupOfProduct[] groupOfProduct, int titleNum) {
        String[] titles = titlesChoser(titleNum);
        Object[][] groups = new Object[groupOfProduct.length][];
        for (int i = 0; i < groupOfProduct.length; i++) {
            String[] groupLine = new String[2];
            groupLine[0] = (i + 1) + ".";
            groupLine[1] = groupOfProduct[i].getName();

            groups[i] = groupLine;
        }
        model.setDataVector(groups, titles);
        t.setModel(model);
    }

    public static void init(int titleNum) {
        t.setModel(new DefaultTableModel(null, titlesChoser(titleNum)));
    }

    private static String[] titlesChoser(int titleNum) {
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

}