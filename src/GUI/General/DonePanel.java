package GUI.General;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DonePanel extends JFrame {
    JLabel background = new JLabel(new ImageIcon("images/photo_2019-04-06_20-57-43.jpg"));
    JLabel okBTN = new JLabel(new ImageIcon("images/picture chooser/okBTN.jpg"));



    public DonePanel() {
        setLayout(null);
        setUndecorated(true);
        setSize(494, 112);
        setLocation(300, 300);
        add(background);
       // background.add(okBTN);
        background.setBounds(0, 0, 494, 112);
        //okBTN.setBounds(197, 92, 86, 24);
        addListenersToControlElements();

    }

    private void addListenersToControlElements() {
        okBTN.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
            }
        });
    }

}
