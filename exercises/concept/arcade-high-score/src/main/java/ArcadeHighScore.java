import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class ArcadeHighScore {

    Map<String, Integer> highScores = new HashMap<>();

    Map<String, Integer> getHighScores(){
        throw new UnsupportedOperationException("Please initialise the ArcadeHighScore.highScores map");
    }

    Map<String, Integer> addPlayer (String name, Integer score) {
        throw new UnsupportedOperationException("Please implement the ArcadeHighScore.addPlayer(name, score) method");
    }

    Map<String, Integer> removePlayer (String name) {
        throw new UnsupportedOperationException("Please implement the ArcadeHighScore.removePlayer(name) method");
    }

    Map<String, Integer> resetScore (String name) {
        throw new UnsupportedOperationException("Please implement the ArcadeHighScore.resetScore(name) method");
    }

    Map<String, Integer> updateScore (String name, Integer score) {
        throw new UnsupportedOperationException("Please implement the ArcadeHighScore.updateScore(name, score) method");
    }

    Set<String> getPlayers () {
        throw new UnsupportedOperationException("Please implement the ArcadeHighScore.listOfPlayers() method");
    }
}
