import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class TournamentTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void justTheHeaderIfNoInput() {
        Tournament tournament = new Tournament();
        assertEquals("Team                           | MP |  W |  D |  L |  P", tournament.printTable());
    }

    @Test
    public void aWinIsThreePointsALossIsZeroPoints() throws Exception {
        Tournament tournament = new Tournament();
        tournament.applyResults("Allegoric Alaskans;Blithering Badgers;win");
        assertArrayEquals(new String[]{
                "Team                           | MP |  W |  D |  L |  P",
                "Allegoric Alaskans             |  1 |  1 |  0 |  0 |  3",
                "Blithering Badgers             |  1 |  0 |  0 |  1 |  0"
                }, tournament.printTable().split("\n"));
    }

    @Test
    public void aWinCanAlsoBeExpressedAsALoss() throws Exception {
        Tournament tournament = new Tournament();
        tournament.applyResults("Blithering Badgers;Allegoric Alaskans;loss");
        assertArrayEquals(new String[]{
                "Team                           | MP |  W |  D |  L |  P",
                "Allegoric Alaskans             |  1 |  1 |  0 |  0 |  3",
                "Blithering Badgers             |  1 |  0 |  0 |  1 |  0"
        }, tournament.printTable().split("\n"));
    }

    @Test
    public void aDifferentTeamCanWin() throws Exception {
        Tournament tournament = new Tournament();
        tournament.applyResults("Blithering Badgers;Allegoric Alaskans;win");
        assertArrayEquals(new String[]{
                "Team                           | MP |  W |  D |  L |  P",
                "Blithering Badgers             |  1 |  1 |  0 |  0 |  3",
                "Allegoric Alaskans             |  1 |  0 |  0 |  1 |  0"
        }, tournament.printTable().split("\n"));
    }

    @Test
    public void aDrawIsOnePointEach() throws Exception {
        Tournament tournament = new Tournament();
        tournament.applyResults( "Allegoric Alaskans;Blithering Badgers;draw");
        assertArrayEquals(new String[]{
                "Team                           | MP |  W |  D |  L |  P",
                "Allegoric Alaskans             |  1 |  0 |  1 |  0 |  1",
                "Blithering Badgers             |  1 |  0 |  1 |  0 |  1"
        }, tournament.printTable().split("\n"));
    }

    @Test
    public void thereCanBeMoreThanOneMatch() throws Exception {
        Tournament tournament = new Tournament();
        tournament.applyResults(
                "Allegoric Alaskans;Blithering Badgers;win\n" +
                        "Allegoric Alaskans;Blithering Badgers;win");
        assertArrayEquals(new String[]{
                "Team                           | MP |  W |  D |  L |  P",
                "Allegoric Alaskans             |  2 |  2 |  0 |  0 |  6",
                "Blithering Badgers             |  2 |  0 |  0 |  2 |  0"
        }, tournament.printTable().split("\n"));
    }

    @Test
    public void thereCanBeMoreThanOneWinner() throws Exception {
        Tournament tournament = new Tournament();
        tournament.applyResults(
                "Allegoric Alaskans;Blithering Badgers;loss\n" +
                "Allegoric Alaskans;Blithering Badgers;win");
        assertArrayEquals(new String[]{
                "Team                           | MP |  W |  D |  L |  P",
                "Allegoric Alaskans             |  2 |  1 |  0 |  1 |  3",
                "Blithering Badgers             |  2 |  1 |  0 |  1 |  3"
        }, tournament.printTable().split("\n"));
    }

    @Test
    public void thereCanBeMoreThanTwoTeams() throws Exception {
        Tournament tournament = new Tournament();
        tournament.applyResults(
                "Allegoric Alaskans;Blithering Badgers;win\n" +
                        "Blithering Badgers;Courageous Californians;win\n" +
                        "Courageous Californians;Allegoric Alaskans;loss");
        assertArrayEquals(new String[]{
                "Team                           | MP |  W |  D |  L |  P",
                "Allegoric Alaskans             |  2 |  2 |  0 |  0 |  6",
                "Blithering Badgers             |  2 |  1 |  0 |  1 |  3",
                "Courageous Californians        |  2 |  0 |  0 |  2 |  0"
        }, tournament.printTable().split("\n"));
    }

    @Test
    public void typicalInput() throws Exception {
        Tournament tournament = new Tournament();
        tournament.applyResults(
                "Allegoric Alaskans;Blithering Badgers;win\n" +
                "Devastating Donkeys;Courageous Californians;draw\n" +
                "Devastating Donkeys;Allegoric Alaskans;win\n" +
                "Courageous Californians;Blithering Badgers;loss\n" +
                "Blithering Badgers;Devastating Donkeys;loss\n" +
                "Allegoric Alaskans;Courageous Californians;win");
        assertArrayEquals(new String[]{
                "Team                           | MP |  W |  D |  L |  P",
                "Devastating Donkeys            |  3 |  2 |  1 |  0 |  7",
                "Allegoric Alaskans             |  3 |  2 |  0 |  1 |  6",
                "Blithering Badgers             |  3 |  1 |  0 |  2 |  3",
                "Courageous Californians        |  3 |  0 |  1 |  2 |  1"
        }, tournament.printTable().split("\n"));
    }

    @Test
    public void incompleteCompetition() throws Exception {
        Tournament tournament = new Tournament();
        tournament.applyResults(
                "Allegoric Alaskans;Blithering Badgers;loss\n" +
                "Devastating Donkeys;Allegoric Alaskans;loss\n" +
                "Courageous Californians;Blithering Badgers;draw\n" +
                "Allegoric Alaskans;Courageous Californians;win");
        assertArrayEquals(new String[]{
                "Team                           | MP |  W |  D |  L |  P",
                "Allegoric Alaskans             |  3 |  2 |  0 |  1 |  6",
                "Blithering Badgers             |  2 |  1 |  1 |  0 |  4",
                "Courageous Californians        |  2 |  0 |  1 |  1 |  1",
                "Devastating Donkeys            |  1 |  0 |  0 |  1 |  0"
        }, tournament.printTable().split("\n"));
    }

    @Test
    public void tiesBrokenAlphabetically() throws Exception {
        Tournament tournament = new Tournament();
        tournament.applyResults(
                "Courageous Californians;Devastating Donkeys;win\n" +
                "Allegoric Alaskans;Blithering Badgers;win\n" +
                "Devastating Donkeys;Allegoric Alaskans;loss\n" +
                "Courageous Californians;Blithering Badgers;win\n" +
                "Blithering Badgers;Devastating Donkeys;draw\n" +
                "Allegoric Alaskans;Courageous Californians;draw");
        assertArrayEquals(new String[]{
                "Team                           | MP |  W |  D |  L |  P",
                "Allegoric Alaskans             |  3 |  2 |  1 |  0 |  7",
                "Courageous Californians        |  3 |  2 |  1 |  0 |  7",
                "Blithering Badgers             |  3 |  0 |  1 |  2 |  1",
                "Devastating Donkeys            |  3 |  0 |  1 |  2 |  1"
        }, tournament.printTable().split("\n"));
    }
}
