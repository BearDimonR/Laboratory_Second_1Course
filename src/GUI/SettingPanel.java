package GUI;

import GUI.General.AppStyles;

import javax.swing.*;
import java.awt.*;

public class SettingPanel extends JPanel {
    JLabel background = new JLabel(new ImageIcon("images/Settings.jpg"));
    JLabel createTick = new JLabel(new ImageIcon("images/Tick.jpg"));
    JLabel deCreateTick = new JLabel(new ImageIcon("images/deTick.jpg"));
    JLabel editTick = new JLabel(new ImageIcon("images/Tick.jpg"));
    JLabel deEditTick = new JLabel(new ImageIcon("images/deTick.jpg"));
    JLabel deleteTick = new JLabel(new ImageIcon("images/Tick.jpg"));
    JLabel deDeleteTick = new JLabel(new ImageIcon("images/deTick.jpg"));
    JLabel quantityTick = new JLabel(new ImageIcon("images/Tick.jpg"));
    JLabel deQuantityTick = new JLabel(new ImageIcon("images/deTick.jpg"));
    JLabel searchTick = new JLabel(new ImageIcon("images/Tick.jpg"));
    JLabel deSearchTick = new JLabel(new ImageIcon("images/deTick.jpg"));
    JLabel blockTick = new JLabel(new ImageIcon("images/Tick.jpg"));
    JLabel deBlockTick = new JLabel(new ImageIcon("images/deTick.jpg"));

    public SettingPanel() {
        setLayout(null);
        add(background);
        background.setBounds(0, 0, 914, 666);
        background.add(createTick);
        background.add(deCreateTick);
        background.add(editTick);
        background.add(deEditTick);
        background.add(deleteTick);
        background.add(deDeleteTick);
        background.add(quantityTick);
        background.add(deQuantityTick);
        background.add(searchTick);
        background.add(deSearchTick);
        background.add(blockTick);
        background.add(deBlockTick);
        createTick.setBounds(456, 197, 28, 28);
        deCreateTick.setBounds(456, 197, 28, 28);
        editTick.setBounds(456, 262, 28, 28);
        deEditTick.setBounds(456, 262, 28, 28);
        deleteTick.setBounds(456, 325, 28, 28);
        deDeleteTick.setBounds(456, 325, 28, 28);
        quantityTick.setBounds(456, 389, 28, 28);
        deQuantityTick.setBounds(456, 389, 28, 28);
        searchTick.setBounds(456, 452, 28, 28);
        deSearchTick.setBounds(456, 452, 28, 28);
        blockTick.setBounds(456, 514, 28, 28);
        deBlockTick.setBounds(456, 514, 28, 28);
    }
}
