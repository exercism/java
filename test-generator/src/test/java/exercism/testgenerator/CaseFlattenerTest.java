package exercism.testgenerator;

import com.fasterxml.jackson.databind.ObjectMapper;
import exercism.testgenerator.model.CanonicalCase;
import exercism.testgenerator.model.CanonicalData;
import exercism.testgenerator.service.CaseFlattener;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CaseFlattenerTest {

    private final ObjectMapper mapper = new ObjectMapper();
    private final CaseFlattener flattener = new CaseFlattener(mapper);

    @Test
    void flattensNestedCanonicalCases() throws Exception {
        String json = """
            {
              "exercise": "example",
              "cases": [
                {
                  "uuid": "case-1",
                  "description": "top level test",
                  "property": "solve",
                  "input": {"x": 1},
                  "expected": 2
                },
                {
                  "description": "grouped tests",
                  "cases": [
                    {
                      "uuid": "case-2",
                      "description": "nested test",
                      "property": "solve",
                      "input": {"x": 2},
                      "expected": 4
                    }
                  ]
                }
              ]
            }
            """;

        CanonicalData data = mapper.readValue(json, CanonicalData.class);
        List<CanonicalCase> cases = flattener.flatten(data.cases());

        assertThat(cases).hasSize(2);
        assertThat(cases.get(0).uuid()).isEqualTo("case-1");
        assertThat(cases.get(0).description()).isEqualTo("top level test");
        assertThat(cases.get(1).uuid()).isEqualTo("case-2");
        assertThat(cases.get(1).description()).isEqualTo("grouped tests -> nested test");
    }
}
