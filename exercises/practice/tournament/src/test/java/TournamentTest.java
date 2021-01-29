import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TournamentTest {

    private Tournament tournament;

    @Before
    public void setUp() {
        tournament = new Tournament();
    }

    @Test
    public void justTheHeaderIfNoInput() {
        assertEquals("Team                           | MP |  W |  D |  L |  P\n", tournament.printTable());
    }

    @Ignore("Remove to run test")
    @Test
    public void aWinIsThreePointsALossIsZeroPoints() {
        tournament.applyResults("Allegoric Alaskans;Blithering Badgers;win");
        assertEquals(
                "Team                           | MP |  W |  D |  L |  P\n" +
                "Allegoric Alaskans             |  1 |  1 |  0 |  0 |  3\n" +
                "Blithering Badgers             |  1 |  0 |  0 |  1 |  0\n",
                tournament.printTable());
    }

    @Ignore("Remove to run test")
    @Test
    public void aWinCanAlsoBeExpressedAsALoss() {
        tournament.applyResults("Blithering Badgers;Allegoric Alaskans;loss");
        assertEquals(
                "Team                           | MP |  W |  D |  L |  P\n" +
                "Allegoric Alaskans             |  1 |  1 |  0 |  0 |  3\n" +
                "Blithering Badgers             |  1 |  0 |  0 |  1 |  0\n",
                tournament.printTable());
    }

    @Ignore("Remove to run test")
    @Test
    public void aDifferentTeamCanWin() {
        tournament.applyResults("Blithering Badgers;Allegoric Alaskans;win");
        assertEquals(
                "Team                           | MP |  W |  D |  L |  P\n" +
                "Blithering Badgers             |  1 |  1 |  0 |  0 |  3\n" +
                "Allegoric Alaskans             |  1 |  0 |  0 |  1 |  0\n",
                tournament.printTable());
    }

    @Ignore("Remove to run test")
    @Test
    public void aDrawIsOnePointEach() {
        tournament.applyResults("Allegoric Alaskans;Blithering Badgers;draw");
        assertEquals(
                "Team                           | MP |  W |  D |  L |  P\n" +
                "Allegoric Alaskans             |  1 |  0 |  1 |  0 |  1\n" +
                "Blithering Badgers             |  1 |  0 |  1 |  0 |  1\n",
                tournament.printTable());
    }

    @Ignore("Remove to run test")
    @Test
    public void thereCanBeMoreThanOneMatch() {
        tournament.applyResults(
                "Allegoric Alaskans;Blithering Badgers;win\n" +
                "Allegoric Alaskans;Blithering Badgers;win");
        assertEquals(
                "Team                           | MP |  W |  D |  L |  P\n" +
                "Allegoric Alaskans             |  2 |  2 |  0 |  0 |  6\n" +
                "Blithering Badgers             |  2 |  0 |  0 |  2 |  0\n",
                tournament.printTable());
    }

    @Ignore("Remove to run test")
    @Test
    public void thereCanBeMoreThanOneWinner() {
        tournament.applyResults(
                "Allegoric Alaskans;Blithering Badgers;loss\n" +
                "Allegoric Alaskans;Blithering Badgers;win");
        assertEquals(
                "Team                           | MP |  W |  D |  L |  P\n" +
                "Allegoric Alaskans             |  2 |  1 |  0 |  1 |  3\n" +
                "Blithering Badgers             |  2 |  1 |  0 |  1 |  3\n",
                tournament.printTable());
    }

    @Ignore("Remove to run test")
    @Test
    public void thereCanBeMoreThanTwoTeams() {
        tournament.applyResults(
                "Allegoric Alaskans;Blithering Badgers;win\n" +
                "Blithering Badgers;Courageous Californians;win\n" +
                "Courageous Californians;Allegoric Alaskans;loss");
        assertEquals(
                "Team                           | MP |  W |  D |  L |  P\n" +
                "Allegoric Alaskans             |  2 |  2 |  0 |  0 |  6\n" +
                "Blithering Badgers             |  2 |  1 |  0 |  1 |  3\n" +
                "Courageous Californians        |  2 |  0 |  0 |  2 |  0\n",
                tournament.printTable());
    }

    @Ignore("Remove to run test")
    @Test
    public void typicalInput() {
        tournament.applyResults(
                "Allegoric Alaskans;Blithering Badgers;win\n" +
                "Devastating Donkeys;Courageous Californians;draw\n" +
                "Devastating Donkeys;Allegoric Alaskans;win\n" +
                "Courageous Californians;Blithering Badgers;loss\n" +
                "Blithering Badgers;Devastating Donkeys;loss\n" +
                "Allegoric Alaskans;Courageous Californians;win");
        assertEquals(
                "Team                           | MP |  W |  D |  L |  P\n" +
                "Devastating Donkeys            |  3 |  2 |  1 |  0 |  7\n" +
                "Allegoric Alaskans             |  3 |  2 |  0 |  1 |  6\n" +
                "Blithering Badgers             |  3 |  1 |  0 |  2 |  3\n" +
                "Courageous Californians        |  3 |  0 |  1 |  2 |  1\n",
                tournament.printTable());
    }

    @Ignore("Remove to run test")
    @Test
    public void incompleteCompetition() {
        tournament.applyResults(
                "Allegoric Alaskans;Blithering Badgers;loss\n" +
                "Devastating Donkeys;Allegoric Alaskans;loss\n" +
                "Courageous Californians;Blithering Badgers;draw\n" +
                "Allegoric Alaskans;Courageous Californians;win");
        assertEquals(
                "Team                           | MP |  W |  D |  L |  P\n" +
                "Allegoric Alaskans             |  3 |  2 |  0 |  1 |  6\n" +
                "Blithering Badgers             |  2 |  1 |  1 |  0 |  4\n" +
                "Courageous Californians        |  2 |  0 |  1 |  1 |  1\n" +
                "Devastating Donkeys            |  1 |  0 |  0 |  1 |  0\n",
                tournament.printTable());
    }

    @Ignore("Remove to run test")
    @Test
    public void tiesBrokenAlphabetically() {
        tournament.applyResults(
                "Courageous Californians;Devastating Donkeys;win\n" +
                "Allegoric Alaskans;Blithering Badgers;win\n" +
                "Devastating Donkeys;Allegoric Alaskans;loss\n" +
                "Courageous Californians;Blithering Badgers;win\n" +
                "Blithering Badgers;Devastating Donkeys;draw\n" +
                "Allegoric Alaskans;Courageous Californians;draw");
        assertEquals(
                "Team                           | MP |  W |  D |  L |  P\n" +
                "Allegoric Alaskans             |  3 |  2 |  1 |  0 |  7\n" +
                "Courageous Californians        |  3 |  2 |  1 |  0 |  7\n" +
                "Blithering Badgers             |  3 |  0 |  1 |  2 |  1\n" +
                "Devastating Donkeys            |  3 |  0 |  1 |  2 |  1\n",
                tournament.printTable());
    }
}
