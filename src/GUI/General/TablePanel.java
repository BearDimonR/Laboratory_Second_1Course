package GUI.General;



import BackGround.Goods;
import BackGround.GroupGoods;
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

    public static void addDataToGoodsTable(Goods[] goods, int titleNum) {
        String[] titles = titlesChoser(titleNum);
        Object[][] studs = new Object[goods.length][];
        for (int i = 0; i < goods.length; i++) {
            String[] studentLine = new String[6];
            studentLine[0] = (i + 1) + ".";
            studentLine[1] = goods[i].getName();
            studentLine[2] = goods[i].getGroupGoods();
            studentLine[3] = goods[i].getMaker();
            studentLine[4] = String.valueOf(goods[i].getPrice());
            studs[i] = studentLine;
        }
        model.setDataVector(studs, titles);
        t.setModel(model);
    }
    public static void addDataToGroupOFGoodsTable(GroupGoods[] groupGoods, int titleNum) {
        String[] titles = titlesChoser(titleNum);
        Object[][] groups = new Object[groupGoods.length][];
        for (int i = 0; i < groupGoods.length; i++) {
            String[] studentLine = new String[2];
            studentLine[0] = (i + 1) + ".";
            studentLine[1] = groupGoods[i].getName();

            groups[i] = studentLine;
        }
        model.setDataVector(groups, titles);
        t.setModel(model);
    }

    public static void init(int titleNum)
    {
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