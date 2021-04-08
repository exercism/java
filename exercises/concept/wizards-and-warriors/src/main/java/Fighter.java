abstract class Fighter {

    boolean isVulnerable() {
        throw new UnsupportedOperationException("Please provide implementation for this method");
    }

    abstract int damagePoints(Fighter fighter);

}

class Warrior extends WizardsAndWarriors {

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Please implement the toString() method with the required text");
    }

    @Override
    int damagePoints(Fighter wizard) {
        throw new UnsupportedOperationException("Please implement Warrior.damagePoints() method");
    }
}

class Wizard extends WizardsAndWarriors {

    @Override
    boolean isVulnerable() {
        throw new UnsupportedOperationException("Please implement Wizard.isVulnerable() method");
    }

    @Override
    int damagePoints(Fighter warrior) {
        throw new UnsupportedOperationException("Please implement Wizard.damagePoints() method");
    }

    void prepareSpell() {
        throw new UnsupportedOperationException("Please implement Wizard.prepareSpell() method");
    }

}
