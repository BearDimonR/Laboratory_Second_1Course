package GUI.Search;

import BackGround.Stock;
import BackGround.Utilities;
import GUI.Editing.ProductEditingPanel;
import GUI.General.TablePanel;
import GUI.MainComponents.ContentPanel;
import GUI.MainComponents.TitleBarPanel;
import GUI.MainComponents.ToolBarPanel;

import javax.swing.*;
import java.awt.event.*;

public class ProductSearchPanel extends JPanel {
    JLabel backgroundHeader = new JLabel(new ImageIcon("images/Search/SearchHeader.jpg"));
    JLabel tableBackground = new JLabel(new ImageIcon("images/tableBodyBackground.jpg"));
    private JLabel btnFind = new JLabel(new ImageIcon("images/findVerticalBTN.jpg"));
    private JTextField tfproductNameSearch = new JTextField();
    private JTextField tfManufacturerSearch = new JTextField();
    private JTextField tfLowestPriceearch = new JTextField();
    private JTextField tfHighestPriceSearch = new JTextField();
    private JComboBox cbProductGroupSearch = new JComboBox();
    private static JLabel btnModeSwitchOff = new JLabel(new ImageIcon("images/groupCreateModeOffBTN.png"));
    public static   TablePanel tablePanel = new TablePanel(1);

    public ProductSearchPanel() {
        setLayout(null);
        backgroundHeader.setLayout(null);
        add(backgroundHeader);
        add(tableBackground);
        backgroundHeader.setBounds(0, 0, 914, 175);
        tableBackground.setBounds(0, 175, 914, 491);
        addElementsToBackgroundHeader();

        addElementsToTableBackgroundBody();

        btnModeSwitchOff.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SearchPanel.showStatistickPanel();
            }
        });
        addEctionListener();
        cheakBox();
    }

    private void addElementsToBackgroundHeader() {
        btnFind.setBounds(13, 47, 54, 110);
        backgroundHeader.add(btnFind);
        backgroundHeader.add(tfproductNameSearch);
        backgroundHeader.add(cbProductGroupSearch);
        backgroundHeader.add(tfManufacturerSearch);
        backgroundHeader.add(tfLowestPriceearch);
        backgroundHeader.add(tfHighestPriceSearch);
        backgroundHeader.add(btnModeSwitchOff);
        btnModeSwitchOff.setBounds(544, 5, 26, 26);
        tfproductNameSearch.setBounds(229, 74, 227, 18);
        tfManufacturerSearch.setBounds(229, 114, 227, 18);
        cbProductGroupSearch.setBounds(648, 74, 227, 17);
        tfLowestPriceearch.setBounds(649, 114, 60, 18);
        tfHighestPriceSearch.setBounds(756, 114, 60, 18);

        addKeyListener();
         //   tablePanel.addDataToGoodsTable(Utilities.Search(TitleBarPanel.tfSearch.getText()), 1);
            System.out.println(TitleBarPanel.tfSearch.getText() + "=search1");
            // tablePanel.addDataToGoodsTable(Stock.getAllProducts(),1);


    }
private void addKeyListener(){
    TitleBarPanel.tfSearch.addKeyListener(new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
            System.out.println("77777");
            System.out.println(TitleBarPanel.tfSearch.getText()+"=search");
        }

        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("88888");
            System.out.println(TitleBarPanel.tfSearch.getText()+"=search");
        }

        @Override
        public void keyReleased(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                System.out.println("99999");
                System.out.println(TitleBarPanel.tfSearch.getText()+"=search");
                String group = TitleBarPanel.tfSearch.getText();
               // tablePanel.addDataToGoodsTable(Utilities.mainSearch(group,group,group,0,50), 1);
               // tablePanel.addDataToGoodsTable(Utilities.Search(group), 1);

            }
        }
    });
}



    private void addElementsToTableBackgroundBody() {
        tableBackground.add(tablePanel);
        tablePanel.setBounds(35, 20, 850, 441);
    }
    private void addEctionListener(){
        btnFind.addMouseListener(new MouseAdapter(){
            @Override

            public void mouseClicked(MouseEvent e){
                System.out.println("1234567890");
                String group = (String ) String.valueOf(cbProductGroupSearch.getSelectedItem());
                if(tfproductNameSearch.getText().matches("[ ]*")==false||
                        tfManufacturerSearch.getText().matches("[ ]*")==false||
                        tfLowestPriceearch.getText().matches("[ ]*")==false||
                        tfHighestPriceSearch.getText().matches("[ ]*")==false
                        || group.matches("[ ]*")==false
                ){

                 updateTable();

                }
            }
        });
    }
    public void cheakBox() {
        cbProductGroupSearch.removeAllItems();
        for (int i = 0; i < Stock.getGroups().size(); i++) {
            cbProductGroupSearch.addItem((Stock.getGroups().get(i).getName()));
        }
    }



    private void updateTable() {
        String group = (String) cbProductGroupSearch.getSelectedItem();
        String product = tfproductNameSearch.getText();
        String manufacturer = tfManufacturerSearch.getText();
        String priceFrom = tfLowestPriceearch.getText();
        String priceTo = tfHighestPriceSearch.getText();

        double prFrom = 0;
        if (tfLowestPriceearch.getText().matches("[ ]*") == true) {
            prFrom = 0;
        } else if (tfLowestPriceearch.getText().matches("[\\d]+[.]?[\\d]*") == true) {
            prFrom = Double.valueOf(priceFrom);
        }
        double prTo = 150;
        if (tfHighestPriceSearch.getText().equals(""))
            prTo = 0;
        else prTo = Double.parseDouble(tfHighestPriceSearch.getText());
        tablePanel.addDataToGoodsTable(Utilities.mainSearch(group, product, manufacturer, prFrom, prTo), 1);
        //tablePanel.addDataToGoodsTable(Stock.getAllProducts(),1);

    }
}
