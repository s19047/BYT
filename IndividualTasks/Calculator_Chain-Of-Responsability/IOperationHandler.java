public interface IOperationHandler {
    public void setNextOperation(IOperationHandler operationHandler);
    public abstract void calculate(Expression expression);
}

class Expression {
    public double firstValue;
    public double secondValue;
    public String operation;

    public Expression(double firstValue, double secondValue, String operation){
        this.firstValue = firstValue;
        this.secondValue = secondValue;
        this.operation = operation;
    }

    public double getFirstValue(){return  firstValue;}
    public double getSecondValue(){return  secondValue;}
    public String getOperation(){return  operation;}
}

class MultiplyHandler implements IOperationHandler{
    private IOperationHandler nextOperation;

    @Override
    public void setNextOperation(IOperationHandler nextOperation) {
        this.nextOperation = nextOperation;
    }

    @Override
    public void calculate(Expression expression) {
        if(expression.operation.equals("*")){
            System.out.println(expression.firstValue +"*"+ expression.secondValue+ " = " + (expression.firstValue*expression.secondValue)  );
        }else{
            nextOperation.calculate(expression);
        }
    }
}

class DivideHandler implements IOperationHandler{
    private IOperationHandler nextOperation;

    @Override
    public void setNextOperation(IOperationHandler nextOperation) {
        this.nextOperation = nextOperation;
    }

    @Override
    public void calculate(Expression expression) {
        if(expression.operation.equals("/")){
            System.out.println(expression.firstValue +"/"+ expression.secondValue+ " = " + (expression.firstValue/expression.secondValue)  );
        }else{
            nextOperation.calculate(expression);
        }
    }
}

class AdditionHandler implements IOperationHandler{
    private IOperationHandler nextOperation;

    @Override
    public void setNextOperation(IOperationHandler nextOperation) {
        this.nextOperation = nextOperation;
    }

    @Override
    public void calculate(Expression expression) {
        if(expression.operation.equals("+")){
            System.out.println(expression.firstValue +"+"+ expression.secondValue+ " = " + (expression.firstValue+expression.secondValue)  );
        }else{
            nextOperation.calculate(expression);
        }
    }
}

class SubtractHandler implements IOperationHandler{
    private IOperationHandler nextOperation;

    @Override
    public void setNextOperation(IOperationHandler nextOperation) {
        this.nextOperation = nextOperation;
    }

    @Override
    public void calculate(Expression expression) {
        if(expression.operation.equals("-")){
            System.out.println(expression.firstValue +"-"+ expression.secondValue+ " = " + (expression.firstValue-expression.secondValue)  );
        }else{
            System.out.println("Please Enter a valid Operation");
        }
    }
}

class calculator {
    private static MultiplyHandler multiplyHandler = new MultiplyHandler();
    private static DivideHandler   divideHandler = new DivideHandler();
    private static AdditionHandler additionHandler = new AdditionHandler();
    private static SubtractHandler subtractHandler = new SubtractHandler();

    static
    {
        multiplyHandler.setNextOperation(divideHandler);
        divideHandler.setNextOperation(additionHandler);
        additionHandler.setNextOperation(subtractHandler);
    }

    public static void makeCaluclation(String mathExpression){
        //this calculator is only for calculating 2 numbers with 4 operations
        String[] expressionArr = mathExpression.split("\\s");
        Expression expression = new Expression(Double.parseDouble(expressionArr[0]),Double.parseDouble(expressionArr[2]),expressionArr[1]);
        multiplyHandler.calculate(expression);
    }

    public static void main(String[] args) {
        makeCaluclation("3 * 9");
        makeCaluclation("3 / 9");
        makeCaluclation("3 + 9");
        makeCaluclation("3 - 9");
    }
}


