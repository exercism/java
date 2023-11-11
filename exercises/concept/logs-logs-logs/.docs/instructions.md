public enum LogLevel {
    UNKNOWN,
    TRACE,
    DEBUG,
    INFO,
    WARNING,
    ERROR,
    FATAL
}

public class LogLine {
    private String logLine;

    public LogLine(String logLine) {
        this.logLine = logLine;
    }
    public LogLevel getLogLevel() {
        String logLevelStr = logLine.substring(logLine.indexOf("[") + 1, logLine.indexOf("]"));
        switch (logLevelStr) {
            case "TRC": return LogLevel.TRACE;
            case "DBG": return LogLevel.DEBUG;
            case "INF": return LogLevel.INFO;
            case "WRN": return LogLevel.WARNING;
            case "ERR": return LogLevel.ERROR;
            case "FTL": return LogLevel.FATAL;
            default: return LogLevel.UNKNOWN;
        }
    }

    public String getOutputForShortLog() {
        int encodedLevel = switch (getLogLevel()) {
            case TRACE -> 1;
            case DEBUG -> 2;
            case INFO -> 4;
            case WARNING -> 5;
            case ERROR -> 6;
            case FATAL -> 42;
            default -> 0;
        };
        String message = logLine.substring(logLine.indexOf("]:") + 2).trim();
        return encodedLevel + ":" + message;
    }
}
