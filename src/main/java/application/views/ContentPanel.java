package application.views;

import application.views.booksfinder.FindBooksView;
import application.views.logs.LogsView;
import application.views.shared.EventBus;
import application.views.shared.Subscriber;

import javax.swing.*;
import java.awt.*;

public class ContentPanel extends JPanel implements Subscriber {
    private CardLayout layout;

    public ContentPanel() {
        this.layout = new CardLayout();
        this.setLayout(layout);
        this.setBackground(new Color(250, 250, 250));
        this.add("Buscar libros", new FindBooksView());
        this.add("Ver logs", new LogsView());
        EventBus.subscribe(this);
    }

    @Override
    public void listen(String subject, Object message) {
        if (subject.equals(EventBus.SECTION_CHANGED)) {
            String s = message.toString();
            this.layout.show(this, s);
        }
    }
}
