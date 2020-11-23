package shared.infrastructure.common;

import shared.domain.logging.LoggerService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConsoleLogger implements LoggerService {
    private String buildLog(String context, String type, String log, String data) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
        String nowAsISO = df.format(new Date());
        return nowAsISO + "  [" + type + "]" + "  [" + context + "]  " + log + data;
    }

    @Override
    public void info(String log, String context, Object data) {
        System.out.println(this.buildLog(context, "INFO", log, data.toString()));
    }

    @Override
    public void log(String log, String context, Object data) {
        System.out.println(this.buildLog(context, "LOG", log, data.toString()));
    }

    @Override
    public void warn(String log, String context, Object data) {
        System.out.println(this.buildLog(context, "WARN", log, data.toString()));
    }

    @Override
    public void error(String log, String context, Object data) {
        System.err.println(this.buildLog(context, "ERROR", log, data.toString()));
    }
}