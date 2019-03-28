package GUI.Editing;

import GUI.General.AppStyles;

import javax.swing.*;
import java.awt.*;

public class ProductEditingPanel extends JPanel {
    JLabel editBTN = new JLabel(new ImageIcon("images/CreateBTN.jpg"));
    JLabel backgroundHeader = new JLabel(new ImageIcon("images/TproductEditingHeader.jpg"));
    JLabel findBTN = new JLabel(new ImageIcon("images/findVerticalButton.jpg"));
    JLabel backgroundClearBody = new JLabel(new ImageIcon("images/productEditingClearBody.jpg"));
    JLabel backgroundBody = new JLabel(new ImageIcon("images/productEditingBody.jpg"));

    public ProductEditingPanel(){
        setLayout(AppStyles.gridBagLayout);
        //add elements on group editing panel
        {
            add(backgroundHeader, new GridBagConstraints(0, 0, 1, 1, 1, 0.6,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            add(backgroundClearBody, new GridBagConstraints(0, 1, 1, 1, 1, 0.6,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            add(backgroundBody, new GridBagConstraints(0, 1, 1, 1, 1, 0.6,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            //add elements on header panel
            {

            }
            //add elements on body panel
            {

            }
        }
    }
}
