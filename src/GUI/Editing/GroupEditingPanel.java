package GUI.Editing;

import BackGround.GroupOfProduct;
import BackGround.Stock;
import GUI.General.AppStyles;
import GUI.General.TablePanel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        backgroundHeader.setLayout(null);
        editFieldsBodyBackground.setLayout(null);
        tableBodyBackground.setLayout(null);
        tableBodyBackground.setVisible(true);
        editFieldsBodyBackground.setVisible(false);
        tfOldGroupName.setEditable(false);
        taOldDescription.setEditable(false);
        //to edit
        btnEdit.setVisible(false);

        tablePanel.addDataToGroupOFGoodsTable(Stock.getGroups(), 2);
        tablePanel.getTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(tablePanel.getTable().getSelectedRow() == -1) return;
                tableBodyBackground.setVisible(false);
                editFieldsBodyBackground.setVisible(true);
                tfOldGroupName.setText(tablePanel.getSelectedGroup().getName());
                taOldDescription.setText(tablePanel.getSelectedGroup().getDescription());
                tfNewGroupName.setText(tablePanel.getSelectedGroup().getName());
                taNewDescription.setText(tablePanel.getSelectedGroup().getDescription());
            }
        });
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
                //setVisible to edit
                if (!btnEdit.isVisible()) return;
                GroupOfProduct group = tablePanel.getSelectedGroup();
                tablePanel.getTable().clearSelection();
                group.setDescription(taNewDescription.getText());
                group.setName(tfNewGroupName.getText());
                taNewDescription.setText("");
                taOldDescription.setText("");
                tfNewGroupName.setText("");
                tfOldGroupName.setText("");
                tablePanel.addDataToGroupOFGoodsTable(Stock.getGroups(),2);
                editFieldsBodyBackground.setVisible(false);
                tableBodyBackground.setVisible(true);


            }
        });
        tfNewGroupName.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                checkFields();
            }
        });
        taNewDescription.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                checkFields();
            }
        });
    }

    private void checkFields() {
        Matcher matcher = Pattern.compile("([\"]?[a-zA-ZА-Яa-я]+\\d*[\"]?(\\s?|([-]?))[\"]?[a-zA-ZА-Яa-яєї]+\\d*[\"]?)+").matcher(tfNewGroupName.getText());
        //setVisible to edit
        if (!matcher.matches() || tfNewGroupName.getText().length() > 20) btnEdit.setVisible(false);
        else if (taNewDescription.getText() == null || taNewDescription.getText().equals("")) btnEdit.setVisible(false);
        else btnEdit.setVisible(true);
    }

    TablePanel getTablePanel() {
        return tablePanel;
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

        editFieldsBodyBackground.add(tfOldGroupName);
        editFieldsBodyBackground.add(spOldDescription);
        editFieldsBodyBackground.add(tfNewGroupName);
        editFieldsBodyBackground.add(spNewDescription);
        editFieldsBodyBackground.add(btnEdit);
        tfOldGroupName.setBounds(112, 66, 305, 20);
        spOldDescription.setBounds(110, 123, 305, 120);
        tfNewGroupName.setBounds(536, 66, 305, 20);
        spNewDescription.setBounds(536, 123, 305, 120);

        btnEdit.setBounds(375, 410, 165, 40);
        
    }

    private void addElementsToClearBodyPanel() {
        tableBodyBackground.add(tablePanel);
        tablePanel.setBounds(35, 20, 850, 430);
    }

    private void addElementsToHeaderBackground() {
        backgroundHeader.add(btnFind);
        backgroundHeader.add(tfGroupNameSearch);
        btnFind.setBounds(13, 47, 54, 110);
        tfGroupNameSearch.setBounds(423, 88, 340, 25);
    }

}
