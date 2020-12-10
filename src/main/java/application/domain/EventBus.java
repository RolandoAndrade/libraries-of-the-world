package application.domain;

import java.util.ArrayList;
import java.util.List;

public class EventBus {
    public static String SECTION_CHANGED = "SECTION_CHANGED";
    public static String START_SEARCH_BOOK = "Buscar Libro";
    public static String START_SEARCH_AUTHOR = "Buscar Autor";

    public static String GET_AUTHOR = "GET_AUTHOR";
    public static String GET_BOOK = "GET_BOOK";
    public static String BOOK_RECEIVED = "BOOK_RECEIVED";
    public static String BOOKS_RECEIVED = "BOOKS_RECEIVED";

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
