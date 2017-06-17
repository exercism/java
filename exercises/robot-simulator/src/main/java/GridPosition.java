class GridPosition {

    final int x;

    final int y;

    GridPosition(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    /*
     * This equals method is of deliberately narrow scope (only allows comparison with another GridPosition) to increase
     * readability. In general, one should provide a full implementation of Object.equals(Object obj) and a
     * corresponding implementation of Object.hashCode(). See
     *
     * https://docs.oracle.com/javase/7/docs/api/java/lang/Object.html#equals(java.lang.Object)
     *
     * and
     *
     * https://docs.oracle.com/javase/7/docs/api/java/lang/Object.html#hashCode()
     *
     * for more information.
     */
    boolean equals(final GridPosition gridPosition) {
        return this.x == gridPosition.x && this.y == gridPosition.y;
    }

}
