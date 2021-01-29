final class LargestSeriesProductCalculator {

    private final String stringToSearch;

    LargestSeriesProductCalculator(final String stringToSearch) throws IllegalArgumentException {
        this.stringToSearch = stringToSearch;
        validateStringToSearch();
    }

    long calculateLargestProductForSeriesLength(final int seriesLength) throws IllegalArgumentException {
        if (seriesLength < 0) {
            throw new IllegalArgumentException("Series length must be non-negative.");
        } else if (seriesLength == 0) {
            return 1;
        } else if (seriesLength > stringToSearch.length()) {
            throw new IllegalArgumentException(
                    "Series length must be less than or equal to the length of the string to search.");
        } else {
            long result = 0;

            int numberOfSeriesToCheck = stringToSearch.length() - seriesLength + 1;

            for (int startIndex = 0; startIndex < numberOfSeriesToCheck; startIndex++) {
                /*
                 * Note: computing the product of each series fresh each time is not the most efficient solution, but
                 * it's the simplest to reason about.
                 */
                result = Math.max(result, computeProductOfSeries(startIndex, seriesLength));
            }

            return result;
        }
    }

    private void validateStringToSearch() throws IllegalArgumentException {
        if (!stringToSearch.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("String to search may only contain digits.");
        }
    }

    private long computeProductOfSeries(final int startIndex, final int seriesLength) {
        // The multiplicative identity is 1.
        long result = 1;

        final int endIndex = startIndex + seriesLength - 1;

        for (int characterIndex = startIndex; characterIndex <= endIndex; characterIndex++) {
            result = result * Character.getNumericValue(stringToSearch.charAt(characterIndex));
        }

        return result;
    }

}
