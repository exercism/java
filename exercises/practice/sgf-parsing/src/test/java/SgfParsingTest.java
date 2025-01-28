import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class SgfParsingTest {

    @Test
    public void emptyInput() {
        String input = "";
        assertThatExceptionOfType(SgfParsingException.class).as("tree missing")
                .isThrownBy(() -> new SgfParsing().parse(input));
    }

    @Test
    @Disabled("Remove to run test")
    public void treeWithNoNodes() {
        String input = "()";
        assertThatExceptionOfType(SgfParsingException.class)
                .as("tree with no nodes")
                .isThrownBy(() -> new SgfParsing().parse(input));
    }

    @Test
    @Disabled("Remove to run test")
    public void nodeWithoutTree() {
        String input = ";";
        assertThatExceptionOfType(SgfParsingException.class).as("tree missing")
                .isThrownBy(() -> new SgfParsing().parse(input));
    }

    @Test
    @Disabled("Remove to run test")
    public void nodeWithoutProperties() throws SgfParsingException {
        String input = "(;)";
        SgfNode expected = new SgfNode();
        SgfNode actual = new SgfParsing().parse(input);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @Disabled("Remove to run test")
    public void singleNodeTree() throws SgfParsingException {
        String input = "(;A[B])";
        SgfNode expected = new SgfNode(Map.of("A", List.of("B")));
        SgfNode actual = new SgfParsing().parse(input);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @Disabled("Remove to run test")
    public void multipleProperties() throws SgfParsingException {
        String input = "(;A[b]C[d])";
        SgfNode expected = new SgfNode(Map.of("A", List.of("b"),
                "C", List.of("d")));
        SgfNode actual = new SgfParsing().parse(input);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @Disabled("Remove to run test")
    public void propertiesWithoutDelimiter() {
        String input = "(;A)";
        assertThatExceptionOfType(SgfParsingException.class).as("properties without delimiter")
                .isThrownBy(() -> new SgfParsing().parse(input));
    }

    @Test
    @Disabled("Remove to run test")
    public void allLowercaseProperty() {
        String input = "(;a[b])";
        assertThatExceptionOfType(SgfParsingException.class).as("property must be in uppercase")
                .isThrownBy(() -> new SgfParsing().parse(input));
    }

    @Test
    @Disabled("Remove to run test")
    public void upperAndLowercaseProperty() {
        String input = "(;Aa[b])";
        assertThatExceptionOfType(SgfParsingException.class).as("property must be in uppercase")
                .isThrownBy(() -> new SgfParsing().parse(input));
    }

    @Test
    @Disabled("Remove to run test")
    public void twoNodes() throws SgfParsingException {
        String input = "(;A[B];B[C])";
        SgfNode expected = new SgfNode(Map.of("A", List.of("B")),
                List.of(
                        new SgfNode(Map.of("B", List.of("C")))
                ));
        SgfNode actual = new SgfParsing().parse(input);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @Disabled("Remove to run test")
    public void twoChildTrees() throws SgfParsingException {
        String input = "(;A[B](;B[C])(;C[D]))";
        SgfNode expected = new SgfNode(Map.of("A", List.of("B")),
                List.of(
                        new SgfNode(Map.of("B", List.of("C"))),
                        new SgfNode(Map.of("C", List.of("D")))
                ));
        SgfNode actual = new SgfParsing().parse(input);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @Disabled("Remove to run test")
    public void multiplePropertyValues() throws SgfParsingException {
        String input = "(;A[b][c][d])";
        SgfNode expected = new SgfNode(Map.of("A", List.of("b", "c", "d")));
        SgfNode actual = new SgfParsing().parse(input);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @Disabled("Remove to run test")
    public void withinPropertyValueWhitespace() throws SgfParsingException {
        String input = "(;A[hello\t\tworld])";
        SgfNode expected = new SgfNode(Map.of("A", List.of("hello  world")));
        SgfNode actual = new SgfParsing().parse(input);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @Disabled("Remove to run test")
    public void withinPropertyValueNewline() throws SgfParsingException {
        String input = "(;A[hello\n\nworld])";
        SgfNode expected = new SgfNode(Map.of("A", List.of("hello\n\nworld")));
        SgfNode actual = new SgfParsing().parse(input);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @Disabled("Remove to run test")
    public void escapedClosingBracket() throws SgfParsingException {
        String input = "(;A[\\]])";
        SgfNode expected = new SgfNode(Map.of("A", List.of("]")));
        SgfNode actual = new SgfParsing().parse(input);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @Disabled("Remove to run test")
    public void escapedBacklash() throws SgfParsingException {
        String input = "(;A[\\\\])";
        SgfNode expected = new SgfNode(Map.of("A", List.of("\\")));
        SgfNode actual = new SgfParsing().parse(input);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @Disabled("Remove to run test")
    public void openingBracketNeedNotToBeEscaped() throws SgfParsingException {
        String input = "(;A[x[y\\]z][foo]B[bar];C[baz])";
        SgfNode expected = new SgfNode(Map.of("A", List.of("x[y]z", "foo"),
                "B", List.of("bar")),
                List.of(
                        new SgfNode(Map.of("C", List.of("baz")))
                ));
        SgfNode actual = new SgfParsing().parse(input);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @Disabled("Remove to run test")
    public void semicolonNeedNotToBeEscaped() throws SgfParsingException {
        String input = "(;A[a;b][foo]B[bar];C[baz])";
        SgfNode expected = new SgfNode(Map.of("A", List.of("a;b", "foo"),
                "B", List.of("bar")),
                List.of(
                        new SgfNode(Map.of("C", List.of("baz")))
                ));
        SgfNode actual = new SgfParsing().parse(input);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @Disabled("Remove to run test")
    public void paranthesesNeedNotToBeEscaped() throws SgfParsingException {
        String input = "(;A[x(y)z][foo]B[bar];C[baz])";
        SgfNode expected = new SgfNode(Map.of("A", List.of("x(y)z", "foo"),
                "B", List.of("bar")),
                List.of(
                        new SgfNode(Map.of("C", List.of("baz")))
                ));
        SgfNode actual = new SgfParsing().parse(input);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @Disabled("Remove to run test")
    public void escapedTab() throws SgfParsingException {
        String input = "(;A[hello\\\tworld])";
        SgfNode expected = new SgfNode(Map.of("A", List.of("hello world")));
        SgfNode actual = new SgfParsing().parse(input);
        assertThat(actual).isEqualTo(expected);
    }
    
    @Test
    @Disabled("Remove to run test")
    public void escapedNewline() throws SgfParsingException {
        String input = "(;A[hello\\\nworld])";
        SgfNode expected = new SgfNode(Map.of("A", List.of("helloworld")));
        SgfNode actual = new SgfParsing().parse(input);
        assertThat(actual).isEqualTo(expected);
    }

    
    @Test
    @Disabled("Remove to run test")
    public void escapedTAndN() throws SgfParsingException {
        String input = "(;A[\\t = t and \\n = n])";
        SgfNode expected = new SgfNode(Map.of("A", List.of("t = t and n = n")));
        SgfNode actual = new SgfParsing().parse(input);
        assertThat(actual).isEqualTo(expected);
    }

    
    @Test
    @Disabled("Remove to run test")
    public void mixOfEscapedCharactersAndWhitespaces() throws SgfParsingException {
        String input = "(;A[\\]b\nc\\\nd\t\te\\\\ \\\n\\]])";
        SgfNode expected = new SgfNode(Map.of("A", List.of("]b\ncd  e\\ ]")));
        SgfNode actual = new SgfParsing().parse(input);
        assertThat(actual).isEqualTo(expected);
    }
}
