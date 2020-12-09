package application.domain;

public interface Subscriber {
    void listen(String subject, Object message);
}
