package GUI.Deleting;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GroupDeletingPanel extends JPanel {
    JLabel groupDeleteBackground = new JLabel(new ImageIcon("images/groupDeleteHeader.jpg"));
    JLabel groupClearBackground = new JLabel(new ImageIcon("images/productClearBody.jpg"));
    JLabel btnFind = new JLabel(new ImageIcon("images/findVerticalButton.jpg"));
    private static JLabel modeSwitchOn = new JLabel(new ImageIcon("images/GroupCreateModeOn.png"));
    public GroupDeletingPanel() {
        setLayout(null);
        groupDeleteBackground.setLayout(null);
        add(groupDeleteBackground);
        add(groupClearBackground);
        groupDeleteBackground.add(modeSwitchOn);
        groupDeleteBackground.add(btnFind);
        groupDeleteBackground.setBounds(0, 0, 914, 175);
        groupClearBackground.setBounds(0, 175, 914, 491);
        modeSwitchOn.setBounds(536, 5, 26, 26);
        btnFind.setBounds(13, 47, 54, 110);
        btnFind.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("fcadvfa");
            }
        });
        modeSwitchOn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DeletingPanel.showProductDeleteTab();
            }
        });
    }
}
