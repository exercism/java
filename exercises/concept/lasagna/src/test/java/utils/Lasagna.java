package utils;

public class Lasagna extends ReflectionProxy {

    @Override
    public String getTargetClassName() {
        return "Lasagna";
    }

    public int expectedMinutesInOven() {
        return invokeMethod("expectedMinutesInOven", Integer.class, new Class[]{});
    }

    public int remainingMinutesInOven(int actualMinutes) {
        return invokeMethod("remainingMinutesInOven", Integer.class, new Class[]{int.class}, actualMinutes);
    }

    public int preparationTimeInMinutes(int amountLayers) {
        return invokeMethod("preparationTimeInMinutes", Integer.class, new Class[]{int.class}, amountLayers);
    }

    public int totalTimeInMinutes(int amountLayers, int actualMinutes) {
        return invokeMethod("totalTimeInMinutes", Integer.class, new Class[]{int.class, int.class},
                amountLayers, actualMinutes);
    }
}
