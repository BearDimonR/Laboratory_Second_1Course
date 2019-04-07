package GUI;

import BackGround.Stock;
import GUI.General.App;
import GUI.General.AppStyles;
import GUI.General.NameChooser;
import GUI.General.PictureChooser;
import GUI.MainComponents.ContentPanel;
import GUI.MainComponents.TitleBarPanel;
import GUI.MainComponents.ToolBarPanel;

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
    JLabel profilePhoto = new JLabel(new ImageIcon("images/picture chooser/pictures150x150/1.png"));
    JLabel logOutBTN = new JLabel(new ImageIcon("images/logOutBTN.jpg"));
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
    JLabel userName = new JLabel("cvdvdsvdsvds");

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
        profileSetBackground.add(profilePhoto);
        profileSetBackground.add(changeNameBTN);
        userTickSetBackground.setVisible(false);
        profileSetBackground.add(userName);
        profileSetBackground.add(logOutBTN);
        profilePhoto.setBounds(89,60,150,150);
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
        changeNameBTN.setBounds(64,369,212,32);
        changePictureBTN.setBounds(64,440,212,32);
        logOutBTN.setBounds(64,510,212,32);
        userName.setBounds(88,236,154,22);
         setStyleOfWorkerChooser();
         addListenersToBTNS();
         addListenersToTickBTNS();
        userName.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        userName.setFont(AppStyles.appH0Font);
        userName.setForeground(AppStyles.MainColor);
    }

    private void setStyleOfWorkerChooser(){
        workerChoser.setBackground(Color.WHITE);
        workerChoser.setFont(AppStyles.appH2Font);
        workerChoser.setForeground(AppStyles.MainColor);
        workerChoser.setUI(new BasicComboBoxUI());
    }
    private void addListenersToBTNS(){
        logOutBTN.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ToolBarPanel.deselectAllButtonsOnToolBar();
                App.makeLoginFrameVisible();

            }
        });
        changePictureBTN.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PictureChooser p = new PictureChooser();
                updateData();
            }
        });
        changeNameBTN.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                NameChooser c = new NameChooser();
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
        userName.setText(Stock.getLoginUser().getName());
        setIconPhotos();
        if(!Stock.getLoginUser().isAdmin()){
            adminTickSetBackground.setVisible(false);
            userTickSetBackground.setVisible(true);
        }
        for(int i=0;i< Stock.getUsers().size();i++) {
            if(!Stock.getUsers().get(i).isAdmin()) workerChoser.addItem(Stock.getUsers().get(i).getName());
        }
    }

    private void setIconPhotos() {
        if(Stock.getLoginUser().getImage() == null){
            profilePhoto.setIcon(null);
            TitleBarPanel.setIcon(null);
            return;
        }
        profilePhoto.setIcon(new ImageIcon(Stock.getLoginUser().getImage()));
        switch (Stock.getLoginUser().getImage()){
            case "images/picture chooser/pictures96x96/1.png": {
                TitleBarPanel.setIcon("images/picture chooser/pictures28x28/1.png");
                break;
            }
            case "images/picture chooser/pictures96x96/2.png": {
                TitleBarPanel.setIcon("images/picture chooser/pictures28x28/2.png");
                break;
            }
            case "images/picture chooser/pictures96x96/3.png": {
                TitleBarPanel.setIcon("images/picture chooser/pictures28x28/3.png");
                break;
            }
            case "images/picture chooser/pictures96x96/4.png": {
                TitleBarPanel.setIcon("images/picture chooser/pictures28x28/4.png");
                break;
            }
            case "images/picture chooser/pictures96x96/5.png": {
                TitleBarPanel.setIcon("images/picture chooser/pictures28x28/5.png");
                break;
            }
            case "images/picture chooser/pictures96x96/6.png": {
                TitleBarPanel.setIcon("images/picture chooser/pictures28x28/6.png");
                break;
            }
            case "images/picture chooser/pictures96x96/7.png": {
                TitleBarPanel.setIcon("images/picture chooser/pictures28x28/7.png");
                break;
            }
            case "images/picture chooser/pictures96x96/8.png": {
                TitleBarPanel.setIcon("images/picture chooser/pictures28x28/8.png");
                break;
            }
        }
    }

}


