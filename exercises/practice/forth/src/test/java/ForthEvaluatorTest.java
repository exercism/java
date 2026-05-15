import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class ForthEvaluatorTest {

    private ForthEvaluator forthEvaluator = new ForthEvaluator();

    @Test
    @DisplayName("numbers just get pushed onto the stack")
    public void testNumbersAreJustPushedOntoTheStack() {
        assertThat(forthEvaluator.evaluateProgram(Collections.singletonList("1 2 3 4 5")))
                .containsExactly(1, 2, 3, 4, 5);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("pushes negative numbers onto the stack")
    public void testNegativeNumbersArePushedOntoTheStack() {
        assertThat(forthEvaluator.evaluateProgram(Collections.singletonList("-1 -2 -3 -4 -5")))
                .containsExactly(-1, -2, -3, -4, -5);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("can add two numbers")
    public void testTwoNumbersCanBeAdded() {
        assertThat(forthEvaluator.evaluateProgram(Collections.singletonList("1 2 +")))
                .containsExactly(3);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("errors if there is nothing on the stack")
    public void testErrorIfAdditionAttemptedWithNothingOnTheStack() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> forthEvaluator.evaluateProgram(Collections.singletonList("+")))
                .withMessage("Addition requires that the stack contain at least 2 values");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("errors if there is only one value on the stack")
    public void testErrorIfAdditionAttemptedWithOneNumberOnTheStack() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> forthEvaluator.evaluateProgram(Collections.singletonList("1 +")))
                .withMessage("Addition requires that the stack contain at least 2 values");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("more than two values on the stack")
    public void testAdditionForMoreThanTwoValuesOnTheStack() {
        assertThat(forthEvaluator.evaluateProgram(Collections.singletonList("1 2 3 +")))
                .containsExactly(1, 5);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("can subtract two numbers")
    public void testTwoNumbersCanBeSubtracted() {
        assertThat(forthEvaluator.evaluateProgram(Collections.singletonList("3 4 -")))
                .containsExactly(-1);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("errors if there is nothing on the stack")
    public void testErrorIfSubtractionAttemptedWithNothingOnTheStack() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> forthEvaluator.evaluateProgram(Collections.singletonList("-")))
                .withMessage("Subtraction requires that the stack contain at least 2 values");

    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("errors if there is only one value on the stack")
    public void testErrorIfSubtractionAttemptedWithOneNumberOnTheStack() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> forthEvaluator.evaluateProgram(Collections.singletonList("1 -")))
                .withMessage("Subtraction requires that the stack contain at least 2 values");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("more than two values on the stack")
    public void testSubtractionForMoreThanTwoValuesOnTheStack() {
        assertThat(forthEvaluator.evaluateProgram(Collections.singletonList("1 12 3 -")))
                .containsExactly(1, 9);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("can multiply two numbers")
    public void testTwoNumbersCanBeMultiplied() {
        assertThat(forthEvaluator.evaluateProgram(Collections.singletonList("2 4 *"))).containsExactly(8);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("errors if there is nothing on the stack")
    public void testErrorIfMultiplicationAttemptedWithNothingOnTheStack() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> forthEvaluator.evaluateProgram(Collections.singletonList("*")))
                .withMessage("Multiplication requires that the stack contain at least 2 values");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("errors if there is only one value on the stack")
    public void testErrorIfMultiplicationAttemptedWithOneNumberOnTheStack() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> forthEvaluator.evaluateProgram(Collections.singletonList("1 *")))
                .withMessage("Multiplication requires that the stack contain at least 2 values");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("more than two values on the stack")
    public void testMultiplicationForMoreThanTwoValuesOnTheStack() {
        assertThat(forthEvaluator.evaluateProgram(Collections.singletonList("1 2 3 *")))
                .containsExactly(1, 6);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("can divide two numbers")
    public void testTwoNumbersCanBeDivided() {
        assertThat(forthEvaluator.evaluateProgram(Collections.singletonList("12 3 /"))).containsExactly(4);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("performs integer division")
    public void testThatIntegerDivisionIsUsed() {
        assertThat(forthEvaluator.evaluateProgram(Collections.singletonList("8 3 /"))).containsExactly(2);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("errors if dividing by zero")
    public void testErrorIfDividingByZero() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> forthEvaluator.evaluateProgram(Collections.singletonList("4 0 /")))
                .withMessage("Division by 0 is not allowed");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("errors if there is nothing on the stack")
    public void testErrorIfDivisionAttemptedWithNothingOnTheStack() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> forthEvaluator.evaluateProgram(Collections.singletonList("/")))
                .withMessage("Division requires that the stack contain at least 2 values");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("errors if there is only one value on the stack")
    public void testErrorIfDivisionAttemptedWithOneNumberOnTheStack() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> forthEvaluator.evaluateProgram(Collections.singletonList("1 /")))
                .withMessage("Division requires that the stack contain at least 2 values");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("more than two values on the stack")
    public void testDivisionForMoreThanTwoValuesOnTheStack() {
        assertThat(forthEvaluator.evaluateProgram(Collections.singletonList("1 12 3 /")))
                .containsExactly(1, 4);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("addition and subtraction")
    public void testCombinedAdditionAndSubtraction() {
        assertThat(forthEvaluator.evaluateProgram(Collections.singletonList("1 2 + 4 -"))).containsExactly(-1);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("multiplication and division")
    public void testCombinedMultiplicationAndDivision() {
        assertThat(forthEvaluator.evaluateProgram(Collections.singletonList("2 4 * 3 /"))).containsExactly(2);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("multiplication and addition")
    public void testCombinedMultiplicationAndAddition() {
        assertThat(forthEvaluator.evaluateProgram(Collections.singletonList("1 3 4 * +"))).containsExactly(13);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("addition and multiplication")
    public void testCombinedAdditionAndMultiplication() {
        assertThat(forthEvaluator.evaluateProgram(Collections.singletonList("1 3 4 + *"))).containsExactly(7);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("copies a value on the stack")
    public void testDupCopiesAValueOnTheStack() {
        assertThat(forthEvaluator.evaluateProgram(Collections.singletonList("1 dup"))).containsExactly(1, 1);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("copies the top value on the stack")
    public void testDupCopiesTopValueOnTheStack() {
        assertThat(forthEvaluator.evaluateProgram(Collections.singletonList("1 2 dup"))).containsExactly(1, 2, 2);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("errors if there is nothing on the stack")
    public void testErrorIfDuplicatingAttemptedWithNothingOnTheStack() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> forthEvaluator.evaluateProgram(Collections.singletonList("dup")))
                .withMessage("Duplicating requires that the stack contain at least 1 value");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("removes the top value on the stack if it is the only one")
    public void testDropRemovesTheTopValueOnTheStackIfItIsTheOnlyOne() {
        assertThat(forthEvaluator.evaluateProgram(Collections.singletonList("1 drop"))).isEmpty();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("removes the top value on the stack if it is not the only one")
    public void testDropRemovesTheTopValueOnTheStackIfItIsNotTheOnlyOne() {
        assertThat(forthEvaluator.evaluateProgram(Collections.singletonList("1 2 drop"))).containsExactly(1);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("errors if there is nothing on the stack")
    public void testErrorIfDroppingAttemptedWithNothingOnTheStack() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> forthEvaluator.evaluateProgram(Collections.singletonList("drop")))
                .withMessage("Dropping requires that the stack contain at least 1 value");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("swaps the top two values on the stack if they are the only ones")
    public void testSwapSwapsTheTopTwosValueOnTheStackIfTheyAreTheOnlyOnes() {
        assertThat(forthEvaluator.evaluateProgram(Collections.singletonList("1 2 swap"))).containsExactly(2, 1);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("swaps the top two values on the stack if they are not the only ones")
    public void testSwapSwapsTheTopTwosValueOnTheStackIfTheyAreNotTheOnlyOnes() {
        assertThat(forthEvaluator.evaluateProgram(Collections.singletonList("1 2 3 swap")))
                .containsExactly(1, 3, 2);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("errors if there is nothing on the stack")
    public void testErrorIfSwappingAttemptedWithNothingOnTheStack() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> forthEvaluator.evaluateProgram(Collections.singletonList("swap")))
                .withMessage("Swapping requires that the stack contain at least 2 values");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("errors if there is only one value on the stack")
    public void testErrorIfSwappingAttemptedWithOneNumberOnTheStack() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> forthEvaluator.evaluateProgram(Collections.singletonList("1 swap")))
                .withMessage("Swapping requires that the stack contain at least 2 values");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("copies the second element if there are only two")
    public void testOverCopiesTheSecondElementIfThereAreOnlyTwo() {
        assertThat(forthEvaluator.evaluateProgram(Collections.singletonList("1 2 over")))
                .containsExactly(1, 2, 1);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("copies the second element if there are more than two")
    public void testOverCopiesTheSecondElementIfThereAreMoreThanTwo() {
        assertThat(forthEvaluator.evaluateProgram(Collections.singletonList("1 2 3 over")))
                .containsExactly(1, 2, 3, 2);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("errors if there is nothing on the stack")
    public void testErrorIfOveringAttemptedWithNothingOnTheStack() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> forthEvaluator.evaluateProgram(Collections.singletonList("over")))
                .withMessage("Overing requires that the stack contain at least 2 values");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("errors if there is only one value on the stack")
    public void testErrorIfOveringAttemptedWithOneNumberOnTheStack() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> forthEvaluator.evaluateProgram(Collections.singletonList("1 over")))
                .withMessage("Overing requires that the stack contain at least 2 values");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("can consist of built-in words")
    public void testUserDefinedOperatorsCanConsistOfBuiltInOperators() {
        assertThat(forthEvaluator.evaluateProgram(Arrays.asList(": dup-twice dup dup ;", "1 dup-twice")))
                .containsExactly(1, 1, 1);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("execute in the right order")
    public void testUserDefinedOperatorsAreEvaluatedInTheCorrectOrder() {
        assertThat(forthEvaluator.evaluateProgram(Arrays.asList(": countup 1 2 3 ;", "countup")))
                .containsExactly(1, 2, 3);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("can override other user-defined words")
    public void testCanRedefineAUserDefinedOperator() {
        assertThat(forthEvaluator.evaluateProgram(Arrays.asList(": foo dup ;", ": foo dup dup ;", "1 foo")))
                .containsExactly(1, 1, 1);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("can override built-in words")
    public void testCanOverrideBuiltInWordOperators() {
        assertThat(forthEvaluator.evaluateProgram(Arrays.asList(": swap dup ;", "1 swap")))
                .containsExactly(1, 1);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("can override built-in operators")
    public void testCanOverrideBuiltInArithmeticOperators() {
        assertThat(forthEvaluator.evaluateProgram(Arrays.asList(": + * ;", "3 4 +")))
                .containsExactly(12);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("can use different words with the same name")
    public void testCanUseDifferentWordsWithTheSameName() {
        assertThat(forthEvaluator.evaluateProgram(Arrays.asList(": foo 5 ;", ": bar foo ;", ": foo 6 ;", "bar foo")))
                .containsExactly(5, 6);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("can define word that uses word with the same name")
    public void testCanDefineWordThatUsesWordWithTheSameName() {
        assertThat(forthEvaluator.evaluateProgram(Arrays.asList(": foo 10 ;", ": foo foo 1 + ;", "foo")))
                .containsExactly(11);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("cannot redefine non-negative numbers")
    public void testCannotRedefineNonNegativeNumbers() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> forthEvaluator.evaluateProgram(Collections.singletonList(": 1 2 ;")))
                .withMessage("Cannot redefine numbers");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("cannot redefine negative numbers")
    public void testCannotRedefineNegativeNumbers() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> forthEvaluator.evaluateProgram(Collections.singletonList(": -1 2 ;")))
                .withMessage("Cannot redefine numbers");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("errors if executing a non-existent word")
    public void testErrorIfEvaluatingAnUndefinedOperator() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> forthEvaluator.evaluateProgram(Collections.singletonList("foo")))
                .withMessage("No definition available for operator \"foo\"");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("DUP is case-insensitive")
    public void testDupIsCaseInsensitive() {
        assertThat(forthEvaluator.evaluateProgram(Collections.singletonList("1 DUP Dup dup")))
                .containsExactly(1, 1, 1, 1);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("DROP is case-insensitive")
    public void testDropIsCaseInsensitive() {
        assertThat(forthEvaluator.evaluateProgram(Collections.singletonList("1 2 3 4 DROP Drop drop")))
                .containsExactly(1);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("SWAP is case-insensitive")
    public void testSwapIsCaseInsensitive() {
        assertThat(forthEvaluator.evaluateProgram(Collections.singletonList("1 2 SWAP 3 Swap 4 swap")))
                .containsExactly(2, 3, 4, 1);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("OVER is case-insensitive")
    public void testOverIsCaseInsensitive() {
        assertThat(forthEvaluator.evaluateProgram(Collections.singletonList("1 2 OVER Over over")))
                .containsExactly(1, 2, 1, 2, 1);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("user-defined words are case-insensitive")
    public void testUserDefinedWordsAreCaseInsensitive() {
        assertThat(forthEvaluator.evaluateProgram(Arrays.asList(": foo dup ;", "1 FOO Foo foo")))
                .containsExactly(1, 1, 1, 1);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("definitions are case-insensitive")
    public void testDefinitionsAreCaseInsensitive() {
        assertThat(forthEvaluator.evaluateProgram(Arrays.asList(": SWAP DUP Dup dup ;", "1 swap")))
                .containsExactly(1, 1, 1, 1);
    }

    @Disabled
    @Test
    @DisplayName("only defines locally")
    public void testDefinitionsAreOnlyDefinedLocally() {
        ForthEvaluator firstInstance = new ForthEvaluator();
        ForthEvaluator secondInstance = new ForthEvaluator();

        List<Integer> firstOutput = firstInstance.evaluateProgram(Arrays.asList(": + - ;", "1 1 +"));
        List<Integer> secondOutput = secondInstance.evaluateProgram(Collections.singletonList("1 1 +"));

        assertThat(firstOutput).containsExactly(0);
        assertThat(secondOutput).containsExactly(2);
    }

}
