import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/** Added ways of actually testing**/
public class CsvWriterTest {

	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();


	@Test
	public void testWriter() {

		System.setOut(new PrintStream(outputStreamCaptor));

		CsvWriter writer = new CsvWriter();
		String[][] lines = new String[][] {
				new String[] {},
				new String[] { "only one field" },
				new String[] { "two", "fields" },
				new String[] { "", "contents", "several words included" },
				new String[] { ",", "embedded , commas, included",
						"trailing comma," },
				new String[] { "\"", "embedded \" quotes",
						"multiple \"\"\" quotes\"\"" },
				new String[] { "mixed commas, and \"quotes\"", "simple field" } };

		writer.write(lines);

		// Expected:
		// -- (empty line)
		// only one field
		// two,fields
		// ,contents,several words included
		// ",","embedded , commas, included","trailing comma,"
		// """","embedded "" quotes","multiple """""" quotes"""""
		// "mixed commas, and ""quotes""",simple field

		assertEquals(("\r\n" +
				"only one field\r\n" +
				"two,fields\r\n" +
				",contents,several words included\r\n" +
				"\",\",\"embedded , commas, included\",\"trailing comma,\"\r\n" +
				"\"\"\"\",\"embedded \"\" quotes\",\"multiple \"\"\"\"\"\" quotes\"\"\"\"\"\r\n" +
				"\"mixed commas, and \"\"quotes\"\"\",simple field\r\n"), outputStreamCaptor.toString());
	}

	@AfterEach
	public void tearDown() {
		System.setOut(standardOut);
	}
}
