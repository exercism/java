import java.util.Collections;
import java.util.Map;
import java.util.Objects;

/**
 * Represents an edge on the graph.
 *
 * NOTE: There is no need to change this file and is treated as read only by the Exercism test runners.
 */
public final class Edge {
    private final String start;

    private final String end;

    private final Map<String, String> attributes;

    public Edge(String start, String end) {
        this.start = start;
        this.end = end;
        this.attributes = Collections.emptyMap();
    }

    public Edge(String start, String end, Map<String, String> attributes) {
        this.start = start;
        this.end = end;
        this.attributes = Map.copyOf(attributes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end, attributes);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Edge other) {
            return Objects.equals(other.start, start)
                && Objects.equals(other.end, end)
                && Objects.equals(other.attributes, attributes);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Edge [start=" + start + ", end=" + end + ", attributes=" + attributes + "]";
    }
}
