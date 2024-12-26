import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class ForthEvaluatorTest {

    private ForthEvaluator forthEvaluator = new ForthEvaluator();

    @Test
    public void testNumbersAreJustPushedOntoTheStack() {
        assertThat(forthEvaluator.evaluateProgram(Collections.singletonList("1 2 3 4 5")))
                .containsExactly(1, 2, 3, 4, 5);
    }

    @Disabled("Remove to run test")
    @Test
    public void testNegativeNumbersArePushedOntoTheStack() {
        assertThat(forthEvaluator.evaluateProgram(Collections.singletonList("-1 -2 -3 -4 -5")))
                .containsExactly(-1, -2, -3, -4, -5);
    }

    @Disabled("Remove to run test")
    @Test
    public void testTwoNumbersCanBeAdded() {
        assertThat(forthEvaluator.evaluateProgram(Collections.singletonList("1 2 +")))
                .containsExactly(3);
    }

    @Disabled("Remove to run test")
    @Test
    public void testErrorIfAdditionAttemptedWithNothingOnTheStack() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> forthEvaluator.evaluateProgram(Collections.singletonList("+")))
                .withMessage("Addition requires that the stack contain at least 2 values");
    }

    @Disabled("Remove to run test")
    @Test
    public void testErrorIfAdditionAttemptedWithOneNumberOnTheStack() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> forthEvaluator.evaluateProgram(Collections.singletonList("1 +")))
                .withMessage("Addition requires that the stack contain at least 2 values");
    }

    @Disabled("Remove to run test")
    @Test
    public void testAdditionForMoreThanTwoValuesOnTheStack() {
        assertThat(forthEvaluator.evaluateProgram(Collections.singletonList("1 2 3 +")))
                .containsExactly(1, 5);
    }

    @Disabled("Remove to run test")
    @Test
    public void testTwoNumbersCanBeSubtracted() {
        assertThat(forthEvaluator.evaluateProgram(Collections.singletonList("3 4 -")))
                .containsExactly(-1);
    }

    @Disabled("Remove to run test")
    @Test
    public void testErrorIfSubtractionAttemptedWithNothingOnTheStack() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> forthEvaluator.evaluateProgram(Collections.singletonList("-")))
                .withMessage("Subtraction requires that the stack contain at least 2 values");

    }

    @Disabled("Remove to run test")
    @Test
    public void testErrorIfSubtractionAttemptedWithOneNumberOnTheStack() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> forthEvaluator.evaluateProgram(Collections.singletonList("1 -")))
                .withMessage("Subtraction requires that the stack contain at least 2 values");
    }

    @Disabled("Remove to run test")
    @Test
    public void testSubtractionForMoreThanTwoValuesOnTheStack() {
        assertThat(forthEvaluator.evaluateProgram(Collections.singletonList("1 12 3 -")))
                .containsExactly(1, 9);
    }

    @Disabled("Remove to run test")
    @Test
    public void testTwoNumbersCanBeMultiplied() {
        assertThat(forthEvaluator.evaluateProgram(Collections.singletonList("2 4 *"))).containsExactly(8);
    }

    @Disabled("Remove to run test")
    @Test
    public void testErrorIfMultiplicationAttemptedWithNothingOnTheStack() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> forthEvaluator.evaluateProgram(Collections.singletonList("*")))
                .withMessage("Multiplication requires that the stack contain at least 2 values");
    }

    @Disabled("Remove to run test")
    @Test
    public void testErrorIfMultiplicationAttemptedWithOneNumberOnTheStack() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> forthEvaluator.evaluateProgram(Collections.singletonList("1 *")))
                .withMessage("Multiplication requires that the stack contain at least 2 values");
    }

    @Disabled("Remove to run test")
    @Test
    public void testMultiplicationForMoreThanTwoValuesOnTheStack() {
        assertThat(forthEvaluator.evaluateProgram(Collections.singletonList("1 2 3 *")))
                .containsExactly(1, 6);
    }

    @Disabled("Remove to run test")
    @Test
    public void testTwoNumbersCanBeDivided() {
        assertThat(forthEvaluator.evaluateProgram(Collections.singletonList("12 3 /"))).containsExactly(4);
    }

    @Disabled("Remove to run test")
    @Test
    public void testThatIntegerDivisionIsUsed() {
        assertThat(forthEvaluator.evaluateProgram(Collections.singletonList("8 3 /"))).containsExactly(2);
    }

    @Disabled("Remove to run test")
    @Test
    public void testErrorIfDividingByZero() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> forthEvaluator.evaluateProgram(Collections.singletonList("4 0 /")))
                .withMessage("Division by 0 is not allowed");
    }

    @Disabled("Remove to run test")
    @Test
    public void testErrorIfDivisionAttemptedWithNothingOnTheStack() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> forthEvaluator.evaluateProgram(Collections.singletonList("/")))
                .withMessage("Division requires that the stack contain at least 2 values");
    }

    @Disabled("Remove to run test")
    @Test
    public void testErrorIfDivisionAttemptedWithOneNumberOnTheStack() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> forthEvaluator.evaluateProgram(Collections.singletonList("1 /")))
                .withMessage("Division requires that the stack contain at least 2 values");
    }

    @Disabled("Remove to run test")
    @Test
    public void testDivisionForMoreThanTwoValuesOnTheStack() {
        assertThat(forthEvaluator.evaluateProgram(Collections.singletonList("1 12 3 /")))
                .containsExactly(1, 4);
    }

    @Disabled("Remove to run test")
    @Test
    public void testCombinedAdditionAndSubtraction() {
        assertThat(forthEvaluator.evaluateProgram(Collections.singletonList("1 2 + 4 -"))).containsExactly(-1);
    }

    @Disabled("Remove to run test")
    @Test
    public void testCombinedMultiplicationAndDivision() {
        assertThat(forthEvaluator.evaluateProgram(Collections.singletonList("2 4 * 3 /"))).containsExactly(2);
    }

    @Disabled("Remove to run test")
    @Test
    public void testCombinedMultiplicationAndAddition() {
        assertThat(forthEvaluator.evaluateProgram(Collections.singletonList("1 3 4 * +"))).containsExactly(13);
    }

    @Disabled("Remove to run test")
    @Test
    public void testCombinedAdditionAndMultiplication() {
        assertThat(forthEvaluator.evaluateProgram(Collections.singletonList("1 3 4 + *"))).containsExactly(7);
    }

    @Disabled("Remove to run test")
    @Test
    public void testDupCopiesAValueOnTheStack() {
        assertThat(forthEvaluator.evaluateProgram(Collections.singletonList("1 dup"))).containsExactly(1, 1);
    }

    @Disabled("Remove to run test")
    @Test
    public void testDupCopiesTopValueOnTheStack() {
        assertThat(forthEvaluator.evaluateProgram(Collections.singletonList("1 2 dup"))).containsExactly(1, 2, 2);
    }

    @Disabled("Remove to run test")
    @Test
    public void testErrorIfDuplicatingAttemptedWithNothingOnTheStack() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> forthEvaluator.evaluateProgram(Collections.singletonList("dup")))
                .withMessage("Duplicating requires that the stack contain at least 1 value");
    }

    @Disabled("Remove to run test")
    @Test
    public void testDropRemovesTheTopValueOnTheStackIfItIsTheOnlyOne() {
        assertThat(forthEvaluator.evaluateProgram(Collections.singletonList("1 drop"))).isEmpty();
    }

    @Disabled("Remove to run test")
    @Test
    public void testDropRemovesTheTopValueOnTheStackIfItIsNotTheOnlyOne() {
        assertThat(forthEvaluator.evaluateProgram(Collections.singletonList("1 2 drop"))).containsExactly(1);
    }

    @Disabled("Remove to run test")
    @Test
    public void testErrorIfDroppingAttemptedWithNothingOnTheStack() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> forthEvaluator.evaluateProgram(Collections.singletonList("drop")))
                .withMessage("Dropping requires that the stack contain at least 1 value");
    }

    @Disabled("Remove to run test")
    @Test
    public void testSwapSwapsTheTopTwosValueOnTheStackIfTheyAreTheOnlyOnes() {
        assertThat(forthEvaluator.evaluateProgram(Collections.singletonList("1 2 swap"))).containsExactly(2, 1);
    }

    @Disabled("Remove to run test")
    @Test
    public void testSwapSwapsTheTopTwosValueOnTheStackIfTheyAreNotTheOnlyOnes() {
        assertThat(forthEvaluator.evaluateProgram(Collections.singletonList("1 2 3 swap")))
                .containsExactly(1, 3, 2);
    }

    @Disabled("Remove to run test")
    @Test
    public void testErrorIfSwappingAttemptedWithNothingOnTheStack() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> forthEvaluator.evaluateProgram(Collections.singletonList("swap")))
                .withMessage("Swapping requires that the stack contain at least 2 values");
    }

    @Disabled("Remove to run test")
    @Test
    public void testErrorIfSwappingAttemptedWithOneNumberOnTheStack() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> forthEvaluator.evaluateProgram(Collections.singletonList("1 swap")))
                .withMessage("Swapping requires that the stack contain at least 2 values");
    }

    @Disabled("Remove to run test")
    @Test
    public void testOverCopiesTheSecondElementIfThereAreOnlyTwo() {
        assertThat(forthEvaluator.evaluateProgram(Collections.singletonList("1 2 over")))
                .containsExactly(1, 2, 1);
    }

    @Disabled("Remove to run test")
    @Test
    public void testOverCopiesTheSecondElementIfThereAreMoreThanTwo() {
        assertThat(forthEvaluator.evaluateProgram(Collections.singletonList("1 2 3 over")))
                .containsExactly(1, 2, 3, 2);
    }

    @Disabled("Remove to run test")
    @Test
    public void testErrorIfOveringAttemptedWithNothingOnTheStack() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> forthEvaluator.evaluateProgram(Collections.singletonList("over")))
                .withMessage("Overing requires that the stack contain at least 2 values");
    }

    @Disabled("Remove to run test")
    @Test
    public void testErrorIfOveringAttemptedWithOneNumberOnTheStack() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> forthEvaluator.evaluateProgram(Collections.singletonList("1 over")))
                .withMessage("Overing requires that the stack contain at least 2 values");
    }

    @Disabled("Remove to run test")
    @Test
    public void testUserDefinedOperatorsCanConsistOfBuiltInOperators() {
        assertThat(forthEvaluator.evaluateProgram(Arrays.asList(": dup-twice dup dup ;", "1 dup-twice")))
                .containsExactly(1, 1, 1);
    }

    @Disabled("Remove to run test")
    @Test
    public void testUserDefinedOperatorsAreEvaluatedInTheCorrectOrder() {
        assertThat(forthEvaluator.evaluateProgram(Arrays.asList(": countup 1 2 3 ;", "countup")))
                .containsExactly(1, 2, 3);
    }

    @Disabled("Remove to run test")
    @Test
    public void testCanRedefineAUserDefinedOperator() {
        assertThat(forthEvaluator.evaluateProgram(Arrays.asList(": foo dup ;", ": foo dup dup ;", "1 foo")))
                .containsExactly(1, 1, 1);
    }

    @Disabled("Remove to run test")
    @Test
    public void testCanOverrideBuiltInWordOperators() {
        assertThat(forthEvaluator.evaluateProgram(Arrays.asList(": swap dup ;", "1 swap")))
                .containsExactly(1, 1);
    }

    @Disabled("Remove to run test")
    @Test
    public void testCanOverrideBuiltInArithmeticOperators() {
        assertThat(forthEvaluator.evaluateProgram(Arrays.asList(": + * ;", "3 4 +")))
                .containsExactly(12);
    }

    @Disabled("Remove to run test")
    @Test
    public void testCanUseDifferentWordsWithTheSameName() {
        assertThat(forthEvaluator.evaluateProgram(Arrays.asList(": foo 5 ;", ": bar foo ;", ": foo 6 ;", "bar foo")))
                .containsExactly(5, 6);
    }

    @Disabled("Remove to run test")
    @Test
    public void testCanDefineWordThatUsesWordWithTheSameName() {
        assertThat(forthEvaluator.evaluateProgram(Arrays.asList(": foo 10 ;", ": foo foo 1 + ;", "foo")))
                .containsExactly(11);
    }

    @Disabled("Remove to run test")
    @Test
    public void testCannotRedefineNonNegativeNumbers() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> forthEvaluator.evaluateProgram(Collections.singletonList(": 1 2 ;")))
                .withMessage("Cannot redefine numbers");
    }

    @Disabled("Remove to run test")
    @Test
    public void testCannotRedefineNegativeNumbers() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> forthEvaluator.evaluateProgram(Collections.singletonList(": -1 2 ;")))
                .withMessage("Cannot redefine numbers");
    }

    @Disabled("Remove to run test")
    @Test
    public void testErrorIfEvaluatingAnUndefinedOperator() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> forthEvaluator.evaluateProgram(Collections.singletonList("foo")))
                .withMessage("No definition available for operator \"foo\"");
    }

    @Disabled("Remove to run test")
    @Test
    public void testDupIsCaseInsensitive() {
        assertThat(forthEvaluator.evaluateProgram(Collections.singletonList("1 DUP Dup dup")))
                .containsExactly(1, 1, 1, 1);
    }

    @Disabled("Remove to run test")
    @Test
    public void testDropIsCaseInsensitive() {
        assertThat(forthEvaluator.evaluateProgram(Collections.singletonList("1 2 3 4 DROP Drop drop")))
                .containsExactly(1);
    }

    @Disabled("Remove to run test")
    @Test
    public void testSwapIsCaseInsensitive() {
        assertThat(forthEvaluator.evaluateProgram(Collections.singletonList("1 2 SWAP 3 Swap 4 swap")))
                .containsExactly(2, 3, 4, 1);
    }

    @Disabled("Remove to run test")
    @Test
    public void testOverIsCaseInsensitive() {
        assertThat(forthEvaluator.evaluateProgram(Collections.singletonList("1 2 OVER Over over")))
                .containsExactly(1, 2, 1, 2, 1);
    }

    @Disabled("Remove to run test")
    @Test
    public void testUserDefinedWordsAreCaseInsensitive() {
        assertThat(forthEvaluator.evaluateProgram(Arrays.asList(": foo dup ;", "1 FOO Foo foo")))
                .containsExactly(1, 1, 1, 1);
    }

    @Disabled("Remove to run test")
    @Test
    public void testDefinitionsAreCaseInsensitive() {
        assertThat(forthEvaluator.evaluateProgram(Arrays.asList(": SWAP DUP Dup dup ;", "1 swap")))
                .containsExactly(1, 1, 1, 1);
    }

    @Disabled
    @Test
    public void testDefinitionsAreOnlyDefinedLocally() {
        ForthEvaluator firstInstance = new ForthEvaluator();
        ForthEvaluator secondInstance = new ForthEvaluator();

        List<Integer> firstOutput = firstInstance.evaluateProgram(Arrays.asList(": + - ;", "1 1 +"));
        List<Integer> secondOutput = secondInstance.evaluateProgram(Collections.singletonList("1 1 +"));

        assertThat(firstOutput).containsExactly(0);
        assertThat(secondOutput).containsExactly(2);
    }

}
