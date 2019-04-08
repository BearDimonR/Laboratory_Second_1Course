package GUI.Deleting;

import BackGround.Stock;
import BackGround.Utilities;
import GUI.General.AppStyles;
import GUI.General.TablePanel;
import GUI.MainComponents.TitleBarPanel;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GroupDeletingPanel extends JPanel {
    JLabel backgroundHeader = new JLabel(new ImageIcon("images/deleteComponents/groupDeleteHeader.jpg"));
    JLabel tableBackground = new JLabel(new ImageIcon("images/tableGroupBodyBackground.jpg"));
    JLabel btnFind = new JLabel(new ImageIcon("images/findHorizontalBTN.jpg"));
    JLabel btnDelete = new JLabel(new ImageIcon("images/deleteBTN.jpg"));
    private static JLabel modeSwitchOn = new JLabel(new ImageIcon("images/groupCreateModeOnBTN.png"));
    private JTextField tfGroupNameSearch = new JTextField();
    private TablePanel tablePanel = new TablePanel(2);

    public GroupDeletingPanel() {
        setLayout(null);
        backgroundHeader.setLayout(null);
        tableBackground.setLayout(null);
        add(backgroundHeader);
        add(tableBackground);
        addElementsToGroupDeletePanel();
        addListners();
        setStyleOfHeader();
        tablePanel.addDataToGroupOFGoodsTable(Stock.getGroups(), 2);

        System.out.println("група \n" + Stock.getGroups());
    }

    private void addElementsToGroupDeletePanel() {
        backgroundHeader.setBounds(0, 0, 914, 117);
        tableBackground.setBounds(0, 117, 914, 549);
        addElementsToHeaderBackground();
        addElementsToTableBackground();
    }

    private void addElementsToTableBackground() {
        tableBackground.add(btnDelete);
        tableBackground.add(tablePanel);
        tablePanel.setBounds(35, 15, 850, 400);
        btnDelete.setBounds(375, 420, 165, 40);
    }

    private void addElementsToHeaderBackground() {
        backgroundHeader.add(btnFind);
        backgroundHeader.add(modeSwitchOn);
        backgroundHeader.add(tfGroupNameSearch);
        backgroundHeader.add(btnDelete);
        btnFind.setBounds(14, 48, 107, 53);
        tfGroupNameSearch.setBounds(410, 67, 228, 20);
        modeSwitchOn.setBounds(544, 5, 26, 26);

    }

    TablePanel getTablePanel() {
        return tablePanel;
    }

    private void addListners() {
        btnFind.addMouseListener(new MouseAdapter() {
            @Override

            public void mouseClicked(MouseEvent e) {
                tablePanel.addDataToGroupOFGoodsTable((Utilities.mainSearch2(tfGroupNameSearch.getText())), 2);

            }
//            }
        });
        modeSwitchOn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DeletingPanel.showProductDeleteTab();
            }
        });
        btnDelete.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (tablePanel.getSelectedGroup() == null) return;
                Stock.getGroups().remove(tablePanel.getSelectedGroup());

                Stock.saveData();
                TitleBarPanel.setStats();
                tablePanel.addDataToGroupOFGoodsTable(Stock.getGroups(), 2);

            }
        });

    }

    public void updateTable(String group) {

        tablePanel.addDataToGroupOFGoodsTable(Utilities.mainSearch2(group), 1);
    }

    private void setStyleOfHeader() {
        tfGroupNameSearch.setFont(AppStyles.appH2Font);
        tfGroupNameSearch.setForeground(AppStyles.MainColor);
        tfGroupNameSearch.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
    }


}
