public class CalculatorConundrum {
    public String calculate(int operand1, int operand2, String operation) {
        if (operation == null) {
            throw new IllegalArgumentException("Operation cannot be null");
        }

        if (operation.isEmpty()) {
            throw new IllegalArgumentException("Operation cannot be empty");
        }

        int result;
        switch (operation) {
            case "+" -> result = operand1 + operand2;
            case "*" -> result = operand1 * operand2;
            case "/" -> {
                try {
                    result = operand1 / operand2;
                } catch (ArithmeticException e) {
                    throw new IllegalOperationException("Division by zero is not allowed", e);
                }
            }
            default -> throw new IllegalOperationException("Operation '" + operation + "' does not exist");
        }

        return String.valueOf(operand1) + " " + String.valueOf(operation) + " " + operand2 + " = " +  result;
    }
}
