
package javaintegralcalculation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {

    public List<Object[]> loadTable(File file) throws IOException {
        List<Object[]> rows = new ArrayList<>();

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(file))) {

            String line;
            int lineNumber = 0;

            while ((line = reader.readLine()) != null) {
                lineNumber++;

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] parts = line.trim().split("\\s+");

                if (parts.length != 4) {
                    throw new IOException(
                            "Invalid format at line " + lineNumber);
                }

                try {
                    double lower = Double.parseDouble(parts[0]);
                    double upper = Double.parseDouble(parts[1]);
                    double step = Double.parseDouble(parts[2]);
                    double result = Double.parseDouble(parts[3]);

                    if (!Double.isFinite(lower)
                            || !Double.isFinite(upper)
                            || !Double.isFinite(step)
                            || !Double.isFinite(result)
                            || step <= 0
                            || upper <= lower) {
                        throw new IOException(
                                "Invalid values at line " + lineNumber);
                    }

                    rows.add(new Object[]{
                        lower, upper, step, result
                    });

                } catch (NumberFormatException ex) {
                    throw new IOException(
                            "Invalid number at line " + lineNumber, ex);
                }
            }
        }

        return rows;
    }
}