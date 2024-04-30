/**
 * This is a helper class to be able to run the tests for this exercise.
 * The tests are located in the {@link GameMasterTest} class.
 * 
 * @see GameMasterTest
 */
public class GameMasterProxy extends ReflectionProxy {

    @Override
    public String getTargetClassName() {
        return "GameMaster";
    }

    public String describe(Character character) {
        return invokeMethod("describe", new Class[] { Character.class }, character);
    }

    public String describe(Destination character) {
        return invokeMethod("describe", new Class[] { Destination.class }, character);
    }

    public String describe(TravelMethod character) {
        return invokeMethod("describe", new Class[] { TravelMethod.class }, character);
    }

    public String describe(Character character, Destination destination, TravelMethod travelMethod) {
        return invokeMethod("describe", new Class[] { Character.class, Destination.class, TravelMethod.class },
                character, destination, travelMethod);
    }

    public String describe(Character character, Destination destination) {
        return invokeMethod("describe", new Class[] { Character.class, Destination.class }, character, destination);
    }
}
