import java.util.Collection;
import java.util.Map;

class DotDsl {

    static class Graph {
        public Graph() {
        }

        public Graph(Map<String, String> attributes) {
        }

        public Collection<Node> getNodes() {
            throw new UnsupportedOperationException();
        }

        public Collection<Edge> getEdges() {
            throw new UnsupportedOperationException();
        }

        public Graph node(String name) {
            throw new UnsupportedOperationException();
        }

        public Graph node(String name, Map<String, String> attributes) {
            throw new UnsupportedOperationException();
        }

        public Graph edge(String start, String end) {
            throw new UnsupportedOperationException();
        }

        public Graph edge(String start, String end, Map<String, String> attributes) {
            throw new UnsupportedOperationException();
        }

        public Map<String, String> getAttributes() {
            throw new UnsupportedOperationException();
        }
    }

    static class Node {
        public String getName() {
            throw new UnsupportedOperationException();
        }

        public Map<String, String> getAttributes() {
            throw new UnsupportedOperationException();
        }
    }

    static class Edge {
        public String getStart() {
            throw new UnsupportedOperationException();
        }

        public String getEnd() {
            throw new UnsupportedOperationException();
        }

        public Map<String, String> getAttributes() {
            throw new UnsupportedOperationException();
        }
    }
}
