import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ExerciseNameTest {
    @Test
    @DisplayName("The Answer to the Ultimate Question of Life, the Universe, and Everything is 42")
    public void testAnswer() {
        assertThat(new ExerciseName().answer()).isEqualTo(42);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("The Answer to the Ultimate Question of Life, the Universe, and Everything is still 42")
    public void testAnswerAgain() {
        assertThat(new ExerciseName().answer()).isEqualTo(42);
    }
}
