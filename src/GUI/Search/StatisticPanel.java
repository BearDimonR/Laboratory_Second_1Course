package GUI.Search;

import GUI.General.TablePanel;

import javax.swing.*;
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
    }
private void setDefaultVisibility(){
        tickAll.setVisible(true);
        deTickAll.setVisible(false);
        tickGroup.setVisible(false);
        deTickGroup.setVisible(true);
}
}
