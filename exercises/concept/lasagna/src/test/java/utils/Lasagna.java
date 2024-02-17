package utils;

public class Lasagna extends ReflectionProxy {

    @Override
    public String getTargetClassName() {
        return "Lasagna";
    }

    public int expectedMinutesInOven() {
        return invokeMethod("expectedMinutesInOven", new Class[]{});
    }

    public int remainingMinutesInOven(int actualMinutes) {
        return invokeMethod("remainingMinutesInOven", new Class[]{int.class}, actualMinutes);
    }

    public int preparationTimeInMinutes(int amountLayers) {
        return invokeMethod("preparationTimeInMinutes", new Class[]{int.class}, amountLayers);
    }

    public int totalTimeInMinutes(int amountLayers, int actualMinutes) {
        return invokeMethod("totalTimeInMinutes", new Class[]{int.class, int.class}, amountLayers, actualMinutes);
    }
}
