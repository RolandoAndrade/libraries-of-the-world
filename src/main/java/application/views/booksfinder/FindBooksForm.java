package application.views.booksfinder;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.lang.reflect.Field;

public class FindBooksForm extends JPanel {
    private JPanel card;

    public FindBooksForm(){
        this.card = new JPanel(new GridBagLayout());
        this.card.setBackground(Color.WHITE);
        this.card.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(230, 230, 230)));
        this.card.setPreferredSize(new Dimension(500,100));
        this.setBorder(new EmptyBorder(0, 12,0 ,12));
        this.addComponentsToCard();
        this.add(card);
    }

    private void addComponentsToCard(){
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.gridheight = 1;
        this.card.add(new TextField(), c);
        c.gridx = 2;
        c.gridwidth = 1;
        this.card.add(new JComboBox<>(), c);

        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        this.card.add(new JButton("Buscar libro"), c);
        c.gridx = 1;
        this.card.add(new JButton("Buscar autor"), c);
        c.gridx = 2;
        c.gridy = 1;
        this.card.add(new JButton("Agregar librería"), c);
    }
}
