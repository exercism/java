import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

class HighScores {

    private List<Integer> highScores;

    public HighScores(List<Integer> highScores) {
        this.highScores = new ArrayList<Integer>(highScores);
    }

    List<Integer> scores() {
        return new ArrayList<Integer>(highScores);
    }

    Integer latest() {
        return highScores.get(highScores.size() - 1);
    }

    Integer personalBest() {
        Optional<Integer> personalBest = highScores.stream().max(Comparator.naturalOrder());
        return personalBest.orElse(0);
    }

    List<Integer> personalTopThree() {
        return highScores.stream().sorted(Comparator.reverseOrder()).limit(3).collect(Collectors.toList());
    }

}
