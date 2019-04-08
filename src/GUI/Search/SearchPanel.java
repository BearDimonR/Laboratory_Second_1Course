package GUI.Search;

import javax.swing.*;

public class SearchPanel extends JPanel {
    private static StatisticPanel statisticPanel = new StatisticPanel();
    private static ProductSearchPanel productSearchPanel = new ProductSearchPanel();

    public SearchPanel() {
        setLayout(null);
        add(productSearchPanel);
        add(statisticPanel);
        productSearchPanel.setBounds(0, 0, 914, 666);
        statisticPanel.setBounds(0, 0, 914, 666);
        productSearchPanel.setVisible(true);
        statisticPanel.setVisible(false);

    }
    public static void showSearchPanel(){
        statisticPanel.setVisible(false);
        productSearchPanel.setVisible(true);
    }
    public static void showStatistickPanel(){
        statisticPanel.update();
        statisticPanel.checkBox();
        statisticPanel.setVisible(true);
        productSearchPanel.setVisible(false);
    }

    public void update(){
        statisticPanel.update();
    }

}
