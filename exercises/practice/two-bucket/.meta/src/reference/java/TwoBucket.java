import java.util.ArrayList;
import java.util.Objects;

class TwoBucket {

    private class State {
        int moves;
        int bucketOne;
        int bucketTwo;

        State (int moves, int bucketOne, int bucketTwo) {
            this.moves = moves;
            this.bucketOne = bucketOne;
            this.bucketTwo = bucketTwo;
        }

        @Override
        public boolean equals(Object o) {
            State otherState = (State) o;
            return this.moves == otherState.moves &&
                    this.bucketOne == otherState.bucketOne &&
                    this.bucketTwo == otherState.bucketTwo;
        }

        @Override
        public int hashCode() {
            return Objects.hash(moves, bucketOne, bucketTwo);
        }
    }

    private State finalState;

    private int bucketOneCap;
    private int bucketTwoCap;
    private int desiredLiters;
    private String startBucket;

    TwoBucket(int bucketOneCap, int bucketTwoCap, int desiredLiters, String startBucket) {
        this.bucketOneCap = bucketOneCap;
        this.bucketTwoCap = bucketTwoCap;
        this.desiredLiters = desiredLiters;
        this.startBucket = startBucket;

        finalState = computeFinalState();
    }

    private ArrayList<State> getAdjacentStates (State state) {
        ArrayList<State> adjacentStates = new ArrayList<State>();

        //Empty bucket one
        adjacentStates.add(new State(state.moves + 1, 0, state.bucketTwo));

        //Empty bucket two
        adjacentStates.add(new State(state.moves + 1, state.bucketOne, 0));

        //Fill bucket one
        adjacentStates.add(new State(state.moves + 1, bucketOneCap, state.bucketTwo));

        //Fill bucket two
        adjacentStates.add(new State(state.moves + 1, state.bucketOne, bucketTwoCap));

        //pour from bucket one to bucket two
        if (state.bucketOne + state.bucketTwo > bucketTwoCap) {
            adjacentStates.add(new State(state.moves + 1,
                                         state.bucketOne - (bucketTwoCap - state.bucketTwo),
                                         bucketTwoCap));
        } else {
            adjacentStates.add(new State(state.moves + 1, 0, state.bucketOne + state.bucketTwo));
        }

        //pour from bucket two to bucket one
        if (state.bucketTwo + state.bucketOne > bucketOneCap) {
            adjacentStates.add(new State(state.moves + 1,
                                         bucketOneCap,
                                         state.bucketTwo - (bucketOneCap - state.bucketOne)));
        } else {
            adjacentStates.add(new State(state.moves + 1, state.bucketTwo + state.bucketOne, 0));
        }

        return adjacentStates;
    }

    private boolean isValid(State state) {
        if (state.bucketOne == bucketOneCap && state.bucketTwo == 0 && startBucket.equals("two")) {
            return false;
        } else if (state.bucketOne == 0 && state.bucketTwo == bucketTwoCap && startBucket.equals("two")) {
            return false;
        } else {
            return true;
        }
    }

    private State computeFinalState() {
        ArrayList<State> paths = new ArrayList<State>();

        State initialState;
        if (startBucket.equals("one")) {
            initialState = new State(1, bucketOneCap, 0);
        } else {
            initialState = new State(1, 0, bucketTwoCap);
        }

        if (initialState.bucketOne == desiredLiters || initialState.bucketTwo == desiredLiters) {
            return initialState;
        }

        paths.add(initialState);

        for (int i = 0; i < 10000; i++) {
            State currentState = paths.remove(0);
            ArrayList<State> adjacentStates = getAdjacentStates(currentState);
            for (State state : adjacentStates) {
                if (state.bucketOne == desiredLiters || state.bucketTwo == desiredLiters) {
                    return state;
                }

                if (!paths.contains(state) && isValid(state)) {
                    paths.add(state);
                }
            }
        }

        return null;
    }

    int getTotalMoves() {
        return finalState.moves;
    }

    String getFinalBucket() {
        if (finalState.bucketOne == desiredLiters) {
            return "one";
        } else if (finalState.bucketTwo == desiredLiters) {
            return "two";
        } else {
            return "No solution found in " + finalState.moves + " iterations!";
        }
    }

    int getOtherBucket() {
        if (getFinalBucket().equals("one")) {
            return finalState.bucketTwo;
        } else if (getFinalBucket().equals("two")) {
            return finalState.bucketOne;
        } else {
            return -1;
        }
    }
}
