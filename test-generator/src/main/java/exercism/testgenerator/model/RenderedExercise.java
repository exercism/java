package exercism.testgenerator.model;

import java.util.List;

public record RenderedExercise(
    String exerciseSlug,
    String testClassName,
    String solutionClassName,
    boolean hasExceptions,
    boolean hasFloatingPoint,
    boolean hasList,
    boolean hasMap,
    boolean hasSet,
    boolean hasDisabled,
    List<RenderedTestCase> testCases
) {
    public boolean hasCollections() {
        return hasList || hasMap || hasSet;
    }
}
