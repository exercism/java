import java.util.List;

final class RelationshipComputer<T> {

    Relationship computeRelationship(final List<T> firstList, final List<T> secondList) {
        if (firstList.equals(secondList)) {
            return Relationship.EQUAL;
        }
        if (checkIfSublist(firstList, secondList)) {
            return Relationship.SUBLIST;
        }
        if (checkIfSublist(secondList, firstList)) {
            return Relationship.SUPERLIST;
        }
        return Relationship.UNEQUAL;
    }

    private boolean checkIfSublist(final List<T> firstList, final List<T> secondList) {
        final int firstListSize = firstList.size();
        final int secondListSize = secondList.size();

        if (firstListSize > secondListSize) {
            return false;
        }
        final int numberOfSublistCandidates = secondListSize - firstListSize + 1;

        for (int startIndex = 0; startIndex < numberOfSublistCandidates; startIndex++) {
            if (secondList.subList(startIndex, startIndex + firstListSize).equals(firstList)) {
                return true;
            }
        }

        return false;
    }

}
