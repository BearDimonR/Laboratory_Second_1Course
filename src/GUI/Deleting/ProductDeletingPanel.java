package GUI.Deleting;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ProductDeletingPanel extends JPanel {
    JLabel productDeleteBackground = new JLabel(new ImageIcon("images/productDeletingHeader.jpg"));
    JLabel productClearBackground = new JLabel(new ImageIcon("images/productClearBody.jpg"));
    private static JLabel modeSwitchOff = new JLabel(new ImageIcon("images/GroupCreateModeOff.png"));

    JLabel btnFind = new JLabel(new ImageIcon("images/findVerticalButton.jpg"));

    public ProductDeletingPanel() {
        setLayout(null);
        productDeleteBackground.setLayout(null);
        add(productDeleteBackground);
        add(productClearBackground);
        productDeleteBackground.add(modeSwitchOff);
        productDeleteBackground.add(btnFind);
        btnFind.setBounds(13, 47, 54, 110);
        productDeleteBackground.setBounds(0, 0, 914, 175);
        modeSwitchOff.setBounds(536, 5, 26, 26);
        productClearBackground.setBounds(0, 175, 914, 491);

        btnFind.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("fcadvfa");
            }
        });
        modeSwitchOff.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DeletingPanel.showGroupDeleteTab();
            }
        });
    }

}
