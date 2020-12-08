package application.views.booksfinder;

import application.views.shared.GUITheme;
import mdlaf.animation.MaterialUIMovement;
import mdlaf.utils.MaterialColors;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class FormButton extends JButton {
    public FormButton(String title){
        this.setText(title.toUpperCase());
        this.setBackground (new Color(3, 169, 244));
        this.setForeground (Color.WHITE);
        this.setBorderPainted(false);
        this.setFocusPainted(false);
        Font font = GUITheme.DARK_THEME.getBold();
        this.setFont(font.deriveFont(12f));
        setBorder(new EmptyBorder(10,10,10,10));
        addMouseListener(MaterialUIMovement.getMovement(this, MaterialColors.LIGHT_BLUE_200));
    }
}
