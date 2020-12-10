package application.views.shared;

import javax.swing.*;
import java.awt.*;


public class FontAwesomeIcon {
    JLabel icon;

    public FontAwesomeIcon(String utfIcon, int size) {
        Font ttfBase = Utilities.getFont("fontawesome-webfont.ttf");
        Font font = ttfBase.deriveFont(Font.PLAIN, size);
        JLabel label = new JLabel(utfIcon);
        label.setForeground(Color.WHITE);
        label.setFont(font);
        label.setSize(new Dimension(size, size));
        icon = label;
    }

    public FontAwesomeIcon(String utfIcon, int size, Color color) {
        Font ttfBase = Utilities.getFont("fontawesome-webfont.ttf");
        Font font = ttfBase.deriveFont(Font.PLAIN, size);
        JLabel label = new JLabel(utfIcon);
        label.setForeground(color);
        label.setFont(font);
        label.setSize(new Dimension(size, size));
        icon = label;
    }

    public JLabel getIcon() {
        return icon;
    }
}
