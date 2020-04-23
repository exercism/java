enum Plant {
    VIOLETS,
    RADISHES,
    CLOVER,
    GRASS;

    static Plant getPlant(char plantCode) {
        switch (plantCode) {
            case 'G':
                return GRASS;
            case 'C':
                return CLOVER;
            case 'R':
                return RADISHES;
            case 'V':
                return VIOLETS;
        }

        return null;
    }
}
