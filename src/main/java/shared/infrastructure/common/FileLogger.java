package shared.infrastructure.common;

import shared.domain.logging.LoggerService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class FileLogger {
    public class ConsoleLogger implements LoggerService {
        private String buildLog(String context, String type, String log, String data) {
            TimeZone tz = TimeZone.getTimeZone("UTC");
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
            df.setTimeZone(tz);
            String nowAsISO = df.format(new Date());
            return nowAsISO + "  [" + type + "]  " + "  [" + context + "]  " + log + data;
        }

        @Override
        public void info(String log, String context, Object data) {

        }

        @Override
        public void log(String log, String context, Object data) {

        }

        @Override
        public void warn(String log, String context, Object data) {

        }

        @Override
        public void error(String log, String context, Object data) {

        }
    }
}
