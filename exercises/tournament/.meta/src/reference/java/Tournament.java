import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

class Tournament {

    private static Pattern separatorPattern = Pattern.compile(";");
    private static Pattern newlinePattern = Pattern.compile("\\n");

    private Map<String, TeamResult> results;

    Tournament() {
        results = new HashMap<>();
    }

    String printTable() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-30s | %2s | %2s | %2s | %2s | %2s",
                "Team", "MP", "W", "D", "L", "P"));
        results.entrySet()
                .stream()
                .sorted(Tournament::comparator)
                .forEach(e -> sb.append(
                        String.format("\n%-30s | %2d | %2d | %2d | %2d | %2d",
                                e.getKey(), e.getValue().getPlayed(), e.getValue().getWins(), e.getValue().getDraws(),
                                e.getValue().getLosses(), e.getValue().getPoints())));
        return sb.toString();
    }

    private static int comparator(Map.Entry<String, TeamResult> teamA, Map.Entry<String, TeamResult> teamB) {
        int compareByPoints = Integer.compare(teamB.getValue().getPoints(), teamA.getValue().getPoints());
        return compareByPoints == 0 ? teamA.getKey().compareTo(teamB.getKey()) : compareByPoints;
    }

    void applyResults(final String resultString) {
        String[] matches = newlinePattern.split(resultString);
        for (String matchString: matches) {
            String[] column = separatorPattern.split(matchString);
            final TeamResult home = results.getOrDefault(column[0], new TeamResult());
            final TeamResult away = results.getOrDefault(column[1], new TeamResult());
            final Result result = Result.valueOf(column[2].toUpperCase());
            switch (result) {
                case WIN:
                    home.applyResult(Result.WIN);
                    away.applyResult(Result.LOSS);
                    break;
                case LOSS:
                    home.applyResult(Result.LOSS);
                    away.applyResult(Result.WIN);
                    break;
                case DRAW:
                    home.applyResult(Result.DRAW);
                    away.applyResult(Result.DRAW);
                    break;
            }
            results.put(column[0], home);
            results.put(column[1], away);
        }
    }

    enum Result {
        WIN,
        DRAW,
        LOSS
    }

    private class TeamResult {

        private int wins;
        private int losses;
        private int draws;

        TeamResult() {
            wins = 0;
            losses = 0;
            draws = 0;
        }

        int getPlayed() {
            return wins + losses + draws;
        }

        int getPoints() {
            return wins * 3 + draws;
        }

        int getWins() {
            return wins;
        }

        int getLosses() {
            return losses;
        }

        int getDraws() {
            return draws;
        }

        void applyResult(final Result result) {
            switch (result) {
                case WIN: wins++; break;
                case DRAW: draws++; break;
                case LOSS: losses++; break;
            }
        }

    }
}
