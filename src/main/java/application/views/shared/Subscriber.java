package application.views.shared;

public interface Subscriber {
    void listen(String subject, Object message);
}
