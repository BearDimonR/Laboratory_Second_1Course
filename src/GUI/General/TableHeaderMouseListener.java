package GUI.General;
import BackGround.Alphabet;
import BackGround.Utilities;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.JTable;
public class TableHeaderMouseListener extends MouseAdapter{
    private JTable table;
    public TableHeaderMouseListener(JTable table){
        this.table = table;
    }
public void  mouseClicked(MouseEvent e){
        Point point = e.getPoint();
        int column = table.columnAtPoint(point);
   //  System.out.println("i="+column);
    if(column==1){
    // TablePanel.addDataToGoodsTable(Alphabet.alphabetProduct(), 1);

    }

}
}


