package application.views.sidebar;

import application.views.shared.FontAwesomeIcon;
import application.views.Frame;
import application.views.shared.GUITheme;
import mdlaf.animation.MaterialUIMovement;
import mdlaf.utils.MaterialColors;

import javax.swing.*;
import java.awt.*;

public class SidebarButton extends JButton {
    private static int index = 0;
    public SidebarButton(String icon, String title){
        this.add(new FontAwesomeIcon(icon, 20).getIcon());
        this.setText("   " + title);
        this.setBackground (new Color(3, 169, 244));
        this.setForeground (Color.WHITE);
        this.setBorderPainted(false);
        this.setFocusPainted(false);
        Font font =GUITheme.DARK_THEME.getRegular();
        this.setFont(font.deriveFont(12f));
        this.setBounds(0,200 + 50*(index++), Frame.FRAME_WIDTH/4 - 3,50);

        addMouseListener(MaterialUIMovement.getMovement(this, MaterialColors.LIGHT_BLUE_200));
    }
}
