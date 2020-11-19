package shared.domain;

public interface LoggerService {
    void info(String log, String context, Object data);
    void log(String log, String context, Object data);
    void warn(String log,String context, Object data);
    void error(String log,String context, Object data);
}
