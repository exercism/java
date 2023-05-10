import static org.junit.Assert.assertEquals;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;

public class SgfParsingTest {

    @Test
    public void emptyInput() {
        String input = "";
        assertThatExceptionOfType(SgfParsingException.class)
                .isThrownBy(() -> new SgfParsing().parse(input))
                .withMessage("tree missing");
    }

    @Test
    @Ignore("Remove to run test")
    public void treeWithNoNodes() {
        String input = "()";
        assertThatExceptionOfType(SgfParsingException.class)
                .isThrownBy(() -> new SgfParsing().parse(input))
                .withMessage("tree with no nodes");
    }

    @Test
    @Ignore("Remove to run test")
    public void nodeWithoutTree() {
        String input = ";";
        assertThatExceptionOfType(SgfParsingException.class)
                .isThrownBy(() -> new SgfParsing().parse(input))
                .withMessage("tree missing");
    }

    @Test
    @Ignore("Remove to run test")
    public void nodeWithoutProperties() throws SgfParsingException {
        String input = "(;)";
        SgfNode expected = new SgfNode();
        SgfNode actual = new SgfParsing().parse(input);
        assertEquals(expected, actual);
    }

    @Test
    @Ignore("Remove to run test")
    public void singleNodeTree() throws SgfParsingException {
        String input = "(;A[B])";
        SgfNode expected = new SgfNode(Map.of("A", List.of("B")));
        SgfNode actual = new SgfParsing().parse(input);
        assertEquals(expected, actual);
    }

    @Test
    @Ignore("Remove to run test")
    public void multipleProperties() throws SgfParsingException {
        String input = "(;A[b]C[d])";
        SgfNode expected = new SgfNode(Map.of("A", List.of("b"),
                                              "C", List.of("d")));
        SgfNode actual = new SgfParsing().parse(input);
        assertEquals(expected, actual);
    }

    @Test
    @Ignore("Remove to run test")
    public void propertiesWithoutDelimiter() {
        String input = "(;A)";
         assertThatExceptionOfType(SgfParsingException.class)
                .isThrownBy(() -> new SgfParsing().parse(input))
                .withMessage("properties without delimiter");
    }

    @Test
    @Ignore("Remove to run test")
    public void allLowercaseProperty() {
        String input = "(;a[b])";
        assertThatExceptionOfType(SgfParsingException.class)
                .isThrownBy(() -> new SgfParsing().parse(input))
                .withMessage("property must be in uppercase");
    }

    @Test
    @Ignore("Remove to run test")
    public void upperAndLowercaseProperty() {
        String input = "(;Aa[b])";
        assertThatExceptionOfType(SgfParsingException.class)
                .isThrownBy(() -> new SgfParsing().parse(input))
                .withMessage("property must be in uppercase");
    }

    @Test
    @Ignore("Remove to run test")
    public void twoNodes() throws SgfParsingException {
        String input = "(;A[B];B[C])";
        SgfNode expected = new SgfNode(Map.of("A", List.of("B")),
                                       List.of(
                                               new SgfNode(Map.of("B", List.of("C")))
                                       ));
        SgfNode actual = new SgfParsing().parse(input);
        assertEquals(expected, actual);
    }

    @Test
    @Ignore("Remove to run test")
    public void twoChildTrees() throws SgfParsingException {
        String input = "(;A[B](;B[C])(;C[D]))";
        SgfNode expected = new SgfNode(Map.of("A", List.of("B")),
                                       List.of(
                                               new SgfNode(Map.of("B", List.of("C"))),
                                               new SgfNode(Map.of("C", List.of("D")))
                                       ));
        SgfNode actual = new SgfParsing().parse(input);
        assertEquals(expected, actual);
    }

    @Test
    @Ignore("Remove to run test")
    public void multiplePropertyValues() throws SgfParsingException {
        String input = "(;A[b][c][d])";
        SgfNode expected = new SgfNode(Map.of("A", List.of("b", "c", "d")));
        SgfNode actual = new SgfParsing().parse(input);
        assertEquals(expected, actual);
    }

    @Test
    @Ignore("Remove to run test")
    public void escapedProperty() throws SgfParsingException {
        String input = "(;A[\\]b\nc\nd\t\te \n\\]])";
        SgfNode expected = new SgfNode(Map.of("A", List.of("]b\nc\nd\t\te \n]")));
        SgfNode actual = new SgfParsing().parse(input);
        assertEquals(expected, actual);
    }

}
