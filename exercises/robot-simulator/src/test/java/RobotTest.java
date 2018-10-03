import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RobotTest {

    @Test
    public void robotsAreCreatedWithAPositionAndOrientation() {
        Orientation initialOrientation = Orientation.NORTH;
        GridPosition initialGridPosition = new GridPosition(0, 0);
        Robot robot = new Robot(initialGridPosition, initialOrientation);

        assertEquals(initialOrientation, robot.getOrientation());
        assertEquals(initialGridPosition, robot.getGridPosition());
    }

    @Ignore("Remove to run test")
    @Test
    public void negativePositionsAreAllowed() {
        GridPosition initialGridPosition = new GridPosition(-1, -1);
        Orientation initialOrientation = Orientation.SOUTH;
        Robot robot = new Robot(initialGridPosition, initialOrientation);

        assertEquals(initialOrientation, robot.getOrientation());
        assertEquals(initialGridPosition, robot.getGridPosition());
    }

    @Ignore("Remove to run test")
    @Test
    public void changesTheDirectionFromNorthToEast() {
        GridPosition initialGridPosition = new GridPosition(0, 0);
        Robot robot = new Robot(initialGridPosition, Orientation.NORTH);

        robot.turnRight();

        Orientation expectedOrientation = Orientation.EAST;
        assertEquals(initialGridPosition, robot.getGridPosition());
        assertEquals(expectedOrientation, robot.getOrientation());
    }

    @Ignore("Remove to run test")
    @Test
    public void changesTheDirectionFromEastToSouth() {
        GridPosition initialGridPosition = new GridPosition(0, 0);
        Robot robot = new Robot(initialGridPosition, Orientation.EAST);

        robot.turnRight();

        Orientation expectedOrientation = Orientation.SOUTH;
        assertEquals(initialGridPosition, robot.getGridPosition());
        assertEquals(expectedOrientation, robot.getOrientation());
    }

    @Ignore("Remove to run test")
    @Test
    public void changesTheDirectionFromSouthToWest() {
        GridPosition initialGridPosition = new GridPosition(0, 0);
        Robot robot = new Robot(initialGridPosition, Orientation.SOUTH);

        robot.turnRight();

        Orientation expectedOrientation = Orientation.WEST;
        assertEquals(initialGridPosition, robot.getGridPosition());
        assertEquals(expectedOrientation, robot.getOrientation());
    }

    @Ignore("Remove to run test")
    @Test
    public void changesTheDirectionFromWestToNorth() {
        GridPosition initialGridPosition = new GridPosition(0, 0);
        Robot robot = new Robot(initialGridPosition, Orientation.WEST);

        robot.turnRight();

        Orientation expectedOrientation = Orientation.NORTH;
        assertEquals(initialGridPosition, robot.getGridPosition());
        assertEquals(expectedOrientation, robot.getOrientation());
    }

    @Ignore("Remove to run test")
    @Test
    public void changesTheDirectionFromNorthToWest() {
        GridPosition initialGridPosition = new GridPosition(0, 0);
        Robot robot = new Robot(initialGridPosition, Orientation.NORTH);

        robot.turnLeft();

        Orientation expectedOrientation = Orientation.WEST;
        assertEquals(initialGridPosition, robot.getGridPosition());
        assertEquals(expectedOrientation, robot.getOrientation());
    }

    @Ignore("Remove to run test")
    @Test
    public void changesTheDirectionFromWestToSouth() {
        GridPosition initialGridPosition = new GridPosition(0, 0);
        Robot robot = new Robot(initialGridPosition, Orientation.WEST);

        robot.turnLeft();

        Orientation expectedOrientation = Orientation.SOUTH;
        assertEquals(initialGridPosition, robot.getGridPosition());
        assertEquals(expectedOrientation, robot.getOrientation());
    }

    @Ignore("Remove to run test")
    @Test
    public void changesTheDirectionFromSouthToEast() {
        GridPosition initialGridPosition = new GridPosition(0, 0);
        Robot robot = new Robot(initialGridPosition, Orientation.SOUTH);

        robot.turnLeft();

        Orientation expectedOrientation = Orientation.EAST;
        assertEquals(initialGridPosition, robot.getGridPosition());
        assertEquals(expectedOrientation, robot.getOrientation());
    }

    @Ignore("Remove to run test")
    @Test
    public void changesTheDirectionFromEastToNorth() {
        GridPosition initialGridPosition = new GridPosition(0, 0);
        Robot robot = new Robot(initialGridPosition, Orientation.EAST);

        robot.turnLeft();

        Orientation expectedOrientation = Orientation.NORTH;
        assertEquals(initialGridPosition, robot.getGridPosition());
        assertEquals(expectedOrientation, robot.getOrientation());
    }

    @Ignore("Remove to run test")
    @Test
    public void increasesTheYCoordinateOneWhenFacingNorth() {
        Orientation initialOrientation = Orientation.NORTH;
        Robot robot = new Robot(new GridPosition(0, 0), initialOrientation);

        robot.advance();

        GridPosition expectedGridPosition = new GridPosition(0, 1);
        assertEquals(expectedGridPosition, robot.getGridPosition());
        assertEquals(initialOrientation, robot.getOrientation());
    }

    @Ignore("Remove to run test")
    @Test
    public void decreasesTheYCoordinateByOneWhenFacingSouth() {
        Orientation initialOrientation = Orientation.SOUTH;
        Robot robot = new Robot(new GridPosition(0, 0), initialOrientation);

        robot.advance();

        GridPosition expectedGridPosition = new GridPosition(0, -1);
        assertEquals(expectedGridPosition, robot.getGridPosition());
        assertEquals(initialOrientation, robot.getOrientation());
    }

    @Ignore("Remove to run test")
    @Test
    public void increasesTheXCoordinateByOneWhenFacingEast() {
        Orientation initialOrientation = Orientation.EAST;
        Robot robot = new Robot(new GridPosition(0, 0), initialOrientation);

        robot.advance();

        GridPosition expectedGridPosition = new GridPosition(1, 0);
        assertEquals(expectedGridPosition, robot.getGridPosition());
        assertEquals(initialOrientation, robot.getOrientation());
    }

    @Ignore("Remove to run test")
    @Test
    public void decreasesTheXCoordinateByOneWhenFacingWest() {
        Orientation initialOrientation = Orientation.WEST;
        Robot robot = new Robot(new GridPosition(0, 0), initialOrientation);

        robot.advance();

        GridPosition expectedGridPosition = new GridPosition(-1, 0);
        assertEquals(expectedGridPosition, robot.getGridPosition());
        assertEquals(initialOrientation, robot.getOrientation());
    }

    @Ignore("Remove to run test")
    @Test
    public void instructionsStartingNorthAndMoveEastAndNorth() {
        Robot robot = new Robot(new GridPosition(7, 3), Orientation.NORTH);

        robot.simulate("RAALAL");

        GridPosition expectedGridPosition = new GridPosition(9, 4);
        Orientation expectedOrientation = Orientation.WEST;

        assertEquals(expectedGridPosition, robot.getGridPosition());
        assertEquals(expectedOrientation, robot.getOrientation());
    }


    @Ignore("Remove to run test")
    @Test
    public void instructionsToMoveWestAndNorth() {
        Robot robot = new Robot(new GridPosition(0, 0), Orientation.NORTH);

        robot.simulate("LAAARALA");

        GridPosition expectedGridPosition = new GridPosition(-4, 1);
        Orientation expectedOrientation = Orientation.WEST;

        assertEquals(expectedGridPosition, robot.getGridPosition());
        assertEquals(expectedOrientation, robot.getOrientation());
    }

    @Ignore("Remove to run test")
    @Test
    public void instructionsToMoveWestAndSouth() {
        Robot robot = new Robot(new GridPosition(2, -7), Orientation.EAST);

        robot.simulate("RRAAAAALA");

        GridPosition expectedGridPosition = new GridPosition(-3, -8);
        Orientation expectedOrientation = Orientation.SOUTH;

        assertEquals(expectedGridPosition, robot.getGridPosition());
        assertEquals(expectedOrientation, robot.getOrientation());
    }

    @Ignore("Remove to run test")
    @Test
    public void instructionsStartingSouthAndMoveEastAndNorth() {
        Robot robot = new Robot(new GridPosition(8, 4), Orientation.SOUTH);

        robot.simulate("LAAARRRALLLL");

        GridPosition expectedGridPosition = new GridPosition(11, 5);
        Orientation expectedOrientation = Orientation.NORTH;

        assertEquals(expectedGridPosition, robot.getGridPosition());
        assertEquals(expectedOrientation, robot.getOrientation());
    }

}
