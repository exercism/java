import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class BadgeTests {

    @Test
    @Tag("task:1")
    @DisplayName("The print method of the TimFromMarketing class returns the correct label for the employee")
    public void labelForEmployee() {
        assertThat(Badge.print(17, "Ryder Herbert", "Marketing"))
                .isEqualTo("[17] - Ryder Herbert - MARKETING");
    }

    @Test
    @Tag("task:2")
    @DisplayName("The print method of the TimFromMarketing class returns the correct label for the new employee")
    public void labelForNewEmployee() {
        assertThat(Badge.print(null, "Bogdan Rosario", "Marketing")).isEqualTo("Bogdan Rosario - MARKETING");
    }

    @Test
    @Tag("task:3")
    @DisplayName("The print method of the TimFromMarketing class returns the correct label for the owner")
    public void labelForOwner() {
        assertThat(Badge.print(59, "Julie Sokato", null)).isEqualTo("[59] - Julie Sokato - OWNER");
    }

    @Test
    @Tag("task:4")
    @DisplayName("The print method of the TimFromMarketing class returns the correct label for the new owner")
    public void labelForNewOwner() {
        assertThat(Badge.print(null, "Amare Osei", null)).isEqualTo("Amare Osei - OWNER");
    }
}
