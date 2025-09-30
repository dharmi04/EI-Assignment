package utils;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class LoggerUtil {
    private static final Logger LOGGER = Logger.getLogger("VirtualClassroomLogger");
    static {
        LOGGER.setUseParentHandlers(false);
        ConsoleHandler ch = new ConsoleHandler();
        ch.setFormatter(new SimpleFormatter());
        ch.setLevel(Level.INFO);
        LOGGER.addHandler(ch);
        LOGGER.setLevel(Level.INFO);
    }

    public static Logger getLogger() {
        return LOGGER;
    }
}
