import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ArcadeHighScore {

    private Map<String, Integer> highScores = new HashMap<>();

    Map<String, Integer> getHighScores() {
        return highScores;
    }

    Map<String, Integer> defineMap() {
        return highScores;
    }

    void addPlayer(String name, Integer score) {
        highScores.put(name, score);
    }

    void removePlayer (String name) {
        highScores.remove(name);
    }

    void resetScore (String name) {
        highScores.put(name, 0);
    }

    void updateScore (String name, Integer score) {

        Integer oldScore = highScores.getOrDefault(name, 0);

        highScores.put(name, oldScore + score);
    }

    Set<String> getPlayers () {
            return highScores.keySet();
        }
}
