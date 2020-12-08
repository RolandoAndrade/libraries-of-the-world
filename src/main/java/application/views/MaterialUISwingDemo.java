package application.views;

import mdlaf.MaterialLookAndFeel;
import mdlaf.animation.MaterialUIMovement;
import mdlaf.utils.MaterialColors;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class MaterialUISwingDemo {

    public static void main (String[] args) {
        try {
            UIManager.setLookAndFeel (new MaterialLookAndFeel ());
        }
        catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace ();
        }

        // basic instantiation of JFrame with various components, including a
        // JMenuBar with some menus and items, as well as a button
        JFrame frame = new JFrame ("Material Design UI for Swing by atharva washimkar");
        frame.setMinimumSize (new Dimension (600, 400));

        // configuring the JMenuBar as well as its menus and items
        JMenuBar bar = new JMenuBar ();
        JMenu menu1 = new JMenu ("Option 1 (Animated)");
        JMenu menu2 = new JMenu ("Option 2 (Not animated)");

        JMenuItem item1 = new JMenuItem ("Item 1 (Animated)");
        JMenuItem item2 = new JMenuItem ("Item 2 (Not animated)");

        //Test RadioButtonMenuItem
        JRadioButtonMenuItem jRadioButtonMenuItem = new JRadioButtonMenuItem ();
        jRadioButtonMenuItem.setText ("prova RadioButtonMenuItem");
        menu1.add (jRadioButtonMenuItem);
        menu1.addSeparator ();

        //TestCheckBoxMenuItem
        JCheckBoxMenuItem checkBoxMenuItem = new JCheckBoxMenuItem ();
        checkBoxMenuItem.setText ("test");
        menu1.add (checkBoxMenuItem);
        menu1.addSeparator ();
        menu1.add (item1);
        menu2.add (item2);

        bar.add (menu1);
        bar.add (menu2);

        // configuring a simple JButton
        JButton button = new JButton ("PRESS ME");
        button.setBackground (MaterialColors.LIGHT_BLUE_400);
        button.setForeground (Color.WHITE);
        button.setMaximumSize (new Dimension (200, 200));

        JPanel content = new JPanel ();
        content.add (button);

        // add everything to the frame
        frame.add (bar, BorderLayout.PAGE_START);
        // frame.add (content, BorderLayout.CENTER);

        // start animating!
        // here, 'gray' is the color that the JComponent will transition to when the user hovers over it
        MaterialUIMovement.add (menu1, MaterialColors.GRAY_200);
        MaterialUIMovement.add (item1, MaterialColors.GRAY_200);

        // you can also pass in extra parameters indicating how many intermediate colors to display, as well as the "frame rate" of the animation
        // there will be 5 intermediate colors displayed in the transition from the original components color to the new one specified
        // the "frame rate" of the transition will be 1000 / 30, or 30 FPS
        // the animation will take 5 * 1000 / 30 = 166.666... milliseconds to complete
        MaterialUIMovement.add (button, MaterialColors.LIGHT_BLUE_500, 5, 1000 / 30);

        // other components
        content.add (new JCheckBox ("checkbox"));
        content.add (new JComboBox<String> (new String[]{"a", "b", "c"}));
        content.add (new JLabel ("label"));
        content.add (new JPasswordField ("password"));
        content.add (new JRadioButton ("radio button"));
        content.add (new JSlider (JSlider.HORIZONTAL, 0, 5, 2));
        content.add (new JSpinner (new SpinnerListModel (new String[]{"d", "e", "f"})));
        content.add (new JTable (new String[][]{{"a", "b", "c"}, {"d", "e", "f"}}, new String[]{"r", "e"}));
        content.add (new JTextField ("text field"));
        content.add (new JToggleButton ("toggle"));

        JToolBar tb = new JToolBar ("toolbar");
        JButton button1 = new JButton ("f");
        JButton button2 = new JButton ("e");
        button1.setBackground (MaterialColors.LIGHT_BLUE_400);
        button1.setForeground (Color.WHITE);
        button2.setBackground (MaterialColors.LIGHT_BLUE_400);
        button2.setForeground (Color.WHITE);
        button1.addMouseListener(MaterialUIMovement.getMovement(button1, MaterialColors.LIGHT_BLUE_200));
        button2.addMouseListener(MaterialUIMovement.getMovement(button2, MaterialColors.LIGHT_BLUE_200));

        button1.addActionListener (new AbstractAction () {
            @Override
            public void actionPerformed (ActionEvent e) {

                putValue (Action.NAME, "f");

                JDialog dialog = new JDialog ();
                JPanel jPanel = new JPanel ();
                jPanel.add (new JColorChooser ());
                dialog.setContentPane (jPanel);
                dialog.setLocationRelativeTo (null);
                dialog.pack ();
                dialog.setVisible (true);
            }
        });
        button1.setToolTipText("This is a tool tip");

        tb.add (button1);
        tb.addSeparator ();
        tb.add (button2);
        tb.setFloatable (true);
        content.add (tb);

        JTree tree = new JTree (new String[]{"a", "b"});
        tree.setEditable (true);

        content.add (tree);

        JScrollPane sp = new JScrollPane (content);
        sp.setHorizontalScrollBarPolicy (JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        sp.setVerticalScrollBarPolicy (JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JPanel pn = new JPanel ();
        JTabbedPane tp = new JTabbedPane ();
        tp.addTab ("bleh", sp);
        tp.addTab ("bleh2", pn);

        frame.add (tp, BorderLayout.CENTER);

        //test progressBar
        JProgressBar progressBar = new JProgressBar ();
        progressBar.setValue (6);
        progressBar.setMaximum (12);
        pn.add (progressBar);

        //test cange coloro maximum value progress bar
        progressBar = new JProgressBar ();
        progressBar.setMaximum (5);
        progressBar.setValue (5);
        pn.add (progressBar);

        JTextPane textPane = new JTextPane ();
        textPane.setText ("Hi I'm super sayan");
        JTextPane textPane1 = new JTextPane ();
        textPane1.setText ("Hi I'm super sayan");
        textPane1.setEnabled (false);
        pn.add (textPane);
        pn.add (textPane1);

        JEditorPane editorPane = new JEditorPane ();
        editorPane.setText ("This theme is fantastic");
        pn.add (editorPane);

        //Test effect mouse over

        //Setting defoult
        JButton testButtonHoverOne = new JButton("Fly over me One");
        testButtonHoverOne.setEnabled(false);
        pn.add(testButtonHoverOne);

        //ModSetting
        JButton testButtonHoverTwo = new JButton("Fly over me Two");
        testButtonHoverTwo.setBackground(MaterialColors.LIGHT_BLUE_500);
        testButtonHoverTwo.setForeground(MaterialColors.WHITE);
        testButtonHoverTwo.addMouseListener(MaterialUIMovement.getMovement(testButtonHoverTwo, MaterialColors.LIGHT_BLUE_200));
        pn.add(testButtonHoverTwo);

        JPanel panel3 = new JPanel();
        tp.addTab("Panel 3", panel3);

        JButton buttonInfo = new JButton("Test INFO");
        buttonInfo.setBackground(MaterialColors.LIGHT_BLUE_500);
        buttonInfo.addMouseListener(MaterialUIMovement.getMovement(buttonInfo, MaterialColors.LIGHT_BLUE_200));
        class InfoMessage extends AbstractAction{

            public InfoMessage() {
                putValue(Action.NAME, "Info option panel");
            }

            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane optionPane = new JOptionPane();
                optionPane.showMessageDialog(frame, "This is message info", "Message info", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        buttonInfo.setAction(new InfoMessage());

        panel3.add(buttonInfo);

        JButton buttonError = new JButton();
        buttonError.setBackground(MaterialColors.RED_800);
        buttonError.addMouseListener(MaterialUIMovement.getMovement(buttonError, MaterialColors.RED_400));
        class ErrorMassage extends AbstractAction{

            public ErrorMassage() {
                putValue(Action.NAME, "Error option panel");
            }

            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane optionPane = new JOptionPane();
                optionPane.showMessageDialog(frame, "This is message error", "Message error", JOptionPane.ERROR_MESSAGE);
            }
        }
        buttonError.setAction(new ErrorMassage());

        panel3.add(buttonError);

        JButton buttonQuestion = new JButton();
        buttonQuestion.setBackground(MaterialColors.BLUE_600);
        buttonQuestion.addMouseListener(MaterialUIMovement.getMovement(buttonQuestion, MaterialColors.BLUE_300));
        class QuesuionMessage extends AbstractAction{

            public QuesuionMessage() {
                putValue(Action.NAME, "Info question panel");
            }

            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane optionPane = new JOptionPane();
                optionPane.showMessageDialog(frame, "This is message question", "Message question", JOptionPane.QUESTION_MESSAGE);
            }
        }

        buttonQuestion.setAction(new QuesuionMessage());

        JButton buttonWarning = new JButton();
        buttonWarning.setOpaque(false);
        buttonWarning.setBackground(MaterialColors.YELLOW_800);
        buttonWarning.addMouseListener(MaterialUIMovement.getMovement(buttonWarning, MaterialColors.YELLOW_500));
        class WarningMessage extends AbstractAction {

            public WarningMessage() {
                putValue(Action.NAME, "Info warning panel");
            }

            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane optionPane = new JOptionPane();
                optionPane.showMessageDialog(frame, "This is message warning", "Message warning", JOptionPane.WARNING_MESSAGE);
            }

        }

        buttonWarning.setAction(new WarningMessage());

        panel3.add(buttonQuestion);
        panel3.add(buttonWarning);

        JSpinner spinnerDate = new JSpinner(new SpinnerDateModel());

        JSpinner spinnerNumbar = new JSpinner(new SpinnerNumberModel());

        ArrayList<Object> objectList = new ArrayList<>();
        objectList.add(new Object());
        objectList.add(new Object());
        objectList.add(new Object());
        JSpinner spinnerList = new JSpinner(new SpinnerListModel(objectList));

        panel3.add(spinnerDate);
        panel3.add(spinnerNumbar);
        panel3.add(spinnerList);

        // make everything visible to the world
        frame.pack ();
        frame.setVisible (true);

        JFileChooser fileChooser = new JFileChooser ();
        fileChooser.showOpenDialog (frame);
    }
}
