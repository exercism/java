import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public final class BracketCheckerTest {

    @Test
    public void testPairedSquareBrackets() {
        final BracketChecker bracketChecker = new BracketChecker("[]");
        assertTrue(bracketChecker.areBracketsMatchedAndNestedCorrectly());
    }

    @Ignore
    @Test
    public void testEmptyString() {
        final BracketChecker bracketChecker = new BracketChecker("");
        assertTrue(bracketChecker.areBracketsMatchedAndNestedCorrectly());
    }

    @Ignore
    @Test
    public void testUnpairedBrackets() {
        final BracketChecker bracketChecker = new BracketChecker("[[");
        assertFalse(bracketChecker.areBracketsMatchedAndNestedCorrectly());
    }

    @Ignore
    @Test
    public void testIncorrectlyOrderedBrackets() {
        final BracketChecker bracketChecker = new BracketChecker("}{");
        assertFalse(bracketChecker.areBracketsMatchedAndNestedCorrectly());
    }

    @Ignore
    @Test
    public void testPairedBracketsWithWhitespace() {
        final BracketChecker bracketChecker = new BracketChecker("{ }");
        assertTrue(bracketChecker.areBracketsMatchedAndNestedCorrectly());
    }

    @Ignore
    @Test
    public void testSimpleNestedBrackets() {
        final BracketChecker bracketChecker = new BracketChecker("{[]}");
        assertTrue(bracketChecker.areBracketsMatchedAndNestedCorrectly());
    }

    @Ignore
    @Test
    public void testSeveralPairedBrackets() {
        final BracketChecker bracketChecker = new BracketChecker("{}[]");
        assertTrue(bracketChecker.areBracketsMatchedAndNestedCorrectly());
    }

    @Ignore
    @Test
    public void testPairedAndNestedBrackets() {
        final BracketChecker bracketChecker = new BracketChecker("([{}({}[])])");
        assertTrue(bracketChecker.areBracketsMatchedAndNestedCorrectly());
    }

    @Ignore
    @Test
    public void testUnopenedClosingBracket() {
        final BracketChecker bracketChecker = new BracketChecker("{[)][]}");
        assertFalse(bracketChecker.areBracketsMatchedAndNestedCorrectly());
    }

    @Ignore
    @Test
    public void testUnpairedAndNestedBracket() {
        final BracketChecker bracketChecker = new BracketChecker("([{])");
        assertFalse(bracketChecker.areBracketsMatchedAndNestedCorrectly());
    }

    @Ignore
    @Test
    public void testPairedAndIncorrectlyNestedBrackets() {
        final BracketChecker bracketChecker = new BracketChecker("[({]})");
        assertFalse(bracketChecker.areBracketsMatchedAndNestedCorrectly());
    }

    @Ignore
    @Test
    public void testValidMathExpression() {
        final BracketChecker bracketChecker = new BracketChecker("(((185 + 223.85) * 15) - 543)/2");
        assertTrue(bracketChecker.areBracketsMatchedAndNestedCorrectly());
    }

    @Ignore
    @Test
    public void testValidComplexLaTeXExpression() {
        final BracketChecker bracketChecker = new BracketChecker(
                "\\left(\\begin{array}{cc} \\frac{1}{3} & x\\\\ \\mathrm{e}^{x} &... x^2 \\end{array}\\right)");

        assertTrue(bracketChecker.areBracketsMatchedAndNestedCorrectly());
    }

}
