import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ArcadeHighScore {

    Map<String, Integer> highScores = new HashMap<>();

    Map<String, Integer> defineMap() {
        return highScores;
    }

    Map<String, Integer> addPlayer (String name, Integer score) {
        highScores.put(name, score);
        return highScores;
    }

    Map<String, Integer> removePlayer (String name) {
        highScores.remove(name);
        return highScores;
    }

    Map<String, Integer> resetScore (String name) {
        highScores.put(name, 0);
        return highScores;
    }

    Map<String, Integer> updateScore (String name, Integer score) {

        Integer oldScore = highScores.getOrDefault(name, 0);

        highScores.put(name, oldScore + score);
        return highScores;
    }

    Set<String> listOfPlayers () {
        return highScores.keySet();
    }
}
