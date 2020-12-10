/* Bad Smell: Duplicated code
 * There is no need to add an extra for loop to clip large values when we
 * can do it in the same for loop that checks if it's within the delta limit.
 *
 * Note: we can also make the arguments, properties of class Matcher, and initialize them with the constructor,
 * but then we would need to change the test class, (I am not sure if we are allowed to do it)
 */

public class Matcher {
	public boolean match(int[] expected, int[] actual, int clipLimit, int delta) {
		if (actual.length != expected.length)
			return false;

		for (int i = 0; i < actual.length; i++) {
			// Clip "too-large" values
			if (actual[i] > clipLimit)
				actual[i] = clipLimit;

			// Check that each entry is within expected +/- delta
			if (Math.abs(expected[i] - actual[i]) > delta)
				return false;
		}

		return true;
	}
}