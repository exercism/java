class TeamResult {

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
