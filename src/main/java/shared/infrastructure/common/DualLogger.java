package shared.infrastructure.common;

import shared.domain.logging.LoggerService;

public class DualLogger implements LoggerService {
    private final ConsoleLogger consoleLogger;
    private final FileLogger fileLogger;

    public DualLogger(){
        consoleLogger = new ConsoleLogger();
        fileLogger = new FileLogger();
    }

    @Override
    public void info(String log, String context, Object data) {
        consoleLogger.info(log, context, data);
        fileLogger.info(log, context, data);
    }

    @Override
    public void log(String log, String context, Object data) {
        consoleLogger.log(log, context, data);
        fileLogger.log(log, context, data);
    }

    @Override
    public void warn(String log, String context, Object data) {
        consoleLogger.warn(log, context, data);
        fileLogger.warn(log, context, data);
    }

    @Override
    public void error(String log, String context, Object data) {
        consoleLogger.error(log, context, data);
        fileLogger.error(log, context, data);
    }
}
