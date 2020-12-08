package application.views;

import javax.swing.*;
import java.awt.*;

public class FindBooksView extends JPanel {
    public FindBooksView(){
        this.setLayout(new BorderLayout());
        this.add(new SectionHeader("\uf02d", "BUSCAR LIBROS"));
    }
}
