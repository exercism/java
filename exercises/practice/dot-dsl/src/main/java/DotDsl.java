import java.util.Collection;
import java.util.Map;

class DotDsl {

    static class Graph {
        public Graph() {
        }

        public Graph(Map<String, String> attributes) {
        }

        public Collection<Node> getNodes() {
            throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
        }

        public Collection<Edge> getEdges() {
            throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
        }

        public Graph node(String name) {
            throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
        }

        public Graph node(String name, Map<String, String> attributes) {
            throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
        }

        public Graph edge(String start, String end) {
            throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
        }

        public Graph edge(String start, String end, Map<String, String> attributes) {
            throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
        }

        public Map<String, String> getAttributes() {
            throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
        }
    }

    static class Node {
        public String getName() {
            throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
        }

        public Map<String, String> getAttributes() {
            throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
        }
    }

    static class Edge {
        public String getStart() {
            throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
        }

        public String getEnd() {
            throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
        }

        public Map<String, String> getAttributes() {
            throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
        }
    }
}
