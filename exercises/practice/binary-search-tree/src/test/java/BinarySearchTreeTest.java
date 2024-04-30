
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class BinarySearchTreeTest {

    @Test
    public void dataIsRetained() {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();

        int expected = 4;
        binarySearchTree.insert(expected);

        BinarySearchTree.Node<Integer> root = binarySearchTree.getRoot();

        assertThat(root).isNotNull();
        assertThat(root.getData()).isEqualTo(expected);
    }


    @Disabled("Remove to run test")
    @Test
    public void insertsLess() {
        BinarySearchTree<Character> binarySearchTree = new BinarySearchTree<>();

        char expectedRoot = '4';
        char expectedLeft = '2';

        binarySearchTree.insert(expectedRoot);
        binarySearchTree.insert(expectedLeft);

        BinarySearchTree.Node<Character> root = binarySearchTree.getRoot();
        BinarySearchTree.Node<Character> left = root.getLeft();

        assertThat(root).isNotNull();
        assertThat(left).isNotNull();

        assertThat(root.getData()).isEqualTo(expectedRoot);
        assertThat(left.getData()).isEqualTo(expectedLeft);
    }

    @Disabled("Remove to run test")
    @Test
    public void insertsSame() {
        BinarySearchTree<String> binarySearchTree = new BinarySearchTree<>();
        String expectedRoot = "4";
        String expectedLeft = "4";

        binarySearchTree.insert(expectedRoot);
        binarySearchTree.insert(expectedLeft);

        BinarySearchTree.Node<String> root = binarySearchTree.getRoot();
        BinarySearchTree.Node<String> left = root.getLeft();

        assertThat(root).isNotNull();
        assertThat(left).isNotNull();

        assertThat(root.getData()).isEqualTo(expectedRoot);
        assertThat(left.getData()).isEqualTo(expectedLeft);
    }

    @Disabled("Remove to run test")
    @Test
    public void insertsRight() {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        int expectedRoot = 4;
        int expectedRight = 5;

        binarySearchTree.insert(expectedRoot);
        binarySearchTree.insert(expectedRight);

        BinarySearchTree.Node<Integer> root = binarySearchTree.getRoot();
        BinarySearchTree.Node<Integer> right = root.getRight();

        assertThat(root).isNotNull();
        assertThat(right).isNotNull();

        assertThat(root.getData()).isEqualTo(expectedRoot);
        assertThat(right.getData()).isEqualTo(expectedRight);
    }

    @Disabled("Remove to run test")
    @Test
    public void createsComplexTree() {
        BinarySearchTree<Character> binarySearchTree = new BinarySearchTree<>();
        List<Character> expected = List.of('4', '2', '6', '1', '3', '5', '7');

        List<Character> treeData = List.of('4', '2', '6', '1', '3', '5', '7');
        treeData.forEach(binarySearchTree::insert);

        assertThat(binarySearchTree.getAsLevelOrderList()).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void sortsSingleElement() {
        BinarySearchTree<String> binarySearchTree = new BinarySearchTree<>();
        List<String> expected = Collections.singletonList("2");

        binarySearchTree.insert("2");

        assertThat(binarySearchTree.getAsSortedList()).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void sortsCollectionOfTwoIfSecondInsertedIsSmallerThanFirst() {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        List<Integer> expected = List.of(1, 2);

        binarySearchTree.insert(2);
        binarySearchTree.insert(1);

        assertThat(binarySearchTree.getAsSortedList()).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void sortsCollectionOfTwoIfSecondNumberisSameAsFirst() {
        BinarySearchTree<Character> binarySearchTree = new BinarySearchTree<>();
        List<Character> expected = List.of('2', '2');

        binarySearchTree.insert('2');
        binarySearchTree.insert('2');

        assertThat(binarySearchTree.getAsSortedList()).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void sortsCollectionOfTwoIfSecondInsertedIsBiggerThanFirst() {
        BinarySearchTree<Character> binarySearchTree = new BinarySearchTree<>();
        List<Character> expected = List.of('2', '3');

        binarySearchTree.insert('2');
        binarySearchTree.insert('3');

        assertThat(binarySearchTree.getAsSortedList()).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void iteratesOverComplexTree() {
        BinarySearchTree<String> binarySearchTree = new BinarySearchTree<>();
        List<String> expected = List.of("1", "2", "3", "5", "6", "7");

        List<String> treeData = List.of("2", "1", "3", "6", "7", "5");
        treeData.forEach(binarySearchTree::insert);

        assertThat(binarySearchTree.getAsSortedList()).isEqualTo(expected);
    }
}
