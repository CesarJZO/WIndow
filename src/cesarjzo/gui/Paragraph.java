package cesarjzo.gui;

import javax.swing.*;
import java.awt.*;

/**
 * A panel that contains a text field which shows a text with the Head-Body template. (WIP)
 *
 * @author CésarJZO
 */
public class Paragraph extends JPanel {
    private String head;
    private String body;
    private JTextArea textArea;

    /**
     * Constructor method that creates the text area
     *
     * @param head The title of the text
     * @param body The text body
     */
    public Paragraph(String head, String body) {
        super();
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(
                textArea,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
        );
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        textArea.setText(this.head + '\n' + this.body);
        add(scrollPane, BorderLayout.CENTER);
    }
}
