package GUI.Login;

import BackGround.Stock;
import BackGround.User;
import GUI.General.App;
import GUI.General.AppStyles;
import GUI.MainComponents.TitleBarPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginFrame extends JFrame {
    JTextField loginField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JLabel logInBTN = new JLabel(new ImageIcon("images/logInBTN.png"));
    public LoginFrame(){
        //set Frame settings
        {
            setUndecorated(true);
            setLayout(null);
            setResizable(false);
            setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
            setContentPane(new JLabel(new ImageIcon("images/loginBackground.png")));
            add(loginField);
            add(passwordField);
            add(logInBTN);
            loginField.setBounds(490,173,220,30);
            passwordField.setBounds(490,277,220,30);
            logInBTN.setBounds(483,422,220,30);
            loginField.setFont(AppStyles.appH1Font);
            loginField.setForeground(AppStyles.MainColor);
            loginField.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

            loginField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    if (!Character.isDigit(e.getKeyChar()) && !Character.isAlphabetic(e.getKeyChar()) && e.getKeyChar() != '_')
                        e.consume();
                }
            });
            passwordField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    if(e.getKeyChar()<=32) e.consume();
                }
            });
        }

            passwordField.setFont(AppStyles.appH1Font);
            passwordField.setForeground(AppStyles.MainColor);
            passwordField.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
            setSize(750,500);
            setLocation(300,100);
            pack();
            logInBTN.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if(Stock.findUserByName(loginField.getText()) == null) ;//set red color of the login
                    else  {
                        User user = Stock.findUserByName(loginField.getText());
                        String password = String.valueOf(passwordField.getPassword());
                        if(user.getPassword().equals(password)) {
                            Stock.setLoginUser(user);
                            TitleBarPanel.setUserName();
                            TitleBarPanel.setStats();
                            App.makeMainFrameVisible();
                        } else ;//set red color of the password
                    }
                }
            });
        }
    }
