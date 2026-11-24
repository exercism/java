package exercism.testgenerator;

import exercism.testgenerator.service.JavaNamingHelper;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class JavaNamingHelperTest {

    @Test
    void convertsSimpleDescriptionToCamelCase() {
        assertThat(JavaNamingHelper.toMethodName("basic"))
            .isEqualTo("basic");
        assertThat(JavaNamingHelper.toMethodName("lowercase words"))
            .isEqualTo("lowercaseWords");
        assertThat(JavaNamingHelper.toMethodName("all caps word"))
            .isEqualTo("allCapsWord");
    }

    @Test
    void handlesPunctuationAndSymbols() {
        assertThat(JavaNamingHelper.toMethodName("punctuation without whitespace"))
            .isEqualTo("punctuationWithoutWhitespace");
        assertThat(JavaNamingHelper.toMethodName("something - with dashes and spaces!"))
            .isEqualTo("somethingWithDashesAndSpaces");
    }

    @Test
    void handlesStartingWithDigits() {
        assertThat(JavaNamingHelper.toMethodName("123 test"))
            .isEqualTo("test123Test");
    }

    @Test
    void prefixesJavaKeywords() {
        assertThat(JavaNamingHelper.toMethodName("default"))
            .isEqualTo("testDefault");
        assertThat(JavaNamingHelper.toMethodName("class"))
            .isEqualTo("testClass");
    }

    @Test
    void convertsSlugToPascalCase() {
        assertThat(JavaNamingHelper.toPascalCase("acronym"))
            .isEqualTo("Acronym");
        assertThat(JavaNamingHelper.toPascalCase("two-fer"))
            .isEqualTo("TwoFer");
        assertThat(JavaNamingHelper.toPascalCase("difference-of-squares"))
            .isEqualTo("DifferenceOfSquares");
    }
}
