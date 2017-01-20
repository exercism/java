import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class HandshakeCalculator {

    private static final int REVERSE_SIGNALS_BIT_POSITION = 4;

    List<Signal> calculateHandshake(final int number) {
        final List<Signal> result = new ArrayList<>();

        for (final Signal signal : Signal.values()) {
            if (isBitSet(signal.ordinal(), number)) {
                result.add(signal);
            }
        }

        if (isBitSet(REVERSE_SIGNALS_BIT_POSITION, number)) {
            Collections.reverse(result);
        }

        return result;
    }

    private boolean isBitSet(final int position, final int number) {
        return ((number >> position) & 1) == 1;
    }

}
