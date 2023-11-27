import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class BadgeTest {

    @Test
    @Tag("task:1")
    @DisplayName("Printing a badge for an employee")
    public void labelForEmployee() {
        Badge badge = new Badge();
        assertThat(badge.print(17, "Ryder Herbert", "Marketing"))
                .isEqualTo("[17] - Ryder Herbert - MARKETING");
    }

    @Test
    @Tag("task:2")
    @DisplayName("Printing a badge for a new employee")
    public void labelForNewEmployee() {
        Badge badge = new Badge();
        assertThat(badge.print(null, "Bogdan Rosario", "Marketing")).isEqualTo("Bogdan Rosario - MARKETING");
    }

    @Test
    @Tag("task:3")
    @DisplayName("Printing a badge for the owner")
    public void labelForOwner() {
        Badge badge = new Badge();
        assertThat(badge.print(59, "Julie Sokato", null)).isEqualTo("[59] - Julie Sokato - OWNER");
    }

    @Test
    @Tag("task:3")
    @DisplayName("Printing a badge for the owner who is a new employee")
    public void labelForNewOwner() {
        Badge badge = new Badge();
        assertThat(badge.print(null, "Amare Osei", null)).isEqualTo("Amare Osei - OWNER");
    }
}
