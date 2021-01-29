import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RobotTest {

    /* Create robot */

    @Test
    public void atOriginFacingNorth() {
        Orientation initialOrientation = Orientation.NORTH;
        GridPosition initialGridPosition = new GridPosition(0, 0);
        Robot robot = new Robot(initialGridPosition, initialOrientation);

        assertEquals(initialOrientation, robot.getOrientation());
        assertEquals(initialGridPosition, robot.getGridPosition());
    }

    @Ignore("Remove to run test")
    @Test
    public void atNegativePositionFacingSouth() {
        GridPosition initialGridPosition = new GridPosition(-1, -1);
        Orientation initialOrientation = Orientation.SOUTH;
        Robot robot = new Robot(initialGridPosition, initialOrientation);

        assertEquals(initialOrientation, robot.getOrientation());
        assertEquals(initialGridPosition, robot.getGridPosition());
    }

    /* Rotating clockwise */

    @Ignore("Remove to run test")
    @Test
    public void changesNorthToEast() {
        GridPosition initialGridPosition = new GridPosition(0, 0);
        Robot robot = new Robot(initialGridPosition, Orientation.NORTH);

        robot.turnRight();

        Orientation expectedOrientation = Orientation.EAST;
        assertEquals(initialGridPosition, robot.getGridPosition());
        assertEquals(expectedOrientation, robot.getOrientation());
    }

    @Ignore("Remove to run test")
    @Test
    public void changesEastToSouth() {
        GridPosition initialGridPosition = new GridPosition(0, 0);
        Robot robot = new Robot(initialGridPosition, Orientation.EAST);

        robot.turnRight();

        Orientation expectedOrientation = Orientation.SOUTH;
        assertEquals(initialGridPosition, robot.getGridPosition());
        assertEquals(expectedOrientation, robot.getOrientation());
    }

    @Ignore("Remove to run test")
    @Test
    public void changesSouthToWest() {
        GridPosition initialGridPosition = new GridPosition(0, 0);
        Robot robot = new Robot(initialGridPosition, Orientation.SOUTH);

        robot.turnRight();

        Orientation expectedOrientation = Orientation.WEST;
        assertEquals(initialGridPosition, robot.getGridPosition());
        assertEquals(expectedOrientation, robot.getOrientation());
    }

    @Ignore("Remove to run test")
    @Test
    public void changesWestToNorth() {
        GridPosition initialGridPosition = new GridPosition(0, 0);
        Robot robot = new Robot(initialGridPosition, Orientation.WEST);

        robot.turnRight();

        Orientation expectedOrientation = Orientation.NORTH;
        assertEquals(initialGridPosition, robot.getGridPosition());
        assertEquals(expectedOrientation, robot.getOrientation());
    }

    /* Rotating counter-clockwise */

    @Ignore("Remove to run test")
    @Test
    public void changesNorthToWest() {
        GridPosition initialGridPosition = new GridPosition(0, 0);
        Robot robot = new Robot(initialGridPosition, Orientation.NORTH);

        robot.turnLeft();

        Orientation expectedOrientation = Orientation.WEST;
        assertEquals(initialGridPosition, robot.getGridPosition());
        assertEquals(expectedOrientation, robot.getOrientation());
    }

    @Ignore("Remove to run test")
    @Test
    public void changesWestToSouth() {
        GridPosition initialGridPosition = new GridPosition(0, 0);
        Robot robot = new Robot(initialGridPosition, Orientation.WEST);

        robot.turnLeft();

        Orientation expectedOrientation = Orientation.SOUTH;
        assertEquals(initialGridPosition, robot.getGridPosition());
        assertEquals(expectedOrientation, robot.getOrientation());
    }

    @Ignore("Remove to run test")
    @Test
    public void changesSouthToEast() {
        GridPosition initialGridPosition = new GridPosition(0, 0);
        Robot robot = new Robot(initialGridPosition, Orientation.SOUTH);

        robot.turnLeft();

        Orientation expectedOrientation = Orientation.EAST;
        assertEquals(initialGridPosition, robot.getGridPosition());
        assertEquals(expectedOrientation, robot.getOrientation());
    }

    @Ignore("Remove to run test")
    @Test
    public void changesEastToNorth() {
        GridPosition initialGridPosition = new GridPosition(0, 0);
        Robot robot = new Robot(initialGridPosition, Orientation.EAST);

        robot.turnLeft();

        Orientation expectedOrientation = Orientation.NORTH;
        assertEquals(initialGridPosition, robot.getGridPosition());
        assertEquals(expectedOrientation, robot.getOrientation());
    }

    /* Moving forward one */

    @Ignore("Remove to run test")
    @Test
    public void facingNorthIncrementsY() {
        Orientation initialOrientation = Orientation.NORTH;
        Robot robot = new Robot(new GridPosition(0, 0), initialOrientation);

        robot.advance();

        GridPosition expectedGridPosition = new GridPosition(0, 1);
        assertEquals(expectedGridPosition, robot.getGridPosition());
        assertEquals(initialOrientation, robot.getOrientation());
    }

    @Ignore("Remove to run test")
    @Test
    public void facingSouthDecrementsY() {
        Orientation initialOrientation = Orientation.SOUTH;
        Robot robot = new Robot(new GridPosition(0, 0), initialOrientation);

        robot.advance();

        GridPosition expectedGridPosition = new GridPosition(0, -1);
        assertEquals(expectedGridPosition, robot.getGridPosition());
        assertEquals(initialOrientation, robot.getOrientation());
    }

    @Ignore("Remove to run test")
    @Test
    public void facingEastIncrementsX() {
        Orientation initialOrientation = Orientation.EAST;
        Robot robot = new Robot(new GridPosition(0, 0), initialOrientation);

        robot.advance();

        GridPosition expectedGridPosition = new GridPosition(1, 0);
        assertEquals(expectedGridPosition, robot.getGridPosition());
        assertEquals(initialOrientation, robot.getOrientation());
    }

    @Ignore("Remove to run test")
    @Test
    public void facingWestDecrementsX() {
        Orientation initialOrientation = Orientation.WEST;
        Robot robot = new Robot(new GridPosition(0, 0), initialOrientation);

        robot.advance();

        GridPosition expectedGridPosition = new GridPosition(-1, 0);
        assertEquals(expectedGridPosition, robot.getGridPosition());
        assertEquals(initialOrientation, robot.getOrientation());
    }

    /* Follow series of instructions */

    @Ignore("Remove to run test")
    @Test
    public void movingEastAndNorthFromReadme() {
        Robot robot = new Robot(new GridPosition(7, 3), Orientation.NORTH);

        robot.simulate("RAALAL");

        GridPosition expectedGridPosition = new GridPosition(9, 4);
        Orientation expectedOrientation = Orientation.WEST;

        assertEquals(expectedGridPosition, robot.getGridPosition());
        assertEquals(expectedOrientation, robot.getOrientation());
    }


    @Ignore("Remove to run test")
    @Test
    public void movingWestAndNorth() {
        Robot robot = new Robot(new GridPosition(0, 0), Orientation.NORTH);

        robot.simulate("LAAARALA");

        GridPosition expectedGridPosition = new GridPosition(-4, 1);
        Orientation expectedOrientation = Orientation.WEST;

        assertEquals(expectedGridPosition, robot.getGridPosition());
        assertEquals(expectedOrientation, robot.getOrientation());
    }

    @Ignore("Remove to run test")
    @Test
    public void movingWestAndSouth() {
        Robot robot = new Robot(new GridPosition(2, -7), Orientation.EAST);

        robot.simulate("RRAAAAALA");

        GridPosition expectedGridPosition = new GridPosition(-3, -8);
        Orientation expectedOrientation = Orientation.SOUTH;

        assertEquals(expectedGridPosition, robot.getGridPosition());
        assertEquals(expectedOrientation, robot.getOrientation());
    }

    @Ignore("Remove to run test")
    @Test
    public void movingEastAndNorth() {
        Robot robot = new Robot(new GridPosition(8, 4), Orientation.SOUTH);

        robot.simulate("LAAARRRALLLL");

        GridPosition expectedGridPosition = new GridPosition(11, 5);
        Orientation expectedOrientation = Orientation.NORTH;

        assertEquals(expectedGridPosition, robot.getGridPosition());
        assertEquals(expectedOrientation, robot.getOrientation());
    }

}
