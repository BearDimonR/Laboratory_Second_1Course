package GUI;

import javax.swing.*;
import java.awt.*;

public class AppFrame extends JFrame {
    ToolBarPanel toolBarPanel = new ToolBarPanel();//panel which contains menu navigation
    ContentPanel contentPanel = new ContentPanel();//panel which contains all content
    TitleBarPanel titleBarPanel = new TitleBarPanel();//panel which contains search field, user profile pic, user name, close and minimize btns
    JLabel logoBar = new JLabel(new ImageIcon("Z:\\Lab2\\images\\logo.jpg"));//Logo image

    public AppFrame() {

        //set Frame settings
        {
            setUndecorated(true);
            setLayout(AppStyles.gridBagLayout);
            setResizable(false);
        }

        //set Logo bar
        {
            logoBar.setSize(new Dimension(95, 35));
            logoBar.setPreferredSize(new Dimension(95, 35));
            logoBar.setMaximumSize(new Dimension(95, 53));
            logoBar.setMinimumSize(new Dimension(95, 53));
        }

        //add panels to GUI.AppFrame
        {
            add(logoBar, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                    GridBagConstraints.CENTER, GridBagConstraints.CENTER,
                    new Insets(0, 0, 0, 0), 0, 0));
            add(titleBarPanel, new GridBagConstraints(1, 0, 1, 1, 1, 1,
                    GridBagConstraints.CENTER, GridBagConstraints.CENTER,
                    new Insets(0, 0, 0, 0), 0, 0));
            add(toolBarPanel, new GridBagConstraints(0, 1, 1, 1, 1, 0.1,
                    GridBagConstraints.CENTER, GridBagConstraints.CENTER,
                    new Insets(0, 0, 0, 0), 0, 0));
            add(contentPanel, new GridBagConstraints(1, 1, 1, 1, 1, 0.1,
                    GridBagConstraints.CENTER, GridBagConstraints.CENTER,
                    new Insets(0, 0, 0, 0), 0, 0));
        }
    }
}
