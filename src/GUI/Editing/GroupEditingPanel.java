package GUI.Editing;

import BackGround.GroupOfProduct;
import BackGround.Stock;
import BackGround.Utilities;
import GUI.General.AppStyles;
import GUI.General.DonePanel;
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
    private JLabel btnDesEdit = new JLabel(new ImageIcon("images/deselectedEditBTN.jpg"));
    private JLabel backgroundHeader = new JLabel(new ImageIcon("images/editComponents/groupEditHeader.jpg"));
    private JLabel tableBodyBackground = new JLabel(new ImageIcon("images/tableGroupBodyBackground.jpg"));
    private JLabel editFieldsBodyBackground = new JLabel(new ImageIcon("images/editComponents/groupEditBody.jpg"));
    private JLabel btnFind = new JLabel(new ImageIcon("images/findHorizontalBTN.jpg"));
    private JTextField tfNewGroupName = new JTextField();
    private JTextArea taNewDescription = new JTextArea();
    private JLabel lbOldGroupName = new JLabel();
    private JTextArea taOldDescription = new JTextArea();
    private JScrollPane spNewDescription = new JScrollPane(taNewDescription);
    private JScrollPane spOldDescription = new JScrollPane(taOldDescription);
    private JTextField tfGroupNameSearch = new JTextField();
    private TablePanel tablePanel = new TablePanel(2);
    private static JLabel btnModeSwitchOn = new JLabel(new ImageIcon("images/groupCreateModeOnBTN.png"));
    private static JLabel arrowBack = new JLabel(new ImageIcon("images/editComponents/back.png"));

    public GroupEditingPanel() {
        setLayout(AppStyles.gridBagLayout);
        backgroundHeader.setLayout(null);
        editFieldsBodyBackground.setLayout(null);
        tableBodyBackground.setLayout(null);
        tableBodyBackground.setVisible(true);
        editFieldsBodyBackground.setVisible(false);
        taOldDescription.setEditable(false);

        btnEdit.setVisible(false);


        tablePanel.addDataToGroupOFGoodsTable(Stock.getGroups(), 2);
        tablePanel.getTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (tablePanel.getTable().getSelectedRow() == -1) return;
                tableBodyBackground.setVisible(false);
                editFieldsBodyBackground.setVisible(true);
                lbOldGroupName.setText(tablePanel.getSelectedGroup().getName());
                taOldDescription.setText(tablePanel.getSelectedGroup().getDescription());
                tfNewGroupName.setText(tablePanel.getSelectedGroup().getName());
                taNewDescription.setText(tablePanel.getSelectedGroup().getDescription());
            }
        });
        addElementsToGroupEditingPanel();
        addMouseListenersToBTNS();

        setStyleOfHeaderElements();
        setStyleOfUserInputElements();
    }

    /**
     * Method adds action listeners to all buttons
     * of group edit panel
     */
    private void addMouseListenersToBTNS() {


        arrowBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tableBodyBackground.setVisible(true);
                editFieldsBodyBackground.setVisible(false);
                tablePanel.getTable().clearSelection();
            }
        });

        // Action listener of find button
        btnFind.addMouseListener(new MouseAdapter() {
            @Override

            public void mouseClicked(MouseEvent e) {
//                if(tfGroupNameSearch.getText().matches("[ ]*")==false
//
//                ){
                //метод додавання інформації до таблиці перший параметр - масив груп, другий елемент - тип таблиці (1 - goods, 2-group)
                //tablePanel.addDataToGroupOFGoodsTable(,2);
                System.out.println("кнопка FIND натиснута");
                updateTable(tfGroupNameSearch.getText());
                //               }
            }
        });

        // Action listener of edit button
        btnEdit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                GroupOfProduct group = tablePanel.getSelectedGroup();
                tablePanel.getTable().clearSelection();
                group.setDescription(taNewDescription.getText());
                group.setName(tfNewGroupName.getText());
                Stock.saveData();
                taNewDescription.setText("");
                taOldDescription.setText("");
                tfNewGroupName.setText("");
                lbOldGroupName.setText("");
                tablePanel.addDataToGroupOFGoodsTable(Stock.getGroups(), 2);
                editFieldsBodyBackground.setVisible(false);
                tableBodyBackground.setVisible(true);
                DonePanel d = new DonePanel();

            }
        });

        // Action listener of toggle button
        btnModeSwitchOn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                EditingPanel.showProductDeleteTab();
            }
        });

        // Key listener of new group name text field
        tfNewGroupName.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                checkFields();
            }
        });

        // Key listener of new group description text area
        taNewDescription.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                checkFields();
            }
        });
    }

    /**
     * Method which check if fields are filled properly
     */
    private void checkFields() {
        Matcher matcher = Pattern.compile("([\"]?[a-zA-ZА-Яa-я]+\\d*[\"]?(\\s?|([-]?))[\"]?[a-zA-ZА-Яa-яєї]+\\d*[\"]?)+").matcher(tfNewGroupName.getText());
        //setVisible to edit
        if (!matcher.matches() || tfNewGroupName.getText().length() > 20) setEditDisabled();
        else if (taNewDescription.getText() == null || taNewDescription.getText().equals("")) setEditDisabled();
        else if (Stock.findProductByName(tfNewGroupName.getText()) != null) setEditDisabled();
        else setEditEnable();
    }

    /**
     * Method adds elements to group editing panel
     */
    private void addElementsToGroupEditingPanel() {
        add(backgroundHeader, new GridBagConstraints(0, 0, 1, 1, 1, 0.2,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        add(tableBodyBackground, new GridBagConstraints(0, 1, 1, 1, 1, 0.8,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        add(editFieldsBodyBackground, new GridBagConstraints(0, 1, 1, 1, 1, 0.8,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        addElementsToHeaderBackground();
        addElementsToBodyPanel();
        addElementsToTableBodyPanel();
    }

    /**
     * Method adds elements to body with txt fields
     */
    private void addElementsToBodyPanel() {
        editFieldsBodyBackground.add(lbOldGroupName);
        editFieldsBodyBackground.add(spOldDescription);
        editFieldsBodyBackground.add(tfNewGroupName);
        editFieldsBodyBackground.add(spNewDescription);
        editFieldsBodyBackground.add(btnEdit);
        editFieldsBodyBackground.add(btnDesEdit);
        editFieldsBodyBackground.add(arrowBack);
        arrowBack.setBounds(20, 0, 26, 26);
        lbOldGroupName.setBounds(112, 123, 305, 20);
        spOldDescription.setBounds(110, 181, 305, 120);
        tfNewGroupName.setBounds(536, 124, 305, 20);
        spNewDescription.setBounds(536, 181, 305, 120);
        btnEdit.setBounds(375, 410, 165, 40);
        btnDesEdit.setBounds(375, 410, 165, 40);

    }

    /**
     * Method adds table to table body panel
     */
    private void addElementsToTableBodyPanel() {
        tableBodyBackground.add(tablePanel);
        tablePanel.setBounds(35, 20, 850, 500);
    }

    /**
     * Method adds elements to header background
     */
    private void addElementsToHeaderBackground() {
        backgroundHeader.add(btnFind);
        backgroundHeader.add(tfGroupNameSearch);
        backgroundHeader.add(btnModeSwitchOn);
        btnModeSwitchOn.setBounds(544, 5, 26, 26);
        btnFind.setBounds(14, 48, 107, 53);
        tfGroupNameSearch.setBounds(410, 67, 228, 20);
    }

    public void updateTable(String group) {

        tablePanel.addDataToGroupOFGoodsTable(Utilities.mainSearch2(group), 1);
        //tablePanel.addDataToGoodsTable(Stock.getAllProducts(),1);

    }

    /**
     * Method set style of elements which are on header
     */
    private void setStyleOfHeaderElements() {
        tfGroupNameSearch.setFont(AppStyles.appH2Font);
        tfGroupNameSearch.setForeground(AppStyles.MainColor);
        tfGroupNameSearch.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));


    }

    /**
     * Method set style of elements which are on header
     */
    private void setStyleOfUserInputElements() {
        lbOldGroupName.setFont(AppStyles.appH2Font);
        lbOldGroupName.setForeground(AppStyles.MainColor);
        lbOldGroupName.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        tfNewGroupName.setFont(AppStyles.appH2Font);
        tfNewGroupName.setForeground(AppStyles.MainColor);
        tfNewGroupName.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        taOldDescription.setFont(AppStyles.appH2Font);
        taOldDescription.setForeground(AppStyles.MainColor);
        spOldDescription.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        taNewDescription.setFont(AppStyles.appH2Font);
        taNewDescription.setForeground(AppStyles.MainColor);
        spNewDescription.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
    }

    /**
     * Method set edit button in disabled mode
     */
    private void setEditEnable() {
        btnEdit.setVisible(true);
        btnDesEdit.setVisible(false);
    }

    /**
     * Method set edit button in disabled mode
     */
    private void setEditDisabled() {
        btnEdit.setVisible(false);
        btnDesEdit.setVisible(true);
    }

    TablePanel getTablePanel() {
        return tablePanel;
    }
}
