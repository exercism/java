import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.List;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class SatelliteTest {
    Satellite satellite = new Satellite();

    @Test
    public void emptyTree() {
        List<Character> preorder = List.of();
        List<Character> inorder = List.of();

        Tree tree = satellite.treeFromTraversals(preorder, inorder);

        assertThat(tree.preorder()).containsExactlyElementsOf(preorder);
        assertThat(tree.inorder()).containsExactlyElementsOf(inorder);
        assertThat(tree.postorder()).isEmpty();
    }

    @Disabled("Remove to run test")
    @Test
    public void treeWithOneItem() {
        List<Character> preorder = List.of('a');
        List<Character> inorder = List.of('a');

        Tree tree = satellite.treeFromTraversals(preorder, inorder);

        assertThat(tree.preorder()).containsExactlyElementsOf(preorder);
        assertThat(tree.inorder()).containsExactlyElementsOf(inorder);
        assertThat(tree.postorder()).containsExactly('a');
    }

    @Disabled("Remove to run test")
    @Test
    public void treeWithManyItems() {
        List<Character> preorder = List.of('a', 'i', 'x', 'f', 'r');
        List<Character> inorder = List.of('i', 'a', 'f', 'x', 'r');

        Tree tree = satellite.treeFromTraversals(preorder, inorder);

        assertThat(tree.preorder()).containsExactlyElementsOf(preorder);
        assertThat(tree.inorder()).containsExactlyElementsOf(inorder);
        assertThat(tree.postorder()).containsExactly('i', 'f', 'r', 'x', 'a');
    }

    @Disabled("Remove to run test")
    @Test
    public void rejectTraversalsOfDifferentLengths() {
        List<Character> preorder = List.of('a', 'b');
        List<Character> inorder = List.of('b', 'a', 'r');

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> satellite.treeFromTraversals(preorder, inorder))
                .withMessage("traversals must have the same length");

    }

    @Disabled("Remove to run test")
    @Test
    public void rejectInconsistentTraversalsOfSameLength() {
        List<Character> preorder = List.of('x', 'y', 'z');
        List<Character> inorder = List.of('a', 'b', 'c');

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> satellite.treeFromTraversals(preorder, inorder))
                .withMessage("traversals must have the same elements");
    }

    @Disabled("Remove to run test")
    @Test
    public void rejectTraversalsWithRepeatedItems() {
        List<Character> preorder = List.of('a', 'b', 'a');
        List<Character> inorder = List.of('b', 'a', 'a');

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> satellite.treeFromTraversals(preorder, inorder))
                .withMessage("traversals must contain unique items");
    }
}
