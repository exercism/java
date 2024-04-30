import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ArcadeHighScoreTest {

    private ArcadeHighScore arcadeHighScore;

    @BeforeEach
    public void setUp() {
        arcadeHighScore = new ArcadeHighScore();
    }

    @Test
    @Tag("task:1")
    @DisplayName("Define an empty map to store the high scores")
    public void getHighScores() {
        assertNotNull(arcadeHighScore.getHighScores());
        assertThat(arcadeHighScore.highScores.isEmpty());
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
    @Tag("task:5")
    @DisplayName("Update a players score who does not exist")
    public void updateScoreOfNonExistentPlayer() {
        String name = "David James";
        Integer score = 67;

        assertThat(arcadeHighScore).isNull();

        arcadeHighScore.updateScore(name, score);
        assertThat(arcadeHighScore.highScores).containsEntry(name, score);
    }

    @Test
    @Tag("task:6")
    @DisplayName("Get all players")
    public void getPlayers() {
        String name = "David James";
        Integer score = 67;

        String secondName = "Lionel Messi";
        Integer secondScore = 87;

        arcadeHighScore.addPlayer(name, score);
        arcadeHighScore.addPlayer(secondName, secondScore);

        assertThat(arcadeHighScore.getPlayers()).contains(name).contains(secondName);
    }
}
