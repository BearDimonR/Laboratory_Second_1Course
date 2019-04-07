package GUI.General;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ProblemPanel extends JFrame {
    JLabel background = new JLabel(new ImageIcon("images/exception.png"));
    JLabel okBTN = new JLabel(new ImageIcon("images/okBTN.png"));

    public ProblemPanel() {
        setLayout(null);
        setUndecorated(true);
        setVisible(true);
        setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
        setSize(300, 68);
        setLocation(300, 300);
        add(background);
       background.add(okBTN);
        background.setBounds(0, 0, 300, 68);
        okBTN.setBounds(257, 0, 43, 67);
        addListenersToControlElements();
        App.setMainFrameUnAble();
    }
    private void addListenersToControlElements() {
        okBTN.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                App.setMainFrameEnAble();
            }
        });
    }

}
