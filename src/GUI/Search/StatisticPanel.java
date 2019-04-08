package GUI.Search;

import BackGround.Stock;
import GUI.General.AppStyles;
import GUI.General.TablePanel;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StatisticPanel extends JPanel {
    JLabel backgroundHeader = new JLabel(new ImageIcon("images/Search/statisticHeader.jpg"));
    JLabel tableBackground = new JLabel(new ImageIcon("images/statisticTableBackground.jpg"));
    private JLabel btnFind = new JLabel(new ImageIcon("images/Search/showHorizontalBTN.jpg"));
    private JLabel tickAll = new JLabel(new ImageIcon("images/Search/tick.jpg"));
    private JLabel tickGroup = new JLabel(new ImageIcon("images/Search/tick.jpg"));
    private JLabel deTickAll = new JLabel(new ImageIcon("images/Search/emptyTick.jpg"));
    private JLabel deTickGroup = new JLabel(new ImageIcon("images/Search/emptyTick.jpg"));
    private JLabel totalPriceOfGroup = new JLabel("0" );
    private JComboBox cbProductGroupSearch = new JComboBox();
    private static JLabel btnModeSwitchOn = new JLabel(new ImageIcon("images/groupCreateModeOnBTN.png"));
    private TablePanel tablePanel = new TablePanel(1);

    public StatisticPanel() {

        setLayout(null);
        backgroundHeader.setLayout(null);
        add(backgroundHeader);
        add(tableBackground);
        backgroundHeader.setBounds(0, 0, 914, 117);
        tableBackground.setBounds(0, 117, 914, 549);
        addElementsToBackgroundHeader();
        addElementsToTableBackgroundBody();
        setDefaultVisibility();
        checkBox();
        btnModeSwitchOn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SearchPanel.showSearchPanel();
            }
        });
        deTickGroup.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tickGroup.setVisible(true);
                deTickGroup.setVisible(false);
                deTickAll.setVisible(true);
                tickAll.setVisible(false);
            }
        });
        deTickAll.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tickGroup.setVisible(false);
                deTickGroup.setVisible(true);
                deTickAll.setVisible(false);
                tickAll.setVisible(true);
            }
        });
        btnFind.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                update();
            }
        });
        tablePanel.addDataToGoodsTable(Stock.getAllProducts(), 1);
        setStyleOfHeaderElements();
    }

    private void addElementsToBackgroundHeader() {
        btnFind.setBounds(14, 48, 107, 53);
        backgroundHeader.add(btnFind);
        backgroundHeader.add(cbProductGroupSearch);
        backgroundHeader.add(btnModeSwitchOn);
        backgroundHeader.add(tickAll);
        backgroundHeader.add(tickGroup);
        backgroundHeader.add(deTickAll);
        backgroundHeader.add(deTickGroup);
        tickAll.setBounds(169, 51, 18, 18);
        deTickAll.setBounds(169, 51, 18, 18);
        tickGroup.setBounds(169, 80, 18, 18);
        deTickGroup.setBounds(169, 80, 18, 18);
        btnModeSwitchOn.setBounds(544, 5, 26, 26);
        cbProductGroupSearch.setBounds(616, 66, 227, 17);
    }

    private void addElementsToTableBackgroundBody() {

        tableBackground.add(tablePanel);
        tablePanel.setBounds(35, 20, 850, 480);
        tableBackground.add(totalPriceOfGroup);
        totalPriceOfGroup.setBounds(126,507,100,20);
    }

    private void setDefaultVisibility() {
        tickAll.setVisible(true);
        deTickAll.setVisible(false);
        tickGroup.setVisible(false);
        deTickGroup.setVisible(true);
    }

    public void checkBox() {
        cbProductGroupSearch.removeAllItems();
        for (int i = 0; i < Stock.getGroups().size(); i++) {
            cbProductGroupSearch.addItem((Stock.getGroups().get(i).getName()));
        }
    }

    public void update() {
      if(!deTickAll.isVisible()) {
          tablePanel.addStatsToGroupOFGoodsTable(Stock.getGroups(),3);
          totalPriceOfGroup.setText(String.valueOf(Stock.getAllPrice()));
      }
      else {
          tablePanel.addStatsToGoodsTable(Stock.findGroup(String.valueOf(cbProductGroupSearch.getSelectedItem())).getProducts(),4);
          totalPriceOfGroup.setText(String.valueOf(Stock.findGroup(String.valueOf(cbProductGroupSearch.getSelectedItem())).getGroupPrice()));
      }
    }
    private void setStyleOfHeaderElements() {
        cbProductGroupSearch.setBackground(Color.WHITE);
        cbProductGroupSearch.setFont(AppStyles.appH2Font);
        cbProductGroupSearch.setForeground(AppStyles.MainColor);
        cbProductGroupSearch.setUI(new BasicComboBoxUI());

    }
    //    private void addMouseListenersToBTNS() {
//        btnFind.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                String group = (String) String.valueOf(cbProductGroupSearch.getSelectedItem());
//               // updateTable(group);
//            }
//        });
//    }
//    public void updateTable(String group) {
//
//        tablePanel.addDataToGroupOFGoodsTable(Utilities.mainSearch2(group), 1);
//
//
//    }

}
