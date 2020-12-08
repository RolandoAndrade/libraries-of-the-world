package application.views.logs;

import application.views.shared.GUITheme;
import application.views.shared.SectionHeader;

import javax.swing.*;
import java.awt.*;

public class LogsView extends JPanel {
    public LogsView() {
        this.setLayout(new BorderLayout());
        this.setBackground(null);
        this.add(new SectionHeader("\uf15c", "VISUALIZAR LOGS"), BorderLayout.NORTH);
        JTextArea textArea = new JTextArea();
        textArea.setFont(GUITheme.DARK_THEME.getRegular());
        textArea.setBackground(Color.white);
        textArea.setEditable(false);
        this.add(textArea, BorderLayout.CENTER);
    }
}
