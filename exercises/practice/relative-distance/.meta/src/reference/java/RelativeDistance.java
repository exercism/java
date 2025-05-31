import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class RelativeDistance {

    private final Map<String, HashSet<String>> Graph;

    RelativeDistance(Map<String, List<String>>  familyTree) {
        final HashMap<String, HashSet<String>> graph = new HashMap<>();

        for (Map.Entry<String, List<String>> entry : familyTree.entrySet()) {
            String parent = entry.getKey();
            List<String> children = entry.getValue();

            graph.putIfAbsent(parent, new HashSet<>());

            for (String child : children) {
                graph.putIfAbsent(child, new HashSet<>());

                graph.get(parent).add(child);
                graph.get(child).add(parent);

                for (String sibling : children) {
                    if (!sibling.equals(child)) {
                        graph.get(child).add(sibling);
                    }
                }
            }
        }

        Graph = graph;
    }

    int degreeOfSeparation(String personA, String personB) {
        if (!Graph.containsKey(personA) || !Graph.containsKey(personB)) {
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

            for (String relative : Graph.get(current)) {
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
