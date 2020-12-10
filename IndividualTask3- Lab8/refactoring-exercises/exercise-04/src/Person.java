import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 * Bad Smell,Lazy Classes + Duplicated Code
 *
 * Removed unnecessary classes, and extracted a method that will replace all duplicated code, with the help of hashmap :)
 * **/
public  class Person {
	public String lastName;

	public String firstName;

	public String middleName;

	private Map<Character, String> order = new HashMap<>();


	public Person(String lastName, String firstName, String middleName) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.middleName = middleName;

		order.put('f',firstName);
		order.put('l',lastName);
		order.put('m',middleName);
	}

	public  void printPerson(Writer out) throws IOException {
		//order: FirstName MiddleName LastName => fml
		out.write(getOrderedName("fml"));
	}

	public  String formatPerson() {
		//order: LastName FirstName MiddleName => lfm, also we need a comma instead of a space
		return getOrderedName("lfm").replaceFirst(" ", ", ");
	}

	public  void display(Writer out) throws IOException {
		out.write(formatPerson());
	}

	private String getOrderedName(String nameOrder){
		String res = "";
		for (int i = 0; i < nameOrder.length(); i++) {
			String namePart = order.get(nameOrder.charAt(i));
			res += (namePart==null)?" ":(namePart+" ");
		}

		//remove extra white spaces
		return res.replaceAll("( +)"," ").trim();
	}


	@Override
	public String toString() {
		return lastName + ", " + firstName
				+ ((middleName == null) ? "" : " " + middleName);
	}
}