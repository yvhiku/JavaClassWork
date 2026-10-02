
package javaintegralcalculation;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class WriteFile {

    public void saveTable(File file, JTable table) throws IOException {
        DefaultTableModel model =
                (DefaultTableModel) table.getModel();

        try (FileWriter writer = new FileWriter(file, false)) {
            for (int i = 0; i < model.getRowCount(); i++) {
                for (int j = 0; j < model.getColumnCount(); j++) {
                    if (j > 0) {
                        writer.write(" ");
                    }

                    Object value = model.getValueAt(i, j);
                    writer.write(value == null ? "" : value.toString());
                }

                writer.write(System.lineSeparator());
            }
        }
    }
}