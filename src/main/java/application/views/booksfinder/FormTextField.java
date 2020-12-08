package application.views.booksfinder;


import application.views.GUITheme;
import mdlaf.utils.MaterialColors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class FormTextField extends JTextField {
    public FormTextField(){
        this.setBackground (Color.WHITE);
        setForeground(MaterialColors.GRAY_300);
        Font font = GUITheme.DARK_THEME.getBold();
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 2, 0,
                        MaterialColors.GRAY_300),
                BorderFactory.createLineBorder(Color.WHITE, 10)));
        this.setFont(font.deriveFont(12f));

        setSelectionColor(Color.RED);
        setColumns(10);

        setText("Libro o el autor");
        this.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (getText().equals("Libro o el autor")) {
                    setText("");
                    setForeground(Color.GRAY);
                    setBorder(BorderFactory.createCompoundBorder(
                            BorderFactory.createMatteBorder(0, 0, 3, 0,
                                    MaterialColors.LIGHT_BLUE_400),
                            BorderFactory.createLineBorder(Color.WHITE, 10)));
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (getText().isEmpty()) {
                    setForeground(MaterialColors.GRAY_300);
                    setText("Libro o el autor");
                    setBorder(BorderFactory.createCompoundBorder(
                            BorderFactory.createMatteBorder(0, 0, 3, 0,
                                    MaterialColors.GRAY_300),
                            BorderFactory.createLineBorder(Color.WHITE, 10)));
                }
            }
        });
    }
}
