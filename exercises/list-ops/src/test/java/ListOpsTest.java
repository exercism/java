import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ListOpsTest {

    @Test
    public void testAppendingEmptyLists() {
        assertEquals(
                Collections.emptyList(),
                ListOps.append(Collections.emptyList(), Collections.emptyList())
        );
    }

    @Ignore("Remove to run test")
    @Test
    public void testAppendingListToEmptyList() {
        assertEquals(
                Arrays.asList('1', '2', '3', '4'),
                ListOps.append(Collections.emptyList(), Arrays.asList('1', '2', '3', '4'))
        );
    }

    @Ignore("Remove to run test")
    @Test
    public void testAppendingNonEmptyLists() {
        assertEquals(
                Arrays.asList("1", "2", "2", "3", "4", "5"),
                ListOps.append(Arrays.asList("1", "2"), Arrays.asList("2", "3", "4", "5"))
        );
    }

    @Ignore("Remove to run test")
    @Test
    public void testConcatEmptyList() {
        assertEquals(
                Collections.emptyList(),
                ListOps.concat(Collections.emptyList())
        );
    }

    @Ignore("Remove to run test")
    @Test
    public void testConcatListOfLists() {
        List<List<Character>> listOfLists = Arrays.asList(
                Arrays.asList('1', '2'),
                Collections.singletonList('3'),
                Collections.emptyList(),
                Arrays.asList('4', '5', '6')
        );

        assertEquals(
                Arrays.asList('1', '2', '3', '4', '5', '6'),
                ListOps.concat(listOfLists)
        );
    }

    @Ignore("Remove to run test")
    @Test
    public void testConcatListOfNestedLists() {
        List<List<List<Character>>> listOfNestedLists = Arrays.asList(
                Arrays.asList(
                        Collections.singletonList('1'),
                        Collections.singletonList('2')
                ),
                Collections.singletonList(
                        Collections.singletonList('3')
                ),
                Collections.singletonList(
                        Collections.emptyList()
                ),
                Collections.singletonList(
                        Arrays.asList('4', '5', '6')
                )
        );

        assertEquals(
                Arrays.asList(
                        Collections.singletonList('1'),
                        Collections.singletonList('2'),
                        Collections.singletonList('3'),
                        Collections.emptyList(),
                        Arrays.asList('4', '5', '6')
                ),
                ListOps.concat(listOfNestedLists)
        );
    }

    @Ignore("Remove to run test")
    @Test
    public void testFilteringEmptyList() {
        assertEquals(
                Collections.emptyList(),
                ListOps.filter(Collections.<Integer>emptyList(), integer -> integer % 2 == 1)
        );
    }

    @Ignore("Remove to run test")
    @Test
    public void testFilteringNonEmptyList() {
        assertEquals(
                Arrays.asList(1, 3, 5),
                ListOps.filter(Arrays.asList(1, 2, 3, 5), integer -> integer % 2 == 1)
        );
    }

    @Ignore("Remove to run test")
    @Test
    public void testSizeOfEmptyList() {
        assertEquals(0, ListOps.size(Collections.emptyList()));
    }

    @Ignore("Remove to run test")
    @Test
    public void testSizeOfNonEmptyList() {
        assertEquals(4, ListOps.size(Arrays.asList("one", "two", "three", "four")));
    }

    @Ignore("Remove to run test")
    @Test
    public void testTransformingEmptyList() {
        assertEquals(
                Collections.emptyList(),
                ListOps.map(Collections.<Integer>emptyList(), integer -> integer + 1)
        );
    }

    @Ignore("Remove to run test")
    @Test
    public void testTransformingNonEmptyList() {
        assertEquals(
                Arrays.asList(2, 4, 6, 8),
                ListOps.map(Arrays.asList(1, 3, 5, 7), integer -> integer + 1)
        );
    }

    @Ignore("Remove to run test")
    @Test
    public void testFoldLeftEmptyList() {
        assertEquals(
                new Double(2.0), // Boxing required for method overload disambiguation.
                ListOps.foldLeft(
                    Collections.<Double>emptyList(),
                    2.0,
                    (x, y) -> x * y
                )
        );
    }

    @Ignore("Remove to run test")
    @Test
    public void testFoldLeftDirectionIndependentFunctionAppliedToNonEmptyList() {
        assertEquals(
                new Integer(15), // Boxing required for method overload disambiguation.
                ListOps.foldLeft(
                    Arrays.asList(1, 2, 3, 4),
                    5,
                    (x, y) -> x + y
                )
        );
    }

    @Ignore("Remove to run test")
    @Test
    public void testFoldLeftDirectionDependentFunctionAppliedToNonEmptyList() {
        assertEquals(
                new Integer(0), // Boxing required for method overload disambiguation.
                ListOps.foldLeft(
                    Arrays.asList(2, 5),
                    5,
                    (x, y) -> x / y
                )
        );
    }

    @Ignore("Remove to run test")
    @Test
    public void testFoldRightEmptyList() {
        assertEquals(
                new Double(2.0), // Boxing required for method overload disambiguation.
                ListOps.foldRight(
                    Collections.<Double>emptyList(),
                    2.0,
                    (x, y) -> x * y
                )
        );
    }

    @Ignore("Remove to run test")
    @Test
    public void testFoldRightDirectionIndependentFunctionAppliedToNonEmptyList() {
        assertEquals(
                new Integer(15), // Boxing required for method overload disambiguation.
                ListOps.foldRight(
                    Arrays.asList(1, 2, 3, 4),
                    5,
                    (x, y) -> x + y
                )
        );
    }

    @Ignore("Remove to run test")
    @Test
    public void testFoldRightDirectionDependentFunctionAppliedToNonEmptyList() {
        assertEquals(
                new Integer(2), // Boxing required for method overload disambiguation.
                ListOps.foldRight(
                    Arrays.asList(2, 5),
                    5,
                    (x, y) -> x / y
                )
        );
    }

    @Ignore("Remove to run test")
    @Test
    public void testReversingEmptyList() {
        assertEquals(
                Collections.emptyList(),
                ListOps.reverse(Collections.emptyList())
        );
    }

    @Ignore("Remove to run test")
    @Test
    public void testReversingNonEmptyList() {
        assertEquals(
                Arrays.asList('7', '5', '3', '1'),
                ListOps.reverse(Arrays.asList('1', '3', '5', '7'))
        );
    }

    @Ignore("Remove to run test")
    @Test
    public void testReversingListOfListIsNotFlattened() {
        List<List<Character>> listOfLists = Arrays.asList(
                Arrays.asList('1', '2'),
                Collections.singletonList('3'),
                Collections.emptyList(),
                Arrays.asList('4', '5', '6')
        );

        assertEquals(
                Arrays.asList(
                        Arrays.asList('4', '5', '6'),
                        Collections.emptyList(),
                        Collections.singletonList('3'),
                        Arrays.asList('1', '2')
                ),
                ListOps.reverse(listOfLists)
        );
    }

}
