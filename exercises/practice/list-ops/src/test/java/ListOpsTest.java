import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ListOpsTest {

    @Test
    public void testAppendingEmptyLists() {
        assertThat(ListOps.append(List.of(), List.of())).isEmpty();
    }

    @Disabled("Remove to run test")
    @Test
    public void testAppendingListToEmptyList() {
        assertThat(ListOps.append(List.of(), List.of('1', '2', '3', '4')))
                .containsExactly('1', '2', '3', '4');
    }

    @Disabled("Remove to run test")
    @Test
    public void testAppendingEmptyListToList() {
        assertThat(ListOps.append(List.of('1', '2', '3', '4'), List.of()))
                .containsExactly('1', '2', '3', '4');
    }

    @Disabled("Remove to run test")
    @Test
    public void testAppendingNonEmptyLists() {
        assertThat(ListOps.append(List.of("1", "2"), List.of("2", "3", "4", "5")))
                .containsExactly("1", "2", "2", "3", "4", "5");
    }

    @Disabled("Remove to run test")
    @Test
    public void testConcatEmptyList() {
        assertThat(ListOps.concat(List.of())).isEmpty();
    }

    @Disabled("Remove to run test")
    @Test
    public void testConcatListOfLists() {
        List<List<Character>> listOfLists = List.of(
                List.of('1', '2'),
                List.of('3'),
                List.of(),
                List.of('4', '5', '6')
        );

        assertThat(ListOps.concat(listOfLists)).containsExactly('1', '2', '3', '4', '5', '6');
    }

    @Disabled("Remove to run test")
    @Test
    public void testConcatListOfNestedLists() {
        List<List<List<Character>>> listOfNestedLists = List.of(
                List.of(
                        List.of('1'),
                        List.of('2')
                ),
                List.of(
                        List.of('3')
                ),
                List.of(
                        List.of()
                ),
                List.of(
                        List.of('4', '5', '6')
                )
        );

        assertThat(ListOps.concat(listOfNestedLists))
                .containsExactly(
                        List.of('1'),
                        List.of('2'),
                        List.of('3'),
                        List.of(),
                        List.of('4', '5', '6'));
    }

    @Disabled("Remove to run test")
    @Test
    public void testFilteringEmptyList() {
        assertThat(ListOps.filter(List.<Integer>of(), integer -> integer % 2 == 1))
                .isEmpty();
    }

    @Disabled("Remove to run test")
    @Test
    public void testFilteringNonEmptyList() {
        assertThat(ListOps.filter(List.of(1, 2, 3, 5), integer -> integer % 2 == 1))
                .containsExactly(1, 3, 5);
    }

    @Disabled("Remove to run test")
    @Test
    public void testSizeOfEmptyList() {
        assertThat(ListOps.size(List.of())).isEqualTo(0);
    }

    @Disabled("Remove to run test")
    @Test
    public void testSizeOfNonEmptyList() {
        assertThat(ListOps.size(List.of("one", "two", "three", "four"))).isEqualTo(4);
    }

    @Disabled("Remove to run test")
    @Test
    public void testTransformingEmptyList() {
        assertThat(ListOps.map(List.<Integer>of(), integer -> integer + 1)).isEmpty();
    }

    @Disabled("Remove to run test")
    @Test
    public void testTransformingNonEmptyList() {
        assertThat(ListOps.map(List.of(1, 3, 5, 7), integer -> integer + 1))
                .containsExactly(2, 4, 6, 8);
    }

    @Disabled("Remove to run test")
    @Test
    public void testFoldLeftEmptyList() {
        assertThat(
                ListOps.foldLeft(
                        List.<Double>of(),
                        2.0,
                        (acc, el) -> el * acc))
                .isEqualTo(2.0);
    }

    @Disabled("Remove to run test")
    @Test
    public void testFoldLeftDirectionIndependentFunctionAppliedToNonEmptyList() {
        assertThat(
                ListOps.foldLeft(
                        List.of(1, 2, 3, 4),
                        5,
                        (acc, el) -> el + acc))
                .isEqualTo(15);
    }

    @Disabled("Remove to run test")
    @Test
    public void testFoldLeftDirectionDependentFunctionAppliedToNonEmptyList() {
        assertThat(
                ListOps.foldLeft(
                        List.of(1.0, 2.0, 3.0, 4.0),
                        24.0,
                        (acc, el) -> el / acc))
                .isEqualTo(64.0);
    }

    @Disabled("Remove to run test")
    @Test
    public void testFoldRightEmptyList() {
        assertThat(
                ListOps.foldRight(
                        List.<Double>of(),
                        2.0,
                        (el, acc) -> acc * el))
                .isEqualTo(2.0);
    }

    @Disabled("Remove to run test")
    @Test
    public void testFoldRightDirectionIndependentFunctionAppliedToNonEmptyList() {
        assertThat(
                ListOps.foldRight(
                        List.of(1, 2, 3, 4),
                        5,
                        (el, acc) -> acc + el))
                .isEqualTo(15);
    }

    @Disabled("Remove to run test")
    @Test
    public void testFoldRightDirectionDependentFunctionAppliedToNonEmptyList() {
        assertThat(
                ListOps.foldRight(
                        List.of(1.0, 2.0, 3.0, 4.0),
                        24.0,
                        (el, acc) -> el / acc))
                .isEqualTo(9.0);
    }

    @Disabled("Remove to run test")
    @Test
    public void testReversingEmptyList() {
        assertThat(ListOps.reverse(List.of())).isEmpty();
    }

    @Disabled("Remove to run test")
    @Test
    public void testReversingNonEmptyList() {
        assertThat(ListOps.reverse(List.of('1', '3', '5', '7')))
                .containsExactly('7', '5', '3', '1');
    }

    @Disabled("Remove to run test")
    @Test
    public void testReversingListOfListIsNotFlattened() {
        List<List<Character>> listOfLists = List.of(
                List.of('1', '2'),
                List.of('3'),
                List.of(),
                List.of('4', '5', '6')
        );

        assertThat(ListOps.reverse(listOfLists))
                .containsExactly(
                        List.of('4', '5', '6'),
                        List.of(),
                        List.of('3'),
                        List.of('1', '2'));
    }

}
