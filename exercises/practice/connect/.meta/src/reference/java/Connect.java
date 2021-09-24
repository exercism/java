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

    private int[] parentO;   //The disjoint-set of player O. Each element of this array represents a field
                            //and each field is connected to itself at initialization.
    private int[] sizeO;     //the number of elements in each subset of the disjoint-set of player O. All initialized to 1 at the start

    private int[] parentX;   //The disjoint-set of player X. Each element of this array represents a field
                            //and each field is connected to itself at initialization.
    private int[] sizeX;     //the number of elements in each subset of the disjoint-set of player X. All initialized to 1 at the start

    private boolean[] playedO; // This helps us keep track of whether player O hs placed a stone on a field.
    private boolean[] playedX; // This helps us keep track of whether player X hs placed a stone on a field.

    private int boardHorizontalSize;
    private int boardVerticalSize;

    public Connect(String[] board) {
        if(board.length == 0) {
            return;
        }

        int boardHorizontalSize = board[0]
                .replace(" ", "") // remove spaces
                .length();
        initializeBoard(boardHorizontalSize, board.length);

        //Place stones on the board
        for(int i=0; i<board.length; i++) {
            String row = board[i].replace(" ", "");
            for(int j=0; j<row.length(); j++) {
                if(row.charAt(j) == 'O') {
                    playO(i+1, j+1);
                }
                if(row.charAt(j) == 'X') {
                    playX(i+1, j+1);
                }
            }
        }
    }

    public Winner computeWinner() {
        if(parentO == null) {
            return Winner.NONE;
        }

        boolean playerOCanWin = boardHorizontalSize != 1 || isPlayed(1, 1, playedO);
        boolean playerXCanWin = boardVerticalSize != 1 || isPlayed(1, 1, playedX);

        //If top-left field is connected to bottom-left field, then top side is connected to bottom side and player O wins
        //Remember we made the top-left field the representative of all fields at the top during initialization.
        //We also made the bottom-left field the representative of all fields at the bottom.
        if(playerOCanWin && findO(0) == findO(boardHorizontalSize * (boardVerticalSize - 1))) {
            return Winner.PLAYER_O;
        }

        //If top-left field is connected to top-right field, then left side is connected to right side and player X wins
        //Remember we made the top-left field the representative of all fields on the left during initialization.
        //We also made the top-right field the representative of all fields on the right.
        if(playerXCanWin && findX(0) == findX(boardHorizontalSize - 1)) {
            return Winner.PLAYER_X;
        }
        return Winner.NONE;
    }

    /**
     * Create two disjoint sets or union-find data structures for player O and player X
     *
     * @param boardHorizontalSize the board horizontal size.
     * @param boardVerticalSize the board vertical size.
     */
    private void initializeBoard(int boardHorizontalSize, int boardVerticalSize) {
        this.boardHorizontalSize = boardHorizontalSize;
        this.boardVerticalSize = boardVerticalSize;
        int numberOfElements = boardHorizontalSize * boardVerticalSize;

        int indexOfTopLeftField = 0;
        int indexOfTopRightField = boardHorizontalSize - 1;
        int indexOfBottomLeftField = boardHorizontalSize * (boardVerticalSize - 1);

        parentO = new int[numberOfElements];
        for (int i = 0; i < numberOfElements; i++) { //Consider using Arrays.setAll(int[] array, IntUnaryOperator generator)
            parentO[i] = i;
        }
        parentX = parentO.clone();

        sizeO = new int[numberOfElements];
        for (int i = 0; i < numberOfElements; i++) { //Consider using Arrays.fill(int[] a, int val)
            sizeO[i] = 1;
        }
        sizeX = sizeO.clone();

        //Makes the top left field the representative of all the fields of the top. And makes the bottom left field
        //the representation of all the fields of the bottom. In the future, by just checking if the top left field
        //and the bottom left field have the same representatives (are connected), we will be able to determine if
        //the top and bottom side are connected, therefore determine if player O won.
        for (int i = 1; i < boardHorizontalSize; i++) {
            unionO(indexOfTopLeftField, i);
            unionO(indexOfBottomLeftField, indexOfBottomLeftField + i);
        }

        //Makes the top left field the representative of all the fields of the left. And makes the top right field
        //the representation of all the fields of the right. In the future, by just checking if the top left field
        //and the top right field have the same representatives (are connected), we will be able to determine if
        //the left and right side are connected, therefore determine if player X won.
        for (int i = 1; i < boardVerticalSize; i++) {
            unionX(indexOfTopLeftField, i * boardHorizontalSize);
            unionX(indexOfTopRightField, indexOfTopRightField + (i * boardHorizontalSize));
        }

        playedO = new boolean[numberOfElements]; //Java default boolean to false. So all the elements of the array are initialized to false by default.
        playedX = new boolean[numberOfElements];
    }

    /**
     * Returns the parent or representative of an element, searching within the disjoint-set of a player.
     *
     * @param element an element
     * @param parent  the disjoint-set of the player
     * @return the parent or representative of the {@code element}
     */
    private int find(int element, int[] parent) {
        while (element != parent[element]) {
            parent[element] = parent[parent[element]];
            element = parent[element];
        }
        return element;
    }

    private int findX(int x) {
        return find(x, parentX);
    }

    private int findO(int o) {
        return find(o, parentO);
    }

    /**
     * Merges the two subsets of a disjoint-set. Connects element a with element b, or merges the subset containing
     * elementA with the subset containing elementB.
     *
     * @param elementA one element
     * @param elementB the other element
     * @param parent   the disjoint-set of the player or the parent array
     * @param size     the sizes of each subset of the disjoint-set
     */
    private void union(int elementA, int elementB, int[] parent, int[] size) {
        int parentA = find(elementA, parent);
        int parentB = find(elementB, parent);
        if (parentA == parentB) return;

        // make smaller root point to larger one
        if (size[parentA] < size[parentB]) {
            parent[parentA] = parentB;
            size[parentB] += size[parentA];
        } else {
            parent[parentB] = parentA;
            size[parentA] += size[parentB];
        }
    }

    private void unionX(int xA, int xB) {
        union(xA, xB, parentX, sizeX);
    }

    private void unionO(int oA, int oB) {
        union(oA, oB, parentO, sizeO);
    }

    /**
     * Determine if a stone has been placed on any field of the board
     * @param row the row on which the field is found
     * @param col the column on which the field is found
     * @return true if a player has placed a stone on this field, otherwise false.
     */
    private boolean isPlayed(int row, int col) {
        int index = (row - 1) * boardHorizontalSize + col - 1;
        return playedO[index] || playedX[index];
    }

    private boolean isPlayed(int row, int col, boolean[] played) {
        return played[(row - 1) * boardHorizontalSize + col - 1];
    }

    private void connect(int rowa, int cola, int rowb, int colb, int[] parent, int[] size) {
        int indexOfA = ((rowa - 1) * boardHorizontalSize) + cola - 1;
        int indexOfB = ((rowb - 1) * boardHorizontalSize) + colb - 1;
        union(indexOfA, indexOfB, parent, size);
    }

    /**
     * Play or place a stone on a field for a specific player
     * @param row the row of the field
     * @param col the column of the field
     * @param parent the disjoint-set of the player
     * @param size the sizes of subsets of the disjoint-set
     * @param played this helps us keep track of the field on which the player has placed a stone
     */
    private void play(int row, int col, int[] parent, int[] size, boolean[] played) {
        if(isPlayed(row, col)) {
            return;
        }
        int index = ((row - 1) * boardHorizontalSize) + col - 1;
        played[index] = true;

        //Check if the player has a stone on the field at the top, then connect it to this field
        if (row > 1 && isPlayed(row - 1, col, played)) {
            connect(row, col, row - 1, col, parent, size);
        }
        //Check if the player has a stone on the field at the top-right, then connect it to this field
        if (row > 1 && col < boardHorizontalSize && isPlayed(row - 1, col + 1, played)) {
            connect(row, col, row - 1, col + 1, parent, size);
        }

        //Check if the player has a stone on the field at the bottom, then connect it to this field
        if (row < boardVerticalSize && isPlayed(row + 1, col, played)) {
            connect(row, col, row + 1, col, parent, size);
        }
        //Check if the player has a stone on the field at the bottom-left, then connect it to this field
        if (row < boardVerticalSize && col > 1 && isPlayed(row + 1, col - 1, played)) {
            connect(row, col, row + 1, col, parent, size);
        }

        //Check if the player has a stone on the field on the left, then connect it to this field
        if (col > 1 && isPlayed(row, col - 1, played)) {
            connect(row, col, row, col - 1, parent, size);
        }
        //Check if the player has a stone on the field on the right, then connect it to this field
        if (col < boardHorizontalSize && isPlayed(row, col + 1, played)) {
            connect(row, col, row, col + 1, parent, size);
        }
    }

    private void playO(int row, int col) {
        play(row, col, parentO, sizeO, playedO);
    }

    private void playX(int row, int col) {
        play(row, col, parentX, sizeX, playedX);
    }

    enum Winner {
        PLAYER_O,
        PLAYER_X,
        NONE
    }
}
