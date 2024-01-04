public class GameMasterProxy extends ReflectionProxy {

    @Override
    public String getTargetClassName() {
        return "GameMaster";
    }

    public String describe(Character character) {
        try {
            return invokeMethod("describe", new Class[]{Character.class}, character);
        } catch (Exception e) {
            throw new UnsupportedOperationException("Please implement the 'describe(Character character)' static " +
                                                    "method");
        }
    }

    public String describe(Destination character) {
        try {
            return invokeMethod("describe", new Class[]{Destination.class}, character);
        } catch (Exception e) {
            throw new UnsupportedOperationException("Please implement the 'describe(Destination destination)' static " +
                                                    "method");
        }
    }

    public String describe(TravelMethod character) {
        try {
            return invokeMethod("describe", new Class[]{TravelMethod.class}, character);
        } catch (Exception e) {
            throw new UnsupportedOperationException("Please implement the 'describe(TravelMethod travelMethod)' " +
                                                    "static method");
        }
    }

    public String describe(Character character, Destination destination, TravelMethod travelMethod) {
        try {
            return invokeMethod("describe", new Class[]{Character.class, Destination.class, TravelMethod.class},
                    character, destination, travelMethod);
        } catch (Exception e) {
            throw new UnsupportedOperationException("Please implement the 'describe(Character character, Destination " +
                                                    "destination, TravelMethod travelMethod)' static method");
        }
    }

    public String describe(Character character, Destination destination) {
        try {
            return invokeMethod("describe", new Class[]{Character.class, Destination.class},
                    character, destination);
        } catch (Exception e) {
            throw new UnsupportedOperationException("Please implement the 'describe(Character character, Destination " +
                                                    "destination)' static method");
        }
    }

}
