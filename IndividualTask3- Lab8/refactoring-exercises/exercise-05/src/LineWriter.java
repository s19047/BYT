public class LineWriter {
    private final CsvWriter csvWriter;

    public LineWriter(CsvWriter csvWriter) {
        this.csvWriter = csvWriter;
    }

    void writeLine(String[] fields) {
        if (fields.length == 0)
            System.out.println();
        else {
            csvWriter.writeField(fields[0]);

            for (int i = 1; i < fields.length; i++) {
                System.out.print(",");
                csvWriter.writeField(fields[i]);
            }
            System.out.println();
        }
    }
}