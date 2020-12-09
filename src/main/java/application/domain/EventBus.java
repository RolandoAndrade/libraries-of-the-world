package application.domain;

import java.util.ArrayList;
import java.util.List;

public class EventBus {
    public static String SECTION_CHANGED = "SECTION_CHANGED";
    public static String START_SEARCH_BOOK = "Buscar Libro";
    public static String START_SEARCH_AUTHOR = "Buscar Autor";

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
