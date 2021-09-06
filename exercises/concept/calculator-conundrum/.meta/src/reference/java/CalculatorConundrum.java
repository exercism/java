public class CalculatorConundrum {
    private final String answer;

    public CalculatorConundrum(int operand1, int operand2, String operation) {
        int result;
        try {
            if (operation.equals("+")) {
                result = SimpleOperation.addition(operand1, operand2);
            } else if (operation.equals("*")) {
                result = SimpleOperation.multiplication(operand1, operand2);
            } else if (operation.equals("/")) {
                result = SimpleOperation.division(operand1, operand2);
            } else if (operation.equals("")) {
                throw new IllegalArgumentException("Operation cannot be empty");
            } else if (operation == null) {
                throw new NullPointerException("Operation cannot be null.");
            } else {
                throw new IllegalArgumentException(String.format("%s operation does not exist", operation));
            }
        } catch (ArithmeticException e){
            throw new ArithmeticException(e.getMessage());
        }
        this.answer = String.format("%d %s %d = %s", operand1, operation, operand2, result);
    }

    public String calculate() {
        return answer;
    }

}
