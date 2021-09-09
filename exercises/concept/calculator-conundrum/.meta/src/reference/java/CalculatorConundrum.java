public class CalculatorConundrum {
    private final String answer;

    public CalculatorConundrum(int operand1, int operand2, String operation) throws IllegalOperationException {
        int result;
        try {
            if (operation == null) {
                throw new IllegalArgumentException("Operation cannot be null");
            }
            switch (operation) {
                case "+":
                    result = SimpleOperation.addition(operand1, operand2);
                    break;
                case "*":
                    result = SimpleOperation.multiplication(operand1, operand2);
                    break;
                case "/":
                    result = SimpleOperation.division(operand1, operand2);
                    break;
                case "":
                    throw new IllegalArgumentException("Operation cannot be empty");
                default:
                    throw new IllegalArgumentException(String.format("%s operation does not exist", operation));
            }
        } catch (ArithmeticException | IllegalArgumentException e){
            if (e instanceof ArithmeticException) {
                throw new ArithmeticException("Divide by zero operation illegal");
            }
            throw new IllegalOperationException(e.getMessage());
        }
        this.answer = String.format("%d %s %d = %s", operand1, operation, operand2, result);
    }

    public String calculate() {
        return answer;
    }

}

