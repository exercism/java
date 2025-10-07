import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HandshakeCalculatorTest {

    private final HandshakeCalculator handshakeCalculator = new HandshakeCalculator();

    @Test
    @DisplayName("wink for 1")
    public void testThatInput1YieldsAWink() {
        assertThat(handshakeCalculator.calculateHandshake(1)).containsExactly(Signal.WINK);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("double blink for 10")
    public void testThatInput2YieldsADoubleBlink() {
        assertThat(handshakeCalculator.calculateHandshake(2)).containsExactly(Signal.DOUBLE_BLINK);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("close your eyes for 100")
    public void testThatInput4YieldsACloseYourEyes() {
        assertThat(handshakeCalculator.calculateHandshake(4)).containsExactly(Signal.CLOSE_YOUR_EYES);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("jump for 1000")
    public void testThatInput8YieldsAJump() {
        assertThat(handshakeCalculator.calculateHandshake(8)).containsExactly(Signal.JUMP);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("combine two actions")
    public void testAnInputThatYieldsTwoActions() {
        assertThat(handshakeCalculator.calculateHandshake(3))
                .containsExactly(Signal.WINK, Signal.DOUBLE_BLINK);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("reverse two actions")
    public void testAnInputThatYieldsTwoReversedActions() {
        assertThat(handshakeCalculator.calculateHandshake(19))
                .containsExactly(Signal.DOUBLE_BLINK, Signal.WINK);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("reversing one action gives the same action")
    public void testReversingASingleActionYieldsTheSameAction() {
        assertThat(handshakeCalculator.calculateHandshake(24)).containsExactly(Signal.JUMP);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("reversing no actions still gives no actions")
    public void testReversingNoActionsYieldsNoActions() {
        assertThat(handshakeCalculator.calculateHandshake(16)).isEmpty();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("all possible actions")
    public void testInputThatYieldsAllActions() {
        assertThat(handshakeCalculator.calculateHandshake(15))
                .containsExactly(Signal.WINK, Signal.DOUBLE_BLINK, Signal.CLOSE_YOUR_EYES, Signal.JUMP);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("reverse all possible actions")
    public void testInputThatYieldsAllActionsReversed() {
        assertThat(handshakeCalculator.calculateHandshake(31))
                .containsExactly(Signal.JUMP, Signal.CLOSE_YOUR_EYES, Signal.DOUBLE_BLINK, Signal.WINK);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("do nothing for zero")
    public void testThatInput0YieldsNoActions() {
        assertThat(handshakeCalculator.calculateHandshake(0)).isEmpty();
    }

    /* The following tests diverge from the canonical test data to test numbers with binary representation with 
     * more than five digits are correctly handled. For more details, check out issue #1965 here:
     * (https://github.com/exercism/java/issues/1965).
     */
    @Disabled("Remove to run test")
    @Test
    @DisplayName("handles input with more than five bits with reversal")
    public void testThatHandlesMoreThanFiveBinaryPlacesWithReversal() {
        assertThat(handshakeCalculator.calculateHandshake(51))
            .containsExactly(Signal.DOUBLE_BLINK, Signal.WINK);
    }
    
    @Disabled("Remove to run test")
    @Test
    @DisplayName("handles input with more than five bits without reversal")
    public void testThatHandlesMoreThanFiveBinaryPlacesWithoutReversal() {
        assertThat(handshakeCalculator.calculateHandshake(35))
            .containsExactly(Signal.WINK, Signal.DOUBLE_BLINK);
    }
    
    @Disabled("Remove to run test")
    @Test
    @DisplayName("all actions for input with more than five bits")
    public void testInputThatYieldsAllActionsFromMoreThanFiveBinaryPlaces() {
        assertThat(handshakeCalculator.calculateHandshake(111))
            .containsExactly(Signal.WINK, Signal.DOUBLE_BLINK, Signal.CLOSE_YOUR_EYES, Signal.JUMP);
    }

}
