/**
 * Bad Smell: Divergent Change:
 * Extracted 2 classes
 *
 * I also added actual testing functionality to the test class
 * **/

public class CsvWriter {
	private final LineWriter lineWriter = new LineWriter(this);

	private final FieldWriter fieldWriter = new FieldWriter();

	public void write(String[][] lines) {
		for (int i = 0; i < lines.length; i++)
			lineWriter.writeLine(lines[i]);
	}

	public void writeField(String field) {
		fieldWriter.writeField(field);
	}

}