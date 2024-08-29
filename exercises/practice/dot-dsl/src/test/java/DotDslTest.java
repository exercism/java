import static java.util.Collections.emptyMap;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

import java.util.Map;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DotDslTest {

    @Test
    @DisplayName("empty graph")
    public void testEmptyGraph() {
        DotDsl.Graph graph = new DotDsl.Graph();

        assertThat(graph.getNodes()).isEmpty();
        assertThat(graph.getEdges()).isEmpty();
        assertThat(graph.getAttributes()).isEmpty();
    }

    @Test
    @Disabled
    @DisplayName("graph with one node")
    public void testGraphWithOneNode() {
        DotDsl.Graph graph = new DotDsl.Graph().node("a");

        assertThat(graph.getNodes())
                .extracting("name", "attributes")
                .containsExactly(tuple("a", emptyMap()));
        assertThat(graph.getEdges()).isEmpty();
        assertThat(graph.getAttributes()).isEmpty();
    }

    @Test
    @Disabled
    @DisplayName("graph with one node with keywords")
    public void testGraphWithOneNodeWithKeywords() {
        DotDsl.Graph graph = new DotDsl.Graph().node("a", Map.of("color", "green"));

        assertThat(graph.getNodes())
                .extracting("name", "attributes")
                .containsExactly(tuple("a", Map.of("color", "green")));
        assertThat(graph.getEdges()).isEmpty();
        assertThat(graph.getAttributes()).isEmpty();
    }

    @Test
    @Disabled
    @DisplayName("graph with one edge")
    public void testGraphWithOneEdge() {
        DotDsl.Graph graph = new DotDsl.Graph().edge("a", "b");

        assertThat(graph.getNodes()).isEmpty();
        assertThat(graph.getEdges())
                .extracting("start", "end", "attributes")
                .containsExactly(tuple("a", "b", emptyMap()));
        assertThat(graph.getAttributes()).isEmpty();
    }

    @Test
    @Disabled
    @DisplayName("graph with one edge with keywords")
    public void testGraphWithOneEdgeWithKeywords() {
        DotDsl.Graph graph = new DotDsl.Graph().edge("a", "b", Map.of("color", "blue"));

        assertThat(graph.getNodes()).isEmpty();
        assertThat(graph.getEdges())
                .extracting("start", "end", "attributes")
                .containsExactly(tuple("a", "b", Map.of("color", "blue")));
        assertThat(graph.getAttributes()).isEmpty();
    }

    @Test
    @Disabled
    @DisplayName("graph with one attribute")
    public void testGraphWithOneAttribute() {
        DotDsl.Graph graph = new DotDsl.Graph(Map.of("foo", "1"));

        assertThat(graph.getNodes()).isEmpty();
        assertThat(graph.getEdges()).isEmpty();
        assertThat(graph.getAttributes()).containsEntry("foo", "1");
    }

    @Test
    @Disabled
    @DisplayName("graph with attributes")
    public void testGraphWithAttributes() {
        DotDsl.Graph graph = new DotDsl.Graph(Map.of("foo", "1", "title", "Testing Attrs", "bar", "true"))
                .node("a", Map.of("color", "green"))
                .node("c")
                .node("b", Map.of("label", "Beta!"))
                .edge("b", "c")
                .edge("a", "b", Map.of("color", "blue"));

        assertThat(graph.getNodes())
                .extracting("name", "attributes")
                .containsExactlyInAnyOrder(
                        tuple("a", Map.of("color", "green")),
                        tuple("c", emptyMap()),
                        tuple("b", Map.of("label", "Beta!")));

        assertThat(graph.getEdges())
                .extracting("start", "end", "attributes")
                .containsExactlyInAnyOrder(
                        tuple("a", "b", Map.of("color", "blue")), tuple("b", "c", emptyMap()));

        assertThat(graph.getAttributes())
                .containsExactlyInAnyOrderEntriesOf(
                        Map.of("foo", "1", "title", "Testing Attrs", "bar", "true"));
    }
}
