import org.junit.Test;
import org.junit.Ignore;
import org.junit.Before;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

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
        assertThat(robot.getName(), not(equalTo(new Robot().getName())));
    }

    @Ignore("Remove to run test")
    @Test
    public void resetName() {
        final String name = robot.getName();
        robot.reset();
        final String name2 = robot.getName();
        assertThat(name, not(equalTo(name2)));
        assertIsValidName(name2);
    }

    private static void assertIsValidName(String name) {
        assertThat(name.matches(EXPECTED_ROBOT_NAME_PATTERN), is(true));
    }
}
