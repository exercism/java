import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;

public class FlattenerTest {

    private Flattener flattener;

    @BeforeEach
    public void setUp() {
        flattener = new Flattener();
    }

    @Test
    @DisplayName("empty")
    public void testEmpty() {
        assertThat(flattener.flatten(emptyList()))
                .isEmpty();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("no nesting")
    public void testFlatListIsPreserved() {
        assertThat(flattener.flatten(asList(0, '1', "two")))
                .containsExactly(0, '1', "two");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("flattens a nested array")
    public void testNestedList() {
        assertThat(flattener.flatten(singletonList(emptyList())))
                .isEmpty();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("flattens array with just integers present")
    public void testASingleLevelOfNestingWithNoNulls() {
        assertThat(flattener.flatten(asList(1, asList('2', 3, 4, 5, "six", "7"), 8)))
                .containsExactly(1, '2', 3, 4, 5, "six", "7", 8);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("5 level nesting")
    public void testFiveLevelsOfNestingWithNoNulls() {
        assertThat(flattener.flatten(
                asList(0,
                        '2',
                        asList(asList(2, "three"),
                                '8',
                                100,
                                "four",
                                singletonList(singletonList(singletonList(50)))), "-2")))
                .containsExactly(0, '2', 2, "three", '8', 100, "four", 50, "-2");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("6 level nesting")
    public void testSixLevelsOfNestingWithNoNulls() {
        assertThat(flattener.flatten(
                asList("one",
                        asList('2',
                                singletonList(singletonList(3)),
                                asList('4',
                                        singletonList(singletonList(5))), "six", 7), "8")))
                .containsExactly("one", '2', 3, '4', 5, "six", 7, "8");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("null values are omitted from the final result")
    public void testNullValuesAreOmitted() {
        assertThat(flattener.flatten(asList("1", "two", null)))
                .containsExactly("1", "two");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("consecutive null values at the front of the list are omitted from the final result")
    public void testConsecutiveNullValuesAtFrontOfListAreOmitted() {
        assertThat(flattener.flatten(asList(null, null, 3)))
                .containsExactly(3);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("consecutive null values in the middle of the list are omitted from the final result")
    public void testConsecutiveNullValuesInMiddleOfListAreOmitted() {
        assertThat(flattener.flatten(asList(1, null, null, "4")))
                .containsExactly(1, "4");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("6 level nest list with null values")
    public void testSixLevelsOfNestingWithNulls() {
        assertThat(flattener.flatten(
                asList("0",
                        2,
                        asList(asList("two", '3'),
                                "8",
                                singletonList(singletonList("one hundred")),
                                null,
                                singletonList(singletonList(null))),
                        "negative two")))
                .containsExactly("0", 2, "two", '3', "8", "one hundred", "negative two");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("all values in nested list are null")
    public void testNestedListsFullOfNullsOnly() {
        assertThat(flattener.flatten(
                asList(null,
                        singletonList(singletonList(singletonList(null))),
                        null,
                        null,
                        asList(asList(null, null), null), null)))
                .isEmpty();
    }

}
