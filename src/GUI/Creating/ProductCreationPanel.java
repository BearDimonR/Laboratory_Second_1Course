package GUI.Creating;

import GUI.General.AppStyles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ProductCreationPanel extends JPanel {
    JLabel createBTN = new JLabel(new ImageIcon("images/CreateBTN.jpg"));
    JLabel background = new JLabel(new ImageIcon("images/productCreationPanelBackground.jpg"));
    JTextField productNameTF = new JTextField();
    JTextField manufacturerTF = new JTextField();
    JTextField priceTF = new JTextField();
    JComboBox productGroupChooser = new JComboBox();
    JTextArea descriptionTA = new JTextArea();
    JScrollPane descriptionScrollPane = new JScrollPane(descriptionTA);

    public ProductCreationPanel() {
        setLayout(AppStyles.gridBagLayout);
        background.setLayout(AppStyles.gridBagLayout);
        setStylesOfTFandTA();
        addElementsOnProductPanel();
        addListenerToCreateBTN();

    }

    /**
     * Method sets styles of all text areas and text fialde
     * which are situated on product creation panel
     */
    private void setStylesOfTFandTA() {
        //productNameTF
        productNameTF.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        productNameTF.setFont(AppStyles.fieldFont);
        productNameTF.setForeground(AppStyles.MainColor);

        //descriptionTA
        descriptionTA.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        descriptionTA.setFont(AppStyles.fieldFont);
        descriptionTA.setForeground(AppStyles.MainColor);
        descriptionScrollPane.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        //manufacturerTF
        manufacturerTF.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        manufacturerTF.setFont(AppStyles.fieldFont);
        manufacturerTF.setForeground(AppStyles.MainColor);
        //priceTF
        priceTF.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        priceTF.setFont(AppStyles.fieldFont);
        priceTF.setForeground(AppStyles.MainColor);
        //productGroupChooser
        productGroupChooser.setBackground(Color.WHITE);
        productGroupChooser.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        productGroupChooser.setFont(AppStyles.fieldFont);
        productGroupChooser.setForeground(AppStyles.MainColor);
    }

    /**
     * Method adds elementa on product creation panel
     */
    private void addElementsOnProductPanel() {
        add(background, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        background.add(productNameTF, new GridBagConstraints(0, 0, 1, 1, 1, 0.0001,
                GridBagConstraints.NORTH, GridBagConstraints.NORTH,
                new Insets(101, 30, 0, 0), 430, 0));
        background.add(descriptionScrollPane, new GridBagConstraints(0, 0, 1, 1, 1, 0.0001,
                GridBagConstraints.NORTH, GridBagConstraints.NORTH,
                new Insets(175, 30, 0, 0), 435, 100));
        background.add(productGroupChooser, new GridBagConstraints(0, 0, 1, 1, 1, 0.0001,
                GridBagConstraints.NORTH, GridBagConstraints.NORTH,
                new Insets(350, 30, 0, 0), 413, 0));
        background.add(manufacturerTF, new GridBagConstraints(0, 0, 1, 1, 1, 0.25,
                GridBagConstraints.CENTER, GridBagConstraints.NORTH,
                new Insets(209, 30, 0, 0), 435, 0));
        background.add(priceTF, new GridBagConstraints(0, 0, 1, 1, 1, 0.25,
                GridBagConstraints.CENTER, GridBagConstraints.NORTH,
                new Insets(349, 30, 0, 0), 435, 0));
        background.add(createBTN, new GridBagConstraints(0, 0, 1, 1, 1, 0.25,
                GridBagConstraints.NORTH, GridBagConstraints.NORTH,
                new Insets(578, 1, 0, 0), 0, 0));
    }

    /**
     * Method adds listenr to creation btn img
     */
    private void addListenerToCreateBTN() {
        createBTN.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //здесь бил бекенд
            }
        });
    }
}
