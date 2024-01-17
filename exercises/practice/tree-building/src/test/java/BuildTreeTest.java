import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class BuildTreeTest {

    @Test
    public void testEmptyList() throws InvalidRecordsException {
        ArrayList<Record> records = new ArrayList<>();

        TreeNode root = new BuildTree().buildTree(records);
        assertThat(root).isNull();
    }

    @Disabled("Remove to run test")
    @Test
    public void testOneRecord() throws InvalidRecordsException {
        ArrayList<Record> records = new ArrayList<>();
        Record record = new Record(0, 0);
        records.add(record);

        TreeNode root = new BuildTree().buildTree(records);
        assertThat(root.getNodeId()).isEqualTo(0);
        assertNodeIsLeaf(root);
    }

    @Disabled("Remove to run test")
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

        assertThat(root.getNodeId()).isEqualTo(0);
        assertThat(root.getChildren().get(0).getNodeId()).isEqualTo(1);
        assertThat(root.getChildren().get(1).getNodeId()).isEqualTo(2);
    }

    @Disabled("Remove to run test")
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

        assertThat(root.getNodeId()).isEqualTo(0);
        assertThat(root.getChildren().get(0).getNodeId()).isEqualTo(1);
        assertThat(root.getChildren().get(1).getNodeId()).isEqualTo(2);
    }

    @Disabled("Remove to run test")
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

        assertThat(root.getNodeId()).isEqualTo(0);
        assertThat(root.getChildren().get(0).getNodeId()).isEqualTo(1);
        assertThat(root.getChildren().get(1).getNodeId()).isEqualTo(2);
        assertThat(root.getChildren().get(2).getNodeId()).isEqualTo(3);

    }

    @Disabled("Remove to run test")
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

        assertThat(root.getNodeId()).isEqualTo(0);
        assertThat(root.getChildren().get(0).getNodeId()).isEqualTo(1);
        assertThat(root.getChildren().get(1).getNodeId()).isEqualTo(2);
        assertThat(root.getChildren().get(0).getChildren().get(0).getNodeId()).isEqualTo(3);
        assertThat(root.getChildren().get(0).getChildren().get(1).getNodeId()).isEqualTo(4);
        assertThat(root.getChildren().get(1).getChildren().get(0).getNodeId()).isEqualTo(5);
        assertThat(root.getChildren().get(1).getChildren().get(1).getNodeId()).isEqualTo(6);
    }

    @Disabled("Remove to run test")
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

        assertThat(root.getNodeId()).isEqualTo(0);
        assertThat(root.getChildren().get(0).getNodeId()).isEqualTo(1);
        assertThat(root.getChildren().get(1).getNodeId()).isEqualTo(2);
        assertThat(root.getChildren().get(0).getChildren().get(0).getNodeId()).isEqualTo(3);
        assertThat(root.getChildren().get(0).getChildren().get(1).getNodeId()).isEqualTo(4);
        assertThat(root.getChildren().get(0).getChildren().get(2).getNodeId()).isEqualTo(5);
        assertThat(root.getChildren().get(1).getChildren().get(0).getNodeId()).isEqualTo(6);
    }

    @Disabled("Remove to run test")
    @Test
    public void testRootNodeHasParent() {
        ArrayList<Record> records = new ArrayList<>();
        records.add(new Record(0, 1));
        records.add(new Record(1, 0));

        BuildTree test = new BuildTree();

        assertThatExceptionOfType(InvalidRecordsException.class)
                .isThrownBy(() -> test.buildTree(records))
                .withMessage("Invalid Records");
    }

    @Disabled("Remove to run test")
    @Test
    public void testNoRootNode() {
        ArrayList<Record> records = new ArrayList<>();
        records.add(new Record(1, 0));
        records.add(new Record(2, 0));

        BuildTree test = new BuildTree();

        assertThatExceptionOfType(InvalidRecordsException.class)
                .isThrownBy(() -> test.buildTree(records))
                .withMessage("Invalid Records");
    }

    @Disabled("Remove to run test")
    @Test
    public void testNonContinuousRecords() {
        ArrayList<Record> records = new ArrayList<>();
        records.add(new Record(2, 0));
        records.add(new Record(4, 2));
        records.add(new Record(1, 0));
        records.add(new Record(0, 0));

        BuildTree test = new BuildTree();

        assertThatExceptionOfType(InvalidRecordsException.class)
                .isThrownBy(() -> test.buildTree(records))
                .withMessage("Invalid Records");
    }

    @Disabled("Remove to run test")
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

        assertThatExceptionOfType(InvalidRecordsException.class)
                .isThrownBy(() -> test.buildTree(records))
                .withMessage("Invalid Records");
    }

    private void assertNodeIsLeaf(TreeNode node) {
        assertThat(node.getChildren().size()).isEqualTo(0);
    }

    private void assertNodeIsBranchWithNNumberOfChildren(TreeNode node, int childrenCount) {
        assertThat(node.getChildren().size()).isEqualTo(childrenCount);
    }
}
