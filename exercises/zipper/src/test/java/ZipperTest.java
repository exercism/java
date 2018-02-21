import org.junit.Ignore;
import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;

public class ZipperTest {

    Zipper zipper;
    BinaryTree binaryTree;

    @Before
    public void setup() {
        zipper = new Zipper(1);
        binaryTree = new BinaryTree(zipper);

        zipper.setLeft(new Zipper(2));
        zipper.left.setRight(new Zipper(3));

        zipper.setRight(new Zipper(4));
    }

    @Test
    public void testToTree() {
        assertEquals(binaryTree, zipper.toTree());
    }

    @Ignore("Remove to run test")
    @Test
    public void testLeftRightAndValue() {
        zipper = binaryTree.getRoot();
        assertEquals(3, zipper.left.right.getValue());
    }

    @Ignore("Remove to run test")
    @Test
    public void testDeadEnd() {
        zipper = binaryTree.getRoot();
        assertEquals(null, zipper.left.left);
    }

    @Ignore("Remove to run test")
    @Test
    public void testToTreeFromDeepFocus() {
        zipper = binaryTree.getRoot();
        assertEquals(binaryTree, zipper.left.right.toTree());
    }

    @Ignore("Remove to run test")
    @Test
    public void testTraversingUpFromTop() {
        zipper = binaryTree.getRoot();
        assertEquals(null, zipper.up);
    }

    @Ignore("Remove to run test")
    @Test
    public void testLeftRightAndUp() {
        zipper = binaryTree.getRoot();
        assertEquals(3, zipper.left.up.right.up.left.right.getValue());
    }

    @Ignore("Remove to run test")
    @Test
    public void testSetValue() {
        zipper = binaryTree.getRoot();
        zipper = zipper.left;
        zipper.setValue(5);
        String expected =
                "value: 1, " +
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
        assertEquals(expected, zipper.toTree().printTree());
    }

    @Ignore("Remove to run test")
    @Test
    public void testSetValueAfterTraversingUp() {
        zipper = binaryTree.getRoot();
        zipper = zipper.left.right.up;
        zipper.setValue(5);
        String expected =
                "value: 1, " +
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
        assertEquals(expected, zipper.toTree().printTree());
    }

    @Ignore("Remove to run test")
    @Test
    public void testSetLeftWithLeaf() {
        zipper = binaryTree.getRoot();
        zipper = zipper.left;
        zipper.setLeft(new Zipper(5));
        String expected =
                "value: 1, " +
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
        assertEquals(expected, zipper.toTree().printTree());
    }

    @Ignore("Remove to run test")
    @Test
    public void testSetRightWithNull() {
        zipper = binaryTree.getRoot();
        zipper = zipper.left;
        zipper.setRight(null);
        String expected =
                "value: 1, " +
                "left: { value: 2, left: null, right: null }, " +
                "right: { value: 4, left: null, right: null }";
        assertEquals(expected, zipper.toTree().printTree());
    }

    @Ignore("Remove to run test")
    @Test
    public void testSetRightWithSubtree() {
        BinaryTree subtree = new BinaryTree(6);
        subtree.getRoot().setLeft(new Zipper(7));
        subtree.getRoot().setRight(new Zipper(8));
        zipper = binaryTree.getRoot();
        zipper.setRight(subtree.getRoot());
        String expected =
                "value: 1, " +
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
        assertEquals(expected, zipper.toTree().printTree());
    }

    @Ignore("Remove to run test")
    @Test
    public void testSetValueOnDeepFocus() {
        zipper = binaryTree.getRoot();
        zipper = zipper.left.right;
        zipper.setValue(5);
        String expected =
                "value: 1, " +
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
        assertEquals(expected, zipper.toTree().printTree());
    }

    @Ignore("Remove to run test")
    @Test
    public void differentPathToSameZipper() {
        Zipper zipper1 = binaryTree.getRoot().left.up.right;
        Zipper zipper2 = binaryTree.getRoot().right;
        assertEquals(zipper2, zipper1);
    }
}
