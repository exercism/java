import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public final class WordProblemSolverTest {

    /*
     * See https://github.com/junit-team/junit4/wiki/Rules for information on JUnit Rules in general and
     * ExpectedExceptions in particular.
     */
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testSingleAddition1() {
        assertEquals(2, new WordProblemSolver().solve("What is 1 plus 1?"));
    }

    @Ignore
    @Test
    public void testSingleAddition2() {
        assertEquals(55, new WordProblemSolver().solve("What is 53 plus 2?"));
    }

    @Ignore
    @Test
    public void testSingleAdditionWithNegativeNumbers() {
        assertEquals(-11, new WordProblemSolver().solve("What is -1 plus -10?"));
    }

    @Ignore
    @Test
    public void testSingleAdditionOfLargeNumbers() {
        assertEquals(45801, new WordProblemSolver().solve("What is 123 plus 45678?"));
    }

    @Ignore
    @Test
    public void testSingleSubtraction() {
        assertEquals(16, new WordProblemSolver().solve("What is 4 minus -12?"));
    }

    @Ignore
    @Test
    public void testSingleMultiplication() {
        assertEquals(-75, new WordProblemSolver().solve("What is -3 multiplied by 25?"));
    }

    @Ignore
    @Test
    public void testSingleDivision() {
        assertEquals(-11, new WordProblemSolver().solve("What is 33 divided by -3?"));
    }

    @Ignore
    @Test
    public void testMultipleAdditions() {
        assertEquals(3, new WordProblemSolver().solve("What is 1 plus 1 plus 1?"));
    }

    @Ignore
    @Test
    public void testAdditionThenSubtraction() {
        assertEquals(8, new WordProblemSolver().solve("What is 1 plus 5 minus -2?"));
    }

    @Ignore
    @Test
    public void testMultipleSubtractions() {
        assertEquals(3, new WordProblemSolver().solve("What is 20 minus 4 minus 13?"));
    }

    @Ignore
    @Test
    public void testSubtractionThenAddition() {
        assertEquals(14, new WordProblemSolver().solve("What is 17 minus 6 plus 3?"));
    }

    @Ignore
    @Test
    public void testMultipleMultiplications() {
        assertEquals(-12, new WordProblemSolver().solve("What is 2 multiplied by -2 multiplied by 3?"));
    }

    @Ignore
    @Test
    public void testAdditionThenMultiplication() {
        assertEquals(-8, new WordProblemSolver().solve("What is -3 plus 7 multiplied by -2?"));
    }

    @Ignore
    @Test
    public void testMultipleDivisions() {
        assertEquals(2, new WordProblemSolver().solve("What is -12 divided by 2 divided by -3?"));
    }

    @Ignore
    @Test
    public void testUnknownOperation() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("I'm sorry, I don't understand the question!");

        new WordProblemSolver().solve("What is 52 cubed?");
    }

    @Ignore
    @Test
    public void testInvalidQuestionFormat() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("I'm sorry, I don't understand the question!");

        // See https://en.wikipedia.org/wiki/President_of_the_United_States if you really need to know!
        new WordProblemSolver().solve("Who is the President of the United States?");
    }

}
