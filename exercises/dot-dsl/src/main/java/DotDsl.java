import java.util.Map;
import java.util.Objects;

class Graph {

    Graph(Object[][] args) {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }
}

class Node {
    private final String name;
    private final Map<String, String> attrs;

    Node(String name, Map<String, String> attrs) {
        this.name = name;
        this.attrs = attrs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Node node = (Node) o;
        return name.equals(node.name) &&
                attrs.equals(node.attrs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, attrs);
    }
}

class Edge {
    private final String src, dst;
    private final Map<String, String> attrs;

    Edge(String src, String dst, Map<String, String> attrs) {
        this.src = src;
        this.dst = dst;
        this.attrs = attrs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Edge edge = (Edge) o;
        return src.equals(edge.src) &&
                dst.equals(edge.dst) &&
                attrs.equals(edge.attrs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(src, dst, attrs);
    }
}
