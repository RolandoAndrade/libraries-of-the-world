package shared.infrastructure.common;

import shared.domain.logging.LoggerService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConsoleLogger implements LoggerService {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_WHITE = "\u001B[37m";


    private String buildLog(String context, String type, String log, String data) {   
        FileLogger filelogger = new FileLogger();
        filelogger.log(log+data);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
        String nowAsISO = df.format(new Date());
        return nowAsISO + "  [" + type + "]" + "  [" + context + "]  " + log + data;
    }

    @Override
    public void info(String log, String context, Object data) {
        System.out.println(ANSI_CYAN + this.buildLog(context, "INFO", log, data.toString()) + ANSI_RESET);
    }

    @Override
    public void log(String log, String context, Object data) {
        System.out.println(ANSI_GREEN + this.buildLog(context, "LOG", log, data.toString()) + ANSI_RESET);
    }

    @Override
    public void warn(String log, String context, Object data) {
        System.out.println(ANSI_YELLOW + this.buildLog(context, "WARN", log, data.toString()) + ANSI_RESET);
    }

    @Override
    public void error(String log, String context, Object data) {
        System.err.println(this.buildLog(context, "ERROR", log, data.toString()));
    }
}