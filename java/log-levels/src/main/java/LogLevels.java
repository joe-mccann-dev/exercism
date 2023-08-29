public class LogLevels {    
    public static String message(String logLine) {
        String[] logLineArray = logLine.split(":");
        String message = logLineArray[1].trim();

        return message;
    }

    public static String logLevel(String logLine) {
        String result = "";
        String[] splitString = logLine.split(":");
        String logLevel = splitString[0];
        result = logLevel.substring(1, logLevel.length() - 1).toLowerCase();
    
        return result;
    }

    public static String reformat(String logLine) {
        String message = message(logLine);
        String logLevel = logLevel(logLine).toLowerCase();
        String result = String.format("%s (%s)", message, logLevel);

        return result;
    }
}
