package utils;

public class Warrior extends ReflectionProxy {

    @Override
    public String getTargetClassName() {
        return "Warrior";
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

    public int getDamagePoints(Fighter wizard) {
        try {
            return invokeMethod("getDamagePoints", new Class[]{int.class}, wizard);
        } catch (Exception e) {
            throw new UnsupportedOperationException("Please implement the getDamagePoints(Fighter) method");
        }
    }
}
