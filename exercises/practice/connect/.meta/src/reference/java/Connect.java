
class Connect {

    public Winner computeWinner(String[] board) {
        return Winner.NONE;
    }

    enum Winner {
        PLAYER_X,
        PLAYER_O,
        NONE
    }
}
