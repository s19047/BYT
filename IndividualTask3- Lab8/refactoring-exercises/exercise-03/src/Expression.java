import java.util.HashMap;

/* Bad Smell: Switch statement
* To solve I extracted methods, Created Classes, Moved methods to classes, Implemented an interface
*
* */
public class Expression {

	private final char operator;

	private Expression left,right;

	private int constant;

	public Expression(int constant) {
		this.operator = 'c';
		this.constant = constant;
	}

	public Expression(char op, Expression left, Expression right) {
		this.operator = op;
		this.left = left;
		this.right = right;
	}

	public int evaluate() {
		if (operator == 'c')
			return constant;

		return createCalculationBuilder().calculate(left,right);
	}

	private ICalculator createCalculationBuilder() {
		HashMap<Character,ICalculator> calculators = new HashMap<>();
		calculators.put('+',new AdditionCalculator());
		calculators.put('-',new SubtractionCalculator());
		calculators.put('*',new MultiplicationCalculator());
		calculators.put('/',new DivisionCalculator());

		if(!calculators.containsKey(operator))
			throw new IllegalStateException("Please Enter a valid operation");

		return  calculators.get(operator);
	}

}
