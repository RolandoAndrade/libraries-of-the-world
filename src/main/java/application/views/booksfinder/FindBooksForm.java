package application.views.booksfinder;

import application.views.CustomButton;
import application.views.CustomTextField;
import mdlaf.MaterialLookAndFeel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class FindBooksForm extends JPanel {
    private JPanel card;
    private JPanel form;

    public FindBooksForm(){
        this.card = new JPanel(new BorderLayout());
        this.form = new JPanel(new GridBagLayout());
        this.form.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.WHITE));
        this.form.setBackground(Color.WHITE);
        this.card.setBackground(Color.WHITE);
        this.card.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(230, 230, 230)));
        this.card.setPreferredSize(new Dimension(450,100));
        this.setBorder(new EmptyBorder(0, 37,0 ,37));
        this.addComponentsToForm();


        this.card.add(form, BorderLayout.CENTER);
        this.add(card);
    }

    private void addComponentsToForm(){
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.gridheight = 1;
        this.form.add(new CustomTextField(), c);
        c.gridx = 2;
        c.gridwidth = 1;
        this.form.add(new JComboBox<>(), c);

        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        this.form.add(new JButton("Buscar libro"), c);
        c.gridx = 2;
        this.form.add(new JButton("Buscar autor"), c);
    }
}
