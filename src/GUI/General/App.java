package GUI.General;

import GUI.Login.LoginFrame;

import java.awt.*;

public class App {
    public static AppFrame mainFrame = new AppFrame();//main frame of the app
    public static LoginFrame loginFrame = new LoginFrame();// login frame of the app

    public static void main(String[] args) {

        //set dimension and visibility of frames
        {
            mainFrame.setSize(new Dimension(1010, 700));
            mainFrame.setVisible(false);
            mainFrame.setLocation(new Point(100, 50));
           loginFrame.setSize(new Dimension(750, 500));
           loginFrame.setLocation(200,200);
            loginFrame.setVisible(true);

        }
    }
    public static void makeMainFrameVisible(){
        loginFrame.setVisible(false);
        mainFrame.setVisible(true);
    }
    public static void makeLoginFrameVisible(){
        mainFrame.setVisible(false);
        loginFrame.setVisible(true);
    }
    public static void setLoginFrameUnAble(){
        loginFrame.setEnabled(false);

    }
    public static void setLoginFrameEnAble(){
        loginFrame.setEnabled(true);
        loginFrame.setExtendedState(loginFrame.getExtendedState() | loginFrame.MAXIMIZED_BOTH);
        loginFrame.setLocation(200,200);
    }

    public static void setMainFrameUnAble(){
        mainFrame.setEnabled(false);
    }
    public static void setMainFrameEnAble(){
        mainFrame.setEnabled(true);
        mainFrame.setExtendedState(mainFrame.getExtendedState() | loginFrame.MAXIMIZED_BOTH);
        mainFrame.setLocation(100,50);
    }
}
