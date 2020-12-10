package application.views.shared;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


public class FontAwesomeIcon {
    JLabel icon;

    public FontAwesomeIcon(String utfIcon, int size) {
        try {            
            InputStream myStream = new BufferedInputStream(new FileInputStream("public/fontawesome-webfont.ttf"));
            Font ttfBase = Font.createFont(Font.TRUETYPE_FONT, myStream);
            Font font = ttfBase.deriveFont(Font.PLAIN, size);
            JLabel label = new JLabel(utfIcon);
            label.setForeground(Color.WHITE);
            label.setFont(font);
            label.setSize(new Dimension(size, size));
            icon = label;
        } catch (IOException | FontFormatException exp) {
            exp.printStackTrace();
        }
    }

    public FontAwesomeIcon(String utfIcon, int size, Color color) {
        try {
            InputStream myStream = new BufferedInputStream(new FileInputStream("public/fontawesome-webfont.ttf"));
            Font ttfBase = Font.createFont(Font.TRUETYPE_FONT, myStream);
            Font font = ttfBase.deriveFont(Font.PLAIN, size);
            JLabel label = new JLabel(utfIcon);
            label.setForeground(color);
            label.setFont(font);
            label.setSize(new Dimension(size, size));
            icon = label;
        } catch (IOException | FontFormatException exp) {
            exp.printStackTrace();
        }
    }

    public JLabel getIcon() {
        return icon;
    }
}
