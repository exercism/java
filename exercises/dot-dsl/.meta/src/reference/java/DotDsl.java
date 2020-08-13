import java.util.*;

enum Type {
    NODE,
    EDGE,
    ATTR,
}

class Graph {

    List<Node> nodes;
    List<Edge> edges;
    Map<Object, Object> attrs;

    Graph(Object[][] args) {
        nodes = new ArrayList<>();
        edges = new ArrayList<>();
        attrs = new HashMap<>();

        for (Object[] item : args) {
            if (item.length < 3) {
                throw new IllegalArgumentException("Graph item incomplete");
            }
            Object type = item[0];
            if (type == Type.ATTR) {
                if (item.length != 3) {
                    throw new IllegalArgumentException("ATTR malformed");
                }
                attrs.put(item[1], item[2]);
            } else if (type == Type.NODE) {
                if (item.length != 3) {
                    throw new IllegalArgumentException("NODE malformed");
                }
                @SuppressWarnings("unchecked")
                Map<String, String> attrs = (Map<String, String>) item[2];
                nodes.add(new Node((String) item[1], attrs));
            } else if (type == Type.EDGE) {
                if (item.length != 4) {
                    throw new IllegalArgumentException("EDGE malformed");
                }
                @SuppressWarnings("unchecked")
                Map<String, String> attrs = (Map<String, String>) item[3];
                edges.add(new Edge((String) item[1], (String) item[2], attrs));
            } else {
                throw new IllegalArgumentException(String.format("Unknown item %s", type));
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Graph graph = (Graph) o;
        return nodes.equals(graph.nodes) &&
                edges.equals(graph.edges) &&
                attrs.equals(graph.attrs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nodes, edges, attrs);
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
