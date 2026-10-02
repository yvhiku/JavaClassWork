
package javaintegralcalculation;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class WriteBinaryFile {

    public void saveTable(File file, JTable table)
            throws IOException {

        DefaultTableModel model =
                (DefaultTableModel) table.getModel();

        List<Object[]> rows = new ArrayList<>();

        for (int i = 0; i < model.getRowCount(); i++) {
            Object[] row = new Object[model.getColumnCount()];

            for (int j = 0; j < model.getColumnCount(); j++) {
                row[j] = model.getValueAt(i, j);
            }

            rows.add(row);
        }

        try (ObjectOutputStream output =
                     new ObjectOutputStream(
                             new FileOutputStream(file))) {
            output.writeObject(rows);
        }
    }
}