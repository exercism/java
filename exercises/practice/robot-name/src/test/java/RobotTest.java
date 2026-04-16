import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class RobotTest {

    private static final String EXPECTED_ROBOT_NAME_PATTERN = "[A-Z]{2}\\d{3}";
    private Robot robot;

    @BeforeEach
    public void setUp() {
        robot = new Robot();
    }

    @Test
    @DisplayName("Robot has a valid name")
    public void hasName() {
        assertIsValidName(robot.getName());
    }

    @Test
    @Disabled("Remove to run test")
    @DisplayName("Same robot returns the same name on repeated calls")
    public void sameRobotsHaveSameNames() {
        assertThat(robot.getName()).isEqualTo(robot.getName());
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Different robots have different names")
    public void differentRobotsHaveDifferentNames() {
        assertThat(robot.getName()).isNotEqualTo(new Robot().getName());
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Resetting a robot assigns a new valid name")
    public void resetName() {
        final String name = robot.getName();
        robot.reset();
        final String name2 = robot.getName();
        assertThat(name).isNotEqualTo(name2);
        assertIsValidName(name2);
    }
    
    @Disabled("Remove to run test")
    @Test
    @DisplayName("Robot names are unique")
    public void robotNamesAreUnique() {
        Set<String> robotNames = new HashSet<>();
        int sampleSize = 5000;
        for (int i = 0; i < sampleSize; i++) {
            robotNames.add(new Robot().getName());
        }
        assertThat(robotNames).hasSize(sampleSize);
    }

    private static void assertIsValidName(String name) {
        assertThat(name).matches(EXPECTED_ROBOT_NAME_PATTERN);
    }
}
