import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class RelativeDistance {

    private final Map<String, HashSet<String>> graph;

    RelativeDistance(Map<String, List<String>>  familyTree) {
        final HashMap<String, HashSet<String>> connections = new HashMap<>();

        for (Map.Entry<String, List<String>> entry : familyTree.entrySet()) {
            String parent = entry.getKey();
            List<String> children = entry.getValue();

            connections.putIfAbsent(parent, new HashSet<>());

            for (String child : children) {
                connections.putIfAbsent(child, new HashSet<>());

                connections.get(parent).add(child);
                connections.get(child).add(parent);

                for (String sibling : children) {
                    if (!sibling.equals(child)) {
                        connections.get(child).add(sibling);
                    }
                }
            }
        }

        graph = connections;
    }

    int degreeOfSeparation(String personA, String personB) {
        if (!graph.containsKey(personA) || !graph.containsKey(personB)) {
            return -1;
        }

        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> distances = new HashMap<>() {
            {
                put(personA, 0);
            }
        };
        queue.add(personA);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            int currentDistance = distances.get(current);

            for (String relative : graph.get(current)) {
                if (!distances.containsKey(relative)) {
                    if (relative.equals(personB)) {
                        return currentDistance + 1;
                    }
                    distances.put(relative, currentDistance + 1);
                    queue.add(relative);
                }
            }
        }

        return -1;
    }
}
