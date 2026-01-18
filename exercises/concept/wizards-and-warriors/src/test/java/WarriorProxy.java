class WarriorProxy extends ReflectionProxy {

    @Override
    public String getTargetClassName() {
        return "Warrior";
    }
    
    public String toString() {
        return invokeMethod("toString", String.class, new Class[0]);
    }

    boolean isVulnerable() {
        return invokeMethod("isVulnerable", Boolean.class, new Class[0]);
    }

    int getDamagePoints(Fighter target) {
        return invokeMethod("getDamagePoints", Integer.class, new Class[]{Fighter.class}, target);
    }
}
