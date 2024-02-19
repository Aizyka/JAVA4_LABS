package home.masterserver;
import java.util.logging.Logger;
public class Log {
    static Logger logger;
    static {
        logger = Logger.getLogger("MasterServerLogger");
    }
    private Log() {
        throw new IllegalStateException("Utility class");
    }

    public static void message(String message) {
        logger.info(message);
    }
}
