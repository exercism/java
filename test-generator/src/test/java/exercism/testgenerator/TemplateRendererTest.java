package exercism.testgenerator;

import exercism.testgenerator.service.TemplateRenderer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TemplateRendererTest {

    @Test
    @DisplayName("cleans up blank lines between annotations and trailing whitespace")
    void testCleanJavaFormattingRemovesBlankLinesBetweenAnnotations() {
        String input = """
            public class ExampleTest {

                
                @Test
                @DisplayName("first test")
                public void testOne() {
                    assertThat(true).isTrue();
                }

                
                @Disabled("Remove to run test")
                
                @Test
                @DisplayName("second test")
                public void testTwo() {
                    assertThat(true).isTrue();
                }

            }
            """;

        String cleaned = TemplateRenderer.cleanJavaFormatting(input);

        String expected = """
            public class ExampleTest {

                @Test
                @DisplayName("first test")
                public void testOne() {
                    assertThat(true).isTrue();
                }

                @Disabled("Remove to run test")
                @Test
                @DisplayName("second test")
                public void testTwo() {
                    assertThat(true).isTrue();
                }

            }
            """;

        assertThat(cleaned).isEqualTo(expected);
    }
}
