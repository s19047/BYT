public class SubtractionCalculator implements  ICalculator{
    public int calculate(Expression left,Expression right) {
        return left.evaluate() - right.evaluate();
    }
}
