import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class ForthEvaluatorTest {

    private ForthEvaluator forthEvaluator = new ForthEvaluator();

    @Test
    public void testNumbersAreJustPushedOntoTheStack() {
        assertEquals(
                Arrays.asList(1, 2, 3, 4, 5),
                forthEvaluator.evaluateProgram(Collections.singletonList("1 2 3 4 5")));
    }

    @Ignore("Remove to run test")
    @Test
    public void testTwoNumbersCanBeAdded() {
        assertEquals(
                Collections.singletonList(3),
                forthEvaluator.evaluateProgram(Collections.singletonList("1 2 +")));
    }

    @Ignore("Remove to run test")
    @Test
    public void testErrorIfAdditionAttemptedWithNothingOnTheStack() {

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> forthEvaluator.evaluateProgram(Collections.singletonList("+")))
                .withMessage("Addition requires that the stack contain at least 2 values");
    }

    @Ignore("Remove to run test")
    @Test
    public void testErrorIfAdditionAttemptedWithOneNumberOnTheStack() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> forthEvaluator.evaluateProgram(Collections.singletonList("1 +")))
                .withMessage("Addition requires that the stack contain at least 2 values");
    }

    @Ignore("Remove to run test")
    @Test
    public void testTwoNumbersCanBeSubtracted() {
        assertEquals(
                Collections.singletonList(-1),
                forthEvaluator.evaluateProgram(Collections.singletonList("3 4 -")));
    }

    @Ignore("Remove to run test")
    @Test
    public void testErrorIfSubtractionAttemptedWithNothingOnTheStack() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> forthEvaluator.evaluateProgram(Collections.singletonList("-")))
                .withMessage("Subtraction requires that the stack contain at least 2 values");
    }

    @Ignore("Remove to run test")
    @Test
    public void testErrorIfSubtractionAttemptedWithOneNumberOnTheStack() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> forthEvaluator.evaluateProgram(Collections.singletonList("1 -")))
                .withMessage("Subtraction requires that the stack contain at least 2 values");
    }

    @Ignore("Remove to run test")
    @Test
    public void testTwoNumbersCanBeMultiplied() {
        assertEquals(
                Collections.singletonList(8),
                forthEvaluator.evaluateProgram(Collections.singletonList("2 4 *")));
    }

    @Ignore("Remove to run test")
    @Test
    public void testErrorIfMultiplicationAttemptedWithNothingOnTheStack() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> forthEvaluator.evaluateProgram(Collections.singletonList("*")))
                .withMessage("Multiplication requires that the stack contain at least 2 values");
    }

    @Ignore("Remove to run test")
    @Test
    public void testErrorIfMultiplicationAttemptedWithOneNumberOnTheStack() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> forthEvaluator.evaluateProgram(Collections.singletonList("1 *")))
                .withMessage("Multiplication requires that the stack contain at least 2 values");
    }

    @Ignore("Remove to run test")
    @Test
    public void testTwoNumbersCanBeDivided() {
        assertEquals(
                Collections.singletonList(4),
                forthEvaluator.evaluateProgram(Collections.singletonList("12 3 /")));
    }

    @Ignore("Remove to run test")
    @Test
    public void testThatIntegerDivisionIsUsed() {
        assertEquals(
                Collections.singletonList(2),
                forthEvaluator.evaluateProgram(Collections.singletonList("8 3 /")));
    }

    @Ignore("Remove to run test")
    @Test
    public void testErrorIfDividingByZero() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> forthEvaluator.evaluateProgram(Collections.singletonList("4 0 /")))
                .withMessage("Division by 0 is not allowed");
    }

    @Ignore("Remove to run test")
    @Test
    public void testErrorIfDivisionAttemptedWithNothingOnTheStack() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> forthEvaluator.evaluateProgram(Collections.singletonList("/")))
                .withMessage("Division requires that the stack contain at least 2 values");
    }

    //@Ignore("Remove to run test")
    @Test
    public void testErrorIfDivisionAttemptedWithOneNumberOnTheStack() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> forthEvaluator.evaluateProgram(Collections.singletonList("1 /")))
                .withMessage("Division requires that the stack contain at least 2 values");
    }

    @Ignore("Remove to run test")
    @Test
    public void testCombinedAdditionAndSubtraction() {
        assertEquals(
                Collections.singletonList(-1),
                forthEvaluator.evaluateProgram(Collections.singletonList("1 2 + 4 -")));
    }

    @Ignore("Remove to run test")
    @Test
    public void testCombinedMultiplicationAndDivision() {
        assertEquals(
                Collections.singletonList(2),
                forthEvaluator.evaluateProgram(Collections.singletonList("2 4 * 3 /")));
    }

    @Ignore("Remove to run test")
    @Test
    public void testDupCopiesAValueOnTheStack() {
        assertEquals(
                Arrays.asList(1, 1),
                forthEvaluator.evaluateProgram(Collections.singletonList("1 dup")));
    }

    @Ignore("Remove to run test")
    @Test
    public void testDupCopiesTopValueOnTheStack() {
        assertEquals(
                Arrays.asList(1, 2, 2),
                forthEvaluator.evaluateProgram(Collections.singletonList("1 2 dup")));
    }

    @Ignore("Remove to run test")
    @Test
    public void testErrorIfDuplicatingAttemptedWithNothingOnTheStack() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> forthEvaluator.evaluateProgram(Collections.singletonList("dup")))
                .withMessage("Duplicating requires that the stack contain at least 1 value");
    }

    @Ignore("Remove to run test")
    @Test
    public void testDropRemovesTheTopValueOnTheStackIfItIsTheOnlyOne() {
        assertEquals(
                Collections.emptyList(),
                forthEvaluator.evaluateProgram(Collections.singletonList("1 drop")));
    }

    @Ignore("Remove to run test")
    @Test
    public void testDropRemovesTheTopValueOnTheStackIfItIsNotTheOnlyOne() {
        assertEquals(
                Collections.singletonList(1),
                forthEvaluator.evaluateProgram(Collections.singletonList("1 2 drop")));
    }

    @Ignore("Remove to run test")
    @Test
    public void testErrorIfDroppingAttemptedWithNothingOnTheStack() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> forthEvaluator.evaluateProgram(Collections.singletonList("drop")))
                .withMessage("Dropping requires that the stack contain at least 1 value");
    }

    @Ignore("Remove to run test")
    @Test
    public void testSwapSwapsTheTopTwosValueOnTheStackIfTheyAreTheOnlyOnes() {
        assertEquals(
                Arrays.asList(2, 1),
                forthEvaluator.evaluateProgram(Collections.singletonList("1 2 swap")));
    }

    @Ignore("Remove to run test")
    @Test
    public void testSwapSwapsTheTopTwosValueOnTheStackIfTheyAreNotTheOnlyOnes() {
        assertEquals(
                Arrays.asList(1, 3, 2),
                forthEvaluator.evaluateProgram(Collections.singletonList("1 2 3 swap")));
    }

    @Ignore("Remove to run test")
    @Test
    public void testErrorIfSwappingAttemptedWithNothingOnTheStack() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> forthEvaluator.evaluateProgram(Collections.singletonList("swap")))
                .withMessage("Swapping requires that the stack contain at least 2 values");
    }

    @Ignore("Remove to run test")
    @Test
    public void testErrorIfSwappingAttemptedWithOneNumberOnTheStack() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> forthEvaluator.evaluateProgram(Collections.singletonList("1 swap")))
                .withMessage("Swapping requires that the stack contain at least 2 values");
    }

    @Ignore("Remove to run test")
    @Test
    public void testOverCopiesTheSecondElementIfThereAreOnlyTwo() {
        assertEquals(
                Arrays.asList(1, 2, 1),
                forthEvaluator.evaluateProgram(Collections.singletonList("1 2 over")));
    }

    @Ignore("Remove to run test")
    @Test
    public void testOverCopiesTheSecondElementIfThereAreMoreThanTwo() {
        assertEquals(
                Arrays.asList(1, 2, 3, 2),
                forthEvaluator.evaluateProgram(Collections.singletonList("1 2 3 over")));
    }

    @Ignore("Remove to run test")
    @Test
    public void testErrorIfOveringAttemptedWithNothingOnTheStack() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> forthEvaluator.evaluateProgram(Collections.singletonList("over")))
                .withMessage("Overing requires that the stack contain at least 2 values");
    }

    @Ignore("Remove to run test")
    @Test
    public void testErrorIfOveringAttemptedWithOneNumberOnTheStack() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> forthEvaluator.evaluateProgram(Collections.singletonList("1 over")))
                .withMessage("Overing requires that the stack contain at least 2 values");
    }

    @Ignore("Remove to run test")
    @Test
    public void testUserDefinedOperatorsCanConsistOfBuiltInOperators() {
        assertEquals(
                Arrays.asList(1, 1, 1),
                forthEvaluator.evaluateProgram(Arrays.asList(": dup-twice dup dup ;", "1 dup-twice")));
    }

    @Ignore("Remove to run test")
    @Test
    public void testUserDefinedOperatorsAreEvaluatedInTheCorrectOrder() {
        assertEquals(
                Arrays.asList(1, 2, 3),
                forthEvaluator.evaluateProgram(Arrays.asList(": countup 1 2 3 ;", "countup")));
    }

    @Ignore("Remove to run test")
    @Test
    public void testCanRedefineAUserDefinedOperator() {
        assertEquals(
                Arrays.asList(1, 1, 1),
                forthEvaluator.evaluateProgram(Arrays.asList(": foo dup ;", ": foo dup dup ;", "1 foo")));
    }

    @Ignore("Remove to run test")
    @Test
    public void testCanOverrideBuiltInWordOperators() {
        assertEquals(
                Arrays.asList(1, 1),
                forthEvaluator.evaluateProgram(Arrays.asList(": swap dup ;", "1 swap")));
    }

    @Ignore("Remove to run test")
    @Test
    public void testCanOverrideBuiltInArithmeticOperators() {
        assertEquals(
                Collections.singletonList(12),
                forthEvaluator.evaluateProgram(Arrays.asList(": + * ;", "3 4 +")));
    }

    @Ignore("Remove to run test")
    @Test
    public void testCanUseDifferentWordsWithTheSameName() {
        assertEquals(
                Arrays.asList(5, 6),
                forthEvaluator.evaluateProgram(Arrays.asList(": foo 5 ;", ": bar foo ;", ": foo 6 ;", "bar foo")));
    }

    @Ignore("Remove to run test")
    @Test
    public void testCanDefineWordThatUsesWordWithTheSameName() {
        assertEquals(
                Collections.singletonList(11),
                forthEvaluator.evaluateProgram(Arrays.asList(": foo 10 ;", ": foo foo 1 + ;", "foo")));
    }

    @Ignore("Remove to run test")
    @Test
    public void testCannotRedefineNumbers() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> forthEvaluator.evaluateProgram(Collections.singletonList(": 1 2 ;")))
                .withMessage("Cannot redefine numbers");
    }

    @Ignore("Remove to run test")
    @Test
    public void testErrorIfEvaluatingAnUndefinedOperator() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> forthEvaluator.evaluateProgram(Collections.singletonList("foo")))
                .withMessage("No definition available for operator \"foo\"");

    }

    @Ignore("Remove to run test")
    @Test
    public void testDupIsCaseInsensitive() {
        assertEquals(
                Arrays.asList(1, 1, 1, 1),
                forthEvaluator.evaluateProgram(Collections.singletonList("1 DUP Dup dup")));
    }

    @Ignore("Remove to run test")
    @Test
    public void testDropIsCaseInsensitive() {
        assertEquals(
                Arrays.asList(1),
                forthEvaluator.evaluateProgram(Collections.singletonList("1 2 3 4 DROP Drop drop")));
    }

    @Ignore("Remove to run test")
    @Test
    public void testSwapIsCaseInsensitive() {
        assertEquals(
                Arrays.asList(2, 3, 4, 1),
                forthEvaluator.evaluateProgram(Collections.singletonList("1 2 SWAP 3 Swap 4 swap")));
    }

    @Ignore("Remove to run test")
    @Test
    public void testOverIsCaseInsensitive() {
        assertEquals(
                Arrays.asList(1, 2, 1, 2, 1),
                forthEvaluator.evaluateProgram(Collections.singletonList("1 2 OVER Over over")));
    }

    @Ignore("Remove to run test")
    @Test
    public void testUserDefinedWordsAreCaseInsensitive() {
        assertEquals(
                Arrays.asList(1, 1, 1, 1),
                forthEvaluator.evaluateProgram(Arrays.asList(": foo dup ;", "1 FOO Foo foo")));
    }

    @Ignore("Remove to run test")
    @Test
    public void testDefinitionsAreCaseInsensitive() {
        assertEquals(
                Arrays.asList(1, 1, 1, 1),
                forthEvaluator.evaluateProgram(Arrays.asList(": SWAP DUP Dup dup ;", "1 swap")));
    }

}
