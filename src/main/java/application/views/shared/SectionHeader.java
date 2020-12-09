package application.views.shared;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

public class SectionHeader extends JPanel {
    public SectionHeader(String icon, String sectionTitle) {
        this.add(new FontAwesomeIcon(icon, 30, Color.GRAY).getIcon());
        JLabel title = new JLabel("   " + sectionTitle);

        Font font = GUITheme.DARK_THEME.getRegular();

        Map<TextAttribute, Object> attributes = new HashMap<>();

        attributes.put(TextAttribute.SIZE, 18);
        attributes.put(TextAttribute.TRACKING, 0.3);
        title.setFont(font.deriveFont(attributes));

        title.setForeground(Color.GRAY);

        setBorder(new EmptyBorder(30, 0, 30, 0));
        this.add(title);
    }
}
