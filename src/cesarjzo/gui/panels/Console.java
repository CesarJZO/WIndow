package cesarjzo.gui.panels;
import cesarjzo.gui.Style;

import javax.swing.*;
import java.awt.*;

/**
 * Creates a terminal-like panel. Contains a text area with a scroll bar for the output and a text
 * field for the input.
 * @author CésarJZO
 */
public class Console extends JPanel {
    private int rows = 15;
    private int columns = 30;
    private final JTextArea txtArea;
    private final JScrollPane scrollPane;
    private final JTextField txtFld;
    private final JPanel inputPanel;
    private final JButton button;
    private String text;

    /**
     * Creates a terminal-like panel with a text area (uneditable) and a text field with a button.
     * @param btnLabel Text to be displayed on the button
     */
    public Console(String btnLabel) {
        txtArea = new JTextArea(rows, columns);
        txtArea.setLineWrap(true);
        txtArea.setEditable(false);
        scrollPane = new JScrollPane(
                txtArea,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        txtArea.setFont(new Font("Consolas", Font.PLAIN, 18));
        text = "";

        txtFld = new JTextField(columns);
        button = new JButton(btnLabel);
        inputPanel = new JPanel();
        inputPanel.add(txtFld);
        inputPanel.add(button);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(scrollPane);
        add(inputPanel);
    }

    public JButton getButton() {
        return button;
    }

    public String getInput() {
        return txtFld.getText();
    }

    /**
     * Sets the text of the text area, maintains the text fields without changes.
     * @param txt Text to replace the text area
     */
    public void setText(String txt) {
        text = txt;
        txtArea.setText(txt);
    }

    public JTextField getTextField() {
        return txtFld;
    }

    /**
     * Appends text in the text field to the text area.
     */
    public void writeInput() {
        if (!getInput().equals("")) {
            text = text.equals("") ? text + getInput() : text + '\n' + getInput();
            txtArea.setText(text);
            txtFld.setText("");
        }
    }

    public void setStyle(Style style) {
        setBackground(style.backgroundColor);

        txtArea.setBackground(style.textBGColor);
        txtArea.setForeground(style.foreground);
        txtArea.setBorder(null);
        scrollPane.setBorder(null);

        inputPanel.setBackground(style.backgroundColor);
        txtFld.setBackground(style.textBGColor);
        txtFld.setForeground(style.foreground);
        txtFld.setFont(style.font);
        txtFld.setBorder(null);

        button.setBackground(style.buttonColor);
        button.setForeground(style.foreground);
        button.setFont(style.font);
    }
}
