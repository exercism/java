import static java.util.Collections.emptyMap;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GraphTest {

    @Test
    @DisplayName("empty graph")
    public void testEmptyGraph() {
        Graph graph = new Graph();

        assertThat(graph.getNodes()).isEmpty();
        assertThat(graph.getEdges()).isEmpty();
        assertThat(graph.getAttributes()).isEmpty();
    }

    @Test
    @Disabled
    @DisplayName("graph with one node")
    public void testGraphWithOneNode() {
        Graph graph = new Graph().node("a");

        assertThat(graph.getNodes()).containsExactly(new Node("a", emptyMap()));
        assertThat(graph.getEdges()).isEmpty();
        assertThat(graph.getAttributes()).isEmpty();
    }

    @Test
    @Disabled
    @DisplayName("graph with one node with attribute")
    public void testGraphWithOneNodeWithAttribute() {
        Graph graph = new Graph().node("a", Map.of("color", "green"));

        assertThat(graph.getNodes())
                .containsExactly(new Node("a", Map.of("color", "green")));
        assertThat(graph.getEdges()).isEmpty();
        assertThat(graph.getAttributes()).isEmpty();
    }

    @Test
    @Disabled
    @DisplayName("graph with one edge")
    public void testGraphWithOneEdge() {
        Graph graph = new Graph().edge("a", "b");

        assertThat(graph.getNodes()).isEmpty();
        assertThat(graph.getEdges())
                .containsExactly(new Edge("a", "b"));
        assertThat(graph.getAttributes()).isEmpty();
    }

    @Test
    @Disabled
    @DisplayName("graph with one edge with attribute")
    public void testGraphWithOneEdgeWithAttribute() {
        Graph graph = new Graph().edge("a", "b", Map.of("color", "blue"));

        assertThat(graph.getNodes()).isEmpty();
        assertThat(graph.getEdges())
                .containsExactly(new Edge("a", "b", Map.of("color", "blue")));
        assertThat(graph.getAttributes()).isEmpty();
    }

    @Test
    @Disabled
    @DisplayName("graph with one attribute")
    public void testGraphWithOneAttribute() {
        Graph graph = new Graph(Map.of("foo", "1"));

        assertThat(graph.getNodes()).isEmpty();
        assertThat(graph.getEdges()).isEmpty();
        assertThat(graph.getAttributes()).containsEntry("foo", "1");
    }

    @Test
    @Disabled
    @DisplayName("graph with nodes, edges, and attributes")
    public void testGraphWithNodesEdgesAndAttributes() {
        Graph graph = new Graph(Map.of("foo", "1", "title", "Testing Attrs", "bar", "true"))
                .node("a", Map.of("color", "green"))
                .node("c")
                .node("b", Map.of("label", "Beta!"))
                .edge("b", "c")
                .edge("a", "b", Map.of("color", "blue"));

        assertThat(graph.getNodes())
                .containsExactlyInAnyOrder(
                        new Node("a", Map.of("color", "green")),
                        new Node("c"),
                        new Node("b", Map.of("label", "Beta!")));

        assertThat(graph.getEdges())
                .containsExactlyInAnyOrder(
                        new Edge("a", "b", Map.of("color", "blue")),
                        new Edge("b", "c"));

        assertThat(graph.getAttributes())
                .containsExactlyInAnyOrderEntriesOf(
                        Map.of("foo", "1", "title", "Testing Attrs", "bar", "true"));
    }

    @Test
    @Disabled
    @DisplayName("multiple edges on one line")
    public void testMultipleEdgesOnOneLine() {
        Graph graph = new Graph()
                .node("a")
                .node("b")
                .node("c")
                .node("d")
                .edge("a", "b", Map.of("style", "dotted"))
                .edge("b", "c", Map.of("style", "dotted"))
                .edge("c", "d", Map.of("style", "dotted"));

        assertThat(graph.getNodes()).containsExactlyInAnyOrder(
                new Node("a"),
                new Node("b"),
                new Node("c"),
                new Node("d")
        );

        assertThat(graph.getEdges())
            .containsExactlyInAnyOrder(
                    new Edge("a", "b", Map.of("style", "dotted")),
                    new Edge("b", "c", Map.of("style", "dotted")),
                    new Edge("c", "d", Map.of("style", "dotted"))
            );
        assertThat(graph.getAttributes()).isEmpty();
    }
}
