package application.views.booksfinder;

import application.views.GUITheme;
import shared.domain.components.Book;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

public class FindBooksResults extends JPanel {
    private JPanel card;
    private JPanel resultsPanel;

    public FindBooksResults(){
        setLayout(new BorderLayout());
        JLabel label = new JLabel("RESULTADOS");
        Font font = GUITheme.LIGHT_THEME.getRegular();
        Map<TextAttribute, Object> attributes = new HashMap<>();
        attributes.put(TextAttribute.SIZE, 12);
        attributes.put(TextAttribute.TRACKING, 0.3);
        label.setFont(font.deriveFont(attributes));
        label.setForeground(Color.GRAY);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBorder(new EmptyBorder(10,10,20,10));
        this.add(label, BorderLayout.NORTH);
        fillResults();

        this.add(BorderLayout.CENTER, new JScrollPane(card));
        setPreferredSize(new Dimension(450, 175));
    }

    private void setUpCard(){

    }

    private void fillResults(){
        this.card = new JPanel(new GridLayout(4,1));
        this.card.add(new BookCard(new Book("Hola"), 1));
        this.card.add(new BookCard(new Book("Hola"), 2));
        this.card.add(new BookCard(new Book("Hola"), 3));
        this.card.add(new BookCard(new Book("Hola"), 4));
    }
}
