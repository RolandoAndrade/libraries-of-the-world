package application.views.logs;

import application.domain.EventBus;
import application.domain.Subscriber;
import application.views.shared.GUITheme;
import application.views.shared.SectionHeader;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class LogsView extends JPanel implements Subscriber {

    JTextArea textArea;
    public LogsView() {
        this.setLayout(new BorderLayout());
        this.setBackground(null);
        this.add(new SectionHeader("\uf15c", "VISUALIZAR LOGS"), BorderLayout.NORTH);
        textArea = new JTextArea();
        textArea.setFont(GUITheme.DARK_THEME.getRegular());
        textArea.setBackground(Color.white);
        textArea.setEditable(false);
        this.add(new JScrollPane(textArea), BorderLayout.CENTER);
        EventBus.subscribe(this);
    }


    @Override
    public void listen(String subject, Object message) {
        try{
            if(subject.equals(EventBus.SECTION_CHANGED)&&message.equals("Ver logs")){
                BufferedReader reader = new BufferedReader(new FileReader("log.txt"));
                StringBuilder stringBuilder = new StringBuilder();
                String line = null;
                String ls = System.getProperty("line.separator");
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line);
                    stringBuilder.append(ls);
                }
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                reader.close();

                String content = stringBuilder.toString();
                textArea.setText(content);
                this.updateUI();
            }
        }catch (Exception e){

        }

    }
}
