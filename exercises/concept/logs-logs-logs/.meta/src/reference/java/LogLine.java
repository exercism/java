public class LogLine {
    private final LogLevel level;
    private final String message;

    public LogLine(String logLine) {
        this.level = switch (logLine.substring(1, 4)) {
            case "TRC" -> LogLevel.TRACE;
            case "DBG" -> LogLevel.DEBUG;
            case "INF" -> LogLevel.INFO;
            case "WRN" -> LogLevel.WARNING;
            case "ERR" -> LogLevel.ERROR;
            case "FTL" -> LogLevel.FATAL;
            default -> LogLevel.UNKNOWN;
        };

        this.message = logLine.substring(7);
    }

    public LogLevel getLogLevel() {
        return this.level;
    }

    public String getOutputForShortLog() {
        return String.valueOf(this.level.getEncodedLevel()) + ":" + this.message;
    }
}
