import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RobotTest {

    @Test
    public void robotIsCreatedWithInitialPositionAndOrientation() {
        Orientation initialOrientation = Orientation.NORTH;
        GridPosition initialGridPosition = new GridPosition(0, 0);
        Robot robot = new Robot(initialGridPosition, initialOrientation);

        assertEquals(robot.getOrientation(), initialOrientation);
        assertEquals(robot.getGridPosition(), initialGridPosition);
    }

    @Ignore("Remove to run test")
    @Test
    public void testNegativePositionsAreAllowed() {
        GridPosition initialGridPosition = new GridPosition(-1, -1);
        Orientation initialOrientation = Orientation.SOUTH;
        Robot robot = new Robot(initialGridPosition, initialOrientation);

        assertEquals(robot.getOrientation(), initialOrientation);
        assertEquals(robot.getGridPosition(), initialGridPosition);
    }

    @Ignore("Remove to run test")
    @Test
    public void testTurningRightDoesNotChangePosition() {
        GridPosition initialGridPosition = new GridPosition(0, 0);
        Robot robot = new Robot(initialGridPosition, Orientation.NORTH);

        robot.turnRight();

        assertEquals(robot.getGridPosition(), initialGridPosition);
    }

    @Ignore("Remove to run test")
    @Test
    public void testTurningRightCorrectlyChangesOrientationFromNorthToEast() {
        Robot robot = new Robot(new GridPosition(0, 0), Orientation.NORTH);

        robot.turnRight();

        Orientation expectedOrientation = Orientation.EAST;

        assertEquals(robot.getOrientation(), expectedOrientation);
    }

    @Ignore("Remove to run test")
    @Test
    public void testTurningRightCorrectlyChangesOrientationFromEastToSouth() {
        Robot robot = new Robot(new GridPosition(0, 0), Orientation.EAST);

        robot.turnRight();

        Orientation expectedOrientation = Orientation.SOUTH;

        assertEquals(robot.getOrientation(), expectedOrientation);
    }

    @Ignore("Remove to run test")
    @Test
    public void testTurningRightCorrectlyChangesOrientationFromSouthToWest() {
        Robot robot = new Robot(new GridPosition(0, 0), Orientation.SOUTH);

        robot.turnRight();

        Orientation expectedOrientation = Orientation.WEST;

        assertEquals(robot.getOrientation(), expectedOrientation);
    }

    @Ignore("Remove to run test")
    @Test
    public void testTurningRightCorrectlyChangesOrientationFromWestToNorth() {
        Robot robot = new Robot(new GridPosition(0, 0), Orientation.WEST);

        robot.turnRight();

        Orientation expectedOrientation = Orientation.NORTH;

        assertEquals(robot.getOrientation(), expectedOrientation);
    }

    @Ignore("Remove to run test")
    @Test
    public void testTurningLeftDoesNotChangePosition() {
        GridPosition initialGridPosition = new GridPosition(0, 0);
        Robot robot = new Robot(initialGridPosition, Orientation.NORTH);

        robot.turnLeft();

        assertEquals(robot.getGridPosition(), initialGridPosition);
    }

    @Ignore("Remove to run test")
    @Test
    public void testTurningLeftCorrectlyChangesOrientationFromNorthToWest() {
        Robot robot = new Robot(new GridPosition(0, 0), Orientation.NORTH);

        robot.turnLeft();

        Orientation expectedOrientation = Orientation.WEST;

        assertEquals(robot.getOrientation(), expectedOrientation);
    }

    @Ignore("Remove to run test")
    @Test
    public void testTurningLeftCorrectlyChangesOrientationFromWestToSouth() {
        Robot robot = new Robot(new GridPosition(0, 0), Orientation.WEST);

        robot.turnLeft();

        Orientation expectedOrientation = Orientation.SOUTH;

        assertEquals(robot.getOrientation(), expectedOrientation);
    }

    @Ignore("Remove to run test")
    @Test
    public void testTurningLeftCorrectlyChangesOrientationFromSouthToEast() {
        Robot robot = new Robot(new GridPosition(0, 0), Orientation.SOUTH);

        robot.turnLeft();

        Orientation expectedOrientation = Orientation.EAST;

        assertEquals(robot.getOrientation(), expectedOrientation);
    }

    @Ignore("Remove to run test")
    @Test
    public void testTurningLeftCorrectlyChangesOrientationFromEastToNorth() {
        Robot robot = new Robot(new GridPosition(0, 0), Orientation.EAST);

        robot.turnLeft();

        Orientation expectedOrientation = Orientation.NORTH;

        assertEquals(robot.getOrientation(), expectedOrientation);
    }

    @Ignore("Remove to run test")
    @Test
    public void testAdvancingDoesNotChangeOrientation() {
        Orientation initialOrientation = Orientation.NORTH;
        Robot robot = new Robot(new GridPosition(0, 0), initialOrientation);

        robot.advance();

        assertEquals(robot.getOrientation(), initialOrientation);
    }

    @Ignore("Remove to run test")
    @Test
    public void testAdvancingWhenFacingNorthIncreasesYCoordinateByOne() {
        Robot robot = new Robot(new GridPosition(0, 0), Orientation.NORTH);

        robot.advance();

        GridPosition expectedGridPosition = new GridPosition(0, 1);

        assertEquals(robot.getGridPosition(), expectedGridPosition);
    }

    @Ignore("Remove to run test")
    @Test
    public void testAdvancingWhenFacingSouthDecreasesYCoordinateByOne() {
        Robot robot = new Robot(new GridPosition(0, 0), Orientation.SOUTH);

        robot.advance();

        GridPosition expectedGridPosition = new GridPosition(0, -1);

        assertEquals(robot.getGridPosition(), expectedGridPosition);
    }

    @Ignore("Remove to run test")
    @Test
    public void testAdvancingWhenFacingEastIncreasesXCoordinateByOne() {
        Robot robot = new Robot(new GridPosition(0, 0), Orientation.EAST);

        robot.advance();

        GridPosition expectedGridPosition = new GridPosition(1, 0);

        assertEquals(robot.getGridPosition(), expectedGridPosition);
    }

    @Ignore("Remove to run test")
    @Test
    public void testAdvancingWhenFacingWestDecreasesXCoordinateByOne() {
        Robot robot = new Robot(new GridPosition(0, 0), Orientation.WEST);

        robot.advance();

        GridPosition expectedGridPosition = new GridPosition(-1, 0);

        assertEquals(robot.getGridPosition(), expectedGridPosition);
    }

    @Ignore("Remove to run test")
    @Test
    public void testInstructionsToMoveWestAndNorth() {
        Robot robot = new Robot(new GridPosition(0, 0), Orientation.NORTH);

        robot.simulate("LAAARALA");

        GridPosition expectedGridPosition = new GridPosition(-4, 1);
        Orientation expectedOrientation = Orientation.WEST;

        assertEquals(robot.getGridPosition(), expectedGridPosition);
        assertEquals(robot.getOrientation(), expectedOrientation);
    }

    @Ignore("Remove to run test")
    @Test
    public void testInstructionsToMoveWestAndSouth() {
        Robot robot = new Robot(new GridPosition(2, -7), Orientation.EAST);

        robot.simulate("RRAAAAALA");

        GridPosition expectedGridPosition = new GridPosition(-3, -8);
        Orientation expectedOrientation = Orientation.SOUTH;

        assertEquals(robot.getGridPosition(), expectedGridPosition);
        assertEquals(robot.getOrientation(), expectedOrientation);
    }

    @Ignore("Remove to run test")
    @Test
    public void testInstructionsToMoveEastAndNorth() {
        Robot robot = new Robot(new GridPosition(8, 4), Orientation.SOUTH);

        robot.simulate("LAAARRRALLLL");

        GridPosition expectedGridPosition = new GridPosition(11, 5);
        Orientation expectedOrientation = Orientation.NORTH;

        assertEquals(robot.getGridPosition(), expectedGridPosition);
        assertEquals(robot.getOrientation(), expectedOrientation);
    }

}
