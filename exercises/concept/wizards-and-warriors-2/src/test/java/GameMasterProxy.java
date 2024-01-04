/**
 * This is a helper class to be able to run the tests for this exercise.
 * The tests are located in the {@link GameMasterTest} class.
 * @see GameMasterTest
 */
public class GameMasterProxy extends ReflectionProxy {

    @Override
    public String getTargetClassName() {
        return "GameMaster";
    }

    public String describe(Character character) {
        try {
            return invokeMethod("describe", new Class[]{Character.class}, character);
        } catch (Exception e) {
            throw new UnsupportedOperationException("Please implement the 'describe(Character character)' " +
                                                    "method");
        }
    }

    public String describe(Destination character) {
        try {
            return invokeMethod("describe", new Class[]{Destination.class}, character);
        } catch (Exception e) {
            throw new UnsupportedOperationException("Please implement the 'describe(Destination destination)' " +
                                                    "method");
        }
    }

    public String describe(TravelMethod character) {
        try {
            return invokeMethod("describe", new Class[]{TravelMethod.class}, character);
        } catch (Exception e) {
            throw new UnsupportedOperationException("Please implement the 'describe(TravelMethod travelMethod)' " +
                                                    "method");
        }
    }

    public String describe(Character character, Destination destination, TravelMethod travelMethod) {
        try {
            return invokeMethod("describe", new Class[]{Character.class, Destination.class, TravelMethod.class},
                    character, destination, travelMethod);
        } catch (Exception e) {
            throw new UnsupportedOperationException("Please implement the 'describe(Character character, Destination " +
                                                    "destination, TravelMethod travelMethod)' method");
        }
    }

    public String describe(Character character, Destination destination) {
        try {
            return invokeMethod("describe", new Class[]{Character.class, Destination.class},
                    character, destination);
        } catch (Exception e) {
            throw new UnsupportedOperationException("Please implement the 'describe(Character character, Destination " +
                                                    "destination)' method");
        }
    }

}
