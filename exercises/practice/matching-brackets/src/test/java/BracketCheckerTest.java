import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BracketCheckerTest {

    @Test
    @DisplayName("Paired square brackets are matched and valid")
    public void testPairedSquareBrackets() {
        BracketChecker bracketChecker = new BracketChecker("[]");
        assertThat(bracketChecker.areBracketsMatchedAndNestedCorrectly()).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Empty string contains no brackets and is valid")
    public void testEmptyString() {
        BracketChecker bracketChecker = new BracketChecker("");
        assertThat(bracketChecker.areBracketsMatchedAndNestedCorrectly()).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Unpaired brackets are invalid")
    public void testUnpairedBrackets() {
        BracketChecker bracketChecker = new BracketChecker("[[");
        assertThat(bracketChecker.areBracketsMatchedAndNestedCorrectly()).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Wrong ordered brackets are invalid")
    public void testWrongOrderedBrackets() {
        BracketChecker bracketChecker = new BracketChecker("}{");
        assertThat(bracketChecker.areBracketsMatchedAndNestedCorrectly()).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Wrong closing bracket type is invalid")
    public void testWrongClosingBracket() {
        BracketChecker bracketChecker = new BracketChecker("{]");
        assertThat(bracketChecker.areBracketsMatchedAndNestedCorrectly()).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Paired brackets with whitespace are valid")
    public void testPairedWithWhitespace() {
        BracketChecker bracketChecker = new BracketChecker("{ }");
        assertThat(bracketChecker.areBracketsMatchedAndNestedCorrectly()).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Partially paired brackets are invalid")
    public void testPartiallyPairedBrackets() {
        BracketChecker bracketChecker = new BracketChecker("{[])");
        assertThat(bracketChecker.areBracketsMatchedAndNestedCorrectly()).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Simple nested brackets are valid")
    public void testSimpleNestedBrackets() {
        BracketChecker bracketChecker = new BracketChecker("{[]}");
        assertThat(bracketChecker.areBracketsMatchedAndNestedCorrectly()).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Several paired brackets in sequence are valid")
    public void testSeveralPairedBrackets() {
        BracketChecker bracketChecker = new BracketChecker("{}[]");
        assertThat(bracketChecker.areBracketsMatchedAndNestedCorrectly()).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Paired and nested complex brackets are valid")
    public void testPairedAndNestedBrackets() {
        BracketChecker bracketChecker = new BracketChecker("([{}({}[])])");
        assertThat(bracketChecker.areBracketsMatchedAndNestedCorrectly()).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Unopened closing bracket is invalid")
    public void testUnopenedClosingBracket() {
        BracketChecker bracketChecker = new BracketChecker("{[)][]}");
        assertThat(bracketChecker.areBracketsMatchedAndNestedCorrectly()).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Unpaired and nested brackets are invalid")
    public void testUnpairedAndNestedBrackets() {
        BracketChecker bracketChecker = new BracketChecker("([{])");
        assertThat(bracketChecker.areBracketsMatchedAndNestedCorrectly()).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Paired but wrongly nested brackets are invalid")
    public void testPairedAndWrongNestedBrackets() {
        BracketChecker bracketChecker = new BracketChecker("[({]})");
        assertThat(bracketChecker.areBracketsMatchedAndNestedCorrectly()).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Innermost correct but overall wrong nesting is invalid")
    public void testPairedAndWrongNestedBracketsButInnermostAreCorrect() {
        BracketChecker bracketChecker = new BracketChecker("[({}])");
        assertThat(bracketChecker.areBracketsMatchedAndNestedCorrectly()).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Paired and incomplete brackets are invalid")
    public void testPairedAndIncompleteBrackets() {
        BracketChecker bracketChecker = new BracketChecker("{}[");
        assertThat(bracketChecker.areBracketsMatchedAndNestedCorrectly()).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Too many closing brackets are invalid")
    public void testTooManyClosingBrackets() {
        BracketChecker bracketChecker = new BracketChecker("[]]");
        assertThat(bracketChecker.areBracketsMatchedAndNestedCorrectly()).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Early unexpected closing bracket is invalid")
    public void testEarlyUnexpectedBrackets() {
        BracketChecker bracketChecker = new BracketChecker(")()");
        assertThat(bracketChecker.areBracketsMatchedAndNestedCorrectly()).isFalse();
    }
    
    @Disabled("Remove to run test")
    @Test
    @DisplayName("Early mismatched brackets are invalid")
    public void testEarlyMismatchedBrackets() {
        BracketChecker bracketChecker = new BracketChecker("{)()");
        assertThat(bracketChecker.areBracketsMatchedAndNestedCorrectly()).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Math expression with balanced parentheses is valid")
    public void testMathExpression() {
        BracketChecker bracketChecker = new BracketChecker("(((185 + 223.85) * 15) - 543)/2");
        assertThat(bracketChecker.areBracketsMatchedAndNestedCorrectly()).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Complex LaTeX expression with matched brackets is valid")
    public void testComplexLatexExpression() {
        BracketChecker bracketChecker = new BracketChecker(
                "\\left(\\begin{array}{cc} \\frac{1}{3} & x\\\\ \\mathrm{e}^{x} &... x^2 \\end{array}\\right)");

        assertThat(bracketChecker.areBracketsMatchedAndNestedCorrectly()).isTrue();
    }

}
