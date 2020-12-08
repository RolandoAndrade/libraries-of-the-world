package application.views.shared;

import java.util.ArrayList;
import java.util.List;

public class EventBus {
    public static String SECTION_CHANGED = "SECTION_CHANGED";
    private static List<Subscriber> subscribers = new ArrayList<>();

    public static void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public static void emit(String subject, Object message) {
        for (Subscriber s : subscribers) {
            s.listen(subject, message);
        }
    }
}
