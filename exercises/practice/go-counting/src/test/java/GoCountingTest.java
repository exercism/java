import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

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

        assertThat(gocounting.getTerritoryOwner(0, 1)).isEqualTo(Player.BLACK);
        assertThat(gocounting.getTerritory(0, 1)).isEqualTo(territory);
    }

    @Disabled("Remove to run test")
    @Test
    public void whiteCenter5x5BoardTest() {
        GoCounting gocounting = new GoCounting(board5x5);

        Set<Point> territory = new HashSet<>();
        territory.add(new Point(2, 3));

        assertThat(gocounting.getTerritoryOwner(2, 3)).isEqualTo(Player.WHITE);
        assertThat(gocounting.getTerritory(2, 3)).isEqualTo(territory);
    }

    @Disabled("Remove to run test")
    @Test
    public void openCorner5x5BoardTest() {
        GoCounting gocounting = new GoCounting(board5x5);

        Set<Point> territory = new HashSet<>();
        territory.add(new Point(0, 3));
        territory.add(new Point(0, 4));
        territory.add(new Point(1, 4));

        assertThat(gocounting.getTerritoryOwner(1, 4)).isEqualTo(Player.NONE);
        assertThat(gocounting.getTerritory(1, 4)).isEqualTo(territory);
    }

    @Disabled("Remove to run test")
    @Test
    public void stoneNotTerritory5x5Board() {
        GoCounting gocounting = new GoCounting(board5x5);

        Set<Point> territory = new HashSet<>();

        assertThat(gocounting.getTerritoryOwner(1, 1)).isEqualTo(Player.NONE);
        assertThat(gocounting.getTerritory(1, 1)).isEqualTo(territory);
    }

    @Disabled("Remove to run test")
    @Test
    public void invalidXTooLow5x5Board() {
        GoCounting gocounting = new GoCounting(board5x5);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> gocounting.getTerritory(-1, 1))
                .withMessage("Invalid coordinate");
    }

    @Disabled("Remove to run test")
    @Test
    public void invalidXTooHigh5x5Board() {
        GoCounting gocounting = new GoCounting(board5x5);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> gocounting.getTerritory(5, 1))
                .withMessage("Invalid coordinate");
    }

    @Disabled("Remove to run test")
    @Test
    public void invalidYTooLow5x5Board() {
        GoCounting gocounting = new GoCounting(board5x5);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> gocounting.getTerritory(1, -1))
                .withMessage("Invalid coordinate");
    }

    @Disabled("Remove to run test")
    @Test
    public void invalidYTooHigh5x5Board() {
        GoCounting gocounting = new GoCounting(board5x5);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> gocounting.getTerritory(1, 5))
                .withMessage("Invalid coordinate");
    }

    @Disabled("Remove to run test")
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

        assertThat(gocounting.getTerritories()).isEqualTo(territories);
    }

    @Disabled("Remove to run test")
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

        assertThat(gocounting.getTerritories()).isEqualTo(territories);
    }

    @Disabled("Remove to run test")
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

        assertThat(gocounting.getTerritories()).isEqualTo(territories);
    }
}
