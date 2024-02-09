package utils;

public class Wizard extends ReflectionProxy {

    @Override
    public String getTargetClassName() {
        return "Wizard";
    }
    
    public String toString() {
        try {
            return invokeMethod("toString", new Class[]{String.class});
        } catch (Exception e) {
            throw new UnsupportedOperationException("Please implement the toString() method");
        }
    }

    public boolean isVulnerable() {
        try {
            return invokeMethod("isVulnerable", new Class[]{Boolean.class});
        } catch (Exception e) {
            throw new UnsupportedOperationException("Please implement the isVulnerable() method");
        }
    }

    public int getDamagePoints(Fighter warrior) {
        try {
            return invokeMethod("getDamagePoints", new Class[]{int.class}, warrior);
        } catch (Exception e) {
            throw new UnsupportedOperationException("Please implement the getDamagePoints(Fighter) method");
        }
    }

    public void prepareSpell() {
        try {
            invokeMethod("prepareSpell", new Class[]{void.class});
        } catch (Exception e) {
            throw new UnsupportedOperationException("Please implement the prepareSpell() method");
        }
    }
}
