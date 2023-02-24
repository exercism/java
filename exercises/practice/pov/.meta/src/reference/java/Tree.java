import java.util.*;

class Tree {
    private final String label;
    private final List<Tree> children;
    private Map<String, List<String>> graph;

    public Tree(String label) {
        this(label, new ArrayList<>());
    }

    public Tree(String label, List<Tree> children) {
        this.label = label;
        this.children = children;
    }

    public static Tree of(String label) {
        return new Tree(label);
    }

    public static Tree of(String label, List<Tree> children) {
        return new Tree(label, children);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Tree tree = (Tree) o;
        return label.equals(tree.label)
                && children.size() == tree.children.size()
                && children.containsAll(tree.children)
                && tree.children.containsAll(children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, children);
    }

    @Override
    public String toString() {
        return "Tree{" + label +
                ", " + children +
                "}";
    }

    public Tree fromPov(String fromNode) {
        if (this.graph == null) {
            this.graph = new HashMap<>();
            convertToGraph(this.label, this.children);
        }

        if (!this.graph.containsKey(fromNode)) {
            throw new UnsupportedOperationException("Tree could not be reoriented");
        }

        return reconstructTreeFromNode(fromNode, "emptyParentForRoot");
    }

    public List<String> pathTo(String fromNode, String toNode) {
        if (this.graph == null) {
            this.graph = new HashMap<>();
            convertToGraph(this.label, this.children);
        }

        if (!this.graph.containsKey(fromNode) || !this.graph.containsKey(toNode)) {
            throw new UnsupportedOperationException("No path found");
        }

        Tree root = fromPov(fromNode);

        List<String> path = new ArrayList<>();
        generatePath(root, toNode, path);
        return path;
    }

    /**
     * Method to convert tree to graph recursively and populate the private class attribute graph
     *
     * @param label    label String of root node
     * @param children children list of root node
     */
    private void convertToGraph(String label, List<Tree> children) {
        this.graph.putIfAbsent(label, new ArrayList<>());
        if (children != null) {
            for (Tree child : children) {
                this.graph.get(label).add(child.label);
                this.graph.putIfAbsent(child.label, new ArrayList<>());
                this.graph.get(child.label).add(label);
                convertToGraph(child.label, child.children);
            }
        }
    }

    /**
     * Method to create Tree object recursively with node as root.
     * It utilizes the previously populated class attribute graph
     *
     * @param node   string label of current node
     * @param parent string label of parent node of current node
     * @return Tree object of root node
     */
    private Tree reconstructTreeFromNode(String node, String parent) {
        List<Tree> children = new ArrayList<>();
        for (String nbr : this.graph.get(node)) {
            if (!nbr.equals(parent)) {
                children.add(reconstructTreeFromNode(nbr, node));
            }
        }
        return Tree.of(node, children);
    }

    /**
     * Method to traverse the tree and populate the path object
     *
     * @param node   Root node Tree object
     * @param target String label of target node
     * @param path   List of String, to be populated
     * @return boolean value representing if path was found in the subtree
     */
    private boolean generatePath(Tree node, String target, List<String> path) {
        path.add(node.label);
        if (node.label.equals(target)) {
            return true;
        }

        for (Tree child : node.children) {
            if (generatePath(child, target, path)) {
                return true;
            }
        }

        path.remove(path.size() - 1);
        return false;
    }
}
