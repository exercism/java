class WizardProxy extends ReflectionProxy {

    @Override
    public String getTargetClassName() {
        return "Wizard";
    }

    public String toString() {
        return invokeMethod("toString", new Class[0]);
    }

    boolean isVulnerable() {
        return invokeMethod("isVulnerable", new Class[0]);
    }

    int getDamagePoints(Fighter target) {
        return invokeMethod("getDamagePoints", new Class[]{Fighter.class}, target);
    }

    void prepareSpell() {
        invokeMethod("prepareSpell", new Class[0]);
    }
}
