import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class TreeTest {
    @Test
    public void inorder() {
        Tree tree = new Tree(
            new Node(
                'C',
                new Node('B', new Node('A'), null),
                new Node('E', new Node('D'), new Node('F'))));

        assertThat(tree.inorder())
            .containsExactly('A', 'B', 'C', 'D', 'E', 'F');
    }

    @Test
    public void preorder() {
        Tree tree = new Tree(
            new Node(
                'A',
                new Node('B', null, new Node('C')),
                new Node('D', new Node('E'), new Node('F'))));

        assertThat(tree.preorder())
            .containsExactly('A', 'B', 'C', 'D', 'E', 'F');
    }

    @Test
    public void postorder() {
        Tree tree = new Tree(
            new Node(
                'F',
                new Node('B', null, new Node('A')),
                new Node('E', new Node('C'), new Node('D'))));

        assertThat(tree.postorder())
            .containsExactly('A', 'B', 'C', 'D', 'E', 'F');
    }
}
