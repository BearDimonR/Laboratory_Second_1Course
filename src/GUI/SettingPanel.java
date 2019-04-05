package GUI;

import GUI.General.AppStyles;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SettingPanel extends JPanel {
    JLabel changeNameBTN = new JLabel(new ImageIcon("images/changeNameBTN.jpg"));
    JLabel changePictureBTN = new JLabel(new ImageIcon("images/changePictureBTN.jpg"));
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
    JComboBox workerChoser = new JComboBox();

    public SettingPanel() {
        setLayout(null);
        add(background);
        background.setBounds(0, 0, 914, 666);
        background.add(workerChoser);
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
        background.add(changePictureBTN);
        background.add(changeNameBTN);
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
        workerChoser.setBounds(486,110,280,20);
        changeNameBTN.setBounds(64,498,212,32);
        changePictureBTN.setBounds(64,569,212,32);
         setStyleOfWorkerChooser();
         addListenersToBTNS();
         addListenersToTickBTNS();
    }
    private void setStyleOfWorkerChooser(){
        workerChoser.setBackground(Color.WHITE);
        workerChoser.setFont(AppStyles.appH2Font);
        workerChoser.setForeground(AppStyles.MainColor);
        workerChoser.setUI(new BasicComboBoxUI());
    }
    private void addListenersToBTNS(){
        changePictureBTN.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
        changeNameBTN.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
    }
    private void addListenersToTickBTNS(){
        createTick.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                createTick.setVisible(false);
                deCreateTick.setVisible(true);
            }
        });
        deCreateTick.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                createTick.setVisible(true);
                deCreateTick.setVisible(false);
            }
        });
        editTick.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                editTick.setVisible(false);
                deEditTick.setVisible(true);
            }
        });
        deEditTick.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                editTick.setVisible(true);
                deEditTick.setVisible(false);
            }
        });
        deleteTick.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                deleteTick.setVisible(false);
                deDeleteTick.setVisible(true);
            }
        });
        deDeleteTick.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                deleteTick.setVisible(true);
                deDeleteTick.setVisible(false);
            }
        });
        quantityTick.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                quantityTick.setVisible(false);
                deQuantityTick.setVisible(true);
            }
        });
        deQuantityTick.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                quantityTick.setVisible(true);
                deQuantityTick.setVisible(false);
            }
        });
        searchTick.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                searchTick.setVisible(false);
                deSearchTick.setVisible(true);
            }
        });
        deSearchTick.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                searchTick.setVisible(true);
                deSearchTick.setVisible(false);
            }
        });
        blockTick.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                blockTick.setVisible(false);
                deBlockTick.setVisible(true);
            }
        });
        deBlockTick.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                blockTick.setVisible(true);
                deBlockTick.setVisible(false);
            }
        });
    }
}


