package GUI.General;

import BackGround.Stock;
import BackGround.User;
import GUI.MainComponents.ContentPanel;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PictureChooser extends JFrame {
    JLabel pic8Background = new JLabel(new ImageIcon("images/picture chooser/pc8Background.jpg"));
    JLabel pic4Background = new JLabel(new ImageIcon("images/picture chooser/pc4Background.jpg"));
    JLabel picture1 = new JLabel(new ImageIcon("images/picture chooser/pictures96x96/1.png"));
    JLabel picture2 = new JLabel(new ImageIcon("images/picture chooser/pictures96x96/2.png"));
    JLabel picture3 = new JLabel(new ImageIcon("images/picture chooser/pictures96x96/3.png"));
    JLabel picture4 = new JLabel(new ImageIcon("images/picture chooser/pictures96x96/4.png"));
    JLabel picture5 = new JLabel(new ImageIcon("images/picture chooser/pictures96x96/5.png"));
    JLabel picture6 = new JLabel(new ImageIcon("images/picture chooser/pictures96x96/6.png"));
    JLabel picture7 = new JLabel(new ImageIcon("images/picture chooser/pictures96x96/7.png"));
    JLabel picture8 = new JLabel(new ImageIcon("images/picture chooser/pictures96x96/8.png"));
    JLabel closeBTN = new JLabel(new ImageIcon("images/picture chooser/pcClose.jpg"));
    JLabel logo = new JLabel(new ImageIcon("images/picture chooser/pcLogo.jpg"));
    JLabel rArrow = new JLabel(new ImageIcon("images/picture chooser/pcRightArrow.jpg"));
    JLabel rDeArrow = new JLabel(new ImageIcon("images/picture chooser/pcDeRightArrow.png"));
    JLabel lArrow = new JLabel(new ImageIcon("images/picture chooser/pcLeftArrow.jpg"));
    JLabel lDeArrow = new JLabel(new ImageIcon("images/picture chooser/pcDeLeftArrow.jpg"));
    User currentUser = Stock.getLoginUser();

    public PictureChooser() {
        setLayout(null);
        setUndecorated(true);
        setVisible(true);
        setSize(500, 350);
        setLocation(300,300);
        add(closeBTN);
        add(logo);
        add(rArrow);
        add(lArrow);
        add(rDeArrow);
        add(lDeArrow);
        add(pic4Background);
        add(pic8Background);
        pic4Background.setBounds(0, 0, 500, 350);
        pic4Background.setVisible(false);
        lArrow.setVisible(false);
        pic8Background.setBounds(0, 0, 500, 350);
        pic8Background.add(picture1);
        pic8Background.add(picture2);
        pic8Background.add(picture3);
        pic8Background.add(picture4);
        pic8Background.add(picture5);
        pic8Background.add(picture6);
        pic8Background.add(picture7);
        pic8Background.add(picture8);
        lArrow.setBounds(8, 163, 15, 24);
        lDeArrow.setBounds(8, 163, 15, 24);
        rArrow.setBounds(474, 163, 15, 24);
        rDeArrow.setBounds(474, 163, 15, 24);
        logo.setBounds(0, 0, 69, 25);
        closeBTN.setBounds(479, 2, 21, 21);
        picture1.setBounds(48, 67, 96, 96);
        picture2.setBounds(150, 67, 96, 96);
        picture3.setBounds(249, 67, 96, 96);
        picture4.setBounds(350, 67, 96, 96);
        picture5.setBounds(48, 188, 96, 96);
        picture6.setBounds(150, 188, 96, 96);
        picture7.setBounds(249, 188, 96, 96);
        picture8.setBounds(350, 188, 96, 96);
        addListenersToControlElements();
        addListenersToPictures();
    }

    private void addListenersToControlElements() {
        closeBTN.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
            }
        });
        lArrow.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pic8Background.setVisible(true);
                pic4Background.setVisible(false);
                lArrow.setVisible(false);
                lDeArrow.setVisible(true);
                rDeArrow.setVisible(false);
                rArrow.setVisible(true);
            }
        });
        rArrow.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pic8Background.setVisible(false);
                pic4Background.setVisible(true);
                lArrow.setVisible(true);
                lDeArrow.setVisible(false);
                rDeArrow.setVisible(true);
                rArrow.setVisible(false);
            }
        });
    }
    private void addListenersToPictures(){
        picture1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                currentUser.setImage(String.valueOf(picture1.getIcon()));
                setVisible(false);
                ContentPanel.settingPanel.updateData();
                Stock.saveUsers();
            }
        });

        picture2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                currentUser.setImage(String.valueOf(picture2.getIcon()));
                setVisible(false);
                ContentPanel.settingPanel.updateData();
                Stock.saveUsers();
            }
        });

        picture3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                currentUser.setImage(String.valueOf(picture3.getIcon()));
                setVisible(false);
                ContentPanel.settingPanel.updateData();
                Stock.saveUsers();
            }
        });

        picture4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                currentUser.setImage(String.valueOf(picture4.getIcon()));
                setVisible(false);
                ContentPanel.settingPanel.updateData();
                Stock.saveUsers();
            }
        });

        picture5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                currentUser.setImage(String.valueOf(picture5.getIcon()));
                setVisible(false);
                ContentPanel.settingPanel.updateData();
                Stock.saveUsers();
            }
        });

        picture6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                currentUser.setImage(String.valueOf(picture6.getIcon()));
                setVisible(false);
                ContentPanel.settingPanel.updateData();
                Stock.saveUsers();
            }
        });

        picture7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                currentUser.setImage(String.valueOf(picture7.getIcon()));
                setVisible(false);
                ContentPanel.settingPanel.updateData();
                Stock.saveUsers();
            }
        });

        picture8.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                currentUser.setImage(String.valueOf(picture8.getIcon()));
                setVisible(false);
                ContentPanel.settingPanel.updateData();
                Stock.saveUsers();
            }
        });
    }
}
