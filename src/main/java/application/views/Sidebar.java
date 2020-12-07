package application.views;

import javax.swing.*;
import java.awt.*;

public class Sidebar extends JPanel {
    public Sidebar(){
        this.setLayout(new GridBagLayout());
        this.setBackground(new Color(3, 169, 244));
        this.setPreferredSize(new Dimension(Frame.FRAME_WIDTH/4, Frame.HEIGHT));
        this.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 3, new Color(230, 230, 230)));
    }
}
