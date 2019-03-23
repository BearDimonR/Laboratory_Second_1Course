package GUI;

import javax.swing.*;
import java.awt.*;

public class DeletingPanel extends JLabel {
    JLabel uc = new JLabel(new ImageIcon("images/UC.jpg"));

    public DeletingPanel() {
        setLayout(AppStyles.gridBagLayout);
        add(uc, new GridBagConstraints(0, 0, 1, 1, 1, 0.25,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
    }
}
