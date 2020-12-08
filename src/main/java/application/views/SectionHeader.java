package application.views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

public class SectionHeader extends JPanel {
    public SectionHeader(String icon, String sectionTitle){
        this.add(new FontAwesomeIcon(icon, 30, Color.GRAY).getIcon());
        JLabel title = new JLabel("   " + sectionTitle);
        Map<TextAttribute, Object> attributes = new HashMap<>();

        attributes.put(TextAttribute.FAMILY,  Font.SANS_SERIF);
        attributes.put(TextAttribute.WEIGHT, TextAttribute.WEIGHT_EXTRA_LIGHT);
        attributes.put(TextAttribute.SIZE, 18);
        attributes.put(TextAttribute.TRACKING, 0.3);

        title.setFont(new Font(attributes));
        title.setForeground(Color.GRAY);

        setBorder(new EmptyBorder(30, 0, 30, 0));
        this.add(title);
    }
}
