public class LogLevels {
    
    public static String message(String logLine) {
        String[] parts = logLine.split(":");
        return parts[1].trim();
    }

    public static String logLevel(String logLine) {
        String[] parts = logLine.split(":");
        return parts[0].substring(1, parts[0].length()-1).toLowerCase();
    }

    public static String reformat(String logLine) {
        return String.format("%s (%s)", message(logLine), logLevel(logLine));
    }
}
