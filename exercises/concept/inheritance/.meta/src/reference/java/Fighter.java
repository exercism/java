abstract class Fighter {

    /**
     * this method sets the default vulnerability to false for all the child classes.
     *
     * @return the vulnerability i.e false.
     */
    boolean isVulnerable() {
        return false;
    }

    abstract int damagePoints(Fighter fighter);

}

class Warrior extends Fighter {

    @Override
    public String toString() {
        return "Fighter is a Warrior";
    }

    @Override
    int damagePoints(Fighter wizard) {
        if (wizard.isVulnerable()) {
            return 10;
        } else {
            return 6;
        }
    }
}

class Wizard extends Fighter {

    boolean isSpellPrepared = false;

    @Override
    boolean isVulnerable() {
        if (isSpellPrepared == false) {
            return true;
        }
        return false;
    }

    @Override
    int damagePoints(Fighter warrior) {
        if (isSpellPrepared) {
            return 12;
        } else {
            return 3;
        }
    }

    void prepareSpell() {
        isSpellPrepared = true;
    }

}
