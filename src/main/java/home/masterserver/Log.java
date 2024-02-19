package home.masterserver;
import java.util.logging.Logger;
public class Log {
    static Logger logger;
    static {
        logger = Logger.getLogger("MasterServerLogger");
    }

    public static void Message(String message) {
        logger.info(message);
    }
}
