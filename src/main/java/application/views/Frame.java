package application.views;

import application.views.sidebar.Sidebar;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Frame extends JFrame {
    public static final int FRAME_HEIGHT = 500;

    public static final int FRAME_WIDTH = 700;

    private static final URL ICON_PATH=ClassLoader.getSystemResource("public/book-icon.png");

    private JPanel mainPanel;

    public Frame(String libraryName){
        createFrame(libraryName);
        this.setVisible(true);
    }

    private void createFrame(String libraryName)
    {
        this.setTitle(libraryName);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit= Toolkit.getDefaultToolkit();
        Image icon=toolkit.getImage(ICON_PATH);
        this.setIconImage(icon);
        this.setResizable(false);
        this.mainPanel = new JPanel(new BorderLayout());
        this.mainPanel.add(new Sidebar(), BorderLayout.LINE_START);
        this.mainPanel.add(new ContentPanel(), BorderLayout.CENTER);
        this.add(mainPanel);
        this.setSize(FRAME_WIDTH,FRAME_HEIGHT);
        this.setLocationRelativeTo(null);
    }
}
