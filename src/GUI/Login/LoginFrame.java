package GUI.Login;

import BackGround.Stock;
import BackGround.User;
import GUI.General.App;
import GUI.General.AppStyles;
import GUI.MainComponents.ContentPanel;
import GUI.MainComponents.TitleBarPanel;
import GUI.SettingPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginFrame extends JFrame {
    private int numberOfTries=0;
    private JTextField loginField = new JTextField();
    private JPasswordField passwordField = new JPasswordField();
    private JLabel logInBTN = new JLabel(new ImageIcon("images/logInBTN.png"));
    private JLabel gotItBTN = new JLabel(new ImageIcon("images/gotItBTN.jpg"));
    private JLabel loadingBar = new JLabel(new ImageIcon("images/43.gif"));
    private JLabel loadingBackground = new JLabel(new ImageIcon("images/loading.png"));
    private JLabel helpBackground = new JLabel(new ImageIcon("images/problemLoginBackground.png"));
    private JLabel loginBackground = new JLabel(new ImageIcon("images/loginBackground.png"));
    private JLabel passwordErrorMSG = new JLabel("incorrect password");
    private JLabel loginErrorMSG = new JLabel("User not found");
    private JLabel help = new JLabel("WTF is going on?!");
    private JLabel closeBTN = new JLabel(new ImageIcon("images/closeLoginBTN.png"));

    public LoginFrame() {
        //set Frame settings
        {
            setUndecorated(true);
            setLayout(null);
            setResizable(false);
            setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
            add(loginBackground);
            add(loadingBackground);
            add(helpBackground);
            helpBackground.setVisible(false);
            loadingBackground.setVisible(false);
            helpBackground.setBounds(0, 0, 750, 500);
            loadingBackground.setBounds(0, 0, 750, 500);
            loginBackground.setBounds(0, 0, 750, 500);
            loginBackground.add(loginField);
            loginBackground.add(closeBTN);
            loginBackground.add(passwordField);
            loginBackground.add(logInBTN);
            helpBackground.add(gotItBTN);
            loginBackground.add(passwordErrorMSG);
            loginBackground.add(loginErrorMSG);
            loginBackground.add(help);
            closeBTN.setBounds(0, 0, 52, 37);
            loginField.setBounds(490, 173, 220, 30);
            loginErrorMSG.setBounds(490, 205, 220, 30);
            passwordField.setBounds(490, 277, 220, 30);
            passwordErrorMSG.setBounds(490, 305, 220, 30);
            help.setBounds(490, 350, 220, 30);
            help.setHorizontalAlignment(0);
            loginErrorMSG.setHorizontalAlignment(0);
            passwordErrorMSG.setHorizontalAlignment(0);
            logInBTN.setBounds(483, 422, 220, 30);
            gotItBTN.setBounds(483, 440, 220, 32);
            loginField.setFont(AppStyles.appH1Font);
            loginField.setForeground(AppStyles.MainColor);
            loginField.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

gotItBTN.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        loginBackground.setVisible(true);
        helpBackground.setVisible(false);
    }
});
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
                    if (e.getKeyChar() <= 32) e.consume();
                }
            });
        }
        help.setVisible(false);
        loginErrorMSG.setVisible(false);
        passwordErrorMSG.setVisible(false);
        loginErrorMSG.setFont(AppStyles.loginErrorMSG);
        loginErrorMSG.setForeground(Color.RED);
        passwordErrorMSG.setFont(AppStyles.loginErrorMSG);
        passwordErrorMSG.setForeground(Color.RED);
        passwordField.setFont(AppStyles.appH1Font);
        passwordField.setForeground(AppStyles.MainColor);
        passwordField.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        setSize(750, 500);
        setLocation(300, 100);
        pack();
        logInBTN.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                loginErrorMSG.setVisible(false);
                passwordErrorMSG.setVisible(false);
                if (Stock.findUserByName(loginField.getText()) == null) {loginErrorMSG.setVisible(true);
                numberOfTries++;
                }
                else  {
                    User user = Stock.findUserByName(loginField.getText());
                    String password = String.valueOf(passwordField.getPassword());
                    if(user.getPassword().equals(password)) {
                        Stock.setLoginUser(user);
                        TitleBarPanel.setUserName();
                        TitleBarPanel.setStats();
                        ContentPanel.initPanel();
                        App.makeMainFrameVisible();
                    } else {
                        passwordErrorMSG.setVisible(true);
                    numberOfTries++;
                    }
                }
                if(numberOfTries>2){
                    help.setVisible(true);

                }
            }
        });
        help.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                helpBackground.setVisible(true);
                loginBackground.setVisible(false);
            }
        });
        closeBTN.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });
    }

    private void showLoadingpanel() {
        loadingBackground.add(loadingBar);
        loadingBar.setBounds(200, 350, 356, 36);
        loadingBackground.setVisible(true);
        loginBackground.setVisible(false);
//pause
        loadingBackground.setVisible(false);
        App.makeMainFrameVisible();

    }
}
