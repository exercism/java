import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


import java.util.ArrayList;

import static org.junit.Assert.*;

public class BuildTreeTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testEmptyList() throws InvalidRecordsException {
        ArrayList<Record> records = new ArrayList<>();

        TreeNode root = new BuildTree().buildTree(records);
        assertNull(root);
    }

    @Ignore("Remove to run test")
    @Test
    public void testOneRecord() throws InvalidRecordsException {
        ArrayList<Record> records = new ArrayList<>();
        Record record = new Record(0, 0);
        records.add(record);

        TreeNode root = new BuildTree().buildTree(records);
        assertNodeIsLeaf(root, 0);
    }

    @Ignore("Remove to run test")
    @Test
    public void testThreeRecordsInOrder() throws InvalidRecordsException {
        ArrayList<Record> records = new ArrayList<>();
        records.add(new Record(0, 0));
        records.add(new Record(1, 0));
        records.add(new Record(2, 0));

        TreeNode root = new BuildTree().buildTree(records);
        assertNodeIsBranch(root, 0, 2);
        assertNodeIsLeaf(root.children.get(0), 1);
        assertNodeIsLeaf(root.children.get(1), 2);
    }

    @Ignore("Remove to run test")
    @Test
    public void testThreeRecordsInReverseOrder() throws InvalidRecordsException {
        ArrayList<Record> records = new ArrayList<>();
        records.add(new Record(2, 0));
        records.add(new Record(1, 0));
        records.add(new Record(0, 0));

        TreeNode root = new BuildTree().buildTree(records);
        assertNodeIsBranch(root, 0, 2);
        assertNodeIsLeaf(root.children.get(0), 1);
        assertNodeIsLeaf(root.children.get(1), 2);
    }

    @Ignore("Remove to run test")
    @Test
    public void testRecordsWithMoreThanTwoChildren() throws InvalidRecordsException {
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

    @Ignore("Remove to run test")
    @Test
    public void testBinaryTree() throws InvalidRecordsException {
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

    @Ignore("Remove to run test")
    @Test
    public void testUnbalancedTree() throws InvalidRecordsException {
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

    @Ignore("Remove to run test")
    @Test
    public void testRootNodeHasParent() throws InvalidRecordsException {
        expectedException.expect(InvalidRecordsException.class);
        expectedException.expectMessage("Invalid Records");

        ArrayList<Record> records = new ArrayList<>();
        records.add(new Record(0, 1));
        records.add(new Record(1, 0));

        BuildTree test = new BuildTree();
        test.buildTree(records);
    }

    @Ignore("Remove to run test")
    @Test
    public void testNoRootNode() throws InvalidRecordsException {
        expectedException.expect(InvalidRecordsException.class);
        expectedException.expectMessage("Invalid Records");

        ArrayList<Record> records = new ArrayList<>();
        records.add(new Record(1, 0));
        records.add(new Record(2, 0));

        BuildTree test = new BuildTree();
        test.buildTree(records);
    }

    @Ignore("Remove to run test")
    @Test
    public void testNonContinuousRecords() throws InvalidRecordsException {
        expectedException.expect(InvalidRecordsException.class);
        expectedException.expectMessage("Invalid Records");

        ArrayList<Record> records = new ArrayList<>();
        records.add(new Record(2, 0));
        records.add(new Record(4, 2));
        records.add(new Record(1, 0));
        records.add(new Record(0, 0));

        BuildTree test = new BuildTree();
        test.buildTree(records);
    }

    @Ignore("Remove to run test")
    @Test
    public void testCycleInDirectly() throws InvalidRecordsException {
        expectedException.expect(InvalidRecordsException.class);
        expectedException.expectMessage("Invalid Records");

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
