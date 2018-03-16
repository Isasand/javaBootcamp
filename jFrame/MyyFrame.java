package my.demotestjava;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author Isa
 */
public class MyyFrame extends JFrame{
    MyyFrame() {

        String[] colNames = new String[] {"Device ID", "Status", "Senast kontakt", "Data"};

        List<String> list = new ArrayList<>();
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");

        String[][] rowData = new String[list.size() / colNames.length][colNames.length];
        for (int i = 0; i < rowData.length; i++) {
            for (int j = 0; j < rowData[i].length; j++) {
                rowData[i][j] = list.get(i * colNames.length + j);
            }
        }

        javax.swing.JTable table = new  javax.swing.JTable(rowData, colNames);

        add(new  javax.swing.JScrollPane(table));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {

        new MyyFrame();
    } 
}
