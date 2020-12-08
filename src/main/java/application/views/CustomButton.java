package application.views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;

public class CustomButton extends JButton {
    public CustomButton(String title){
        this.setText(title);
        this.setFocusPainted(false);
        this.setBackground(new Color(3, 169, 244));
        this.setForeground(Color.WHITE);
        this.setBorder(new EmptyBorder(10,10,10,10));
        this.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.WHITE, 5),
                BorderFactory.createLineBorder(new Color(3, 169, 244), 10)));
        this.setFont(new Font("SansSerif.plain", Font.PLAIN, 12));

        this.addMouseListener(new MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(Color.WHITE, 5),
                        BorderFactory.createLineBorder(new Color(0, 179, 255), 10)));
                setBackground(new Color(0, 179, 255));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                setBackground(new Color(3, 169, 244));
                setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(Color.WHITE, 5),
                        BorderFactory.createLineBorder(new Color(3, 169, 244), 10)));
            }
        });
    }
}
