package GUI.General;

import BackGround.GroupOfProduct;
import BackGround.Product;
import BackGround.Stock;
import GUI.Creating.GroupCreationPanel;
import GUI.Login.LoginFrame;

import java.awt.*;

public class App {
    public static AppFrame mainFrame = new AppFrame();//main frame of the app
    static LoginFrame loginFrame = new LoginFrame();// login frame of the app

    public static void main(String[] args) {

        //set dimension and visibility of frames
        {
            mainFrame.setSize(new Dimension(1010, 700));
            mainFrame.setVisible(true);
            mainFrame.setLocation(new Point(100, 50));
            loginFrame.setSize(new Dimension(670, 530));
            loginFrame.setVisible(true);
        }
    }
}
