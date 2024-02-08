abstract class Fighter {

    boolean isVulnerable() {
        throw new UnsupportedOperationException("Please provide implementation for this method");
    }

    abstract int damagePoints(Fighter fighter);

}
