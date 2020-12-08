package application.views.booksfinder;

import application.views.FontAwesomeIcon;
import application.views.GUITheme;
import mdlaf.animation.MaterialUIMovement;
import mdlaf.utils.MaterialColors;
import shared.domain.components.Book;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

public class BookCard extends JPanel {
    JPanel card;
    JPanel iconPanel;
    JPanel namePanel;
    JPanel authorPanel;
    Color[] colors = {MaterialColors.GREEN_400, MaterialColors.AMBER_400, MaterialColors.PURPLE_400, MaterialColors.ORANGE_400};

    public BookCard(Book book, int index){
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(450,70));
        this.setBorder(new EmptyBorder(10,32,10,32));
        this.card = new JPanel(new GridBagLayout());
        this.card.setBorder(BorderFactory.createLineBorder( new Color(230, 230, 230),1, true));
        this.setIconPanel(index);
        this.setBookPanel(book.getTitle());
        this.setAuthorPanel(book.getTitle());
        this.add(card, BorderLayout.CENTER);

        addMouseListener(MaterialUIMovement.getMovement(card, MaterialColors.GRAY_100));
    }

    private void setIconPanel(int index){
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        this.iconPanel = new JPanel(new BorderLayout());
        this.iconPanel.setBackground(colors[index%colors.length]);
        this.iconPanel.setSize(50,50);
        JLabel icon = new FontAwesomeIcon("\uf02d", 30).getIcon();
        icon.setHorizontalAlignment(SwingConstants.CENTER);
        this.iconPanel.setBorder(new EmptyBorder(10,10,10,10));
        this.iconPanel.add(icon, BorderLayout.CENTER);
        card.add(iconPanel, c);
    }

    private void setBookPanel(String bookName){
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 0;
        this.namePanel = new JPanel(new BorderLayout());

        this.namePanel.add(getLabel("Libro"), BorderLayout.NORTH);
        this.namePanel.add(getField(bookName), BorderLayout.CENTER);
        this.namePanel.setBackground(null);
        card.add(namePanel, c);
    }

    private void setAuthorPanel(String authorName){
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 0;
        this.authorPanel = new JPanel(new BorderLayout());
        this.authorPanel.add(getLabel("Autor"), BorderLayout.NORTH);
        this.authorPanel.add(getField(authorName), BorderLayout.CENTER);
        this.authorPanel.setBackground(null);
        card.add(authorPanel, c);
    }

    private JLabel getLabel(String title){
        JLabel label = new JLabel(title.toUpperCase());
        Font font = GUITheme.LIGHT_THEME.getThin();
        Map<TextAttribute, Object> attributes = new HashMap<>();
        attributes.put(TextAttribute.SIZE, 9);
        attributes.put(TextAttribute.TRACKING, 0.2);
        label.setFont(font.deriveFont(attributes));
        label.setBorder(new EmptyBorder(5,5,5,5));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setForeground(Color.GRAY);
        return label;
    }

    private JLabel getField(String field){
        JLabel label = new JLabel(field);
        Font font = GUITheme.LIGHT_THEME.getRegular();
        label.setFont(font.deriveFont(10f));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBorder(new EmptyBorder(10,10,10,10));
        label.setForeground(Color.GRAY);
        return label;
    }
}
