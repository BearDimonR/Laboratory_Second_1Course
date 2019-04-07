package GUI;

import BackGround.Stock;
import GUI.General.AppStyles;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class SettingPanel extends JPanel {
    JLabel changeNameBTN = new JLabel(new ImageIcon("images/changeNameBTN.jpg"));
    JLabel changePictureBTN = new JLabel(new ImageIcon("images/changePictureBTN.jpg"));
    JLabel profileSetBackground = new JLabel(new ImageIcon("images/SettingsProfilePlace.jpg"));
    JLabel adminTickSetBackground = new JLabel(new ImageIcon("images/SettingsTicksPlace.jpg"));
    JLabel userTickSetBackground = new JLabel(new ImageIcon("images/UserSettingBackground.jpg"));
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
        add(profileSetBackground);
        add(adminTickSetBackground);
        add(userTickSetBackground);
        profileSetBackground.setBounds(0, 0, 352, 666);
        adminTickSetBackground.setBounds(352, 0, 562, 666);
        userTickSetBackground.setBounds(352, 0, 562, 666);
        adminTickSetBackground.add(workerChoser);
        adminTickSetBackground.add(createTick);
        adminTickSetBackground.add(deCreateTick);
        adminTickSetBackground.add(editTick);
        adminTickSetBackground.add(deEditTick);
        adminTickSetBackground.add(deleteTick);
        adminTickSetBackground.add(deDeleteTick);
        adminTickSetBackground.add(quantityTick);
        adminTickSetBackground.add(deQuantityTick);
        adminTickSetBackground.add(searchTick);
        adminTickSetBackground.add(deSearchTick);
        adminTickSetBackground.add(blockTick);
        adminTickSetBackground.add(deBlockTick);
        profileSetBackground.add(changePictureBTN);
        profileSetBackground.add(changeNameBTN);
        userTickSetBackground.setVisible(false);
        createTick.setBounds(105, 197, 28, 28);
        deCreateTick.setBounds(105, 197, 28, 28);
        editTick.setBounds(105, 262, 28, 28);
        deEditTick.setBounds(105, 262, 28, 28);
        deleteTick.setBounds(105, 325, 28, 28);
        deDeleteTick.setBounds(105, 325, 28, 28);
        quantityTick.setBounds(105, 389, 28, 28);
        deQuantityTick.setBounds(105, 389, 28, 28);
        searchTick.setBounds(105, 452, 28, 28);
        deSearchTick.setBounds(105, 452, 28, 28);
        blockTick.setBounds(105, 514, 28, 28);
        deBlockTick.setBounds(105, 514, 28, 28);
        workerChoser.setBounds(135,110,280,20);
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
        workerChoser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Boolean> access = null;
                if(Stock.findUserByName(String.valueOf(workerChoser.getSelectedItem())).getAccess() != null) {
                    access = Stock.findUserByName(String.valueOf(workerChoser.getSelectedItem())).getAccess();
                    if (access.get(0)){
                        createTick.setVisible(true);
                        deCreateTick.setVisible(false);
                    }
                    else{
                        createTick.setVisible(false);
                        deCreateTick.setVisible(true);
                    }
                    if (access.get(1)){
                        editTick.setVisible(true);
                        deEditTick.setVisible(false);
                    }
                    else {
                        editTick.setVisible(false);
                        deEditTick.setVisible(true);
                    }
                    if (access.get(2)) {
                        deleteTick.setVisible(true);
                        deDeleteTick.setVisible(false);
                    }
                    else {
                        deleteTick.setVisible(false);
                        deDeleteTick.setVisible(true);
                    }
                    if (access.get(3)) {
                        quantityTick.setVisible(true);
                        deQuantityTick.setVisible(false);
                    }
                    else {
                        quantityTick.setVisible(false);
                        deQuantityTick.setVisible(true);
                    }
                    if (access.get(4)) {
                        searchTick.setVisible(true);
                        deSearchTick.setVisible(false);
                    }
                    else {
                        searchTick.setVisible(false);
                        deSearchTick.setVisible(true);
                    }

                }

            }
        });
    }
    private void addListenersToTickBTNS(){
        createTick.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                createTick.setVisible(false);
                deCreateTick.setVisible(true);
                Stock.findUserByName(String.valueOf(workerChoser.getSelectedItem())).getAccess().set(0,false);
            }
        });
        deCreateTick.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                createTick.setVisible(true);
                deCreateTick.setVisible(false);
                Stock.findUserByName(String.valueOf(workerChoser.getSelectedItem())).getAccess().set(0,true);
                Stock.saveUsers();
            }
        });
        editTick.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                editTick.setVisible(false);
                deEditTick.setVisible(true);
                Stock.findUserByName(String.valueOf(workerChoser.getSelectedItem())).getAccess().set(1,false);
                Stock.saveUsers();
            }
        });
        deEditTick.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                editTick.setVisible(true);
                deEditTick.setVisible(false);
                Stock.findUserByName(String.valueOf(workerChoser.getSelectedItem())).getAccess().set(1,true);
                Stock.saveUsers();
            }
        });
        deleteTick.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                deleteTick.setVisible(false);
                deDeleteTick.setVisible(true);
                Stock.findUserByName(String.valueOf(workerChoser.getSelectedItem())).getAccess().set(2,false);
                Stock.saveUsers();
            }
        });
        deDeleteTick.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                deleteTick.setVisible(true);
                deDeleteTick.setVisible(false);
                Stock.findUserByName(String.valueOf(workerChoser.getSelectedItem())).getAccess().set(2,true);
                Stock.saveUsers();
            }
        });
        quantityTick.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                quantityTick.setVisible(false);
                deQuantityTick.setVisible(true);
                Stock.findUserByName(String.valueOf(workerChoser.getSelectedItem())).getAccess().set(3,false);
                Stock.saveUsers();
            }
        });
        deQuantityTick.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                quantityTick.setVisible(true);
                deQuantityTick.setVisible(false);
                Stock.findUserByName(String.valueOf(workerChoser.getSelectedItem())).getAccess().set(3,true);
                Stock.saveUsers();
            }
        });
        searchTick.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                searchTick.setVisible(false);
                deSearchTick.setVisible(true);
                Stock.findUserByName(String.valueOf(workerChoser.getSelectedItem())).getAccess().set(4,false);
                Stock.saveUsers();
            }
        });
        deSearchTick.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                searchTick.setVisible(true);
                deSearchTick.setVisible(false);
                Stock.findUserByName(String.valueOf(workerChoser.getSelectedItem())).getAccess().set(4,true);
                Stock.saveUsers();
            }
        });
        blockTick.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                blockTick.setVisible(false);
                deBlockTick.setVisible(true);
                Stock.findUserByName(String.valueOf(workerChoser.getSelectedItem())).getAccess().set(1,false);
                Stock.saveUsers();
            }
        });
        deBlockTick.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                blockTick.setVisible(true);
                deBlockTick.setVisible(false);
                Stock.findUserByName(String.valueOf(workerChoser.getSelectedItem())).getAccess().set(1,false);
                Stock.saveUsers();
            }
        });
    }

    public void updateData() {
        if(!Stock.getLoginUser().isAdmin()){
            adminTickSetBackground.setVisible(false);
            userTickSetBackground.setVisible(true);
        }
        for(int i=0;i< Stock.getUsers().size();i++) {
            if(!Stock.getUsers().get(i).isAdmin()) workerChoser.addItem(Stock.getUsers().get(i).getName());
        }
    }

}


