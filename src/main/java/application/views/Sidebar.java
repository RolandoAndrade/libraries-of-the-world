package application.views;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Sidebar extends JPanel {
    public Sidebar(){
        this.setLayout(null);
        this.setBackground(new Color(3, 169, 244));
        this.setPreferredSize(new Dimension(Frame.FRAME_WIDTH/4, Frame.HEIGHT));
        this.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 3, new Color(230, 230, 230)));
        drawLogo();
        this.add(new SidebarButton("\uf02d", "Buscar libros"));
        this.add(new SidebarButton("\uf15c", "Ver logs"));
        this.add(new SidebarButton("\uf060", "Salir"));
    }

    private void drawLogo(){
        try{
            BufferedImage image = ImageIO.read(ClassLoader.getSystemResource("public/ucab.png"));
            JLabel imageLabel = new JLabel(new ImageIcon(image.getScaledInstance(100,100,Image.SCALE_FAST)));
            imageLabel.setBounds(37,37,100,100);
            this.add(imageLabel);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
