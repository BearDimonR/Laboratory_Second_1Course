package GUI.Deleting;

import BackGround.Stock;
import GUI.General.TablePanel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GroupDeletingPanel extends JPanel {
    JLabel backgroundHeader = new JLabel(new ImageIcon("images/deleteComponents/groupDeleteHeader.jpg"));
    JLabel tableBackground = new JLabel(new ImageIcon("images/tableBodyBackground.jpg"));
    JLabel btnFind = new JLabel(new ImageIcon("images/findVerticalBTN.jpg"));
    JLabel btnDelete = new JLabel(new ImageIcon("images/createBTN.jpg"));
    private static JLabel modeSwitchOn = new JLabel(new ImageIcon("images/groupCreateModeOnBTN.png"));
    private JTextField tfGroupNameSearch = new JTextField();
    private TablePanel tablePanel = new TablePanel(2);

    public GroupDeletingPanel() {
        setLayout(null);
        backgroundHeader.setLayout(null);
        tableBackground.setLayout(null);
        add(backgroundHeader);
        add(tableBackground);
        addElementsToGroupDeltePanel();
        addListners();

        tablePanel.addDataToGroupOFGoodsTable(Stock.getGroups(),2);
    }

    private void addElementsToGroupDeltePanel() {
        backgroundHeader.setBounds(0, 0, 914, 175);
        tableBackground.setBounds(0, 175, 914, 491);
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
        btnFind.setBounds(13, 47, 54, 110);
        tfGroupNameSearch.setBounds(423, 88, 340, 25);
        modeSwitchOn.setBounds(536, 5, 26, 26);

    }

    public TablePanel getTablePanel() {
        return tablePanel;
    }

    private void addListners() {
        btnFind.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
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
                if(tablePanel.getSelectedGroup() == null) return;
                Stock.getGroups().remove(tablePanel.getSelectedGroup());
                tablePanel.addDataToGroupOFGoodsTable(Stock.getGroups(),2);
            }
        });
    }
}
