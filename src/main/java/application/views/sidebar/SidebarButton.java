package application.views.sidebar;

import application.views.FontAwesomeIcon;
import application.views.Frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;

public class SidebarButton extends JButton {
    private static int index = 0;
    public SidebarButton(String icon, String title){
        this.add(new FontAwesomeIcon(icon, 20).getIcon());
        this.setText("   " + title);
        this.setBorderPainted(false);
        this.setFocusPainted(false);
        this.setBackground(new Color(3, 169, 244));
        this.setForeground(Color.WHITE);
        this.setFont(new Font("SansSerif.plain", Font.PLAIN, 14));

        this.setBounds(0,200 + 50*(index++), Frame.FRAME_WIDTH/4 - 3,50);

        this.addMouseListener(new MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                setBackground(new Color(0, 179, 255));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                setBackground(new Color(3, 169, 244));
            }
        });
    }
}
