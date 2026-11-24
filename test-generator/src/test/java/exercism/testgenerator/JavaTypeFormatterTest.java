package exercism.testgenerator;

import com.fasterxml.jackson.databind.ObjectMapper;
import exercism.testgenerator.service.JavaTypeFormatter;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class JavaTypeFormatterTest {

    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    void formatsPrimitives() throws Exception {
        assertThat(JavaTypeFormatter.format(mapper.readTree("null"))).isEqualTo("null");
        assertThat(JavaTypeFormatter.format(mapper.readTree("true"))).isEqualTo("true");
        assertThat(JavaTypeFormatter.format(mapper.readTree("false"))).isEqualTo("false");
        assertThat(JavaTypeFormatter.format(mapper.readTree("42"))).isEqualTo("42");
        assertThat(JavaTypeFormatter.format(mapper.readTree("9999999999"))).isEqualTo("9999999999L");
    }

    @Test
    void formatsEscapedStrings() throws Exception {
        assertThat(JavaTypeFormatter.format(mapper.readTree("\"hello\""))).isEqualTo("\"hello\"");
        assertThat(JavaTypeFormatter.format(mapper.readTree("\"hello \\\"world\\\"\""))).isEqualTo("\"hello \\\"world\\\"\"");
        assertThat(JavaTypeFormatter.format(mapper.readTree("\"line1\\nline2\""))).isEqualTo("\"line1\\nline2\"");
    }

    @Test
    void formatsArrays() throws Exception {
        assertThat(JavaTypeFormatter.format(mapper.readTree("[]"))).isEqualTo("List.of()");
        assertThat(JavaTypeFormatter.format(mapper.readTree("[\"a\", \"b\"]"))).isEqualTo("List.of(\"a\", \"b\")");
        assertThat(JavaTypeFormatter.format(mapper.readTree("[1, 2, 3]"))).isEqualTo("List.of(1, 2, 3)");
    }
}
