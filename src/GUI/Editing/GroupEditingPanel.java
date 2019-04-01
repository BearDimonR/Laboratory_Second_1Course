package GUI.Editing;

import GUI.General.AppStyles;
import GUI.General.TablePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GroupEditingPanel extends JPanel {

    private JLabel btnEdit = new JLabel(new ImageIcon("images/editBTN.jpg"));
    private JLabel backgroundHeader = new JLabel(new ImageIcon("images/editComponents/groupEditHeader.jpg"));
    private JLabel tableBodyBackground = new JLabel(new ImageIcon("images/tableBodyBackground.jpg"));
    private JLabel editFieldsBodyBackground = new JLabel(new ImageIcon("images/editComponents/groupEditBody.jpg"));
    private JLabel btnFind = new JLabel(new ImageIcon("images/findVerticalBTN.jpg"));
    private JTextField tfNewGroupName = new JTextField();
    private JTextArea taNewDescription = new JTextArea();
    private JTextField tfOldGroupName = new JTextField();
    private JTextArea taOldDescription = new JTextArea();
    private JScrollPane spNewDescription = new JScrollPane(taNewDescription);
    private JScrollPane spOldDescription = new JScrollPane(taOldDescription);
    private JTextField tfGroupNameSearch = new JTextField();
    private TablePanel tablePanel = new TablePanel(2);

    public GroupEditingPanel() {
        setLayout(AppStyles.gridBagLayout);
        backgroundHeader.setLayout(AppStyles.gridBagLayout);
        editFieldsBodyBackground.setLayout(AppStyles.gridBagLayout);
        tableBodyBackground.setLayout(AppStyles.gridBagLayout);
        tableBodyBackground.setVisible(false);
        editFieldsBodyBackground.setVisible(true);

        addElementsToGroupEditingPanel();
        addMouseListenersToBTNS();
    }

    private void addMouseListenersToBTNS() {
        btnFind.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //метод додавання інформації до таблиці перший параметр - масив груп, другий елемент - тип таблиці (1 - goods, 2-group)
                //tablePanel.addDataToGroupOFGoodsTable(,2);
            }
        });
        btnEdit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });
    }

    private void addElementsToGroupEditingPanel() {
        add(backgroundHeader, new GridBagConstraints(0, 0, 1, 1, 1, 0.6,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        add(tableBodyBackground, new GridBagConstraints(0, 1, 1, 1, 1, 0.6,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        add(editFieldsBodyBackground, new GridBagConstraints(0, 1, 1, 1, 1, 0.6,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        addElementsToHeaderBackground();
        addElementsToBodyPanel();
        addElementsToClearBodyPanel();
    }

    private void addElementsToBodyPanel() {

        editFieldsBodyBackground.add(tfOldGroupName, new GridBagConstraints(0, 0, 1, 1, 0.2, 0.0001,
                GridBagConstraints.NORTHWEST, GridBagConstraints.CENTER,
                new Insets(65, 111, 0, 0), 300, 0));
        editFieldsBodyBackground.add(spOldDescription, new GridBagConstraints(0, 1, 1, 1, 0.8, 0.00001,
                GridBagConstraints.NORTHWEST, GridBagConstraints.CENTER,
                new Insets(-68, 111, 0, 0), 300, 100));
        editFieldsBodyBackground.add(tfNewGroupName, new GridBagConstraints(1, 0, 1, 1, 0.2, 0.00001,
                GridBagConstraints.NORTHWEST, GridBagConstraints.NORTH,
                new Insets(65, 50, 0, 0), 300, 0));
        editFieldsBodyBackground.add(spNewDescription, new GridBagConstraints(1, 1, 1, 1, 0.8, 0.0001,
                GridBagConstraints.NORTHWEST, GridBagConstraints.NORTH,
                new Insets(-68, 50, 0, 0), 300, 100));
        editFieldsBodyBackground.add(btnEdit, new GridBagConstraints(0, 2, 2, 1, 1, 0.0001,
                GridBagConstraints.CENTER, GridBagConstraints.CENTER,
                new Insets(0, 50, 0, 0), 0, 0));

    }

    private void addElementsToClearBodyPanel() {
        tableBodyBackground.add(tablePanel, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                GridBagConstraints.CENTER, GridBagConstraints.CENTER,
                new Insets(0, 0, 0, 0), 800, 0));
    }

    private void addElementsToHeaderBackground() {
        backgroundHeader.add(btnFind, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                GridBagConstraints.WEST, GridBagConstraints.CENTER,
                new Insets(30, 14, 0, 0), 0, 0));
        backgroundHeader.add(tfGroupNameSearch, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                GridBagConstraints.CENTER, GridBagConstraints.CENTER,
                new Insets(15, 275, 0, 0), 340, 0));
    }

}
