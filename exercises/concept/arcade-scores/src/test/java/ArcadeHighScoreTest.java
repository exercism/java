import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ArcadeHighScoreTest {

    private final ArcadeHighScore arcadeHighScore = new ArcadeHighScore();


    @Test
    @Tag("task:1")
    @DisplayName("Define a map to store the high scores")
    public void defineMap() {
        assertNotNull(arcadeHighScore.highScores);
    }

    @Test
    @Tag("task:2")
    @DisplayName("Add a player to the high scores map")
    public void addPlayer() {
        String name = "David James";
        Integer score = 67;

        arcadeHighScore.addPlayer(name, score);
        assertThat(arcadeHighScore.highScores).containsEntry(name, score);
    }

    @Test
    @Tag("task:3")
    @DisplayName("Remove a player from the high scores map")
    public void removePlayer() {
        String name = "David James";
        Integer score = 67;

        arcadeHighScore.addPlayer(name, score);
        assertThat(arcadeHighScore.highScores).containsEntry(name, score);

        arcadeHighScore.removePlayer(name);
        assertThat(arcadeHighScore.highScores).isEmpty();
    }

    @Test
    @Tag("task:4")
    @DisplayName("Reset a players score to 0")
    public void resetScore() {
        String name = "David James";
        Integer score = 67;

        arcadeHighScore.addPlayer(name, score);
        assertThat(arcadeHighScore.highScores).containsEntry(name, score);

        arcadeHighScore.resetScore("David James");
        assertThat(arcadeHighScore.highScores).containsEntry(name, 0);
    }

    @Test
    @Tag("task:5")
    @DisplayName("Update a players score")
    public void updateScore() {
        String name = "David James";
        Integer score = 67;

        arcadeHighScore.addPlayer(name, score);
        assertThat(arcadeHighScore.highScores).containsEntry(name, score);

        Integer newScore = 31;

        arcadeHighScore.updateScore(name, newScore);
        assertThat(arcadeHighScore.highScores).containsEntry(name, score + newScore);
    }

    @Test
    @Tag("task:6")
    @DisplayName("Get a list of players")
    public void listOfPlayers() {
        String name = "David James";
        Integer score = 67;

        String secondName = "Lionel Messi";
        Integer secondScore = 87;

        arcadeHighScore.addPlayer(name, score);
        arcadeHighScore.addPlayer(secondName, secondScore);

        assertThat(arcadeHighScore.highScores).containsEntry(name, score).containsEntry(secondName, secondScore);
    }
}
