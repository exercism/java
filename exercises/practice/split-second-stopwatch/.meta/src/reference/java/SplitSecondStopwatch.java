import java.util.ArrayList;
import java.util.List;

public class SplitSecondStopwatch {

    /**
     * A split-second stopwatch that tracks elapsed time with lap functionality.
     * Supports start, stop, reset, and lap operations with precise time tracking.
     * Times are formatted in HH:MM:SS format with two-digit precision.
     *
     * @see <a href="https://github.com/exercism/problem-specifications/tree/main/exercises/split-second-stopwatch">
     * Problem Specifications
     * </a>
     */

    private enum State { READY, RUNNING, STOPPED }

    private State state;
    private long totalCompletedLaps;  // Total time from completed laps
    private long currentLapStart;     // When current lap started
    private long accumulated;         // Accumulated time for current lap when stopped
    private List<String> previousLaps;
    private long mockTime;

    public SplitSecondStopwatch() {
        this.state = State.READY;
        this.totalCompletedLaps = 0;
        this.currentLapStart = 0;
        this.accumulated = 0;
        this.previousLaps = new ArrayList<>();
        this.mockTime = 0;
    }

    public void start() {
        if (state == State.RUNNING) {
            throw new IllegalStateException("cannot start an already running stopwatch");
        }

        currentLapStart = mockTime;
        state = State.RUNNING;
    }

    public void stop() {
        if (state != State.RUNNING) {
            throw new IllegalStateException("cannot stop a stopwatch that is not running");
        }

        accumulated += mockTime - currentLapStart;
        state = State.STOPPED;
    }

    public void reset() {
        if (state != State.STOPPED) {
            throw new IllegalStateException("cannot reset a stopwatch that is not stopped");
        }

        state = State.READY;
        totalCompletedLaps = 0;
        currentLapStart = 0;
        accumulated = 0;
        previousLaps.clear();
    }

    public void lap() {
        if (state != State.RUNNING) {
            throw new IllegalStateException("cannot lap a stopwatch that is not running");
        }

        long currentLapTime = getCurrentLapTime();
        totalCompletedLaps += currentLapTime;
        previousLaps.add(formatTime(currentLapTime));

        // Reset current lap and restart
        accumulated = 0;
        currentLapStart = mockTime;
    }

    public String state() {
        return state.name().toLowerCase();
    }

    public String currentLap() {
        return formatTime(getCurrentLapTime());
    }

    public String total() {
        return formatTime(totalCompletedLaps + getCurrentLapTime());
    }

    public List<String> previousLaps() {
        return new ArrayList<>(previousLaps);
    }

    public void advanceTime(String timeString) {
        String[] parts = timeString.split(":");
        long hours = Long.parseLong(parts[0]);
        long minutes = Long.parseLong(parts[1]);
        long seconds = Long.parseLong(parts[2]);

        long milliseconds = (hours * 3600 + minutes * 60 + seconds) * 1000;
        mockTime += milliseconds;
    }

    private long getCurrentLapTime() {
        switch (state) {
            case READY:
                return 0;
            case RUNNING:
                return accumulated + (mockTime - currentLapStart);
            case STOPPED:
                return accumulated;
            default:
                throw new IllegalStateException("Invalid state");
        }
    }

    private String formatTime(long milliseconds) {
        long totalSeconds = milliseconds / 1000;
        long hours = totalSeconds / 3600;
        long minutes = (totalSeconds % 3600) / 60;
        long seconds = totalSeconds % 60;

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}
