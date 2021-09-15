public class CalculatorConundrum {

    public String calculate(int operand1, int operand2, String operation) {
        int result;
        if (operation == null) {
            throw new IllegalOperationException("Operation cannot be null");
        }
        switch (operation) {
            case "+":
                result = SimpleOperation.addition(operand1, operand2);
                break;
            case "*":
                result = SimpleOperation.multiplication(operand1, operand2);
                break;
            case "/":
                try {
                    result = SimpleOperation.division(operand1, operand2);
                } catch (ArithmeticException e) {
                    throw new IllegalOperationException("Divide by zero operation illegal", e);
                }
                break;
            case "":
                throw new IllegalOperationException("Operation cannot be empty");
            default:
                throw new IllegalOperationException(String.format("%s operation does not exist", operation));
        }
        return String.format("%d %s %d = %s", operand1, operation, operand2, result);
    }

}
