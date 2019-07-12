import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.Before;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class WordProblemSolverTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    WordProblemSolver solver;

    @Before
    public void setup() {
        solver = new WordProblemSolver();
    }

    @Test
    public void testJustANumber() {
        assertEquals(5, solver.solve("What is 5?"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testSingleAddition1() {
        assertEquals(2, solver.solve("What is 1 plus 1?"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testSingleAddition2() {
        assertEquals(55, solver.solve("What is 53 plus 2?"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testSingleAdditionWithNegativeNumbers() {
        assertEquals(-11, solver.solve("What is -1 plus -10?"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testSingleAdditionOfLargeNumbers() {
        assertEquals(45801, solver.solve("What is 123 plus 45678?"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testSingleSubtraction() {
        assertEquals(16, solver.solve("What is 4 minus -12?"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testSingleMultiplication() {
        assertEquals(-75, solver.solve("What is -3 multiplied by 25?"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testSingleDivision() {
        assertEquals(-11, solver.solve("What is 33 divided by -3?"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testMultipleAdditions() {
        assertEquals(3, solver.solve("What is 1 plus 1 plus 1?"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testAdditionThenSubtraction() {
        assertEquals(8, solver.solve("What is 1 plus 5 minus -2?"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testMultipleSubtractions() {
        assertEquals(3, solver.solve("What is 20 minus 4 minus 13?"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testSubtractionThenAddition() {
        assertEquals(14, solver.solve("What is 17 minus 6 plus 3?"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testMultipleMultiplications() {
        assertEquals(-12, solver.solve("What is 2 multiplied by -2 multiplied by 3?"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testAdditionThenMultiplication() {
        assertEquals(-8, solver.solve("What is -3 plus 7 multiplied by -2?"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testMultipleDivisions() {
        assertEquals(2, solver.solve("What is -12 divided by 2 divided by -3?"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testUnknownOperation() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("I'm sorry, I don't understand the question!");

        solver.solve("What is 52 cubed?");
    }

    @Ignore("Remove to run test")
    @Test
    public void testNonMathQuestion() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("I'm sorry, I don't understand the question!");

        // See https://en.wikipedia.org/wiki/President_of_the_United_States if you really need to know!
        solver.solve("Who is the President of the United States?");
    }

    @Ignore("Remove to run test")
    @Test
    public void testMissingAnOperand() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("I'm sorry, I don't understand the question!");

        solver.solve("What is 1 plus?");
    }

    @Ignore("Remove to run test")
    @Test
    public void testNoOperandsOrOperators() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("I'm sorry, I don't understand the question!");

        solver.solve("What is?");
    }

    @Ignore("Remove to run test")
    @Test
    public void testTwoOperationsInARow() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("I'm sorry, I don't understand the question!");

        solver.solve("What is 1 plus plus 2?");
    }

    @Ignore("Remove to run test")
    @Test
    public void testTwoNumbersAfterOperation() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("I'm sorry, I don't understand the question!");

        solver.solve("What is 1 plus 2 1?");
    }

    @Ignore("Remove to run test")
    @Test
    public void testPostfixNotation() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("I'm sorry, I don't understand the question!");

        solver.solve("What is 1 2 plus?");
    }

    @Ignore("Remove to run test")
    @Test
    public void testPrefixNotation() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("I'm sorry, I don't understand the question!");

        solver.solve("What is plus 1 2?");
    }
}
