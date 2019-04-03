package GUI.MainComponents;

import GUI.*;
import GUI.Creating.CreationPanel;
import GUI.Deleting.DeletingPanel;
import GUI.Editing.EditingPanel;
import GUI.General.AppStyles;
import GUI.Search.SearchPanel;

import javax.swing.*;
import java.awt.*;

public class ContentPanel extends JPanel {
    private static CreationPanel creationPanel = new CreationPanel();
    private static EditingPanel editingPanel = new EditingPanel();
    private static DeletingPanel deletingPanel = new DeletingPanel();
    private static SearchPanel searchPanel = new SearchPanel();
    private static QuantityPanel quantityPanel = new QuantityPanel();
    private static SettingPanel settingPanel = new SettingPanel();

    public ContentPanel() {
        setLayout(AppStyles.gridBagLayout);
        showPanel(1);
        //set size of content panel
        {
            setSize(new Dimension(914, 665));
            setPreferredSize(new Dimension(915, 665));
            setMaximumSize(new Dimension(915, 665));
            setMinimumSize(new Dimension(915, 665));
        }
        //add panels
        {
            add(creationPanel, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                    GridBagConstraints.NORTH, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            add(editingPanel, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                    GridBagConstraints.NORTH, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            add(deletingPanel, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                    GridBagConstraints.NORTH, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            add(quantityPanel, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                    GridBagConstraints.NORTH, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            add(settingPanel, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                    GridBagConstraints.NORTH, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            add(searchPanel, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                    GridBagConstraints.NORTH, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));

        }
    }

    public static void showPanel(int j) {
        creationPanel.setVisible(false);
        deletingPanel.setVisible(false);
        editingPanel.setVisible(false);
        quantityPanel.setVisible(false);
        searchPanel.setVisible(false);
        settingPanel.setVisible(false);
        switch (j) {
            case 1:
                creationPanel.setVisible(true);
                break;
            case 2:
                editingPanel.setVisible(true);
                editingPanel.updateTable();
                break;
            case 3:
                deletingPanel.setVisible(true);
                DeletingPanel.updateTable();
                break;
            case 4:
                quantityPanel.setVisible(true);
                quantityPanel.updateTable();
                break;
            case 5:
                settingPanel.setVisible(true);
                break;
            case 6:
                searchPanel.setVisible(true);
                break;
        }
    }
}
