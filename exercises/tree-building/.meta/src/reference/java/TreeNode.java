import java.util.ArrayList;

public class TreeNode {
    private int nodeId;
    public ArrayList<TreeNode> children;

    public TreeNode(int nodeId) {
        this.nodeId = nodeId;
        this.children = new ArrayList<>();
    }

    public int getNodeId() {
        return nodeId;
    }
}
