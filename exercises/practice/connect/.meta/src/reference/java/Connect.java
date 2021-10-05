/**
 * To solve our exercise, we are going to model our board based on disjoint-set data structure, also called a
 * union-find data structure or merge-find set. We are going to use two sets. One for player O and the other for
 * player X.
 * For additional documentation, check
 * <a href="https://en.wikipedia.org/wiki/Disjoint-set_data_structure">Wikipedia Disjoint-set Data Structure</a>
 * or <a href="https://algs4.cs.princeton.edu/15uf">Section 1.5</a> of
 * <i>Algorithms, 4th Edition, A nice book on DSA</i> by Robert Sedgewick and Kevin Wayne.
 */
class Connect {

    private Board boardO;
    private Board boardX;
    private int boardHorizontalSize;
    private int boardVerticalSize;

    public Connect(String[] board) {
        if (board.length == 0) {
            return;
        }

        boardHorizontalSize = board[0]
                .replace(" ", "") // remove spaces
                .length();
        boardVerticalSize = board.length;

        //Player O and Player X don't win in the same directions. Therefore, we use two different boards which track
        //their wins in different directions
        boardO = new Board(boardHorizontalSize, boardVerticalSize, false);
        boardX = new Board(boardHorizontalSize, boardVerticalSize, true);

        //Place stones on the board
        for (int i = 0; i < board.length; i++) {
            String row = board[i].replace(" ", "");
            for (int j = 0; j < row.length(); j++) {
                if (row.charAt(j) == 'O') {
                    boardO.placeStone(i, j);
                }
                if (row.charAt(j) == 'X') {
                    boardX.placeStone(i, j);
                }
            }
        }
    }

    public Winner computeWinner() {
        if (boardO == null || boardX == null) {
            return Winner.NONE;
        }

        boolean playerOCanWin = boardHorizontalSize != 1 || boardO.hasStone(0, 0);
        boolean playerXCanWin = boardVerticalSize != 1 || boardX.hasStone(0, 0);

        if (playerOCanWin && boardO.playerWins()) {
            return Winner.PLAYER_O;
        }

        if (playerXCanWin && boardX.playerWins()) {
            return Winner.PLAYER_X;
        }
        return Winner.NONE;
    }
}
