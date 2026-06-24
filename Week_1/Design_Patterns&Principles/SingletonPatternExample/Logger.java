

// Logger class for logging messages
public class Logger {
    //The Private instance initiated to null and to accessed only within the class
    private static Logger instance;

    //Private constructor to prevent instantiation from outside the class and making it null 
    private Logger() {
        // Private constructor to prevent instantiation
    }

    // Public method to get the singleton instance of Logger
    // This method checks if the instance is null, and if so, creates a new instance of Logger. Otherwise, it returns the existing instance.
    public static Logger getInstance(){
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Method to log messages
    // This method takes a message as input and prints it to the console with a "Log: " prefix.
    public void log(String message) {
        System.out.println("Log: " + message);
    }
}
