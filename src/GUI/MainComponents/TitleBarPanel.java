package GUI.MainComponents;

import BackGround.Stock;
import BackGround.Utilities;
import GUI.General.AppStyles;
import GUI.General.App;
import GUI.Search.ProductSearchPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static BackGround.Utilities.Search;

public class TitleBarPanel extends JPanel {
    JLabel btnCancel = new JLabel(new ImageIcon("images/mainFrame/cancelBTN.jpg"));//icon of cancel btn
    JLabel btnMinimize = new JLabel(new ImageIcon("images/mainFrame/minimiseBTN.jpg"));//icon of minimize btn
    static JLabel userNameLabel = new JLabel("User name");// label which contains user name info
    JLabel background = new JLabel(new ImageIcon("images/mainFrame/titleBarBackground.jpg"));//background picture of title bar
    static JLabel userProfilePic = new JLabel(new ImageIcon("images/userProfilePic.png"));//icon of user profile picture

    private static JLabel totalPrice = new JLabel("0");//icon of user profile picture
    private static JLabel totalAmount = new JLabel("0");//icon of user profile picture

    JTextField tfSearch = new JTextField();


    public TitleBarPanel() {
        setLayout(null);
        background.setLayout(null);
        //set size of toll bar panel
        {
            setSize(new Dimension(915, 35));
            setPreferredSize(new Dimension(915, 35));
            setMaximumSize(new Dimension(915, 35));
            setMinimumSize(new Dimension(915, 35));
        }

        //set style of search text field
        {
            tfSearch.setOpaque(false);
            tfSearch.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            tfSearch.setFont(AppStyles.appH2Font);
            tfSearch.setForeground(AppStyles.MainColor);
        }

        //add elements to title bar
        {


            add(background);
            background.setBounds(0, 0, 914, 35);
            background.add(tfSearch);
            background.add(btnCancel);
            background.add(userProfilePic);
            background.add(userNameLabel);
            background.add(btnMinimize);
            background.add(totalPrice);
            background.add(totalAmount);
            tfSearch.setBounds(70, 4, 140, 24);
            btnCancel.setBounds(881, 4, 26, 26);
            totalPrice.setBounds(335, 4, 60, 24);
            totalAmount.setBounds(500, 4, 60, 24);
            userProfilePic.setBounds(716, 3, 31, 31);
            userNameLabel.setBounds(750, 5, 100, 26);
            btnMinimize.setBounds(847, 3, 26, 26);
        }

        //add mouse listener to close and minimize btn
        {
            btnCancel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    System.exit(0);
                }
            });
            btnMinimize.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    App.mainFrame.setState(Frame.ICONIFIED);
                }
            });
            tfSearch.addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) { }
                @Override
                public void keyPressed(KeyEvent e) { }
                @Override
                public void keyReleased(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {

                        if (CheckSearchLine(tfSearch.getText())==false) {
                            tfSearch.setText("");
                        } else {
                            ToolBarPanel.deselectAllButtonsOnToolBar();
                            ContentPanel.showPanel(6);
                            ProductSearchPanel.tablePanel.addDataToGoodsTable(Utilities.Search(tfSearch.getText()), 1);
                        }
                    }
                }
            });
        }

    }

    /**
     * check search line
     * @param search
     * @return
     */
    private boolean  CheckSearchLine(String search){
       if(search.matches("[ ]*") == false &&
               search.matches("[ ]*[0-9]+[.]?[0-9]*[ ]*") == false &&
               search.matches("[ ]*[A-Za-zА-Яа-яії]+[ ]*") == false &&
               search.matches("[ ]*[\\d]+[.]?[\\d]*[ ]*[-][ ]*[\\d]+[.]?[\\d]*[ ]*") == false)
       {
           return false;
       }
       return true;
   }
    public static void setIcon(String s) {
        if(s == null) userProfilePic.setIcon(new ImageIcon("images/userProfilePic.png"));
        else userProfilePic.setIcon(new ImageIcon(s));
    }

    private void  updateTable(String search){
        //tablePanel.addDataToGoodsTable(Utilities.Search(search), 1);
    }

    public static void setStats() {
        setTotalAmount(Stock.getAllAmount());
        setTotalPrice(Stock.getAllPrice());
    }

    public static void setUserName() {
        userNameLabel.setText(Stock.getLoginUser().getName());
    }

    public static void setTotalPrice(double price) {
        totalPrice.setText(String.valueOf(price));
    }

    public static void setTotalAmount(int amount) {
        totalAmount.setText(String.valueOf(amount));
    }
}
