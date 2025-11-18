import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BracketCheckerTest {

    @Test
    @DisplayName("paired square brackets")
    public void testPairedSquareBrackets() {
        BracketChecker bracketChecker = new BracketChecker("[]");
        assertThat(bracketChecker.areBracketsMatchedAndNestedCorrectly()).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("empty string")
    public void testEmptyString() {
        BracketChecker bracketChecker = new BracketChecker("");
        assertThat(bracketChecker.areBracketsMatchedAndNestedCorrectly()).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("unpaired brackets")
    public void testUnpairedBrackets() {
        BracketChecker bracketChecker = new BracketChecker("[[");
        assertThat(bracketChecker.areBracketsMatchedAndNestedCorrectly()).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("wrong ordered brackets")
    public void testWrongOrderedBrackets() {
        BracketChecker bracketChecker = new BracketChecker("}{");
        assertThat(bracketChecker.areBracketsMatchedAndNestedCorrectly()).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("wrong closing bracket")
    public void testWrongClosingBracket() {
        BracketChecker bracketChecker = new BracketChecker("{]");
        assertThat(bracketChecker.areBracketsMatchedAndNestedCorrectly()).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("paired with whitespace")
    public void testPairedWithWhitespace() {
        BracketChecker bracketChecker = new BracketChecker("{ }");
        assertThat(bracketChecker.areBracketsMatchedAndNestedCorrectly()).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("partially paired brackets")
    public void testPartiallyPairedBrackets() {
        BracketChecker bracketChecker = new BracketChecker("{[])");
        assertThat(bracketChecker.areBracketsMatchedAndNestedCorrectly()).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("simple nested brackets")
    public void testSimpleNestedBrackets() {
        BracketChecker bracketChecker = new BracketChecker("{[]}");
        assertThat(bracketChecker.areBracketsMatchedAndNestedCorrectly()).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("several paired brackets")
    public void testSeveralPairedBrackets() {
        BracketChecker bracketChecker = new BracketChecker("{}[]");
        assertThat(bracketChecker.areBracketsMatchedAndNestedCorrectly()).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("paired and nested brackets")
    public void testPairedAndNestedBrackets() {
        BracketChecker bracketChecker = new BracketChecker("([{}({}[])])");
        assertThat(bracketChecker.areBracketsMatchedAndNestedCorrectly()).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("unopened closing brackets")
    public void testUnopenedClosingBracket() {
        BracketChecker bracketChecker = new BracketChecker("{[)][]}");
        assertThat(bracketChecker.areBracketsMatchedAndNestedCorrectly()).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("unpaired and nested brackets")
    public void testUnpairedAndNestedBrackets() {
        BracketChecker bracketChecker = new BracketChecker("([{])");
        assertThat(bracketChecker.areBracketsMatchedAndNestedCorrectly()).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("paired and wrong nested brackets")
    public void testPairedAndWrongNestedBrackets() {
        BracketChecker bracketChecker = new BracketChecker("[({]})");
        assertThat(bracketChecker.areBracketsMatchedAndNestedCorrectly()).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("paired and wrong nested brackets but innermost are correct")
    public void testPairedAndWrongNestedBracketsButInnermostAreCorrect() {
        BracketChecker bracketChecker = new BracketChecker("[({}])");
        assertThat(bracketChecker.areBracketsMatchedAndNestedCorrectly()).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("paired and incomplete brackets")
    public void testPairedAndIncompleteBrackets() {
        BracketChecker bracketChecker = new BracketChecker("{}[");
        assertThat(bracketChecker.areBracketsMatchedAndNestedCorrectly()).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("too many closing brackets")
    public void testTooManyClosingBrackets() {
        BracketChecker bracketChecker = new BracketChecker("[]]");
        assertThat(bracketChecker.areBracketsMatchedAndNestedCorrectly()).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("early unexpected brackets")
    public void testEarlyUnexpectedBrackets() {
        BracketChecker bracketChecker = new BracketChecker(")()");
        assertThat(bracketChecker.areBracketsMatchedAndNestedCorrectly()).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("early mismatched brackets")
    public void testEarlyMismatchedBrackets() {
        BracketChecker bracketChecker = new BracketChecker("{)()");
        assertThat(bracketChecker.areBracketsMatchedAndNestedCorrectly()).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("math expression")
    public void testMathExpression() {
        BracketChecker bracketChecker = new BracketChecker("(((185 + 223.85) * 15) - 543)/2");
        assertThat(bracketChecker.areBracketsMatchedAndNestedCorrectly()).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("complex latex expression")
    public void testComplexLatexExpression() {
        BracketChecker bracketChecker = new BracketChecker(
                "\\left(\\begin{array}{cc} \\frac{1}{3} & x\\\\ \\mathrm{e}^{x} &... x^2 \\end{array}\\right)");

        assertThat(bracketChecker.areBracketsMatchedAndNestedCorrectly()).isTrue();
    }

}
