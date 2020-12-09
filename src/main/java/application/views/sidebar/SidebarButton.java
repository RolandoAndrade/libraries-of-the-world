package application.views.sidebar;

import application.views.Frame;
import application.domain.EventBus;
import application.views.shared.FontAwesomeIcon;
import application.views.shared.GUITheme;
import mdlaf.animation.MaterialUIMovement;
import mdlaf.utils.MaterialColors;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;

public class SidebarButton extends JButton {
    private static int index = 0;

    public SidebarButton(String icon, String title) {
        this.add(new FontAwesomeIcon(icon, 20).getIcon());
        this.setText("   " + title);
        this.setBackground(new Color(3, 169, 244));
        this.setForeground(Color.WHITE);
        this.setBorderPainted(false);
        this.setFocusPainted(false);
        Font font = GUITheme.DARK_THEME.getRegular();
        this.setFont(font.deriveFont(12f));
        this.setBounds(0, 200 + 50 * (index++), Frame.FRAME_WIDTH / 4 - 3, 50);

        addMouseListener(MaterialUIMovement.getMovement(this, MaterialColors.LIGHT_BLUE_200));
        addMouseListener(new MouseInputListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                if (title.equals("Salir")) {
                    System.exit(0);
                } else {
                    EventBus.emit(EventBus.SECTION_CHANGED, title);
                }
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseDragged(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseMoved(MouseEvent mouseEvent) {

            }
        });
    }
}
