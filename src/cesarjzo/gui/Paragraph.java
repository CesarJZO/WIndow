package cesarjzo.gui;

import javax.swing.*;
import java.awt.*;

/**
 * A panel that contains a text field which shows a text with the Head-Body template. (WIP)
 *
 * @author CésarJZO
 */
public class Paragraph extends JPanel {
    private final String head;
    private final String body;
    private final JLabel textArea;

    /**
     * Constructor method that creates the text area
     *
     * @param head The title of the text
     * @param body The text body
     */
    public Paragraph(String head, String body) {
        this.head = head;
        this.body = body;
        textArea = new JLabel();
        JScrollPane scrollPane = new JScrollPane(
                textArea,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
        );

        textArea.setText(
                "<html>\n" +
                        "\t<body>\n" +
                        "\t<h1>" + head + "</h1>\n" +
                        "\t<p>" + body + "</p>\n" +
                        "\t</body>\n" +
                        "</html>"

        );
        add(scrollPane, BorderLayout.CENTER);
    }

    public String getHead() {
        return head;
    }

    public String getBody() {
        return body;
    }
}
