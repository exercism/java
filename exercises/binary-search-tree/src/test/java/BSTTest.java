
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Ignore;
import org.junit.Test;

public class BSTTest {

    @Test
    public void dataIsRetained() {
        BST<Integer> bst = new BST();
        final int actual = 4;
        bst.insert(actual);
        final BST.Node<Integer> root = bst.getRoot();
        assertNotNull(root);
        final int expected = root.getData();
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void insertsLess() {
        BST<Integer> bst = new BST();
        final int expectedRoot = 4;
        final int expectedLeft = 2;

        bst.insert(expectedRoot);
        bst.insert(expectedLeft);

        final BST.Node<Integer> root = bst.getRoot();
        assertNotNull(root);
        final BST.Node<Integer> left = root.getLeft();
        assertNotNull(left);

        final int actualRoot = root.getData();
        final int actualLeft = left.getData();
        assertEquals(expectedLeft, actualLeft);
        assertEquals(expectedRoot, actualRoot);
    }

    @Ignore("Remove to run test")
    @Test
    public void insertsSame() {
        BST<Integer> bst = new BST();
        final int expectedRoot = 4;
        final int expectedLeft = 4;

        bst.insert(expectedRoot);
        bst.insert(expectedLeft);

        final BST.Node<Integer> root = bst.getRoot();
        assertNotNull(root);
        final BST.Node<Integer> left = root.getLeft();
        assertNotNull(left);

        final int actualRoot = root.getData();
        final int actualLeft = left.getData();
        assertEquals(expectedLeft, actualLeft);
        assertEquals(expectedRoot, actualRoot);
    }

    @Ignore("Remove to run test")
    @Test
    public void insertsRight() {
        BST<Integer> bst = new BST();
        final int expectedRoot = 4;
        final int expectedRight = 5;

        bst.insert(expectedRoot);
        bst.insert(expectedRight);

        final BST.Node<Integer> root = bst.getRoot();
        assertNotNull(root);
        final BST.Node<Integer> right = root.getRight();
        assertNotNull(right);

        final int actualRoot = root.getData();
        final int actualRight = right.getData();
        assertEquals(expectedRight, actualRight);
        assertEquals(expectedRoot, actualRoot);
    }

    @Ignore("Remove to run test")
    @Test
    public void createsComplexTree() {
        BST<Integer> bst = new BST<>();
        List<Integer> expected = Collections.unmodifiableList(
                Arrays.asList(4, 2, 6, 1, 3, 5, 7)
        );

        List<Integer> treeData = Collections.unmodifiableList(
                Arrays.asList(4, 2, 6, 1, 3, 7, 5)
        );
        treeData.forEach(bst::insert);

        List<Integer> actual = bst.getAsLevelOrderList();
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void sortsSingleElement() {
        BST<Integer> bst = new BST<>();
        List<Integer> expected = Collections.unmodifiableList(
                Collections.singletonList(4)
        );

        bst.insert(4);

        List<Integer> actual = bst.getAsSortedList();
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void sortsCollectionOfTwoIfSecondInsertedIsSmallerThanFirst() {
        BST<Integer> bst = new BST<>();
        List<Integer> expected = Collections.unmodifiableList(
                Arrays.asList(2, 4)
        );

        bst.insert(4);
        bst.insert(2);

        List<Integer> actual = bst.getAsSortedList();
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void sortsCollectionOfTwoIfSecondInsertedIsBiggerThanFirst() {
        BST<Integer> bst = new BST<>();
        List<Integer> expected = Collections.unmodifiableList(
                Arrays.asList(4, 5)
        );

        bst.insert(4);
        bst.insert(5);

        List<Integer> actual = bst.getAsSortedList();
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void iteratesOverComplexTree() {
        BST<Integer> bst = new BST<>();
        List<Integer> expected = Collections.unmodifiableList(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7)
        );

        List<Integer> treeData = Collections.unmodifiableList(
                Arrays.asList(4, 2, 1, 3, 6, 7, 5)
        );
        treeData.forEach(bst::insert);

        List<Integer> actual = bst.getAsSortedList();
        assertEquals(expected, actual);
    }
}
