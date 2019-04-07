package GUI.General;

import BackGround.Stock;
import BackGround.User;
import GUI.MainComponents.ContentPanel;
import GUI.MainComponents.TitleBarPanel;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameChooser extends JFrame {
    JLabel background = new JLabel(new ImageIcon("images/picture chooser/UserNameChangeBackground.jpg"));
    JLabel closeBTN = new JLabel(new ImageIcon("images/picture chooser/pcClose.jpg"));
    JLabel logo = new JLabel(new ImageIcon("images/picture chooser/pcLogo.jpg"));
    JLabel saveBTN = new JLabel(new ImageIcon("images/picture chooser/okBTN.jpg"));
    JTextField newUserName = new JTextField();


    public NameChooser() {
        setLayout(null);
        setUndecorated(true);
        setVisible(true);
        setSize(500, 128);
        setLocation(300, 300);
        add(closeBTN);
        add(logo);
        add(background);
        background.add(newUserName);
        background.add(saveBTN);
        background.setBounds(0, 0, 500, 128);
        newUserName.setBounds(176, 51, 298, 17);
        saveBTN.setBounds(197, 92, 86, 24);
        logo.setBounds(0, 0, 69, 25);
        closeBTN.setBounds(479, 2, 21, 21);
        setStyleOfTF();
        addListenersToControlElements();

    }

    private void setStyleOfTF() {
        newUserName.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        newUserName.setFont(AppStyles.appH2Font);
        newUserName.setForeground(AppStyles.MainColor);
    }

    private void addListenersToControlElements() {
        newUserName.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!Character.isDigit(e.getKeyChar()) && !Character.isAlphabetic(e.getKeyChar()) && e.getKeyChar() != '_')
                e.consume();
                    else if(newUserName.getText().length() == 19) e.consume();
            }
        });
        closeBTN.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
            }
        });
        saveBTN.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(newUserName.getText() == null || newUserName.getText().equals("")){
                    // error
                    return;
                }
                Matcher matcher = Pattern.compile("[A-Za-zА-Яїєіа-я_0-9]{3,20}").matcher(newUserName.getText());
                User currentUser =Stock.getLoginUser();
                if(matcher.matches()) {
                    for (int i = 0; i < Stock.getUsers().size(); i++) {
                        if (newUserName.getText().equals(Stock.getUsers().get(i).getName())){
                            break;
                        } else if (i == Stock.getUsers().size() - 1) {
                            currentUser.setName(newUserName.getText());
                            Stock.saveUsers();
                            ContentPanel.settingPanel.updateData();
                            TitleBarPanel.setUserName();
                            setVisible(false);
                            return;
                        }
                    }
                }
                // error
                newUserName.setText("");
            }
        });
    }

}
