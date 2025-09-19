import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.assertj.core.api.Assertions.assertThat;

public class ZipperTest {

    Zipper zipper;
    BinaryTree binaryTree;

    @BeforeEach
    @DisplayName("setup")
    public void setup() {
        zipper = new Zipper(1);
        binaryTree = new BinaryTree(zipper);

        zipper.setLeft(new Zipper(2));
        zipper.left.setRight(new Zipper(3));

        zipper.setRight(new Zipper(4));
    }

    @Test
    @DisplayName("test to tree")
    public void testToTree() {
        assertThat(zipper.toTree()).isEqualTo(binaryTree);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("test left right and value")
    public void testLeftRightAndValue() {
        zipper = binaryTree.getRoot();
        assertThat(zipper.left.right.getValue()).isEqualTo(3);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("test dead end")
    public void testDeadEnd() {
        zipper = binaryTree.getRoot();
        assertThat(zipper.left.left).isNull();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("test to tree from deep focus")
    public void testToTreeFromDeepFocus() {
        zipper = binaryTree.getRoot();
        assertThat(zipper.left.right.toTree()).isEqualTo(binaryTree);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("test traversing up from top")
    public void testTraversingUpFromTop() {
        zipper = binaryTree.getRoot();
        assertThat(zipper.up).isNull();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("test left right and up")
    public void testLeftRightAndUp() {
        zipper = binaryTree.getRoot();
        assertThat(zipper.left.up.right.up.left.right.getValue()).isEqualTo(3);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("test ability to return after multiple level descend")
    public void testAbilityToReturnAfterMultipleLevelDescend() {
        zipper = binaryTree.getRoot();
        assertThat(zipper.left.right.up.up.getValue()).isEqualTo(1);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("test set value")
    public void testSetValue() {
        zipper = binaryTree.getRoot();
        zipper = zipper.left;
        zipper.setValue(5);
        String expected = "value: 1, " +
                "left: { " +
                "value: 5, " +
                "left: null, " +
                "right: { " +
                "value: 3, " +
                "left: null, " +
                "right: null } }, " +
                "right: { " +
                "value: 4, " +
                "left: null, " +
                "right: null }";
        assertThat(zipper.toTree().printTree()).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("test set value after traversing up")
    public void testSetValueAfterTraversingUp() {
        zipper = binaryTree.getRoot();
        zipper = zipper.left.right.up;
        zipper.setValue(5);
        String expected = "value: 1, " +
                "left: { " +
                "value: 5, " +
                "left: null, " +
                "right: { " +
                "value: 3, " +
                "left: null, " +
                "right: null } }, " +
                "right: { " +
                "value: 4, " +
                "left: null, " +
                "right: null }";
        assertThat(zipper.toTree().printTree()).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("test set left with leaf")
    public void testSetLeftWithLeaf() {
        zipper = binaryTree.getRoot();
        zipper = zipper.left;
        zipper.setLeft(new Zipper(5));
        String expected = "value: 1, " +
                "left: { " +
                "value: 2, " +
                "left: { " +
                "value: 5, " +
                "left: null, " +
                "right: null }, " +
                "right: { " +
                "value: 3, " +
                "left: null, " +
                "right: null } }, " +
                "right: { " +
                "value: 4, " +
                "left: null, " +
                "right: null }";
        assertThat(zipper.toTree().printTree()).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("test set right with null")
    public void testSetRightWithNull() {
        zipper = binaryTree.getRoot();
        zipper = zipper.left;
        zipper.setRight(null);
        String expected = "value: 1, " +
                "left: { value: 2, left: null, right: null }, " +
                "right: { value: 4, left: null, right: null }";
        assertThat(zipper.toTree().printTree()).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("test set right with subtree")
    public void testSetRightWithSubtree() {
        BinaryTree subtree = new BinaryTree(6);
        subtree.getRoot().setLeft(new Zipper(7));
        subtree.getRoot().setRight(new Zipper(8));
        zipper = binaryTree.getRoot();
        zipper.setRight(subtree.getRoot());
        String expected = "value: 1, " +
                "left: { " +
                "value: 2, " +
                "left: null, " +
                "right: { " +
                "value: 3, " +
                "left: null, " +
                "right: null } }, " +
                "right: { " +
                "value: 6, " +
                "left: { " +
                "value: 7, " +
                "left: null, " +
                "right: null }, " +
                "right: { " +
                "value: 8, " +
                "left: null, " +
                "right: null } }";
        assertThat(zipper.toTree().printTree()).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("test set value on deep focus")
    public void testSetValueOnDeepFocus() {
        zipper = binaryTree.getRoot();
        zipper = zipper.left.right;
        zipper.setValue(5);
        String expected = "value: 1, " +
                "left: { " +
                "value: 2, " +
                "left: null, " +
                "right: { " +
                "value: 5, " +
                "left: null, " +
                "right: null } }, " +
                "right: { " +
                "value: 4, " +
                "left: null, " +
                "right: null }";
        assertThat(zipper.toTree().printTree()).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("different path to same zipper")
    public void differentPathToSameZipper() {
        Zipper zipper1 = binaryTree.getRoot().left.up.right;
        Zipper zipper2 = binaryTree.getRoot().right;
        assertThat(zipper1).isEqualTo(zipper2);
    }
}
