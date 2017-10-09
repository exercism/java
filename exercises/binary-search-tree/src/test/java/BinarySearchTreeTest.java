
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.Before;

public class BinarySearchTreeTest {
    private BinarySearchTree<Integer> binarySearchTree;

    @Before
    public void setUp() {
        binarySearchTree = new BinarySearchTree<>();
    }

    @Test
    public void dataIsRetained() {
        final int actual = 4;
        binarySearchTree.insert(actual);
        final BinarySearchTree.Node<Integer> root = binarySearchTree.getRoot();
        assertNotNull(root);
        final int expected = root.getData();
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void insertsLess() {
        final int expectedRoot = 4;
        final int expectedLeft = 2;

        binarySearchTree.insert(expectedRoot);
        binarySearchTree.insert(expectedLeft);

        final BinarySearchTree.Node<Integer> root = binarySearchTree.getRoot();
        assertNotNull(root);
        final BinarySearchTree.Node<Integer> left = root.getLeft();
        assertNotNull(left);

        final int actualRoot = root.getData();
        final int actualLeft = left.getData();
        assertEquals(expectedLeft, actualLeft);
        assertEquals(expectedRoot, actualRoot);
    }

    @Ignore("Remove to run test")
    @Test
    public void insertsSame() {
        final int expectedRoot = 4;
        final int expectedLeft = 4;

        binarySearchTree.insert(expectedRoot);
        binarySearchTree.insert(expectedLeft);

        final BinarySearchTree.Node<Integer> root = binarySearchTree.getRoot();
        assertNotNull(root);
        final BinarySearchTree.Node<Integer> left = root.getLeft();
        assertNotNull(left);

        final int actualRoot = root.getData();
        final int actualLeft = left.getData();
        assertEquals(expectedLeft, actualLeft);
        assertEquals(expectedRoot, actualRoot);
    }

    @Ignore("Remove to run test")
    @Test
    public void insertsRight() {
        final int expectedRoot = 4;
        final int expectedRight = 5;

        binarySearchTree.insert(expectedRoot);
        binarySearchTree.insert(expectedRight);

        final BinarySearchTree.Node<Integer> root = binarySearchTree.getRoot();
        assertNotNull(root);
        final BinarySearchTree.Node<Integer> right = root.getRight();
        assertNotNull(right);

        final int actualRoot = root.getData();
        final int actualRight = right.getData();
        assertEquals(expectedRight, actualRight);
        assertEquals(expectedRoot, actualRoot);
    }

    @Ignore("Remove to run test")
    @Test
    public void createsComplexTree() {
        List<Integer> expected = Collections.unmodifiableList(
                Arrays.asList(4, 2, 6, 1, 3, 5, 7)
        );

        List<Integer> treeData = Collections.unmodifiableList(
                Arrays.asList(4, 2, 6, 1, 3, 7, 5)
        );
        treeData.forEach(binarySearchTree::insert);

        List<Integer> actual = binarySearchTree.getAsLevelOrderList();
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void sortsSingleElement() {
        List<Integer> expected = Collections.unmodifiableList(
                Collections.singletonList(4)
        );

        binarySearchTree.insert(4);

        List<Integer> actual = binarySearchTree.getAsSortedList();
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void sortsCollectionOfTwoIfSecondInsertedIsSmallerThanFirst() {
        List<Integer> expected = Collections.unmodifiableList(
                Arrays.asList(2, 4)
        );

        binarySearchTree.insert(4);
        binarySearchTree.insert(2);

        List<Integer> actual = binarySearchTree.getAsSortedList();
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void sortsCollectionOfTwoIfSecondInsertedIsBiggerThanFirst() {
        List<Integer> expected = Collections.unmodifiableList(
                Arrays.asList(4, 5)
        );

        binarySearchTree.insert(4);
        binarySearchTree.insert(5);

        List<Integer> actual = binarySearchTree.getAsSortedList();
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void iteratesOverComplexTree() {
        List<Integer> expected = Collections.unmodifiableList(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7)
        );

        List<Integer> treeData = Collections.unmodifiableList(
                Arrays.asList(4, 2, 1, 3, 6, 7, 5)
        );
        treeData.forEach(binarySearchTree::insert);

        List<Integer> actual = binarySearchTree.getAsSortedList();
        assertEquals(expected, actual);
    }
}
