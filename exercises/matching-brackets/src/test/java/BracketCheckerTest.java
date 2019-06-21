import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BracketCheckerTest {

    @Test
    public void testPairedSquareBrackets() {
        BracketChecker bracketChecker = new BracketChecker("[]");
        assertTrue(bracketChecker.areBracketsMatchedAndNestedCorrectly());
    }

    @Ignore("Remove to run test")
    @Test
    public void testEmptyString() {
        BracketChecker bracketChecker = new BracketChecker("");
        assertTrue(bracketChecker.areBracketsMatchedAndNestedCorrectly());
    }

    @Ignore("Remove to run test")
    @Test
    public void testUnpairedBrackets() {
        BracketChecker bracketChecker = new BracketChecker("[[");
        assertFalse(bracketChecker.areBracketsMatchedAndNestedCorrectly());
    }

    @Ignore("Remove to run test")
    @Test
    public void testWrongOrderedBrackets() {
        BracketChecker bracketChecker = new BracketChecker("}{");
        assertFalse(bracketChecker.areBracketsMatchedAndNestedCorrectly());
    }

    @Ignore("Remove to run test")
    @Test
    public void testWrongClosingBracket() {
        BracketChecker bracketChecker = new BracketChecker("{]");
        assertFalse(bracketChecker.areBracketsMatchedAndNestedCorrectly());
    }

    @Ignore("Remove to run test")
    @Test
    public void testPairedWithWhitespace() {
        BracketChecker bracketChecker = new BracketChecker("{ }");
        assertTrue(bracketChecker.areBracketsMatchedAndNestedCorrectly());
    }

    @Ignore("Remove to run test")
    @Test
    public void testPartiallyPairedBrackets() {
        BracketChecker bracketChecker = new BracketChecker("{[])");
        assertFalse(bracketChecker.areBracketsMatchedAndNestedCorrectly());
    }

    @Ignore("Remove to run test")
    @Test
    public void testSimpleNestedBrackets() {
        BracketChecker bracketChecker = new BracketChecker("{[]}");
        assertTrue(bracketChecker.areBracketsMatchedAndNestedCorrectly());
    }

    @Ignore("Remove to run test")
    @Test
    public void testSeveralPairedBrackets() {
        BracketChecker bracketChecker = new BracketChecker("{}[]");
        assertTrue(bracketChecker.areBracketsMatchedAndNestedCorrectly());
    }

    @Ignore("Remove to run test")
    @Test
    public void testPairedAndNestedBrackets() {
        BracketChecker bracketChecker = new BracketChecker("([{}({}[])])");
        assertTrue(bracketChecker.areBracketsMatchedAndNestedCorrectly());
    }

    @Ignore("Remove to run test")
    @Test
    public void testUnopenedClosingBracket() {
        BracketChecker bracketChecker = new BracketChecker("{[)][]}");
        assertFalse(bracketChecker.areBracketsMatchedAndNestedCorrectly());
    }

    @Ignore("Remove to run test")
    @Test
    public void testUnpairedAndNestedBrackets() {
        BracketChecker bracketChecker = new BracketChecker("([{])");
        assertFalse(bracketChecker.areBracketsMatchedAndNestedCorrectly());
    }

    @Ignore("Remove to run test")
    @Test
    public void testPairedAndWrongNestedBrackets() {
        BracketChecker bracketChecker = new BracketChecker("[({]})");
        assertFalse(bracketChecker.areBracketsMatchedAndNestedCorrectly());
    }

    @Ignore("Remove to run test")
    @Test
    public void testPairedAndIncompleteBrackets() {
        BracketChecker bracketChecker = new BracketChecker("{}[");
        assertFalse(bracketChecker.areBracketsMatchedAndNestedCorrectly());
    }

    @Ignore("Remove to run test")
    @Test
    public void testTooManyClosingBrackets() {
        BracketChecker bracketChecker = new BracketChecker("[]]");
        assertFalse(bracketChecker.areBracketsMatchedAndNestedCorrectly());
    }

    @Ignore("Remove to run test")
    @Test
    public void testMathExpression() {
        BracketChecker bracketChecker = new BracketChecker("(((185 + 223.85) * 15) - 543)/2");
        assertTrue(bracketChecker.areBracketsMatchedAndNestedCorrectly());
    }

    @Ignore("Remove to run test")
    @Test
    public void testComplexLatexExpression() {
        BracketChecker bracketChecker = new BracketChecker(
                "\\left(\\begin{array}{cc} \\frac{1}{3} & x\\\\ \\mathrm{e}^{x} &... x^2 \\end{array}\\right)");

        assertTrue(bracketChecker.areBracketsMatchedAndNestedCorrectly());
    }

}
