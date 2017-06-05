
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
        BST<Integer> sut = new BST();
        final int actual = 4;
        sut.insert(actual);
        final BST.Node<Integer> root = sut.getRoot();
        assertNotNull(root);
        final int expected = root.getData();
        assertEquals(expected, actual);
    }

    @Test
    @Ignore
    public void insertsLess() {
        BST<Integer> sut = new BST();
        final int expectedRoot = 4;
        final int expectedLeft = 2;

        sut.insert(expectedRoot);
        sut.insert(expectedLeft);

        final BST.Node<Integer> root = sut.getRoot();
        assertNotNull(root);
        final BST.Node<Integer> left = root.getLeft();
        assertNotNull(left);

        final int actualRoot = root.getData();
        final int actualLeft = left.getData();
        assertEquals(expectedLeft, actualLeft);
        assertEquals(expectedRoot, actualRoot);
    }

    @Test
    @Ignore
    public void insertsSame() {
        BST<Integer> sut = new BST();
        final int expectedRoot = 4;
        final int expectedLeft = 4;

        sut.insert(expectedRoot);
        sut.insert(expectedLeft);

        final BST.Node<Integer> root = sut.getRoot();
        assertNotNull(root);
        final BST.Node<Integer> left = root.getLeft();
        assertNotNull(left);

        final int actualRoot = root.getData();
        final int actualLeft = left.getData();
        assertEquals(expectedLeft, actualLeft);
        assertEquals(expectedRoot, actualRoot);
    }

    @Test
    @Ignore
    public void insertsRight() {
        BST<Integer> sut = new BST();
        final int expectedRoot = 4;
        final int expectedRight = 5;

        sut.insert(expectedRoot);
        sut.insert(expectedRight);

        final BST.Node<Integer> root = sut.getRoot();
        assertNotNull(root);
        final BST.Node<Integer> right = root.getRight();
        assertNotNull(right);

        final int actualRoot = root.getData();
        final int actualRight = right.getData();
        assertEquals(expectedRight, actualRight);
        assertEquals(expectedRoot, actualRoot);
    }

    @Test
    @Ignore
    public void createsComplexTree() {
        BST<Integer> sut = new BST<>();
        List<Integer> expected = Collections.unmodifiableList(
                Arrays.asList(4, 2, 6, 1, 3, 5, 7)
        );

        List<Integer> treeData = Collections.unmodifiableList(
                Arrays.asList(4, 2, 6, 1, 3, 7, 5)
        );
        treeData.forEach(sut::insert);

        List<Integer> actual = sut.getAsLevelOrderList();
        assertEquals(expected, actual);
    }

    @Test
    @Ignore
    public void sortsSingleElement() {
        BST<Integer> sut = new BST<>();
        List<Integer> expected = Collections.unmodifiableList(
                Collections.singletonList(4)
        );

        sut.insert(4);

        List<Integer> actual = sut.getAsSortedList();
        assertEquals(expected, actual);
    }

    @Test
    @Ignore
    public void sortsCollectionOfTwoIfSecondInsertedIsSmallerThanFirst() {
        BST<Integer> sut = new BST<>();
        List<Integer> expected = Collections.unmodifiableList(
                Arrays.asList(2, 4)
        );

        sut.insert(4);
        sut.insert(2);

        List<Integer> actual = sut.getAsSortedList();
        assertEquals(expected, actual);
    }

    @Test
    @Ignore
    public void sortsCollectionOfTwoIfSecondInsertedIsBiggerThanFirst() {
        BST<Integer> sut = new BST<>();
        List<Integer> expected = Collections.unmodifiableList(
                Arrays.asList(4, 5)
        );

        sut.insert(4);
        sut.insert(5);

        List<Integer> actual = sut.getAsSortedList();
        assertEquals(expected, actual);
    }

    @Test
    @Ignore
    public void iteratesOverComplexTree() {
        BST<Integer> sut = new BST<>();
        List<Integer> expected = Collections.unmodifiableList(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7)
        );

        List<Integer> treeData = Collections.unmodifiableList(
                Arrays.asList(4, 2, 1, 3, 6, 7, 5)
        );
        treeData.forEach(sut::insert);

        List<Integer> actual = sut.getAsSortedList();
        assertEquals(expected, actual);
    }
}
