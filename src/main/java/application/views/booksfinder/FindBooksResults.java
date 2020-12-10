package application.views.booksfinder;

import application.domain.EventBus;
import application.domain.Subscriber;
import application.views.shared.GUITheme;
import shared.domain.components.Book;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;


public class FindBooksResults extends JPanel implements Subscriber {
    private JPanel card;
    JScrollPane scrollPane;
    private List<Book> bookList = new ArrayList<Book>();

    public FindBooksResults() {
        setLayout(new BorderLayout());
        JLabel label = new JLabel("RESULTADOS");
        Font font = GUITheme.LIGHT_THEME.getRegular();
        Map<TextAttribute, Object> attributes = new HashMap<>();
        attributes.put(TextAttribute.SIZE, 12);
        attributes.put(TextAttribute.TRACKING, 0.3);
        label.setFont(font.deriveFont(attributes));
        label.setForeground(Color.GRAY);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBorder(new EmptyBorder(10, 10, 20, 10));
        this.add(label, BorderLayout.NORTH);
        fillResults();


        setPreferredSize(new Dimension(450, 175));

        EventBus.subscribe(this);
    }

    private void fillResults() {
        this.card = new JPanel(new GridLayout(Math.max(2,bookList.size()), 1));
        if(bookList.size()>0){
            for (int i = 0; i < bookList.size() && i < 4; i++){
                this.card.add(new BookCard(bookList.get(i), i));
            }
        }else {
            JLabel label = new JLabel("No hay resultados que mostrar");
            label.setFont(GUITheme.DARK_THEME.getThin().deriveFont(10f));
            label.setHorizontalAlignment(SwingConstants.CENTER);
            this.card.add(label);
        }
        this.scrollPane = new JScrollPane(card);
        this.add(BorderLayout.CENTER, scrollPane);
        this.updateUI();
    }

    @Override
    public void listen(String subject, Object message) {
        if(subject.equals(EventBus.BOOK_RECEIVED)){
            this.remove(scrollPane);
            bookList = new ArrayList<>();
            if(message != null){
                bookList.add((Book) message);
            }
            fillResults();
        }
        else if(subject.equals(EventBus.BOOKS_RECEIVED)){
            this.remove(scrollPane);
            bookList = (List<Book>) message;
            fillResults();
        }
    }
}
