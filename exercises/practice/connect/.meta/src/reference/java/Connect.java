
class Connect {

    public Winner computeWinner(String[] board) {
        return Winner.NONE;
    }

    enum Winner {
        PLAYER_X,
        PLAYER_O,
        NONE
    }

    /**
     * To solve our exercise, we are going to model our board as a disjoint-set data structure, also called a
     * union-find data structure or merge-find set.
     * For additional documentation, check
     * <a href="https://en.wikipedia.org/wiki/Disjoint-set_data_structure">Wikipedia Disjoint-set Data Structure</a>
     * or <a href="https://algs4.cs.princeton.edu/15uf">Section 1.5</a> of
     * <i>Algorithms, 4th Edition, A nice book on DSA</i> by Robert Sedgewick and Kevin Wayne.
     */
    private static class Board {
        private final int[] parent;   // parent[i] = The representatives or parents of every element i.
        private final int[] size;     // size[i] = number of elements in every subset with i as the root (NB: root not parent or representative).

        /**
         * Create a disjoint set or union-find data structure
         * Initially, each element is, in its own set and its own representative or parent.
         *
         * @param  numberOfElements the number of elements
         */
        public Board(int numberOfElements) {
            parent = new int[numberOfElements];
            size = new int[numberOfElements];
            for(int i = 0; i < numberOfElements; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        /**
         * Returns the parent or representative of the set containing the element.
         *
         * @param  element an element
         * @return he parent or representative of the set containing the element {@code element}
         */
        public int find(int element) {
            while (element != parent[element]) {
                parent[element] = parent[parent[element]];
                element = parent[element];
            }
            return element;
        }

        /**
         * Merges the set containing elementA with
         * the set containing elementB.
         *
         * @param  elementA one element
         * @param  elementB the other element
         */
        public void union(int elementA, int elementB) {
            int parentA = find(elementA);
            int parentB = find(elementB);
            if (parentA == parentB) return;

            // make smaller root point to larger one
            if (size[parentA] < size[parentB]) {
                parent[parentA] = parentB;
                size[parentB] += size[parentA];
            }
            else {
                parent[parentB] = parentA;
                size[parentA] += size[parentB];
            }
        }
    }
}
