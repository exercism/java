import java.util.Collections;
import java.util.Map;
import java.util.Objects;

/**
 * Represents a node on the graph.
 *
 * NOTE: There is no need to change this file and is treated as read only by the Exercism test runners.
 */
public final class Node {

    private final String name;

    private final Map<String, String> attributes;

    public Node(String name) {
        this.name = name;
        this.attributes = Collections.emptyMap();
    }

    public Node(String name, Map<String, String> attributes) {
        this.name = name;
        this.attributes = Map.copyOf(attributes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, attributes);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Node other) {
            return Objects.equals(other.name, name) && Objects.equals(other.attributes, attributes);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Node [name=" + name + ", attributes=" + attributes + "]";
    }
}
