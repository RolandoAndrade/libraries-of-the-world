package application.views.booksfinder;

import application.domain.EventBus;
import application.domain.SearchRequest;
import application.domain.Subscriber;
import application.views.shared.Utilities;
import shared.domain.components.Library;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

public class FindBooksForm extends JPanel implements Subscriber {
    private JPanel card;
    private JPanel form;
    private JComboBox<LibraryComboItem> libraryJComboBox;
    private JTextField search;

    public FindBooksForm() {
        this.card = new JPanel(new BorderLayout());
        this.form = new JPanel(new GridBagLayout());
        this.form.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.WHITE));
        this.form.setBackground(Color.WHITE);
        this.card.setBackground(Color.WHITE);
        this.card.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(230, 230, 230)));
        this.card.setPreferredSize(new Dimension(450, 150));
        this.setBorder(new EmptyBorder(0, 37, 0, 37));
        this.addComponentsToForm();


        this.card.add(form, BorderLayout.CENTER);
        this.add(card);

        EventBus.subscribe(this);
    }

    private void addComponentsToForm() {
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 1;
        c.weighty = 1;
        c.insets = new Insets(5, 5, 5, 5);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.gridheight = 1;
        search = new FormTextField();
        this.form.add(search, c);

        c.gridx = 2;
        c.gridwidth = 2;
        libraryJComboBox = new JComboBox();
        List<Library> libraries = Utilities.getConfiguration().getLibraries();
        for (Library l: libraries){
            libraryJComboBox.addItem(new LibraryComboItem(l));
        }

        this.form.add(libraryJComboBox, c);

        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 2;
        this.form.add(new FormButton(EventBus.START_SEARCH_BOOK), c);
        c.gridx = 2;
        this.form.add(new FormButton(EventBus.START_SEARCH_AUTHOR), c);
    }

    private Library getSelectedLibrary(){
        LibraryComboItem item =((LibraryComboItem)libraryJComboBox.getSelectedItem());
        Library l;
        if(item == null){
            l = Utilities.getConfiguration().getCurrentLibrary();
        }
        else {
            l = item.getValue();
        }
        return l;
    }

    @Override
    public void listen(String subject, Object message) {
        if(subject.equals(EventBus.START_SEARCH_BOOK)){
            EventBus.emit(EventBus.GET_BOOK, new SearchRequest(search.getText(), getSelectedLibrary()));
        }else if (subject.equals(EventBus.START_SEARCH_AUTHOR)){
            EventBus.emit(EventBus.GET_AUTHOR, new SearchRequest(search.getText(), getSelectedLibrary()));
        }
    }
}
