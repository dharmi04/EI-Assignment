public class Main {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("Application started.");
        logger2.log("Another log entry.");

        System.out.println("Same instance? " + (logger1 == logger2));
    }
}