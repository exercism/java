import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class PovTest {

    @Test
    public void testFromPovGivenSingletonTree() {
        Tree tree = Tree.of("x");
        Tree expected = Tree.of("x");
        assertThat(tree.fromPov("x")).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void testFromPovGivenTreeWithParentAndOneSibling() {
        Tree tree = Tree.of("parent",
                List.of(Tree.of("x"),
                        Tree.of("sibling")));

        Tree expected = Tree.of("x",
                List.of(Tree.of("parent",
                        List.of(Tree.of("sibling")))));
        assertThat(tree.fromPov("x")).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void testFromPovGivenTreeWithParentAndManySibling() {
        Tree tree = Tree.of("parent",
                List.of(Tree.of("x"),
                        Tree.of("a"),
                        Tree.of("b"),
                        Tree.of("c")));

        Tree expected = Tree.of("x",
                List.of(Tree.of("parent",
                        List.of(Tree.of("a"),
                                Tree.of("b"),
                                Tree.of("c")))));

        assertThat(tree.fromPov("x")).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void testFromPovGivenTreeWithNewRootDeeplyNested() {
        Tree tree = Tree.of("level-0",
                List.of(Tree.of("level-1",
                        List.of(Tree.of("level-2",
                                List.of(Tree.of("level-3",
                                        List.of(Tree.of("x")))))))));

        Tree expected = Tree.of("x",
                List.of(Tree.of("level-3",
                        List.of(Tree.of("level-2",
                                List.of(Tree.of("level-1",
                                        List.of(Tree.of("level-0")))))))));

        assertThat(tree.fromPov("x")).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void testFromPovGivenMovesChildrenOfNewRootToSameLevelAsFormerParent() {
        Tree tree = Tree.of("parent",
                List.of(Tree.of("x",
                        List.of(Tree.of("kid-0"),
                                Tree.of("kid-1")))));

        Tree expected = Tree.of("x",
                List.of(Tree.of("kid-0"),
                        Tree.of("kid-1"),
                        Tree.of("parent")));

        assertThat(tree.fromPov("x")).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void testFromPovGivenComplexTreeWithCousins() {
        Tree tree = Tree.of("grandparent",
                List.of(Tree.of("parent",
                                List.of(Tree.of("x",
                                                List.of(Tree.of("kid-0"),
                                                        Tree.of("kid-1"))),
                                        Tree.of("sibling-0"),
                                        Tree.of("sibling-1"))),
                        Tree.of("uncle",
                                List.of(Tree.of("cousin-0"),
                                        Tree.of("cousin-1")))));

        Tree expected = Tree.of("x",
                List.of(Tree.of("kid-1"),
                        Tree.of("kid-0"),
                        Tree.of("parent",
                                List.of(Tree.of("sibling-0"),
                                        Tree.of("sibling-1"),
                                        Tree.of("grandparent",
                                                List.of(Tree.of("uncle",
                                                        List.of(Tree.of("cousin-0"),
                                                                Tree.of("cousin-1")))))))));

        assertThat(tree.fromPov("x")).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void testFromPovGivenNonExistentTargetInSingletonTree() {
        Tree tree = Tree.of("x");
        assertThatExceptionOfType(UnsupportedOperationException.class)
                .isThrownBy(() -> tree.fromPov("nonexistent"))
                .withMessage("Tree could not be reoriented");
    }

    @Disabled("Remove to run test")
    @Test
    public void testFromPovGivenNonExistentTargetInLargeTree() {
        Tree tree = Tree.of("parent",
                List.of(Tree.of("x",
                                List.of(Tree.of("kid-0"),
                                        Tree.of("kid-1"))),
                        Tree.of("sibling-0"),
                        Tree.of("sibling-1")));

        assertThatExceptionOfType(UnsupportedOperationException.class)
                .isThrownBy(() -> tree.fromPov("nonexistent"))
                .withMessage("Tree could not be reoriented");
    }

    @Disabled("Remove to run test")
    @Test
    public void testPathToCanFindPathToParent() {
        Tree tree = Tree.of("parent",
                List.of(Tree.of("x"),
                        Tree.of("sibling")));

        List<String> expected = List.of("x", "parent");
        assertThat(tree.pathTo("x", "parent")).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void testPathToCanFindPathToSibling() {
        Tree tree = Tree.of("parent",
                List.of(Tree.of("a"),
                        Tree.of("x"),
                        Tree.of("b"),
                        Tree.of("c")));

        List<String> expected = List.of("x", "parent", "b");
        assertThat(tree.pathTo("x", "b")).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void testPathToCanFindPathToCousin() {
        Tree tree = Tree.of("grandparent",
                List.of(Tree.of("parent",
                                List.of(Tree.of("x",
                                                List.of(Tree.of("kid-0"),
                                                        Tree.of("kid-1"))),
                                        Tree.of("sibling-0"),
                                        Tree.of("sibling-1"))),
                        Tree.of("uncle",
                                List.of(Tree.of("cousin-0"),
                                        Tree.of("cousin-1")))));

        List<String> expected = List.of("x", "parent", "grandparent", "uncle", "cousin-1");
        assertThat(tree.pathTo("x", "cousin-1")).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void testPathToCanFindPathNotEnvolvingRoot() {
        Tree tree = Tree.of("grandparent",
                List.of(Tree.of("parent",
                        List.of(Tree.of("x"),
                                Tree.of("sibling-0"),
                                Tree.of("sibling-1")))));

        List<String> expected = List.of("x", "parent", "sibling-1");
        assertThat(tree.pathTo("x", "sibling-1")).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void testPathToCanFindPathFromNodesOtherThanX() {
        Tree tree = Tree.of("parent",
                List.of(Tree.of("a"),
                        Tree.of("x"),
                        Tree.of("b"),
                        Tree.of("c")));

        List<String> expected = List.of("a", "parent", "c");
        assertThat(tree.pathTo("a", "c")).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void testPathWhenDestinationDoesNotExist() {
        Tree tree = Tree.of("parent",
                List.of(Tree.of("x",
                                List.of(Tree.of("kid-0"),
                                        Tree.of("kid-1"))),
                        Tree.of("sibling-0"),
                        Tree.of("sibling-1")));

        assertThatExceptionOfType(UnsupportedOperationException.class)
                .isThrownBy(() -> tree.pathTo("x", "nonexistent"))
                .withMessage("No path found");
    }

    @Disabled("Remove to run test")
    @Test
    public void testPathWhenSourceDoesNotExist() {
        Tree tree = Tree.of("parent",
                List.of(Tree.of("x",
                                List.of(Tree.of("kid-0"),
                                        Tree.of("kid-1"))),
                        Tree.of("sibling-0"),
                        Tree.of("sibling-1")));

        assertThatExceptionOfType(UnsupportedOperationException.class)
                .isThrownBy(() -> tree.pathTo("nonexistent", "x"))
                .withMessage("No path found");
    }

}
