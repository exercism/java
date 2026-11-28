package exercism.testgenerator;

import exercism.testgenerator.model.TestCaseConfig;
import exercism.testgenerator.service.TestsTomlService;
import java.util.Collections;
import java.util.Map;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TestsTomlServiceTest {

    private final TestsTomlService service = new TestsTomlService();

    @Test
    void parsesTestsTomlWithIncludesAndExcludes() throws Exception {
        String toml = """
            [1e22cceb-c5e4-4562-9afe-aef07ad1eaf4]
            description = "basic"

            [b3cca662-f50a-489e-ae10-ab8290a09bdc]
            description = "detects two anagrams"
            include = false
            comment = "not supported"
            """;

        Map<String, TestCaseConfig> result = service.parseTestsToml(toml);

        assertThat(result).hasSize(2);
        assertThat(service.isCaseIncluded(result, "1e22cceb-c5e4-4562-9afe-aef07ad1eaf4")).isTrue();
        assertThat(service.isCaseIncluded(result, "b3cca662-f50a-489e-ae10-ab8290a09bdc")).isFalse();
        assertThat(service.isCaseIncluded(result, "unknown-uuid")).isFalse(); // omitted from tests.toml implies excluded
        assertThat(service.isCaseIncluded(Collections.emptyMap(), "unknown-uuid")).isTrue(); // empty/no tests.toml implies included
    }
}
