import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;

import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;

public class BuildTreeTest {

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
        assertEquals(root.getNodeId(), 0);
        assertNodeIsLeaf(root);
    }

    @Ignore("Remove to run test")
    @Test
    public void testThreeRecordsInOrder() throws InvalidRecordsException {
        ArrayList<Record> records = new ArrayList<>();
        records.add(new Record(0, 0));
        records.add(new Record(1, 0));
        records.add(new Record(2, 0));

        TreeNode root = new BuildTree().buildTree(records);
        assertNodeIsBranchWithNNumberOfChildren(root, 2);
        assertNodeIsLeaf(root.getChildren().get(0));
        assertNodeIsLeaf(root.getChildren().get(1));

        assertEquals(root.getNodeId(), 0);
        assertEquals(root.getChildren().get(0).getNodeId(), 1);
        assertEquals(root.getChildren().get(1).getNodeId(), 2);
    }

    @Ignore("Remove to run test")
    @Test
    public void testThreeRecordsInReverseOrder() throws InvalidRecordsException {
        ArrayList<Record> records = new ArrayList<>();
        records.add(new Record(2, 0));
        records.add(new Record(1, 0));
        records.add(new Record(0, 0));

        TreeNode root = new BuildTree().buildTree(records);
        assertNodeIsBranchWithNNumberOfChildren(root, 2);
        assertNodeIsLeaf(root.getChildren().get(0));
        assertNodeIsLeaf(root.getChildren().get(1));

        assertEquals(root.getNodeId(), 0);
        assertEquals(root.getChildren().get(0).getNodeId(), 1);
        assertEquals(root.getChildren().get(1).getNodeId(), 2);
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
        assertNodeIsBranchWithNNumberOfChildren(root, 3);
        assertNodeIsLeaf(root.getChildren().get(0));
        assertNodeIsLeaf(root.getChildren().get(1));
        assertNodeIsLeaf(root.getChildren().get(2));

        assertEquals(root.getNodeId(), 0);
        assertEquals(root.getChildren().get(0).getNodeId(), 1);
        assertEquals(root.getChildren().get(1).getNodeId(), 2);
        assertEquals(root.getChildren().get(2).getNodeId(), 3);

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

        assertNodeIsBranchWithNNumberOfChildren(root, 2);
        assertNodeIsBranchWithNNumberOfChildren(root.getChildren().get(0), 2);
        assertNodeIsBranchWithNNumberOfChildren(root.getChildren().get(1), 2);
        assertNodeIsLeaf(root.getChildren().get(0).getChildren().get(0));
        assertNodeIsLeaf(root.getChildren().get(0).getChildren().get(1));
        assertNodeIsLeaf(root.getChildren().get(1).getChildren().get(0));
        assertNodeIsLeaf(root.getChildren().get(1).getChildren().get(1));

        assertEquals(root.getNodeId(), 0);
        assertEquals(root.getChildren().get(0).getNodeId(), 1);
        assertEquals(root.getChildren().get(1).getNodeId(), 2);
        assertEquals(root.getChildren().get(0).getChildren().get(0).getNodeId(), 3);
        assertEquals(root.getChildren().get(0).getChildren().get(1).getNodeId(), 4);
        assertEquals(root.getChildren().get(1).getChildren().get(0).getNodeId(), 5);
        assertEquals(root.getChildren().get(1).getChildren().get(1).getNodeId(), 6);
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
        assertNodeIsBranchWithNNumberOfChildren(root, 2);
        assertNodeIsBranchWithNNumberOfChildren(root.getChildren().get(0), 3);
        assertNodeIsBranchWithNNumberOfChildren(root.getChildren().get(1), 1);
        assertNodeIsLeaf(root.getChildren().get(0).getChildren().get(0));
        assertNodeIsLeaf(root.getChildren().get(0).getChildren().get(1));
        assertNodeIsLeaf(root.getChildren().get(0).getChildren().get(2));
        assertNodeIsLeaf(root.getChildren().get(1).getChildren().get(0));

        assertEquals(root.getNodeId(), 0);
        assertEquals(root.getChildren().get(0).getNodeId(), 1);
        assertEquals(root.getChildren().get(1).getNodeId(), 2);
        assertEquals(root.getChildren().get(0).getChildren().get(0).getNodeId(), 3);
        assertEquals(root.getChildren().get(0).getChildren().get(1).getNodeId(), 4);
        assertEquals(root.getChildren().get(0).getChildren().get(2).getNodeId(), 5);
        assertEquals(root.getChildren().get(1).getChildren().get(0).getNodeId(), 6);
    }

    @Ignore("Remove to run test")
    @Test
    public void testRootNodeHasParent() {
        ArrayList<Record> records = new ArrayList<>();
        records.add(new Record(0, 1));
        records.add(new Record(1, 0));

        BuildTree test = new BuildTree();

        InvalidRecordsException expected =
            assertThrows(
                InvalidRecordsException.class,
                () -> test.buildTree(records));

        assertThat(expected).hasMessage("Invalid Records");
    }

    @Ignore("Remove to run test")
    @Test
    public void testNoRootNode() {
        ArrayList<Record> records = new ArrayList<>();
        records.add(new Record(1, 0));
        records.add(new Record(2, 0));

        BuildTree test = new BuildTree();

        InvalidRecordsException expected =
            assertThrows(
                InvalidRecordsException.class,
                () -> test.buildTree(records));

        assertThat(expected).hasMessage("Invalid Records");
    }

    @Ignore("Remove to run test")
    @Test
    public void testNonContinuousRecords() {
        ArrayList<Record> records = new ArrayList<>();
        records.add(new Record(2, 0));
        records.add(new Record(4, 2));
        records.add(new Record(1, 0));
        records.add(new Record(0, 0));

        BuildTree test = new BuildTree();

        InvalidRecordsException expected =
            assertThrows(
                InvalidRecordsException.class,
                () -> test.buildTree(records));

        assertThat(expected).hasMessage("Invalid Records");
    }

    @Ignore("Remove to run test")
    @Test
    public void testCycleIndirectly() {
        ArrayList<Record> records = new ArrayList<>();
        records.add(new Record(5, 2));
        records.add(new Record(3, 2));
        records.add(new Record(2, 6));
        records.add(new Record(4, 1));
        records.add(new Record(1, 0));
        records.add(new Record(0, 0));
        records.add(new Record(6, 3));

        BuildTree test = new BuildTree();

        InvalidRecordsException expected =
            assertThrows(
                InvalidRecordsException.class,
                () -> test.buildTree(records));

        assertThat(expected).hasMessage("Invalid Records");
    }

    private void assertNodeIsLeaf(TreeNode node) {
        assertEquals(node.getChildren().size(), 0);
    }

    private void assertNodeIsBranchWithNNumberOfChildren(TreeNode node, int childrenCount) {
        assertEquals(node.getChildren().size(), childrenCount);
    }
}
