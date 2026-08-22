import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class BuildTreeTest {

    @Test
    @DisplayName("empty list")
    public void testEmptyList() throws InvalidRecordsException {
        ArrayList<Record> records = new ArrayList<>();
        TreeNode root = BuildTree.buildTree(records);
        assertThat(root).isNull();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("single record")
    public void testOneRecord() throws InvalidRecordsException {
        ArrayList<Record> records = new ArrayList<>(List.of(
            new Record(0, 0)
        ));
        TreeNode root = BuildTree.buildTree(records);
        assertNotNull(root);
        assertThat(root.getNodeId()).isEqualTo(0);
        assertThat(root.getChildren()).isEmpty();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("three records in order")
    public void testThreeRecordsInOrder() throws InvalidRecordsException {
        ArrayList<Record> records = new ArrayList<>(List.of(
            new Record(0, 0),
            new Record(1, 0),
            new Record(2, 0)
        ));
        TreeNode root = BuildTree.buildTree(records);
        assertNotNull(root);
        assertThat(root.getChildren()).hasSize(2);
        assertThat(root.getChildren().get(0).getNodeId()).isEqualTo(1);
        assertThat(root.getChildren().get(1).getNodeId()).isEqualTo(2);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("three records in reverse order")
    public void testThreeRecordsInReverseOrder() throws InvalidRecordsException {
        ArrayList<Record> records = new ArrayList<>(List.of(
            new Record(2, 0),
            new Record(1, 0),
            new Record(0, 0)
        ));
        TreeNode root = BuildTree.buildTree(records);
        assertNotNull(root);
        assertThat(root.getChildren()).hasSize(2);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("more than two children")
    public void testRecordsWithMoreThanTwoChildren() throws InvalidRecordsException {
        ArrayList<Record> records = new ArrayList<>(List.of(
            new Record(0, 0),
            new Record(1, 0),
            new Record(2, 0),
            new Record(3, 0)
        ));
        TreeNode root = BuildTree.buildTree(records);
        assertNotNull(root);
        assertThat(root.getChildren()).hasSize(3);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("binary tree")
    public void testBinaryTree() throws InvalidRecordsException {
        ArrayList<Record> records = new ArrayList<>(List.of(
            new Record(5, 1),
            new Record(3, 2),
            new Record(2, 0),
            new Record(4, 1),
            new Record(1, 0),
            new Record(0, 0),
            new Record(6, 2)
        ));
        TreeNode root = BuildTree.buildTree(records);
        assertNotNull(root);
        assertThat(root.getNodeId()).isEqualTo(0);
        assertThat(root.getChildren()).hasSize(2);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("unbalanced tree")
    public void testUnbalancedTree() throws InvalidRecordsException {
        ArrayList<Record> records = new ArrayList<>(List.of(
            new Record(5, 2),
            new Record(3, 2),
            new Record(2, 0),
            new Record(4, 1),
            new Record(1, 0),
            new Record(0, 0),
            new Record(6, 2)
        ));
        TreeNode root = BuildTree.buildTree(records);
        assertNotNull(root);
        assertThat(root.getChildren().get(1).getChildren()).hasSize(3);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("one root node and has parent")
    public void testOneRootNodeAndHasParent() {
        ArrayList<Record> records = new ArrayList<>(List.of(new Record(0, 1)));
        assertInvalid(records, "node parent_id should be smaller than its record_id");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("root node has parent")
    public void testRootNodeHasParent() {
        ArrayList<Record> records = new ArrayList<>(List.of(
            new Record(0, 1),
            new Record(1, 0)
        ));
        assertInvalid(records, "node parent_id should be smaller than its record_id");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("no root node")
    public void testNoRootNode() {
        ArrayList<Record> records = new ArrayList<>(List.of(
            new Record(1, 0),
            new Record(2, 0)
        ));
        assertInvalid(records, "record id is invalid or out of order");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("duplicate node")
    public void testDuplicateNode() {
        ArrayList<Record> records = new ArrayList<>(List.of(
            new Record(0, 0),
            new Record(1, 0),
            new Record(1, 0)
        ));
        assertInvalid(records, "record id is invalid or out of order");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("duplicate root")
    public void testDuplicateRoot() {
        ArrayList<Record> records = new ArrayList<>(List.of(
            new Record(0, 0),
            new Record(0, 0)
        ));
        assertInvalid(records, "record id is invalid or out of order");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("non-continuous")
    public void testNonContinuous() {
        ArrayList<Record> records = new ArrayList<>(List.of(
            new Record(2, 0),
            new Record(4, 2),
            new Record(1, 0),
            new Record(0, 0)
        ));
        assertInvalid(records, "record id is invalid or out of order");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("cycle directly")
    public void testCycleDirectly() {
        ArrayList<Record> records = new ArrayList<>(List.of(
            new Record(5, 2),
            new Record(3, 2),
            new Record(2, 2),
            new Record(4, 1),
            new Record(1, 0),
            new Record(0, 0),
            new Record(6, 3)
        ));
        assertInvalid(records, "record id is invalid or out of order");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("cycle indirectly")
    public void testCycleIndirectly() {
        ArrayList<Record> records = new ArrayList<>(List.of(
            new Record(5, 2),
            new Record(3, 2),
            new Record(2, 6),
            new Record(4, 1),
            new Record(1, 0),
            new Record(0, 0),
            new Record(6, 3)
        ));
        assertInvalid(records, "record id is invalid or out of order");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("higher id parent of lower id")
    public void testHigherIdParentOfLowerId() throws InvalidRecordsException {
        ArrayList<Record> records = new ArrayList<>(List.of(
            new Record(0, 0),
            new Record(2, 0),
            new Record(1, 2)
        ));
        assertInvalid(records, "record id is invalid or out of order");
    }

    private void assertInvalid(ArrayList<Record> records, String expectedMessage) {
        assertThatExceptionOfType(InvalidRecordsException.class)
            .isThrownBy(() -> BuildTree.buildTree(records))
            .withMessage(expectedMessage);
    }
}
