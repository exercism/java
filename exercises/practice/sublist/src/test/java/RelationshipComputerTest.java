import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;

public class RelationshipComputerTest {

    @Test
    @DisplayName("empty lists")
    public void testThatTwoEmptyListsAreConsideredEqual() {
        Relationship relationship = new RelationshipComputer<>().computeRelationship(
                emptyList(),
                emptyList());

        assertThat(relationship).isEqualTo(Relationship.EQUAL);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("empty list within non empty list")
    public void testEmptyListIsSublistOfNonEmptyList() {
        Relationship relationship = new RelationshipComputer<>().computeRelationship(
                emptyList(),
                asList(1, 2, 3));

        assertThat(relationship).isEqualTo(Relationship.SUBLIST);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("non empty list contains empty list")
    public void testNonEmptyListIsSuperlistOfEmptyList() {
        Relationship relationship = new RelationshipComputer<>().computeRelationship(
                asList('1', '2', '3'),
                emptyList());

        assertThat(relationship).isEqualTo(Relationship.SUPERLIST);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("list equals itself")
    public void testListIsEqualToItself() {
        List<String> anyList = asList("1", "2", "3");

        Relationship relationship = new RelationshipComputer<String>().computeRelationship(
                anyList,
                anyList);

        assertThat(relationship).isEqualTo(Relationship.EQUAL);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("different lists")
    public void testDifferentListsOfTheSameLengthAreUnequal() {
        Relationship relationship = new RelationshipComputer<>().computeRelationship(
                asList(1, 2, 3),
                asList(2, 3, 4));

        assertThat(relationship).isEqualTo(Relationship.UNEQUAL);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("false start")
    public void testSublistCheckDoesNotAbortAfterFalseStart() {
        Relationship relationship = new RelationshipComputer<>().computeRelationship(
                asList('1', '2', '5'),
                asList('0', '1', '2', '3', '1', '2', '5', '6'));

        assertThat(relationship).isEqualTo(Relationship.SUBLIST);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("consecutive")
    public void testSublistCheckHandlesExtraneousRepeatsOfFirstEntry() {
        Relationship relationship = new RelationshipComputer<>().computeRelationship(
                asList("1", "1", "2"),
                asList("0", "1", "1", "1", "2", "1", "2"));

        assertThat(relationship).isEqualTo(Relationship.SUBLIST);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("sublist at start")
    public void testSublistAtStart() {
        Relationship relationship = new RelationshipComputer<>().computeRelationship(
                asList(0, 1, 2),
                asList(0, 1, 2, 3, 4, 5));

        assertThat(relationship).isEqualTo(Relationship.SUBLIST);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("sublist in middle")
    public void testSublistInMiddle() {
        Relationship relationship = new RelationshipComputer<>().computeRelationship(
                asList('2', '3', '4'),
                asList('0', '1', '2', '3', '4', '5'));

        assertThat(relationship).isEqualTo(Relationship.SUBLIST);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("sublist at end")
    public void testSublistAtEnd() {
        Relationship relationship = new RelationshipComputer<>().computeRelationship(
                asList("3", "4", "5"),
                asList("0", "1", "2", "3", "4", "5"));

        assertThat(relationship).isEqualTo(Relationship.SUBLIST);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("at start of superlist")
    public void testAtStartOfSuperlist() {
        Relationship relationship = new RelationshipComputer<>().computeRelationship(
                asList(0, 1, 2, 3, 4, 5),
                asList(0, 1, 2));

        assertThat(relationship).isEqualTo(Relationship.SUPERLIST);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("in middle of superlist")
    public void testInMiddleOfSuperlist() {
        Relationship relationship = new RelationshipComputer<>().computeRelationship(
                asList('0', '1', '2', '3', '4', '5'),
                asList('2', '3'));

        assertThat(relationship).isEqualTo(Relationship.SUPERLIST);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("at end of superlist")
    public void testAtEndOfSuperlist() {
        Relationship relationship = new RelationshipComputer<>().computeRelationship(
                asList("0", "1", "2", "3", "4", "5"),
                asList("3", "4", "5"));

        assertThat(relationship).isEqualTo(Relationship.SUPERLIST);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("first list missing element from second list")
    public void testFirstListMissingElementFromSecondList() {
        Relationship relationship = new RelationshipComputer<>().computeRelationship(
                asList(1, 3),
                asList(1, 2, 3));

        assertThat(relationship).isEqualTo(Relationship.UNEQUAL);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("second list missing element from first list")
    public void testSecondListMissingElementFromFirstList() {
        Relationship relationship = new RelationshipComputer<>().computeRelationship(
                asList('1', '2', '3'),
                asList('1', '3'));

        assertThat(relationship).isEqualTo(Relationship.UNEQUAL);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("order matters to a list")
    public void testThatListOrderingIsAccountedFor() {
        Relationship relationship = new RelationshipComputer<>().computeRelationship(
                asList("1", "2", "3"),
                asList("3", "2", "1"));

        assertThat(relationship).isEqualTo(Relationship.UNEQUAL);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("same digits but different numbers")
    public void testThatListsWithSameDigitsButDifferentNumbersAreUnequal() {
        Relationship relationship = new RelationshipComputer<>().computeRelationship(
                asList(1, 0, 1),
                asList(10, 1));

        assertThat(relationship).isEqualTo(Relationship.UNEQUAL);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("first list missing additional digits from second list")
    public void testFirstListMissingAdditionalDigitsFromSecondList() {
        Relationship relationship = new RelationshipComputer<>().computeRelationship(
                asList(1, 2),
                asList(1, 22));

        assertThat(relationship).isEqualTo(Relationship.UNEQUAL);
    }
}
