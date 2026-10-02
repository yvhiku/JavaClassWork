
package javaintegralcalculation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class ReadBinaryFile {

    public List<Object[]> loadTable(File file)
            throws IOException, ClassNotFoundException {

        try (ObjectInputStream input =
                     new ObjectInputStream(
                             new FileInputStream(file))) {

            Object object = input.readObject();

            if (!(object instanceof List<?>)) {
                throw new IOException(
                        "Invalid binary file format.");
            }

            List<?> loadedRows = (List<?>) object;
            List<Object[]> rows = new java.util.ArrayList<>();

            for (Object item : loadedRows) {
                if (!(item instanceof Object[])) {
                    throw new IOException(
                            "Invalid row in binary file.");
                }

                Object[] row = (Object[]) item;

                if (row.length != 4) {
                    throw new IOException(
                            "Invalid number of columns.");
                }

                rows.add(row);
            }

            return rows;
        }
    }
}