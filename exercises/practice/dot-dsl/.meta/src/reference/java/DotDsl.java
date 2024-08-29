import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DotDsl {
    private static class Element<T> {
        private final Map<String, String> attributes = new HashMap<>();

        public Element() {
        }

        public Element(Map<String, String> attributes) {
            this.attributes.putAll(attributes);
        }

        public Map<String, String> getAttributes() {
            return Collections.unmodifiableMap(attributes);
        }
    }

    public static class Graph extends Element<Graph> {

        private final List<Node> nodes = new ArrayList<>();

        private final List<Edge> edges = new ArrayList<>();

        public Graph() {
            super();
        }

        public Graph(Map<String, String> attributes) {
            super(attributes);
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
    }

    public static class Node extends Element<Node> {
        private final String name;

        public Node(String name) {
            this.name = name;
        }

        public Node(String name, Map<String, String> attributes) {
            super(attributes);
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class Edge extends Element<Edge> {
        private final String start;

        private final String end;

        public Edge(String start, String end) {
            this.start = start;
            this.end = end;
        }

        public Edge(String start, String end, Map<String, String> attributes) {
            super(attributes);
            this.start = start;
            this.end = end;
        }

        public String getStart() {
            return start;
        }

        public String getEnd() {
            return end;
        }
    }
}
