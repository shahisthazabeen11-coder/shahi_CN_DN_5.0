public class Main {

    // Main method to demonstrate the usage of the Logger singleton
    public static void main(String[] args) {
        // Get the singleton instance of Logger
    Logger logger_one = Logger.getInstance();
    Logger logger_two = Logger.getInstance();

    // Log messages using the singleton instance
    logger_one.log("This is the first log message.");
    logger_two.log("This is the second log message.");

    // Check if both logger instances are the same
    if (logger_one == logger_two) {
        System.out.println("Both logger instances are the same (singleton works).");
    } else {
        System.out.println("Logger instances are different (singleton failed).");
    }


}
}
