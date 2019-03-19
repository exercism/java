import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BuildTreeTest {
    @Test
    public void test_emptyList_shouldReturnNull() throws InvalidRecordsException {
        ArrayList<Record> records = new ArrayList<>();

        TreeNode root = new BuildTree().buildTree(records);
        assertNull(root);
    }

    @Test
    public void test_oneRecord() throws InvalidRecordsException {
        ArrayList<Record> records = new ArrayList<>();
        Record record = new Record(0, 0);
        records.add(record);

        TreeNode root = new BuildTree().buildTree(records);
        assertNodeIsLeaf(root, 0);
    }

    @Test
    public void test_threeRecordsInOrder() throws InvalidRecordsException {
        ArrayList<Record> records = new ArrayList<>();
        records.add(new Record(0, 0));
        records.add(new Record(1, 0));
        records.add(new Record(2, 0));

        TreeNode root = new BuildTree().buildTree(records);
        assertNodeIsBranch(root, 0, 2);
        assertNodeIsLeaf(root.children.get(0), 1);
        assertNodeIsLeaf(root.children.get(1), 2);
    }

    @Test
    public void test_threeRecordsInReverseOrder() throws InvalidRecordsException {
        ArrayList<Record> records = new ArrayList<>();
        records.add(new Record(2, 0));
        records.add(new Record(1, 0));
        records.add(new Record(0, 0));

        TreeNode root = new BuildTree().buildTree(records);
        assertNodeIsBranch(root, 0, 2);
        assertNodeIsLeaf(root.children.get(0), 1);
        assertNodeIsLeaf(root.children.get(1), 2);
    }

    @Test
    public void test_recordsWithMoreThanTwoChildren() throws InvalidRecordsException {
        ArrayList<Record> records = new ArrayList<>();
        records.add(new Record(0, 0));
        records.add(new Record(1, 0));
        records.add(new Record(2, 0));
        records.add(new Record(3, 0));

        TreeNode root = new BuildTree().buildTree(records);
        assertNodeIsBranch(root, 0, 3);
        assertNodeIsLeaf(root.children.get(0), 1);
        assertNodeIsLeaf(root.children.get(1), 2);
        assertNodeIsLeaf(root.children.get(2), 3);

    }

    @Test
    public void test_binaryTree() throws InvalidRecordsException {
        ArrayList<Record> records = new ArrayList<>();
        records.add(new Record(6, 2));
        records.add(new Record(0, 0));
        records.add(new Record(3, 1));
        records.add(new Record(2, 0));
        records.add(new Record(4, 1));
        records.add(new Record(5, 2));
        records.add(new Record(1, 0));

        TreeNode root = new BuildTree().buildTree(records);

        assertNodeIsBranch(root, 0, 2);
        assertNodeIsBranch(root.children.get(0), 1, 2);
        assertNodeIsBranch(root.children.get(1), 2, 2);
        assertNodeIsLeaf(root.children.get(0).children.get(0), 3);
        assertNodeIsLeaf(root.children.get(0).children.get(1), 4);
        assertNodeIsLeaf(root.children.get(1).children.get(0), 5);
        assertNodeIsLeaf(root.children.get(1).children.get(1), 6);
    }

    @Test
    public void test_unbalancedTree() throws InvalidRecordsException {
        ArrayList<Record> records = new ArrayList<>();
        records.add(new Record(0, 0));
        records.add(new Record(1, 0));
        records.add(new Record(2, 0));
        records.add(new Record(3, 1));
        records.add(new Record(4, 1));
        records.add(new Record(5, 1));
        records.add(new Record(6, 2));

        TreeNode root = new BuildTree().buildTree(records);
        assertNodeIsBranch(root, 0, 2);
        assertNodeIsBranch(root.children.get(0), 1, 3);
        assertNodeIsBranch(root.children.get(1), 2, 1);
        assertNodeIsLeaf(root.children.get(0).children.get(0), 3);
        assertNodeIsLeaf(root.children.get(0).children.get(1), 4);
        assertNodeIsLeaf(root.children.get(0).children.get(2), 5);
        assertNodeIsLeaf(root.children.get(1).children.get(0), 6);
    }

    @Test(expected = InvalidRecordsException.class)
    public void test_rootNodeHasParent() throws InvalidRecordsException {
        ArrayList<Record> records = new ArrayList<>();
        records.add(new Record(0, 1));
        records.add(new Record(1, 0));

        BuildTree test = new BuildTree();
        test.buildTree(records);
    }

    @Test(expected = InvalidRecordsException.class)
    public void test_noRootNode() throws InvalidRecordsException {
        ArrayList<Record> records = new ArrayList<>();
        records.add(new Record(1, 0));
        records.add(new Record(2, 0));

        BuildTree test = new BuildTree();
        test.buildTree(records);
    }

    @Test(expected = InvalidRecordsException.class)
    public void test_nonContinuousRecords() throws InvalidRecordsException {
        ArrayList<Record> records = new ArrayList<>();
        records.add(new Record(2, 0));
        records.add(new Record(4, 2));
        records.add(new Record(1, 0));
        records.add(new Record(0, 0));

        BuildTree test = new BuildTree();
        test.buildTree(records);
    }

    @Test(expected = InvalidRecordsException.class)
    public void test_cycleInDirectly() throws InvalidRecordsException {
        ArrayList<Record> records = new ArrayList<>();
        records.add(new Record(5, 2));
        records.add(new Record(3, 2));
        records.add(new Record(2, 6));
        records.add(new Record(4, 1));
        records.add(new Record(1, 0));
        records.add(new Record(0, 0));
        records.add(new Record(6, 3));

        BuildTree test = new BuildTree();
        test.buildTree(records);
    }

    private void assertNodeIsLeaf(TreeNode node, int nodeId) {
        assertEquals(node.getNodeId(), nodeId);
        assertEquals(node.children.size(), 0);
    }

    private void assertNodeIsBranch(TreeNode node, int nodeId, int childrenCount) {
        assertEquals(node.getNodeId(), nodeId);
        assertEquals(node.children.size(), childrenCount);
    }
}
