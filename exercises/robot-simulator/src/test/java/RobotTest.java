import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public final class RobotTest {

    @Test
    public void testRobotIsCreatedWithCorrectInitialPosition() {
        final GridPosition initialGridPosition = new GridPosition(0, 0);
        final Robot robot = new Robot(initialGridPosition, Orientation.NORTH);

        assertTrue(robot.getGridPosition().equals(initialGridPosition));
    }

    @Ignore
    @Test
    public void testRobotIsCreatedWithCorrectInitialOrientation() {
        final Orientation initialOrientation = Orientation.NORTH;
        final Robot robot = new Robot(new GridPosition(0, 0), initialOrientation);

        assertTrue(robot.getOrientation().equals(initialOrientation));
    }

    @Ignore
    @Test
    public void testTurningRightDoesNotChangePosition() {
        final GridPosition initialGridPosition = new GridPosition(0, 0);
        final Robot robot = new Robot(initialGridPosition, Orientation.NORTH);

        robot.turnRight();

        assertTrue(robot.getGridPosition().equals(initialGridPosition));
    }

    @Ignore
    @Test
    public void testTurningRightCorrectlyChangesOrientationFromNorthToEast() {
        final Robot robot = new Robot(new GridPosition(0, 0), Orientation.NORTH);

        robot.turnRight();

        final Orientation expectedOrientation = Orientation.EAST;

        assertTrue(robot.getOrientation().equals(expectedOrientation));
    }

    @Ignore
    @Test
    public void testTurningRightCorrectlyChangesOrientationFromEastToSouth() {
        final Robot robot = new Robot(new GridPosition(0, 0), Orientation.EAST);

        robot.turnRight();

        final Orientation expectedOrientation = Orientation.SOUTH;

        assertTrue(robot.getOrientation().equals(expectedOrientation));
    }

    @Ignore
    @Test
    public void testTurningRightCorrectlyChangesOrientationFromSouthToWest() {
        final Robot robot = new Robot(new GridPosition(0, 0), Orientation.SOUTH);

        robot.turnRight();

        final Orientation expectedOrientation = Orientation.WEST;

        assertTrue(robot.getOrientation().equals(expectedOrientation));
    }

    @Ignore
    @Test
    public void testTurningRightCorrectlyChangesOrientationFromWestToNorth() {
        final Robot robot = new Robot(new GridPosition(0, 0), Orientation.WEST);

        robot.turnRight();

        final Orientation expectedOrientation = Orientation.NORTH;

        assertTrue(robot.getOrientation().equals(expectedOrientation));
    }

    @Ignore
    @Test
    public void testTurningLeftDoesNotChangePosition() {
        final GridPosition initialGridPosition = new GridPosition(0, 0);
        final Robot robot = new Robot(initialGridPosition, Orientation.NORTH);

        robot.turnLeft();

        assertTrue(robot.getGridPosition().equals(initialGridPosition));
    }

    @Ignore
    @Test
    public void testTurningLeftCorrectlyChangesOrientationFromNorthToWest() {
        final Robot robot = new Robot(new GridPosition(0, 0), Orientation.NORTH);

        robot.turnLeft();

        final Orientation expectedOrientation = Orientation.WEST;

        assertTrue(robot.getOrientation().equals(expectedOrientation));
    }

    @Ignore
    @Test
    public void testTurningLeftCorrectlyChangesOrientationFromWestToSouth() {
        final Robot robot = new Robot(new GridPosition(0, 0), Orientation.WEST);

        robot.turnLeft();

        final Orientation expectedOrientation = Orientation.SOUTH;

        assertTrue(robot.getOrientation().equals(expectedOrientation));
    }

    @Ignore
    @Test
    public void testTurningLeftCorrectlyChangesOrientationFromSouthToEast() {
        final Robot robot = new Robot(new GridPosition(0, 0), Orientation.SOUTH);

        robot.turnLeft();

        final Orientation expectedOrientation = Orientation.EAST;

        assertTrue(robot.getOrientation().equals(expectedOrientation));
    }

    @Ignore
    @Test
    public void testTurningLeftCorrectlyChangesOrientationFromEastToNorth() {
        final Robot robot = new Robot(new GridPosition(0, 0), Orientation.EAST);

        robot.turnLeft();

        final Orientation expectedOrientation = Orientation.NORTH;

        assertTrue(robot.getOrientation().equals(expectedOrientation));
    }

    @Ignore
    @Test
    public void testAdvancingDoesNotChangeOrientation() {
        final Orientation initialOrientation = Orientation.NORTH;
        final Robot robot = new Robot(new GridPosition(0, 0), initialOrientation);

        robot.advance();

        assertTrue(robot.getOrientation().equals(initialOrientation));
    }

    @Ignore
    @Test
    public void testAdvancingWhenFacingNorthIncreasesYCoordinateByOne() {
        final Robot robot = new Robot(new GridPosition(0, 0), Orientation.NORTH);

        robot.advance();

        final GridPosition expectedGridPosition = new GridPosition(0, 1);

        assertTrue(robot.getGridPosition().equals(expectedGridPosition));
    }

    @Ignore
    @Test
    public void testAdvancingWhenFacingSouthDecreasesYCoordinateByOne() {
        final Robot robot = new Robot(new GridPosition(0, 0), Orientation.SOUTH);

        robot.advance();

        final GridPosition expectedGridPosition = new GridPosition(0, -1);

        assertTrue(robot.getGridPosition().equals(expectedGridPosition));
    }

    @Ignore
    @Test
    public void testAdvancingWhenFacingEastIncreasesXCoordinateByOne() {
        final Robot robot = new Robot(new GridPosition(0, 0), Orientation.EAST);

        robot.advance();

        final GridPosition expectedGridPosition = new GridPosition(1, 0);

        assertTrue(robot.getGridPosition().equals(expectedGridPosition));
    }

    @Ignore
    @Test
    public void testAdvancingWhenFacingWestDecreasesXCoordinateByOne() {
        final Robot robot = new Robot(new GridPosition(0, 0), Orientation.WEST);

        robot.advance();

        final GridPosition expectedGridPosition = new GridPosition(-1, 0);

        assertTrue(robot.getGridPosition().equals(expectedGridPosition));
    }

    @Ignore
    @Test
    public void testInstructionsToMoveWestAndNorth() {
        final Robot robot = new Robot(new GridPosition(0, 0), Orientation.NORTH);

        robot.simulate("LAAARALA");

        final GridPosition expectedGridPosition = new GridPosition(-4, 1);
        final Orientation expectedOrientation = Orientation.WEST;

        assertTrue(robot.getGridPosition().equals(expectedGridPosition));
        assertTrue(robot.getOrientation().equals(expectedOrientation));
    }

    @Ignore
    @Test
    public void testInstructionsToMoveWestAndSouth() {
        final Robot robot = new Robot(new GridPosition(2, -7), Orientation.EAST);

        robot.simulate("RRAAAAALA");

        final GridPosition expectedGridPosition = new GridPosition(-3, -8);
        final Orientation expectedOrientation = Orientation.SOUTH;

        assertTrue(robot.getGridPosition().equals(expectedGridPosition));
        assertTrue(robot.getOrientation().equals(expectedOrientation));
    }

    @Ignore
    @Test
    public void testInstructionsToMoveEastAndNorth() {
        final Robot robot = new Robot(new GridPosition(8, 4), Orientation.SOUTH);

        robot.simulate("LAAARRRALLLL");

        final GridPosition expectedGridPosition = new GridPosition(11, 5);
        final Orientation expectedOrientation = Orientation.NORTH;

        assertTrue(robot.getGridPosition().equals(expectedGridPosition));
        assertTrue(robot.getOrientation().equals(expectedOrientation));
    }

}
