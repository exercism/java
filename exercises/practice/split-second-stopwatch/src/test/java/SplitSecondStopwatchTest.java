import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class SplitSecondStopwatchTest {
    @Test
    @DisplayName("new stopwatch starts in ready state")
    public void newStopwatchStartsInReadyState() {
        SplitSecondStopwatch stopwatch = new SplitSecondStopwatch();
        assertThat(stopwatch.state()).isEqualTo("ready");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("new stopwatch's current lap has no elapsed time")
    public void newStopwatchCurrentLapHasNoElapsedTime() {
        SplitSecondStopwatch stopwatch = new SplitSecondStopwatch();
        assertThat(stopwatch.currentLap()).isEqualTo("00:00:00");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("new stopwatch's total has no elapsed time")
    public void newStopwatchTotalHasNoElapsedTime() {
        SplitSecondStopwatch stopwatch = new SplitSecondStopwatch();
        assertThat(stopwatch.total()).isEqualTo("00:00:00");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("new stopwatch does not have previous laps")
    public void newStopwatchDoesNotHavePreviousLaps() {
        SplitSecondStopwatch stopwatch = new SplitSecondStopwatch();
        assertThat(stopwatch.previousLaps()).isEmpty();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("start from ready state changes state to running")
    public void startFromReadyStateChangesStateToRunning() {
        SplitSecondStopwatch stopwatch = new SplitSecondStopwatch();
        stopwatch.start();
        assertThat(stopwatch.state()).isEqualTo("running");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("start does not change previous laps")
    public void startDoesNotChangePreviousLaps() {
        SplitSecondStopwatch stopwatch = new SplitSecondStopwatch();
        stopwatch.start();
        assertThat(stopwatch.previousLaps()).isEmpty();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("start initiates time tracking for current lap")
    public void startInitiatesTimeTrackingForCurrentLap() {
        SplitSecondStopwatch stopwatch = new SplitSecondStopwatch();
        stopwatch.start();
        stopwatch.advanceTime("00:00:05");
        assertThat(stopwatch.currentLap()).isEqualTo("00:00:05");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("start initiates time tracking for total")
    public void startInitiatesTimeTrackingForTotal() {
        SplitSecondStopwatch stopwatch = new SplitSecondStopwatch();
        stopwatch.start();
        stopwatch.advanceTime("00:00:23");
        assertThat(stopwatch.total()).isEqualTo("00:00:23");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("start cannot be called from running state")
    public void startCannotBeCalledFromRunningState() {
        SplitSecondStopwatch stopwatch = new SplitSecondStopwatch();
        stopwatch.start();
        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(stopwatch::start)
                .withMessage("cannot start an already running stopwatch");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("stop from running state changes state to stopped")
    public void stopFromRunningStateChangesStateToStopped() {
        SplitSecondStopwatch stopwatch = new SplitSecondStopwatch();
        stopwatch.start();
        stopwatch.stop();
        assertThat(stopwatch.state()).isEqualTo("stopped");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("stop pauses time tracking for current lap")
    public void stopPausesTimeTrackingForCurrentLap() {
        SplitSecondStopwatch stopwatch = new SplitSecondStopwatch();
        stopwatch.start();
        stopwatch.advanceTime("00:00:05");
        stopwatch.stop();
        stopwatch.advanceTime("00:00:08");
        assertThat(stopwatch.currentLap()).isEqualTo("00:00:05");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("stop pauses time tracking for total")
    public void stopPausesTimeTrackingForTotal() {
        SplitSecondStopwatch stopwatch = new SplitSecondStopwatch();
        stopwatch.start();
        stopwatch.advanceTime("00:00:13");
        stopwatch.stop();
        stopwatch.advanceTime("00:00:44");
        assertThat(stopwatch.total()).isEqualTo("00:00:13");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("stop cannot be called from ready state")
    public void stopCannotBeCalledFromReadyState() {
        SplitSecondStopwatch stopwatch = new SplitSecondStopwatch();
        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(stopwatch::stop)
                .withMessage("cannot stop a stopwatch that is not running");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("stop cannot be called from stopped state")
    public void stopCannotBeCalledFromStoppedState() {
        SplitSecondStopwatch stopwatch = new SplitSecondStopwatch();
        stopwatch.start();
        stopwatch.stop();
        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(stopwatch::stop)
                .withMessage("cannot stop a stopwatch that is not running");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("start from stopped state changes state to running")
    public void startFromStoppedStateChangesStateToRunning() {
        SplitSecondStopwatch stopwatch = new SplitSecondStopwatch();
        stopwatch.start();
        stopwatch.stop();
        stopwatch.start();
        assertThat(stopwatch.state()).isEqualTo("running");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("start from stopped state resumes time tracking for current lap")
    public void startFromStoppedStateResumesTimeTrackingForCurrentLap() {
        SplitSecondStopwatch stopwatch = new SplitSecondStopwatch();
        stopwatch.start();
        stopwatch.advanceTime("00:01:20");
        stopwatch.stop();
        stopwatch.advanceTime("00:00:20");
        stopwatch.start();
        stopwatch.advanceTime("00:00:08");
        assertThat(stopwatch.currentLap()).isEqualTo("00:01:28");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("start from stopped state resumes time tracking for total")
    public void startFromStoppedStateResumesTimeTrackingForTotal() {
        SplitSecondStopwatch stopwatch = new SplitSecondStopwatch();
        stopwatch.start();
        stopwatch.advanceTime("00:00:23");
        stopwatch.stop();
        stopwatch.advanceTime("00:00:44");
        stopwatch.start();
        stopwatch.advanceTime("00:00:09");
        assertThat(stopwatch.total()).isEqualTo("00:00:32");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("lap adds current lap to previous laps")
    public void lapAddsCurrentLapToPreviousLaps() {
        SplitSecondStopwatch stopwatch = new SplitSecondStopwatch();
        stopwatch.start();
        stopwatch.advanceTime("00:01:38");
        stopwatch.lap();
        assertThat(stopwatch.previousLaps()).containsExactly("00:01:38");
        stopwatch.advanceTime("00:00:44");
        stopwatch.lap();
        assertThat(stopwatch.previousLaps()).containsExactly("00:01:38", "00:00:44");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("lap resets current lap and resumes time tracking")
    public void lapResetsCurrentLapAndResumesTimeTracking() {
        SplitSecondStopwatch stopwatch = new SplitSecondStopwatch();
        stopwatch.start();
        stopwatch.advanceTime("00:08:22");
        stopwatch.lap();
        assertThat(stopwatch.currentLap()).isEqualTo("00:00:00");
        stopwatch.advanceTime("00:00:15");
        assertThat(stopwatch.currentLap()).isEqualTo("00:00:15");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("lap continues time tracking for total")
    public void lapContinuesTimeTrackingForTotal() {
        SplitSecondStopwatch stopwatch = new SplitSecondStopwatch();
        stopwatch.start();
        stopwatch.advanceTime("00:00:22");
        stopwatch.lap();
        stopwatch.advanceTime("00:00:33");
        assertThat(stopwatch.total()).isEqualTo("00:00:55");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("lap cannot be called from ready state")
    public void lapCannotBeCalledFromReadyState() {
        SplitSecondStopwatch stopwatch = new SplitSecondStopwatch();
        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(stopwatch::lap)
                .withMessage("cannot lap a stopwatch that is not running");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("lap cannot be called from stopped state")
    public void lapCannotBeCalledFromStoppedState() {
        SplitSecondStopwatch stopwatch = new SplitSecondStopwatch();
        stopwatch.start();
        stopwatch.stop();
        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(stopwatch::lap)
                .withMessage("cannot lap a stopwatch that is not running");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("stop does not change previous laps")
    public void stopDoesNotChangePreviousLaps() {
        SplitSecondStopwatch stopwatch = new SplitSecondStopwatch();
        stopwatch.start();
        stopwatch.advanceTime("00:11:22");
        stopwatch.lap();
        assertThat(stopwatch.previousLaps()).containsExactly("00:11:22");
        stopwatch.stop();
        assertThat(stopwatch.previousLaps()).containsExactly("00:11:22");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("reset from stopped state changes state to ready")
    public void resetFromStoppedStateChangesStateToReady() {
        SplitSecondStopwatch stopwatch = new SplitSecondStopwatch();
        stopwatch.start();
        stopwatch.stop();
        stopwatch.reset();
        assertThat(stopwatch.state()).isEqualTo("ready");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("reset resets current lap")
    public void resetResetsCurrentLap() {
        SplitSecondStopwatch stopwatch = new SplitSecondStopwatch();
        stopwatch.start();
        stopwatch.advanceTime("00:00:10");
        stopwatch.stop();
        stopwatch.reset();
        assertThat(stopwatch.currentLap()).isEqualTo("00:00:00");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("reset clears previous laps")
    public void resetClearsPreviousLaps() {
        SplitSecondStopwatch stopwatch = new SplitSecondStopwatch();
        stopwatch.start();
        stopwatch.advanceTime("00:00:10");
        stopwatch.lap();
        stopwatch.advanceTime("00:00:20");
        stopwatch.lap();
        assertThat(stopwatch.previousLaps()).containsExactly("00:00:10", "00:00:20");
        stopwatch.stop();
        stopwatch.reset();
        assertThat(stopwatch.previousLaps()).isEmpty();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("reset cannot be called from ready state")
    public void resetCannotBeCalledFromReadyState() {
        SplitSecondStopwatch stopwatch = new SplitSecondStopwatch();
        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(stopwatch::reset)
                .withMessage("cannot reset a stopwatch that is not stopped");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("reset cannot be called from running state")
    public void resetCannotBeCalledFromRunningState() {
        SplitSecondStopwatch stopwatch = new SplitSecondStopwatch();
        stopwatch.start();
        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(stopwatch::reset)
                .withMessage("cannot reset a stopwatch that is not stopped");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("supports very long laps")
    public void supportsVeryLongLaps() {
        SplitSecondStopwatch stopwatch = new SplitSecondStopwatch();
        stopwatch.start();
        stopwatch.advanceTime("01:23:45");
        assertThat(stopwatch.currentLap()).isEqualTo("01:23:45");
        stopwatch.lap();
        assertThat(stopwatch.previousLaps()).containsExactly("01:23:45");
        stopwatch.advanceTime("04:01:40");
        assertThat(stopwatch.currentLap()).isEqualTo("04:01:40");
        assertThat(stopwatch.total()).isEqualTo("05:25:25");
        stopwatch.lap();
        assertThat(stopwatch.previousLaps()).containsExactly("01:23:45", "04:01:40");
        stopwatch.advanceTime("08:43:05");
        assertThat(stopwatch.currentLap()).isEqualTo("08:43:05");
        assertThat(stopwatch.total()).isEqualTo("14:08:30");
        stopwatch.lap();
        assertThat(stopwatch.previousLaps()).containsExactly("01:23:45", "04:01:40", "08:43:05");
    }
}
