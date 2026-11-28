package exercism.testgenerator.model;

import java.io.IOException;

public class CanonicalDataNotFoundException extends IOException {
    private final String exerciseSlug;

    public CanonicalDataNotFoundException(String exerciseSlug, String message) {
        super(message);
        this.exerciseSlug = exerciseSlug;
    }

    public String getExerciseSlug() {
        return exerciseSlug;
    }
}
