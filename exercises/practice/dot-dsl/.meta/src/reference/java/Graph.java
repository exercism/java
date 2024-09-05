import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Graph {

    private final List<Node> nodes = new ArrayList<>();

    private final List<Edge> edges = new ArrayList<>();

    private final Map<String, String> attributes;

    public Graph() {
        this.attributes = Collections.emptyMap();
    }

    public Graph(Map<String, String> attributes) {
        this.attributes = Map.copyOf(attributes);
    }

    public Collection<Node> getNodes() {
        return Collections.unmodifiableList(nodes);
    }

    public Collection<Edge> getEdges() {
        return Collections.unmodifiableList(edges);
    }

    public Graph node(String name) {
        nodes.add(new Node(name));
        return this;
    }

    public Graph node(String name, Map<String, String> attributes) {
        nodes.add(new Node(name, attributes));
        return this;
    }

    public Graph edge(String start, String end) {
        edges.add(new Edge(start, end));
        return this;
    }

    public Graph edge(String start, String end, Map<String, String> attributes) {
        edges.add(new Edge(start, end, attributes));
        return this;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }
}
