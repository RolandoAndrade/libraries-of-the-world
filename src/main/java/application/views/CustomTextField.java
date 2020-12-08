package application.views;
import javax.swing.*;
import javax.swing.border.Border;

public class CustomTextField extends JPanel {
    public CustomTextField(){
        Border tfBorder = UIManager.getBorder("TextField.border");
        Border newBorder = BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(10, 10, 10, 10),
                tfBorder);
        this.setBorder(newBorder);
        this.add(new JTextField("Hola"));
    }
}
