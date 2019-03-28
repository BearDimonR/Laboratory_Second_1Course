package GUI.Login;

import GUI.General.AppStyles;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {
    public LoginFrame(){
        //set Frame settings
        {
            setUndecorated(true);
            setLayout(AppStyles.gridBagLayout);
            setResizable(false);
            setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
            setContentPane(new JLabel(new ImageIcon("loginForm.png")));
            setLocation(300,100);
            pack();
        }
    }
}
// THIS CLASS IS UNDER CONSTRUCTION :)