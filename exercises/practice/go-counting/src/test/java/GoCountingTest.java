import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Ignore;
import org.junit.Test;

import java.awt.Point;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class GoCountingTest {

    String board5x5 = "  B  \n" +
                      " B B \n" +
                      "B W B\n" +
                      " W W \n" +
                      "  W  ";

    @Test
    public void blackCorner5x5BoardTest() {
        GoCounting gocounting = new GoCounting(board5x5);

        Set<Point> territory = new HashSet<>();
        territory.add(new Point(0, 0));
        territory.add(new Point(0, 1));
        territory.add(new Point(1, 0));

        assertEquals(Player.BLACK, gocounting.getTerritoryOwner(0, 1));
        assertEquals(territory, gocounting.getTerritory(0, 1));
    }

    @Ignore("Remove to run test")
    @Test
    public void whiteCenter5x5BoardTest() {
        GoCounting gocounting = new GoCounting(board5x5);

        Set<Point> territory = new HashSet<>();
        territory.add(new Point(2, 3));

        assertEquals(Player.WHITE, gocounting.getTerritoryOwner(2, 3));
        assertEquals(territory, gocounting.getTerritory(2, 3));
    }

    @Ignore("Remove to run test")
    @Test
    public void openCorner5x5BoardTest() {
        GoCounting gocounting = new GoCounting(board5x5);

        Set<Point> territory = new HashSet<>();
        territory.add(new Point(0, 3));
        territory.add(new Point(0, 4));
        territory.add(new Point(1, 4));

        assertEquals(Player.NONE, gocounting.getTerritoryOwner(1, 4));
        assertEquals(territory, gocounting.getTerritory(1, 4));
    }

    @Ignore("Remove to run test")
    @Test
    public void stoneNotTerritory5x5Board() {
        GoCounting gocounting = new GoCounting(board5x5);

        Set<Point> territory = new HashSet<>();

        assertEquals(Player.NONE, gocounting.getTerritoryOwner(1, 1));
        assertEquals(territory, gocounting.getTerritory(1, 1));
    }

    @Ignore("Remove to run test")
    @Test
    public void invalidXTooLow5x5Board() {
        GoCounting gocounting = new GoCounting(board5x5);

        IllegalArgumentException expected =
            assertThrows(
                IllegalArgumentException.class,
                () -> gocounting.getTerritory(-1, 1));

        assertThat(expected).hasMessage("Invalid coordinate");
    }

    @Ignore("Remove to run test")
    @Test
    public void invalidXTooHigh5x5Board() {
        GoCounting gocounting = new GoCounting(board5x5);

        IllegalArgumentException expected =
            assertThrows(
                IllegalArgumentException.class,
                () -> gocounting.getTerritory(5, 1));

        assertThat(expected).hasMessage("Invalid coordinate");
    }

    @Ignore("Remove to run test")
    @Test
    public void invalidYTooLow5x5Board() {
        GoCounting gocounting = new GoCounting(board5x5);

        IllegalArgumentException expected =
            assertThrows(
                IllegalArgumentException.class,
                () -> gocounting.getTerritory(1, -1));

        assertThat(expected).hasMessage("Invalid coordinate");
    }

    @Ignore("Remove to run test")
    @Test
    public void invalidYTooHigh5x5Board() {
        GoCounting gocounting = new GoCounting(board5x5);

        IllegalArgumentException expected =
            assertThrows(
                IllegalArgumentException.class,
                () -> gocounting.getTerritory(1, 5));

        assertThat(expected).hasMessage("Invalid coordinate");
    }

    @Ignore("Remove to run test")
    @Test
    public void oneTerritoryIsWholeBoardTest() {
        GoCounting gocounting = new GoCounting(" ");

        HashMap<Player, Set<Point>> territories = new HashMap<>();
        Set<Point> blackTerritory = new HashSet<>();
        Set<Point> whiteTerritory = new HashSet<>();
        Set<Point> noneTerritory = new HashSet<>();
        noneTerritory.add(new Point(0, 0));

        territories.put(Player.BLACK, blackTerritory);
        territories.put(Player.WHITE, whiteTerritory);
        territories.put(Player.NONE, noneTerritory);

        assertEquals(territories, gocounting.getTerritories());
    }

    @Ignore("Remove to run test")
    @Test
    public void twoTerritoryRectangularBoardTest() {
        GoCounting gocounting = new GoCounting(" BW \n BW ");

        Set<Point> blackTerritory = new HashSet<>();
        blackTerritory.add(new Point(0, 0));
        blackTerritory.add(new Point(0, 1));

        Set<Point> whiteTerritory = new HashSet<>();
        whiteTerritory.add(new Point(3, 0));
        whiteTerritory.add(new Point(3, 1));

        Set<Point> noneTerritory = new HashSet<>();

        HashMap<Player, Set<Point>> territories = new HashMap<>();
        territories.put(Player.BLACK, blackTerritory);
        territories.put(Player.WHITE, whiteTerritory);
        territories.put(Player.NONE, noneTerritory);

        assertEquals(territories, gocounting.getTerritories());
    }

    @Ignore("Remove to run test")
    @Test
    public void twoRegionRectangularBoardTest() {
        GoCounting gocounting = new GoCounting(" B ");

        HashMap<Player, Set<Point>> territories = new HashMap<>();
        Set<Point> blackTerritory = new HashSet<>();
        blackTerritory.add(new Point(0, 0));
        blackTerritory.add(new Point(2, 0));
        Set<Point> whiteTerritory = new HashSet<>();
        Set<Point> noneTerritory = new HashSet<>();

        territories.put(Player.BLACK, blackTerritory);
        territories.put(Player.WHITE, whiteTerritory);
        territories.put(Player.NONE, noneTerritory);

        assertEquals(territories, gocounting.getTerritories());
    }
}
