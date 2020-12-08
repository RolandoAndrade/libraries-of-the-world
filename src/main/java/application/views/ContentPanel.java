package application.views;

import application.views.booksfinder.FindBooksView;

import javax.swing.*;
import java.awt.*;

public class ContentPanel extends JPanel {
    public ContentPanel(){
        this.setLayout(new CardLayout());
        this.setBackground(new Color(250,250,250));
        this.add(new FindBooksView());
    }
}
