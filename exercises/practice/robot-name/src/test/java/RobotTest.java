import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class RobotTest {

    private static final String EXPECTED_ROBOT_NAME_PATTERN = "[A-Z]{2}\\d{3}";
    private Robot robot;

    @Before
    public void setUp() {
        robot = new Robot();
    }

    @Test
    public void hasName() {
        assertIsValidName(robot.getName());
    }

    @Ignore("Remove to run test")
    @Test
    public void differentRobotsHaveDifferentNames() {
        assertThat(robot.getName()).isNotEqualTo(new Robot().getName());
    }

    @Ignore("Remove to run test")
    @Test
    public void resetName() {
        final String name = robot.getName();
        robot.reset();
        final String name2 = robot.getName();
        assertThat(name).isNotEqualTo(name2);
        assertIsValidName(name2);
    }
    
    @Ignore("Remove to run test")
    @Test
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
