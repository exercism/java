public class Transpose {
    public String transpose(String toTranspose) {

        StringBuilder transposedForm = new StringBuilder();
        String[] rows = toTranspose.split("\n");

        int maxRowSize = 0;

        for (int i = 0; i < rows.length; i++) {
            if (rows[i].length() > maxRowSize) {
                maxRowSize = rows[i].length();
            }
        }

        padRows(rows);

        for (int newRowOldCol = 0; newRowOldCol < maxRowSize; newRowOldCol++) {
            for (int newColOldRow = 0; newColOldRow < rows.length; newColOldRow++) {
                if (newRowOldCol < rows[newColOldRow].length()) {
                    transposedForm.append(rows[newColOldRow].charAt(newRowOldCol));
                }
            }

            if (newRowOldCol != maxRowSize - 1) {
                transposedForm.append("\n");
            }
        }

        return transposedForm.toString();
    }

    private void padRows(String[] rows) {
        for (int i = 0; i < rows.length; i++) {
            for (int j = i; j < rows.length; j++) {
                if (rows[j].length() > rows[i].length()) {
                    rows[i] = String.format("%-" + rows[j].length() + "s", rows[i]);
                }
            }
        }
    }
}
